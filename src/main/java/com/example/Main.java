package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;

public class Main {

    private static final String DEFAULT_HOST = "des418";
    private static final String DEFAULT_PORT = "9999";
    private static final String URI = "/ws/test";

    public static void main(String[] args) throws Exception {
        String host = DEFAULT_HOST, port = DEFAULT_PORT, protocol = "http";
        if (args != null && args.length > 0) {
            int i=0;
            if (args[i].equals("-s")) {
                protocol = "https";
                i++;
            }
            if (args.length > i) {
                host = args[i++];
                if (args.length > i) {
                    port = args[i];
                }
            }
        }
        System.out.println("Iniciando servico...");
        String url = protocol + "://" + host + ":" + port + URI;

        Endpoint endpoint = Endpoint.create(new TestServiceImpl());
        if (protocol.equals("http")) {
            endpoint.publish(url);
        } else {
            String keyPass = "111111";
            String keystoreFile = "keystore.jks";
            SSLContext ssl = SSLContext.getInstance("TLS");
            KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            KeyStore store = KeyStore.getInstance("JKS");
            store.load(Main.class.getClassLoader().getResourceAsStream(keystoreFile), keyPass.toCharArray());
            keyFactory.init(store, keyPass.toCharArray());
            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(store);
            ssl.init(keyFactory.getKeyManagers(), trustFactory.getTrustManagers(), new SecureRandom());

            HttpsConfigurator configurator = new HttpsConfigurator(ssl);
            HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress(host, Integer.parseInt(port)), 20);
            httpsServer.setHttpsConfigurator(configurator);
            HttpContext httpContext = httpsServer.createContext(URI);
            httpsServer.start();

            endpoint.publish(httpContext);
        }

        System.out.println("Servico iniciado! WSDL disponivel => " + url + "?wsdl");
        System.out.print("Pressione qualquer tecla para fechar...");
        System.in.read();
        System.exit(0);
    }

    private static Source getXSDFromResource() throws IOException {
        URL resource = Main.class.getResource("/schema.xsd");
        String systemId = resource.toExternalForm();
        InputStream inputStream = resource.openStream();
        return new StreamSource(inputStream, systemId);
    }

}

package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;

public class Main {

    private static final String DEFAULT_HOST = "des418";
    private static final String DEFAULT_PORT = "9999";
    private static final String URL = "http://%s:%s/ws/test";

    public static void main(String[] args) throws Exception {
        String host = DEFAULT_HOST, port = DEFAULT_PORT;
        if (args != null && args.length > 0) {
            host = args[0];
            if (args.length > 1) {
                port = args[1];
            }
        }
        System.out.println("Iniciando servico...");
        String url = String.format(URL, host, port);

//        Endpoint endpoint = Endpoint.create(new TestServiceImpl());
//        endpoint.setMetadata(Arrays.asList(getXSDFromResource()));
//        endpoint.publish(url);
        
        Endpoint.publish(url, new TestServiceImpl());

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

# Simple SOAP Service
Webservice SOAP simples, que pode ser usado para testar integrações com este tipo de arquitetura WS

Compilando:
```sh
$ mvn clean package
```

Executando:
```sh
$ java -jar target/SOAPService.jar localhost 9999
```

Para executar utilizando HTTPS, passar o parâmetro "-s":
```sh
$ java -jar target/SOAPService.jar -s localhost 9999
```
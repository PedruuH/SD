# SD
Projetos desenvolvidos para disciplina de Sistemas Distribuidos.

## Pré-requisitos

Primeiramente é necessária a instalação da ferramenta Maven

### Instalação

No terminal, utilize o comando:
```
$ sudo apt install maven
```

## Execução:

Para iniciar a execução do servidor, utilize o comando: 
```
$ mvn package exec:java -Dexec.mainClass=br.com.ufu.javaGrpcClientServer.server.JavaServer
```

Após iniciado o servidor, utilize o comando para a execução do cliente: 
```
$ mvn package exec:java -Dexec.mainClass=br.com.ufu.javaGrpcClientServer.client.JavaClient
```

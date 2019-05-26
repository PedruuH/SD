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

Antes de de iniciar a execução do servidor ou cliente, utilize o comando:
```
$ mvn -DskipTests package
```

Servidor: 
```
$ mvn package exec:java -Dexec.mainClass=br.com.ufu.javaGrpcClientServer.server.JavaServer
```

Cliente:  
```
$ mvn package exec:java -Dexec.mainClass=br.com.ufu.javaGrpcClientServer.client.JavaClient
```

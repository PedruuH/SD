# SD
Projetos desenvolvidos para disciplina de Sistemas Distribuidos.

## Pré-requisitos

Para a execução desse projeto serão necessários o Java Runtime Environment, o Java SE Development Kit e a ferramenta de automação de compilação Maven.

### Instalação

Primeiramente, atualize a lista de pacotes:
```
$ sudo apt update
```

Instale o Java Runtime Environment com o comando:
```
$ sudo apt install default-jre
```

Instale o Java SE Development Kit:
```
$ sudo apt install default-jdk
```

Por fim, instale a ferramenta Maven com:
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

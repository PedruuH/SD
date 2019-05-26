# SD
Projetos desenvolvidos para disciplina de Sistemas Distribuidos.


# Execução:

$ mvn -DskipTests package

Servidor: $ mvn -DskipTests package exec:java -Dexec.mainClass=br.com.ufu.javaGrpcClientServer.server.JavaServer\n
Cliente:  $ mvn -DskipTests package exec:java -Dexec.mainClass=br.com.ufu.javaGrpcClientServer.client.JavaClient

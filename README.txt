PROJETO API - EXERCÍCIOS ADA

COMO EXECUTAR NO TERMINAL

Opção 1 - Via Maven (recomendado):

Exercício 1:
mvn clean compile
mvn exec:java -Dexec.mainClass="exercicio1.Main"

Exercício 2 (quando implementado):
mvn clean compile
mvn exec:java -Dexec.mainClass="exercicio2.view.ConsoleMenu"

Opção 2 - Via IDE:
Abra o projeto na IDE e execute a classe Main desejada
- exercicio1.Main
- exercicio2.view.ConsoleMenu (quando implementado)

ESTRUTURA

exercicio1/     Consulta CEP (ViaCEP) - já funciona
exercicio2/     Catálogo & Tarefas (DummyJSON) - para implementar

DEPENDÊNCIAS NECESSÁRIAS

No pom.xml precisa ter:
- jackson-databind (para JSON)
- lombok (para @Data, @Builder, etc)

Se não tiver, adicione:

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.2</version>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>

EXERCÍCIO 1 - já funciona
Execute: mvn exec:java -Dexec.mainClass="exercicio1.Main"

EXERCÍCIO 2 - implementar seguindo os guias
Quando terminar, execute: mvn exec:java -Dexec.mainClass="exercicio2.view.ConsoleMenu"

ARQUIVOS DE DADOS

O exercício 2 vai criar:
data/products.txt
data/todos.txt
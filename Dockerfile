# Etapa 1: Construção da aplicação
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copiar o arquivo de configuração do Maven e baixar dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar o código fonte para o container
COPY src ./src

# Compilar o projeto e gerar o .jar
RUN mvn clean package -DskipTests

# Etapa 2: Execução da aplicação
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar o arquivo .jar gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Definir o comando para iniciar o servidor Spring Boot
CMD ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
FROM maven:3.8.6-amazoncorretto-17 as builder

WORKDIR application

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; java -Djarmode=layertools -jar ../*.jar extract)

FROM amazoncorretto:17

ARG DEPENDENCY=target/dependency

WORKDIR application

COPY --from=builder application/${DEPENDENCY}/dependencies/ ./
COPY --from=builder application/${DEPENDENCY}/spring-boot-loader/ ./
COPY --from=builder application/${DEPENDENCY}/snapshot-dependencies/ ./
COPY --from=builder application/${DEPENDENCY}/application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

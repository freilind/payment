# docker build --tag=TAGNAME:VERSION --build-arg NAMEJAR=NAME .
FROM openjdk:17-jdk-alpine
ARG NAMEJAR
COPY ${NAMEJAR}.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

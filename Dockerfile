

FROM openjdk:8-jre-alpine
ADD target/socleKataCompte.jar socleKataCompte.jar

RUN apk update && \
    apk add --no-cache tzdata
	
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /socleKataCompte.jar

EXPOSE 9098

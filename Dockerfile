FROM openjdk:16-alpine
MAINTAINER André Silva Alves <andresilvaalves@gmail.com>

RUN mkdir -m 0755 -p /opt/app/ && mkdir -m 0755 -p /opt/app/log/

COPY target/*.jar /opt/app/application.jar
RUN chmod  0755 /opt/app/application.jar


WORKDIR /opt/app/

EXPOSE 8093

ENTRYPOINT ["java", "-Djava.net.preferIPv4Stack=true", "-Djava.net.preferIPv4Addresses=true", "-Dspring.profiles.active=prod", "-jar","/opt/app/application.jar"]

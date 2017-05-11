FROM docstore.rgs.ru:5000/centos-java:latest
MAINTAINER "Nesterenko Maxim"

ADD /spring-camel-rest-demo.jar /

EXPOSE 8081

CMD ["bash", "-c", "java -jar \
    ${JAVA_OPTS} \
    /spring-camel-rest-demo.jar"]
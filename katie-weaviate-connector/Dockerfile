FROM openjdk:11.0.11-jdk
MAINTAINER katie-weaviate-connector.wyona.org
VOLUME /tmp
COPY target/katie-weaviate-connector-*.war app.war
ENTRYPOINT ["java","-jar","/app.war"]

#FROM tomcat:8.5-alpine
#MAINTAINER katie-weaviate-connector.wyona.org
#VOLUME /tmp
#RUN rm -rf /usr/local/tomcat/webapps/ROOT
#COPY target/katie-weaviate-connector-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

#FROM frolvlad/alpine-oraclejdk8:slim
#MAINTAINER katie-weaviate-connector.wyona.org
#VOLUME /tmp
#ADD target/katie-weaviate-connector-1.0.0-SNAPSHOT.jar app.jar
#RUN sh -c 'touch /app.jar'
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
#EXPOSE 8080

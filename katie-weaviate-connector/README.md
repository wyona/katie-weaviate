# Katie Weaviate Connector

Katie Weaviate Connector webapp, in order to connect Katie with Weaviate using REST interfaces

## Requirements

* JDK: 1.11 (e.g. on Mac OS X: export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.11.jdk/Contents/Home)
* Maven version: 3.3.3 (Please double check Maven .m2/settings.xml)
* Either Tomcat: 8 (please see build.sh)
* or Docker (please see below)
* or from command line

## Configuration

* Configure mail server inside src/main/resources/application.properties

## Build and deploy inside Tomcat

* sh build.sh
* http://127.0.0.1:8080/katie-weaviate-connector-1.0.0-SNAPSHOT/

## Build and run from command line

* mvn clean install
* java -jar target/katie-weaviate-connector-1.0.0-SNAPSHOT.war
* http://localhost:8383/ (see server.port inside src/main/resources/application.properties)

## Docker

* Build webapp as jar file (see pom.xml)
* Start Docker
* Build image: docker build -t katie-weaviate-connector .
* Show images: docker images
** Remove image: docker rmi -f IMAGE ID
* Run image: docker run -p 8383:8383 katie-weaviate-connector
* Show docker processes: docker ps
* Stop specific docker process: docker stop CONTAINER ID
* Request in browser: http://127.0.0.1:8383/swagger-ui.html

## IntelliJ IDEA

* Start IntelliJ
* File -> New -> Project from Version Control -> Git
    * https://github.com/wyona/katie-weaviate
    * https://github.com/wyona/katie-weaviate.git
* Set JDK (see Version above)
* Reimport All Maven Projects
* Run clean/install
* Startup Server
* http://127.0.0.1:8383

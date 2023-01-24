#!/bin/bash

TOMCAT_HOME=/Users/michaelwechner/local/apache-tomcat-8.5.53

echo "INFO: Build 'Hello World' webapp ..."
mvn clean install -Dmaven.test.skip=true
#mvn clean install
#mvn -X clean install

echo "INFO: Trying to deploy webapp ..."
if [ ! -d $TOMCAT_HOME ];then
    echo "ERROR: No Tomcat installed at $TOMCAT_HOME"
    exit 0
fi
rm -rf $TOMCAT_HOME/webapps/katie-weaviate-connector-*
rm -rf $TOMCAT_HOME/work/Catalina/localhost/katie-weaviate-connector-*
cp target/katie-weaviate-connector-1.0.0-SNAPSHOT.war $TOMCAT_HOME/webapps/.

echo "INFO: Clean log files ..."
rm -f $TOMCAT_HOME/logs/*

echo "INFO: Startup Tomcat '$TOMCAT_HOME' and access the 'Hello World' webapp at 'http://127.0.0.1:8080/katie-weaviate-connector-1.0.0-SNAPSHOT/' ...."

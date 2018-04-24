#!/bin/sh

export JAVA_HOME=$JAVA8_HOME
export CLASSPATH=.:$JAVA_HOME/lib
export PATH=$JAVA_HOME/bin:$PATH
export JAVA_OPTS='-server -Xms1200m -Xmx1500m'

echo [INFO] Current Project Path
pwd

echo [INFO] Java version
java -version

echo [INFO] Startup APP...
nohup java -jar target/spring-boot-gwt-sample-0.0.1-SNAPSHOT.jar &



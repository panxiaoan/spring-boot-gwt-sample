#!/bin/sh

export JAVA_HOME=$JAVA8_HOME
export CLASSPATH=.:$JAVA_HOME/lib
export PATH=$JAVA_HOME/bin:$PATH
export JAVA_OPTS='-server -Xms1200m -Xmx1500m'

java -version

cd ..
pwd

echo [INFO] mvn eclipse...
mvn clean -U eclipse:clean dependency:sources -DdownloadSources=true eclipse:eclipse



#!/bin/sh

export JAVA_HOME=$JAVA11_HOME
export CLASSPATH=.:$JAVA_HOME/lib
export PATH=$JAVA_HOME/bin:$PATH
export JAVA_OPTS='-server -Xms1g -Xmx1g'

java -version

cd ..
echo "[INFO] >>> current workspace: $(pwd)"

rm -rf src/main/resources/gwt-unitCache
mvn clean compile

echo [INFO] Start GWT compile to JavaScript...

mvn gwt:compile
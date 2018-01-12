#!/bin/sh

export JAVA_HOME=$JAVA8_HOME
export CLASSPATH=.:$JAVA_HOME/lib
export PATH=$JAVA_HOME/bin:$PATH
export JAVA_OPTS='-server -Xms1200m -Xmx1500m'

java -version

cd ..
pwd

echo [INFO] Start GWT compile to JavaScript...

SRC=src/main/java:target/classes

GWT_HOME=$M2_REPO/com/google/gwt
validation_api=$GWT_HOME/validation-api/1.0.0.GA/validation-api-1.0.0.GA-sources.jar
gwt_user=$GWT_HOME/gwt-user/2.8.1/gwt-user-2.8.1.jar
gwt_dev=$GWT_HOME/gwt-dev/2.8.1/gwt-dev-2.8.1.jar
gwt_codeserver=$GWT_HOME/gwt-codeserver/2.8.1/gwt-codeserver-2.8.1.jar

asm=$M2_REPO/org/ow2/asm/asm-all/5.0.4/asm-all-5.0.4.jar

jars=$validation_api:$gwt_user:$gwt_dev:$gwt_codeserver:$asm:$SRC

java -Xms512m -cp $jars com.google.gwt.dev.Compiler -war src/main/resources/static $* com.pxa.sample.SpringBootGWTSample


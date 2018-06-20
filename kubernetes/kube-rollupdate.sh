#!/bin/bash

cd /opt/spring-boot-gwt-sample-docker

BUILD_ID=$1

echo -e "rollup deployment……"
kubectl set image deployment/springbootgwtsample springbootgwtsample=panxiaoan/spring-boot-gwt-sample:$BUILD_ID --namespace=default
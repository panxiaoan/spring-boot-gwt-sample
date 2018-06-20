#!/bin/bash

cd /opt/spring-boot-gwt-sample-docker

BUILD_ID=$1

echo -e "\033[32m rollup deployment…… \033[0m"
kubectl set image deployment/springbootgwtsample springbootgwtsample=panxiaoan/spring-boot-gwt-sample:$BUILD_ID --namespace=default
#!/bin/bash

cd /opt

BUILD_ID=$1
COMMIT_ID=$2
CONTAINER_NAME=spring-boot-gwt-sample
IMAGES_NAME=java/$CONTAINER_NAME
echo "build_id:"$1" commit_id:"$2" buildtime:"`date "+%Y-%m-%d %H:%M:%S"` >> docker_build.log

FILENAME=$(find -name spring-boot-gwt-sample-**.jar)
JARNAME=${FILENAME##*/}
chmod 777 $JARNAME

if [ -z "$JARNAME" ]
then
    echo "not find :"$JARNAME
    exit
else
    echo "find app:"$JARNAME
fi
 
docker stop $CONTAINER_NAME
docker rm $CONTAINER_NAME

IMAGE_ID=$(docker images | grep "$IMAGES_NAME" | awk '{print $3}')
echo "iam:"$IMAGE_ID
if [ -z "$IMAGE_ID" ]
then
    echo no images need del
else
    echo "rm images:" $IMAGE_ID
    docker rmi -f $IMAGE_ID
fi

docker build --build-arg app=$JARNAME . -t $IMAGES_NAME:$BUILD_ID
rm $JARNAME

docker run -itd -p 8080:8080 --name $CONTAINER_NAME $IMAGES_NAME:$BUILD_ID --restart=always

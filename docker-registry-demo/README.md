# Docker Registry

## Objective
Build a custom image, tag it, push it to Docker Hub, and pull it.

## Build
docker build -t my-custom-image:v1 .

## Tag
docker tag my-custom-image:v1 zeyaurrahman/my-custom-image:v1

## Push
docker push zeyaurrahman/my-custom-image:v1

## Pull
docker pull zeyaurrahman/my-custom-image:v1

## Run
docker run --rm zeyaurrahman/my-custom-image:v1

## Expected Output
Hello from Zeyaurrahman Docker Registry Demo

## Docker Hub Repository
https://hub.docker.com/r/zeyaurrahman/my-custom-image

## Result
Custom image successfully built, tagged, and pushed to Docker Hub.

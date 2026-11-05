# Docker Resource Management

## Objective
Run a Docker container with 512 MB memory and 1 CPU limit.

## Command
docker run -dit --name resource-demo --memory=512m --cpus=1 alpine sh

## Verification
docker inspect resource-demo --format='Memory: {{.HostConfig.Memory}} bytes, NanoCPUs: {{.HostConfig.NanoCpus}}'

## Verified Output
Memory: 536870912 bytes
NanoCPUs: 1000000000

## Result
Container successfully created with 512 MB memory and 1 CPU limit.

# Docker Container Troubleshooting

## Objective
Troubleshoot a container that exits immediately.

## Step 1: Run faulty container
docker run -d --name troubleshoot-demo alpine sh -c "echo 'Starting application'; exit 1"

## Step 2: Check logs
docker logs troubleshoot-demo

## Root Cause
The container exited because the command explicitly executed exit 1.

## Step 3: Fix the issue
docker rm troubleshoot-demo

docker run -d --name troubleshoot-demo alpine sh -c "echo 'Application started successfully'; sleep 3600"

## Step 4: Verify
docker ps --filter name=troubleshoot-demo
docker logs troubleshoot-demo

## Result
The corrected container started successfully and remained running.

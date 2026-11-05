# Task 13 - Docker Networking

## Objective
Create a custom bridge network and verify communication between two containers.

## Step 1: Create custom network
docker network create devops-network

## Step 2: Launch containers
docker run -dit --name container1 --network devops-network alpine sh
docker run -dit --name container2 --network devops-network alpine sh

## Step 3: Verify containers
docker ps

## Step 4: Test communication
docker exec container1 ping -c 4 container2

## Expected Result
4 packets transmitted, 4 received, 0% packet loss.

## Status
Completed successfully.

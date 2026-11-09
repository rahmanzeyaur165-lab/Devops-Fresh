#!/bin/bash

echo "Docker Cleanup Started..."

echo "Removing stopped containers..."
docker container prune -f

echo "Removing dangling images..."
docker image prune -f

echo "Removing unused volumes..."
docker volume prune -f

echo "Docker disk usage after cleanup:"
docker system df

echo "Docker Cleanup Completed!"

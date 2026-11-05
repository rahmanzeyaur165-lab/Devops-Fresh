# Docker Multi-Stage Build

## Objective
Create a multi-stage Dockerfile and compare image sizes.

## Build Normal Image
docker build -f Dockerfile.normal -t normal-image .

## Build Optimized Image
docker build -t optimized-image .

## Image Size Comparison

| Image | Disk Usage | Content Size |
|---|---:|---:|
| normal-image | 239 MB | 61.3 MB |
| optimized-image | 93.6 MB | 26.3 MB |

## Result
The optimized image reduced disk usage by approximately 60.8%.

The multi-stage build uses a Node.js builder stage and an Nginx final stage.

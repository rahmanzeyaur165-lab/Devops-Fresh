FROM node:22-alpine AS builder
WORKDIR /app
COPY app/ .
RUN mkdir -p /output && cp index.html /output/

FROM nginx:alpine
COPY --from=builder /output/index.html /usr/share/nginx/html/index.html
EXPOSE 80

\# Kubernetes NodePort Service



\## Objective

Expose an existing Nginx Deployment using a Kubernetes NodePort Service and access it through a web browser.



\## 1. Check Deployment



```bash

kubectl get deployments

```



Result: 5/5 replicas ready.



\## 2. Create NodePort Service



```bash

kubectl expose deployment nginx-deployment --type=NodePort --port=80

```



\## 3. Verify Service



```bash

kubectl get services

```



Service details:

\- Name: nginx-deployment

\- Type: NodePort

\- Cluster IP: 10.102.105.232

\- Service Port: 80

\- NodePort: 31413



\## 4. Get Application URL



```bash

minikube service nginx-deployment --url

```



\## 5. Browser Verification



Opened the generated Minikube URL in Google Chrome.



Result: Welcome to nginx! page displayed successfully.



\## Status

Completed successfully using Kubernetes and Minikube.


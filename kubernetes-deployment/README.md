\# Kubernetes Deployment Creation and Scaling



\## Objective

Create an Nginx Deployment with 3 replicas, verify all Pods are running, and scale the Deployment to 5 replicas.



\## 1. Create Deployment



```bash

kubectl create deployment nginx-deployment --image=nginx:latest --replicas=3

```



\## 2. Verify Deployment



```bash

kubectl get deployments

```



Initial result: 3/3 replicas ready.



\## 3. Verify Pods



```bash

kubectl get pods

```



Result: All 3 Deployment Pods were running successfully.



\## 4. Scale Deployment to 5 Replicas



```bash

kubectl scale deployment nginx-deployment --replicas=5

```



\## 5. Final Verification



```bash

kubectl get deployments

kubectl get pods

```



Final result:



\- Desired replicas: 5

\- Ready replicas: 5

\- Available replicas: 5

\- All 5 Deployment Pods: Running



\## Status



Completed successfully using Minikube and Kubernetes.


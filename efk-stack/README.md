# EFK-minikube
Non production setup of the EFK stack on minikube

1. **Create the namespace** 
2. **Create the elastic search service** 
3. **Create the elastic search persistent volume**
4. **Create elastic search as a Stateful Set** 
5. **Creating the Kibana Deployment and Service** 
6. **Creating the Fluentd DaemonSet** 

#Java Service Readiness
follow readme.md file in spring-boot-lorem-poc folder for setup.
Once Java Service steps are completed lets proceed with below deployment steps on local

# Deploy
```
kubectl apply -f efk-project --recursive
```
Oberserve the name of your Kibana pod:
```
kubectl get pods --namespace=kube-logging
NAME                      READY   STATUS    RESTARTS   AGE
es-cluster-0              1/1     Running   0          63m
es-cluster-1              1/1     Running   0          62m
es-cluster-2              1/1     Running   0          62m
fluentd-v6jgn             1/1     Running   0          23m
kibana-dep-765cb6669d-czssw   1/1     Running   0          51m
```
and configure port forwarding.
```
kubectl port-forward kibana-dep-765cb6669d-czssw  5601:5601 --namespace=kube-logging
```
visit the following web URL:
```
http://localhost:5601
```

7. **Testing the logging** 

```
minikube service lorem-svc -n kube-logging
```

**Version:** 

kubectl version: v1.26.3, minikube version: v1.30.1

# Clear the resources
```
kubectl delete -f efk-project
```
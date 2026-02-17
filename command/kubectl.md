# Вывод информации о кластере
kubectl cluster-info

# Для дальнейшей отладки и диагностики проблем кластера используйте команду 'kubectl cluster-info dump'
kubectl cluster-info dump

# Вывод списка узлов кластера
kubectl get nodes

# Получение дополнительных сведений об объекте
kubectl describe node minikube-m02

# Вывод списка модулей
kubectl get pods
# Вывод списка модулей с labels
kubectl get po --show-labels
# Вывод списка модулей с конкретными labels
kubectl get po -L creation-method

# Развертывание приложения
kubectl run k8s-demo --image=compotapp/k8s-demo --port=8080

# Создать deployment
kubectl create deployment k8s-demo --image=compotapp/k8s-demo --port=8080

# Масштабировать до нужного количества реплик
kubectl scale deployment k8s-demo --replicas=3

# Создание объекта Service
kubectl expose replicaset k8s-demo --type=LoadBalancer --name k8s-demo-http --port=8080 --target-port=8080

# Вывод списка служб
kubectl get services, kubectl get svc

# Использовать порт-форвардинг
kubectl port-forward svc/k8s-demo-http 8080:8080
# Использовать порт-форвардинг на конкретный под
kubectl port-forward k8s-demo-pod 8888:8080
curl localhost:8888

# Полный YAML развернутого модуля
kubectl get po k8s-demo-7894bbbcd6-8jck7 -o yaml

# Создать модуль из файла YAML
kubectl create -f manifest/k8s-demo-pod.yaml

# Посмотреть логи
kubectl logs <ид контейнера>

# Посмотреть логи многоконтейнерного пода
kubectl logs k8s-demo-pod -c k8s-demo

# Добавить labels
kubectl label po k8s-demo-pod creation_method=example
# Изменить labels
kubectl label po k8s-demo-pod-v2 env=debug --overwrite

# Вывод списка модулей с помощью селектора меток
kubectl get po -l creation_method=example
# Вывод списка модулей с помощью селектора меток по ключу
kubectl get po -l env
# Вывод списка модулей с помощью селектора меток которые не содержат ключ
kubectl get po -l '!env'

# Добавить labels к node
kubectl label node minikube-m02 example=label
# Вывод списка node с помощью селектора меток
kubectl get nodes -l gpu=true

# Добавить аннотацию в модуль
kubectl annotate pod k8s-demo-pod-v2 mycompany.com/someannotation="foo bar"

# Обнаружение других пространств имен и их модулей
kubectl get ns
# Поиск конкретных пространств имен и их модулей
kubectl get po --namespace kube-system
# Создание пространств имен
kubectl create namespace custom-namespace

# Удаление модуля по имени
kubectl delete po k8s-demo-pod-v2
# Удаление модулей с помощью селекторов меток
kubectl delete po -l creation_method=example
# Удаление модулей путем удаления всего пространства имен
kubectl delete ns custom-namespace
# Удаление всех модулей в пространстве имен при сохранении пространства имен
kubectl delete po --all
# Удаление (почти) всех ресурсов в пространстве имен
kubectl delete all --all

# Получение лога приложения аварийного контейнера
kubectl logs k8s-demo-liveness --previous

# Посмотреть job
kubectl get jobs

# Переменные среды service в контейнере
kubectl exec k8s-demo-v6-pod env
# Зайти в контейнер в pod
kubectl exec k8s-demo-v6-pod -it bash


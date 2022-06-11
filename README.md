
**One time GKE setup**
```
export PROJECT_ID=$(gcloud config get-value project)

gcloud container clusters create service-cluster \
--num-nodes 1 \
--machine-type n1-standard-1 \
--zone us-central1-c \
--workload-metadata=GKE_METADATA \
--project=${PROJECT_ID} \
--workload-pool=${PROJECT_ID}.svc.id.goog
```
**One time setup of service2**
```
gcloud services enable compute.googleapis.com container.googleapis.com containerregistry.googleapis.com cloudtrace.googleapis.com logging.googleapis.com secretmanager.googleapis.com
git clone https://github.com/sdhimmar006/service2.git
chmod +x service2/mvnw
export SERVICE2_PORT=8082
export APP_NAME=service2
export GOOGLE_CLOUD_PROJECT=`gcloud config list --format="value(core.project)"`
export VERSION=$(($(date +%s%N)/1000000))
cd service2
./mvnw -DskipTests package
./mvnw -DskipTests com.google.cloud.tools:jib-maven-plugin:build \
-Dimage=gcr.io/$GOOGLE_CLOUD_PROJECT/$APP_NAME/$VERSION
kubectl create deployment $APP_NAME \
--image=gcr.io/$GOOGLE_CLOUD_PROJECT/$APP_NAME/$VERSION
kubectl create service loadbalancer $APP_NAME --tcp=$SERVICE2_PORT:$SERVICE2_PORT
```
**Update an existing service**
```
export VERSION=$(($(date +%s%N)/1000000))
export GOOGLE_CLOUD_PROJECT=`gcloud config list --format="value(core.project)"`
export APP_NAME=service2
./mvnw -DskipTests package
./mvnw -DskipTests com.google.cloud.tools:jib-maven-plugin:build \
-Dimage=gcr.io/$GOOGLE_CLOUD_PROJECT/$APP_NAME/$VERSION
kubectl set image deployment/$APP_NAME \
$APP_NAME=gcr.io/$GOOGLE_CLOUD_PROJECT/$APP_NAME/$VERSION
```

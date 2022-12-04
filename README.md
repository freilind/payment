# Microservices with spring boot and spring cloud.

## Stack :
>- Spring Boot 2.7.5
>- Spring cloud 2021.0.5
>- Keycloack server
>- Java 11
>- Postgresql
>- Docker
>- Docker compose

## Solution diagram
![components.png](images/components.png)

## Getting Started

First, run the commands:

```
./gradlew initBuildJars --parallel
```

```
./gradlew buildImageDocker --parallel
```

```
docker-compose -f docker-compose-init.yml up
```

Open [http://localhost:8090/admin](http://localhost:8090/admin) with your browser to configure keycloack.

Login with the credentials defined in the .env file
```
KEYCLOAK_ADMIN=admin
KEYCLOAK_ADMIN_PASSWORD=admin123
```
Create realm (Payment).

![img.png](images/create_realm.png)

Go to Keys in the realm and copy the key of the provider
rsa-generated.

![img.png](images/key.png)

Create the client.

![img_1.png](images/create_client.png)

Put the client Id in .env file.

```
KEYCLOACK_CLIENT_ID
```

Create user and set password.

![img_1.png](images/create_user.png)

Copy the key of provider and put in .env file and the bootstrap file of the 
keycloack project.

```
KEYCLOACK_REAL_ID
```

![img_2.png](images/bootstrap-kc.png)

```
docker-compose -f docker-compose.yml up
```

Stop the containers.

# Run

```
docker-composes up
```

Use the postman collection with endpoints.
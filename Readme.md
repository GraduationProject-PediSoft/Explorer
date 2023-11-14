# Explorer Pedisoft

This repository contains the explorer for Pedisoft sytem. It uses SpringCloud Eureka discovery client to read the discovery registry to filter IA microservices in the system. The IA Services that connect to the system are expected to have a special metadata:

- microservice-type: IA-MODEL

# Running

The project was designed to be executed in a containerized environment. In this repo [Docker](https://www.docker.com/) was used for it, but Podman or Kubernetes could be used with little configuration. The compose file builds and executes the SpringBoot web server without any additional configuration, simply run:

```sh
docker compose up -d
```

# Configuration
## Environment
the *.env_template* file contains the environment variables that should be defined in order to run, should be edited according to the needs.

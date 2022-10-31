# Katie Weaviate

[Katie](https://ukatie.com) is using [Weaviate](https://weaviate.io/developers/weaviate/current/) to detect duplicated questions.

## Setup

* Install Weaviate: https://weaviate.io/developers/weaviate/current/installation/docker-compose.html
* Configure persistent volume: https://weaviate.io/developers/weaviate/current/installation/docker-compose.html#persistent-volume
* Run Weaviate: docker-compose up
* Test Weaviate: http://localhost:8080/v1
* Add Schema using the shell script described below

## Schema

Here is a shell script that we use to set the schema

[weaviate-schema.sh](./weaviate-schema.sh)

## Nginx configuration to protect the Weaviate API

Here is an example configuration, whereas it assumes that Weaviate runs on port 4001

[nginx.conf](./nginx.conf)

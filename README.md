# Katie Weaviate

[Katie](https://ukatie.com) is using [Weaviate](https://weaviate.io/developers/weaviate/current/) to detect duplicated questions.

## Setup

* Install Weaviate: https://weaviate.io/developers/weaviate/current/installation/docker-compose.html
    * semitechnologies/transformers-inference (sentence-transformers-multi-qa-MiniLM-L6-cos-v1)
    * semitechnologies/qna-transformers (distilbert-base-uncased-distilled-squad)
* Configure persistent volume: https://weaviate.io/developers/weaviate/current/installation/docker-compose.html#persistent-volume
* Run Weaviate: docker-compose up
* Test Weaviate: http://localhost:8080/v1
* Add Schema using the shell script described below: sh weaviate-schema.sh
* Verify Schema: http://localhost:8080/v1/schema
* Index Katie domain with Weaviate (Make sure to configure weaviate.host inside applicatio(-dev).properties
* Verify Objects: http://localhost:8080/v1/objects

## Schema

Here is a shell script that we use to set the schema

[weaviate-schema.sh](./weaviate-schema.sh)

## Nginx configuration to protect the Weaviate API

Here is an example configuration, whereas it assumes that Weaviate runs on port 4001

[nginx.conf](./nginx.conf)

# Katie Weaviate

[Katie](https://ukatie.com) is using [Weaviate](https://www.semi.technology/developers/weaviate/current/) to detect duplicated questions.

## Schema

Here is a shell script that we use to set the schema

[weaviate-schema.sh](./weaviate-schema.sh)

## Nginx configuration to protect the Weaviate API

Here is an example configuration, whereas it assumes that Weaviate runs on port 4001

[nginx.conf](./nginx.conf)

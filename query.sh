#!/bin/sh

BASE_URL=http://0.0.0.0:8080/v1/graphql
#BASE_URL=https://weaviate.ukatie.com/v1/graphql

echo "Query Weaviate ($BASE_URL) ..."

curl -k -X POST -H "Content-Type: application/json" -d '{"query":"{Get {Question { question _additional { vector }}}}"}' $BASE_URL

#curl -k -X POST -H "Content-Type: application/json" -d '{"query":"{Get {OpenAIDocument { text _additional { vector }}}}"}' $BASE_URL

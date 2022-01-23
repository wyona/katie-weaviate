#!/bin/sh

BASE_URL=http://0.0.0.0:8080/v1/schema
#BASE_URL=https://weaviate.ukatie.com/v1/schema

echo "Set Weaviate schema ($BASE_URL) ..."

curl -k -X POST -H "Content-Type: application/json" -d '{"class":"Question", "description":"Question", "properties":[ {"dataType":["string"], "description":"QnA Id", "name":"qnaId", "moduleConfig":{"text2vec-transformers":{"skip":true}}}, {"dataType":["text"], "description":"Question", "name":"question", "moduleConfig":{"text2vec-transformers":{"skip":false}} } ] }' $BASE_URL

curl -k -X POST -H "Content-Type: application/json" -d '{"class":"Answer", "description":"Answer", "properties":[ {"dataType":["string"], "description":"QnA Id", "name":"qnaId", "moduleConfig":{"text2vec-transformers":{"skip":true}}}, {"dataType":["text"], "description":"Answer", "name":"answer", "moduleConfig":{"text2vec-transformers":{"skip":false}} } ] }' $BASE_URL

curl -k -X POST -H "Content-Type: application/json" -d '{"class":"Tenant", "description":"Tenant", "properties":[ {"dataType":["string"], "description":"Name of tenant", "name":"name"} ] }' $BASE_URL

curl -k -X POST -H "Content-Type: application/json" -d '{"dataType":["Tenant"], "description":"Tenant of a question", "name":"tenant" }' $BASE_URL/Question/properties

curl -k -X POST -H "Content-Type: application/json" -d '{"dataType":["Tenant"], "description":"Tenant of an answer", "name":"tenant" }' $BASE_URL/Answer/properties

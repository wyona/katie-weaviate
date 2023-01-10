#!/bin/sh

# https://weaviate.io/developers/weaviate/current/graphql-references/aggregate.html
echo "INFO: Count various classes ..."
echo ""

echo '{ 
    "query": "{
      Aggregate {
        Question {
          meta {
            count
          }
        }
      }
    }"
  }' | curl \
    -X POST \
    -H 'Content-Type: application/json' \
    -d @- \
    http://localhost:8080/v1/graphql

echo '{ 
    "query": "{
      Aggregate {
        Answer {
          meta {
            count
          }
        }
      }
    }"
  }' | curl \
    -X POST \
    -H 'Content-Type: application/json' \
    -d @- \
    http://localhost:8080/v1/graphql

echo '{ 
    "query": "{
      Aggregate {
        Tenant {
          meta {
            count
          }
        }
      }
    }"
  }' | curl \
    -X POST \
    -H 'Content-Type: application/json' \
    -d @- \
    http://localhost:8080/v1/graphql

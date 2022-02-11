#!/bin/sh

# Weaviate documentation: https://www.semi.technology/developers/weaviate/current/modules/text2vec-openai.html
# Get OpenAPI key: https://beta.openai.com/account/api-keys

#curl https://api.openai.com/v1/engines/text-search-ada-query-001/embeddings \
curl https://api.openai.com/v1/engines/text-similarity-ada-001/embeddings \
  -k -X POST \
  -H "Authorization: Bearer YOUR_API_KEY" \
  -H "Content-Type: application/json" \
  -d '{"input": "Who is Katie?"}'

#!/bin/sh

curl https://api.openai.com/v1/engines/text-search-ada-query-001/embeddings \
  -k -X POST \
  -H "Authorization: Bearer YOUR_API_KEY" \
  -H "Content-Type: application/json" \
  -d '{"input": "Who is Katie?"}'

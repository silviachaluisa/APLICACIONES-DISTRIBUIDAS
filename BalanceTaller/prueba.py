import requests
from collections import Counter

responses=[]
for _ in range(100):
    response=requests.get("http://localhost:8080")
    responses.append(response.text.strip())
    
count=Counter(responses)
print(count)        
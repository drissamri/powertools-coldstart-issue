```
mvn clean package 
```

```
sls deploy
```

```
lumigo-cli measure-lambda-cold-starts -n client-service-dev-create-client -r eu-central-1 -f src/test/resources/create-client-event.json
```

lambda-logging (baseline) 
```
{
  "functionName": "client-service-dev-create-client",
  "memorySize": 3008,
  "coldStarts": 65,
  "min": 1475.29,
  "p25": 1573.41,
  "median": 1602.8,
  "p75": 1624.75,
  "p95": 1669.79,
  "max": 1712.77,
  "stddev": 43.1292
}
```
powertools-logging
```
{
      "functionName": "client-service-dev-create-client",
      "memorySize": 3008,
      "coldStarts": 71,
      "min": 1787.6,
      "p25": 1952.06,
      "median": 1981.9,
      "p75": 2004.21,
      "p95": 2063.38,
      "max": 2149.03,
      "stddev": 53.575
}
```
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
  "coldStarts": 47,
  "min": 1266.24,
  "p25": 1321.98,
  "median": 1353.7,
  "p75": 1368.37,
  "p95": 1397.98,
  "max": 1410.66,
  "stddev": 32.9884
}

{
  "functionName": "client-service-dev-create-client",
  "memorySize": 3008,
  "coldStarts": 65,
  "min": 1281.9,
  "p25": 1333.04,
  "median": 1350.91,
  "p75": 1365.49,
  "p95": 1435.17,
  "max": 1706.47,
  "stddev": 55.5152
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
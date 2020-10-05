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
#1
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
#2
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
-----

powertools-logging
```
{
  "functionName": "client-service-dev-create-client",
  "memorySize": 3008,
  "coldStarts": 69,
  "min": 1731.6,
  "p25": 1894.02,
  "median": 1929.76,
  "p75": 1957.6,
  "p95": 1992.91,
  "max": 2039.29,
  "stddev": 54.1881
}

{
  "functionName": "client-service-dev-create-client",
  "memorySize": 3008,
  "coldStarts": 70,
  "min": 1838.32,
  "p25": 1890.96,
  "median": 1917.03,
  "p75": 1950.22,
  "p95": 1988.21,
  "max": 2055.86,
  "stddev": 43.4739
}
```
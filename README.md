## OAuth 2.0 (OpenID Connect) with Spring Boot demo

### Resource Server

#### REST API 
- Insert
```
$ curl -v -X POST -u user:password -H 'Content-Type: application/json' -d '{"task":"Task Name"}' http://localhost:8080/v1/task
```
- Find all
```
$ curl -v -X GET -u user:password http://localhost:8080/v1/timelines
```
- Find by user
```
$ curl -v -X GET -u user:password http://localhost:8080/v1/tasks
```

#### REST API (with Access Token)
- Insert
```
curl -v -X POST -H 'Authorization: Bearer e257d9c6-d21f-44c5-a517-dce7e31fb6b5' -H 'Content-Type: application/json' -d '{"task":"Task Name"}'  http://localhost:18082/v1/task
```

- Find all
```
curl -v -X GET -H 'Authorization: Bearer e257d9c6-d21f-44c5-a517-dce7e31fb6b5' http://localhost:18082/v1/timelines
```



### Authorization Server

#### OAuth Endpoint

- Token Endpoint
```
curl -X POST -u demo:demo -d grant_type=password -d username=user -d password=password http://localhost:18081/authz/oauth/token
```

## OAuth 2.0 (OpenID Connect) with Spring Boot demo

### Resource Server

#### REST API
- Insert
```
$ curl -X POST -u user:password -H 'Content-Type: application/json' -d '{"task":"Task Name"}' http://localhost:8080/v1/task
```
- Find all
```
$ curl -X GET -u user:password http://localhost:8080/v1/tasks
```
- Find by user
```
$ curl -X GET -u user:password http://localhost:8080/v1/tasks
```


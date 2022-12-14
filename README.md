# Issue management service
This project is an issue management application

## Tech stack
* **Kotlin** as a main language.
* **Gradle** as a build tool.
* **Arrow Core** for type-safe error handling.
* **TestContainers** for integration testing.

## Architecture
This project consists of several Gradle subprojects separated based on Domain-driven design (DDD) as below.

## Server API
### 1. Get issues API
```
GET {host}/api/v1/issues?status=TODO
```

### 2. Post issue API
```
POST {host}/api/v1/issues
```

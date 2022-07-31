# Issue management service
This project is an issue management application developed by referring to fastcampus lecture.

## Tech stack
* **Kotlin** as a main language.
* **Gradle** as a build tool.
* **Arrow Core** for type-safe error handling.
* **TestContainers** for integration testing.
* **Kotest** for unit testing.

---

## Architecture
This project consists of several Gradle subprojects separated based on Domain-driven design (DDD) as below.

---

## Server API
### 1. Get issues API
```json
GET {host}/api/v1/issues?status=TODO
```

### 2. Post issue API
```json
POST {host}/api/v1/issues
```

### 3. Get issue API
```json
GET {host}/api/v1/issues/{issueId}
```

### 4. Update issue API
```json
PUT {host}/api/v1/issues/{issueId}
```

### 5. Delete issue API
```json
DELETE {host}/api/v1/issues/{issueId}
```
# Integration Test Instructions

## Purpose
Verify the endpoint through HTTP requests to a running embedded Spring Boot server.

## Test Setup
`TypeMappingControllerIT` starts the application with a random available port using `@SpringBootTest(webEnvironment = RANDOM_PORT)`. The test uses the JDK HTTP client; no separate test server setup is needed.

## Run Integration Tests
From the project root:

```powershell
mvn verify
```

Maven Failsafe executes `*IT` test classes during `integration-test` and verifies the results during `verify`.

## Covered Scenarios
- All four supported values return HTTP 200 and their exact mapping strings.
- Lowercase and mixed-case values match case-insensitively.
- An unsupported value returns HTTP 404, `text/plain`, and `Unknown type: <value>`.
- Existing `GET /home` continues to return `Home page`.

## Test Reports
- **Failsafe Reports**: `target/failsafe-reports/`.
- **Expected**: `TypeMappingControllerIT` passes with zero failures and errors.

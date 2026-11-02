# Unit of Work

## `type-mapping-api`
- **Type**: Feature unit within the existing Spring Boot application; not a separately deployable service.
- **Purpose**: Expose the type-to-string mapping API for client applications.
- **Responsibilities**:
  - Add the new `TypeMappingController` for `POST /types/{type}`.
  - Map the four supported type names case-insensitively to their specified result strings.
  - Return HTTP 404 with `Unknown type: <type>` for unsupported values.
  - Add live-server integration coverage for the endpoint and preserve the existing home endpoint behavior.
- **Code Organization**:
  - Production code follows the existing Maven layout under `src/main/java/org/example/`.
  - Integration test code follows the Maven test layout under `src/test/java/org/example/`.
  - Maven dependency and plugin changes, if needed for integration testing, remain in the existing root `pom.xml`.
- **Story**: ST-1.
- **External Interfaces**: HTTP POST endpoint `/types/{type}`.
- **Owned Data**: None; this unit is stateless and has no persistence.
- **Out of Scope**: Deployment/infrastructure changes, authentication, and additional performance/availability targets.

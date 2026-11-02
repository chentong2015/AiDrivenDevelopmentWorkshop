# Components

## TypeMappingController
- **Purpose**: Expose the type-mapping REST API.
- **Responsibilities**:
  - Handle POST requests at `/types/{type}`.
  - Apply case-insensitive matching for the four supported type values.
  - Return the specified mapping result as a string.
  - Raise a not-found condition for unsupported values, preserving the supplied type for the error response.
  - Translate unsupported-type errors to HTTP 404 with the required plain-text response.
- **Interfaces**: HTTP endpoint and Spring MVC exception handling.
- **Dependencies**: Spring Web / Spring MVC.

## Separate Service
No separate service component is introduced. This is a small, stateless mapping with one endpoint and no persistence, external integrations, or reuse requirement; keeping it in the new controller follows the selected design choice.

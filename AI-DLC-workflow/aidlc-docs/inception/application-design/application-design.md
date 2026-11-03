# Application Design

## Scope and Decisions
- Add `TypeMappingController` for `POST /types/{type}`.
- Keep the case-insensitive mapping logic in the new controller; do not introduce a separate service.
- Return the mapped `String` for successful requests.
- Use a controller-scoped exception handler for unsupported types, returning HTTP 404 with plain-text body `Unknown type: <type>`.
- Preserve the existing `GET /home` endpoint unchanged.

## Components
### TypeMappingController
Owns the new endpoint, supported type mapping, and unsupported-type response handling. See `components.md` and `component-methods.md`.

## Service Orchestration
No separate service layer is required for this isolated, stateless mapping. See `services.md`.

## Dependencies and Communication
The controller depends on Spring Web / Spring MVC for request mapping and exception handling. It has no data-store, external-service, or other application-component dependency. See `component-dependency.md`.

## Contract
- **Method**: POST
- **Path**: `/types/{type}`
- **Success**: HTTP 200 and the mapping result (`HMS-enhanced`, `OKA-lina PM`, `UTA-BAE`, or `RAS-enhanced KO`).
- **Matching**: Case-insensitive.
- **Unsupported type**: HTTP 404 and plain text `Unknown type: <type>`.
- **Authentication**: None required.
- **Request body**: None required.

## Traceability
This design supports ST-1 and FR-1 through FR-5. The live-server integration-test requirement FR-6 is handled in the code-generation and build/test stages.

# Requirements

## Intent Analysis
- **User Request**: Add a new API feature to the existing service, using the context in `docs/requirements/feature.md`.
- **Request Type**: New feature.
- **Scope Estimate**: Single Spring Boot application; add a new controller and integration-test coverage, with test/build configuration as needed.
- **Complexity Estimate**: Simple implementation with standard requirements depth because the original endpoint and response behavior required clarification.

## Summary
Add a POST endpoint at `/types/{type}`. It maps four supported type names to specified strings, appending the supplied Add Info value with a space. Type matching is case-insensitive. Unsupported types return HTTP 404 with a plain-text message. An integration test must start the embedded server on a random port and make HTTP requests.

## Functional Requirements

### FR-1: Endpoint and Controller
- Provide an HTTP POST endpoint at `/types/{type}`.
- Accept exactly one path variable named `type`.
- Implement the endpoint in a new controller class.
- No request body is required by the stated requirements.

### FR-2: Type Matching
- Match supported type values case-insensitively.
- Normalize the value for mapping while preserving the original path value for an unsupported-type error message.

### FR-3: Supported Type Responses
Return the following string body for each supported type:

| Input type (case-insensitive) | Response body |
|---|---|
| `HMS` | `HMS-enhanced` |
| `OKA` | `OKA-lina PM` |
| `UTA` | `UTA-BAE` |
| `RAS` | `RAS-enhanced KO` |

For rows with Add Info, append that value to the Mapping Result separated by one space.

### FR-4: Unsupported Type
- For any unsupported `type`, return HTTP 404 Not Found.
- Return a plain-text body in the form `Unknown type: <type>`, replacing `<type>` with the supplied path value.

### FR-5: Endpoint Access
- No authentication or authorization is required for this endpoint.

### FR-6: Integration Testing
- Add an integration test for the endpoint.
- Start the embedded server on a random port and send HTTP requests to the running application.
- Test all four mapping results.
- Verify case-insensitive matching and the specified unsupported-type status/body.

## Non-Functional Requirements
- No additional performance, availability, or operational targets were specified; use existing service defaults.
- No persistence, external integrations, or infrastructure changes are required by the stated feature.

## Technical Context and Constraints
- Existing application: Java 17, Maven, Spring Boot Web 4.1.1.
- Existing application code is under `src/main/java/org/example/`.
- The existing project has no test source files or test dependencies. Add only the test/build configuration needed for the requested integration test.
- Keep the requested endpoint in a new controller; preserve the existing `GET /home` behavior.

## Extension Configuration
- Resiliency Baseline: Disabled.
- Security Baseline: Disabled.
- Property-Based Testing: Disabled.

## Acceptance Criteria
1. `POST /types/HMS` returns HTTP 200 with body `HMS-enhanced`.
2. `POST /types/OKA` returns HTTP 200 with body `OKA-lina PM`.
3. `POST /types/UTA` returns HTTP 200 with body `UTA-BAE`.
4. `POST /types/RAS` returns HTTP 200 with body `RAS-enhanced KO`.
5. Lowercase or mixed-case supported values return the same mapping as their uppercase forms.
6. An unsupported value returns HTTP 404 and plain text `Unknown type: <supplied value>`.
7. Integration tests exercise the running application via its embedded server on a random port and cover all four mappings.
8. The existing `GET /home` endpoint continues to return `Home page`.

## Decisions Recorded from Clarification
- Route: `/types/{type}`.
- Add Info: append to the mapping result with one separating space.
- Unsupported type: HTTP 404 with plain-text `Unknown type: <type>`.
- Matching: case-insensitive.
- Access control: none required.
- Integration test: embedded server on a random port with real HTTP requests.
- Additional NFR targets: none.

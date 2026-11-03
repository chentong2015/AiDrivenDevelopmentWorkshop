# User Stories

## ST-1: Retrieve the Mapped Type Value
- **Persona**: API-Integrating Application Developer
- **Story**: An application integrating with the service posts a type value and receives its mapped string so the application can use the service's mapping without duplicating those rules.
- **Requirements**: FR-1, FR-2, FR-3, FR-4, FR-5, FR-6.

### Acceptance Criteria
- [x] A POST to `/types/HMS` returns HTTP 200 with `HMS-enhanced`.
- [x] A POST to `/types/OKA` returns HTTP 200 with `OKA-lina PM`.
- [x] A POST to `/types/UTA` returns HTTP 200 with `UTA-BAE`.
- [x] A POST to `/types/RAS` returns HTTP 200 with `RAS-enhanced KO`.
- [x] Lowercase or mixed-case supported values return the same mapping as their uppercase forms.
- [x] An unsupported value returns HTTP 404 with plain text `Unknown type: <supplied value>`.
- [x] No authentication or authorization is required to call the endpoint.
- [x] Integration tests send HTTP requests to the running application on a random port and cover all four mappings.
- [x] The existing `GET /home` endpoint continues to return `Home page`.

### INVEST Validation
- **Independent**: The story is scoped to the new endpoint and can be implemented independently of unrelated service features.
- **Negotiable**: Implementation details remain open while the approved API contract is fixed.
- **Valuable**: It lets a client obtain the service-defined mapping rather than reproducing it.
- **Estimable**: The route, mapping values, error behavior, and test expectations are defined.
- **Small**: One endpoint, one mapping behavior, and focused integration coverage.
- **Testable**: Each acceptance criterion can be verified through HTTP responses or regression testing.

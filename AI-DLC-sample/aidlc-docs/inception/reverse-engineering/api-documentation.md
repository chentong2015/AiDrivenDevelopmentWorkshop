# API Documentation

## REST APIs
### Home
- **Method**: GET
- **Path**: `/home`
- **Purpose**: Return a static home response.
- **Request**: No request body or path variables.
- **Response**: String body `Home page`.

## Requested API (Not Yet Implemented)
The feature requirement requests a POST endpoint with one path variable named `type`. The route template, the behavior for unsupported types, and the interpretation of the "Add Info" column are not specified in the current API implementation. The requested mapping values are recorded in `docs/requirements/feature.md`; these questions will be handled during Requirements Analysis.

## Internal APIs
### `HomeController`
- **Methods**: `String home()`
- **Parameters**: None.
- **Return Types**: `String` response body.

## Data Models
No request or response model classes are present.

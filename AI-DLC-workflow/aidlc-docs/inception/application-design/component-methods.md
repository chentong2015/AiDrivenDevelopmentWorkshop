# Component Methods

## TypeMappingController

### `String mapType(String type)`
- **Purpose**: Map one supported type value to its required response string.
- **Input**: `type`, the path-variable string.
- **Output**: The mapped string for `HMS`, `OKA`, `UTA`, or `RAS`.
- **Business Rules**:
  - Match without regard to case.
  - Return `HMS-enhanced`, `OKA-lina PM`, `UTA-BAE`, or `RAS-enhanced KO`, respectively.
  - For unsupported values, signal the controller's not-found handling with the original supplied value.

### `ResponseEntity<String> handleUnsupportedType(UnsupportedTypeException exception)`
- **Purpose**: Convert an unsupported-type condition into the agreed HTTP error response.
- **Input**: An exception containing the original supplied type.
- **Output**: HTTP 404 with plain-text body `Unknown type: <type>`.
- **Invocation**: Spring MVC exception handler; not a public REST route.

## HTTP Endpoint
- **Method**: POST
- **Path**: `/types/{type}`
- **Path Variable**: `type`
- **Success Response**: HTTP 200 with the mapped string as the response body.
- **Error Response**: HTTP 404 with the specified plain-text message for unsupported types.
- **Request Body**: None required.

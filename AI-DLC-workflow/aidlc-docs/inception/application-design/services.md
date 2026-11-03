# Services

## Service Layer Decision
No separate application service is introduced for this feature. The type mapping is a small, stateless operation used only by one endpoint. The selected design keeps the mapping in `TypeMappingController` and uses a controller-scoped exception handler for unsupported values.

## Request Orchestration
1. Spring MVC routes `POST /types/{type}` to the controller method.
2. The controller performs case-insensitive matching and selects the response string.
3. If supported, Spring MVC returns the string with HTTP 200.
4. If unsupported, the controller raises an exception carrying the original type; its exception handler returns HTTP 404 and `Unknown type: <type>`.

No database, remote call, or other service interaction is involved.

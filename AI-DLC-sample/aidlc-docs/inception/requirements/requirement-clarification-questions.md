# Requirements Follow-Up Clarification

You selected HTTP 404 for unsupported `type` values, but did not specify the response body. Which behavior should the API use?

## Question 1: Unsupported-Type Response Body
When the endpoint returns HTTP 404 for an unsupported type, what should the response body contain?

A) An empty response body

B) Plain text in the form `Unknown type: <type>`

C) Leave the response body to Spring Boot's default error handling

X) Other (please describe the exact response body after [Answer]: tag below)

[Answer]: B

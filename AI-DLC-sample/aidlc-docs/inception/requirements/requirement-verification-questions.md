# Requirements Clarification Questions

The feature requirements specify a POST endpoint with a `type` path variable and four mapping results. Please answer every question by entering an option after `[Answer]:`. For `X) Other`, describe your preference after the tag.

## Question 1: Endpoint Route
Which route should the new POST endpoint use?

A) `/api/{type}`

B) `/types/{type}`

X) Other (please describe after [Answer]: tag below)

[Answer]: B

## Question 2: "Add Info" Values 
Should the `Add Info` values be included in the returned string?

A) Append the value with a space, e.g. `OKA-lina PM` and `RAS-enhanced KO`

B) Return only the Mapping Result, ignoring the Add Info column

X) Other (please describe after [Answer]: tag below)

[Answer]: A

## Question 3: Unsupported Type
What should happen when `type` is not one of `HMS`, `OKA`, `UTA`, or `RAS`?

A) Return HTTP 400 Bad Request

B) Return HTTP 404 Not Found

X) Other (please describe the status and response body after [Answer]: tag below)

[Answer]: B

## Question 4: Type Matching
Should type values be case-sensitive?

A) Yes; accept only the exact uppercase values shown in the requirements

B) No; accept case-insensitive values and normalize them before mapping

X) Other (please describe after [Answer]: tag below)

[Answer]: B

## Question 5: Endpoint Access
What access-control expectation applies to this endpoint?

A) No authentication or authorization is required

B) Apply an existing authentication/authorization mechanism (please identify it after [Answer]:)

X) Other (please describe after [Answer]: tag below)

[Answer]: A

## Question 6: Integration-Test Execution
How should the required integration test exercise the endpoint?

A) Start the Spring application context and use MockMvc without opening a network port

B) Start the embedded server on a random port and send HTTP requests to it

X) Other (please describe after [Answer]: tag below)

[Answer]: B

## Question 7: Non-Functional Targets
Are there additional performance, availability, or operational targets for this endpoint?

A) No additional targets; use the existing service defaults

B) Yes; provide the specific targets after [Answer]:

X) Other (please describe after [Answer]: tag below)

[Answer]: A

## Question 8: Resiliency Extension
Should the resiliency baseline be applied to this project?

**What this extension is.** Enabling it applies directional, design-time best practices derived from the AWS Well-Architected Framework (Reliability Pillar) and resilience-review guidance. It steers requirements, design, and code toward fault tolerance, high availability, observability, and recoverability across 15 practice areas.

**What this extension is NOT.** It does not make the workload production-ready, certify it, or guarantee any availability, RTO, or RPO target. It is a starting point to validate and harden, not a substitute for a formal AWS Well-Architected Review.

A) Yes - apply the resiliency baseline as directional best practices and design-time guidance (recommended for business-critical workloads as an informed starting point to validate and harden before go-live)

B) No - skip the resiliency baseline (suitable for PoCs, prototypes, and experimental projects where rapid iteration matters more than reliability)

X) Other (please describe after [Answer]: tag below)

[Answer]: B

## Question 9: Security Extension
Should security extension rules be enforced for this project?

A) Yes - enforce all SECURITY rules as blocking constraints (recommended for production-grade applications)

B) No - skip all SECURITY rules (suitable for PoCs, prototypes, and experimental projects)

X) Other (please describe after [Answer]: tag below)

[Answer]: B

## Question 10: Property-Based Testing Extension
Should property-based testing (PBT) rules be enforced for this project?

A) Yes - enforce all PBT rules as blocking constraints (recommended for projects with business logic, data transformations, serialization, or stateful components)

B) Partial - enforce PBT rules only for pure functions and serialization round-trips (suitable for projects with limited algorithmic complexity)

C) No - skip all PBT rules (suitable for simple CRUD applications, UI-only projects, or thin integration layers with no significant business logic)

X) Other (please describe after [Answer]: tag below)

[Answer]: C

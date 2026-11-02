# Code Generation Plan - `type-mapping-api`

## Unit Context
- **Unit**: `type-mapping-api`
- **Workspace Root**: `C:\Work\Work Other Projects\AiDrivenDevelopmentWorkshop\AI-DLC-sample`
- **Project Type**: Brownfield Maven/Spring Boot application, Java 17.
- **Story**: ST-1.
- **Requirements**: `aidlc-docs/inception/requirements/requirements.md`.
- **Design**: `aidlc-docs/inception/application-design/`.
- **Dependencies**: Existing Spring Boot Web application; no other feature units.

## Generation Steps

### Step 1: Configure Test Dependencies and Integration-Test Execution
- [x] Update the existing root `pom.xml` to add the Spring Boot test starter for tests.
- [x] Configure Maven Failsafe to run `*IT` integration-test classes during `integration-test` and `verify`, preserving Java 17 and current application dependencies.
- [x] Keep changes limited to the existing single Maven module.

### Step 2: Generate the API Controller
- [x] Create `src/main/java/org/example/TypeMappingController.java`.
- [x] Add `POST /types/{type}` with an explicitly named `type` path variable and no required request body.
- [x] Implement case-insensitive mapping for all four required values, preserving the approved response strings and appended Add Info values.
- [x] Return the mapping string for supported values.
- [x] Handle unsupported types through the controller-scoped exception handler; return HTTP 404 with `text/plain` body `Unknown type: <original type>`.
- [x] Avoid changing `HomeController` and preserve `GET /home`.

### Step 3: Generate the Live-Server Integration Test
- [x] Create `src/test/java/org/example/TypeMappingControllerIT.java`.
- [x] Start the application with `@SpringBootTest(webEnvironment = RANDOM_PORT)`.
- [x] Send actual HTTP POST requests to the random-port embedded server.
- [x] Assert status and exact response body for all four mapping values.
- [x] Assert at least one lowercase or mixed-case supported input maps identically.
- [x] Assert an unsupported type returns HTTP 404, plain-text content, and `Unknown type: <supplied value>`.
- [x] Assert the existing GET `/home` endpoint still returns `Home page`.

### Step 4: Validate and Document
- [x] Run the Maven verification lifecycle so Failsafe executes the `IT` test.
- [x] Fix any failures caused by this change and rerun the targeted validation (initial run passed).
- [x] Update this plan and `aidlc-docs/aidlc-state.md` with completed steps.
- [x] Present the generated code for explicit approval before Build and Test.

## Validation Result
- **Command**: `mvn -q verify`
- **Result**: Passed.
- **Integration Test**: `TypeMappingControllerIT` - 4 tests, 0 failures, 0 errors, 0 skipped.

## Contract Traceability
- **FR-1**: Step 2 route and controller.
- **FR-2 / FR-3**: Step 2 mapping; Step 3 success and case-insensitive assertions.
- **FR-4**: Step 2 error handling; Step 3 unsupported-type assertion.
- **FR-5**: No authentication configuration is added.
- **FR-6**: Step 1 Failsafe setup and Step 3 live-server integration coverage.
- **Regression**: Existing GET `/home` assertion in Step 3.

## Plan Approval Gate
No production or test code is changed until the user explicitly approves this plan.

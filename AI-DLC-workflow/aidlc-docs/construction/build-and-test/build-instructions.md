# Build Instructions

## Prerequisites
- **Build Tool**: Maven; Java 17.
- **Dependencies**: Maven-resolvable dependencies declared in the root `pom.xml`.
- **Environment Variables**: None required.
- **System Requirements**: Java 17 and network/cache access for Maven dependencies as needed.

## Build Steps

### 1. Build and Verify
From the project root:

```powershell
mvn clean verify
```

This compiles application and test sources, runs the test lifecycle, and executes the Maven Failsafe integration-test goals.

### 2. Verify Build Success
- **Expected Output**: Maven exits with status 0 and reports `BUILD SUCCESS`.
- **Integration Test Report**: `target/failsafe-reports/`.
- **Build Artifacts**: Compiled classes under `target/classes/` and `target/test-classes/`.

## Troubleshooting

### Dependency Resolution Failure
- **Cause**: Maven repository access or local cache issue.
- **Solution**: Check Maven repository connectivity and rerun `mvn clean verify`.

### Compilation or Test Failure
- **Cause**: Source or test compilation errors, or an unmet assertion.
- **Solution**: Review Maven output and reports under `target/`, fix the failure, and rerun verification.

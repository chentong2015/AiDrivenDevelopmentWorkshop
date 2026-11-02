# Unit Test Execution

## Run Unit Tests

### Execute the Unit-Test Phase
```powershell
mvn test
```

This project currently has an integration test rather than a separate unit-test suite. Run `mvn verify` to execute the required Failsafe integration test.

### Review Results
- **Expected**: Any unit tests present pass.
- **Report Location**: `target/surefire-reports/`.

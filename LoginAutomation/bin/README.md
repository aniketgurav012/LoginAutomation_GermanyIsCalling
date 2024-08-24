# Login Automation Test

## Test Execution Steps

1. Clone the repository to your local machine.
2. Navigate to the project directory: `cd LoginAutomation`.
3. Ensure you have Maven installed.
4. Run the tests using Maven:
   ```
   mvn test
   ```
5. The test report will be generated in the `target/surefire-reports` directory.

## Assumptions

- The login page URL is assumed to be `https://www.example.com/login`.
- The test credentials (`validUsername`, `validPassword`) are assumed to be correct for a successful login.
- The error message ID is `errorMsg`, which is expected to display "Invalid username or password."

## Additional Information

- The project uses Selenium WebDriver for browser automation and TestNG for test management.
- WebDriverManager is used to handle the WebDriver binaries.

## Potential Improvements

- More test cases can be added for edge cases like empty fields or SQL injection attempts.
- The tests can be extended to cover different browsers using cross-browser testing strategies.

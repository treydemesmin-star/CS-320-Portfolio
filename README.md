# CS 320 Software Testing, Automation, and Quality Assurance Portfolio

## Portfolio Artifacts

This repository contains selected work from CS 320 Software Testing, Automation, and Quality Assurance. The Project One folder includes `Contact.java`, `ContactService.java`, `ContactTest.java`, and `ContactServiceTest.java`. These files demonstrate how I created a back-end contact service and used JUnit tests to verify that it met the customer’s requirements.

The Project Two folder contains my summary and reflections report. This report explains my unit testing approach, the testing techniques I used, the quality of my JUnit tests, and the lessons I learned about software testing and quality assurance.

My complete Project One test suite ran 68 tests with no failures, errors, or skipped tests. JaCoCo reported 100% coverage of all 484 instructions, 68 branches, 132 lines, 43 methods, and 6 production classes.

## How Can I Ensure That My Code, Program, or Software Is Functional and Secure?

I can ensure that software is functional by turning each requirement into one or more test cases. In the contact service, I tested normal operations such as creating, updating, and deleting contacts. I also tested invalid inputs, including null values, fields that exceeded their maximum lengths, phone numbers that were not exactly 10 digits, and duplicate contact IDs.

These tests helped verify both successful behavior and the way the program handled incorrect data. I used assertions to compare the actual results with the expected results. I also used `assertThrows` to confirm that invalid data produced an `IllegalArgumentException`.

I can improve security by validating all data before allowing it to enter the program and preventing objects from entering an invalid state. For example, the contact ID is required, cannot be longer than 10 characters, and cannot be updated after the contact is created. The service also rejects duplicate contact IDs.

Although this project did not include authentication, a database, or a network connection, the same defensive approach would apply to larger software systems. I would also use dependency scanning, static analysis, access controls, secure error handling, code reviews, and additional integration and security testing when those features are part of the application.

Testing and coverage reports support software quality, but I understand that 100% code coverage does not automatically prove that a program is completely secure or free from defects. The quality and purpose of the test cases are just as important as the coverage percentage.

## How Do I Interpret User Needs and Incorporate Them Into a Program?

I interpret user needs by separating broad requests into specific and measurable software requirements. For the contact service, the customer required a unique contact ID that could not be longer than 10 characters. The customer also required first and last names that could not be longer than 10 characters, a phone number containing exactly 10 digits, and an address that could not be longer than 30 characters.

The customer also needed the ability to add contacts, delete contacts by ID, and update approved fields without changing the contact ID. I incorporated these needs by adding validation rules to the `Contact` class and service operations to the `ContactService` class.

I then created positive, negative, and boundary tests for each requirement. Positive tests confirmed that valid data was accepted. Negative tests confirmed that invalid data was rejected. Boundary tests checked values at and immediately beyond the allowed limits.

This process helped me confirm that I was building what the customer requested instead of relying on assumptions. It also showed me why requirements must be clear, specific, and testable. When a requirement states an exact limit, I should test a valid value at the limit and an invalid value immediately beyond it.

## How Do I Approach Designing Software?

I approach software design by first understanding the requirements and then separating the program into small classes with focused responsibilities. In this project, the `Contact` class stores contact information and enforces the validation rules for its fields. The `ContactService` class manages the collection of contacts and performs add, update, and delete operations.

Keeping these responsibilities separate made the code easier to understand, test, and maintain. It also reduced unnecessary dependencies between different parts of the program.

I also design software with testing in mind. I worked incrementally by implementing a requirement, writing tests for expected and unexpected behavior, running the test suite, and correcting problems before moving forward. I used clear method names and avoided unnecessary repeated logic so that the purpose of the code remained easy to understand.

In future projects, I will continue using modular design, automated testing, code reviews, and coverage tools. I will also remember that meaningful test cases are more important than reaching a coverage percentage by itself. A strong software design should be understandable, maintainable, testable, and flexible enough to support future changes.

## AI Use Acknowledgment

I used OpenAI’s ChatGPT to help organize and revise portions of the written portfolio reflection. I reviewed the final content for accuracy and made sure it reflected my own project work, testing results, and understanding of the course material. No SNHU owned property was directly uploaded into ChatGPT.

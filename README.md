# Quantity Measurement Application
## Project Overview
This project demonstrates object-oriented design and equality comparison for length measurements in Java.

The application evolves step-by-step through use cases (UCs), starting from simple same-unit comparison to cross-unit equality handling.

The goal is to build a scalable and clean design while following core OOP principles and Java best practices.

## Branch Strategy
This project follows a feature-based branching strategy, where each use case is implemented in a dedicated branch.

Each branch represents a progressive enhancement of the application.

## Branch Links
### UC1 – Feet Measurement Equality

Branch: feature/UC1-FeetMeasurementEquality

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC1-FeetMeasurementEquality?authuser=0)

### UC2 – Feet and Inches Measurement Equality

Branch: feature/UC2-FeetAndInchesMeasurementEquality

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC2-FeetAndInchesMeasurementEquality?authuser=0)

### UC3 - Generic Quantity Class For DRY Principle

Branch: feature/UC3-GenericQuantityClassForDRYPrinciple

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC3-GenericQuantityClassForDRYPrinciple?authuser=0)

### UC4 - Extended Unit Support 

Branch: feature/UC4-ExtendedUnitSupport

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC4-ExtendedUnitSupport?authuser=0)

### UC5 - Unit-to-Unit Conversion

Branch: feature/UC5-UnitToUnitConversion

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC5-UnitToUnitConversion?authuser=0)

### UC6 - Addition of Two Length Units

Branch: feature/UC6-Addition-Of-Two-Length-Units

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC6-Addition-Of-Two-Length-Units?authuser=0)

### UC7 - Addition with Target Unit Specification

Branch: feature/UC7-Addition-With-Target-Unit-Specification

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC7-Addition-With-Target-Unit-Specification?authuser=0)

### UC8 - Refactoring Unit Enum to Standalone

Branch: feature/UC8-Refactoring-Unit-Enum-To-Standalone

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC8-Refactoring-Unit-Enum-To-Standalone?authuser=0)

### UC9 - Weight Measurement

Branch: feature/UC9-Weight-Measurement

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC9-Weight-Measurement?authuser=0)

### UC10 - Generic Quantity Class with Unit Interface

Branch: feature/UC10-Generic-Quantity-Class-with-Unit-Interface-For-Multi-Category-Support

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC10-Generic-Quantity-Class-with-Unit-Interface-For-Multi-Category-Support?authuser=0)

### UC11 - Volume Measurement Equality

Branch: feature/UC11-Volume-Measurement-Equality

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC11-Volume-Measurement-Equality?authuser=0)

### UC12 - Subtraction and Division Operations

Branch: feature/UC12-Subtraction-and-Division-Operations-on-Quantity-Measurements

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC12-Subtraction-and-Division-Operations-on-Quantity-Measurements?authuser=0)

### UC13 - Centralized Arithmetic Logic to Enforce DRY

Branch: feature/UC13-Centralized-Arithmetic-Logic-to-Enforce-DRY-in-Quantity-Operations

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC13-Centralized-Arithmetic-Logic-to-Enforce-DRY-in-Quantity-Operations?authuser=0)

### UC14 - Temperature Measurement with Selective Arithmetic Support

Branch: feature/UC14-Temperature-Measurement-with-Selective-Arithmetic-Support-and-Measurable-Refactoring

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC14-TemperaturE-Measurement-with-Selective-Arithmetic-Support-and-Measurable-Refactoring?authuser=0)

### UC15 - N-Tier Architecture Refactoring

Branch: feature/UC15-N-Tier

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC15-N-Tier?authuser=0)

### UC16 - Database Integration with JDBC

Branch: feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence?authuser=0)

### UC17 - Spring Backend for Quantity Measurement

Branch: feature/UC17-Spring-Backend-for-Quantity-Measurement

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC17-Spring-Backend-for-Quantity-Measurement?authuser=0)

### UC18 - Spring Backend for Quantity Measurement

Branch: feature/UC18-Google-Authentication-and-User-Management-for-Quantity-Measurement

Link: [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC18-Google-Authnetication-and-User-Management-for-Quantity-Measurement?authuser=0)

## Project Structure 
```
src/main/java/com/app/quantitymeasurement/

├── controller/        # REST APIs
├── service/           # Business logic
├── repository/        # Database layer
├── entity/            # JPA entities
├── dto/               # Request/Response objects
├── model/             # Core quantities (units)
├── security/          # JWT & OAuth configuration
├── exception/         # Custom exceptions
├── config/            # Spring configuration
└── util/              # Utility classes
```

## Use Case (UC) Breakdown
## UC1 – Feet Equality

- Implemented the basic functionality to compare two quantities measured in feet.
- This ensured that values with the same unit could be validated for equality.
- It served as the foundation for building more complex unit comparisons.

## UC2 – Inch Equality

- Extended the equality comparison logic to support inch measurements.
- Allowed accurate comparison between quantities expressed in inches.
- Helped generalize the equality mechanism beyond a single unit type.

## UC3 – Generic Length Equality

- Introduced a generic approach to compare different length units like feet and inches.
- Handled internal conversion before performing equality checks.
- Improved flexibility by allowing cross-unit comparisons within the same category.

## UC4 – Yard Equality

- Added support for yard as a new unit in the length category.
- Integrated the yard into the existing comparison and conversion logic.
- Ensured seamless equality checks across feet, inches, and yards.

## UC5 – Unit Conversion

- Implemented logic to convert values between compatible units.
- Used predefined conversion factors to maintain accuracy.
- Enabled operations like feet to inches and vice versa.

## UC6 – Addition of Quantities

- Developed functionality to add two quantities of the same category.
- Handled automatic conversion to a common unit before performing addition.
- Ensured accurate results irrespective of input units.

## UC7 – Target Unit Addition

- Enhanced addition operation by allowing results in a specified target unit.
- Converted both operands into the desired unit before computing the result.
- Improved usability by giving control over the output format.

## UC8 – Standalone Units

- Refactored the system to treat units as independent components.
- Improved modularity and reduced tight coupling between units.
- Made the system easier to extend with new measurement types.

## UC9 – Weight Measurement

- Introduced weight measurement category, including kilograms and grams. Enabled comparison, conversion, and arithmetic operations for weight units.
- Extended system capability beyond length measurements.

## UC10 – Generic Quantity Class

- Designed a reusable generic quantity class using interfaces.
- Allowed different unit types to be handled in a unified way.
- Improved code reusability and type safety across categories.

## UC11 – Volume Measurement

- Added support for volume units and their respective operations.
- Enabled conversion and comparison within the volume category.
- Further expanded the system to handle multiple measurement domains.

## UC12 – Subtraction & Division

- Implemented subtraction and division operations for quantities.
- Ensured operations are performed only on compatible unit types.
- Handled conversions internally to maintain accuracy.

## UC13 – Centralized Logic

- Refactored arithmetic operations into a centralized logic layer.
- Reduced code duplication and improved maintainability.
- Followed DRY (Don't Repeat Yourself) principles effectively.

## UC14 – Temperature Handling

- Introduced temperature measurement with special conversion logic.
- Restricted arithmetic operations were not logically valid.
- Handled edge cases like Celsius to Fahrenheit conversion.

## UC15 – N-Tier Architecture

- Structured the application into Controller, Service, and Repository layers.
- Ensured proper separation of concerns across the system.
- Improved scalability, readability, and maintainability of the codebase.

## UC16 – Database Integration

- Integrated database support using Spring Data JPA.
- Enabled persistent storage of measurement data.
- Supported both H2 (development) and MySQL (production).

## UC17 – Spring Framework Integration

- Leveraged Spring Boot features for dependency injection and configuration. 
- Simplified application setup and reduced boilerplate code.
- Improved overall development efficiency and structure.

## UC18 – OAuth Authentication

- Implemented secure authentication using JWT and Google OAuth.
- Allowed users to log in via an external authentication provider.
- Enhanced application security and user management capabilities.

## Sample Request

### Compare Quantities
```
{
  "q1": { "value": 1, "unit": "FEET" },
  "q2": { "value": 12, "unit": "INCH" }
}
```
### Convert Units
```
{
  "value": 100,
  "fromUnit": "CENTIMETER",
  "toUnit": "METER"
}
```
## Concepts Used
- Object-Oriented Programming (OOP)
- Generics in Java
- Interface-based design
- REST API design
- Dependency Injection (DI)
- Spring Security (JWT + OAuth)
- JPA & ORM Mapping

## Challenges Solved
- Designing a generic unit system for multiple categories
- Handling accurate unit conversions
- Ensuring type-safe arithmetic operations
- Implementing secure authentication flow
- Structuring project using clean architecture

## Author
Harshita Agrawal

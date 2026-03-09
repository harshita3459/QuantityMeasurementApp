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

**Branch:** feature/UC1-FeetMeasurementEquality

**Link:**  [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC1-FeetMeasurementEquality)

### UC2 – Feet and Inches Measurement Equality

**Branch:** feature/UC2-FeetAndInchesMeasurementEquality

**Link:** [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC2-FeetAndInchesMeasurementEquality)

### UC3 - Generic Quantity Class For DRY Principle

**Branch:** feature/UC3-GenericQuantityClassForDRYPrinciple

**Link:** [Click here](https://github.com/harshita3459/QuantityMeasurementApp/tree/feature/UC3-GenericQuantityClassForDRYPrinciple?authuser=0)

## UC1 – Feet Measurement Equality
### Objective

Implement equality comparison for measurements in Feet.

The system should determine whether two length measurements in feet are equal based on their value.

### Problem Statement

Two length measurements with the same numeric value in feet should be considered equal.

For example:

1.0 feet = 1.0 feet → TRUE
1.0 feet ≠ 2.0 feet → FALSE

## Implementation Approach
### 1. Created a Feet Class

- Stores a double value
- The constructor initializes the value
- Getter method to access the value

### 2. Overrode equals() Method

- The equality logic ensures:
- Reflexive property (object equals itself)
- Null safety
- Type safety (only compare with Feet objects)
- Value-based comparison using Double.compare()

### 3. Overrode hashCode()

- Ensures consistency with equals() method as per Java contract.

## Key Concepts Applied

- Encapsulation
- Method overriding
- Equality contract
- Null safety
- Floating-point comparison handling
- Object-oriented design fundamentals

## Outcome

The system correctly performs value-based equality comparison for measurements expressed in feet.

## UC2 – Feet and Inches Measurement Equality
### Objective

Extend the equality comparison to support measurements in both Feet and Inches.

The system should determine whether two length measurements are equal, even if they are expressed in different units (Feet or Inches).

### Problem Statement

Two length measurements representing the same physical length should be considered equal, regardless of their unit.

For example:

1.0 feet = 1.0 feet → TRUE  
1.0 inch = 1.0 inch → TRUE  
1.0 feet = 12.0 inches → TRUE  
1.0 feet ≠ 2.0 feet → FALSE  
1.0 inch ≠ 2.0 inches → FALSE  

## Implementation Approach
### 1. Created Feet and Inches, Classes

- Each class stores a double value
- The constructor initializes the value
- The getter method provides controlled access to the value
- Both classes encapsulate their own data

### 2. Implemented Cross-Unit Equality Logic

- Overrode the equals() method in both classes
- Equality logic handles:
  - Reflexive property (object equals itself)
  - Null safety
  - Type safety (only compare with supported measurement types)
  - Same-unit comparison using Double.compare()
  - Cross-unit comparison using conversion logic

### 3. Conversion Logic

- To enable cross-unit comparison:
  - 1 Foot = 12 Inches
- During comparison:
  - Feet can be converted to Inches

   OR

  - Inches can be converted to Feet

- Conversion is done before value comparison to ensure accuracy.

- Example conversion logic:

   feetValue = inches / 12

   inchesValue = feet × 12

### 4. Overrode hashCode()

- Ensures consistency with equals()
- Maintains Java equality contract
- Prevents unexpected behavior in collections

## Key Concepts Applied

- Encapsulation
- Method overriding
- Cross-unit equality logic
- Equality contract (reflexive, symmetric, transitive, consistent)
- Null safety
- Type safety
- Floating-point comparison handling
- Unit conversion logic
- Object-oriented design principles

## Outcome

The system now supports equality comparison between:

  - Feet ↔ Feet
  - Inches ↔ Inches
  - Feet ↔ Inches
  - Equality logic is mathematically correct.
  - All equality contract rules are preserved.
  - The design remains clean and maintainable.
  - UC1 functionality remains fully intact and backward compatible.

## UC3 – Generic Quantity Class for DRY Principle
### Objective

Refactor the existing Feet and Inches classes into a single generic QuantityLength class to eliminate code duplication and follow the DRY (Don't Repeat Yourself) principle.

The system should represent any length measurement using a value and unit type while maintaining all equality functionality from UC1 and UC2.

### Problem Statement

In UC1 and UC2, separate classes (Feet and Inches) were used for each unit.
Both classes had almost identical code, such as:

- Similar constructors
- Identical equals() implementations
- Similar value handling logic
- This violated the DRY principle and made the code harder to maintain.

UC3 solves this by introducing a generic measurement class that can handle multiple units.

Example:

Quantity(1.0, FEET) = Quantity(12.0, INCHES) → TRUE

Quantity(1.0, INCHES) = Quantity(1.0, INCHES) → TRUE

## Implementation Approach
### 1. Created a LengthUnit Enum
An enum is used to define supported length units and their conversion factors relative to a base unit.
Base unit chosen: Feet
Supported units:

- FEET
- INCHES
- YARDS
- CENTIMETERS

Each unit contains a conversion factor to feet.

Example:

- FEET → 1.0
- INCHES → 1 / 12
- YARDS → 3.0
- CENTIMETERS → 0.0328084

The enum also provides a method to convert values to the base unit.

### 2. Created a Generic QuantityLength Class
Instead of multiple classes, UC3 introduces a single class to represent all length measurements.
The class contains:

- double value
- LengthUnit unit
- Constructor validates:
- Value must be numeric
- Unit cannot be null

This allows the system to represent measurements like:

- Quantity(1.0, FEET)
- Quantity(12.0, INCHES)
- Quantity(3.0, YARDS)
- Quantity(2.54, CENTIMETERS)

### 3. Base Unit Conversion
To compare measurements across different units, values are converted to the base unit (feet).

Conversion is performed using the conversion factor defined in the enum.

Example conversion:

feetValue = value × conversionFactor

This ensures that all measurements are compared using a common reference.

### 4. Implemented Equality Logic
The equals() method is overridden to perform value-based comparison.

Equality logic ensures:

- Reflexive property (object equals itself)
- Null safety
- Type safety
- Cross-unit comparison using base unit conversion
- Two objects are considered equal if their converted base unit values are the same.

Example:

1 Foot == 12 Inches
1 Yard == 3 Feet

### 5. Overrode hashCode()
The hashCode() method is implemented using the converted base unit value.

This ensures consistency with the equals() method and prevents issues when using objects in collections.

### 6. Implemented toString() Method
A custom toString() method provides a readable representation of the object.

Example output:

Quantity(1.0, feet)
Quantity(12.0, inches)

This improves debugging and logging readability.

## Key Concepts Applied

- DRY Principle (Don't Repeat Yourself)
- Code refactoring
- Enum usage for unit representation
- Encapsulation
- Abstraction
- Object-oriented design principles
- Value-based equality
- Floating-point comparison handling
- Equality contract (reflexive, symmetric, transitive, consistent)
- Type safety
- Scalable design for future units

## Outcome

- Code duplication between Feet and Inches classes is eliminated.
- A single QuantityLength class now handles all length measurements.
- Equality comparison works for multiple units.
- The system becomes more maintainable and scalable.
- All functionality from UC1 and UC2 remains fully supported.
- New units can be added easily through the LengthUnit enum.

## Author
Harshita Agrawal

# S.O.L.I.D

> Solid is a set of principles that help us to build object-oriented applications in a more organized, scalable and responsibly defined way.

## Cohesion

- A cohesive class do one thing well

## Encapsulation

- Getters and setters are not efficient ways of applying encapsulation
- It's good to give access only for to the needed features of our classes
- Encapsulation makes our classes simpler

## Coupling

- Coupling is the dependency between classes
- Coupling is not always bad, and that it is impossible to create a system without any coupling
- We must control the coupling level in our application

## What problems are solved or avoided by applying SOLID?

Software may start with a clean and elegant design but over time they become hard to maintain, often requiring costly redesigns. Robert Martin, points out some symptoms of rotting design due to improperly managed dependencies acros modules:

- **Rigidity:** Implementing even a small change is difficult since it's likely to translate into a cascade of changes
- **Fragility:** Any change tends to break the software in many places, even in areas not conceptually related to the change
- **Immobility:** We're unable to reuse modules from other projects or within the same project because those modules have lots of dependencies
- **Viscosity:** When code changes are needed, developers will prefer the easier route even if they break exisiting design

Antipatterns and improper understanding of design principles can lead to problematic code: Singleton, tight coupling, untestability, premature optimization, indescriptive naming and duplication. SOLID can help devs stay clear of these.

The essence of solid is managing dependencies. This is done with interfaces and abstractions. Modules and classes should not be tightly coupled.

## Single Responsibility Principle

- A class should have one, and only one, reason to change.
  - Robert C. Martin aka Uncle Bob
```java
public class Employee {
  private String empId;
  private String name;
  private string address; 
 
  public boolean isPromotionDueThisYear() {
    // promotion logic
  }
 
  // Getters & Setters
}

/* Applying SRP */

public class PromotionService {
  public boolean isPromotionDueThisYear(Employee employee) {
    // promotion logic
  }
}
 
public class Employee {
  private String empId;
  private String name;
  private string address;   
 
  // Getters & Setters
}
```

## Open/Closed Principle

- Software entities (classes, modules, functions, etc.) must be open for extension, but closed for modification
  - Bertrand Meyer
- A class is considered to be closed if changes are guaranteed to not happen. It can be used as a base class which can be extended by child classes
- A class is considered to be open if its functionality can be enhanced by its subclasses
```java
public class Rectangle {
  public double length;
  public double width;
}

public class Circle {
  public double radius; 
}

public class AreaCalculator {
  public double calculateRectangleArea(Rectangle rectangle) {
    return rectangle.length * rectangle.width;
  }
  
  public double calculateCircleArea(Circle circle) {
    return (22 / 7) * circle.radius * circle.radius;
  } 
}

/* Applying OCP */

public interface Shape {
  public double calculateArea();
}
 
public class Rectangle implements Shape {
  public double length;
  public double width;
  
  public double calculateArea() {
    return length * width;
  }
}
 
public class Circle implements Shape {
  public double radius;
  
  public double calculateArea() {
    return (22 / 7) * radius * radius;
  }
}
```

## Liskov Substitution Principle

- If q(x) is a provable property of objects and of type T, then q(y) must be true for objects and of type S, where S is a subtype of T
  - Barbara Liskov
- Although inheritance favors code reuse, it can have side effects when not used correctly
- Liskov Substitution Principle (LSP) says that we should be able to replace base classes with their derived classes anywhere, no problem
- For example we have `Animal` class with a `makeNoise()` method then any subclass of Animal should implement `makeNoise()`

## Interface Segregation Principle

- A class shouldn't be forced to rely on methods it won't use
  - Robert C. Martin aka Uncle Bob
- Separating interfaces for the real use, not forcing the client implement it
```java
public interface GenerateReport{
  public void generateExcel();
  public void generatePDF();
}

/* Applying ISP */

public interface ExcelReport {
  public void generateExcel();
}

public interface PDFReport {
  public void generatePDF();
}
```

## Dependency Inversion Principle

- Abstractions should not depend on implementations. Implementations must rely on abstractions
  - Robert C. Martin aka Uncle Bob
```ts
interface Person {
  introduceSelf(): void;
}

class Doctor implements Person {
  public introduceSelf() {
    console.log('I am a Doctor');
  }
}

class ITEngineer implements Person {
  public introduceSelf() {
    console.log('I am an IT Engineer');
  }
}

/* Applying DIP */

class Person {
  // Person properties
}

interface Introduction {
  introduce(): void;
}

class EngineerIntroductionService implements Introduction {
  public introduce() {
    console.log("I'm a Engineer");
  }
}


class ITEngineerIntroductionService implements Introduction {
  public introduce() {
    console.log("I'm a IT Engineer");
  }
}

class Engineer extends Person {
  private introductionService: EngineerIntroductionService;
 
  constructor(introductionService: EngineerIntroductionService) {
    super();
    this.introductionService = introductionService;
  }
 
  public introduceSelf() {
    this.introductionService.introduce();
  }
}

class ITEngineer extends Person {
  private introductionService: ITEngineerIntroductionService;
 
  constructor(introductionService: ITEngineerIntroductionService) {
    super();
    this.introductionService = introductionService;
  }
 
  public introduceSelf() {
    this.introductionService.introduce();
  }
}

const engineer = new Engineer(new EngineerIntroductionService());
const itEngineer= new ITEngineer(new ITEngineerIntroductionService());

engineer.introduceSelf();
itEngineer.introduceSelf();
```

## Useful links:

- [SOLID Design Principles](https://devopedia.org/solid-design-principles)
- [SOLID design principles in java](https://www.w3schools.blog/solid-design-principles-java)
- [SOLID Principles with TypeScript](https://javascript.plainenglish.io/solid-principles-with-type-script-d0f9a0589ec5)

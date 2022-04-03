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

## Single Responsibility Principle

- A class should have one, and only one, reason to change.
  - Robert C. Martin aka Uncle Bob

## Open/Closed Principle

- Software entities (classes, modules, functions, etc.) must be open for extension, but closed for modification
  - Bertrand Meyer

## Liskov Substitution Principle

- If q(x) is a provable property of objects and of type T, then q(y) must be true for objects and of type S, where S is a subtype of T
  - Barbara Liskov
- Although inheritance favors code reuse, it can have side effects when not used correctly
- Liskov Substitution Principle (LSP) says that we should be able to replace base classes with their derived classes anywhere, no problem

## Interface Segregation Principle

- A class shouldn't be forced to rely on methods it won't use
  - Robert C. Martin aka Uncle Bob

## Dependency Inversion Principle

- Abstractions should not depend on implementations. Implementations must rely on abstractions
  - Robert C. Martin aka Uncle Bob

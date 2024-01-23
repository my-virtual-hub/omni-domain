<img src="images/logo_reduzido.png" alt="Image">

# OmniCommunicator - Domain Layer

Welcome to the domain layer repository of the OmniCommunicator!

The OmniCommunicator is an independent communication orchestration system, designed with a hexagonal architecture to ensure flexibility and robustness. Developed in Java, it enables communication sending across a variety of providerChannels - SMS, email, WhatsApp, inApp, Push, and more!

This repository contains the core domain logic of the OmniCommunicator. Here, you will find the fundamental business rules that are agnostic to any specific framework or technology, allowing the OmniCommunicator to operate consistently across a variety of contexts.

One of the key benefits of the OmniCommunicator is its flexibility and extensibility. It can be connected to any service provider, provided the corresponding library is developed. This means you can extend the OmniCommunicator to support new communication providerChannels or service providers as needed. Additionally, it can be extended to support provider-specific property and rules, allowing for deeper, custom integration with each service provider.

<img src="images/imagem_readme_reduzido.png" alt="Image" >

## Table of Contents
- [Domain-Driven Design (DDD) and SOLID](#domain-driven-design-ddd-and-solid)
- [Independent Project](#independent-project)
- [Features](#features)
- [Getting Started](#getting-started)
- [Using SonarCloud for Code Quality](#using-sonarCloud-and-qodana-for-code-quality)
- [Contact](#contact)

## Domain-Driven Design (DDD) and SOLID

The OmniCommunicator is built following the principles of Domain-Driven Design (DDD) and SOLID.

DDD is an approach to software development that focuses on creating a rich, expressive domain model that reflects the logic and complexity of the business. This helps ensure that the software we create effectively solves real-world problems.

SOLID is an acronym for five principles of object-oriented design and classes that help make code more flexible, modular, and reusable. These principles are:

- **Single Responsibility Principle (SRP):** A class should have only a single responsibility.
- **Open-Closed Principle (OCP):** Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.
- **Liskov Substitution Principle (LSP):** Derived classes must be substitutable for their base classes.
- **Interface Segregation Principle (ISP):** Clients should not be forced to depend on interfaces they do not use.
- **Dependency Inversion Principle (DIP):** Depend on abstractions, not on concretions.

By following these principles and practices, we hope to create high-quality software that is easy to maintain, extend, and adapt to changes in business needs.

## Independent Project

This is an independent project and its evolution will depend on availability. We are open and welcome any help from the community. Whether contributing code, reporting bugs, suggesting improvements, or simply using the project, your participation is welcome and appreciated!

## Features

- **Multichannel:** The OmniCommunicator supports a variety of communication providerChannels, including SMS, email, WhatsApp, inApp, and Push. This allows you to reach your users wherever they are, in the way that is most convenient for them.
- **Flexible and Extensible:** The OmniCommunicator can be connected to any service provider, provided the corresponding library is developed. It can also be extended to support provider-specific property and rules.
- **Hexagonal Architecture:** The OmniCommunicator is built with a hexagonal architecture, meaning that business logic and application logic are kept separate. This allows for greater flexibility and makes the system easier to maintain and evolve.
- **Made in Java:** Developed in Java, the OmniCommunicator takes advantage of the robustness, maturity, and portability of this language.

## Getting Started

This repository contains the domain layer of the OmniCommunicator. To see the project in action, you will also need the corresponding repositories for the application and infrastructure layers.

We are excited to see how the OmniCommunicator will be used and evolve. Whether you're a communications enthusiast, a Java learner, or a software architect, we hope you find this project useful and inspiring. We look forward to receiving your feedback and contributions!

Together, let's revolutionize the way communications are orchestrated!

## Prerequisites

Before you begin, ensure you have met the following requirements:

- You have installed Java 17.0.9 or higher. You can check your Java version with the command `java -version` in your command line interface. If you don't have it installed, you can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or install it via a package manager.
- You have installed Apache Maven 3.6.3 or higher. You can check your Maven version with the command `mvn -version` in your command line interface. If you don't have it installed, you can download it from the [official Apache Maven website](https://maven.apache.org/download.cgi) or install it via a package manager.

These are essential tools for building and managing the project. The project uses Java 17.0.9 or higher for its development and Apache Maven 3.6.3 or higher for its dependency management and build automation.

## Using SonarCloud and Qodana for Code Quality

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) 
[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=my-virtual-hub_omni-domain)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) [![Qodana](https://github.com/my-virtual-hub/omni-comm-domain/actions/workflows/qodana.yml/badge.svg?branch=main)](https://github.com/my-virtual-hub/omni-comm-domain/actions/workflows/qodana.yml) 

| Quality Metrics | Code Metrics | Security Metrics |
|---|---|---|
| [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) | [![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) | [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) |
| [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=coverage)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) | [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) | [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=bugs)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) |
| [![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) | [![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) | [![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) |
| | [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) | |
| | [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=my-virtual-hub_omni-domain&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=my-virtual-hub_omni-domain) | |

## License

Omni Communicator is Open Source software released under the [Apache 2.0 license](https://www.apache.org/licenses/LICENSE-2.0.html).

## Contact

<ul>
  <img src="images/marco.png" alt="Image">
</ul>

- Email: [marco.quicula@quicula.com.br](mailto:marco.quicula@quicula.com.br)
- Website: [www.quicula.com.br](http://www.quicula.com.br)
- LinkedIn: [https://www.linkedin.com/in/marco-quicula/](https://www.linkedin.com/in/marco-quicula/)
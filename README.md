# ONBOARDING BACKEND

## Prérequis

Before you start, make sure you have the following tools installed on your machine:

- Java 21
- Maven
- MySQL

Project use flyway for DB migration

## Installation

### Clone projet

```bash ```
- git clone https://votre-url-de-repository.git
- cd nom-du-dossier

### Install dependancies
```bash ```
- mvn install

### Configuration
Edit application.yml file to configure database access.

## Run
mvn spring-boot:run
By default, the application run on `http://localhost:80`

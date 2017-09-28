# Involves Challenge

Project proposed by Involves in order to select candidates to developer position.
It's a CSV reader which an user may interact by typing pre-defined commands in order to visualize data.

## Gettind Started

By default the dataset is already included in the project. In order to run it, follow the steps below.

## Prerequisites

The followings items are required:
- [Java 8](https://www.java.com/pt_BR/download/faq/java8.xml)
- [Gradle](https://gradle.org/)

## Installing

First, you need to clone the following [repository](https://github.com/claytonrm/InvolvesChallenge.git). Then, you will need to compile using 
```
gradle build
```

## Running the Tests

In order to run the tests you will need junit, which will be downloaded by gradle. Just execute the following command

```
gradle test
```

## Running the Project

In order to run the project you will need to run the following command:

```
java -jar build/libs/dataset-assistant-1.0.jar
```
after that, you can use one of the parameters

- **count** * - writes on the console the total amount of imported records (neglecting the header)
- **count distinct [property]** - writes on the console the total amount of distinct values of the given property (column)
- **filter [property] [value]** - writes on the console the header and every row that contains the given value

### Example of usage

If you want to find Florianópolis city in the dataset:

```
java -jar build/libs/dataset-assistant.jar
```
Wait a second and type:
```
filter [name] [Florianópolis]
```

### Authors

* Clayton R. Mendonça - [GitHub](https://github.com/claytonrm/) [LinkedIn](https://www.linkedin.com/in/claytonmendonca/)

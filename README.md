# Java Sample App

## Description

This is a simple java sample app to experiment the usage of spring boot with a Domain Driven Design implementation

## Usage

### IDE Run

```sh
docker-compose up postgres-container
```

After running the previous command you can run the application in your IDE.
You will also need to update the `application.properties` file to point to `localhost`.

### Standalone Run

```sh
./gradlew build && docker-compose build && docker-compose up
```

### Build

```sh
./gradlew build 
```

### Tests

```sh
./gradlew test 
```

## Notes

This sample intends only to exemplify the usage of spring boot and development tools and libraries. 
Some of the patterns used are not the most appropriate for a production application.

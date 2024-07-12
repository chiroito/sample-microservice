# sample-microservice

## Resource

This project is an application that runs as a destination to connect to with a REST Client.

This project has two functions
One is an echo server.
The other is a response with delay.

# Echo server
The echo server includes a message in the request and returns a response containing that message.
This resource is provided at the URL `/echo`.

To make the message `Hello`, the URL would be `/echo/Hello`.
This will return the following message.
```json
{
   "message" : "Hello"
}
```

# Response with delay

A response with a delay is one that includes the time you want to delay in the request, and will respond after that time has elapsed.
This resource is provided at the URL `/latency`.

This resource can be specified in seconds and milliseconds.
Seconds is `/latency/s` and milliseconds is `/latency/ms`.

Specify the time after this URL.
For a stop of 500 milliseconds, the URL would be `/latency/ms/500`.

The response will always be the following message.
```json
{
   "message" : "Hello"
}
```


# For developing

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

Since this application is intended to work with other applications, please specify the following as runtime arguments to avoid port number conflicts.

```
-Dquarkus.http.port=8082
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/sample-microservice-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Java Flight Recorder (JFR) ([guide](https://quarkus.io/guides/jfr)): Monitor your applications with Java Flight Recorder

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

# OpenFeature Java Example Code

Example code using Split as the OpenFeature backend.

## Build & run

Copy `env.example` to `.env` and add your API key, and the name of the feature flag you want to use. After you can run
the app.

### Run via Maven

```
$ mvn compile exec:java -Dexec.mainClass="com.company.Main"
```

### Run from jar

```
$ mvn clean package
$ java -jar target/java_openfeature_test-1.0-SNAPSHOT-jar-with-dependencies.jar
```

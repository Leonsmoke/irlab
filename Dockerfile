ARG VERSION=8u151

FROM openjdk:${VERSION}-jdk as BUILD

COPY . /src
WORKDIR /src
RUN chmod +x gradlew
RUN ./gradlew --no-daemon shadowJar

FROM openjdk:${VERSION}-jre

COPY --from=BUILD /src/build/libs/irlab-0.0.1-SNAPSHOT-all.jar /bin/runner/run.jar
WORKDIR /bin/runner
EXPOSE 8080
CMD ["java","-jar","run.jar"]
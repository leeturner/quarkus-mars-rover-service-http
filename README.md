# Quarkus Mars Rover Http Service

This service returns a list of [Mars Rover](https://en.wikipedia.org/wiki/Mars_rover) names in json in the following
format:

```json
[
  {
    "id": 0,
    "name": "Spirit"
  },
  {
    "id": 1,
    "name": "Opportunity"
  },
  {
    "id": 2,
    "name": "Curiosity"
  },
  {
    "id": 3,
    "name": "Perseverance"
  },
  {
    "id": 4,
    "name": "Sojourner"
  }
]
```

It is designed to be consumed using the [mars rover cli](https://github.com/wiremock/quarkus-mars-rover-cli-http) to output those names to the command line.  These two 
applications combined show how http services can be mocked using [WireMock](https://wiremockk.org) and the Quarkus
[WireMock dev service](https://docs.quarkiverse.io/quarkus-wiremock/dev/index.html).

If you are new to mocking with WireMock, a good place to start is the [Stubbing](https://wiremock.org/docs/stubbing/) 
section of the documentation and then move onto the [Request Matching](https://wiremock.org/docs/request-matching/) and
[Response Templating](https://wiremock.org/docs/response-templating/) sections.

## WireMock Cloud
[WireMock Cloud](https://www.wiremock.io/?utm_source=github&utm_medium=referral&utm_campaign=quarkus-insights&utm_term=quarkus-mars-rover-service-http)
is a managed, hosted version of WireMock, developed by the same team who wrote the open-source project. It's built on 
the same technology that powers open source WireMock and is 100% compatible with the WireMock API, with additional 
features that make it quick and easy to mock any API you depend on. WireMock Cloud also introduces advanced capabilities 
such as chaos engineering, mock creation from openAPI spec, contract testing, import data from CSV files and the newer 
stateful mock functionality, as well as better collaboration and user management.  WireMock Cloud has a free forever 
plan so take a look and see how WireMock Cloud can fit into your SDLC.

## Quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

### Making Requests

You can find a collection of requests in the form of a JetBrains [http file](/src/test/http/rover-requests.http) in the
`src/test` folder.  This will allow you to make requests and see the responses returned.  These can be converted to 
`curl` if required:

```bash
curl -X GET --location "http://localhost:8080/rovers"
```

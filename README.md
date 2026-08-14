# Currency Converter

A Spring Boot REST API learning project that converts an amount between two currencies using **live
exchange rates** from the [Frankfurter](https://frankfurter.dev) API, with in-memory caching.

## Stack

| | |                                                                                                          
|---|---|
| Java | 25 |
| Spring Boot | 4.1.0 (Spring Framework 7) |
| Build | Maven (wrapper included) |
| Cache | Caffeine |
| Docs | springdoc-openapi 3.1.0 |
| Rates | [api.frankfurter.dev](https://api.frankfurter.dev) |

## Run the API

Requires JDK 25 on your `PATH`. No API key is needed.
```bash
./mvnw spring-boot:run
```

The app starts on <http://localhost:8080>.

```bash
./mvnw test      # run the test suite
./mvnw package   # build an executable jar into target/
```

## API documentation

While app is running:

| Swagger UI | <http://localhost:8080/swagger-ui.html> |
| OpenAPI spec (JSON) | <http://localhost:8080/v3/api-docs> |
| OpenAPI spec (YAML) | <http://localhost:8080/v3/api-docs.yaml> |

Swagger UI is the quickest way to visualize the endpoint. There are prefilled examples that you can
execute from the browser, or enter valid custom currencies and amounts.

## Endpoint

### `GET /convert`

| Parameter | Type | Required | Constraint | Example |
|---|---|---|---|---|
| `from` | string | yes | exactly 3 letters | `USD` |
| `to` | string | yes | exactly 3 letters | `EUR` |
| `amount` | number | yes | must be positive | `100` |

Currency codes are case-insensitive on input and echoed back in uppercase.

**Success — `200 OK`**

```bash
curl "http://localhost:8080/convert?from=USD&to=EUR&amount=100"
```

```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100.0,
  "rate": 0.86453,
  "result": 86.453
}
```

Rates are live, so `rate` and `result` will differ from the values above.

**Validation failure — `400 Bad Request`** (`text/plain`)

```bash
curl "http://localhost:8080/convert?from=US&to=EUR&amount=-5"
```

```
from: must match "[A-Za-z]{3}"; amount: must be greater than 0
```

Every failing parameter is reported in one response rather than just the first.

**Unknown currency — `400 Bad Request`** (`text/plain`)

```bash
curl "http://localhost:8080/convert?from=USD&to=ZZZ&amount=100"
```

```
Unknown currency: ZZZ
```

## Roadmap

- [x] Conversion endpoint with hardcoded rates
- [x] Unknown-currency handling via `@ControllerAdvice`
- [x] Externalized rate configuration
- [x] Live rates from Frankfurter
- [x] Caching with Caffeine
- [x] Bean Validation, `ConversionResponse`, OpenAPI docs
- [ ] Unit and web-layer tests
- [ ] Conversion history persisted with JPA
- [ ] Docker packaging and CI

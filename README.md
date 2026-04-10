# Demo Spring Boot App

Kleine Demo-Anwendung zum Ausprobieren von GitHub Actions fuer Build und Tests.

Verwendete Basis:

- Spring Boot 4.0.5
- Java 21 LTS
- Maven Wrapper mit Apache Maven 3.9.14

## REST APIs

- `GET /api/hello?name=Name`
- `GET /api/status`
- `POST /api/echo`

Beispiel fuer `POST /api/echo`:

```json
{
  "message": "build and test"
}
```

## Lokal ausfuehren

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Tests ausfuehren:

```powershell
.\mvnw.cmd test
```

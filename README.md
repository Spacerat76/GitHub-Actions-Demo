# Demo Spring Boot App

[![Maven CI](https://github.com/Spacerat76/GitHub-Actions-Demo/actions/workflows/maven.yml/badge.svg)](https://github.com/Spacerat76/GitHub-Actions-Demo/actions/workflows/maven.yml)

Kleine Demo-Anwendung zum Ausprobieren von GitHub Actions fuer Build und Tests.

Verwendete Basis:

- Spring Boot 4.0.5
- Java 21 LTS
- Maven Wrapper mit Apache Maven 3.9.14

## Qualitaets- und Security-Checks

Dieses Repository nutzt mehrere GitHub-Actions-Checks als schlanken Ersatz fuer ein groesseres SonarQube-Setup:

- `build (ubuntu-latest)` und `build (windows-latest)` bauen und testen die Anwendung auf beiden Plattformen.
- `coverage` erzeugt JaCoCo-Coverage, prueft Gesamt- und Diff-Coverage fuer geaenderten Code und kommentiert die Werte in Pull Requests.
- `quality` fuehrt Checkstyle, PMD und SpotBugs aus. In Pull Requests blockieren nur neue Findings gegen den Basis-Branch.
- `dependency-review` prueft neu eingefuehrte Abhaengigkeiten auf bekannte Risiken.
- Dependabot erstellt regelmaessig Update-Pull-Requests fuer Maven-Abhaengigkeiten und GitHub Actions.
- `analyze (java-kotlin)` fuehrt CodeQL aus und sucht nach Security- und Dataflow-Problemen.

Alle diese Checks sind fuer Pull Requests nach `main` als Pflicht-Checks hinterlegt.

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

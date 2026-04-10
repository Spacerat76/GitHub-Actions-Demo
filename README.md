# Demo Spring Boot App

[![Maven CI](https://github.com/Spacerat76/GitHub-Actions-Demo/actions/workflows/maven.yml/badge.svg)](https://github.com/Spacerat76/GitHub-Actions-Demo/actions/workflows/maven.yml)

Kleine Demo-Anwendung zum Ausprobieren von GitHub Actions fuer Build, Tests, Qualitaets- und Security-Checks.

Verwendete Basis:

- Spring Boot 4.0.5
- Java 21 LTS
- Maven Wrapper mit Apache Maven 3.9.14

## Qualitaets- und Security-Checks

Dieses Repository nutzt mehrere GitHub-Actions-Checks als schlanken Ersatz fuer ein groesseres SonarQube-Setup:

- `build (ubuntu-latest)` und `build (windows-latest)` bauen und testen die Anwendung auf beiden Plattformen.
- `coverage` erzeugt JaCoCo-Coverage, prueft mindestens 90% Line-Coverage, 80% Branch-Coverage und 90% Diff-Coverage auf geaenderten ausfuehrbaren Zeilen in Pull Requests.
- `quality` fuehrt Checkstyle, PMD und SpotBugs aus. In Pull Requests blockieren nur neue Findings gegen den Basis-Branch.
- `dependency-review` prueft neu eingefuehrte Abhaengigkeiten auf bekannte Risiken und bekannte Sicherheitsprobleme.
- Dependabot erstellt regelmaessig Update-Pull-Requests fuer Maven-Abhaengigkeiten und GitHub Actions. Dependabot Security Updates fuer bekannte Sicherheitsluecken sind ebenfalls aktiviert.
- `analyze (java-kotlin)` fuehrt CodeQL aus und sucht nach Security- und Dataflow-Problemen.

Alle diese Checks sind fuer Pull Requests nach `main` als Pflicht-Checks hinterlegt. Fuer `main` ist ausserdem Branch Protection mit mindestens einem Review aktiv.

## Pull-Request-Feedback

Pull Requests erhalten sticky Kommentare direkt von GitHub Actions, damit die wichtigsten Ergebnisse ohne Oeffnen einzelner Workflow-Runs sichtbar bleiben:

- `coverage` kommentiert PR- und Basis-Branch-Coverage, Deltas und die Diff-Coverage der geaenderten ausfuehrbaren Zeilen.
- `quality` kommentiert Checkstyle-, PMD- und SpotBugs-Ergebnisse und blockiert nur neue Findings.
- `dependency-review` kommentiert, ob neue Abhaengigkeiten unkritisch sind oder Risiken mitbringen.
- `CodeQL` kommentiert den Status der Security-Analyse fuer den Pull Request.

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

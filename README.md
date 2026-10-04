# Assignment 3: Bridge Pattern
Tursyn Maksat
SE-2528

- **Repository:** https://github.com/mxx567/sdp_assignment3
- **Topic:** C — Reports
- **Base commit hash:** `5eb60ef0b6fc87208792b2687467a13abb047ed1`

## Class Role Map

| Role | Class / Interface | Source path |
|---|---|---|
| Abstraction | `Report` | `src/Report.java` |
| A1 | `AttendanceReport` | `src/AttendanceReport.java` |
| A2 | `GradeReport` | `src/GradeReport.java` |
| Implementor | `Formatter` | `src/Formatter.java` |
| I1 | `TextFormatter` | `src/TextFormatter.java` |
| I2 | `HTMLFormatter` | `src/HTMLFormatter.java` |
| I3 | `MarkdownFormatter` | `src/MarkdownFormatter.java` |
| Client | `Tests` | `src/Tests.java` |

The Bridge is the interface-typed field `formatter` in `Report.java`. The `execute()` method calculates the report content and delegates formatting to the current formatter. The `setImplementation(...)` method allows the formatter to be replaced at runtime. The T5 check in `Tests.java` verifies that the same report object works with both `TextFormatter` and `HTMLFormatter`.

## Build and Run

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo# sdp_assignment3

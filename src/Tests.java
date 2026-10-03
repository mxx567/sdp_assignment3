import java.util.Objects;

public class Tests {
    private int passed;
    private int failed;

    public String run() {
        passed = 0;
        failed = 0;

        // T1
        AttendanceReport attendanceText = new AttendanceReport(3, 4, new TextFormatter());

        check("T1 AttendanceReport + TextFormatter", attendanceText.execute(), "Attendance: 3 of 4 sessions attended (75%)");

        // T2
        AttendanceReport attendanceHtml = new AttendanceReport(3, 4, new HTMLFormatter());
        check("T2 AttendanceReport + HtmlFormatter", attendanceHtml.execute(), "<p>Attendance: 3 of 4 sessions attended (75%)</p>");

        // T3
        GradeReport gradeText = new GradeReport(new int[]{70, 80, 90}, new TextFormatter());
        check("T3 GradeReport + TextFormatter", gradeText.execute(), "Grade average: 80");

        // T4
        GradeReport gradeHtml = new GradeReport(new int[]{70, 80, 90}, new HTMLFormatter());

        check("T4 GradeReport + HtmlFormatter", gradeHtml.execute(), "<p>Grade average: 80</p>");

        // T5
        AttendanceReport report = new AttendanceReport(3, 4, new TextFormatter());
        AttendanceReport originalReference = report;
        String before = report.execute();
        report.setImplementation(new HTMLFormatter());
        String after = report.execute();
        boolean sameObject = originalReference == report;

        boolean correctSwitch =
                before.equals(
                        "Attendance: 3 of 4 sessions attended (75%)"
                )
                        && after.equals(
                        "<p>Attendance: 3 of 4 sessions attended (75%)</p>"
                );

        if (sameObject && correctSwitch) {
            passed++;
            System.out.println("T5 Runtime switch: PASS");
        } else {
            failed++;
            System.out.println("T5 Runtime switch: FAIL");
            System.out.println("Before: " + before);
            System.out.println("After: " + after);
        }

        // T6
        AttendanceReport attendanceMarkdown = new AttendanceReport(3, 4, new MarkdownFormatter());

        check("T6 AttendanceReport + MarkdownFormatter", attendanceMarkdown.execute(), "**Attendance: 3 of 4 sessions attended (75%)**");

        // T7
        GradeReport gradeMarkdown = new GradeReport(new int[]{70, 80, 90}, new MarkdownFormatter());

        check("T7 GradeReport + MarkdownFormatter", gradeMarkdown.execute(), "**Grade average: 80**");

        System.out.println("SUMMARY: " + passed + "/5 PASS");

        return String.format("PASSED: %d, FAILED: %d", passed, failed);
    }

    private void check(String testName, String actual, String expected) {
        if (Objects.equals(actual, expected)) {
            passed++;
            System.out.println(testName + ": PASS");
        } else {
            failed++;
            System.out.println(testName + ": FAIL");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual);
        }
    }
}

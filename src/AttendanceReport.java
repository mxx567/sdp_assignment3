public class AttendanceReport extends Report {
    private final int attended;
    private final int total;

    public AttendanceReport(String id, int attended, int total, Formatter formatter) {
        super(formatter);
        this.attended = attended;
        this.total = total;
    }

    @Override
    protected String calculate() {
        double percentage = (double) attended / total * 100;
        return String.format("Attendance: %d of %d sessions attended (%.0f%%)", attended, total, percentage);
    }
}
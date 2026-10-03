public class GradeReport extends Report {
    private final int[] grades;

    public GradeReport(String id, int[] grades, Formatter formatter) {
        super(formatter);
        this.grades = grades.clone();
    }

    @Override
    protected String calculate() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double average = (double) sum / grades.length;
        return String.format("Grade average: %.0f", average);
    }
}
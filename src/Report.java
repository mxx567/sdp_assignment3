public abstract class Report {
    protected Formatter formatter;

    protected Report(Formatter formatter) {
        this.formatter = formatter;
    }

    public void setImplementation(Formatter formatter) {
        this.formatter = formatter;
    }

    public String execute() {
        String calculatedContent = calculate();
        return formatter.format(calculatedContent);
    }

    protected abstract String calculate();
}
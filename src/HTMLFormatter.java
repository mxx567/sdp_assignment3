public class HTMLFormatter implements Formatter {
    @Override
    public String format(String content) {
        return "<p>" + content + "</p>";
    }
}
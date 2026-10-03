public class MarkdownFormatter implements Formatter {
    @Override
    public String format(String content) {
        return "**" + content + "**";
    }
}
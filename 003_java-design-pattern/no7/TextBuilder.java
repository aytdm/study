public class TextBuilder extends Builder {
    private StringBuffer buffer = new StringBuffer();
    public void makeTitle(String title) {
        buffer.append("========================================\n");
        buffer.append("[ " + title + " ]\n");
        buffer.append("\n");
    }
    public void makeString(String str) {
        buffer.append("■" + str + "\n");
        buffer.append("\n");
    }
    public void makeItems(String[] items) {
        for (int i=0; i<items.length; i++) {
            buffer.append("  ・" + items[i] + "\n");
        }
        buffer.append("\n");
    }
    public Object getResult() {
        buffer.append("========================================\n");
        return buffer.toString();
    }
}
public class Triple {
    private int count;
    public static Triple[] triple = new Triple[] {
        new Triple(0),
        new Triple(1),
        new Triple(2)
    };

    private Triple (int count) {
        System.out.println("The instance " + count + " is created.");
        this.count = count;
    }

    public static Triple getInstance(int count) {
        System.out.println("[getInstance id=" + count + "]");
        return triple[count];
    }

    public String toString() {
        return "[Triple id=" + count + "]";
    }
}
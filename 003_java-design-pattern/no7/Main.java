import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (args[0].equals("plain")) {
            Director director = new Director(new TextBuilder());
            String result = (String)director.construct();
            System.out.println(result);
        } else if (args[0].equals("html")) {
            Director director = new Director(new HTMLBuilder());
            String filename = (String)director.construct();
            System.out.println(filename + "が作成されました");
        } else {
            usage();
            System.exit(0);
        }
        */
        Director director = new Director(new FrameBuilder());
        JFrame frame = (JFrame)director.construct();
        frame.setVisible(true);
    }
    /*
    public static void usage() {
        System.out.println("Usage: java main plain");
        System.out.println("Usage: java main html");
    }
    */
}
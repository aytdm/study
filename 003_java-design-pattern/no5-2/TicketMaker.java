public class TicketMaker {
    private int ticket = 1000;
    
    private static TicketMaker singleton = new TicketMaker();

    private TicketMaker() {
        System.out.println("The instance was created.");
    }

    public static TicketMaker getInstance() {
        return singleton;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}
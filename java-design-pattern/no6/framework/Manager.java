package framework;
import java.util.*;

public class Manager {
    private Hashtable<String, Product> showcase = new Hashtable<String, Product>();
    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }
    public Product create(String protoname) {
        Product p = showcase.get(protoname);
        return p.createClone();
    }
}
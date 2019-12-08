package idcard;

import framework.*;
import java.util.*;

public class IDCardFactory extends Factory {
    
    private Vector<String> owners = new Vector<String>();
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }
    protected Vector getOwners() {
        return this.owners;
    }
}
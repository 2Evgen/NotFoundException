package domain;

public class Smartphone extends Product {
    private final String constructor;


    public Smartphone(int id, String name, int price, String constructor) {
        super(id, name, price);
        this.constructor = constructor;
    }

}

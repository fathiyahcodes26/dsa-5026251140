package lw01.Unguided;

public abstract class Rental implements Chargeable {
    protected String id;
    protected int days;

    public Rental(String id, int days) { 
        if (days <= 0 || days > 30) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.days = days;
    }

    public abstract String label();

    public int calculateCharge(int units) {
        if (units <= 0 || units > 10) {
            throw new IllegalArgumentException();
        }

        return units * calculateCharge();
    }

    public String summary(int units) {
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}

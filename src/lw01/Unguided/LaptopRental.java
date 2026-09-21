package lw01.Unguided;

public class LaptopRental extends Rental {

    public LaptopRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        return days * 40000 + 10000;
    }

    @Override
    public String label() {
        return "Laptop";
    }
}
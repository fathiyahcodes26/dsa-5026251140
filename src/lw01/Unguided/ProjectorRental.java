package lw01.Unguided;

public class ProjectorRental extends Rental {

    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int charge;

        if (days <= 3) {
            charge = days * 60000;
        } else {
            charge = (3 * 45000) + ((days - 3) *20000 );
        }

        return charge + 20000;
    }

    @Override
    public String label() {
        return "Projector";
    }
}

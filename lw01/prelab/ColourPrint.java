
public class ColourPrint extends PrintJob {

    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int charge;

        if (pages <= 10) {
            charge = pages * 1500;
        } else {
            charge = (10 * 1500) + ((pages - 10) * 1000);
        }

        return charge + 2000;
    }

    @Override
    public String label() {
        return "Colour";
    }
}
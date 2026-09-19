public abstract class PrintJob implements Chargeable {
    protected String id;
    protected int pages;

    public PrintJob(String id, int pages) {
        if (pages <= 0 || pages > 100) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.pages = pages;
    }

    public abstract String label();

    public int calculateCharge(int copies) {
        if (copies <= 0 || copies > 10) {
            throw new IllegalArgumentException();
        }

        return copies * calculateCharge();
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
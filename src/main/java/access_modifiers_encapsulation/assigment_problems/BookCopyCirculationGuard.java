package access_modifiers_encapsulation.assigment_problems;

public class BookCopyCirculationGuard {
    private int copiesTotal;
    private int copiesAvailable;

    public BookCopyCirculationGuard(int copiesTotal) {
        if (copiesTotal < 0) {
            this.copiesTotal = 0;
            this.copiesAvailable = 0;
        } else {
            this.copiesTotal = copiesTotal;
            this.copiesAvailable = copiesTotal;
        }
    }

    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public static void main(String[] args) {
        BookCopyCirculationGuard b = new BookCopyCirculationGuard(3);
        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut(); // 4th attempt silently rejected
        System.out.println(b.getCopiesAvailable());

        b.checkIn();
        b.checkIn();
        b.checkIn();
        b.checkIn(); // 4th attempt silently rejected
        System.out.println(b.getCopiesAvailable());
    }
}
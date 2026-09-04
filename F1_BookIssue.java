class BookIssue {
    String title;
    String borrowerName;
    int daysOverdue;

    BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    double fineAmount() {
        if (daysOverdue > 0)
            return daysOverdue * 5;
        else
            return 0;
    }

    boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    // Static because it calculates the total for all BookIssue objects.
    // fineAmount() is not static because it belongs to one book.
    static double totalFineCollected(BookIssue[] issues) {
        double total = 0;

        for (BookIssue b : issues)
            total = total + b.fineAmount();

        return total;
    }
}

public class F1_BookIssue {
    public static void main(String[] args) {

        BookIssue[] books = {
            new BookIssue("Clean Code", "Aditi", 18),
            new BookIssue("Effective Java", "Rohan", 5),
            new BookIssue("Refactoring", "Kiran", 0),
            new BookIssue("DSA Handbook", "Arun", 21),
            new BookIssue("Design Patterns", "Meera", 9)
        };

        for (BookIssue b : books) {
            if (b.isSeverelyOverdue())
                System.out.println(b.title + " - " + b.daysOverdue +
                                   " days - Severely overdue");
            else
                System.out.println(b.title + " - " + b.daysOverdue +
                                   " days - OK");
        }

        System.out.println("Total fine collected: Rs " +
                           BookIssue.totalFineCollected(books));
    }
}

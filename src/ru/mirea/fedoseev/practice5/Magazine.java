package ru.mirea.fedoseev.practice5;

/**
 * Класс, представляющий журнал
 */
public class Magazine implements Printable {
    private String name;
    private int issueNumber;
    private String month;

    public Magazine(String name, int issueNumber, String month) {
        this.name = name;
        this.issueNumber = issueNumber;
        this.month = month;
    }

    @Override
    public void print() {
        System.out.println("Magazine: " + name + " Issue #" + issueNumber + " (" + month + ")");
    }

    public String getName() {
        return name;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getMonth() {
        return month;
    }

    /**
     * Статический метод для печати только журналов из массива Printable
     */
    public static void printMagazines(Printable[] printables) {
        System.out.println("\n=== Печать только журналов ===");
        for (Printable printable : printables) {
            if (printable instanceof Magazine) {
                printable.print();
            }
        }
    }
}

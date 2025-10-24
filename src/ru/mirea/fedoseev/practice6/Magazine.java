package ru.mirea.fedoseev.practice6;

public class Magazine implements Printable {
    private String name;

    public Magazine(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Magazine: " + name);
    }

    @Override
    public String getName() {
        return name;
    }

    public static void printMagazines(Printable[] printables) {
        System.out.println("\n=== Журналы ===");
        for (Printable printable : printables) {
            if (printable instanceof Magazine) {
                System.out.println(printable.getName());
            }
        }
    }
}

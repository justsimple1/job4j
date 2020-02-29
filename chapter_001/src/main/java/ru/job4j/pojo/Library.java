package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book story = new Book("Ball", 50);
        Book classic = new Book("War and Piece", 4000);
        Book fantastic = new Book("Mystery of the third planet", 800);
        Book program = new Book("Clean code", 100);

        Book[] books = new Book[4];

        books[0] = story;
        books[1] = classic;
        books[2] = fantastic;
        books[3] = program;

        for (int index = 0; index < books.length; index++) {
            Book lib = books[index];
            System.out.println(lib.getName() + " - " + lib.getCount());
        }

        System.out.println("Swap books");
        Book temp = new Book();
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int index = 0; index < books.length; index++) {
            Book lib = books[index];
            System.out.println(lib.getName() + " - " + lib.getCount());
        }
        System.out.println();
        System.out.println("Output books with name 'Clean code'");
        for (int index = 0; index < books.length; index++) {
                Book lib = books[index];
            if (lib.getName().equals("Clean code")) {
                System.out.println(lib.getName() + " - " + lib.getCount());
            }
        }
        System.out.println("Replace all books to program");
        for (int index = 0; index < books.length; index++) {
            books[index] = program;
            Book lib = books[index];
            System.out.println(lib.getName() + " - " + lib.getCount());
        }

    }
}

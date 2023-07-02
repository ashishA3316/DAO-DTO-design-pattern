package demo;

import dao.BookDAO;
import dto.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class BookPresentation {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("-----------------------------------");
        System.out.println("Select Mode of Operation");
        System.out.println("1. Add New Book");
        System.out.println("2. Delete Book");
        System.out.println("3. View Book");
        int choice = sc.nextInt();

        switch (choice)
        {
            case 1 :
                addBooks();
                break;

            case 2 :
                deleteBook();
                break;

            case 3 :
                viewBook();
                break;

            default:
                System.out.println("Invalid Choice !!");
        }
    }
    private static void addBooks() {
        System.out.println("Enter Book Id");
        int id = sc.nextInt();
        System.out.println("Enter Book Name");
        String name = sc .next();
        System.out.println("Enter Book Price");
        double price = sc.nextDouble();
        //add data into DTO Object
        BookDTO dt = new BookDTO();
        dt.setBookId(id);
        dt.setBookName(name);
        dt.setBookPrice(price);
        //call method from DAO class
        BookDAO da = new BookDAO();
        int count = da.insertBook(dt);
        System.out.println(count+" Book Inserted Successfully");
    }
    private static void deleteBook() {
        System.out.println("Enter Book ID");
        int id = sc.nextInt();
        BookDTO dt = new BookDTO();
        dt.setBookId(id);

        BookDAO da = new BookDAO();
        int count1 = da.deleteBook(dt);

        System.out.println(count1+" Book Deleted Successfully");
    }
    private static void viewBook() {
        BookDAO da = new BookDAO();
        ArrayList<BookDTO> bookList =da.viewBook();
        for (BookDTO b : bookList)
        {
            System.out.println(b);
        }
    }





}

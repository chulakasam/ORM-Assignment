package lk.ijse;

import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.Entity.Author;
import lk.ijse.Entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Author author1 = new Author("A001","Davin","UK",null);
        Author author2 = new Author("A002","kevin","USA",null);
        Author author3 = new Author("A003","Michel","France",null);
        Author author4 = new Author("A004","Stack","USA",null);
        Author author5 = new Author("A005","wickramasinghe","SL",null);

        Book book1 = new Book("B001","Innovations",2013,2100.00,author2);
        Book book2 = new Book("B002","Novel",2016,1900.00,author1);
        Book book3 = new Book("B003","Adventure",2020,3100.00,author2);
        Book book4 = new Book("B004","Innovations",2012,1500.00,author3);


        List<Book> list = List.of(book1, book3);
        author2.setBooks(list);

        author1.setBooks(List.of(book2));
        author3.setBooks(List.of(book4));

        session.save(author1);
        session.save(author2);
        session.save(author3);
        session.save(author4);


        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);

        transaction.commit();
        session.close();
    }
}
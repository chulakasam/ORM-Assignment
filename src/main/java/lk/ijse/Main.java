package lk.ijse;

import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.Entity.Author;
import lk.ijse.Entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*Author author1 = new Author("A001","Davin","UK",null);
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
        */



        //01 .retrive details where year>=2010
        /* Query query = session.createQuery("select title from Book where year>=2010");
        List resultList = query.getResultList();
        System.out.println(resultList.toString());
        */

        //02.update query to increase the price of all books
        /* Query query = session.createQuery("update Book B set B.price =(B.price )* 1.1 where B.author.id = :authorId");
        query.setParameter("authorId", "A003");
        int result = query.executeUpdate();
        System.out.println("Result: " + result);
        */

        //04.the average price of all books.
        /*Query query = session.createQuery("SELECT AVG(b.price) FROM Book b");
        Double avg = (Double) query.getSingleResult();
        System.out.println("average price :"+ avg);
        */

        //05.all authors along with the count of books they have written.
        /*Query query = session.createQuery("select A.id,count(B.id) from Author A join Book B on A.id=B.author.id group by A.id");
        List <Object[]> list = query.getResultList();

        for(Object[] obj:list){
            System.out.println(obj[0]+ " "+obj[1]);
        }
         */

        //06.retrieve books written by authors from a specific country.
        /*Query query = session.createQuery("select B.title from Book B join Author A on B.author.id=A.id where A.country=:country");
        query.setParameter("country","USA");
        List list = query.getResultList();

        for (Object obj : list) {
            System.out.println(obj);
        }
        */

        //10.find authors who have written more than the average number of books.
        /*Query query = session.createQuery("select A.name FROM Author A WHERE ( SELECT COUNT(B.id) FROM Book B WHERE A.id = B.author.id ) > ( SELECT AVG(Count) FROM ( SELECT COUNT(B.id) AS Count FROM Book B GROUP BY B.author.id ))");
        List<Object> list = query.getResultList();

        for(Object obj:list){
            System.out.println(obj);
        }
        */



        transaction.commit();
        session.close();



    }
}
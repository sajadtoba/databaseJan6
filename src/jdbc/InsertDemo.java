package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/movies?serverTimezone=UTC";
        String user = "root";
        String password = "cAt@123";

        //Connection connection = DriverManager.getConnection(url,user,password);
        Connection connection = null;
        Statement statement = null;


        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            //Movie movie = new Movie();
            Movie mib = new Movie(10,"Men in Black",2009,"SciFi","PG-13");

            //String query = "insert into movie(id, title, release_year, genre, mpaa_rating) values(5, 'Matrix',1999, 'SciFi','R');";

             //String query ="insert into movie(id, title, release_year, genre, mpaa_rating)" +
            // "values("+ mib.getId() + "', '"+ mib.getTitle() + "', " + mib.getReleaseYear() +
                   //  ", '" + mib.getGenre() + "', '" + mib.getMpaaRating() + "');" ;

            String query = "insert into movie (id, title, release_year, genre, mpaa_rating)" +
                    " values (" + mib.getId() + ", '" + mib.getTitle() + "', " + mib.getReleaseYear() +
                    ", '" + mib.getGenre() + "', '" + mib.getMpaaRating() + "');";






             //String query1 = "insert into movie(id, title, release_year, genre, mpaa_rating) values(9, 'tuMa',1978, 'SciFi','T');";

            // Statement.execute(query);          //  Error because Statement is not a object  (statement is an object)
            statement.execute(query);
             //statement.execute(query1);
            System.out.println("Movie Added");


        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Something might have went wrong with connection");
        } finally {
            connection.close();
            statement.close();

        }
    }
}


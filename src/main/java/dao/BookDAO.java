package dao;
import dto.BookDTO;
import java.sql.*;
import java.util.ArrayList;

public class BookDAO {

    static Connection con = null;
    static PreparedStatement pstmt = null;

    static
    {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    //insertBook()-------------------------------------------------------------
    public int insertBook(BookDTO dt) {
        PreparedStatement pstmt = null;
        int count = 0;
        String query = "insert into book_info values(?, ?, ?)";

        try
        {
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1, dt.getBookId());
            pstmt.setString(2, dt.getBookName());
            pstmt.setDouble(3, dt.getBookPrice());
            count = pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return count;
    }

    //deleteBook()------------------------------------------------------------------
    public int deleteBook(BookDTO dt) {
        PreparedStatement pstmt = null;
        int count1 = 0;
        String query = "Delete from book_info where Book_id= ?";

        try
        {
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1, dt.getBookId());
           count1= pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return count1;
    }

    // viewBook()-------------------------------------------------------------------------
    public ArrayList<BookDTO> viewBook() {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<BookDTO> bookList = new ArrayList<>();

        String query = "select * from book_info";

        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                //store data into DTO Object
                BookDTO dt = new BookDTO();
                dt.setBookId(id);
                dt.setBookName(name);
                dt.setBookPrice(price);
                //add object into list
                bookList.add(dt);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return bookList;
    }
}

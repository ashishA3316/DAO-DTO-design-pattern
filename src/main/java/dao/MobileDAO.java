package dao;

import dto.MobileDTO;

import java.sql.*;
import java.util.ArrayList;

public class MobileDAO {

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
//insert details--------------------------------------------------------------------------------------------
    public int insertMobileDetails(MobileDTO dt) {
        PreparedStatement pstmt = null;
        int count = 0;

        String query = "insert into mobile_info values(?,?,?,?,?,?)";

        try
        {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,dt.getModelNo());
            pstmt.setString(2, dt.getModelName());
            pstmt.setString(3, dt.getCompany());
            pstmt.setInt(4, dt.getRam());
            pstmt.setInt(5, dt.getCamera());
            pstmt.setDouble(6, dt.getPrice());
            count = pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return count;
    }


//search mobile---------------------------------------------------------------------------------------

   ArrayList<MobileDTO> data = new ArrayList<>();;
    public ArrayList<MobileDTO> DisplayMobileByCompany(MobileDTO dt) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "select model_name from mobile_info where company = ?";

        try
        {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, dt.getCompany());
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                MobileDTO da = new MobileDTO();
                da.setModelName(rs.getString("model_name"));
                data.add(da);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return data;
    }
    public ArrayList<MobileDTO> DisplayMobileByPrice(double Sprice, double Eprice) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "select * from mobile_info where price between ? and ? ";

        try
        {
            pstmt = con.prepareStatement(query);
            pstmt.setDouble(1, Sprice);
            pstmt.setDouble(2, Eprice);
            rs = pstmt.executeQuery();
            ArrayList<MobileDTO> dt = record(rs);
            data = dt;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return data;
    }

    public ArrayList<MobileDTO> DisplayMobileByRam(int ram) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "select * from mobile_info where RAM = ? ";

        try
        {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, ram);
            rs = pstmt.executeQuery();
            ArrayList<MobileDTO> data1 = record(rs);
            data1 = data;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return data;
    }
    public ArrayList<MobileDTO> DisplayMobileByCamera(int st, int ed) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "select * from mobile_info where camera between ? and ? ";

        try
        {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, st);
            pstmt.setInt(2, ed);
            rs = pstmt.executeQuery();
            ArrayList<MobileDTO> da = record(rs);
            data = da;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return data;
    }

//delete Mobile----------------------------------------------------------------------------------------
    public int deleteMobile(MobileDTO dt) {
        PreparedStatement pstmt = null;
        int count = 0;

        String query = "delete from mobile_info where model_no = ?";

        try
        {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, dt.getModelNo());
            count = pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return count;
    }

    public ArrayList<MobileDTO> record (ResultSet rs) throws SQLException
    {
        while (rs.next())
        {
            MobileDTO dt = new MobileDTO();
            dt.setModelNo(rs.getInt("model_no"));
            dt.setModelName(rs.getString("model_name"));
            dt.setCompany(rs.getString("company"));
            dt.setRam(rs.getInt("RAM"));
            dt.setCamera(rs.getInt("camera"));
            dt.setPrice(rs.getDouble("price"));
            data.add(dt);
        }
        return data;
    }
}

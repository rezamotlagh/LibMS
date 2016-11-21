package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Borrower;
import view.JDBCMysqlConnection;
public class BorrowerDao implements DAOInterface{
	public void createBorrower()
	{
		
	}
	public void readBorrower()
	{
		
	}
	public void updateBorrower(Borrower borrower)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query="update tbl_borrower set name='"+borrower.getName()+"', address='"+borrower.getAddress()+"', phone='"+borrower.getPhone()+"' where cardNo="+borrower.getCardNo();
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteBorrower(int cardNo)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_borrower where cardNo="+cardNo;	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
	}
	public void insertBorrower(Borrower borrower)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="insert into tbl_borrower(name,address,phone)values('"+borrower.getName()+"','"+borrower.getAddress()+"','"+borrower.getPhone()+"')";
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteBorrower()
	{
		//delete all overloaded
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_borrower";	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
	}
	public Borrower findBorrower(int cardNo)
	{
		Borrower borrower=new Borrower();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_borrower where cardNo="+cardNo;	
			rs=st.executeQuery(query);
			if(rs.next())
			{
				rs.previous();
			
			while(rs.next())
			{
				borrower.setCardNo(rs.getInt("cardNo"));
				borrower.setName(rs.getString("name"));
				borrower.setAddress(rs.getString("address"));
				borrower.setPhone(rs.getString("phone"));
			}
			}
			else
			{
				System.out.println("Null object!");
				borrower=null;
				
			}
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return borrower;

	}
	public ArrayList<Borrower> findBorrower()
	{
		ArrayList<Borrower> borrowerList=new ArrayList<Borrower>();
		Borrower borrower;
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_borrower";	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				borrower= new Borrower();
				borrower.setCardNo(rs.getInt("publisherId"));
				borrower.setName(rs.getString("publisherName"));
				borrower.setAddress(rs.getString("publisherAddress"));
				borrower.setPhone(rs.getString("publisherPhone"));
				borrowerList.add(borrower);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return borrowerList;
	}
}

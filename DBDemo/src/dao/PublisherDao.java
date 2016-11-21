package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Publisher;
import view.JDBCMysqlConnection;
public class PublisherDao implements DAOInterface {
	public void createPublisher()
	{
		
	}
	public void readPublisher()
	{
		
	}
	public void updatePublisher(Publisher publisher)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			
			String query="update tbl_publisher set publisherName='"+publisher.getPublisherName()+"', publisherAddress='"+publisher.getPublisherAddress()+"', publisherPhone='"+publisher.getPublisherPhone()+"' where publisherId="+publisher.getPublisherId();
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deletePublisher(int publisherId)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_publisher where publisherId="+publisherId;	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
	}
	public void insertPublisher(Publisher publisher)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="insert into tbl_publisher(publisherName,publisherAddress,publisherPhone)values('"+publisher.getPublisherName()+"','"+publisher.getPublisherAddress()+"','"+publisher.getPublisherPhone()+"')";
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public void deletePublisher()
	{
		//delete all overloaded
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_publisher";	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
	}
	public Publisher findPublisher(int publisherId)
	{
		Publisher pub=new Publisher();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_publisher where publisherId="+publisherId;	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				pub.setPublisherId(rs.getInt("publisherId"));
				pub.setPublisherName(rs.getString("publisherName"));
				pub.setPublisherAddress(rs.getString("publisherAddress"));
				pub.setPublisherPhone(rs.getString("publisherPhone"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return pub;
	}
	public ArrayList<Publisher> findPublisher()
	{
		ArrayList<Publisher> pubList=new ArrayList<Publisher>();
		Publisher pub;
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_publisher";	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				pub=new Publisher();
				pub.setPublisherId(rs.getInt("publisherId"));
				pub.setPublisherName(rs.getString("publisherName"));
				pub.setPublisherAddress(rs.getString("publisherAddress"));
				pub.setPublisherPhone(rs.getString("publisherPhone"));
				pubList.add(pub);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return pubList;
	}
}

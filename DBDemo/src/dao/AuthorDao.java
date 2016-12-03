package dao;
import domain.Author;
import view.JDBCMysqlConnection;
import java.sql.*;
import java.util.ArrayList;
public class AuthorDao implements DAOInterface{
	public void createAuthor(Author author)
	{
		
	}
	public void readAuthor()
	{
		
	}
	public void updateAuthor(Author author)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query="update tbl_author set authorName='"+author.getAuthorName()+"' where authorId="+author.getAuthorId();
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteAuthor(int authorId)
	{
		
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_author where authorId="+authorId;	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		
	}
	public void insertAuthor(Author author)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="insert into tbl_author(authorName)values('"+author.getAuthorName()+"')";
			
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteAuthor()
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query="delete from tbl_author";
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public Author findAuthor(int authorId)
	{
	
		Author ath=new Author();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select authorId,authorName from tbl_author where authorId="+authorId;	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				ath.setAuthorId(rs.getInt("authorId"));
				ath.setAuthorName(rs.getString("authorName"));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return ath;
	}
	public ArrayList<Author> findAuthor()
	{ //select all
		ArrayList<Author> authList=new ArrayList<Author>();
		Author ath;
		try
		{
			
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="select * from Author";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				ath=new Author();
				ath.setAuthorId(rs.getInt("authorId"));
				ath.setAuthorName(rs.getString("authorName"));
				authList.add(ath);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
		return authList;
	}
}

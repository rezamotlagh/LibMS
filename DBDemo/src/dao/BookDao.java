package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.AuthorDao;
import domain.Book;
import domain.Branch;
import dao.PublisherDao;
import view.JDBCMysqlConnection;
public class BookDao implements DAOInterface{

	public void createBook()
	{
		
	}
	public void readBook()
	{
		
	}
	public void updateBook(Book book)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			
			
			String query="update tbl_book set title='"+book.getTitle()+"',authId="+book.getAuthor().getAuthorId()+", pubId="+book.getPublisher().getPublisherId()+" where  bookId="+book.getBookId();
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteBook(int bookId)
	{
		try
	{
		Connection con=JDBCMysqlConnection.getConnection();
		String query;
		query="delete from tbl_book where bookId="+bookId;	
		PreparedStatement st = con.prepareStatement(query);
		st.executeUpdate(query);
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}	 
		
	}
	public void insertBook(Book book)
	{
		try
		{
			
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="insert into tbl_book(title,authId,pubId)values('"+book.getTitle()+"','"+book.getAuthor().getAuthorId()+"','"+book.getPublisher().getPublisherId()+"')";
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteBook()
	{
		//delete all overloaded
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_book";	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
	}
	public Book findBook(int bookId)
	{
		
		Book book=new Book();
		AuthorDao ath=new AuthorDao();
		PublisherDao pub=new PublisherDao();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_book where bookId="+bookId;	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				book.setBookId(rs.getInt("bookId"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(ath.findAuthor(rs.getInt("authId")));
				book.setPublisher(pub.findPublisher(rs.getInt("pubId")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return book;
	}
	public ArrayList<Book> findBook()
	{
		ArrayList<Book> bookList=new ArrayList<Book>();
		Book book;
		AuthorDao ath;
		PublisherDao pub;
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_book";	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				book=new Book();
				ath=new AuthorDao();
				pub=new PublisherDao();
				book.setBookId(rs.getInt("bookId"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(ath.findAuthor(rs.getInt("authId")));
				book.setPublisher(pub.findPublisher(rs.getInt("pubId")));
				bookList.add(book);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return bookList;
	}
	
	
	public ArrayList<Book> findBook(Branch branch)
	{
		ArrayList<Book> bookList=new ArrayList<Book>();
		Book book;
		AuthorDao ath;
		PublisherDao pub;
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_book where bookId in(select bookId from tbl_book_copies where branchId="+branch.getBranchId()+" and noOfCopies>0)";	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				book=new Book();
				ath=new AuthorDao();
				pub=new PublisherDao();
				book.setBookId(rs.getInt("bookId"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(ath.findAuthor(rs.getInt("authId")));
				book.setPublisher(pub.findPublisher(rs.getInt("pubId")));
				bookList.add(book);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return bookList;
	}


	
}

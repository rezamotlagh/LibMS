package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import domain.BookCopies;
import view.JDBCMysqlConnection;
public class BookCopiesDao  implements DAOInterface {
	public void createBookCopies()
	{
		
	}
	public void readBookCopies()
	{
		
	}
	public void updateBookCopies(BookCopies bookCopies)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query="update tbl_book_copies set noOfCopies="+bookCopies.getNoOfCopies()+" where bookId="+bookCopies.getBookId().getBookId()+" and branchId="+bookCopies.getBranchId().getBranchId();
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public void deleteBookCopies(int bookId, int branchId)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_book_copies where bookId="+bookId+" and branchId="+branchId;	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public void insertBookCopies(BookCopies bc)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="insert into tbl_book_copies values("+bc.getBookId().getBookId()+","+bc.getBranchId().getBranchId()+","+bc.getNoOfCopies()+")";
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteBookCopies()
	{
	
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_book_copies";	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public BookCopies findBookCopies(int bookId,int branchId)
	{
		BookCopies bc=new BookCopies();
		BookDao book=new BookDao();
		BranchDao branch=new BranchDao();
		boolean exist=false;
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_book_copies where bookId="+bookId+" and branchId="+branchId ;	
			rs=st.executeQuery(query);
			if(rs.next())
			{	exist=true;
				rs.previous();
			
				while(rs.next())
				{
					bc.setBookId(book.findBook(rs.getInt("bookId")));
					bc.setBranchId(branch.findBranch(rs.getInt("branchId")));
					bc.setNoOfCopies(rs.getInt("noOfCopies"));
				}
			}
			else
				exist=false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		if(exist)
		return bc;
		else
		{
			bc=null;
			return bc;
		}
	}
	public ArrayList<BookCopies> findBookCopies()
	{
		ArrayList<BookCopies> bcList=new ArrayList<BookCopies>();
		BookCopies bc;
		BookDao book=new BookDao();
		BranchDao branch=new BranchDao();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_book_copies";	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				bc=new BookCopies();
				bc.setBookId(book.findBook(rs.getInt("bookId")));
				bc.setBranchId(branch.findBranch(rs.getInt("branchId")));
				bc.setNoOfCopies(rs.getInt("noOfCopies"));
				bcList.add(bc);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return bcList;
	}


	
}

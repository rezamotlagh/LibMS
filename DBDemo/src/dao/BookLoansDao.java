package dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//import java.util.Date;
import domain.BookCopies;
import domain.BookLoans;
import view.JDBCMysqlConnection;
public class BookLoansDao implements DAOInterface
	{
	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	public void createBookLoans()
	{
		
	}
	public void readBookLoans()
	{
		
	}
	public void updateBookLoans(BookLoans bookLoans)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query="update tbl_book_loans set dueDate=? where bookId="+bookLoans.getBookId().getBookId()+" and branchId="+bookLoans.getBranchId().getBranchId()+" and cardNo="+bookLoans.getCardNo().getCardNo()+" and dateOut='"+bookLoans.getDateIn()+"'";
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public void deleteBookLoans(BookLoans bl)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			
			String query;
			query="delete from tbl_book_loans where cardNo="+bl.getCardNo().getCardNo()+" and bookId="+bl.getBookId().getBookId()+" and branchId="+bl.getBranchId().getBranchId();	
			System.out.println(query);
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public void insertBookLoans(BookLoans bl)
	{
		try
		{
			//dates are added here . there is no date added in the bookloan object
			Connection con=JDBCMysqlConnection.getConnection();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        java.util.Date date = new java.util.Date();
	        String dateOut = dateFormat.format(date);

	        Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.DATE, 7);
	        java.util.Date dDate = cal.getTime();    
	        String dueDate = dateFormat.format(dDate);
			
			String query="insert into tbl_book_loans(bookId,branchId,cardNo,dateOut,dueDate)values("+bl.getBookId().getBookId()+","+bl.getBranchId().getBranchId()+","+bl.getCardNo().getCardNo()+",'"+dateOut+"','"+dueDate+"')";
			PreparedStatement st = con.prepareStatement(query);
			System.out.println(query);
			
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteBookLoans()
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_book_loans";	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public BookLoans findBookLoans(BookLoans bl)
	{
		System.out.println("Hello!! "+bl.getCardNo());
		BookLoans bookLoans=new BookLoans();
		BookDao book=new BookDao();
		BranchDao branch=new BranchDao();
		BorrowerDao borrower=new BorrowerDao();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_book_loans where cardNo="+bl.getCardNo().getCardNo()+" and bookId="+bl.getBookId().getBookId()+" and branchId="+bl.getBranchId().getBranchId();	
			System.out.println(query);
			rs=st.executeQuery(query);
			if(!rs.next())
			{
				bl=null;
				return bookLoans;
			}	
			else
			{
				bookLoans.setBookId(book.findBook(rs.getInt("bookId")));
				bookLoans.setBranchId(branch.findBranch(rs.getInt("branchId")));
				bookLoans.setCardNo(borrower.findBorrower(rs.getInt("cardNo")));
				bookLoans.setDateIn(rs.getTimestamp("dateOut"));
				bookLoans.setDateOut(rs.getTimestamp("dueDate"));
			}
			System.out.println(bookLoans.getCardNo());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return bookLoans;
	}
	public ArrayList<BookLoans> findBookLoans()
	{
		ArrayList<BookLoans> bookLoansList=new ArrayList<BookLoans>(); 
		BookLoans bookLoans;
		BookDao book=new BookDao();
		BranchDao branch=new BranchDao();
		BorrowerDao borrower=new BorrowerDao();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_book_loans";	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				bookLoans=new BookLoans();
				bookLoans.setBookId(book.findBook(rs.getInt("bookId")));
				bookLoans.setBranchId(branch.findBranch(rs.getInt("branchId")));
				bookLoans.setCardNo(borrower.findBorrower(rs.getInt("cardNo")));
				bookLoans.setDateIn(rs.getTimestamp("dateOut"));
				bookLoans.setDateOut(rs.getTimestamp("dueDate"));
				bookLoansList.add(bookLoans);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return bookLoansList;
	}

	public ArrayList<BookLoans> findBookLoans(int cardNo)
	{
		ArrayList<BookLoans> bookLoansList=new ArrayList<BookLoans>(); 
		BookLoans bookLoans;
		BookDao book=new BookDao();
		BranchDao branch=new BranchDao();
		BorrowerDao borrower=new BorrowerDao();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_book_loans where cardNo="+cardNo;	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				bookLoans=new BookLoans();
				bookLoans.setBookId(book.findBook(rs.getInt("bookId")));
				bookLoans.setBranchId(branch.findBranch(rs.getInt("branchId")));
				bookLoans.setCardNo(borrower.findBorrower(rs.getInt("cardNo")));
				bookLoans.setDateIn(rs.getTimestamp("dateOut"));
				bookLoans.setDateOut(rs.getTimestamp("dueDate"));
				bookLoansList.add(bookLoans);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return bookLoansList;
	}

	}

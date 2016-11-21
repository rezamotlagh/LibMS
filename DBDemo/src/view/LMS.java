package view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import service.*;
import dao.*;
import domain.*;
public class LMS 
{
	public static void borrowerMenu()
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BorrowerService borrowerS=new BorrowerService();
		BorrowerDao borrowerDao=new BorrowerDao();
		Borrower borrower=new Borrower();
		String input;
		int choice,cardNo;
		try
		{
			while(true)
			{
				System.out.println("Welcome to the Borrower Menu");
				while(true)
				{
				System.out.println("Enter Your Card Number");
				input=br.readLine();
				
				if(input.isEmpty())
					return;
				else{
				cardNo=Integer.parseInt(input);
				borrower=borrowerDao.findBorrower(cardNo);
				if(borrower==null)
				    System.out.println("Invalid Card Number! Try Again or just press enter to exit");
				else{
					System.out.println("Validated!");
					break;
					}
					}
				}
				
				String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
				System.out.println(timeStamp);
				System.out.println("Select an option:\n1.Checkout a book\n2.Return a book\n3.Back");
				choice=Integer.parseInt(br.readLine());
				switch(choice)
				{
				case 1:
					
					borrowerS.checkOutBook(cardNo);
					return;
				case 2:
					borrowerS.returnBook(cardNo);
					return;
				case 3:
					return;
				default:
						System.out.println("Invalid Choice");
						break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void adminMenu()
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		AdminService admin=new AdminService();
		int choice;
		try
		{
		while(true)
		{
			System.out.println("Welcome To Administrator Menu");
			System.out.println("Select an option:\n1.Edit Book\n2.Edit Author\n3.Edit Publisher\n4.Edit Branch\n5.Edit Borrower\n6.Change Due date\n7.Back");
			choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
				case 1:
					admin.editBook();
					break;
				case 2:
					admin.editAuthor();
					break;
				case 3:
					admin.editPublisher();
					break;
				case 4:
					admin.editBranch();
					break;
				case 5:
					admin.editBorrowers();
					break;
				case 6:
					admin.updateDueDate();
					break;
				case 7:
					return;
				default:
					System.out.println("Invalid Choice!");
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void librarianMenu()
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		LibrarianService librarian=new LibrarianService();
		int choice,ch,i;
		try
		{
		while(true)
		{
			System.out.println("Welcome To Librarian Menu");
			
			System.out.println("Select an option: \n1.Branch Management\n2.Back");
			choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1: 
					BranchDao branchDao=new BranchDao();
					ArrayList<Branch> branchList=new ArrayList<Branch>();
					branchList= branchDao.findBranch();
					
					for(i=0;i<branchList.size();i++)
					{
						//System.out.println(i);	
						System.out.println((i+1)+")"+branchList.get(i).getBranchName());
					}
					System.out.println((i+1)+")Back");
					ch=Integer.parseInt(br.readLine());
					if(ch>=1 && ch<(i+1))
						librarian.manageBranch(branchList.get(ch-1));
						
					else if(ch==i+1)
						return;
					
			case 2: return;
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		int choice;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		AdminService admin;
		try
		{
		while(true)
		{
			System.out.println("Welcome To the Library Management System");
			System.out.println("Select an option:\n1.Librarian Menu\n2.Borrower Menu\n3.Administrator Menu\n4.Exit");
			choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1:
				librarianMenu();
				break;
			case 2:
				borrowerMenu();
				break;
			case 3:
				adminMenu();
				break;
			case 4:
				System.out.println("Have A Nice Time!");
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
			
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
	
	
	
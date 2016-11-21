package service;
import domain.*;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.*;

public class BorrowerService
{

	public void checkOutBook(int cardNo)
	{
		/*
		 * 1.Fetch and print list of branches and ask user to choose a branch
		 * 2.Load all the books available for that branch and have copies available from bookCopies and ask user to choose a book 
		 * 3.Reduce number of copies to and enter the info in the bookLoans table
		 * 4.There can be another additional option to check if the person has any delayed loan. if so user is prohibited to be loaned book
		 * */
		
		int i,thisBranch,thisBook,noofCopies;
		try
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BookLoans bl=new BookLoans();
		BookLoansDao blDao=new BookLoansDao();
		BookCopies bc=new BookCopies();
		System.out.println("Select a Branch:");
		BranchDao branchDao=new BranchDao();
		ArrayList<Branch> branchList=new ArrayList<Branch>();
		branchList= branchDao.findBranch();
		BookCopiesDao bcDao=new BookCopiesDao();
		BorrowerDao borrowerDao=new BorrowerDao();
		for(i=0;i<branchList.size();i++)
		{
			System.out.println((i+1)+")"+branchList.get(i).getBranchName());
		}
		System.out.println((i+1)+")Back");
		thisBranch=Integer.parseInt(br.readLine());
		if(thisBranch>=1 && thisBranch<(i+1))
		{
			System.out.println("Select a Book from the following list:");
			BookDao bookDao=new BookDao();
			ArrayList<Book> bookList=new ArrayList<Book>();
			bookList= bookDao.findBook(branchDao.findBranch(thisBranch)); //find all the books with available copies for this branch 
			
			for(i=0;i<bookList.size();i++)
			{
				System.out.println((i+1)+")"+bookList.get(i).getTitle());
			}
			System.out.println((i+1)+")Back");
			
			thisBook=Integer.parseInt(br.readLine());
			if(thisBook>=1 && thisBook<(i+1))
			{
				
				bc=bcDao.findBookCopies(bookList.get(thisBook-1).getBookId(), branchList.get(thisBranch-1).getBranchId());
				noofCopies=bc.getNoOfCopies()-1;
				bc.setNoOfCopies(noofCopies);
				bl.setBookId(bookList.get(thisBook-1));
				bl.setBranchId(branchList.get(thisBranch-1));
				bl.setCardNo(borrowerDao.findBorrower(cardNo));
				blDao.insertBookLoans(bl);
				System.out.println("Checkout Successfull");
				return;
			}
		}		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void returnBook(int cardNo)
	{
		//A dirty solution(in my perfectionist mind!) but still a solution. we must check whether the record exists in the book loans table with that person that branch and that book
		//if yes remove the record and increment the book copies.
		
		int i,thisLoan,noofCopies;
		try
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BookCopies bc=new BookCopies();
		BookLoansDao blDao=new BookLoansDao();
		BookCopiesDao bcDao=new BookCopiesDao();
		ArrayList<BookLoans> blList=new ArrayList<BookLoans>();
		
		blList=blDao.findBookLoans(cardNo);
		System.out.println("Select a book to return:");
		System.out.println("   BookId   BranchId   DateOut     DueDate");
		for(i=0;i<blList.size();i++)
		{
			System.out.println((i+1)+")"+blList.get(i).getBookId().getTitle()+"    "+blList.get(i).getBranchId().getBranchName()+"    "+blList.get(i).getDateIn()+"     "+blList.get(i).getDateOut());
		}
		System.out.println((i+1)+")Back");
		
		thisLoan=Integer.parseInt(br.readLine());
		if(thisLoan>=1 && thisLoan<(i+1))
		{
			
			bc=bcDao.findBookCopies(blList.get(thisLoan-1).getBookId().getBookId(), blList.get(thisLoan-1).getBranchId().getBranchId());
			noofCopies=bc.getNoOfCopies()+1;
			bc.setNoOfCopies(noofCopies);
			bcDao.updateBookCopies(bc);
			blDao.deleteBookLoans(blList.get(thisLoan-1));
			System.out.println("Return Successfull");
			return;
		}
		else if(thisLoan==(i+1))
		{
			return;
		}
				}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

package service;
import domain.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;

//we are in the book edit menu case 2. Finish he book menu and go after borrowers edit, branch edit and update due date
import dao.*;
public class AdminService
{
  public void editBook()
  {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  Book book;
	  BookDao bookDao=new BookDao();
	  Author author= new Author();
	  AuthorDao authorDao=new AuthorDao();
	  Publisher publisher;
	  PublisherDao pubDao;
	  int choice;
	  boolean editFlag;
	  String input;
	  try
	  {
		  while(true)
		  {
			  System.out.println("Edit Book Menu. Select a number: \n1.Add new book \n2.Update book Info\n3.Delete a book\n4.Cancel");
			  choice=Integer.parseInt(br.readLine());
		  switch(choice)
		  {
		  case 1:
			  editFlag=true;
			  book=new Book();
			  author=new Author();
			  authorDao=new AuthorDao();
			  pubDao=new PublisherDao();
			  publisher=new Publisher();
			  System.out.println("Enter a new book title or leave it empty to cancel!");
			  input=br.readLine();
			  if(!input.isEmpty())
			  {
				  book.setTitle(input);
				  
			  }
			  else
			  	  {
				  editFlag=false;
				  System.out.println("No title was entered!");
			  	  }
			  
			  System.out.println("Enter a new author Id or leave it empty to cancel!");
			  input=br.readLine();
			  if(!input.isEmpty())
			  {
				  author=authorDao.findAuthor(Integer.parseInt(input));
				  System.out.println(author.toString());
				  if(author.getAuthorId()==0)
				  {
					  System.out.println("No author with id="+input+"exists. Operation cancelled!");
					  editFlag=false;
				  }
				  else
				  book.setAuthor(author);
			  }
			  else
			  	  {
				  editFlag=false;
				  System.out.println("No author Id was entered!");
			  	  }
			  
			  System.out.println("Enter a new publisher Id or leave it empty to cancel!");
			  input=br.readLine();
			  if(!input.isEmpty())
			  {
				  publisher=pubDao.findPublisher(Integer.parseInt(input));
				  if(publisher.getPublisherId()==0)
				  {
					  System.out.println("No publisher with id="+input+"exists. Operation cancelled!");
					  editFlag=false;
				  }
				  else
				  book.setPublisher(publisher);
			  }
			  else
			  	  {
				  editFlag=false;
				  System.out.println("No publisher Id was entered!");
			  	  }
			  if(editFlag)
			  {
				  bookDao.insertBook(book);
				  System.out.println("Book Added Successfully!");
			  }
			  
			  break;
		  case 2:
			  editFlag=false;
			  int bookId;
			  book=new Book();
			  author=new Author();
			  authorDao=new AuthorDao();
			  pubDao=new PublisherDao();
			  publisher=new Publisher();
			  System.out.println("Enter a book Id");
			  bookId=Integer.parseInt(br.readLine());
			  book=bookDao.findBook(bookId);
			  if(book.getBookId()==0)
			  {
				  System.out.println("The book with this id does not exist Operation canceled!");
				  break;
			  }
			  
			  System.out.println("You have selected Book with the following details");
			  System.out.println(book.toString());
			  
			  System.out.println("Enter a new name or leave it empty for no change");
			  input=br.readLine();
			  if(!input.isEmpty())
			  {
			  book.setTitle(input);
			  editFlag=true;
			  }
			  while(true)
			  {
				  System.out.println("Enter a new author Id or leave it empty for no change");
				  input=br.readLine();
				  if(input.isEmpty())
					  break;
				  else
				  {
					  author=authorDao.findAuthor(Integer.parseInt(input));
					  if(author.getAuthorId()==0)
						  System.out.println("Wrong autor Id!");
					  else
					  {
					  book.setAuthor(author);
					  editFlag=true;
					  break;
					  }
				  }
			  }
			  while(true)
			  {
				  System.out.println("Enter a new publisher Id or leave it empty for no change");
				  input=br.readLine();
				  if(input.isEmpty())
					  break;
				  else
				  {  
					  publisher=pubDao.findPublisher(Integer.parseInt(input));
					  if(publisher.getPublisherId()==0)
						  System.out.println("Wrong publisher Id!");
					  else
					  {
						  book.setPublisher(publisher);
						  editFlag=true;
						  break;
					  }
				  }
		  	  }
			  if(editFlag)
			  {
			  bookDao.updateBook(book);
			  System.out.println("Updated");
			  }
			  break;
			  
		  case 3:
			  book= new Book();
			 
			  while(true)
			  {
			  System.out.println("Enter a book Id");
			  bookId=Integer.parseInt(br.readLine());
			  book=bookDao.findBook(bookId);
			  if(book.getBookId()==0)
			   {
				  System.out.println("No record exists with this Id");
				  break;
			   }
			   
				  System.out.println("You have selected the Book with the following details");
			  	  System.out.println(book.toString());
			  
			      System.out.println("Are you sure you want to delete? y/n");
			  input=br.readLine();
			  if(input.equalsIgnoreCase("y"))
			  {
				  bookDao.deleteBook(bookId);
			  	  System.out.println("Book info deleted!");
			  	  break;
			  }
			  else if(input.equalsIgnoreCase("n"))
			  {
				  System.out.println("Operation cancelled by the user!");
			  	  break;
			  }
			  else
				  System.out.println("invalid choice");
			  }
		  
			  break;
		  case 4:
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
  
    public void editAuthor()
  {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  Author author;
	  AuthorDao authorDao=new AuthorDao();;
	  boolean editFlag=false;
	  String input;
	  int choice,authorId;
	  try
	  {
		  while(true)
		  {
			  System.out.println("Edit Author Menu. Select a number: \n1.Add new Author\n2.Update an author\n3.Delete an author\n4.Cancel");
			  choice=Integer.parseInt(br.readLine());
			  switch(choice)
			  {
			  case 1:
				  author= new Author();
				  System.out.println("Enter a new Author Name or leave it empty for no insertion!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  author.setAuthorName(input);
					  authorDao.insertAuthor(author);
					  System.out.println("New author added!");
				  }
					  break;
			  case 2:
				  author= new Author();
				  System.out.println("Enter an author Id");
				  authorId=Integer.parseInt(br.readLine());
				  author=authorDao.findAuthor(authorId);
				  if(author.getAuthorId()==0)
				   {
					  System.out.println("No record exists with this Id. Operation cancelled");
					  break;
				   }
				   
				  System.out.println("You have selected the Author with the following details");
				  System.out.println(author.toString());
				  System.out.println("Enter a new author name or leave it empty for no change");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  editFlag=true;
					  author.setAuthorName(input);
				  }
				  if(editFlag)
				  {
				  authorDao.updateAuthor(author); 
				  System.out.println("Author info updated!");
				  editFlag=false;
				  }
				  break;
			  case 3:
				  author= new Author();
				  while(true)
				  {
				  System.out.println("Enter an author Id");
				  authorId=Integer.parseInt(br.readLine());
				  author=authorDao.findAuthor(authorId);
				  if(author.getAuthorId()==0)
				   {
					  System.out.println("No record exists with this Id. Operation cancelled");
					  break;
				   }
				   
					  System.out.println("You have selected the Author with the following details");
				  	  System.out.println(author.toString());
				  
				      System.out.println("Are you sure you want to delete? y/n");
				  input=br.readLine();
				  if(input.equalsIgnoreCase("y"))
				  {
					  authorDao.deleteAuthor(authorId);
				  	  System.out.println("Author info deleted!");
				  	  break;
				  }
				  if(input.equalsIgnoreCase("n"))
				  {
					 System.out.println("Delete Operation cancelled by the user!");
					 break;
				  }
				  else
					 System.out.println("Invalid answer.");
				  }
				  break;
			  case 4:
				  return;
				  default:
					 System.out.println("Invalid Choice!");
			  }//switch
			  
		  }//while
	   }
	  catch(NumberFormatException nfe)
	  {
		  
	  }
	  catch(Exception e)
	  {
		
	  }  
	  
  }
  public void editPublisher()
  {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  Publisher publisher;
	  PublisherDao publisherDao=new PublisherDao();;
	  boolean editFlag=false;
	  String input;
	  int choice,publisherId;
	  try
	  {
		  while(true)
		  {
			  System.out.println("Edit Publisher Menu. Select a number: \n1.Add new Publisher\n2.Update a publisher\n3.Delete a publisher\n4.Cancel");
			  choice=Integer.parseInt(br.readLine());
			  switch(choice)
			  {
			  case 1:
				  publisher= new Publisher();
				  editFlag=false;
				  System.out.println("Enter a new Publisher Name or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  publisher.setPublisherName(input);
					  editFlag=true;
				  }
				  
				  System.out.println("Enter a new Publisher Address or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  publisher.setPublisherAddress(input);
					  editFlag=true;
				  }
				  
				  System.out.println("Enter a new Publisher Phone or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  publisher.setPublisherPhone(input);
					  editFlag=true;
				  }
				  				  
				  		if(editFlag)
				  	  {
					  publisherDao.insertPublisher(publisher);
					  System.out.println("New publisher added!");
				  	  }
					  break;
			  case 2:
				  publisher= new Publisher();
				  editFlag=false;
				  System.out.println("Enter a publisher Id");
				  publisherId=Integer.parseInt(br.readLine());
				  publisher=publisherDao.findPublisher(publisherId);
				  if(publisher.getPublisherId()==0)
				   {
					  System.out.println("No record exists with this Id. Operation cancelled");
					  break;
				   }
				   
				  System.out.println("You have selected the Publisher with the following details");
				  System.out.println(publisher.toString());
				  
				  System.out.println("Enter a new Publisher Name or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  publisher.setPublisherName(input);
					  editFlag=true;  
				  }
				  
				  System.out.println("Enter a new Publisher Address or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  publisher.setPublisherAddress(input);
					  editFlag=true;
				  }
				 
				  System.out.println("Enter a new Publisher Phone or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  publisher.setPublisherPhone(input);
					  editFlag=true;
				  }
				 
				  if(editFlag)
				  {
				  publisherDao.updatePublisher(publisher); 
				  System.out.println("Publisher info updated!");
				  }
				  break;
			  case 3:
				  publisher= new Publisher();
				  while(true)
				  {
				  System.out.println("Enter a publisher Id");
				  publisherId=Integer.parseInt(br.readLine());
				  publisher=publisherDao.findPublisher(publisherId);
				  if(publisher.getPublisherId()==0)
				   {
					  System.out.println("No record exists with this Id. Operation cancelled");
					  break;
				   }
				   
					  System.out.println("You have selected the Publisher with the following details");
				  	  System.out.println(publisher.toString());
				  
				      System.out.println("Are you sure you want to delete? y/n");
				  input=br.readLine();
				  if(input.equalsIgnoreCase("y"))
				  {
					  publisherDao.deletePublisher(publisherId);
				  	  System.out.println("Publisher info deleted!");
				  	  break;
				  }
				  else if(input.equalsIgnoreCase("n"))
				  {
					  System.out.println("Delete operation cancelled by the user!");
					  break;
				  }
				  else
					  System.out.println("Invalid choice!");
				  }
				  break;
			  case 4:
				  return;
				  default:
					 System.out.println("Invalid Choice!");
			  }//switch
			  
		  }//while
	   }
	  catch(Exception e)
	  {
		 e.printStackTrace();
	  }  
	
  }
  public void editBranch()
  {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  Branch branch;
	  BranchDao branchDao=new BranchDao();;
	  boolean editFlag=true;
	  String input;
	  int choice,branchId;
	  try
	  {
		  while(true)
		  {
			  System.out.println("Edit Branch Menu. Select a number: \n1.Add new Branch\n2.Update a branch\n3.Delete a branch\n4.Cancel");
			  choice=Integer.parseInt(br.readLine());
			  switch(choice)
			  {
			  case 1:
				  branch= new Branch();
				  System.out.println("Enter a new Branch Name");
				  input=br.readLine();
				  if(input.isEmpty())
				  {
					  System.out.println("No Name was entered!");
					  editFlag=false;
				  }
				  else
				  {
					  branch.setBranchName(input);
					  
				  }
				  System.out.println("Enter a new Branch Address");
				  input=br.readLine();
				  if(input.isEmpty())
				  {
					  System.out.println("No Address was entered!");
					  editFlag=false;
				  }
				  else
				  {
					  branch.setBranchAddress(input);
					  
				  }
				  if(editFlag)
				  {
					  branchDao.insertBranch(branch);
					  System.out.println("New branch added!");
				  }
					  break;
			  case 2:
				  editFlag=false;
				  branch= new Branch();
				  System.out.println("Enter a branch Id");
				  branchId=Integer.parseInt(br.readLine());
				  branch=branchDao.findBranch(branchId);
				  if(branch.getBranchId()==0)
				   {
					  System.out.println("No record exists with this Id. Operation cancelled");
					  break;
				   }
				   
				  System.out.println("You have selected the Branch with the following details");
				  System.out.println(branch.toString());
				  System.out.println("Enter a new branch name or leave it empty for no change");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  editFlag=true;
					  branch.setBranchName(input);
				  }
				  System.out.println("Enter a new branch Address or leave it empty for no change");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  editFlag=true;
					  branch.setBranchAddress(input);
				  }
				  if(editFlag)
				  {
				  branchDao.updateBranch(branch); 
				  System.out.println("Branch info updated!");
				  editFlag=false;
				  }
				  break;
			  case 3:
				  branch= new Branch();
				  System.out.println("Enter a branch Id");
				  branchId=Integer.parseInt(br.readLine());
				  branch=branchDao.findBranch(branchId);
				  if(branch.getBranchId()==0)
				   {
					  System.out.println("No record exists with this Id. Operation cancelled");
					  break;
				   }
				   
					  System.out.println("You have selected the Branch with the following details");
				  	  System.out.println(branch.toString());
				  
				      System.out.println("Are you sure you want to delete? y/n");
				  input=br.readLine();
				  if(input.equalsIgnoreCase("y"))
				  {
					  branchDao.deleteBranch(branchId);
				  	  System.out.println("Branch info deleted!");
				  }
				  else
					  System.out.println("negative answer, no or invalid choice. delete operation cancelled!");
				  break;
			  case 4:
				  return;
				  default:
					 System.out.println("Invalid Choice!");
			  }//switch
			  
		  }//while
	   }
	  catch(Exception e)
	  {
		 e.printStackTrace();
	  } 
	  
	  
  }
  public void editBorrowers()
  {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  Borrower borrower;
	  BorrowerDao borrowerDao=new BorrowerDao();;
	  boolean editFlag=false;
	  String input;
	  int choice,cardNo;
	  try
	  {
		  while(true)
		  {
			  System.out.println("Edit Borrower Menu. Select a number: \n1.Add new Borrower\n2.Update a borrower\n3.Delete a borrower\n4.Cancel");
			  choice=Integer.parseInt(br.readLine());
			  switch(choice)
			  {
			  case 1:
				  borrower= new Borrower();
				  editFlag=true;
				  System.out.println("Enter a new Borrower Name or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  borrower.setName(input);
					  
				  }
				  else
				  	  {
					  editFlag=false;
					  System.out.println("No Name was entered!");
				  	  }
				  
				  System.out.println("Enter a new Borrower Address or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  borrower.setAddress(input);
					  
				  }
				  else
				  {
					  System.out.println("No Address was entered!");
					  editFlag=false;
				  }
				  System.out.println("Enter a new Borrower Phone or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  borrower.setPhone(input);
					  
				  }
				  else
				  {
					  System.out.println("No Phone was entered!");
					  editFlag=false;
				  }
				  
				  		if(editFlag)
				  	  {
					  borrowerDao.insertBorrower(borrower);
					  System.out.println("New borrower added!");
				  	  }
					  break;
			  case 2:
				  borrower= new Borrower();
				  editFlag=false;
				  System.out.println("Enter a card No");
				  cardNo=Integer.parseInt(br.readLine());
				  borrower=borrowerDao.findBorrower(cardNo);
				  if(borrower.getCardNo()==0)
				   {
					  System.out.println("No record exists with this card No. Operation cancelled");
					  break;
				   }
				   
				  System.out.println("You have selected the Borrower with the following details");
				  System.out.println(borrower.toString());
				  
				  System.out.println("Enter a new Borrower Name or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  borrower.setName(input);
					  editFlag=true;  
				  }
				  
				  System.out.println("Enter a new Borrower Address or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  borrower.setAddress(input);
					  editFlag=true;
				  }
				 
				  System.out.println("Enter a new Borrower Phone or leave it empty to cancel!");
				  input=br.readLine();
				  if(!input.isEmpty())
				  {
					  borrower.setPhone(input);
					  editFlag=true;
				  }
				 
				  if(editFlag)
				  {
				  borrowerDao.updateBorrower(borrower); 
				  System.out.println("Borrower info updated!");
				  editFlag=false;
				  }
				  break;
			  case 3:
				  borrower= new Borrower();
				  System.out.println("Enter a card No");
				  cardNo=Integer.parseInt(br.readLine());
				  borrower=borrowerDao.findBorrower(cardNo);
				  if(borrower.getCardNo()==0)
				   {
					  System.out.println("No record exists with this card No. Operation cancelled");
					  break;
				   }
				   
					  System.out.println("You have selected the Borrower with the following details");
				  	  System.out.println(borrower.toString());
				  
				      System.out.println("Are you sure you want to delete? y/n");
				  input=br.readLine();
				  if(input.equalsIgnoreCase("y"))
				  {
					  borrowerDao.deleteBorrower(cardNo);
				  	  System.out.println("Borrower info deleted!");
				  }
				  else
					  System.out.println("negative answer, no or invalid choice. delete operation cancelled!");
				  break;
			  case 4:
				  return;
				  default:
					 System.out.println("Invalid Choice!");
			  }//switch
			  
		  }//while
	   }
	  catch(Exception e)
	  {
		 e.printStackTrace();
	  }
	  
  }
  public void updateDueDate()
  {
	  BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	  BookLoans bl=new BookLoans();
	  BookLoansDao bld=new BookLoansDao();
	  Branch branch=new Branch();
	  Book book=new Book();
	  Borrower borrower=new Borrower();
	  BranchDao branchDao=new BranchDao();
	  BookDao bookDao=new BookDao();
	  BorrowerDao borrowerDao=new BorrowerDao();
	  int bookId,branchId,cardNo;
	  String input;
	  try
	  {
	  System.out.println("Enter the book Id");
	  bookId=Integer.parseInt(br.readLine());
	  System.out.println("Enter the branch Id");
	  branchId=Integer.parseInt(br.readLine());
	  System.out.println("Enter the card No");
	  cardNo=Integer.parseInt(br.readLine());
	  Timestamp dueDate;
	  book=bookDao.findBook(bookId);
	  branch=branchDao.findBranch(branchId);
	  borrower=borrowerDao.findBorrower(cardNo);
	  
	  bl.setBookId(book);
	  bl.setBranchId(branch);
	  bl.setCardNo(borrower);
	  
	  bl=bld.findBookLoans(bl);
	  
	  if(bl==null)
	   {
		  System.out.println("No record exists with this Info. Operation cancelled");
		  return;
	   }
	   
	  System.out.println("You have selected the Loan Record with the following details");
	  System.out.println(bl.toString());
	  System.out.println("Enter a new due date(YYYY-MM-DD hh:mm:ss) or leave it empty for no change");
	  input=br.readLine();
	  if(!input.isEmpty())
	  {
		  dueDate = Timestamp.valueOf(input);
		  bl.setDateOut(dueDate);
		  bld.updateBookLoans(bl);
		  System.out.println("Due Date was updated!");
	  }
	   
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
}

package service;
import  domain.*;
import  java.io.*;
import  java.util.ArrayList;
import  dao.*;
public class LibrarianService 
{
	public void updateBranchDetails(int id,String name,String address)
	{
		System.out.println(id+","+name+","+address);
		BranchDao branchDao=new BranchDao();
		Branch branch=new Branch();
		branch.setBranchName(name);
		branch.setBranchAddress(address);
		branch.setBranchId(id);
		branchDao.updateBranch(branch);
	}
	
public void manageBranch(Branch branch)
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		int choice=1;
		
		System.out.println("Please select an option: \n1.Update the details of the branch\n2.Change number of copies of book to the branch\n3.Exit");
		try
		{
			
			switch(choice)
			{
			case 1: 
				String input;
				boolean editFlag=false;
				BranchDao branchDao=new BranchDao();
				System.out.println("Branch details are as follow: ");
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
			case 2:
						int i,ch,copiesCounter=0;
						System.out.println("Select a Book to add:");
						BookDao bookDao=new BookDao();
						ArrayList<Book> bookList=new ArrayList<Book>();
						bookList= bookDao.findBook();
						
						for(i=0;i<bookList.size();i++)
						{
							System.out.println((i+1)+")"+bookList.get(i).getTitle());
						}
						System.out.println((i+1)+")Back");
						ch=Integer.parseInt(br.readLine());
						if(ch>=1 && ch<(i+1))
						{
							BookCopies bookCopies=new BookCopies();
							BookCopiesDao bookCopiesDao=new BookCopiesDao();
							bookCopies=bookCopiesDao.findBookCopies(bookList.get(ch-1).getBookId(),branch.getBranchId());
							if(bookCopies==null)
								copiesCounter=0;
							else
								copiesCounter=bookCopies.getNoOfCopies();
						
							System.out.println("Number of copies for this book in this branch is: "+copiesCounter);
							System.out.println("Enter a new number of copies or leave it empty for no change");
							input=br.readLine();
							if(input.isEmpty())
							{
								System.out.println("No change!");
								return;
							}
							else
							{
								bookCopies.setNoOfCopies(Integer.parseInt(input));
								bookCopiesDao.updateBookCopies(bookCopies);
						
								return;
							}
						}
							
						 
						else if(ch==i+1)
							return;
						
				case 3:
				return;
				default:System.out.println("Invalid Choice");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}



package service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class UpdateLibraryDetails
 */
@WebServlet("/UpdateLibraryDetails")
public class UpdateLibraryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private boolean checkEntries(String name,String address)
	{
		if(name.isEmpty()|| address.isEmpty())
			return false;
		else
		{
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("I am a string");
		boolean b = m.find();
		if(b)
			return false;
		else
			return true;
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String name=request.getParameter("branchName");
	String address=request.getParameter("branchAddress");
	String branch=(String) request.getSession().getAttribute("branchName");
	System.out.println(branch);
	try
	{
		
	String[] splittedBranch=branch.split("\\.");
	int id=Integer.parseInt(splittedBranch[0]);
	System.out.println("id= "+id);
	
	if(checkEntries(name,address))
	{
		System.out.println(name+","+address);
	 LibrarianService libser=new LibrarianService();
	 libser.updateBranchDetails(id, name, address);
	 response.sendRedirect("LibrarianDashboard.jsp");
	 return;
	}
	 else
	 {
		 System.out.println("could not update");
		 response.sendRedirect("LibrarianDashboard.jsp");
	 
	 }
	}
	catch(NullPointerException npe)
	{
		System.out.println("NPE exception");
	}
	catch(ArrayIndexOutOfBoundsException aobe)
	{
		System.out.println("AOBE Exception");
	}
	}

}

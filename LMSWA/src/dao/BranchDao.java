package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import domain.Branch;
import view.JDBCMysqlConnection;
public class BranchDao implements DAOInterface{

	public void createBranch()
	{
		
	}
	public void readBranch()
	{
		
	}
	public void updateBranch(Branch branch)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query="update tbl_library_branch set branchName='"+branch.getBranchName()+"', branchAddress='"+branch.getBranchAddress()+"' where branchId="+branch.getBranchId();
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public void deleteBranch(int branchId)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_library_branch where branchId="+branchId;	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
	}
	public void insertBranch(Branch branch)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="insert into tbl_library_branch(branchName,BranchAddress)values('"+branch.getBranchName()+"','"+branch.getBranchAddress()+"')";
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteBranch()
	{
		//delete all overloaded
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			String query;
			query="delete from tbl_library_branch";	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public Branch findBranch(int branchId)
	{
		//ArrayList<Branch> branchList=new ArrayList();
		Branch branch=new Branch();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_library_branch where branchId="+branchId;	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				branch.setBranchId(rs.getInt("branchId"));
				branch.setBranchName(rs.getString("branchName"));
				branch.setBranchAddress(rs.getString("branchAddress"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return branch;
	}
	public ArrayList<Branch> findBranch()
	{
		ArrayList<Branch> branchList=new ArrayList<Branch>();
		Branch branch;
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			query="select * from tbl_library_branch";	
			rs=st.executeQuery(query);
			while(rs.next())
			{
				branch=new Branch();
				branch.setBranchId(rs.getInt("branchId"));
				branch.setBranchName(rs.getString("branchName"));
				branch.setBranchAddress(rs.getString("branchAddress"));
				branchList.add(branch);
			
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return branchList;
	}
}

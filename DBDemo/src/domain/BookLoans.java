package domain;
import java.sql.Date;
import java.sql.Timestamp;

public class BookLoans {

	private Timestamp dateIn; // type: sql timestamp
	private Timestamp dateOut;
	
	private Book book;//bookId
	private Branch branch;//branchId
	private Borrower borrower;//cardNo
	
	
	public Timestamp getDateIn() {
		return dateIn;
	}
	public Timestamp getDateOut() {
		return dateOut;
	}
	public Book getBookId() {
		return book;
	}
	public Branch getBranchId() {
		return branch;
	}
	public Borrower getCardNo() {
		return borrower;
	}
	public void setDateIn(Timestamp timestamp) {
		this.dateIn = timestamp;
	}
	public void setDateOut(Timestamp dateOut) {
		this.dateOut = dateOut;
	}
	public void setBookId(Book tbook) {
		book=tbook;
	}
	public void setBranchId(Branch tbranch) {
		branch=tbranch;
	}
	public void setCardNo(Borrower tborrower) {
		borrower=tborrower;

	}

	
	
	@Override
	public String toString() {
		return "BookLoans [dateIn=" + dateIn + ", dateOut=" + dateOut + ", book=" + book.getBookId() + ", branch=" + branch.getBranchId()
				+ ", borrower=" + borrower.getCardNo() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((borrower == null) ? 0 : borrower.hashCode());
		result = prime * result + ((dateIn == null) ? 0 : dateIn.hashCode());
		result = prime * result + ((dateOut == null) ? 0 : dateOut.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookLoans other = (BookLoans) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (borrower == null) {
			if (other.borrower != null)
				return false;
		} else if (!borrower.equals(other.borrower))
			return false;
		if (dateIn == null) {
			if (other.dateIn != null)
				return false;
		} else if (!dateIn.equals(other.dateIn))
			return false;
		if (dateOut == null) {
			if (other.dateOut != null)
				return false;
		} else if (!dateOut.equals(other.dateOut))
			return false;
		return true;
	}
	
	
	
}

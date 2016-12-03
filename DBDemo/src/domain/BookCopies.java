package domain;

public class BookCopies {

	private int noOfCopies;
	private Book book;//bookId
	private Branch branch;//branchId
	
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public Book getBookId() {
		return book;
	}
	public Branch getBranchId() {
		return branch;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public void setBookId(Book tbook) {
		book=tbook;
	}
	public void setBranchId(Branch tbranch) {
		branch=tbranch;
	}
	
	@Override
	public String toString() {
		return "BookCopies [noOfCopies=" + noOfCopies + ", bookId=" + book + ", branchId=" + branch + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + noOfCopies;
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
		BookCopies other = (BookCopies) obj;
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
		if (noOfCopies != other.noOfCopies)
			return false;
		return true;
	}
	
	}

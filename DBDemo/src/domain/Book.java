package domain;

public class Book {
 
	private int bookId;
	private Author author;//authId
	private Publisher publisher;//pubId
	private String title;
	public int getBookId() {
		return bookId;
	}
	public Author getAuthor() {
		return author;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setAuthor(Author tauthor) {
		author=tauthor;
	}
	public void setPublisher(Publisher tPublisher) {
	   publisher=tPublisher;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
		
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", authId=" + author.getAuthorId() + ", pubId=" + publisher.getPublisherId() + ", title=" + title + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + bookId;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookId != other.bookId)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}

package domain;

public class Author {

	private int authorId;
	private String authorName;
	
	public int getAuthorId() {
		return authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorId(int authId) {
		authorId = authId;
	}
	public void setAuthorName(String authName) {
		authorName = authName;
	}
	
	
	
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
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
		Author other = (Author) obj;
		if (authorId != other.authorId)
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		return true;
	}
	
	
	
	
}

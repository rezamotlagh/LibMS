package domain;

public class Borrower {

	private int cardNo;
	private String name;
	private String address;
	private String phone;
	
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCardNo() {
		return cardNo;
	}

	
	public String getName() {
		return name;
	}

	
	public String getAddress() {
		return address;
	}

	
	public String getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		return "Borrower [cardNo=" + cardNo + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + cardNo;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Borrower other = (Borrower) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cardNo != other.cardNo)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	
	
}

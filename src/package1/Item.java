package package1;

public class Item {
	private String bookId;
	private String bookName;
	private int price;
	
	public Item(String pbookId, String pbookName, int pprice) {
		this.bookId=pbookId;
		this.bookName=pbookName;
		this.price=pprice;
	}
	
	String getBookId() {
		return this.bookId;
	}
	
	String getBookName() {
		return this.bookName;
	}
	
	int getPrice() {
		return this.price;
	}
}

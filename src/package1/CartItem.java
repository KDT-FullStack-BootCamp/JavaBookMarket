package package1;

public class CartItem {
	private Book bookInfo;
	private String bookId;
	private int count;
	private int total_price;
	
	CartItem(Book pbookInfo) {
		this.bookInfo=pbookInfo;
		this.bookId=this.bookInfo.getBookId();
		this.count=1;
		this.total_price=this.bookInfo.getPrice() * this.count;
	}
	
	String getBookId() {
		return this.bookId;
	}
	
	Book getBookInfo() {
		return this.bookInfo;
	}
	
	int getCount() {
		return this.count;		
	}
	
	int getTotalPrice() {
		return this.total_price;
	}
	
	void setCount(int pcount) {
		this.count=pcount;
		this.total_price=this.bookInfo.getPrice() * this.count;
	}	
}

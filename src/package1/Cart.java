package package1;

public class Cart {
	private CartItem[] cartItemList=new CartItem[3];
	private int cartCount=0;
	public final static int NODATA=-1;
	public Cart() {
		
	}
	
	public void insertBook(Book book) {
		this.cartItemList[cartCount] = new CartItem(book);
		this.cartCount++;
	}
	
	public void inCreaseBookCount(String bookId) {
		for(int i=0; i<this.cartCount; i++) {
			if(this.cartItemList[i].getBookId().equals(bookId)) {
				this.cartItemList[i].setCount(this.cartItemList[i].getCount()+1);
				return;
			}
		}
	}

	public void removeAllCart() {
		this.cartItemList = new CartItem[3];
		this.cartCount = 0;
	}

	public void printCart() {
		System.out.println("장바구니 상품 목록 보기 :");
		if(this.cartCount==0) {
			System.out.println("장바구니가 비어있습니다");
			return;
		}
		System.out.println("---------------------------------------------");
		System.out.println("도서ID\t\t|수량\t|총가격");

		for (int i = 0; i < this.cartCount; i++) {
			System.out.print((i+1)+" "+this.cartItemList[i].getBookId() + "\t| ");
			System.out.print(this.cartItemList[i].getCount() + "\t| ");
			System.out.print(this.cartItemList[i].getTotalPrice());
			System.out.println();
		}
		System.out.println("---------------------------------------------");
	}

	public boolean isCartInBook(String pbookId) {
		
		for(int i=0; i<this.cartCount;i++) {
			if(pbookId.equals(this.cartItemList[i].getBookId())) {				
				return true;
			}
		}
		
		return false;
	}

	public Book removeCart(int numId) {
		CartItem[] cartItem = new CartItem[3];
		int num = 0;
		Book removeBook=this.cartItemList[numId].getBookInfo();
		
		for (int i = 0; i < this.cartCount; i++) {
			if (numId != i) {
				cartItem[num++] = this.cartItemList[i];
			}
		}
		
		this.cartCount = num;
		this.cartItemList = cartItem;
		return removeBook;
	}
	
	public Book decreaseBookCount(String bookId) {
		Book decreaseCountBook=null;
		for(int i=0; i<this.cartCount; i++) {
			if(this.cartItemList[i].getBookId().equals(bookId)) {
				this.cartItemList[i].setCount(this.cartItemList[i].getCount()-1);
				decreaseCountBook=this.cartItemList[i].getBookInfo();
				if(this.cartItemList[i].getCount()==0) {
					String bookName=this.cartItemList[i].getBookInfo().getBookName();
					System.out.println(bookName+"의 수량이 0이되어 항목을 장바구니에서 삭제합니다.");	
					this.removeCart(i);	
				}				
				break;				
			}
		}		
		return decreaseCountBook;
	}
	
	public int getCartCount() {
		return this.cartCount;
	}

}

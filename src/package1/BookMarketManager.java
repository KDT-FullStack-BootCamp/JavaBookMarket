package package1;

import java.util.Scanner;

public class BookMarketManager {
	private Book[] mBook=null;
	private Cart cart=null;
	
	public Person user=null;	

	public BookMarketManager() {
		this.mBook=new Book[3];
		this.mBook[0]=new Book("ISBN1234","쉽게 배우는 JSP 웹프로그래밍",27000,
				"송미영","단계별로 구현하여 배우는 JSP 프로그래밍","IT전문서",
				"2018/10/08");
		this.mBook[1]=new Book("ISBN1235","안드로이드 프로그래밍",33000,"우재남",
				"실습단계별 명확한 멘토링!","IT전문서","2022/01/22");

		this.mBook[2]=new Book("ISBN1236","스크래치", 22000,"고광일",
				"컴퓨팅 사고력을 키우는 블록 코딩","컴퓨터 입문","2019/06/10");
		
		this.cart=new Cart();		
	}
	
	public  void bookList() {
				
		for(int i=0; i<mBook.length; i++) {
			System.out.print("도서 ID :");
			System.out.println(mBook[i].getBookId());
			System.out.print("도서 이름: ");
			System.out.println(mBook[i].getBookName());
			System.out.print("도서 가격: ");
			System.out.println(mBook[i].getPrice());
			System.out.print("저자 : ");
			System.out.println(mBook[i].getAuthor());
			System.out.print("도서 설명 : ");
			System.out.println(mBook[i].getDescription());
			System.out.print("분류 : ");
			System.out.println(mBook[i].getCategory());
			System.out.print("출판일 : ");
			System.out.println(mBook[i].getReleaseDate());
			System.out.println("======================================");
		}			
	}
	
	public void menuIntroduction() {
		System.out.println("*****************************************");
		System.out.println("\tWelcome to Shopping mall");
		System.out.println("\tWelcome to Book Market!");
		System.out.println("*****************************************");
		System.out.println("1. 고객정보확인하기\t\t4. 바구니에 항목추가하기");
		System.out.println("2. 장바구니 상품 목록 보기\t5. 장바구니에 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기\t\t6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기\t\t8. 종료");
		System.out.println("9. 관리자 로그인");
		System.out.println("*****************************************");		
	}
	
	public void menuGuestInfo() {
		if(this.user!=null) {
			System.out.println("현재 고객 정보 :");
			System.out.println("이름:" + this.user.getName() + "   " + 
								"연락처:" + this.user.getPhone());
		}
		else {
			System.out.println("로그인한 고객정보가 없습니다.");
		}
		
	}

	public void menuCartItemList() {
		cart.printCart();
	}

	public void menuCartClear() {
		System.out.println("장바구니 비우기");
		if (this.cart.getCartCount() == 0)
			System.out.println("장바구니가 비어있습니다.");
		else {
			System.out.println("장바구니의 내용을 모두 비우시겠습니까? Y  | N ");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();

			if (str.toUpperCase().equals("Y")) {
				System.out.println("장바구니가 비었습니다.");				
				this.cart.removeAllCart();
			}
		}
	}

	public void menuCartAddItem() {
		System.out.println("바구니에 항목추가하기");
		bookList();
		
		while(true) {
			System.out.println("장바구니에 추가할 도서의 ID를 입력하세요");
			Scanner input=new Scanner(System.in);
			String bookId=input.nextLine();
			
			int search_index=-1;
			
			for(int i=0; i<3;i++) {
				if(bookId.equals(mBook[i].getBookId())) {
					search_index=i;
					break;
				}
			}
			
			if(search_index==-1) {
				System.out.println("도서의 ID를 확인해 주세요..");
				continue;
			}			
			
			System.out.println("장바구니에 추가하겠습니까?(Y|N)");
			String yn=input.nextLine();
			Book bookinfo=mBook[search_index];
			if(yn.toLowerCase().equals("y")) {
				boolean flag=cart.isCartInBook(bookId);
				if(flag) {
					cart.inCreaseBookCount(bookId);
				}
				else {
					cart.insertBook(bookinfo);				
				}				
				System.out.println(bookinfo.getBookName()+"가 장바구니에 추가되었습니다.");
			}	
			break;		
		}		
	}

	public void menuCartRemoveItemCount() {
		System.out.println("장바구니에 항목 수량 줄이기");
		while (true) {
			this.cart.printCart();
			System.out.print("수량을 줄이실 도서ID를 입력하세요 :");
			Scanner input = new Scanner(System.in);
			String bookId = input.nextLine();
			if(!this.cart.isCartInBook(bookId)) {
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
			
			System.out.println(bookId + "의 수량을 줄이시겠습니까??  Y  | N ");
			String str = input.nextLine();
			if (str.toUpperCase().equals("Y")) {
				Book removeBook=this.cart.decreaseBookCount(bookId);
				if(removeBook!=null) {
					System.out.println(removeBook.getBookName() + " 도서가 장바구니에서 삭제되었습니다.");
				}				
			}
			break;
		}
		
	}

	public void menuCartRemoveItem() {
		System.out.println("장바구니의 항목 삭제하기");
		if (this.cart.getCartCount() == 0)
			System.out.println("장바구니가 비어있습니다.");
		else {
			this.menuCartItemList();
			
			while (true) {
				System.out.print("삭제하실 장바구니 번호를 입력하세요 :");
				Scanner input = new Scanner(System.in);
				int index = input.nextInt();
				input.nextLine();			
				if(index<1  || index>this.cart.getCartCount()) {
					System.out.println("잘못입력하셨습니다.");
					continue;
				}				
				System.out.println("정말로 삭제하시겠습니까?  Y  | N ");
				String str = input.nextLine();
				if (str.toUpperCase().equals("Y")) {
					Book removeBook=this.cart.removeCart(index-1);
					System.out.println(removeBook.getBookName() + " 도서가 장바구니에서 삭제되었습니다.");
				}
				break;
			}
		}
	}

	public void menuCartBill() {
		System.out.println("영수증 표시하기");
	}	

	public void run() {
		Scanner input = new Scanner(System.in);

		System.out.print("당신의 이름을 입력하세요 : ");
		String name = input.next();

		System.out.print("연락처를 입력하세요 : ");
		String phone = input.next();
		
		this.user=new Person(name, phone);
		
		boolean end_flag = false;

		while (true) {
			this.menuIntroduction();
			System.out.print("메뉴번호를 선택해 주세요 : ");
			int number = input.nextInt();

			if (number < 1 || number > 9) {
				System.out.println("메뉴번호가 틀렸습니다.다시 선택해 주세요..");
				continue;
			}

			switch (number) {
			case 1:
				this.menuGuestInfo();
				break;
			case 2:
				this.menuCartItemList();
				break;
			case 3:
				this.menuCartClear();
				break;
			case 4:
				this.menuCartAddItem();
				break;
			case 5:
				this.menuCartRemoveItemCount();
				break;
			case 6:
				this.menuCartRemoveItem();
				break;
			case 7:
				this.menuCartBill();
				break;
			case 8:
				end_flag = true;
				break;
			case 9:
				this.menuAdminLogin();
				break;
			default:
			}

			if (end_flag) {
				break;
			}
		}
		
		System.out.println("Book maket 종료");
	}
	
	public void menuAdminLogin() {
		System.out.println("관리자 정보를 입력하세요");
		Scanner input=new Scanner(System.in);
		System.out.print("아이디:");
		String id=input.nextLine();
		System.out.print("비밀번호:");
		String pw=input.nextLine();
	
		Admin admin=new Admin(user.getName(), user.getPhone());
		if(admin.getId().equals(id) && admin.getPw().equals(pw)){
			System.out.println("이름:"+admin.getName()+
								"  연락처:"+admin.getPhone());
			System.out.println("아이디:"+admin.getId()+
								"  비밀번호:"+admin.getPw());
		}
		else {
			System.out.println("관리자 계정이 틀렸습니다..");
		}		
	}

}

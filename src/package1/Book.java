package package1;

public class Book extends Item {
	private String author;
	private String description;
	private String category;
	private String releaseDate;
	
	public Book(String pbookId, String pbookName, int pprice, String pauthor,
			String pdescription, String pcategory, String preleaseDate) {
		super(pbookId, pbookName, pprice);
		
		this.author=pauthor;
		this.description=pdescription;
		this.category=pcategory;
		this.releaseDate=preleaseDate;		
	}
	
	String getAuthor() {
		return this.author;
	}
	
	String getDescription() {
		return this.description;
	}
	
	String getCategory() {
		return this.category;		
	}
	
	String getReleaseDate() {
		return this.releaseDate;
	}

}

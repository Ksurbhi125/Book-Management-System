package com.book.mgt;
	import java.util.Date;
	import java.util.Random;
	public class MainProcessor {
		public  static Date crdate=null;
		
		static {
			crdate=new Date();
		}

	   public static void main(String[] args) {
	      System.out.println("start Book processor ....");
	      System.out.println("Start adding the book deatil into database....");
			int Book_id=getGeneratedBookId();
			System.out.println("Book_id>>>>>>>>>"+Book_id);
	      BookInfo bkInfo = new BookInfo(Book_id, "Black Book", "nageshwar", 999, crdate,89);
	      BookService bookService = new BookServiceImpl();
	      
	      bookService.addBookDetails(bkInfo);
	  	  bookService.DeleteBookDetails( 61941 );
		  bookService.SearchBookById( 74819 );
		    bookService.SearchBookByName("Black Book" );
			BookInfo bk_update=new BookInfo();
			bk_update.setBook_id( 58545  );
			bk_update.setAuthor_name("Ashar");
			bookService.updateBookInfo(bk_update);

		
	      System.out.println("End the process....");
	   }
		private static int getGeneratedBookId() {
			Random rNumber=new Random();
			return rNumber.nextInt(10000);
		}
	}


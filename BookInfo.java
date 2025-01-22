package com.book.mgt;
import java.util.Date;
public class BookInfo {
	
	public int book_id;
	public String book_name;
	public String author_name;
	public int book_price;
	public Date crdate;
	public long nPage;
	public BookInfo() {}
	   
	   public BookInfo(int book_id, String book_name, String author_name, int book_price, Date crdate, long nPage) {
	      super();
		   this.book_id = book_id;
	      this.book_name = book_name;
	      this.author_name = author_name;
	      this.book_price = book_price;
	      this.crdate = crdate;
	      this.nPage=nPage;
	   }
	   
	   public BookInfo(int i, String string) {
			this.book_id = book_id; 
			this.author_name = author_name;
			// TODO Auto-generated constructor stub
		}
	   
	   public long getnpage() {
		   return nPage;
	   }
	   
	   public void intnPage(int nPage) {
		   this.nPage=nPage;
	   }

	   public int getBook_id() {
	      return this.book_id;
	   }

	   public void setBook_id(int book_id) {
	      this.book_id = book_id;
	   }

	   public String getBook_name() {
	      return this.book_name;
	   }

	   public void setBook_name(String book_name) {
	      this.book_name = book_name;
	   }

	   public String getAuthor_name() {
	      return this.author_name;
	   }

	   public void setAuthor_name(String author_name) {
	      this.author_name = author_name;
	   }

	   public int getBook_price() {
	      return this.book_price;
	   }

	   public void setBook_price(int book_price) {
	      this.book_price = book_price;
	   }

	   public Date getCrdate() {
	      return this.crdate;
	   }

	   public void setCrdate(Date crdate) {
	      this.crdate = crdate;
	   }

	   public String toString() {
		   return "BookInfo [book_id=" + this.book_id + ", book_name=" + this.book_name + ", author_name=" + this.author_name + ", book_price=" + this.book_price + ", crdate=" + this.crdate + ",nPage="+nPage+"]";
	   }
	}


package com.book.mgt;
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	public class BookServiceImpl implements BookService{
		
		public String BOOK_ADD_QUERY="insert into bookinfo_tbl values(?,?,?,?,?,?)";
		public String BOOK_DELETE_QUERY="delete from bookinfo_tbl where Bookid=?";
		public String BOOK_SEARCH_QUERY="select * from bookinfo_tbl where Bookid=?";
		public String BOOK_SEARCH_BY_NAME_QUERY="select * from bookinfo_tbl where Book_Name = ?";
	    public String BOOK_UPDATE_QUERY="update bookinfo_tbl set AuthorName=? where Bookid=?";
	    
		public Connection con=null;
		public PreparedStatement ps1=null;
		public PreparedStatement ps2=null;
		public PreparedStatement ps3=null;
		public PreparedStatement ps4=null;
		public PreparedStatement ps5=null;
		
		public int addBookDetails(BookInfo bk) {
			System.out.println("start calling BookServiceImpl- addBookDeatils()");
			System.out.println(bk.getBook_id());
			Connection con=myBookJDBCUtil.getMysqlConnection();
			try {
				ps1=con.prepareStatement(BOOK_ADD_QUERY);
				ps1.setInt(1, bk.getBook_id());
				ps1.setString(2,bk.getBook_name());
				ps1.setString(3, bk.getAuthor_name());
		        ps1.setInt(4, bk.getBook_price());
		        ps1.setDate(5, new Date(bk.getCrdate().getTime()));
				ps1.setLong(6, bk.getnpage());
		         
		         int x = this.ps1.executeUpdate();
		         System.out.println("Book Details has been succesfully inserted ");
		         
		         
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}

		@Override
		public boolean DeleteBookDetails(int bookId) {
			Connection con =myBookJDBCUtil.getMysqlConnection();
			try {
			ps2=con.prepareStatement(BOOK_DELETE_QUERY);
			ps2.setInt(1,bookId);
			int y= ps2.executeUpdate();
			if(y>0) {
			
			System.out.println("Book Deatils has been succesfully deleted ");
			}else {
				System.out.println("Book Deatils not able to delete ");
			}
			}
			catch(SQLException e) {
			
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
			return false;
		}

		@Override
		public int updateBookInfo(BookInfo bk) {
			// TODO Auto-generated method stub
			int status=0;
			
			System.out.println(">>>>>>>>>Updating records>>>>>>>>>>>>>>>>>>>>>>");
			Connection con =myBookJDBCUtil.getMysqlConnection();
			
			try {
				ps4=con.prepareStatement(BOOK_UPDATE_QUERY);
				ps4.setString(1, bk.getAuthor_name());
				ps4.setInt(2, bk.getBook_id());
				
			 status=ps4.executeUpdate();
			if(status>0) {                                                                          
				System.out.println("Record has been sucessful updated");
			}else {
				System.out.println("Record not able to update");
			}
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return status;
		}

		public ArrayList<BookInfo> SearchBookById() {
			// TODO Auto-generated method stub
			return null;
		}

		public void SearchBookByName() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public ArrayList SearchBookById(int bookId) {
			System.out.println(">>>>>>>>>Searching records>>>>>>>>>>>>>>>>>>>>>>");
			Connection con =myBookJDBCUtil.getMysqlConnection();
			BookInfo bk=null;
			try {
			ps3=con.prepareStatement(BOOK_SEARCH_QUERY);
			ps3.setInt(1, bookId);
			
			 ResultSet rs=ps3.executeQuery();
			 
			 while(rs.next()) {
				 
				 bk=new BookInfo();
				 bk.setBook_id(rs.getInt(1));
				 bk.setBook_name(rs.getString(2));
				 bk.setAuthor_name(rs.getString(3));
				 bk.setBook_price(rs.getInt(4));
				 bk.setCrdate(rs.getDate(5));
				 bk.intnPage(rs.getInt(6));
			 }
			 
			 System.out.println(bk);
			 
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
		
			return null;
		}
		@Override
		public ArrayList SearchBookByName(String bookname) {
			System.out.println(">>>Start searching record by Name >>>");
			Connection con =myBookJDBCUtil.getMysqlConnection();
			try {
				ps4=con.prepareStatement(BOOK_SEARCH_BY_NAME_QUERY);
				ps4.setString(1, bookname);
				ResultSet rs = ps4.executeQuery();
				boolean recordFound = false;
				while(rs.next()) {
					BookInfo bk = new BookInfo();
					bk.setBook_id(rs.getInt(1));
					bk.setBook_name(rs.getString(2));
					bk.setAuthor_name(rs.getString(3));
					bk.setBook_price(rs.getInt(4));
					bk.setCrdate(rs.getDate(5));
					recordFound = true;
					System.out.println(bk);		
				}
				if(!recordFound) {
					System.out.println("No book found with BookName: " + bookname);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

	}


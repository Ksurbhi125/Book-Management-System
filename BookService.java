package com.book.mgt;
	import java.util.ArrayList;

	public interface BookService {
	   int addBookDetails(BookInfo bk);

	   boolean DeleteBookDetails(int bookId);

	   int updateBookInfo(BookInfo bk);

	   ArrayList SearchBookById(int bookId);

	   ArrayList SearchBookByName(String bookname);

	}


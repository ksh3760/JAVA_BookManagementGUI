package p20201020책관리;

import java.sql.*;

public class MyDb {
	static Connection con;
	static Statement stmt;
	static String title, publisher, year;
	static int book_id, price;
	
	public MyDb() {
		// 1. JDBC 드라이버를 적재
		System.out.println("------------------------------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		}
			
		// 2. DB 연결
		String url		= "jdnc:oracle:thin:@net.yju.ac.kr:1521:orcl";	// oracle DB 접속을 위한 url
		String id 		= "s1701052";									// oracle DB 접속을 위한 아이디
		String password = "p1701052";									// oracle DB 접속을 위한 패스워드
		con 	= null;
		
		try {
			con = DriverManager.getConnection(url , id, password);
			System.out.println("연결 성공");
		} catch (SQLException e) {
			System.out.println("연결 오류");
		}

		System.out.println("------------------------------");
	}
	
	// 조회
	public static void SearchBook () {
		String bNum = MyFrame.tfs[0].getText();

		try {
			stmt = con.createStatement();
			String sql = null;
			sql = "select * from books where book_id = " + bNum ;
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while (rs.next()) {		 
				 book_id = rs.getInt("BOOK_ID");
				 title = rs.getString("TITLE");
	        	 price = rs.getInt("PRICE");
	        	 year = rs.getString("YEAR");
	        	 publisher = rs.getString("PUBLISHER");
			 }
			 
		} catch (Exception e) {
			System.out.println("조회 중 오류가 발생하였습니다.");
		}
		
	}
	
	
	// 삽입
	public static void InsertBook () {
		String bNum = MyFrame.tfs[0].getText();
		String bTitle= MyFrame.tfs[1].getText();
		String bPublisher = MyFrame.tfs[2].getText();
		String bYear = MyFrame.tfs[3].getText();
		String bPrice = MyFrame.tfs[4].getText();
		
		try {
			stmt = con.createStatement();
			
			String  sql = "INSERT INTO books(BOOK_ID, TITLE, PUBLISHER, YEAR, PRICE) values"
				+ "(" + bNum + ", '" + bTitle + "' , '" + bPublisher + "' , '" + bYear + "' ," + bPrice + ")";
			stmt.executeUpdate(sql);
			System.out.println("삽입에 성공했숩니다.");
	 
		} catch (Exception e) {
			System.out.println("이미 있는 책번호 입니다.");
			System.out.println("------------------------------");
		}

	}
	
	
	// 수정
	public static void UpdateBook () {
		String bNum = MyFrame.tfs[0].getText();
		String bTitle= MyFrame.tfs[1].getText();
		String bPublisher = MyFrame.tfs[2].getText();
		String bYear = MyFrame.tfs[3].getText();
		String bPrice = MyFrame.tfs[4].getText();
		
		try {
			stmt = con.createStatement();
			
			String  sql = "UPDATE books SET title =" +  " '" + bTitle + "' " 
										+ ",publisher = " + " '" + bPublisher + "' "
										+ ",year = "+  " '" + bYear + "' " 
										+ ",price = " + bPrice + "where book_id =" + bNum;
			stmt.executeUpdate(sql);
			System.out.println("수정에 성공했숩니다.");
	 
		} catch (Exception e) {
			System.out.println("수정 중 오류가 발생하였습니다.");
			System.out.println("------------------------------");
		}

	}
	
	
	// 삭제
	public static void DeleteBook () {
		String bNum = MyFrame.tfs[0].getText();
		String bTitle= MyFrame.tfs[1].getText();
		String bPublisher = MyFrame.tfs[2].getText();
		String bYear = MyFrame.tfs[3].getText();
		String bPrice = MyFrame.tfs[4].getText();
		
		try {
			stmt = con.createStatement();
			
			String  sql = "delete from books where book_id = " + bNum;
			
			stmt.executeUpdate(sql);
			System.out.println("삭제에 성공했숩니다.");
	 
		} catch (Exception e) {
			System.out.println("삭제 중 오류가 발생하였습니다.");
			System.out.println("------------------------------");
		}

	}
	
		
}// end public class MyDb

package p20201020å����;

import java.sql.*;

public class MyDb {
	static Connection con;
	static Statement stmt;
	static String title, publisher, year;
	static int book_id, price;
	
	public MyDb() {
		// 1. JDBC ����̹��� ����
		System.out.println("------------------------------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		}
			
		// 2. DB ����
		String url		= "jdnc:oracle:thin:@net.yju.ac.kr:1521:orcl";	// oracle DB ������ ���� url
		String id 		= "s1701052";									// oracle DB ������ ���� ���̵�
		String password = "p1701052";									// oracle DB ������ ���� �н�����
		con 	= null;
		
		try {
			con = DriverManager.getConnection(url , id, password);
			System.out.println("���� ����");
		} catch (SQLException e) {
			System.out.println("���� ����");
		}

		System.out.println("------------------------------");
	}
	
	// ��ȸ
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
			System.out.println("��ȸ �� ������ �߻��Ͽ����ϴ�.");
		}
		
	}
	
	
	// ����
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
			System.out.println("���Կ� �����߼��ϴ�.");
	 
		} catch (Exception e) {
			System.out.println("�̹� �ִ� å��ȣ �Դϴ�.");
			System.out.println("------------------------------");
		}

	}
	
	
	// ����
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
			System.out.println("������ �����߼��ϴ�.");
	 
		} catch (Exception e) {
			System.out.println("���� �� ������ �߻��Ͽ����ϴ�.");
			System.out.println("------------------------------");
		}

	}
	
	
	// ����
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
			System.out.println("������ �����߼��ϴ�.");
	 
		} catch (Exception e) {
			System.out.println("���� �� ������ �߻��Ͽ����ϴ�.");
			System.out.println("------------------------------");
		}

	}
	
		
}// end public class MyDb

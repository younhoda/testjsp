package product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {

	public ArrayList<ProductDTO> selectAll() throws Exception {
		// 1. 드라이버(connector) 셋팅
		Class.forName("com.mysql.jdbc.Driver");

		// 2. DB연결(->my서버설정+db명+id+pw)
		String url = "jdbc:mysql://localhost:3306/myshop";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL문 객체화
		String sql = "select * from product";
		PreparedStatement ps = con.prepareStatement(sql);

		// 4. SQL문 실행 요청
		ResultSet rs = ps.executeQuery();
		System.out.println("start " + rs.getRow());

		// 해당 row index의 값이 존재하는가? 체크..
		// System.out.println(rs.first());
		// System.out.println(rs.absolute(1));

		// 해당 ResultSet의 갯수를 구하는 방법..==========
		// rs의 맨 끝으로 이동
		// rs.last();
		// 그 맨 끝의 getRow()를 출력
		// System.out.println("레코드의 갯수는 " + rs.getRow());

		ProductDTO dto = null;
		ArrayList<ProductDTO> list = new ArrayList<>();

		while (rs.next()) { // 커서를 옮겨서 레코드가 있는지 체크
			System.out.println("row: " + rs.getRow());
			dto = new ProductDTO();

			String id = rs.getString(1);
			String title = rs.getString(2);
			String name = rs.getString(3);
			String price = rs.getString(4);

			dto.setId(id);
			dto.setTitle(title);
			dto.setName(name);
			dto.setPrice(price);

			list.add(dto);
			System.out.println();

		}
		return list;
	}

	public void update(String title,String price,String id ) throws Exception {
		// 1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");

		// 2.DB연결--(my서버설정+db명+id+pw)
		String url = "jdbc:mysql://localhost:3306/bigdata";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql문 객체화
		String sql = "update product set title=?,price=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,title);
		ps.setString(2,price);
		ps.setString(3,id);
		

		// 4.sql문 실행 요청
		ps.executeUpdate();
		System.out.println("sql문 요청 완료");

	}

	public ProductDTO select(String input) throws Exception {
		// 1. 드라이버(connector) 셋팅
		Class.forName("com.mysql.jdbc.Driver");

		// 2. DB연결(->my서버설정+db명+id+pw)
		String url = "jdbc:mysql://localhost:3306/myshop";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL문 객체화
		String sql = "select * from product where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, input);

		// 4. SQL문 실행 요청
		ResultSet rs = ps.executeQuery();
		ProductDTO dto = null;
		while (rs.next()) { // 커서를 옮겨서 레코드가 있는지 체크
			dto = new ProductDTO();

			String id = rs.getString(1);
			String title = rs.getString(2);
			String name = rs.getString(3);
			String price = rs.getString(4);

			dto.setId(id);
			dto.setTitle(title);
			dto.setName(name);
			dto.setPrice(price);
		}
		return dto;
	}

	public void delete(String id) throws Exception {
		// 1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");

		// 2.DB연결--(my서버설정+db명+id+pw)
		String url = "jdbc:mysql://localhost:3306/myshop";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql문 객체화
		String sql = "delete from product where title=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4.sql문 실행 요청
		ps.executeUpdate();
		System.out.println("sql문 요청 완료");

	}

	public void insert(ProductDTO dto) throws Exception {
		// 1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");

		// 2.DB연결--(my서버설정+db명+id+pw)
		String url = "jdbc:mysql://localhost:3306/myshop";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql문 객체화
		String sql = "insert into product values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getPrice());

		// 4.sql문 실행 요청
		ps.executeUpdate();
		System.out.println("sql문 요청 완료");

	}

}

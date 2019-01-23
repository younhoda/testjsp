package product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {

	public ArrayList<ProductDTO> selectAll() throws Exception {
		// 1. ����̹�(connector) ����
		Class.forName("com.mysql.jdbc.Driver");

		// 2. DB����(->my��������+db��+id+pw)
		String url = "jdbc:mysql://localhost:3306/myshop";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL�� ��üȭ
		String sql = "select * from product";
		PreparedStatement ps = con.prepareStatement(sql);

		// 4. SQL�� ���� ��û
		ResultSet rs = ps.executeQuery();
		System.out.println("start " + rs.getRow());

		// �ش� row index�� ���� �����ϴ°�? üũ..
		// System.out.println(rs.first());
		// System.out.println(rs.absolute(1));

		// �ش� ResultSet�� ������ ���ϴ� ���..==========
		// rs�� �� ������ �̵�
		// rs.last();
		// �� �� ���� getRow()�� ���
		// System.out.println("���ڵ��� ������ " + rs.getRow());

		ProductDTO dto = null;
		ArrayList<ProductDTO> list = new ArrayList<>();

		while (rs.next()) { // Ŀ���� �Űܼ� ���ڵ尡 �ִ��� üũ
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
		// 1.����̹� ����
		Class.forName("com.mysql.jdbc.Driver");

		// 2.DB����--(my��������+db��+id+pw)
		String url = "jdbc:mysql://localhost:3306/bigdata";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql�� ��üȭ
		String sql = "update product set title=?,price=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,title);
		ps.setString(2,price);
		ps.setString(3,id);
		

		// 4.sql�� ���� ��û
		ps.executeUpdate();
		System.out.println("sql�� ��û �Ϸ�");

	}

	public ProductDTO select(String input) throws Exception {
		// 1. ����̹�(connector) ����
		Class.forName("com.mysql.jdbc.Driver");

		// 2. DB����(->my��������+db��+id+pw)
		String url = "jdbc:mysql://localhost:3306/myshop";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL�� ��üȭ
		String sql = "select * from product where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, input);

		// 4. SQL�� ���� ��û
		ResultSet rs = ps.executeQuery();
		ProductDTO dto = null;
		while (rs.next()) { // Ŀ���� �Űܼ� ���ڵ尡 �ִ��� üũ
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
		// 1.����̹� ����
		Class.forName("com.mysql.jdbc.Driver");

		// 2.DB����--(my��������+db��+id+pw)
		String url = "jdbc:mysql://localhost:3306/myshop";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql�� ��üȭ
		String sql = "delete from product where title=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4.sql�� ���� ��û
		ps.executeUpdate();
		System.out.println("sql�� ��û �Ϸ�");

	}

	public void insert(ProductDTO dto) throws Exception {
		// 1.����̹� ����
		Class.forName("com.mysql.jdbc.Driver");

		// 2.DB����--(my��������+db��+id+pw)
		String url = "jdbc:mysql://localhost:3306/myshop";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql�� ��üȭ
		String sql = "insert into product values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getPrice());

		// 4.sql�� ���� ��û
		ps.executeUpdate();
		System.out.println("sql�� ��û �Ϸ�");

	}

}

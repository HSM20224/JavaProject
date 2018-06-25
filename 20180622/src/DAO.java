import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DAO {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/test?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "1234";
	static int rowCount;
	private String msgs = "****** 이전 대화 ******\n";

	public Connection getConn() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
			// this.getCount();
		} catch (Exception e) {
			e.printStackTrace();
		} // try - catch
		return con;
	} // getConn : 연결 메소드 작성

	public int insertChat(TcpServer dto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = getConn();
			String sql = "insert into chat values(?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getContents());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				} // ps try - catch
			} // ps if
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				} // con try - catch
			} // con if
		} // try - catch - finally
		return result;
	} // insertMember : 채팅내용을 저장하는 메소드, 성공 여부를 int형 result 를 반환한다.

	public String getChat() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConn();
			String sql = "select * from chat";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String name = rs.getString("name");
				String contents = rs.getString("con");
				
				String msg = name+ " : " + contents;
				msgs += msg + "\n";
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				} // rs try - catch
			} // rs if
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				} // ps try - catch
			} // stmt if
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				} // con try - catch
			} // con if
		}
		return msgs+"\n****** 이전 대화 ******";// try - catch - finally
	} // getChat : 채팅내용을 가져오는 메서드
}
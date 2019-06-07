import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		String databaseUrl = "jdbc:mysql://localhost:3306/jdbc-test";
		String databaseUser = "root";
		String password ="Abcd@1234";
		String driverDb = "com.mysql.jdbc.Driver";
		Connection connection = null;
		try {
			Class.forName(driverDb);
			connection = DriverManager.getConnection(databaseUrl,databaseUser,password);
			print(connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	public static void insert(Connection con) {
		String sql = "insert into student(Name,Age, Address) values (?,?,?)";
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Giant");
			ps.setInt(2, 28);
			ps.setString(3, "HCM");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void print(Connection con) {
		String sql  = "select * from student";
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				System.out.println("Id = " + rs.getInt("Id") + "& Ten = " + rs.getString(2) + "& dia chi = " + rs.getString(4)
				+"& tuoi = " + rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

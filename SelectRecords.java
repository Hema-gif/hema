
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRecords {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "hema");
			st = con.createStatement();
			boolean b = st.execute("select * from movies");
			System.out.println(b);
			rs = st.getResultSet();
			System.out.println("name\tactor\tactress\tdirector\tyearofrelease");
			System.out.println("-----------------------------");
			while(rs.next()) {
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("actor")+"\t");
				System.out.print(rs.getString("actress")+"\t");
				System.out.print(rs.getString("director")+"\t");
				System.out.print(rs.getInt("yearOfRelease")+"\t");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

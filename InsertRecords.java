
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertRecords {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "hema");
			st = con.createStatement();
			st.executeUpdate("insert into movies values('uppena','vteja','keerthi','babu',2021)");
			st.executeUpdate("insert into movies values('aaa','nithnin','samantha','babu',2018)");
			st.executeUpdate("insert into movies values('hai','vteja','keerthi','babu',2017)");
			st.executeUpdate("insert into movies values('poja','vishal','shruthihasan','babu',2016)");
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				st.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

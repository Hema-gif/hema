import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "hema");
		Statement st = con.createStatement();
		st.executeUpdate("create table emp1(ENO number(3) primary key, ENAME varchar2(10), ESAL float(5), EADDR varchar2(10))");
		System.out.println("Table emp1 Created Successfully");
		st.close();
		con.close();
	}
}
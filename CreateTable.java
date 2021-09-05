import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "hema");
		Statement st = con.createStatement();
		st.executeUpdate("create table movies(name varchar2(20),actor varchar2(20),actress varchar2(20),director varchar(20),yearOfrelease number(4)");
		System.out.println("Table movie Created Successfully");
		st.close();
		con.close();
	}
}
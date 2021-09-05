
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertRecords {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "hema");
			st = con.createStatement();
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.print("Employee Number    : ");
				int eno = Integer.parseInt(br.readLine());
				
				System.out.print("Employee Name      : ");
				String ename = br.readLine();
				
				System.out.print("Employee Salary    : ");
				float esal = Float.parseFloat(br.readLine());
				
				System.out.print("Employee Address   : ");
				String eaddr = br.readLine();
				
				st.executeUpdate("insert into emp1 values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')");
				System.out.println("Employee "+eno+" Inserted Successfully");
				System.out.print("Onemore Employee[Yes/No]?    : ");
				String option = br.readLine();
				if(option.equalsIgnoreCase("yes")) {
					continue;
				}else {
					System.out.println("======Thank You for Inserting Records=======");
					break;
				}				
			}			
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

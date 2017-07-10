package drivers;

/*Developer : TANDOH
 * Company  :Tanamo Inc.
 * Email: tanamoinc@gmail.com
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Driver {

	public static void main(String args[]) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");

			System.out.print("Database is connected !");
			conn.close();
		} catch (Exception e) {
			System.out.print("Try Again - Error:" + e);
		}
	}
}
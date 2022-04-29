import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class UD18 {

	//Atributos de la clase relativos a la BD.
	private static String db_ = "Nombre Base de Datos";
	private static String login_ = "Usuario de la Base de Datos";
	private static String password_ = "Contrase�a";
	private static String url_ ="jdbc:mysql://ip_servidor/"+db_;
			
	//Atributos privados para almacenar la conexi�n MySQL.
	private static Connection connection_;
	private static Statement st_ = null;
	
	public UD18() {

		try {
			//Obtener el driver para MySQL.
			Class.forName("com.mysql.jdbc.Driver");
			//Obtener la conexi�n.
			connection_ = DriverManager.getConnection(url_, login_, password_);
			if (connection_ != null) {
				st_ = connection_.createStatement();
				System.out.println("Conexi�n a base de datos " + db_ + " correcta.");	
			}else
				System.out.println("Conexi�n fallida.");
		}catch (SQLException e) {e.printStackTrace();}
		 catch (ClassNotFoundException e) {e.printStackTrace();}
		 catch (Exception e) {e.printStackTrace();}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

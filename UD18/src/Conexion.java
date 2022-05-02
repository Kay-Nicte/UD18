import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {



	public Connection conexion() {
		try {
			//Obtener el driver para MySQL.
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtener la conexión.
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC","root","P@ssw0rd");
			System.out.println("Server Connected");	
			return conexion;
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error al conectar a la base de datos");
			System.out.println(ex);
			return null;
		}
	}
	
	public void createDB(String tiendaInformatica) {
		
		try {
			Connection conexion = conexion();
			String Query = "CREATE DATABASE IF NOT EXISTS "+tiendaInformatica;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Se ha creado la base de datos "+tiendaInformatica+" de forma correcta");
		} catch (SQLException ex) {
			System.out.println("Error al crear la base de datos");
			System.out.println(ex);
		}
	}
	
	public void createTable(String db, String Fabricantes) {
		
		try {
			Connection conexion = conexion();
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.execute(Querydb);
			
			String Querytb = Fabricantes;
			Statement st = conexion.createStatement();
			st.execute(Querytb);
			System.out.println("Tabla creada con éxito");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al crear la tabla");
		}
	}
}
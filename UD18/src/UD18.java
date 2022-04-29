import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class UD18 {

	public static void main(String[] args) {

		try {
			//Obtener el driver para MySQL.
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtener la conexión.
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC","root","P@ssw0rd");
			System.out.println("Server Connected");		
		}catch(SQLException | ClassNotFoundException ex ) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
	}
	
	private void MySQLConnection(String string, String string2, String name) {
		// TODO Auto-generated method stub
		
	}
	
	
	private static Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//MÉTODO QUE FINALIZA LA CONEXIÓN A MYSQL 
	public void closeConnection() throws SQLException {
		//Conexion.close();
		JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
	}
	
	
	//MÉTODO QUE CREA BASE DE DATOS 
	public void createDB(String name) {
		try {
			String Query = "CREATE DATABASE" + name;
			Statement st = UD18.createStatement();
			st.executeUpdate(Query);
			closeConnection();
			MySQLConnection("root", "", name);
	JOptionPane.showMessageDialog(null, "Se ha creado la base de datos "+name+" de forma exitosa.");
		} catch (SQLException ex) {
	//		Logger.getLogger(MySQL.class.getName().log(Level.SEVERE, null, ex));
		}
	}
	
	
	//MÉTODO QUE CREA TABLAS MYSQL
	public static void createTable(String db, String name) {
		try {
			String Querydb = "USE "+db+";";
			Connection conexion = null;
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "CREATE TABLE "+name+"(ID INT PRIMARY KEY AUTO INCREMENT, Nombre VARCHAR(50), Apellido VARCHAR(50), Edad VARCHAR(3), Sexo VARCHAR(1))";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito");
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	//MÉTODO QUE INSERTA DATOS EN TABLAS MYSQL
	public static void insertData(String db, String table_name, String name, String lastname, String age, String gender) {
		try {
			String Querydb = "USE"+db+";";
			Connection conexion = null;
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + " (Nombre, Apellido, Edad, Sexo) VALUE "+ name +","+lastname+","+age+","+gender+";";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	//MÉTODO QUE ELIMINA VALORES DE NUESTRA BASE DE DATOS
	public void deleteRecord(String table_name, String ID) {
	/*	try {
			String Query = "DELETE FROM "+table_name+" WHERE ID = "+ID;
			Statement st = Conexion.createStatement();
			st.executeUpdate(Query);
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}*/
	}
}
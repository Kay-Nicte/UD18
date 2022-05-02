public class UD18App {

	public static void main(String[] args) {

	Conexion conexionMysql = new Conexion();
	
		conexionMysql.conexion();
		//conexionMysql.createDB("Tienda_Informatica");
		conexionMysql.createTable("Tienda_Informatica", "CREATE TABLE Articulos (Codigo INT Primary Key, Nombre VARCHAR(100), Precio INT, Fabricante INT)");
		
	}
}
# Driver UcanAccess to connect databases

The JDBC-ODBC bridge is no longer shipped/supported with JDK 8.
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver") will not compile with Java 1.8. The JDBC ODBC is provided and supported by Oracle which has stopped
supporting these drivers since Java 8. The recommended suggestion is to use the drivers
provided the by the DB vendors and the adopt the driver code change in the script.

## Pasos para cargar la base de datos de Access a partir de Java 8

1. Hay que cargar la clase del driver de MS Access para Java 8
(ucanaccess.jdbc.UcanaccessDriver). Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

2. Editar la clase ConnectionUtils de la aplicación northbrick3, para modificar la conexión a la BBDD y utilizar el driver UcanAccess. Modificaremos los métodos getConnection.


```
public static Connection getConnection(ServletConfig config) {
		Connection connection = null;
		
		public static Connection getConnection(ServletConfig config) {
		Connection connection = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			ServletContext context = config.getServletContext();
			System.out.println("realPath: " + context.getRealPath("northbrick.mdb"));
			String dbURL = "jdbc:ucanaccess://" + context.getRealPath("northbrick.mdb");
			connection = DriverManager.getConnection(dbURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:northbrick";
			connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
```

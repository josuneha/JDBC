UcanAccess

The JDBC-ODBC bridge is no longer shipped/supported with JDK 8.
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver") will not compile with Java 1.8. The JDBC ODBC is provided and supported by Oracle which has stopped
supporting these drivers since Java 8. The recommended suggestion is to use the drivers
provided the by the DB vendors and the adopt the driver code change in the script.

Pasos para cargar la base de datos de Access a partir de Java 8
1. Hay que cargar la clase del driver de MS Access para Java 8
(ucanaccess.jdbc.UcanaccessDriver). Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

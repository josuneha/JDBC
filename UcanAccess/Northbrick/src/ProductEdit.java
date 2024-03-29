import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProductEdit extends HttpServlet {
	Connection connection;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		connection = ConnectionUtils.getConnection(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter toClient = res.getWriter();
		toClient.println(Utils.header("Product Form"));
		toClient.println("<form action='ProductUpdate' method='GET'>");
		toClient.println("<table border='1'>");
		String idStr = req.getParameter("id");
		ProductData product = ProductData.getProduct(connection, idStr);
		toClient.println("<tr><td>Id</td>");
		toClient.println("<td><input name='productId' value='" + product.productId + "'></td></tr>");
		toClient.println("<tr><td>Name</td>");
		String name = product.productName;
		System.out.println("Name: " + name);
		name = name.replace("'", "&#39;");
		System.out.println("Name: " + name);
		toClient.println("<td><input name='productName' value='" + name + "'></td></tr>");
		toClient.println("<tr><td>Supplier</td>");
		toClient.println("<td><input name='supplierId' value='" + product.supplierId + "'></td>");
		toClient.println("<tr><td>Price</td>");
		toClient.println("<td><input name='unitPrice' value='" + product.unitPrice + "'></td>");
		toClient.println("</tr>");
		toClient.println("<tr><td>Image</td>");
		toClient.println("<td><img src='http://northbrick1.appspot.com/images/" + product.productId + ".png'></td>");
		toClient.println("</tr>");
		toClient.println("</table>");
		toClient.println("<input type='submit'>");
		toClient.println("</form>");
		toClient.println(Utils.footer("Product Form"));
		toClient.close();
	}
}
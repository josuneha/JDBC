import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProductUpdate extends HttpServlet {
	Connection connection;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		connection = ConnectionUtils.getConnection(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String idStr = req.getParameter("productId");
		ProductData product = new ProductData(req.getParameter("productId"), req.getParameter("productName"),
				Integer.parseInt(req.getParameter("supplierId")), null,
				Float.parseFloat(req.getParameter("unitPrice")));
		int n = ProductData.updateProduct(connection, product);
		res.sendRedirect("ProductEdit?id=" + idStr + "&a=" + Math.random());
	}
}
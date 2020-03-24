import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;

@SuppressWarnings("serial")
public class CustomerOrderList extends HttpServlet {
	Connection connection;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		connection = ConnectionUtils.getConnection(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter toClient = res.getWriter();
		String id = req.getParameter("id");

		System.out.println("id customerOrderList: " + id);
		toClient.println(Utils.header("CustomerOrderList"));
		printCategoryTable(toClient, connection, id);

		// ejercicio 2
		// toClient.println("<script src=createOrder.js></script>");

		// toClient.println("<form action='OrderInsert' method='Get'>");
		// toClient.println("<input name='id' type='hidden' value='" + id +
		// "'></input>");

		toClient.println(Utils.footer("CustomerOrderList"));
		toClient.close();
	}

	public static void printCategoryTable(PrintWriter toClient, Connection connection, String id) {
		toClient.println("<table id='order' border='1'>");
		Vector<OrderData> orderList;
		// int id2=Integer.parseInt(id);

		orderList = OrderData.getOrderListXCustomer(connection, id);
		for (int i = 0; i < orderList.size(); i++) {
			OrderData order = orderList.elementAt(i);
			toClient.println("<tr>");
			toClient.println("<td>" + order.orderId + " </td>");
			toClient.println("<td>" + order.orderDate + " </td>");
			// toClient.println("<td>" + order.employeeId + " </td>");
			toClient.println("<td><a href='OrderEdit?id=" + order.orderId + "'>Products</a></td>");
			// toClient.println("<td><a href='CategoryEdit?id=" + category.categoryId +
			// "'>Edit</a></td>");
			toClient.println("</tr>");
		}

		toClient.println("</table>");

		// toClient.println("</form>");
	}
}

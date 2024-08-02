package org.jsp.emart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update_page")
public class UpdatePageServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id=Integer.parseInt(req.getParameter("id")) ;
			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emart","root", "root");
				PreparedStatement ps = con.prepareStatement("select * from product where id=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				req.setAttribute("rs", rs);
				RequestDispatcher rd= req.getRequestDispatcher("update.jsp") ;
				rd.include(req, resp);
				rs.close();
				ps.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

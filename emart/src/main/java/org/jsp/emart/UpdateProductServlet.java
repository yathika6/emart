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

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		String name= req.getParameter("name");
		Double price= Double.parseDouble(req.getParameter("price"));
		String brand= req.getParameter("brand");
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emart","root", "root");
			 ps = con.prepareStatement("update product set name=?, price=?, brand=? where id=?");
			ps.setString(1,name);
			ps.setDouble(2, price);
			ps.setString(3,brand);
			ps.setInt(4, id);
			int row=ps.executeUpdate();
			System.out.println(row+" : row affected");
			ps = con.prepareStatement("select * from product");
			rs=ps.executeQuery();
			req.setAttribute("rs", rs);
			RequestDispatcher rd= req.getRequestDispatcher("allproducts.jsp");
			rd.forward(req, resp);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

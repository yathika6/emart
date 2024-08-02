package org.jsp.emart;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				String email= req.getParameter("email");
				String password = req.getParameter("password");
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emart","root","root");
					ps= con.prepareStatement("select * from user where email=? and password=?");
					ps.setString(1, email);
					ps.setString(2, password);
					rs = ps.executeQuery();
					if(rs.next()) {
						if(rs.getString(5).equalsIgnoreCase("user")) {
//							ps=con.prepareStatement("select * from product");
//							rs=ps.executeQuery();
//							req.setAttribute("rs",rs);
							RequestDispatcher rd=   req.getRequestDispatcher("userhome.jsp");
							rd.forward(req, resp);
						}
						else if(rs.getString(5).equalsIgnoreCase("admin")) {
							resp.getWriter().write("<html><body><h2 id='id'>login successful</h2></body></html>");
							RequestDispatcher rd=   req.getRequestDispatcher("home.jsp");
							rd.include(req, resp);
						}
						else {
							resp.getWriter().write("<html><body><h2 id='id'>login successful</h2></body></html>");
							RequestDispatcher rd=   req.getRequestDispatcher("login.jsp");
							rd.include(req, resp);
						}
						
					}
					else
						{
						PrintWriter pw= resp.getWriter();
						pw.write("<html><body><h1>Invalid Credentials</h1></body></html>");
						RequestDispatcher rd=  req.getRequestDispatcher("login.jsp");
						rd.include(req, resp);
						}
					
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
}

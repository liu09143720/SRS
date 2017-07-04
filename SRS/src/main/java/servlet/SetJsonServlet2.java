package servlet;

import service.WebService;
import util.org.json.JSONArray;
import util.org.json.JSONObject;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;
/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/SetJsonServlet2")
public class SetJsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetJsonServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");  
	    response.setCharacterEncoding("UTF-8");  
	    response.setHeader("Cache-Control", "no-cache");  
		PrintWriter out=response.getWriter();
		
		WebService userService = new WebService();
		
		JSONArray ja=new JSONArray();
		JSONObject jo=new JSONObject();
		jo.put("sid","05");
		jo.put("option","6kkkkk");
		ja.put(jo);
		 jo=new JSONObject();
		jo.put("sid","09");
		jo.put("option","1kkkkk");
		ja.put(jo);
		 jo=new JSONObject();
		jo.put("tid","06");
		jo.put("enrolled","2kkkkk");
		ja.put(jo);
		jo=new JSONObject();
		jo.put("tid","04");
		jo.put("enrolled","4kkkkk");
		ja.put(jo);
		
		out.print(ja.toString());
		out.close();
		/*
		Connection con=DbUtil.getConnection();
		JSONArray ja=new JSONArray();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from Guitar");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				JSONObject jo=new JSONObject();
				jo.put("type",rs.getString("type"));
				jo.put("color",rs.getString("color"));
				ja.put(jo);
			}
			out.print(ja.toString());
			out.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}

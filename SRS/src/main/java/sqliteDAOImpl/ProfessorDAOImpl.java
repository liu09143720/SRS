package sqliteDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SRSDAO.ProfessorDAO;

import model.Person;
import model.Professor;
import util.DBUtil;







public class ProfessorDAOImpl implements ProfessorDAO{
	private Connection conn = DBUtil.getSqliteConnection();
	private PreparedStatement stmt=null;
	private SQLException ex=null;
	
	@Override
	public void updateTeachers(Professor ud) {
		// TODO Auto-generated method stub
		try{                                                        
			
			stmt = conn.prepareStatement("UPDATE Professor set name=?,department=? where ssn=?");
			stmt.setString(1, ud.getName());
			stmt.setString(2, ud.getDepartment());
			stmt.setString(3, ud.getSsn());
			stmt.executeUpdate();
			
		}catch(SQLException e){
			ex=e;
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					if(ex==null){
						ex=e;
					}
				}
			}
		if(ex!=null){
			throw new RuntimeException(ex);
		}
		}
	}

	@Override
	public void deleteTeachers(String[] deletes) {
		// TODO Auto-generated method stub
		try{
			
			for(int i=0;i<deletes.length;i++){
				stmt=conn.prepareStatement("DELETE FROM Professor WHERE ssn=?");
				stmt.setString(1,deletes[i]);
				//stmt.setString(2, administrator.getPassword());
				stmt.executeUpdate();
			}
		}catch(SQLException e){
			ex=e;
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					if(ex==null){
						ex=e;
					}
				}
			}
		if(ex!=null){
			throw new RuntimeException(ex);
		}
		}
	}

	@Override
	public void addProfessor(Professor add1) {
		// TODO Auto-generated method stub
		try{
			stmt=conn.prepareStatement("INSERT INTO Professor(ssn,name,department,password) VALUES(?,?,?,?)");
			stmt.setString(1, add1.getSsn());
			stmt.setString(2,add1.getName());
			stmt.setString(3, add1.getDepartment());
			stmt.setString(4, "123456");//Ä¬ÈÏÃÜÂë
			
			
			stmt.executeUpdate();
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
	}

	@Override
	public List<Professor> getProfessors() {
		// TODO Auto-generated method stub
		List<Professor> pros=null;
		Professor pro=null;
		
		try{
			
			stmt=conn.prepareStatement("SELECT ssn,name,department,password FROM Professor");
			/*stmt.setString(1, admin.getCname());
			stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			pros=new ArrayList<Professor>();
			while(rs.next()){
				pro=new Professor(rs.getString("name"),rs.getString("ssn"),"", rs.getString("department"));
				
				pros.add(pro);
			}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return pros;
	}

	@Override
	public Person signInProfessor(Person admin) {
		// TODO Auto-generated method stub
		Professor pro=null;
		
		try{
			
			stmt=conn.prepareStatement("SELECT ssn,name,department,password FROM Professor WHERE ssn=? and password=?");
			stmt.setString(1, admin.getSsn());
			stmt.setString(2, admin.getPassword());
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				pro=new Professor(rs.getString("name"),rs.getString("ssn"),"", rs.getString("department"));
				
				
			}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return pro;
	}
	
	
	
	
	
}

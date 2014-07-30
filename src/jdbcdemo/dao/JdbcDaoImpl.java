package jdbcdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jdbcdemo.model.Circle;

@Component
public class JdbcDaoImpl {


	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	/*public Circle getCircle(int id){

		Connection conn =null;

		try {
		
			conn=dataSource.getConnection();
			
			PreparedStatement ps =conn.prepareStatement("SELECT * FROM circle where id =?");
			ps.setInt(1, id);

			Circle circle=null;
			ResultSet rs=ps.executeQuery();

			if (rs.next()){
				circle=new Circle(id, rs.getString("name"));
			}

			rs.close();
			ps.close();

			return circle;
		}
		catch (Exception e){

			throw new RuntimeException(e);
		}

		finally {
			try{conn.close();
			}
			catch(SQLException e ){	}
		}

	}
	*/
	
	public int getCircleCount(){
		
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
				
	}
		
	public String getCircleName(int id){
		
		String sql="SELECT NAME FROM CIRCLE WHERE ID=? ";
		return jdbcTemplate.queryForObject(sql,new Object[]{id}, String.class);
	}

	public Circle getCircleForId(int id){
		String sql="SELECT * FROM CIRCLE WHERE ID=? ";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CircleMapper());
	}
	
	public List<Circle> getAllCricles(){
		String sql="SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insertCircle(Circle circle){
		
		String sql="INSERT INTO CIRCLE(ID, NAME) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(), circle.getName()});
	}
	
	public void createTriangleTable(){
		String sql="CREATE TABLE TRIANGLE (ID INTEGER, NAME CHAR(50))";
		jdbcTemplate.execute(sql);
	}
	
	
	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle=new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			
			return circle;
		}
		
	}

}
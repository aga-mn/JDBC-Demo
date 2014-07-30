package jdbcdemo.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {

	public int getCricleCount(){
		
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return this.getSimpleJdbcTemplate().queryForInt(sql);
	}
	
}

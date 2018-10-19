package lizhe.shiro.test.logintest.dao;

import java.sql.Timestamp;

import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.mapper.BaseMapper;
import lombok.Data;

import static lizhe.shiro.test.logintest.config.MyBeeltSqlConfig.$;

@Data
public class Myuser extends TailBean{
	
	private Long id ;
	//用户名
	private String userName ;
	//用户密码
	private String userPassword ;
	//会员ID
	private Long userSex ;
	
	private Long userStatus ;
	
	private Timestamp createdAt ;
	
	private Timestamp updatedAt ;
	
	
	public interface Dao extends BaseMapper <Myuser> {
		Dao $ = $().getMapper(Dao.class);
	}

}

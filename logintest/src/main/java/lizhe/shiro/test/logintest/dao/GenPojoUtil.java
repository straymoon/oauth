package lizhe.shiro.test.logintest.dao;

import javax.sql.DataSource;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;

import lombok.Data;
@Data
public class GenPojoUtil {

	private static String driver = "com.mysql.jdbc.Driver";
	
	private static String url = "jdbc:mysql://localhost:3306/db_t100?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=convertToNull&useSSL=false";
	
	private static String dbName = "db_t100";
	
	private static String userName = "root";
	
	private static String password = "root~!@#";
	
	public static void main(String[] args) {
		
		try {
			genPojo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void genPojo() throws Exception {
		
		ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, dbName, userName, password);
		DBStyle mysql = new MySqlStyle();
		// sql语句放在classpagth的/sql 目录下
		SQLLoader loader = new ClasspathLoader("/sql");
		// 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的
		UnderlinedNameConversion nc = new  UnderlinedNameConversion();
		// 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
		SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
		
		 sqlManager.genPojoCodeToConsole("teach_lesson_content");
	}
	
	
}

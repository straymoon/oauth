package lizhe.shiro.test.logintest.config;

import javax.sql.DataSource;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import lombok.Data;

@Configuration
@Data
public class MyBeeltSqlConfig{
	

	  //开启事务
	  @Bean
	  public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("datasource") DataSource datasource) {
	    DataSourceTransactionManager dsm = new DataSourceTransactionManager();
	    dsm.setDataSource(datasource);
	    return dsm;
	  }
	  
	  
	  @Bean(name = "sqlManagerFactoryBean")
	    @Primary
	    public SqlManagerFactoryBean getSqlManagerFactoryBean(@Qualifier("datasource") DataSource datasource) {
	        SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
	
	        BeetlSqlDataSource source = new BeetlSqlDataSource();
	        source.setMasterSource(datasource);
	        factory.setCs(source);
	        factory.setDbStyle(new MySqlStyle());
	        factory.setInterceptors(new Interceptor[]{new DebugInterceptor()});
	        factory.setNc(new UnderlinedNameConversion());//开启驼峰
	        factory.setSqlLoader(new ClasspathLoader("/sql"));//sql文件路径
	        return factory;
	    }
	  
	//配置包扫描
    @Bean(name = "beetlSqlScannerConfigurer")
    public BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
        BeetlSqlScannerConfigurer conf = new BeetlSqlScannerConfigurer();
        conf.setBasePackage("lizhe.shiro.test.logintest.dao");
        conf.setDaoSuffix("Dao");
        conf.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
        return conf;
    }
    
    static SQLManager $;
    
    public static SQLManager $() {
    	return $;
    }
    
    public static void $(SqlManagerFactoryBean sqlManagerFactoryBean) {
    	try {
			$ = sqlManagerFactoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * 
 */
package lizhe.shiro.test.logintest.druid;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.stereotype.Component;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author Bean
 *
 */
@Component
@WebFilter(
	filterName = "druidWebStatFilter", 
	urlPatterns = "/druid/*", 
	initParams = {
		@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
	}
)
public class DruidStatFilter extends WebStatFilter {

}

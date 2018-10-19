package lizhe.shiro.test.logintest.ctl;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class JVMtest extends ClassLoader {
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		return super.findClass(name);
	}
	
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MalformedURLException {
		
		File distDir = new File("C:\\Users\\bell\\Desktop\\");
        if (!distDir.exists()) {
            distDir.mkdirs();
        }
		
		JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
		
		
		int compileResult = javac.run(null, null, null,"-d", distDir.getAbsolutePath(),"C:\\Users\\bell\\Desktop\\Testbian.java");
		
		
		URL url = new URL("file:C:\\Users\\bell\\Desktop\\");
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});


		
		Class klass = classLoader.loadClass("Testbian");
        Method evalMethod = klass.getMethod("call");
        String result = (String)evalMethod.invoke(klass.newInstance());

			

	}

}	

package hello;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println("********************************************");
        System.out.println("Looking at classpath ...");
        
        //Get context class loader
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //Get the URLs
        URL[] urls = ((URLClassLoader)classLoader).getURLs();

        for(int i=0; i< urls.length; i++)
        {
            System.out.println(urls[i].getFile());
        }     
        
        System.out.println("********************************************");
        String testfile = "/home/vcap/app/.java-buildpack/open_jdk_jre/ASSEMBLY_EXCEPTION";
        System.out.println(String.format("Printing contents of %s ...",testfile));
        try {
			BufferedReader input = new BufferedReader(new FileReader(testfile));
	        String text;
			while (input.ready()){
	        	text = input.readLine();
	        	System.out.println(text);
	        }
			input.close();
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("********************************************");
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

}
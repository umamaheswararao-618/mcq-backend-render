import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
public class Main {
	public static void main(String[] args)
	{
		Properties p=new Properties();
		
		try {
			InputStream is=new FileInputStream("C:/Users/UMA MAHESWARARAO/Downloads/filedb.txt");
			p.load(is);
			String url=p.getProperty("url");
			String user=p.getProperty("username");
			String pass=p.getProperty("password");
	//	Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection con=DriverManager.getConnection(url,user,pass);
		System.out.println(con);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
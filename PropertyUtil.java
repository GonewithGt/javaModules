package gt.gone.hanwang.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;


public class PropertyUtil {
	 static String profileName="conf.properties";
	// static String defaultPath = "conf.properties";
	 private static Properties props = new Properties();
	 public static String getValue(String key) {  
	        try {  
	            /*//InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("common.properties"); 
	        	String ss = PropertyUtil.class.getResource("/").getPath();  
		       // System.out.println(ss);  
		        //String s = new File(ss).getParentFile().getParentFile().getPath();
	        	String s = JarToolUtil.getJarDir();
		        String filepath = s + File.separator+profileName;
		        String defaultFilePath = new File(ss).getParentFile().getPath()+File.separator + profileName; 
		        File file = new File(filepath);
		        File defaultfile = new File(defaultFilePath);
		        FileInputStream fileInputStream = null ;
		       // System.out.println(filepath);
		        if(file.exists()){	//判断配置文件是否存在
		        	fileInputStream = new FileInputStream(filepath);
		        	//System.out.println("filePath" + filepath);
		        	JOptionPane.showMessageDialog(null, "filePath" + filepath);
		        }else if(defaultfile.exists()){
		        	fileInputStream = new FileInputStream(defaultFilePath);
		        	JOptionPane.showMessageDialog(null, "defaultPath = "+defaultFilePath);
		        	//System.out.println("defaultPath = "+defaultFilePath);
		        }
		        
		        JOptionPane.showMessageDialog(null, "defaultPath = "+defaultFilePath);
		        JOptionPane.showMessageDialog(null, "filePath" + filepath);*/
	        	String s = JarToolUtil.getJarDir();
	        	String filepath = s + File.separator+profileName;
	        	File file = new File(filepath);
	        	
			   // FileInputStream fileInputStream = null ;
			    InputStreamReader inputStreamReader = null;
			       // System.out.println(filepath);
			        if(file.exists()){	//判断配置文件是否存在
			        	/*fileInputStream  = new FileInputStream(filepath);
			        	inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");*/
			        	FileInputStream fis = new FileInputStream(file);
			        	   //可检测多种类型，并剔除bom
			        	BOMInputStream bomIn = new BOMInputStream(fis, false,ByteOrderMark.UTF_8, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_16BE);
			        	   String charset = "utf-8";
			        	   //若检测到bom，则使用bom对应的编码
			        	   if(bomIn.hasBOM()){
			        		   charset = bomIn.getBOMCharsetName();
			        	   }
			        	   inputStreamReader = new InputStreamReader(bomIn, charset);
			        	//JOptionPane.showMessageDialog(null, "filePathOK = " + filepath);
			        }else{
			        	//JOptionPane.showMessageDialog(null, "filePathOK = " + filepath);
			        	 JOptionPane.showMessageDialog(null, "配置文件不存在");
			        }
			        
	            props.load(inputStreamReader);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return (String) props.get(key);  
	    }  
	 
	 /*test*/
	 public static void main(String []args){
		// URI  uri = Paths.get("resource/dblook.properties", null).toAbsolutePath().toUri();
        // System.out.println(uri);
		System.out.println(getValue("FILEPATH"));
	       // String system_str = System.getProperty("user.dir");  
	       // System.out.println(system_str);  
	 }
	 

}

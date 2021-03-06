package ren.zhaoruncheng.autocodebytemplate.file.manipulate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * 
 * @author Holmes
 * read content from file and return a String contains the file's content
 */
public class ReadFile {
	
	private String path;
	
	private File file;
	
	public String getString(){
		StringBuilder sb=new StringBuilder();
		try{
			String encoding="UTF-8";
			if(file.isFile()&&file.exists()){
				//create a reader
				InputStreamReader read=new InputStreamReader(
						new FileInputStream(file),encoding);
				//create a buffer reader
				BufferedReader bufferedReader=new BufferedReader(read);
				String lineTxt=null;
				
				while((lineTxt=bufferedReader.readLine())!=null){
					//read character every line
					sb.append(lineTxt);
					sb.append("\n");
				}
			}else{
				System.out.println("no file exist");
			}
		}catch(Exception e){
			System.out.println("reader file error");
			 e.printStackTrace();
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
	
	public ReadFile(String path){
		this.path=path;
		this.file=new File(path);
	}
	
	public ReadFile(File file){
		this.file=file;
	}
}

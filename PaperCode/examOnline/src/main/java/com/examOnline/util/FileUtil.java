/*package com.examOnline.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.GregorianCalendar;

*//**
 * @author cdy
 *
 *//*
public class FileUtil {

	public static String readFile(String path) throws IOException{
		File file = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		file = new File(path);
		br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
		String line = null;   
        sb = new StringBuffer((int) file.length());   
        while ((line = br.readLine()) != null) {   
            sb.append(line);   
        }   
        br.close();   
		return sb.toString();
        BASE64Encoder encoder = new BASE64Encoder(); 
        return encoder.encode(br.toString().getBytes("GBK"));
	}
	public static String fileWriterStr(String path,String fileName,String msg){
		GregorianCalendar gcNow = new GregorianCalendar();
	   // String localDir=File.separator+gcNow.get(GregorianCalendar.YEAR)+File.separator+(Integer.parseInt(gcNow.get(GregorianCalendar.MONTH)+"")+1)+File.separator+gcNow.get(GregorianCalendar.DAY_OF_MONTH);
	    
	    
		File file=new File(path);
        if(!file.exists()){
            file.mkdirs(); 
        }
        String filePath = path+File.separator+fileName+".txt";
        File f=new File(filePath);
        FileWriter fw = null;
        try {
			fw=new FileWriter(f);
			fw.write(msg);
			fw.close();
		 } catch (IOException e) {
			e.printStackTrace();
		 }
        return filePath;
	}
	*//** 
     * @Title:  
     * @Description: TODO(��һ�ű���ͼƬת����Base64�ַ�) 
     * @param imgPath 
     * @return 
     *//*  
    public static String readFileToBase64(String imgPath) {  
        InputStream in = null;  
        byte[] data = null;  
        // ��ȡͼƬ�ֽ�����  
        try {  
            in = new FileInputStream(imgPath);  
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        // ���ֽ�����Base64����  
        BASE64Encoder encoder = new BASE64Encoder(); 
        // ����Base64�������ֽ������ַ�  
        String s = encoder.encode(data).replace("\n", "");
        s = s.replace(" ", "");
        return s;
    }  
    *//**
     * /���ֽ������ַ����Base64���벢���ͼƬ 
     * @param imgStr
     * @return
     *//*
    public static boolean GenerateImage(String imgStr,String path,String name) { 
    	
	      if (imgStr == null) //ͼ�����Ϊ�� 
	        return false; 
	      BASE64Decoder decoder = new BASE64Decoder(); 
	      try 
	      { 
	        //Base64���� 
	        byte[] b = decoder.decodeBuffer(imgStr); 
	        for(int i=0;i<b.length;++i) 
	        { 
	          if(b[i]<0) 
	          {//�����쳣��� 
	            b[i]+=256; 
	          } 
	        } 
	        //���jpegͼƬ 
	       // String imgFilePath = "d://222.jpg";//����ɵ�ͼƬ 
	        String imgFilePath = path + name;
	        OutputStream out = new FileOutputStream(imgFilePath);   
	        out.write(b); 
	        out.flush(); 
	        out.close(); 
	        return true; 
	      }  
	      catch (Exception e)  
	      { 
	        return false; 
	      } 
    } 
	public static void main(String[] args) throws IOException {
		System.out.println(readFile("E:/12/500.gif"));
		System.out.println(readFileToBase64("E:/12/banner3.jpg"));
		
	}

}
*/
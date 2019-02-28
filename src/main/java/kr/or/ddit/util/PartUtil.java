package kr.or.ddit.util;

public class PartUtil {

	public static String getFileNameFromPart(String contentDisposition) {
		
		String[] splits = contentDisposition.split("; ");
		String filename = "";
		
		for(String split : splits) {
			if(split.startsWith("filename=")) {
				filename = split.substring(split.indexOf("\"")+1,split.lastIndexOf("\""));
			
			
			}
			
		}
		
		
		
		
		return filename;
	}

}

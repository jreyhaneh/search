package searchProcess;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import search.DocStor;
import search.Document;
import search.InvertedIndex;
import search.PostingList;
import search.once;



public class token {
	

 
private static final String pun = ".,-_;:!#@()$*&%^|?'\"`~/\\";

private static boolean isSplitter(char c) {
	
	return Character.isWhitespace(c) || pun.indexOf(c)>=0;
		
}

    
public static List<String> tokenize(String s){
	
		  
	ArrayList<String> tokens=new ArrayList<>();
	  
	StringBuilder builder = new StringBuilder();
	

	
	for (int i=0 ;i<s.length() ;i++) {
		char y=s.charAt(i);
		if(isSplitter(y) && builder.length()>0) {
			tokens.add(builder.toString());
			builder.setLength(0);
		}
		else {
			if(!isSplitter(y))
			builder.append(y);
		}
	}
	if(builder.length()>0)
		tokens.add(builder.toString());
   

	
	
return tokens;
  }
    
//public static void main(String[] args) throws IOException {
//List<String> texts = Arrays.asList("the spring of a lion","the great gatsby","three little kittens");
//DocStor store=new DocStor();
//InvertedIndex index=new InvertedIndex();
//
//for (String name :texts) {
//	InputStream stream = once.class.getResource("/text/"+ name +".txt").openStream();
//    String body=new String(stream.readAllBytes());
//    List<String> str  =  token.tokenize(body);
//    for (String s:str) {
//    	String nor =normall.normalize(s);
//    	//System.out.println(nor);
//    	}
//}

}
//}


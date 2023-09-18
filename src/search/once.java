package search;

import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import searchProcess.normall;
import searchProcess.token;

public class once {

	public static void main(String[] args) throws IOException {
		List<String> docmain = null;
	    List<String> texts = Arrays.asList("three little kittens","the spring of a lion","the great gatsby");
    	DocStor store=new DocStor();
        InvertedIndex index=new InvertedIndex();
       ArrayList<String> book1 = new ArrayList<String>();
        ArrayList<String> book2 = new ArrayList<String>();
        ArrayList<String> book3 = new ArrayList<String>();
   
        int i=0;		
	    for (String name :texts) {
	    
		InputStream stream = once.class.getResource("/text/"+ name +".txt").openStream();
        String nor=new String(stream.readAllBytes());
        List<String> str  =  token.tokenize(nor);
        docmain=str;
        i++;
     
        for (String s:str) {
        	
        String body =normall.normalize(s);
  
        if(i==1) {
        book1.add(body);
       }
        
        if(i==2) {
        book2.add(body);
           }
        
        if(i==3) {
        book3.add(body);
           }
       
        Document document=new Document(name,body); 
		store.add(document);
		index.add(document);
		} 
	    }
	    
	    while(true) {
	    System.out.println();
	
		System.out.print("enter your query:");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine(); 
		if (line.equals("end")) 
	    return;
		
		
		double f=0;
		List<String> lin =token.tokenize(line);
		
		for (String g:lin) {	
		String linear =normall.normalize(g);
	    PostingList list=index.get(linear);
        for(Integer docId : list.getDocIds()) {
	    f++;
	    }}
      
    
		    double idf= Math.log(docmain.size()/f);
		   /////////////////////////  
			double result1 = 0;
			for (String g:lin) {
				String lop=normall.normalize(g); 
			for (String word : book1) {
			if (lop.equalsIgnoreCase(word))
		    result1++;}}
		    double tf1=(result1 / book1.size());
		    ////////////////////////////
		    double result2 = 0;
		    for (String g:lin) {
				String lop=normall.normalize(g); 
			for (String word : book2) {
			if (lop.equalsIgnoreCase(word))
		    result2++;}}
		    double tf2=(result2 / book2.size());
		    /////////////////////////////////
		    double result3 = 0;
		    for (String g:lin) {
				String lop=normall.normalize(g); 
			for (String word : book3) {
			if (lop.equalsIgnoreCase(word))
		    result3++;}}
		    double tf3=(result3 / book3.size());
		    /////////////////////////////////////
		    double TfIdf1 = tf1 * idf;
		    double TfIdf2 = tf2 * idf;
		    double TfIdf3 = tf3 * idf;
		   //////////////////////////////////////////
//		    System.out.println("Tf_Idf1:"+"  "+TfIdf1);
//		    System.out.println("Tf_Idf2:"+"  "+TfIdf2);
//		    System.out.println("Tf_Idf3:"+"  "+TfIdf3);
		     
		    double[] number= {TfIdf1,TfIdf2,TfIdf3};
		        Arrays.sort(number);
		        double x=0;
                int j=0;
		        for(int k=2;k>-1;k--) {
		       
		            if(number[k]!=0) {
		            	
		              j++;
		              
		        if(number[k]==TfIdf1)
		        System.out.println("doc"+ j +" : three little kitten");
		        
		        if(number[k]==TfIdf2)
		        System.out.println("doc"+ j +": the spring of a lion");
		        	
		        if(number[k]==TfIdf3)
	        	System.out.println("doc"+ j +" : the great gatsby");    
		        } 
		          
    } 
		        System.out.println("------------------");
	}
	}
	}
	

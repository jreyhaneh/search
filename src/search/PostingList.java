package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PostingList {
   private List<Integer> docIds=new ArrayList<>();
   
  // PostingList() {
	   
  // }
   
	   PostingList(int... ids){
   for(int id  : ids) {
	   docIds.add(id);
   }}
   public void add(int id) {
	   docIds.add(id);
   }
   
   public void sort() {
	   Collections.sort(docIds);
   }
   public int size() {
	 return docIds.size(); 
	 }
   public List<Integer> getDocIds() {
		 return docIds; 
		 }
	 
	 @Override
	 public String toString() {
	return Arrays.toString(docIds.toArray(new Integer[0]));
	 }
	
	 
   
   public PostingList and(PostingList other) {
	   PostingList result =new PostingList();
	  int i=0 , j=0;
	 
 while(i<size() && j<other.size()) {
	 int a=docIds.get(i);
	 int b= other.docIds.get(j);
	 if(a==b) {
		result.add(a);
		i++;
		j++;
	 }
	 else if (a<b){
		 i++;
	 }
	 else {
		 j++;
	 } 
	 }
 return result ;
 }
//   
//   public PostingList or(PostingList other) {
//	   PostingList result =new PostingList();
//	  int k=0 , p=0;
//	 
// while ( k<size()&&p<other.size() ) {
//	 int c=docIds.get(k);
//	 int d= other.docIds.get(p);
//	 
//	 if(c==d) {
//		 result.add(c);
//		k++;
//		p++;
//	 }
//		
//	 else if (c<d){
//		 result.add(c);
//		 k++;
//	 }
//	 
//	 else {
//		 result.add(d);
//		 p++;
//	 }
//	 }
// 
//
// if(k>=size()) {
//	 while(p<other.size()) {
//		 int d= other.docIds.get(p);
//		 result.add(d);
//		 p++;
//		 
//	}
//	}
//	 
//	if(p>=other.size()) {
//	while(k<size()) {
//	int c=docIds.get(k);
//	result.add(c);
//	 k++;
//	 
//	}
//	}
//	
//
// return result ;
// 
//}
}

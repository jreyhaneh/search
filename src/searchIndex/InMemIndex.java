package searchIndex;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import search.Document;
import searchProcess.normall;
import searchProcess.token;

public class InMemIndex {
	private Map<String , Set<Document>> table =new HashMap<>();
	
public void add(Document doc) {
	String normalized=normall.normalize(doc.getBody());
	List<String> tokens=token.tokenize(normalized);
	for(String token:tokens) {
	table.putIfAbsent(token,new HashSet<>());
	table.get(token).add(doc);
	}
}
public Set<Document> query(String q){
	String normalized=normall.normalize(q);
	List<String> tokens=token.tokenize(normalized);
	Set<Document> result=new HashSet<>();
	if(tokens.isEmpty())
		return result;
	result=table.getOrDefault(tokens.get(0), new HashSet<>());
	
	for(int i=1;i<tokens.size();i++) {
		result.retainAll(table.getOrDefault(tokens.get(i), new HashSet<>()));
	}
	return result;
	
	
}
}

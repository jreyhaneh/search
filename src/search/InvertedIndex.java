package search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvertedIndex {
private Map<String, PostingList> table =new HashMap<>();

public void add(Document document) {
	
	
	String[] tokens=document.getBody().toString().split("\\s+");
    Set<String> distincTokens = new HashSet<>();
    for(String token:tokens) {
    	distincTokens.add(token);
    }
    
    for(String token: distincTokens) {
    	table.putIfAbsent(token,new PostingList());
        table.get(token).add(document.getDocId());
    }
    for(PostingList list: table.values()) {
    	list.sort();
    }
    }
public PostingList get(String line) {
	return table.get(line);
}
}

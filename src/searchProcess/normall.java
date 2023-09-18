package searchProcess;

import java.util.HashMap;
import java.util.Map;

public class normall {
	private static Map<Character,Character> table=new HashMap<>();
	static {table.put( 'ي' , 'ی');
	        table.put( 'ك' , 'ک');
	}
	
	public static String normalize(String s) {
		StringBuilder builder = new StringBuilder(s.length());
		for (int i=0; i<s.length();i++) {
			char c=s.charAt(i);
			Character converted=table.get(c);
			if(converted !=null)
				c=converted;
			builder.append(Character.toLowerCase(c));
		}
		return builder.toString();
		}
public static void main(String[] args) {
	System.out.println(normalize("بووك"));
}
	
	
}

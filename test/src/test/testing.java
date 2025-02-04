package test;


import java.util.*;
import java.util.Map.Entry;
public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	 HashMap<String,String> map = new HashMap<>();

    map.put("123","AAA");
    map.put("234","BBB");
    map.put("567","EEE");

 for(  Entry<String, String>value  : map.entrySet() ) {
	 
	String ne1 = value.getKey();
	
	if (ne1.contains("567")) {
		
	String ne2=	value.getValue();
	
	
	}
 }

	}

}

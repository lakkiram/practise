package operators;

import java.util.ArrayList;
import java.util.List;

public class Mulitiple {

	public static void main(String[] args) {
		
		List<String> dogList = new ArrayList<String>();
		dogList.add("border collie");
		dogList.add("cattle dog");
		dogList.add("xyz");
		
		for(int i=0; i < dogList.size(); i++) {
			System.out.println(dogList.get(i));
		}
		
	}
	
	
}
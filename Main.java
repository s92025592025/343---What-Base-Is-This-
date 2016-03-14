import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Main{
	public static final Map<String, Integer> numberList = makeNumberList();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String input1 = sc.next();
			String input2 = sc.next();
		}
	}

	public static Map<String, Integer> makeNumberList(){
		Map<String, Integer> temp = new HashMap<String, Integer>();
		for(int i = 65; i < 91; i++){
			temp.put(Character.toString((char)i), i - 55);
		}

		return temp;
	} 
}

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Main{
	public static final Map<String, Integer> numberList = makeNumberList();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String input1 = sc.next();
			String input2 = sc.next();
			List<Integer> converted1 = findAllConvert(input1);
			//System.out.println(converted1.toString());
			int base1 = -1, base2 = -1;
			for(int i = 2; i < 37; i++){
				if(convert(i, input2) != null && converted1.contains(convert(i, input2))){
					base2 = i; 
					base1 = converted1.indexOf(convert(i, input2)) + 2;
					break;
				}
			}

			if(base1 < 0){
				System.out.println(input1 + " is not equal to " + input2 + " in any base 2..36");
			}else{
				System.out.println(input1 + " (base " + base1 + ") = " + input2+ " (base " + base2 + ")");
			}

		}
	}

	public static Map<String, Integer> makeNumberList(){
		Map<String, Integer> temp = new HashMap<String, Integer>();
		for(int i = 65; i < 91; i++){
			temp.put(Character.toString((char)i), i - 55);
		}

		return temp;
	}

	public static List<Integer> findAllConvert(String input){
		List<Integer> list = new ArrayList<Integer>();

		for(int i = 2; i < 37; i++){
			list.add(convert(i, input));
		}

		return list;
	}

	public static Integer convert(int base, String input){
		int sum = 0;
		int decimal = 1;
		for(int i = input.length(); i > 0; i--){
			if(input.charAt(i - 1) > 64 && input.charAt(i - 1) < 91){
				if(numberList.get(input.substring(i - 1, i)) >= base){
					return null;
				}

				sum += numberList.get(input.substring(i - 1, i)) * decimal;
			}else{
				if(Integer.parseInt(input.substring(i - 1, i)) >= base){
					return null;
				}

				sum += Integer.parseInt(input.substring(i - 1, i)) * decimal;
			}

			decimal *= base;
		}

		return sum;
	}

}

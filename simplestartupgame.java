package ch1;
import java.util.*;
class inputs{//class for taking inputs 
	public String getuserinputs(String enter) {
		Scanner no = new Scanner(System.in);
		System.out.print(enter+" : ");		
		return no.next();
	}
}
class simplestartup{
	private ArrayList<String> startupcell=new ArrayList<String>() ;//location of the startupcells
	int noofhits =0 ;//no of time we hit the startupcell
	
	String check(String guess) {
		String result="miss";
		//int index = startupcell.indexOf(guess);
		if(startupcell.contains(guess)) {
			startupcell.remove(guess);
			result="hit";
		}
			if(startupcell.isEmpty()) {
				result="startup has been kill";
			}
			
		
		//-----------------------------------------
//		for(int cell:startupcell) {
//			if(guess==cell) {
//				result="hit";
//				noofhits++;
//				for(int i = 0; i<3; i++) {
//					if(startupcell[i]==guess) {
//						startupcell[i]= -12;
//						break;
//					}
//				}
//				break;
//			}
//		}
//		if(noofhits==startupcell.length) {
//             result = "startup is killed";
//		}
		//return result;//return "hit" "miss" 
//		 String result = "miss";
//	        int index = startupcell.indexOf(guess);
//	        if (index >= 0) {
//	        	   startupcell.remove(index);
//	        	}
//	        if (startupcell.isEmpty()) {
//	        	   result = "kill";
//	        	} else {
//	        	   result = index == -1 ? "miss" : "hit";
//	        	}
	        return result;
		
	}
	public void setstartupcell(int[] startupcell1) {
//		for(int i = 0; i<startupcell.length;i++) {
//			this.startupcell.add(String.valueOf(i));
//		}
		for(int val:startupcell1) {
			startupcell.add(String.valueOf(val));
		}
		//take an arrayList  and set in the virtual grid 
	}
}
public class simplestartupgame {
	public static void main(String[] args) {
		simplestartup obj = new simplestartup();
		Random sc = new Random();
		inputs obj1 =new inputs();
		int noofguess=0;
		int rm = sc.nextInt(4);
		int[] arr=new int[3];
		//ArrayList<String> arr = new ArrayList<String>();
		for(int i =0 ; i<3; i++) {
			arr[i]=rm++;
			//rm++;
		}
		
		obj.setstartupcell(arr);
		boolean isalive = true;
        while(isalive) {
            String guess = obj1.getuserinputs("enter your number ");
        	noofguess++;
        	String output=obj.check(guess);
        	if(output.equals("startup has been kill")) {
        		isalive=false;
        		System.out.println("you took total : "+noofguess+" guesses");
        	}
        	System.out.println(output);
        	
        }	
		
		
	}

}

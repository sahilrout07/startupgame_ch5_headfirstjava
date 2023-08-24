//Here I have used ArrayList but It can also done with the help of the array.
//class-inputs , simplestartup , simplestartupgame(main class)
//methods - getuserinputs() , check() , setstartupcell()
package ch1;
import java.util.*;
//class for taking inputs as String from the user from the command line and return the String. Instead of this, we can also write scanner for taking inputs in the main method.   
class inputs{
	public String getuserinputs(String enter) {
		Scanner no = new Scanner(System.in);
		System.out.print(enter+" : ");		
		return no.next();
	}
}
class simplestartup{
	
	private ArrayList<String> startupcell=new ArrayList<String>();//declare and initialize  an ArrayList for place location of the startupcells in a virtual 1x7 grid
	
	String check(String guess) { //this method is used to check if the user guesses matching the startupcell location or not, if matching then remove that element and return "hit" or "miss".If the ArrayList is empty then retrun "startup has been killed". 
		String result="miss";//default result
		//int index = startupcell.indexOf(guess);
		//startup.remove(index);
		//We can also use this instead of what we have written below.
		if(startupcell.contains(guess)) {
			startupcell.remove(guess);
			result="hit";
		}
		if(startupcell.isEmpty()) {
			result="startup has been kill";
		}	
		
	        return result;
	}
	//this is an important step because we are taking an int array and converting its elements to String so we can add this to our ArrayList String.valueOf(datatype var)->this will change any datatype to starting.  
	public void setstartupcell(int[] startupcell1) {
		for(int val:startupcell1) {
			startupcell.add(String.valueOf(val));//ArrayList should be declared and initialized otherwise will show an error. and set it in the virtual grid.
		}
	}
}
public class simplestartupgame {
	public static void main(String[] args) {
		simplestartup obj = new simplestartup();
		Random sc = new Random();
		inputs obj1 =new inputs();
		int noofguess=0;
		int rm = sc.nextInt(4);// random number between 0 to 4
		int[] arr=new int[3];//array of size 3
		for(int i =0 ; i<3; i++) {//array creation 
			arr[i]=rm++;
		}
		
		obj.setstartupcell(arr);//send array through arguments 
		boolean isalive = true; // let  take a default situation where the game is active ie. startup is not killed yet.
        while(isalive) {
            String guess = obj1.getuserinputs("enter your number ");
        	noofguess++;// to count the no of guesses user make in total.
        	String output=obj.check(guess); // send guess as an argument to check the result "hit" "miss" "startup has been killed".
        	if(output.equals("startup has been kill")) {
        		isalive=false;//to stop the game if the final cell also hit ie. startup has been killed.
        		System.out.println("you took total : "+noofguess+" guesses");
        	}
        	System.out.println(output);
        	
        }		
	}
}

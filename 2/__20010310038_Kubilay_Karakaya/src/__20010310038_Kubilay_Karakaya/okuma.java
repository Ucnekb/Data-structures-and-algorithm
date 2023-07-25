package __20010310038_Kubilay_Karakaya;

import java.util.Scanner;

public class okuma {
	public Scanner input;
	public String [] h;
	public int [] f=null;
	
	public  okuma(Scanner input){
		
		this.input=input;
		 String line =input.nextLine();
		 
		 if (line.contains("değişkenler:")) {//değişkenler
	         String[] parts = line.split(":");
	             String harfler = parts[1].trim();
	              h = harfler.split(",");
	         }
		 else if (line.contains("deÄŸiÅŸkenler:")) { //deÄŸiÅŸkenler
		         String[] parts = line.split(":");
		             String harfler = parts[1].trim();
		              h = harfler.split(",");         
		         }
		 else if (line.contains(":")) {
	         String[] parts = line.split(":");
	             String harfler = parts[1].trim();
	              h = harfler.split(",");         
	         }
		 
		 System.out.println("karnaugh.txt dosyas� okundu.");
		 if(h.length==3) {
			 map3 map3=new map3(h,input);
		 }
		 else if (h.length==4) {
			 map4 map4=new map4(h,input);
		 } 	 
	}
}


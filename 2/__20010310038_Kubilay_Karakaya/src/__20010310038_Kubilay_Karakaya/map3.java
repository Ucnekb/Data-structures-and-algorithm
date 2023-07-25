package __20010310038_Kubilay_Karakaya;

import java.util.Scanner;

public class map3 {
	public Scanner input;
	public String [] h;
	public int [] f=null;
	public  boolean bak=false;
	public  boolean bak2=false;
	
	
	
	public map3(String [] h,Scanner input) {
		
		this.h =h;
		this.input=input;
		
		int [] f=new int [8];
		  input.nextLine();
			  for(int i=0;i<8;i++) {
				  f[i]=input.nextInt();
				  if(i==3) {
					int a =f[i];
					f[i]=f[i-1];
					f[i-1]=a;
				  }
				  else if (i==7) {
					  int a =f[i];
						f[i]=f[i-1];
						f[i-1]=a;
				  }
				  
			  }
			  this.h =h;  
			  this.f=f;
			 System.out.println("doğruluk tablosu:");
			 System.out.println(h[0]+ " "+ h[1]+ " " +h[2] + " " + " F");
			  System.out.println("0" +" " +  " 0" + "  "+"0" + "  "+ f[0]);
			  System.out.println("0" +" " +  " 0" + "  "+"1" + "  "+ f[1]);
			  System.out.println("0" +" " +  " 1" + "  "+"0" + "  "+ f[2]);
			  System.out.println("0" +" " +  " 1" + "  "+"1" + "  "+ f[3]);
			  System.out.println("1" +" " +  " 0" + "  "+"0" + "  "+ f[4]);
			  System.out.println("1" +" " +  " 0" + "  "+"1" + "  "+ f[5]);
			  System.out.println("1" +" " +  " 1" + "  "+"0" + "  "+ f[6]);
			  System.out.println("1" +" " +  " 1" + "  "+"1" + "  "+ f[7]);

			  System.out.println("fonksiyon ifadeleri:");
		System.out.println(minterm(f,h,bak));
		System.out.println(maxterm(f,h,bak2));
		f=tümle(f);
		System.out.println(minterm(f,h,bak));
		System.out.println(maxterm(f,h,bak2));
			
			
		}
	public  String minterm(int [] f , String [] h ,boolean bak) {
		 int b=0;
		 
		int [] m=new int [8];
		for(int i=0;i<f.length;i++) {
			if(f[i]==1) {
				m[b]=i;
				b++;
			}	
		}
		String son=null;
		if(bak==false) {
			 son="f= ";
			bak=true;
			this.bak=bak;
		}
		else if(bak==true) {
			 son="f'= ";
			bak=false;
			this.bak=bak;
		}
		
		String [] n=new String [8];
		n [0] =  "("+h[0]+"'"+"."+h[1]+"'"+"."+h[2]+"'"+")";          //"(A'.B'.C')";   0  0  0
		n [1] =  "("+h[0]+"'"+"."+h[1]+"'"+"."+h[2]+")";             //"(A'.B'.C)";     0  0  1               
		n [2] =  "("+h[0]+"'"+"."+h[1]+"."+h[2]+"'"+  ")";          //"(A'.B.C')";      0  1  0
		n [3] = "("+h[0]+"'"+"."+h[1]+"."+h[2]+ ")";               //"(A'.B.C)";        0  1  1       
		n [4] =  "("+h[0]+"."+h[1]+"'"+"."+h[2]+"'"+")";          //"(A.B'.C')";        1  0  0 
		n [5] =  "("+h[0]+"."+h[1]+"'"+"."+h[2]+")";                 //"(A.B'.C)";          1  0  1                                        
		n [6] =  "("+h[0]+"."+h[1]+"."+h[2]+"'"+")";            //"(A.B.C')";           1  1  0
		n [7] =  "("+h[0]+"."+h[1]+"."+h[2]+")";               //"(A.B.C)";             1  1  1
		
		for(int i=0;i<b;i++) {
			if(i!=0) {
				son+=" +"+ n[m[i]];
			}
			else {
				son+=n[m[i]];
			}
		}
	
		return son;
		
	}
	public  String maxterm(int [] f , String [] h,boolean bak2) {
		 int c=0;
			int [] M=new int [8];
			for(int i=0;i<f.length;i++) {
				if(f[i]==0) {
					M[c]=i;
					c++;
				}	
			}
			String son=null;
			if(bak2==false) {
				 son="f= ";
				bak2=true;
				this.bak2=bak2;
			}
			else if(bak2==true) {
				 son="f'= ";
				bak2=false;
				this.bak2=bak2;
			}
			String [] n=new String [8];
			n [0] =  "("+h[0]+"+"+h[1]+"+"+h[2]+")";                                     //"(A.B.C)";   0  0  0
			n [1] =  "("+h[0]+"+"+h[1]+"+"+h[2]+"'"+")";                               //"(A.B.C')";     0  0  1               
			n [2] =  "("+h[0]+"+"+h[1]+"'"+"+"+h[2]+  ")";                            //"(A.B'.C)";      0  1  0
			n [3] = "("+h[0]+"+"+h[1]+"'"+"+"+h[2]+"'"+ ")";                         //"(A.B'.C')";        0  1  1       
			n [4] =  "("+h[0]+"'"+ "+"+h[1]+"+"+h[2]+")";                           //"(A'.B.C)";        1  0  0 
			n [5] =  "("+h[0]+"'"+"+"+h[1]+"+"+h[2]+"'"+")";                       //"(A'.B.C')";          1  0  1                                        
			n [6] =  "("+h[0]+"'"+"+"+h[1]+"'" +"+"+h[2]+")";                     //"(A'.B'.C)";           1  1  0
			n [7] =  "("+h[0]+"'" +"+"+h[1]+"'" +"+"+h[2]+"'"+")";               //"(A'.B'.C')";             1  1  1
			
			for(int i=0;i<c;i++) {
				if(i!=0) {
					son+=" ."+ n[M[i]];
				}
				else {
					son+=n[M[i]];
				}
				
			}
			
			return son;
		}
	public static int [] tümle(int [] f) {
		for(int i=0;i<f.length;i++) {
			if(f[i]==1) {
				f[i]=0;
			}
			else if (f[i]==0 ){
				f[i]=1;
			}
		}
		return f;
		
	}
	
		
	}


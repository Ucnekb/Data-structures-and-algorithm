import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Scanner  input=new Scanner(System.in);
   System.out.println(" l�tfen say� giriniz");
   int kare=input.nextInt();
   
  int top=0;
  int son=0;
   
   char[] secilenKarakterler = karakterSec(kare);
   
   
   int[][] dikdortgenler = diktortgenOlustur(kare);
   
   printArray(dikdortgenler);
   printCharArray(secilenKarakterler);
   System.out.println(" ");
   
   
   desenleriYazdir(kare,dikdortgenler,secilenKarakterler,son);
   ikinciEkran(dikdortgenler,secilenKarakterler,son);
   
   while (top!=kare) {
	 
   System.out.print("Bir harf girin: ");
   char harf = input.next().charAt(0);
   if(harf=='a'||  harf=='A') {
	   top++;
	   secilenKarakterler = deleteAndCopyChar(secilenKarakterler);
	   
	   
	   dikdortgenler = deleteAndCopy(dikdortgenler);
	   System.out.println("S�LME �ALI�TI ");
	   
	   printArray(dikdortgenler);
	   printCharArray(secilenKarakterler);
	   kare--;
	  
   }
   if(top==kare)
   {
	   System.out.println( "dizi bo� ");
	   break;
   }
   
   
   if (harf == 's' || harf == 'S') {
       son++; // E�er girilen harf 's' veya 'S' ise "son" de�i�keni 1 art�r�l�r.
       System.out.println("if deki son 1 art� :" + son);
       
       if (son >= kare) {
           son = 0; // "son" de�eri 3'ten b�y�kse 0'a d�nd�r�l�r.
       }

   }
   else  if (harf == 'w' || harf == 'W') {
       son--; // E�er girilen harf 's' veya 'S' ise "son" de�i�keni 1 art�r�l�r.
       System.out.println("if bir azalt�ld�");
       System.out.println("w de ki son  : " + son);
      
       
       if (son < 0) {
           son = kare-1; // "son" de�eri 3'ten b�y�kse 0'a d�nd�r�l�r.
           System.out.println("son==0 oldu :"+ son );
       }
   }
   System.out.println("whildeki son "+ son);
   desenleriYazdir(kare,dikdortgenler,secilenKarakterler,son);
   ikinciEkran(dikdortgenler,secilenKarakterler,son);
   
	}
	}
	
	
	public static char[] karakterSec(int say�) {
        // Rastgele say� �retmek i�in Random s�n�f�n� kullanal�m
        Random random = new Random();

        char[] secilenKarakterler = new char[say�];

        for (int i = 0; i < say�; i++) {
            // 1 ile 4 aras�nda rastgele bir say� se�elim
            int secilenSayi = random.nextInt(4) + 1;

            // Say�ya g�re karakter se�imi yapal�m
            char secilenKarakter;
            switch (secilenSayi) {
                case 1:
                    secilenKarakter = '$';
                    break;
                case 2:
                    secilenKarakter = '-';
                    break;
                case 3:
                    secilenKarakter = '+';
                    break;
                case 4:
                    secilenKarakter = 'x';
                    break;
                default:
                    secilenKarakter = '$'; // Varsay�lan olarak '$' karakterini d�nd�relim
                    break;
            }

            secilenKarakterler[i] = secilenKarakter;
        }

        return secilenKarakterler;
    }
	 
	 public static int[][] diktortgenOlustur(int sayi) {
	        Random random = new Random();
	        int[][] dikdortgenler = new int[sayi][2];

	        for (int i = 0; i < sayi; i++) {
	            int genislik = random.nextInt(46) + 5; // 5-50 aras�nda rastgele bir say� (0 ile 45 aras�na 5 ekleyerek) 46
	            int yukseklik = random.nextInt(2) + 3; // 3-10 aras�nda rastgele bir say� (0 ile 7 aras�na 3 ekleyerek)  2

	            dikdortgenler[i][0] = genislik;
	            dikdortgenler[i][1] = yukseklik;
	        }

	        return dikdortgenler;
	    }
	 
	  public static void desenleriYazdir(int desenSayisi, int[][] ikiBoyutluDizi, char[] isaretler , int son ) {
	        // �ki boyutlu dizi ve i�aret dizisinin boyutlar�n� kontrol edelim
	        if (ikiBoyutluDizi.length != desenSayisi || isaretler.length != desenSayisi) {
	        	System.out.println();
	            System.out.println("Hata: �ki boyutlu dizi ve i�aret dizilerinin boyutlar� ge�erli de�il!");
	            return;
	        }

	        for (int i = 0 ; i < desenSayisi; i++) {
	            // �ki boyutlu dizideki say�lar� �arpal�m
	            int sayi1 = ikiBoyutluDizi[i][0];
	            int sayi2 = ikiBoyutluDizi[i][1];
	            int carpim = sayi1 * sayi2;

	            // Deseni olu�turma
	            StringBuilder desen = new StringBuilder();
	            desen.append("******************\n");
	            desen.append("* ").append(carpim).append("      \"").append(isaretler[i]).append("\"  *\n");
	            desen.append("******************");

	            // �lk desenin alt�na "<---------------" ekleyelim
	            if (i == 0+son) {
	                desen.append("        <---------------");
	                System.out.println("son :" + son);
	            }

	            System.out.println(desen);
	        }
	    }
	  
	  public static void ikinciEkran(int[][] ikiBoyutluDizi, char[] karakterler ,int son) {
	        if (ikiBoyutluDizi.length != karakterler.length) {
	            System.out.println("Hata: �ki boyutlu dizi ve karakter dizisi boyutlar� e�it olmal�!");
	            return;
	        }

	        
	            int row = ikiBoyutluDizi[son][0];
	            int col = ikiBoyutluDizi[son][1];
	            char karakter = karakterler[son];

	            // Dikd�rtgen resmini olu�turma
	            StringBuilder resim = new StringBuilder();
	            for (int r = 0; r < row; r++) {
	                for (int c = 0; c < col; c++) {
	                    resim.append(karakter);
	                }
	                resim.append("\n");
	            }

	            System.out.println(resim);
	            System.out.println("Sat�r: " + row + ", S�tun: " + col + ", Karakter: " + karakter);
	        
	    }


	  public static int[][] deleteAndCopy(int[][] array) {
		  int[][] newArray = new int[array.length - 1][array[0].length];
		  for (int i = 1; i < array.length; i++) {
		    for (int j = 0; j < array[0].length; j++) {
		      newArray[i - 1][j] = array[i][j];
		    }
		  }
		  return newArray;
		}
	
public static char[] deleteAndCopyChar(char[] inputArray) {
    // Yeni dizi boyutunu bir azaltarak ba�layal�m
    char[] newArray = new char[inputArray.length - 1];

    // inputArray'in 0. index'ten itibaren yeni diziye kopyalayal�m
    for (int i = 1; i < inputArray.length; i++) {
        newArray[i - 1] = inputArray[i];
    }

    return newArray;
}
public static void printArray(int[][] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            System.out.print(array[i][j] + " ");
        }
        System.out.println(); // Her sat�r sonunda bir alt sat�ra ge�mek i�in bo� bir sat�r yazd�r�yoruz
    }
}
public static void printCharArray(char[] array) {
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
}
}



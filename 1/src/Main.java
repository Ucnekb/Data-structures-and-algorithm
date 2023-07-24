import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Scanner  input=new Scanner(System.in);
   System.out.println(" lütfen sayý giriniz");
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
	   System.out.println("SÝLME ÇALIÞTI ");
	   
	   printArray(dikdortgenler);
	   printCharArray(secilenKarakterler);
	   kare--;
	  
   }
   if(top==kare)
   {
	   System.out.println( "dizi boþ ");
	   break;
   }
   
   
   if (harf == 's' || harf == 'S') {
       son++; // Eðer girilen harf 's' veya 'S' ise "son" deðiþkeni 1 artýrýlýr.
       System.out.println("if deki son 1 artý :" + son);
       
       if (son >= kare) {
           son = 0; // "son" deðeri 3'ten büyükse 0'a döndürülür.
       }

   }
   else  if (harf == 'w' || harf == 'W') {
       son--; // Eðer girilen harf 's' veya 'S' ise "son" deðiþkeni 1 artýrýlýr.
       System.out.println("if bir azaltýldý");
       System.out.println("w de ki son  : " + son);
      
       
       if (son < 0) {
           son = kare-1; // "son" deðeri 3'ten büyükse 0'a döndürülür.
           System.out.println("son==0 oldu :"+ son );
       }
   }
   System.out.println("whildeki son "+ son);
   desenleriYazdir(kare,dikdortgenler,secilenKarakterler,son);
   ikinciEkran(dikdortgenler,secilenKarakterler,son);
   
	}
	}
	
	
	public static char[] karakterSec(int sayý) {
        // Rastgele sayý üretmek için Random sýnýfýný kullanalým
        Random random = new Random();

        char[] secilenKarakterler = new char[sayý];

        for (int i = 0; i < sayý; i++) {
            // 1 ile 4 arasýnda rastgele bir sayý seçelim
            int secilenSayi = random.nextInt(4) + 1;

            // Sayýya göre karakter seçimi yapalým
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
                    secilenKarakter = '$'; // Varsayýlan olarak '$' karakterini döndürelim
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
	            int genislik = random.nextInt(46) + 5; // 5-50 arasýnda rastgele bir sayý (0 ile 45 arasýna 5 ekleyerek) 46
	            int yukseklik = random.nextInt(2) + 3; // 3-10 arasýnda rastgele bir sayý (0 ile 7 arasýna 3 ekleyerek)  2

	            dikdortgenler[i][0] = genislik;
	            dikdortgenler[i][1] = yukseklik;
	        }

	        return dikdortgenler;
	    }
	 
	  public static void desenleriYazdir(int desenSayisi, int[][] ikiBoyutluDizi, char[] isaretler , int son ) {
	        // Ýki boyutlu dizi ve iþaret dizisinin boyutlarýný kontrol edelim
	        if (ikiBoyutluDizi.length != desenSayisi || isaretler.length != desenSayisi) {
	        	System.out.println();
	            System.out.println("Hata: Ýki boyutlu dizi ve iþaret dizilerinin boyutlarý geçerli deðil!");
	            return;
	        }

	        for (int i = 0 ; i < desenSayisi; i++) {
	            // Ýki boyutlu dizideki sayýlarý çarpalým
	            int sayi1 = ikiBoyutluDizi[i][0];
	            int sayi2 = ikiBoyutluDizi[i][1];
	            int carpim = sayi1 * sayi2;

	            // Deseni oluþturma
	            StringBuilder desen = new StringBuilder();
	            desen.append("******************\n");
	            desen.append("* ").append(carpim).append("      \"").append(isaretler[i]).append("\"  *\n");
	            desen.append("******************");

	            // Ýlk desenin altýna "<---------------" ekleyelim
	            if (i == 0+son) {
	                desen.append("        <---------------");
	                System.out.println("son :" + son);
	            }

	            System.out.println(desen);
	        }
	    }
	  
	  public static void ikinciEkran(int[][] ikiBoyutluDizi, char[] karakterler ,int son) {
	        if (ikiBoyutluDizi.length != karakterler.length) {
	            System.out.println("Hata: Ýki boyutlu dizi ve karakter dizisi boyutlarý eþit olmalý!");
	            return;
	        }

	        
	            int row = ikiBoyutluDizi[son][0];
	            int col = ikiBoyutluDizi[son][1];
	            char karakter = karakterler[son];

	            // Dikdörtgen resmini oluþturma
	            StringBuilder resim = new StringBuilder();
	            for (int r = 0; r < row; r++) {
	                for (int c = 0; c < col; c++) {
	                    resim.append(karakter);
	                }
	                resim.append("\n");
	            }

	            System.out.println(resim);
	            System.out.println("Satýr: " + row + ", Sütun: " + col + ", Karakter: " + karakter);
	        
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
    // Yeni dizi boyutunu bir azaltarak baþlayalým
    char[] newArray = new char[inputArray.length - 1];

    // inputArray'in 0. index'ten itibaren yeni diziye kopyalayalým
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
        System.out.println(); // Her satýr sonunda bir alt satýra geçmek için boþ bir satýr yazdýrýyoruz
    }
}
public static void printCharArray(char[] array) {
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
}
}



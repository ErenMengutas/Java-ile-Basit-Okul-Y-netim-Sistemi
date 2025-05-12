package okulProject;

import java.util.Scanner;

public class Depo {

    static Scanner scanner=new Scanner(System.in);
    static String kullaniciningirdigiSayi;

    static void anaMenu() throws InterruptedException {


        do {
            System.out.println("========== JAVA KOLEJİ==========\n"
                    +
                    "============= ANA MENU ==============" +
                    "\n" +
                    "   1-Okul Bilgilerini Görüntüle\n"+
                    "   2-Öğretmen Menü\n"+
                    "   3-Ögrenci Menü\n"+
                    "   Q Çıkış\n"
                    );

            System.out.println("Lütfen Yapmak istetiğiniz işlemi tuşlayınız");
            kullaniciningirdigiSayi=scanner.nextLine();

            switch (kullaniciningirdigiSayi){
                case "1":okulBilgileri();
                    break;
                case "2":Ogretmen.ogretmenMenu();
                    break;
                case "3":
                    Ogreci.ogreciMenu();
                    break;
                case "4":
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("⊘ ⊘ Lütfen geçerli bir tercih giriniz ⊘ ⊘ \n\n");
            }

        }while (!kullaniciningirdigiSayi.equalsIgnoreCase("q"));
        projeyiDurdur();
    }

    public static void projeyiDurdur(){

        System.out.println("Çıkış yapılıyor");
    }

    public static void okulBilgileri() throws InterruptedException {
        System.out.println(
                 "Okul ismi : JAVA KOLEJİ \n"+
                 "Adres :"+Okul.adres+"\n"+
                 "Telefon :"+Okul.telefon+"\n"+"\n"
        );

        Thread.sleep(2000);
    }

 }

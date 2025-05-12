package okulProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogreci {
   static Scanner scanner=new Scanner(System.in);

    static Map<String,String> ogrenciMap=new HashMap<>();
    public static void ogreciler() {
        ogrenciMap.put("12345678901","Ali Can,4441,12,A");
        ogrenciMap.put("12345678902","Veli Yan,4442,12,A");
        ogrenciMap.put("12345678903","Ayşe Can,4443,11,B");
        ogrenciMap.put("12345678904","Alp Şen,4444,11,B");
        ogrenciMap.put("12345678905","Elif San,4445,11,A");

    }

    public static void ogreciMenu() throws InterruptedException {

        do {
            System.out.println("\n\n========= Öğreci Menü =========\n" +
                    "1- Öğrenciler Listesini yazdir\n"+
                    "2- Sınıfa göre Öğrenci Seç\n"+
                    "3- Öğrenci Ekle\n"+
                    "4- Öğrenci Silme\n"+
                    "A- Ana Menüye geri dön\n"+
                    "Q Çıkış\n"
            );
            Depo.kullaniciningirdigiSayi=scanner.nextLine();

            switch (Depo.kullaniciningirdigiSayi){
                case "1":
                    ogreciListesiYazdir();
                    break;
                case "2":
                    sinifaGoreOgrSec();
                    break;
                case "3":
                    ogreciEkle();
                    break;
                case "4":
                    ogrenciSil();
                    break;
                case "a":
                case "A":
                    Depo.anaMenu();
                    break;
                 case "q":
                 case "Q":
                    break;

                 default:
                     System.out.println("Lütfen geçerli bir tercih yapınız");

            }
        } while (!Depo.kullaniciningirdigiSayi.equalsIgnoreCase("q"));

    }

    private static void ogrenciSil() {

            System.out.println("Lütfen silmek istediğiniz öğrencinin Tc Kimlik numarasını yazınız");
            String silinicekOgrNo=scanner.nextLine();

            String silinicekOgrctValue=ogrenciMap.get(silinicekOgrNo);

            String sonucValue=ogrenciMap.remove(silinicekOgrNo);

            try {
                boolean bl=sonucValue.equalsIgnoreCase(silinicekOgrctValue);
                System.out.println("Öğrenci başarı ile silindi");
            } catch (Exception e) {
                System.out.println("Girilen numara ile eşleşen bir öğretmen bulunamadı");
            }

    }


    public static void ogreciListesiYazdir() throws InterruptedException {
        Set<Map.Entry<String,String>> ogretmenlerSet=ogrenciMap.entrySet();
        System.out.println("Tc Kimlik No Öğrenci No Öğrenci No Şube");
        //    ogrenciMap.put("12345678905","Elif San,4445,11,A");
        for (Map.Entry<String,String> each:ogretmenlerSet)
        {
            System.out.println(each.getKey()+"  "+each.getValue());
        }
        Thread. sleep(2000);
    }

    public static void sinifaGoreOgrSec() throws InterruptedException {
        Set<Map.Entry<String,String>>ogretmenlerSet=ogrenciMap.entrySet();
        System.out.println("Lütfen öğrencinin sınıfını giriniz ");
        String sınıfSec=scanner.nextLine();


        for (Map.Entry<String,String> each:ogretmenlerSet)
        {

            String eachValue=each.getValue();
            String[] eachValuearr =eachValue.split(",");

            if (sınıfSec.equalsIgnoreCase(eachValuearr[2]))
            {
                System.out.println(eachValuearr[0]);
            }

        }

        Thread. sleep(2000);

    }
    public static void ogreciEkle() {
        System.out.println("Lütfen ekleyeceğiniz öğrencinin Tc Kimlik numarasını giriniz");
        String ogrenciTc= scanner.nextLine();
        System.out.println("Lütfen ekleyeceğiniz öğrencinin ismini ve Soyismini giriniz giriniz");
        String ogrenciİsimSoyisim= scanner.nextLine();
        System.out.println("Lütfen ekleyeceğiniz öğrencinin numarasını giriniz");
        String ogrenciNo= scanner.nextLine();
        System.out.println("Lütfen ekleyeceğiniz öğrencinin kaçıncı sınıf olduğunu giriniz");
        String ogrenciSinif= scanner.nextLine();
        System.out.println("Lütfen ekleyeceğiniz öğrencinin şubesini giriniz");
        String ogrenciSube= scanner.nextLine();

        String ogretmenBilgileri=ogrenciİsimSoyisim+","+ogrenciNo+","+ogrenciSinif+","+ogrenciSube;
        ogrenciMap.put(ogrenciTc,ogretmenBilgileri);

    }



}

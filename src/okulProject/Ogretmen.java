package okulProject;

import java.util.*;

public class Ogretmen {
     static Map<String,String> ogretmenlerListesiMap =new HashMap<>();
     static Scanner scanner=new Scanner(System.in);



    public static void ogretmenlerMapEkle(){
        ogretmenlerListesiMap.put("00000000001","Albert Ainstein,Fizik");
        ogretmenlerListesiMap.put("00000000002","Carl F.Gauss,Matematik");
        ogretmenlerListesiMap.put("00000000003","Aziz Sancar,Kimya");
        ogretmenlerListesiMap.put("00000000004","Gregor Mendel,Biyoloji");
        ogretmenlerListesiMap.put("00000000005","İlber Ortaylı,Tarih");
        ogretmenlerListesiMap.put("00000000006","William Shakespeare,Edebiyat");
        ogretmenlerListesiMap.put("00000000007","Vincent van Gogh,Resim");
        ogretmenlerListesiMap.put("00000000008","Amadeus Mozart,Müzik");


    }





    public static void ogretmenMenu() throws InterruptedException {
            do {
                System.out.println("\n\n========= Öğretmen Menü =========\n" +
                        "1- Öğretmen Listesini yazdir\n"+
                        "2- Branşa göre öğretmen Seç\n"+
                        "3- Öğretmen Ekle\n"+
                        "4- Öğretmen Silme\n"+
                        "A- Ana Menüye geri dön\n"+
                        "Q Çıkış\n"
                );

                Depo.kullaniciningirdigiSayi=scanner.nextLine();

                switch (Depo.kullaniciningirdigiSayi){
                    case "1":
                        ogretmenlarMapYazdir();
                        break;
                    case "2":
                        bransaGoreOgrsec();
                        break;
                    case "3":
                        ogretmenEkleme();
                        break;
                    case "4":
                        ogretmenSilme();
                        break;
                    case "A":
                    case "a":
                        Depo.anaMenu();
                        break;
                    case "q":
                    case "Q":
                        break;
                    default:
                        System.out.println("Lütfen geçerli bir tercih yapınız");

                }


            }while (!Depo.kullaniciningirdigiSayi.equalsIgnoreCase("q"));


    }

    public static void ogretmenSilme() {
        System.out.println("Lütfen silmek istediğiniz öğretmenin numarasını yazınız");
        String silinicekOgrNo=scanner.nextLine();

        String silinicekOgrtValue=ogretmenlerListesiMap.get(silinicekOgrNo);

        String sonucValue=ogretmenlerListesiMap.remove(silinicekOgrNo);

        try {
            boolean bl=sonucValue.equalsIgnoreCase(silinicekOgrtValue);
            System.out.println("Öğretmen başarı ile silindi");
        } catch (Exception e) {
            System.out.println("Girilen numara ile eşleşen bir öğretmen bulunamadı");
        }
    }

    public static void ogretmenEkleme() {
        System.out.println("Lütfen ekleyeceğiniz öğretmenin numarasını giriniz");
        String ogretmenNo= scanner.nextLine();
        System.out.println("Lütfen ekleyeceğiniz öğretmenin ismini ve Soyismini giriniz giriniz");
        String ogretmenIsim= scanner.nextLine();
        System.out.println("Lütfen ekleyeceğiniz öğretmenin branşını giriniz");
        String ogretmenBrans= scanner.nextLine();

        String ogretmenBilgileri=ogretmenIsim+","+ogretmenBrans;
        ogretmenlerListesiMap.put(ogretmenNo,ogretmenBilgileri);

    }

    public static void ogretmenlarMapYazdir() throws InterruptedException {
       Set<Map.Entry<String,String>>ogretmenlerSet=ogretmenlerListesiMap.entrySet();
        System.out.println("Öğretmen No  Öğretmen Adı   Öğretmenin Branşı");
       for (Map.Entry<String,String> each:ogretmenlerSet)
       {

           System.out.println(each.getKey()+"  "+each.getValue());
       }
        Thread. sleep(2000);
    }


    public static void bransaGoreOgrsec() throws InterruptedException {
        Set<Map.Entry<String,String>>ogretmenlerSet=ogretmenlerListesiMap.entrySet();
        System.out.println("Lütfen öğretmenini öğrenmek istediğiniz branşı yazınız");
        String bransSec=scanner.nextLine();


        for (Map.Entry<String,String> each:ogretmenlerSet)
        {

            String eachValue=each.getValue();
            String[] eachValuearr =eachValue.split(",");

            if (bransSec.equalsIgnoreCase(eachValuearr[1]))
            {
                System.out.println(eachValuearr[0]);
            }

        }

        Thread. sleep(2000);

    }




}

import java.util.Scanner;

public class UcakBiletiHesaplama {
    public static void main(String[] args) {
        /*
        Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın.
        Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın.
        Mesafe başına ücret 0,10 TL / km olarak alın.
        İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye
        aşağıdaki indirimleri uygulayın ;

        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı,
        yolculuk tipi ise 1 veya 2) olmalıdır. Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !"
        şeklinde bir uyarı verilmelidir.
        * Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
        *Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
        *Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
        *Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
         */

        Scanner input = new Scanner(System.in);

        int km, yas, yolculukTipi;

        System.out.print("Mesafeyi Giriniz :");
        km = input.nextInt();
        System.out.print("Yaşınızı Giriniz :");
        yas = input.nextInt();
        System.out.print("Yolculuk Tipini Giriniz (1=Tek Yön, 2=Gidiş-Dönüş) :");
        yolculukTipi = input.nextInt();


        double normalFiyat, yasIndirimi, tipIndirimi;

        if(km > 0 && yas > 0 && (yolculukTipi ==1 || yolculukTipi==2)){
            normalFiyat = km * 0.10;
            if(yas < 12){
                yasIndirimi = normalFiyat * 0.5;
            }
            else if(yas >= 12 && yas <= 24) {
                yasIndirimi = normalFiyat * 0.10;
            }
            else if(yas >= 65) {
                yasIndirimi = normalFiyat * 0.30;
            }
           else {
               yasIndirimi = 0;
            }
           normalFiyat -= yasIndirimi;

           if(yolculukTipi==2){
               tipIndirimi = normalFiyat * 0.20;
               normalFiyat = (normalFiyat - tipIndirimi) * 2;
           }
           System.out.print("Bilet Fiyatı : " + normalFiyat);
        }
        else {
            System.out.println("Hatalı veri girdiniz");
        }

    }
}

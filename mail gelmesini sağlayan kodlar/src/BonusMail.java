import java.io.File;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class BonusMail {

	private static final String HEDEF_DOSYA = "C:\\Users\\kullanici\\xyz\\Local\\VMlocation\\BANKA.TXT";
    private static final String GONDEREN_MAIL = "kendimailin@gmail.com";
    private static final String UYGULAMA_SIFRESI = "ztfjahvpacdbxrze"; // Gmail 16 haneli kod
    private static final String ALICI_MAIL = "kendimailin@gmail.com";

    public static void main(String[] args) {
        File dosya = new File(HEDEF_DOSYA);
        System.out.println("--- GOZCU AKTIF: " + HEDEF_DOSYA + " IZLENIYOR ---");
        
        long sonBoyut = dosya.exists() ? dosya.length() : 0;

        while (true) {
            if (dosya.exists() && dosya.length() > sonBoyut) {
                System.out.println("Yeni kayit bulundu! Mail gonderiliyor...");
                sendEmail("DIGIBANK BILDIRIMI", "Banka veritabanina yeni giris yapildi.");
                sonBoyut = dosya.length();
            }
            try { Thread.sleep(2000); } catch (Exception e) {}
        }
    }

    public static void sendEmail(String subject, String text) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(GONDEREN_MAIL, UYGULAMA_SIFRESI);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(GONDEREN_MAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ALICI_MAIL));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            System.out.println("BAŞARILI: GERÇEK MAİL GÖNDERİLDİ!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

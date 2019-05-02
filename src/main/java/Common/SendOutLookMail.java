package Common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendOutLookMail {
	
	 public static String timestamp() {
	        return new SimpleDateFormat("dd MMMM yyyy HH-mm-ss").format(new Date());
	    }
	
	public static void sendOutLookMail() {
	final String username = "stiyyagura@enhops.com";  // like yourname@outlook.com
    final String password = "Enhops@2312";   // password here

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp-mail.outlook.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
      });
    session.setDebug(true);

    try {

        Message message = new MimeMessage(session);
        Multipart multipart = new MimeMultipart();
        message.setFrom(new InternetAddress(username));
       // message.setRecipients(Message.RecipientType.CC, "abc@abc.com,abc@def.com,ghi@abc.com");
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("stiyyagura@enhops.com")); 
        message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("stiyyagura@enhops.com"));
        message.setSubject("Android Test report" + timestamp());
        message.setText(" Hi xxxx,please find an attached document");
       
      //  message.setText("HI you have done sending mail with outlook");

        MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.setContent(message, "text/html");
        
        String attachFile = "E:\\surya automation\\TestProject\\Reports\\HtmlReports\\Android Automaton Report.html";
        try {
			attachPart.attachFile(attachFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        multipart.addBodyPart(attachPart);
        message.setContent(multipart);
        Transport.send(message);

        System.out.println("Done");
    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
    
	}
    public static void main(String args[]){
    	sendOutLookMail();
    }

}

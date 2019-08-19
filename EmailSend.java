/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * https://www.google.com/settings/security/lesssecureapps
 */



/**
 *
 * @author Naveen
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class EmailSend {

   public boolean Mail(String mail){
	   boolean x=false;
	   try{
           String host ="smtp.gmail.com" ;
           String user = "your MailID";
           String pass = "your MailID password";
          
           String from = "from Mail ID";
           String subject = "This is confirmation number for your expertprogramming account. Please insert this number to activate your account.";
           String messageText = "Your Is Test Email :";
           boolean sessionDebug = true;

           Properties props = System.getProperties();

         //  props.put("mail.smtp.starttls.enable", "true");
           props.put("mail.smtp.host", host);
           props.put("mail.smtp.port", "465");
           props.put("mail.smtp.auth", "true");
           props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
           props.put("mail.smtp.socketFactory.port", "465");
           props.put("mail.smtp.socketFactory.fallback", "false");
         //  props.put("mail.smtp.starttls.required", "true");

        //   java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
           
           
           
           Session mailSession = Session.getDefaultInstance(props, null);
           mailSession.setDebug(sessionDebug);
           Message msg = new MimeMessage(mailSession);
           msg.setFrom(new InternetAddress(from));
           InternetAddress[] address = {new InternetAddress(mail)};
           msg.setRecipients(Message.RecipientType.TO, address);
           msg.setSubject(subject); msg.setSentDate(new Date());
           msg.setText(messageText);

          Transport transport=mailSession.getTransport("smtp");
          transport.connect(host, user, pass);
          transport.sendMessage(msg, msg.getAllRecipients());
          transport.close();
          System.out.println("message send successfully");
          x=true;
       }catch(Exception ex)
       {
    	   
           System.out.println(ex);
           return x;
       }
	   
return x;

    }
}

import java.util.Properties;  
  
import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  


class Mailer {  
public static void send(String to,String subject,String msg){  
  
final String user="530akash@gmail.com";//change accordingly  
final String pass="akashbadave26";  
  
//1st step) Get the session object    
Properties properties = new Properties();  
properties.put("mail.smtp.host","smtp.gmail.com");//change accordingly
properties.put("mail.smtp.SocketFactory.port","465");
properties.put("mail.smtp.starttls.enable", true); 
properties.put("mail.smtp.auth", "true");  
  
Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() 
{  
  protected PasswordAuthentication getPasswordAuthentication() 
  {  
   return new PasswordAuthentication(user,pass);  
   }  
});  
//2nd step)compose message  
try 
{  
 MimeMessage message = new MimeMessage(session);  
 message.setFrom(new InternetAddress(user));  
 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
 message.setSubject(subject);  
 message.setText(msg);  
   
 //3rd step)send message  
 Transport.send(message);  
  
 System.out.println("Done");  
  
 } catch (MessagingException e) {  
   e.printStackTrace();
 }  
      
}  
}
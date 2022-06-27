package Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mail {
 public static void send(String email,String fname,String uname) throws IOException {
     
     String to = email;
     String text="Hello, "+ fname +"\n\n"+
                 "You have successflly registred to the assignment web application of Atharv Parmar.\n"+
                 "Your UserName is "+uname+".\n\n"+
                 "Thankyou\n";
     
     try {    
         Properties properties = new Properties();    
         properties.put("mail.smtp.host", "smtp.gmail.com");    
         properties.put("mail.smtp.socketFactory.port", "465");    
         properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
         properties.put("mail.smtp.auth", "true");    
         properties.put("mail.smtp.port", "465");
                 
         FileInputStream fStream = new FileInputStream("E:\\Programming\\java\\DemoApp\\src\\main\\java\\com\\t\\config.properties");
         properties.load(fStream);
         final String fromMail = (String) properties.getProperty("email");
         final String password = (String) properties.getProperty("password");
         
         Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromMail, password);
                }
            });         session.getDebug();
      MimeMessage message = new MimeMessage(session);
      message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
      message.setSubject("Registration Successful !!");    
      message.setText(text);    
      Transport.send(message);      
      
     } catch (MessagingException e) {
         e.printStackTrace();     
     }    

 }
}
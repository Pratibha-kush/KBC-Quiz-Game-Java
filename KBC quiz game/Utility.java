import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;



public class Utility{

//save User details to file

public static void saveUserToFile(String name,String email,int age){
try{
FileWriter fw=new FileWriter("userDetails.txt",true);

fw.write("Name: "+name+"\n");
fw.write("Email: "+email+"\n");
fw.write("Age: "+age+"\n");
fw.write("---------------------------------------\n");

fw.close();
System.out.println("User data saved successfully!");
}
catch(IOException e){
System.out.println("Error saving data");
}

}

//send mail



public static void sendMail(String name, String toEmail) {

final String fromEmail = "pratibhakushwah05@gmail.com";
final String password = "xycg tvuj fjpy pssi";

Properties props = new Properties();
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", "587");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");

Session session = Session.getInstance(props, new Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(fromEmail, password);
}});

try {
Message msg = new MimeMessage(session);

msg.setFrom(new InternetAddress(fromEmail));
msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail));

msg.setSubject("Welcome to KBC Quiz Game 🎉");

msg.setText(
                "Hello " + name + ",\n\n" +
                "Congratulations! You have successfully registered for the KBC Quiz Game.\n\n" +
                "Get ready to test your knowledge!\n\n" +
                "Best of luck 👍\n\n" +
                "Regards,\nKBC Quiz Team"
);
Transport.send(msg);
System.out.println("Mail sent successfully!");
} 
catch (MessagingException e) {
System.out.println("Error sending mail!");
}


}


public static void sendResultMail(String name, String toEmail, int priceMoney){
final String fromEmail = "pratibhakushwah05@gmail.com";
final String password = "xycg tvuj fjpy pssi";

Properties props = new Properties();
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", "587");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");

Session session = Session.getInstance(props, new Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(fromEmail, password);
}});

try {
Message msg = new MimeMessage(session);

msg.setFrom(new InternetAddress(fromEmail));
msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail));

msg.setSubject("KBC Result 🎯");

msg.setText(
                "Hello " + name + ",\n\n" +
                "Congratulations! You completed the KBC Quiz." +
                
                "\n\nPrize Money: " +"₹"+priceMoney +
                "\n\nKeep Playing,\nKBC Quiz Team"
);
Transport.send(msg);
System.out.println("Mail sent successfully!");
} 
catch (MessagingException e) {
System.out.println("Error sending mail!");
}


}




}
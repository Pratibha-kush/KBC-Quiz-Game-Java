import java.util.*;

public class User{
public static String name;
public static String email;
public static int age;

static Scanner sc=new Scanner(System.in);

public static void registerUser(){


while(true){
try{

System.out.println("Please Enter your Details:");

System.out.print("Name:");
name=sc.nextLine();

System.out.print("Email id:");
email=sc.nextLine();

if(!validateEmail(email)){
System.out.println("Invalid Email Format! Try again.");
continue;
}

System.out.print("Age:");
age=sc.nextInt();
sc.nextLine();
if(age < 18){
System.out.println("Invalid Age! Must be 18+");
continue;
}

break;


}
catch(InputMismatchException e){

System.out.println("Invalid Input, Please fill valid details!");
//registerUser();
sc.nextLine();
}
}

System.out.println("\nRegistered Successfully!");
try {
Thread.sleep(2000);
} 
catch (InterruptedException e) {
e.printStackTrace();
}

Utility.saveUserToFile(name,email,age);

try {
Utility.sendMail(name, email);
System.out.println("Welcome email sent successfully!");
} 
catch(Exception e){
System.out.println("Mail failed, but registration continues.");
}

}


public static boolean validateEmail(String email){
if(email==null || email.isEmpty()){
return false;
}

int atIndex = email.indexOf('@');
int dotIndex = email.lastIndexOf('.');

if(atIndex<=0){
return false;
}
if(dotIndex<=atIndex+1){
return false;
}
if(dotIndex==email.length()-1){
return false;
}
return true;

}

}
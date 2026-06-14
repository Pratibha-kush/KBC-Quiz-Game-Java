import java.util.*;


public class KBC{


public static void main(String[] args){

Scanner sc=new Scanner(System.in);

String[] ques={"1.What is the capital of India?",
		"2.Which company developed the Java programming language?",
		"3.Which protocol is used to send emails?",
		"4.Which of the following is an open-source operating system?",
		"5.Which is the largest ocean in the world?"};

String[][] options={ {"A.Delhi","B.Mumbai","C.Indore","D.Chennai"},	{"A.MicroSoft","B.SunMicrosystems","C.Oracle","D.IBM"},
	{"A.FTP","B.SMTP","C.HTTP","D.POP3"},
	{"A.Windows","B.macOS","C.Linux","D.Solaris"},
	{"A.Atlantic Ocean","B.Indian Ocean","C.Arctic Ocean","D.Pacific Ocean"} 
	};

char[] answer={'A','B','B','C','D'};

while(true){
User.registerUser();

int priceMoney=Quiz.startQuiz(ques,options,answer);

//Utility.saveUserToFile(User.name, User.email, User.age);

//Utility.sendMail(User.name, User.email);

Utility.sendResultMail(User.name, User.email,Quiz.priceMoney);

System.out.println("Do you want to play again? (Y/N)");
char ch=sc.next().charAt(0);

if(ch=='N' || ch=='n'){
System.out.println("Game Ends!");
break;
}

}
}
}
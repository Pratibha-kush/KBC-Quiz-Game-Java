import java.util.*;

public class Quiz{

static int score=0;
static int priceMoney=0;

public static int startQuiz(String[] ques,String[][] options,char[] answer){

System.out.println("Lets Start the Game!");
LoggerUtil.logger.info("Quiz started");
try {
Thread.sleep(2000);
} 
catch (InterruptedException e) {
e.printStackTrace();
}
Scanner sc=new Scanner(System.in);


for(int i=0;i<ques.length;i++){


//timer after 10 questions
/*try{
if((i+1) % 10 == 0){
System.out.println("Next round starting...");
Thread.sleep(3000);
}
}
catch (InterruptedException e) {
e.printStackTrace();
}*/


System.out.println("\n---------------------------------------------------------------------");

System.out.println(ques[i]);


for(int j=0;j<options[i].length;j++){



try {
Thread.sleep(1000);
} 
catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println(options[i][j]);
}

System.out.print("Enter your option: ");


final int questionIndex = i;
final boolean[] answered = {false};

Thread timer=new Thread(()->{
try{
if(questionIndex >= 10){
for(int t=10;t>=1;t--){

if(answered[0]){
return;
}
System.out.println("\nTime left: "+t+"sec");
Thread.sleep(1000);
}

if(!answered[0]){
System.out.println("Times's up! Game Over.");
System.exit(0);
}
}
}
catch(InterruptedException e) {
e.printStackTrace();
}
});

timer.start();




char op = Character.toUpperCase(sc.next().charAt(0));

answered[0]=true;

switch(op){
case 'A':
case 'B':
case 'C':
case 'D':
if(op==answer[i]){
System.out.println("Correct answer");
LoggerUtil.logger.info("Question:"+(i+1)+" Correct answer");

score++;
priceMoney=score*2000;
//System.out.println(priceMoney);
}
else{
System.out.println("wrong answer");
LoggerUtil.logger.error("Question:"+(i+1)+" Wrong answer");
System.out.println("Game end, Better luck next Time!");
return score;
}
break;

default:
System.out.println("Invalid Choice");
i--;

}
}
System.out.println("Congratulations! You completed the quiz.");
return priceMoney;


}

}
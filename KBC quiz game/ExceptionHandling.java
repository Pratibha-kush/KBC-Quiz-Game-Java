//try catch finally throw throws

public class ExceptionHandling{

public static void main(String[] args){

int age=18;
try{
if(age<0){
//throw invalid output
throw new Exception("Invalid age");

}//else if(age<18){
// not legal age
//throws
//}
else{
System.out.println("Legal age");
}
} 
catch(Exception e){
System.out.println(e);
}
//finally{}

}

}
public class StringCalculator{
    public static void main(String args[]) {
      System.out.println(add("1,2"));
    }
   
static int add(String numbers){
       if(numbers.trim() != ""){
           String[] num = numbers.split(",");
           if(num.length == 1){
               return Integer.parseInt(num[0]);
           }else{
               return Integer.parseInt(num[0])+Integer.parseInt(num[1]);
           }
       }
       return 0;
   }
}
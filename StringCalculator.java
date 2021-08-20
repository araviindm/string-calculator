public class StringCalculator{

    public static void main(String args[]) {
        System.out.println(add("5\n3,2"));
    }
    static int add(String numbers){

        int total=0;
        if(numbers.trim() != ""){
            String[] num = numbers.split("[,\n]");
            for(String str: num){
                total+= Integer.parseInt(str);
            }
            return total;      
         }
        return 0;
    }
  }
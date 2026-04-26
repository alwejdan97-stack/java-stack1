import java.util.Stack;

public class DecimalToBinaryConverter {
    public static void main(String[] args){
        int[] number={9,8,1,4,10,0,7};
        for(int num:number){
            System.out.println("decimal is: "+num);
            //System.out.println(decimalToBinary(num));
            System.out.println("binary is: "+decimalToBinary(num));
        }
    }
    public static String decimalToBinary(int decimal){
        if(decimal==0){
            return "0";
        }else if(decimal<0){
            return "not supported";
        }
        Stack<Integer> decim=new Stack<>();

        while(decimal>0){
            int remainder= decimal % 2;
            int quotient=decimal/2;
            decim.push(remainder);
            decimal=quotient;
        }
        String str="";
        if(!(decim.isEmpty())){
            str=str+decim.pop();
        }
        return str;
    }
    public static void displayConversionProcess(int decimal){
        if(decimal==0){
            System.out.println("0");
        }
        Stack<Integer> decim=new Stack<>();

        while(decimal>0){
            int remainder= decimal % 2;
            int quotient = decimal/2;
            System.out.println(decimal+"  / 2= "+quotient+" | remainde= "+remainder);
            decim.push(remainder);
            decimal=quotient;
        }
        System.out.println("stack is: "+decim);
    }
}

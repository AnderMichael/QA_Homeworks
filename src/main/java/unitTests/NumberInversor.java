package unitTests;

public class NumberInversor {

    public String reverseNumber(int n) {
        // Number to String
        if(n >= 0){
            String number = String.valueOf(n), reversed = "";
            for (int i = number.length() - 1; i >= 0; i--) {
                reversed += number.charAt(i);
            }
            return reversed;
        }else{
            return "Valor Incorrecto";
        }

    }

}

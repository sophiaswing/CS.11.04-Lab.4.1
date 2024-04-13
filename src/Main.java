public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str){
       if (str.charAt(0)=='(' && str.charAt(str.length()-1)==')'){
           return true;

        }
       return false;
    }

    // 2. reverseInteger
    public static String reverseInteger(int check){
        String ans = "";
        while(check>0){
            ans+=check%10;
            check/=10;
        }
        return ans;
    }

    // 3. encryptThis

    public static String encryptThis(String str){
        str += " "; //use a space to make sure the last word is processed correct
        String ans = ""; //stores result
        String word = ""; //stores each word from input string
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){ //if character is a space
                ans += (int)word.charAt(0); //put first letter's ascii into result
                ans += word.charAt(word.length()-1); //put last character of word into result
                if(word.length()>2){
                    ans+=word.substring(2,word.length()-1); //put substring of the word without first & last characters
                    ans+=word.charAt(1); //put second character of the word
                }

                if(i!=str.length()-1) ans+=" "; //if it isn't the last word put a space
                word=""; //reset word string
            }else{
                word+=str.charAt(i);
            }
        }
        return ans;
    }





    // 4. decipherThis
    public static String decipherThis (String str){
        str += " ";
        String ans = "";
        String word = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){ //indicates end of word
                int num=0;
                int pos=0;
                for(int j=0;j<word.length();j++){ //find ascii digits
                    if(word.charAt(j)>='0'&&word.charAt(j)<='9'){ //if current character is digit
                        num*=10;
                        num += Integer.parseInt(word.substring(j,j+1)); //add current digit to num & convert from string to integer
                        pos=j; //store position of last encountered ascii
                    }else{
                        break;
                    }
                }
                ans += (char)num;
                ans += word.charAt(word.length()-1); //put last character of word onto result string
                if(word.length()-1>1+pos){ //if there are additional characters after ascii
                    ans += word.substring(pos+2,word.length()-1); //append substring excluding ascii and last character
                    ans += word.charAt(pos+1);
                }
                if(i!=str.length()-1){
                    ans += " ";
                }
                word = "";
            }else{
                word+=str.charAt(i);
            }
        }
        return ans;
    }

}




package algorithm;

import java.util.HashMap;
import java.util.Map;

public class ReadNumber {
    public static String readNumber(String a) {
        switch (a){
            case "1": return "Muoi";
            case "2": return "Tram";
            case "3" : return "Nghan";
            case "6" : return "Trieu";
            case "9": return "Ty";
            default: return null;
        }
    }
    public static String readNumberUnit(char a) {
        switch (a){
            case '1': return  "Mot";
            case '2': return "Hai";
            case '3': return  "Ba";
            case '4': return  "Bon";
            case '5': return  "Nam";
            case '6': return "Sau";
            case '7': return "Bay";
            case '8': return "Tam";
            case '9': return "Chin";
            default: return null;
        }
    }
    public static Integer log10(Integer number) {
        return (int)Math.log10(number);
    }

    public static String handleString(String input) {
        Map<String,String> handleStringMap = new HashMap();
        int i = 0;
        int n = input.length();
        while (i < n) {
            int a = n / 3;
            int b = n % 3;
            String key = null;
            String val = null;
            if (b == 0){
                key = readNumberUnit(input.charAt(i));
                val = readNumber(String.valueOf(a));
                i++;
            } else {
                for (int k = 0 ; k < b ; k ++){
                    String c = readNumberUnit(input.charAt(i));
                    int log10 = log10(Integer.parseInt(c));
                    String d = readNumber(String.valueOf(log10));
                    String e = null;
                    if (log10 == -1) {
                        e = readNumberUnit(input.charAt(i));
                    }
                    if (e != null) {
                        key = c + d + e;
                    }
                }
                i+=b;
            }
            handleStringMap.put(key, val);
        }
        return handleStringMap.toString();
    }
    public static void main(String[] args) {
        String result =  handleString("2345234");
        System.out.println(result);
    }

}

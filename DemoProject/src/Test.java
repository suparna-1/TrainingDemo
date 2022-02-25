import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args)
    {
           String[] arrPattern={"abc","abb","bac","abbc"};
           String input="xyz";
            getPattern(arrPattern,input);

    }

    public static void getPattern(String[] arrPattern,String input) {
        List<String> list=new ArrayList<String>();

        Pattern pattern=Pattern.compile("()");
        for(String str:arrPattern){
            Matcher matcher=pattern.matcher(str);
            while(matcher.find()){
                String s=matcher.group();
                str=str.substring(1);
                list.add(str);
            }
        }
        System.out.println(list);






    }
}

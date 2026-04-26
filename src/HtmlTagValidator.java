import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagValidator {
    public static void main(String[] args){
        System.out.println(validateHtmlTags("<input value = '>'>"));
        System.out.println(validateHtmlTags("<br/>"));
        System.out.println(validateHtmlTags("br/>"));
        System.out.println(validateHtmlTags("<'br/>"));
        System.out.println(validateHtmlTags("<b>Hello</i>"));
        System.out.println(validateHtmlTags("<b>Hello</b>"));
        System.out.println(validateHtmlTags("<input value = '>'>"));
        System.out.println(validateHtmlTags("<input value = '>'>"));
    }
    public static boolean validateHtmlTags(String html){
        String regex="<(\"[^\"]*\"|'[^']*'|[^'\">])*>"; //regex for checking url
        Pattern pt=Pattern.compile(regex); //compile regex
        if(html==null){ //check if the url empty or not
            return false;
        }
        Matcher mat=pt.matcher(html); //using matcher to check the url
        if(mat.matches()){
            return true;
        }
        return false;
    }
}

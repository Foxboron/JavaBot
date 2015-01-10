package Bot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fox on 1/10/15.
 */
public class Parser {


    public String IrcParse(String msg){
        String pattern;
        pattern = "^(?:[:](\\S+) )?(\\S+)(?: (?!:)(.+?))?(?: [:](.+))?$";

        Pattern reg = Pattern.compile(pattern);
        Matcher matcher = reg.matcher(msg);

        return matcher.group();

    }
}

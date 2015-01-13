package Bot;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fox on 1/10/15.
 */
public class Parser {


    public List Parse(String msg){
        String pattern;
        pattern = "^(?:[:](\\S+) )?(\\S+)(?: (?!:)(.+?))?(?: [:](.+))?$";

        Pattern reg = Pattern.compile(pattern);
        Matcher matcher = reg.matcher(msg);


        List<String> allMatches = new ArrayList<String>();
        matcher.find();
        for(int c = 0; c != matcher.groupCount()+1; c++){
            if(matcher.group(c) == null){
                allMatches.add("");
            } else {
                allMatches.add(matcher.group(c));
            }
        }

        return allMatches;

    }
}

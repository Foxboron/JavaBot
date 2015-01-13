package Bot;

import Bot.Network;
import Bot.Parser;
import Bot.Commands;

import java.io.IOException;
import java.util.List;

/**
 * Created by fox on 1/10/15.
 */
public class IrcBot {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world!");
        Network Conn = new Network();
        Parser ircParser = new Parser();

        Conn.connect("irc.velox.pw", 6666);

        String prefix = ".";

        String serverInput;
        List parsedMsg;
        String s;
        while ((serverInput = Conn.readLine()) != null) {
            parsedMsg = ircParser.Parse(serverInput);
            System.out.println(parsedMsg);
            s = (String)(parsedMsg.get(4));
            System.out.println(s);
            if (s.contains("Found your hostname") && parsedMsg.contains("Auth")) {
                Conn.writer("NICK JavBot2");
                Conn.writer("USER JavaBot 0 * :TheRealOJ");
            }else if(parsedMsg.contains("PING")){
                Conn.writer("PONG :" + parsedMsg.get(4));
            }else if(parsedMsg.contains("266")){
                Conn.writer("JOIN :#lobby");
            }else if(parsedMsg.contains("PRIVMSG")){
                String cmd = (String)(parsedMsg.get(4));
                if(cmd.substring(0,1).equals(prefix)){
                    String[] cmdArgs = cmd.split(" ");
                    String finalCmd = cmdArgs[0].substring(1);
                    Commands CC = new Commands();
                    Conn.writer("PRIVMSG #lobby :"+CC.getCmd(finalCmd, cmd));
                }
            }

        }
    }
}

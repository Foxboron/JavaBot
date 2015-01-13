package Bot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fox on 1/10/15.
 */
public class Commands {

    public String getCmd(String cmd, String args){
        Class[] parameterTypes = new Class[1];
        parameterTypes[0] = String.class;
        Method method1 = null;
        try {
            method1 = Commands.class.getMethod(cmd, parameterTypes);
        } catch (NoSuchMethodException e) {
            System.out.println("No such command");;
        }
        Commands cmds = new Commands();

        Object[] parameters = new Object[1];
        parameters[0] = args;
        if (method1 != null) {
            try {
                return (String)(method1.invoke(cmds, parameters));
            } catch (Exception e) {
                e.printStackTrace();
        }
        return "";
    }


    public String tell(String args){
        return args;
    }

}

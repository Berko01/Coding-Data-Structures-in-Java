import java.io.PushbackReader;
import java.util.IntSummaryStatistics;
import java.util.Stack;

public class Palindrom {

    public boolean IsPalindrom(String phrase) {

        Stack stack = new Stack<Character>();

        int i=0;
        for (;i < phrase.length()/2; i++) {
            char c = phrase.charAt(i);
            stack.push(c);
        }
        if(phrase.length()%2==1) i++;

        for(;i<phrase.length();i++)
        {
            if((char)stack.pop()!=phrase.charAt(i))
            {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        Palindrom palindrom=new Palindrom();

        String phrase="attah";

        System.out.println(palindrom.IsPalindrom(phrase));
        
    }
}
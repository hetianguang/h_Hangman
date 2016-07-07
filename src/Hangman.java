import java.util.Scanner;

/**
 * Created by Tiger on 2016/7/6.
 */
public class Hangman {

    private final String words;
    private String guess_word;
    private int times;

    public Hangman(String str) {
        this.words = str;
        this.times = str.length()+1;
        this.guess_word = "aeiou";
    }

    public  int count() {
        return words.length();
    }

    public  String showword() {

        return words;
    }

    public  String incompleter_word() {
        String str = "";
        char[] ch = words.toCharArray();
        for(int i = 0; i < words.length();i++)
        {
            if(guess_word.indexOf(ch[i]) ==-1 ) {
                str += "_";
            }
            else
                str += String.valueOf(ch[i]);
        }
        return str;
    }

    public  int Times() {
         return times;
    }

    public  String exist_word() {

        return guess_word;
    }

    public void guess(char gs) {
        if(guess_word.indexOf(gs)==-1)
        {
            if(words.indexOf(gs)!=-1)
            { guess_word += String.valueOf(gs);
                --times;
            }
            else
                --times;
        }

    }

    public  String current_word() {
       String word =  incompleter_word();
        return word;
    }

    public  String Game_Status() {
        String status_1 = "you need to continue";
        String status_2 = "you are successful";
        String status_3 = "you have failed";
        if(times > 0)
        {
            if(words.equals(current_word()))
                return status_2;
            else
                return status_1;
        }
        if(words.equals(current_word()))
            return status_2;
        else
            return status_3;

    }
    public static void main(String[] args)
    {
        Hangman hangman = new Hangman("apple");
        Scanner sc = new Scanner(System.in);
        while("you need to continue".equals(hangman.Game_Status()))
        {
            System.out.println( hangman.current_word());
            System.out.println("请猜单词："+"\n");
            hangman.guess(sc.next().charAt(0));
            System.out.println("你还有" + hangman.Times() +"次机会。\n");
            System.out.println("目前单词组成状态：" + hangman.current_word());
            System.out.println( hangman.Game_Status());

        }



    }
}

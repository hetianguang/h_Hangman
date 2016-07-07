import java.util.Scanner;

/**
 * Created by Tiger on 2016/7/6.
 */
public class Hangman {

    private final String word;
    private int times;
    private String guessed_chars_and_ture;
    private String guessed_chars_but_false;
    public static final String STATUS_1 = "you need to continue";
    public static final String STATUS_2 = "you are successful";
    public static final String STATUS_3 = "you have failed";

    public Hangman(String str) {
        this.word = str;
        this.times = str.length()+1;
        this.guessed_chars_and_ture = "aeiou";
        this.guessed_chars_but_false = "";
    }

    public  int word_length() {
        return word.length();
    }

    public  String show_word() {
        return word;
    }

    public  String incompleter_word() {
        String str = "";
        char[] ch = word.toCharArray();
        int i = 0;
        while (i < word.length()) {

            str += isBoolean_not_in_guessed_chars(ch[i]) ? "_" : String.valueOf(ch[i]);
            i++;
        }
        return str;
    }

    private boolean isBoolean_not_in_guessed_chars(char ch) {
        return (guessed_chars_and_ture.indexOf(ch) ==-1 && guessed_chars_but_false.indexOf(ch) ==-1);
    }


    public  int Times() {
        return times;
    }

    public  String guessed_chars() {

        return guessed_chars_and_ture;
    }

    public void guess(char ch) {
        if(isBoolean_not_in_guessed_chars(ch))
        {
            --times;
            if(isaBoolean_in_word(ch))
                guessed_chars_and_ture += String.valueOf(ch);
            else
                guessed_chars_but_false += String.valueOf(ch);
        }
        else
            System.out.println("你已经猜过了！！！");

    }

    private boolean isaBoolean_in_word(char ch) {
        return word.indexOf(ch)!=-1;
    }

    public  String show_current_word() {
        return incompleter_word();
    }

    public  String Game_Status() {
        boolean equals = isOK_guess();
        return times > 0 ? equals ? STATUS_2 : STATUS_1 : equals ? STATUS_2 : STATUS_3;

    }

    private boolean isOK_guess() {
        return word.equals(show_current_word());
    }

    public static void main(String[] args)
    {
        Hangman hangman = new Hangman("apple");
        Scanner sc = new Scanner(System.in);
        while(STATUS_1.equals(hangman.Game_Status()))
        {
            System.out.println( hangman.show_current_word());
            System.out.println("请猜单词："+"\n");
            hangman.guess(sc.next().charAt(0));
            System.out.println("你还有" + hangman.Times() +"次机会。\n");
            System.out.println("目前单词组成状态：" + hangman.show_current_word());
            System.out.println( hangman.Game_Status());

        }

    }
}

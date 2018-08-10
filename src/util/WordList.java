import java.time.LocalDateTime;
import java.util.ArrayList;


public class WordList {
    ArrayList<WordEntry> ActiveWords;
    ArrayList<WordEntry> DeactivatedWords;
    String WordListName;
    LocalDateTime CreateTime;
    Integer idx;

    public WordList() {

    }

//    public WordList(String name, Integer NumOfWords) {
//        this.WordListName = name;
//        ActiveWords = new ArrayList<WordEntry>();
//        DeactivatedWords = new ArrayList<WordEntry>();
//    }

    public WordList(String name) {
        this.WordListName = name;
        ActiveWords = new ArrayList<WordEntry>();
        DeactivatedWords = new ArrayList<WordEntry>();
        idx = 0;
    }

    void neg_activate (WordEntry w) {
        w.neg_active();
        DeactivatedWords.add(w);
        ActiveWords.remove(w);

    }

    void add_a_word(WordEntry w) {
        ActiveWords.add(w);
    }

    WordEntry next_word() {
        return ActiveWords.get(idx);
    }

}

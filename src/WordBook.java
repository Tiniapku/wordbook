import java.util.ArrayList;
public class WordBook {
    ArrayList<WordList> MyLists;
    Integer NumOfLists;

    public WordBook(WordList FirstList) {
        MyLists = new ArrayList<WordList>();
        MyLists.add(FirstList);
        NumOfLists = 1;
    }

    void add_list(WordList list) {
        MyLists.add(list);
        NumOfLists += 1;
    }

    void remove_list(WordList list) {
        MyLists.remove(list);
        NumOfLists -= 1;
    }
}

import java.time.LocalDateTime;

public class WordEntry {
    String word;
    String def;
    String example;
    String ans;
    String notes;

    LocalDateTime last_mem;
    Integer mem_times;
    Boolean active;

    public WordEntry() {

    }

    public WordEntry(String word, String def, String example, String ans) {
        this.word = word;
        this.def = def;
        this.example = example;
        this.ans = ans;
        this.notes = "";

        this.active = true;
        this.mem_times = 0;
        this.last_mem = LocalDateTime.now();
    }

    void memorize() {
        this.mem_times++;
        this.last_mem = LocalDateTime.now();
    }

    void neg_active() {
        this.active = !this.active;
    }

    void update_notes(String s) {
        this.notes = s;
    }
}

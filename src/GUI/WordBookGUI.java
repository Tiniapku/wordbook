import javax.swing.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WordBookGUI extends JFrame
                         implements ActionListener {

    ArrayList<javax.swing.JButton> WordListButton;
    WordBook myWordBook;
    static int page_width = 500;
    static int page_height = 500;

    public WordBookGUI() {
        initComponents();
    }

    private void initComponents() {

        WordListButton = new ArrayList<javax.swing.JButton>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My WordBook");

        myWordBook = test_wordbook();

        for (WordList wl : myWordBook.MyLists) {
            javax.swing.JButton button = new javax.swing.JButton();
            button.setText(wl.WordListName);
            WordListButton.add(button);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        // (TODO) Edit the gap later
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        // Add horizontal and Vertical group, the layout should look like this:
        // First Group
        // Second Group
        // Third Group
        GroupLayout.Group g = layout.createParallelGroup();
        int list_count = 0;
        for (javax.swing.JButton button : WordListButton) {
            g.addComponent(button);
            button.addActionListener(this);
            button.setActionCommand(Integer.toString(list_count));
            list_count += 1;
        }
        hGroup.addGroup(g);

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        for (javax.swing.JButton button : WordListButton) {
            vGroup.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(button));
        }

        layout.setVerticalGroup(vGroup);
        //pack();

    }

    public void actionPerformed(ActionEvent e) {

        WordList wl = myWordBook.MyLists.get(Integer.parseInt(e.getActionCommand()));
        WordListGUI wl_page = new WordListGUI(wl);
        wl_page.setPreferredSize(new Dimension(this.page_width, this.page_height));
        wl_page.pack();
        wl_page.setVisible(true);
    }

    private WordBook test_wordbook() {
        WordEntry firstword = new WordEntry("wd1", "def", "ex", "ans");
        WordEntry secondword = new WordEntry("wd2", "def", "ex", "ans");
        WordEntry thirdword = new WordEntry("wd3", "def", "ex", "ans");
        WordList firstlist = new WordList("First List");
        firstlist.add_a_word(firstword);
        firstlist.add_a_word(secondword);
        firstlist.add_a_word(thirdword);
        WordBook firstbook = new WordBook(firstlist);

        WordList secondlist = new WordList("Second List");
        secondlist.add_a_word(firstword);
        firstbook.add_list(secondlist);

        WordList thirdlist = new WordList("Third List");
        thirdlist.add_a_word(firstword);
        firstbook.add_list(thirdlist);

        return firstbook;
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WordBookGUI wbg = new WordBookGUI();
                wbg.setPreferredSize(new Dimension(wbg.page_width, wbg.page_height));
                wbg.pack();
                wbg.setVisible(true);

            }
        });
    }


}
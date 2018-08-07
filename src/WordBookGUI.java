import javax.swing.*;
import java.awt.Dimension;
import java.util.ArrayList;

public class WordBookGUI extends javax.swing.JFrame{

    ArrayList<javax.swing.JButton> WordListButton;


    public WordBookGUI() {
        initComponents();
    }

    private void initComponents() {

        WordListButton = new ArrayList<javax.swing.JButton>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My WordBook");

        WordBook myWordBook = test_wordbook();

        for (WordList wl : myWordBook.MyLists) {
            javax.swing.JButton button = new javax.swing.JButton();
            button.setText(wl.WordListName);
            WordListButton.add(button);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        // Add horizontal and Vertical group, the layout should look like this:
        // First Group
        // Second Group
        // Third Group
        GroupLayout.Group g = layout.createParallelGroup();

        for (javax.swing.JButton button : WordListButton) {
            g.addComponent(button);
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

    private WordBook test_wordbook() {
        WordEntry firstword = new WordEntry("wd", "def", "ex", "ans");
        WordList firstlist = new WordList("First List");
        firstlist.add_a_word(firstword);
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
                wbg.setPreferredSize(new Dimension(500, 500));
                wbg.pack();
                wbg.setVisible(true);

            }
        });
    }


}
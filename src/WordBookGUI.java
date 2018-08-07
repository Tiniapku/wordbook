import javax.swing.*;
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
        int idx = 0;
        for (javax.swing.JButton button : WordListButton) {
            String text = myWordBook.MyLists.get(idx).WordListName;
            button.setText(text);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(WordListButton.get(0), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(WordListButton.get(1))
                            .addComponent(WordListButton.get(2)))));
        pack();

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
                new WordBookGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel celsiusLabel;
    private javax.swing.JButton convertButton;
    private javax.swing.JLabel fahrenheitLabel;
    private javax.swing.JTextField tempTextField;
    // End of variables declaration//GEN-END:variables

}
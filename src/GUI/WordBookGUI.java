import javax.swing.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WordBookGUI extends JFrame
                         implements ActionListener {

    // Share the following objects and attributes with subclasses
    WordBook myWordBook;
    JLabel Title;
    static int page_width = 500;
    static int page_height = 500;

    public WordBookGUI() {
        initComponents();
    }

    private void initComponents() {
        ArrayList<javax.swing.JButton> WordListButton;
        WordListButton = new ArrayList<javax.swing.JButton>();

        JLabel Title = new JLabel();
        Title.setText("My Word Book");
        JLabel EmptyLabel = new JLabel();
        EmptyLabel.setText("No list, please create new list");
        JButton CreateNewList = new JButton();
        CreateNewList.setText("Create New List");
        CreateNewList.addActionListener(this);
        CreateNewList.setActionCommand("CreateNew");
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
        g.addComponent(Title);
        int list_count = 0;

        if (WordListButton.size() == 0) {
            g.addComponent(EmptyLabel);
        }
        else {
            for (javax.swing.JButton button : WordListButton) {
                g.addComponent(button);
                button.addActionListener(this);
                button.setActionCommand(Integer.toString(list_count));
                list_count += 1;
            }
        }
        g.addComponent(CreateNewList);
        hGroup.addGroup(g);

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup().addComponent(Title));
        if (WordListButton.size() == 0) {
            vGroup.addGroup(layout.createParallelGroup().addComponent(EmptyLabel));
        }
        else {
            for (javax.swing.JButton button : WordListButton) {
                vGroup.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(button));
            }
        }
        vGroup.addGroup(layout.createParallelGroup().addComponent(CreateNewList));
        layout.setVerticalGroup(vGroup);
        //pack();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "CreateNew") {
            CreateNewListGUI cnl = new CreateNewListGUI();
            cnl.setPreferredSize(new Dimension(this.page_width, this.page_height));
            cnl.pack();
            cnl.setVisible(true);
        }
        else {
            int idx = Integer.parseInt(e.getActionCommand());
            WordListGUI wl_page = new WordListGUI(idx);
            wl_page.setPreferredSize(new Dimension(this.page_width, this.page_height));
            wl_page.pack();
            wl_page.setVisible(true);
        }
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
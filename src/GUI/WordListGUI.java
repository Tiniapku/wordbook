import javax.swing.*;
import java.awt.Dimension;
import java.util.ArrayList;

public class WordListGUI extends javax.swing.JFrame {
    ArrayList<javax.swing.JLabel> words;
    ArrayList<javax.swing.JButton> EditWordButton;
    ArrayList<javax.swing.JButton> RemoveWordButton;
    javax.swing.JButton AddNewButton;
    javax.swing.JButton StartButton;
    javax.swing.JButton BackButton;

    public WordListGUI(WordList wl) {
        initComponents(wl);
    }

    private void initComponents(WordList wl) {
        words = new ArrayList<JLabel>();
        EditWordButton = new ArrayList<JButton>();
        RemoveWordButton = new ArrayList<JButton>();
        AddNewButton = new JButton();
        StartButton = new JButton();
        BackButton = new JButton();
        JLabel title = new JLabel();
        title.setText("Active Words");

        AddNewButton.setText("Add New");
        StartButton.setText("Start");
        BackButton.setText("Back");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(wl.WordListName);

        for (WordEntry we : wl.ActiveWords) {
            javax.swing.JLabel wd = new JLabel();
            JButton edit = new JButton();
            JButton remove = new JButton();

            wd.setText(we.word);
            edit.setText("Edit");
            remove.setText("Remove");
            words.add(wd);
            EditWordButton.add(edit);
            RemoveWordButton.add(remove);
        }


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        // (TODO) edit the gap later
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        // The layout looks like this:
        // --------------------------------------------
        // | Active Words:                            |
        // | word1        edit        remove          |
        // | word2        edit        remove          |
        // | word3        edit        remove          |
        // |                                          |
        // | Add New      Start       Back            |
        // --------------------------------------------

        // left group
        GroupLayout.Group l = layout.createParallelGroup();
        l.addComponent(title);
        for (JLabel wd : words) {
            l.addComponent(wd);
        }
        l.addComponent(AddNewButton);
        hGroup.addGroup(l);

        // center group
        GroupLayout.Group c = layout.createParallelGroup();
        for (JButton edit : EditWordButton) {
            c.addComponent(edit);
        }
        c.addComponent(StartButton);
        hGroup.addGroup(c);

        // right group
        GroupLayout.Group r = layout.createParallelGroup();
        for (JButton remove: RemoveWordButton) {
            r.addComponent(remove);
        }
        r.addComponent(BackButton);
        hGroup.addGroup(r);

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup().addComponent(title));
        int list_length = words.size();
        for (int i = 0; i < list_length; i++) {
            vGroup.addGroup(layout.createParallelGroup()
                    .addComponent(words.get(i))
                    .addComponent(EditWordButton.get(i))
                    .addComponent(RemoveWordButton.get(i)));
        }

        vGroup.addGroup(layout.createParallelGroup()
        .addComponent(AddNewButton)
        .addComponent(StartButton)
        .addComponent(BackButton));

        layout.setVerticalGroup(vGroup);
    }
}

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddNewGUI extends WordBookGUI
                       implements ActionListener {

    JLabel AddNew;
    JLabel Word;
    JLabel Definition;
    JLabel Example;
    JLabel Answer;
    JButton Add;
    JButton Cancel;

    JTextField TWord;
    JTextField TDef;
    JTextField TEx;
    JTextField TAns;

    int idx;

    public AddNewGUI(int idx) {this.idx = idx; initComponents();}


    private void initialContents() {
        AddNew = new JLabel();
        Word = new JLabel();
        Definition = new JLabel();
        Example = new JLabel();
        Answer = new JLabel();
        Add = new JButton();
        Cancel = new JButton();

        TWord = new JTextField();
        TDef = new JTextField();
        TEx = new JTextField();
        TAns = new JTextField();

        AddNew.setText("AddNew");
        Word.setText("Word");
        Definition.setText("Definition");
        Example.setText("Example");
        Answer.setText("Answer");
        Add.setText("Add");
        Cancel.setText("Cancel");
    }
    private void initComponents() {

        initialContents();
        // Structure:
        // -------------------------------------
        // | Add New                           |
        // | Word          --------------------|
        // | Definition    --------------------|
        // | Example       --------------------|
        // | Answer        --------------------|
        // | Add           Cancel              |
        // -------------------------------------
        GroupLayout layout = new GroupLayout((getContentPane()));
        getContentPane().setLayout(layout);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().addComponent(AddNew)
                .addComponent(Word)
                .addComponent(Definition)
                .addComponent(Example)
                .addComponent(Answer)
                .addComponent(Add));

        hGroup.addGroup(layout.createParallelGroup().addComponent(TWord)
        .addComponent(TDef)
        .addComponent(TEx)
        .addComponent(TAns)
        .addComponent(Cancel));

        layout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup().addComponent(AddNew));
        vGroup.addGroup(layout.createParallelGroup().addComponent(Word).addComponent(TWord));
        vGroup.addGroup(layout.createParallelGroup().addComponent(Definition).addComponent(TDef));
        vGroup.addGroup(layout.createParallelGroup().addComponent(Example).addComponent(TEx));
        vGroup.addGroup(layout.createParallelGroup().addComponent(Answer).addComponent(TAns));
        vGroup.addGroup(layout.createParallelGroup().addComponent(Add).addComponent(Cancel));

        layout.setVerticalGroup(vGroup);


    }
    public void actionPerformed(ActionEvent e) {
        WordEntry wd = new WordEntry(TWord.getText(), TDef.getText(), TEx.getText(), TAns.getText());
        myWordBook.MyLists.get(this.idx).add_a_word(wd);

        
    }
}


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class CreateNewListGUI extends WordBookGUI
                           implements ActionListener {

    JLabel name;
    JLabel detail;
    JTextField Name;
    JTextField Detail;
    JButton Create;
    JButton Cancel;

    public CreateNewListGUI() {
        initComponent();
    }

    private void initContent() {
        this.Title = new JLabel();
        Title.setText("Create New List");

        name = new JLabel();
        name.setText("Name");

        detail = new JLabel();
        detail.setText("Details");

        Name = new JTextField();
        Detail = new JTextField();

        Create = new JButton();
        Create.setText("Create");
        Create.addActionListener(this);

        Cancel = new JButton();
        Cancel.setText("Cancel");
    }
    private void initComponent() {
        initContent();
        // Structure:
        // -------------------------------------
        // | Create New List                   |
        // | Name          --------------------|
        // | Details       --------------------|
        // | Create           Cancel           |
        // -------------------------------------

        GroupLayout layout = new GroupLayout((getContentPane()));
        getContentPane().setLayout(layout);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().addComponent(Title)
                .addComponent(name)
                .addComponent(detail)
                .addComponent(Create));
        hGroup.addGroup(layout.createParallelGroup().addComponent(Name)
        .addComponent(Detail)
        .addComponent(Cancel));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup().addComponent(Title))
                .addGroup(layout.createParallelGroup().addComponent(name).addComponent(Name))
                .addGroup(layout.createParallelGroup().addComponent(detail).addComponent(Detail))
                .addGroup(layout.createParallelGroup().addComponent(Create).addComponent(Cancel));
        layout.setVerticalGroup(vGroup);
    }

    public void actionPerformed(ActionEvent e) {
        WordList new_wl = new WordList(Name.getText());
        myWordBook.add_list(new_wl);
//        for (WordList wl :myWordBook.MyLists) {
//            System.out.println(wl.WordListName);
//        }

    }


}

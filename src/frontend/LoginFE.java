package frontend;

import Contract.PersonelContract;
import dal.AccountsDAL;
import dal.PersonelDAL;
import interfaces.FeInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFE extends JDialog implements FeInterfaces {
    public static JComboBox emailBox;
    public LoginFE(){
        initPencere();

    }


    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
        setTitle("Lütfen Giriş Yapınız");

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(3,2));

        panel.setBorder(BorderFactory.createTitledBorder("Lütfen Bilgilerini Giriniz"));
        JLabel mail = new JLabel("Email : ",JLabel.RIGHT);
        panel.add(mail);
        emailBox = new JComboBox(new PersonelDAL().GetAll().toArray());
        panel.add(emailBox);
        JLabel password = new JLabel("Sifre : ",JLabel.RIGHT);
        panel.add(password);
        JPasswordField passwordField = new JPasswordField(15);
        panel.add(passwordField);

        JButton loginButton = new JButton("Giriş Yap");
        panel.add(loginButton);
        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonelContract contract = (PersonelContract) emailBox.getSelectedItem();
                String sifre = passwordField.getText();
                if(new AccountsDAL().GetPersonelIdVeSifre(contract.getId(),sifre).getId() !=0){
                    new AnaPencereFE();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Giriş Başarısız");
                }
            }
        });
        return panel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        return null;
    }
}

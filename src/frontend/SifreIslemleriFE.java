package frontend;

import Contract.AccountsContract;
import Contract.PersonelContract;
import Contract.YetkilerContract;
import dal.AccountsDAL;
import dal.PersonelDAL;
import dal.YetkilerDAL;
import interfaces.FeInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SifreIslemleriFE extends JDialog implements FeInterfaces {
    public SifreIslemleriFE(){
        initPencere();
    }
    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Şifre Belirle"));
        add(panel);

        setTitle("Şifre Belirle");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);

        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(5,2));

        JLabel personelLabel = new JLabel("Personel Seç" , JLabel.RIGHT);
        panel.add(personelLabel);
        JComboBox personelBox =new JComboBox(new PersonelDAL().GetAll().toArray());
        panel.add(personelBox);

        JLabel yetkiLabel = new JLabel("Yetki Seç" , JLabel.RIGHT);
        panel.add(yetkiLabel);
        JComboBox yetkiBox =new JComboBox(new YetkilerDAL().GetAll().toArray());
        panel.add(yetkiBox);

        JLabel sifreLabel = new JLabel("Şifre Girin",JLabel.RIGHT);
        panel.add(sifreLabel);
        JPasswordField sifreField = new JPasswordField(15);
        panel.add(sifreField);

        JLabel sifreTekrarLabel = new JLabel("Şifre Girin",JLabel.RIGHT);
        panel.add(sifreTekrarLabel);
        JPasswordField sifreTekrarField = new JPasswordField(15);
        panel.add(sifreTekrarField);

        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // kişinin daha önce şifre belirlenmiş mi diye kontrol edilmeli
                AccountsContract contract = new AccountsContract();
                PersonelContract pContract = (PersonelContract) personelBox.getSelectedItem();
                YetkilerContract yContract = (YetkilerContract) yetkiBox.getSelectedItem();
                // girilen iki şifre eşit mi diye kontrol edilir.
                if(sifreField.getText().equals(sifreTekrarField.getText())){
                    contract.setPersonelId(pContract.getId());
                    contract.setYetkiId(yContract.getId());
                    contract.setSifre(sifreField.getText());


                    new AccountsDAL().Insert(contract);


                    JOptionPane.showConfirmDialog(null,  "Şifre Belirlendi.");

                }
                else {
                    JOptionPane.showMessageDialog(null,"Şifreler aynı değil");
                }

            }
        });
        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);

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

package frontend;

import Contract.KategoriContract;
import Contract.PersonelContract;
import dal.PersonelDAL;
import interfaces.FeInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonelEkleFE extends JDialog implements FeInterfaces {
    public PersonelEkleFE(){
        initPencere();
    }
    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Personel EKle"));
        add(panel);

        setTitle("Personel Ekle");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);

        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);


    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(3,2));
        JLabel adiLabel = new JLabel("Adı Soyadı",JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField = new JTextField(15);
        panel.add(adiField);

        JLabel mailLabel = new JLabel("Email",JLabel.RIGHT);
        panel.add(mailLabel);
        JTextField mailField = new JTextField(15);
        panel.add(mailField);

        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            PersonelContract contract = new PersonelContract();
            contract.setAdiSoyadi(adiField.getText());
            contract.setEmail(mailField.getText());
            new PersonelDAL().Insert(contract);
            JOptionPane.showConfirmDialog(null, contract.getAdiSoyadi() + " Adlı personel eklenmiştir.");

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

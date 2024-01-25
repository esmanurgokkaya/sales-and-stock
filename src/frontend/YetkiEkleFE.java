package frontend;

import Contract.PersonelContract;
import Contract.YetkilerContract;
import dal.PersonelDAL;
import dal.YetkilerDAL;
import interfaces.FeInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YetkiEkleFE extends JDialog implements FeInterfaces {
    public YetkiEkleFE(){
        initPencere();
    }
    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Yetki EKle"));
        add(panel);

        setTitle("Yetki Ekle");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);

        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {

        JPanel panel = new JPanel(new GridLayout(2,2));
        JLabel adiLabel = new JLabel("Yetki Adı",JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField = new JTextField(15);
        panel.add(adiField);


        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YetkilerContract contract = new YetkilerContract();
                contract.setAdi(adiField.getText());
                //contract.setEmail(mailField.getText());
                new YetkilerDAL().Insert(contract);
                JOptionPane.showConfirmDialog(null, contract.getAdi() + " Adlı yetki eklenmiştir.");

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

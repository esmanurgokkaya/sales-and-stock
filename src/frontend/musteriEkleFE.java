package frontend;

import Contract.KategoriContract;
import Contract.MusteriContract;
import dal.KategoriDAL;
import dal.MusteriDAL;
import interfaces.FeInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class musteriEkleFE extends JDialog implements FeInterfaces {

    public musteriEkleFE(){
        initPencere();
    }
    @Override
    public void initPencere() {
        JPanel panel = initPanel();

        panel.setBorder(BorderFactory.createTitledBorder("Müşteri Ekle"));
        add(panel);
        setTitle("Müşteri Ekle");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {
        JPanel panel =new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new GridLayout(3,2));
        JPanel buttonPanel = new JPanel(new GridLayout(1,2));

        JLabel adiLabel = new JLabel("Müşteri Adı Soyadı ",JLabel.RIGHT);
        fieldPanel.add(adiLabel);
        JTextField adiField = new JTextField(15);
        fieldPanel.add(adiField);
        JLabel sehirLabel = new JLabel("Şehir Seç " , JLabel.RIGHT);
        fieldPanel.add(sehirLabel);
        JComboBox sehirbox = new JComboBox(new KategoriDAL().GetAllParentId().toArray());
        fieldPanel.add(sehirbox);
//        JLabel adresLabel = new JLabel("Adres" , JLabel.RIGHT);
//        fieldPanel.add(adresLabel);

        JTextArea adresArea = new JTextArea(5,1);
        JScrollPane adresPane = new JScrollPane(adresArea);
        adresPane.setBorder(BorderFactory.createTitledBorder("Adres"));


        JButton kaydetButton = new JButton("Kaydet");
        buttonPanel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MusteriContract contract = new MusteriContract();

                if(sehirbox.getSelectedIndex() != 0){
                    KategoriContract castContract =(KategoriContract) sehirbox.getSelectedItem();
                    contract.setAdiSoyadi(adiField.getText());
                    contract.setSehirId(castContract.getId());

                    new MusteriDAL().Insert(contract);
                    JOptionPane.showConfirmDialog(null,contract.getAdiSoyadi()+" Adlı Kişi Başarılı Şekilde Eklenmiştir.");

                }
                else{
                    contract.setAdiSoyadi(adiField.getText());
                    contract.setSehirId(sehirbox.getSelectedIndex());

                    new MusteriDAL().Insert(contract);
                    JOptionPane.showConfirmDialog(null,contract.getAdiSoyadi()+ " Adlı Kişi Başarılı Şekilde Eklenmiştir.");
                }
            }
        });
        JButton iptalButton = new JButton("İptal");
        buttonPanel.add(iptalButton);

        panel.add(fieldPanel, BorderLayout.NORTH);
        panel.add(adresPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);


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

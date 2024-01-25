package frontend;

import Contract.KategoriContract;
import dal.KategoriDAL;
import interfaces.FeInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KategoriEkleFE extends JDialog implements FeInterfaces {
    public KategoriEkleFE(){
    initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();

        panel.setBorder(BorderFactory.createTitledBorder("Kategori Ekle"));
        add(panel);
        setTitle("Kategori Ekle");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);


    }

    @Override
    public JPanel initPanel() {
        JPanel panel =new JPanel(new GridLayout(3,2));

        JLabel adiLabel = new JLabel("Kategori Adı",JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField = new JTextField(15);
        panel.add(adiField);

        JLabel kategoriLabel = new JLabel("Kategori Seç" , JLabel.RIGHT);
        panel.add(kategoriLabel);

        JComboBox kategoribox = new JComboBox(new KategoriDAL().GetAllParentId().toArray());
        panel.add(kategoribox);
        kategoribox.insertItemAt("--Kategori Seçiniz--",0);
        kategoribox.setSelectedIndex(0);
        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KategoriContract contract = new KategoriContract();

                if(kategoribox.getSelectedIndex() != 0){
                    KategoriContract castContract =(KategoriContract) kategoribox.getSelectedItem();
                    contract.setAdi(adiField.getText());
                    contract.setParentId(castContract.getId());

                    new KategoriDAL().Insert(contract);
                    JOptionPane.showConfirmDialog(null,contract.getAdi()+"Adlı Kayıt Başarılı Şekilde Eklenmiştir.");

                }
                else{
                    contract.setAdi(adiField.getText());
                    contract.setParentId(kategoribox.getSelectedIndex());

                    new KategoriDAL().Insert(contract);
                    JOptionPane.showConfirmDialog(null,contract.getAdi()+"Adlı Kayıt Başarılı Şekilde Eklenmiştir.");
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

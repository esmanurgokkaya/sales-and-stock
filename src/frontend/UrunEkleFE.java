package frontend;

import Contract.KategoriContract;
import Contract.UrunlerContract;
import dal.KategoriDAL;
import dal.UrunlerDAL;
import interfaces.FeInterfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class UrunEkleFE extends JDialog implements FeInterfaces {

    public  UrunEkleFE(){
    initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();

        panel.setBorder(BorderFactory.createTitledBorder("Ürün Kayıt Alanı")); // daha güzel duracak üst başlığı verir.
        add(panel);
        setTitle("Ürün Ekleyin");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE); // bu açılan pencerinin alta atılmasını engeller
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(5,2));

        JLabel adiLabel = new JLabel( "Ürün Adı:",JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField = new JTextField(10);
        panel.add(adiField);
        JLabel kategoriLabel = new JLabel("Kategori",JLabel.RIGHT);
        panel.add(kategoriLabel);
        JComboBox kategoriBox = new JComboBox(new KategoriDAL().GetAll().toArray());
        panel.add(kategoriBox);

// Tarih seçici için SpinnerDateModel oluşturun
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        JSpinner tarihDate = new JSpinner(dateModel);

// JSpinner.DateEditor'ı al ve bir Date nesnesiyle ilişkilendir
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(tarihDate, "dd-MM-yyyy");

// JSpinner'ın düzenleyicisini JSpinner.DateEditor olarak ayarla
        tarihDate.setEditor(dateEditor);

// Panelinize JSpinner'ı ekleyin
        panel.add(new JLabel("Tarih", JLabel.RIGHT));
        panel.add(tarihDate);




        JLabel fiyatLabel = new JLabel("Fiyat",JLabel.RIGHT);
        panel.add(fiyatLabel);
        JTextField fiyaatField =new JTextField(10);
        panel.add(fiyaatField);

        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UrunlerContract contract = new UrunlerContract();
                KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();


                contract.setAdi(adiField.getText());
                contract.setKategoriId(casContract.getId());
                // JSpinner'dan tarih değerini al
                Date selectedDate = (Date) tarihDate.getValue();

                // Formatla ve set et
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(selectedDate);
                contract.setTarih(formattedDate);

                contract.setFiyat(Float.parseFloat(fiyaatField.getText()));
                new UrunlerDAL().Insert(contract);
                JOptionPane.showConfirmDialog(null,contract.getAdi() + " Adlı ürün başarılı şekilde eklendi.");
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

package frontend;

import interfaces.FeInterfaces;
import utilities.MenulerFE;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class AnaPencereFE extends JFrame implements FeInterfaces {

    public AnaPencereFE (){
        initPencere();
    }

    @Override
    public void initPencere() {
        JTabbedPane tabs =initTabs();
        JPanel panel = initPanel();
        JMenuBar bar = initBar();


       add(tabs);
        setJMenuBar(bar);
        setTitle("Satış ve Stok Programı");
        setSize(600,600);;
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTabbedPane pane = initTabs();
        panel.add(pane, BorderLayout.CENTER);


        return panel;
    }

    @Override
    public JMenuBar initBar() {
        JMenuBar bar = MenulerFE.initBar();

        return bar;
    }

    @Override
    public JTabbedPane initTabs() {
        JTabbedPane pane = new JTabbedPane();
        ImageIcon icon = new ImageIcon("C:\\Users\\esman\\java-coding\\satis_stok\\src\\frontend\\icons\\stokIcon2.png");


        JPanel stokPanel = new JPanel(new BorderLayout());
        JPanel satisPanel = new JPanel(new BorderLayout());


        /*Stok itemleri*/
        JPanel stokSolPanel = new JPanel(new BorderLayout());
        JPanel stokSolUstPanel = new JPanel(new GridLayout(4,2));
        JPanel stokSolAltPanel = new JPanel();
        stokSolPanel.setBorder(BorderFactory.createTitledBorder("Stok İşlemleri"));

        String [] stokKolonlar = {"Id", "Personel Adı", "Ürün Adı","Adeti","Tarihi"};

        DefaultTableModel model = new DefaultTableModel(stokKolonlar,0);

        JTable table = new JTable(model);
        JScrollPane stokPanelTable = new JScrollPane(table);

        JLabel stokUrunAdi  = new JLabel("Ürün Adi : ", JLabel.RIGHT);
        stokSolUstPanel.add(stokUrunAdi);
        JComboBox stokUrunAdiBox = new JComboBox();
        stokSolUstPanel.add(stokUrunAdiBox);
        JLabel stokAdet = new JLabel("Adet : ",JLabel.RIGHT);
        stokSolUstPanel.add(stokAdet);
        JTextField stokAdetField = new JTextField(15);
        stokSolUstPanel.add(stokAdetField);
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        JSpinner tarihDate = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(tarihDate, "dd-MM-yyyy");
        tarihDate.setEditor(dateEditor);
        JLabel tarih = new JLabel("Tarih : ", JLabel.RIGHT);
        stokSolUstPanel.add(tarih);
        stokSolUstPanel.add(tarihDate, BorderLayout.CENTER);
        JButton stokEkleButton = new JButton("Stok Ekle");
        stokSolUstPanel.add(stokEkleButton);
        JButton stokYenileButton = new JButton("Yenile");
        stokSolUstPanel.add(stokYenileButton);


        /*Satış itemleri*/
        JPanel satisSagPanel = new JPanel(new BorderLayout());
        JPanel satisSagUstPanel = new JPanel(new GridLayout(4,2));
        JPanel satisSagAltPanel = new JPanel();
        satisSagPanel.setBorder(BorderFactory.createTitledBorder("Satış İşlemleri"));

        String [] satisKolonlar = {"Id", "Personel Adı","Müşteri Adı", "Ürün Adı","Adeti","Tarihi"};
        DefaultTableModel model1 = new DefaultTableModel(satisKolonlar,0);
        JTable table1 = new JTable(model1);
        JScrollPane satisPanelTable = new JScrollPane(table1);
        JLabel satisUrunAdi  = new JLabel("Ürün Adi : ", JLabel.RIGHT);
        satisSagUstPanel.add(satisUrunAdi);
        JComboBox satisUrunAdiBox = new JComboBox();
        satisSagUstPanel.add(satisUrunAdiBox);
        JLabel satisAdet = new JLabel("Adet : ",JLabel.RIGHT);
        satisSagUstPanel.add(satisAdet);
        JTextField satisAdetField = new JTextField(15);
        satisSagUstPanel.add(satisAdetField);

        SpinnerDateModel dateModell = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        JSpinner tarihDatee = new JSpinner(dateModell);
        JSpinner.DateEditor dateEditorr = new JSpinner.DateEditor(tarihDatee, "dd-MM-yyyy");
        tarihDatee.setEditor(dateEditorr);
        JLabel tarihh = new JLabel("Satış Tarihi : ", JLabel.RIGHT);
        satisSagUstPanel.add(tarihh);
        satisSagUstPanel.add(tarihDatee, BorderLayout.CENTER);

        JButton satisEkleButton = new JButton("Satış Yap");
        satisSagUstPanel.add(satisEkleButton);
        JButton satisYenileButton = new JButton("Yenile");
        satisSagUstPanel.add(satisYenileButton);

        satisPanel.add(satisSagPanel,BorderLayout.WEST);
        satisPanel.add(satisPanelTable,BorderLayout.CENTER);

        satisSagPanel.add(satisSagUstPanel,BorderLayout.NORTH);
        satisSagPanel.add(satisSagAltPanel,BorderLayout.SOUTH);


        stokPanel.add(stokSolPanel,BorderLayout.WEST);
        stokPanel.add(stokPanelTable, BorderLayout.CENTER);

        stokSolPanel.add(stokSolUstPanel,BorderLayout.NORTH);
        stokSolPanel.add(stokSolAltPanel, BorderLayout.SOUTH);

        pane.addTab("Stok", icon,stokPanel, "Does nothing");
        pane.addTab("Satiş",icon,satisPanel, "yazı");
        return pane;
    }
}

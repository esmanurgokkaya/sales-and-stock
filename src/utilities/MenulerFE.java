package utilities;

import frontend.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenulerFE {
    public static JMenuBar initBar() {
        JMenuBar bar = new JMenuBar();

        JMenu dosyaMenu = new JMenu("Dosya");
        bar.add(dosyaMenu);
        JMenuItem cikisItem = new JMenuItem("Çıkış");
        dosyaMenu.add(cikisItem);
// ürünler menüsü
        JMenu urunlerMenu = new JMenu( "Ürünler");
        bar.add(urunlerMenu);
        JMenuItem urunlerEkleItem = new JMenuItem("Ürün Ekle");
        urunlerMenu.add(urunlerEkleItem);
        JMenuItem kategoriEkleItem = new JMenuItem("Kategori Ekle");
        urunlerMenu.add(kategoriEkleItem);
        urunlerMenu.addSeparator();
        JMenuItem urunDuzenleItem = new JMenuItem("Ürün Düzenle");
        urunlerMenu.add(urunDuzenleItem);
        JMenuItem kategoriDuzenleItem = new JMenuItem( "Kategori Düzenle");
        urunlerMenu.add(kategoriDuzenleItem);
      // personeller menüsü
        JMenu personellerMenu = new JMenu("Personel İşlemleri");
        bar.add(personellerMenu);
        JMenuItem personelEkleItem = new JMenuItem("Personel Ekle");
       personellerMenu.add(personelEkleItem);
        JMenuItem yetkiEkleItem = new JMenuItem("Yetki Ekle");
        personellerMenu.add(yetkiEkleItem);
        JMenuItem sifreBelirleItem = new JMenuItem("Şİfre Belirile");
        personellerMenu.add(sifreBelirleItem);
        personellerMenu.addSeparator();

        JMenuItem personelDuzenleItem = new JMenuItem("Personel Düzenle");
        personellerMenu.add(personelDuzenleItem);
        JMenuItem yetkiDuzenleItem = new JMenuItem("Yetki Düzenle");
        personellerMenu.add(yetkiDuzenleItem);
        JMenuItem sifreDuzenleItem = new JMenuItem("Şifre Düzenle");
        personellerMenu.add(sifreDuzenleItem);


        // müşteriler menüsü
        JMenu musterilerMenu = new JMenu("Müşteri İşlemleri");
        bar.add(musterilerMenu);
        JMenuItem musteriEkleItem = new JMenuItem("Müşteri Ekle");
        musterilerMenu.add(musteriEkleItem);
        JMenuItem sehirEkleItem = new JMenuItem("Şehir Ekle");
        musterilerMenu.add(sehirEkleItem);
        musterilerMenu.addSeparator();

        JMenuItem musteriDuzenleItem = new JMenuItem("Müşteri Düzenle");
        musterilerMenu.add(musteriDuzenleItem);
        JMenuItem sehirDuzenleItem = new JMenuItem("Şehir Düzenle");
        musterilerMenu.add(sehirDuzenleItem);


        urunlerEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new UrunEkleFE();
                    }
                });
            }
        });

        kategoriEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KategoriEkleFE();
            }
        });
        personelEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new PersonelEkleFE();
                    }
                });
            }
        });

        yetkiEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new YetkiEkleFE();
                    }
                });
            }
        });

        sifreBelirleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new SifreIslemleriFE();
                    }
                });
            }
        });

        musteriEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new musteriEkleFE();
                    }
                });
            }
        });
        return bar;
    }
}

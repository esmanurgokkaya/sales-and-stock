package interfaces;

import javax.swing.*;

public class AnaPencereFE extends JFrame implements FeInterfaces {

    public AnaPencereFE (){
        initPencere();
    }

    @Override
    public void initPencere() {
        JTabbedPane tabs =initTabs();
        JPanel panel = initPanel();
        JMenuBar bar = initBar();


       // add(tabs);
        //setJMenuBar(bar);
        setTitle("Satış ve Stok Programı");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        return null;
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

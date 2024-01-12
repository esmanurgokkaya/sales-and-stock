package test;

import interfaces.AnaPencereFE;

import javax.swing.*;

 public class Run {

    public static void main(){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AnaPencereFE();
            }
        });

    }
 }

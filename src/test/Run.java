package test;

import frontend.AnaPencereFE;
import frontend.LoginFE;

import javax.swing.*;

 public class Run {
     //yazılan tüm kodların yürütülmesi için ana pencere clası new edilir.

    public static void main(String[] args){
        try{
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        }
        catch (Exception e){
            // if nimbus is not availeble, you can set the gui to another look and feel
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                new AnaPencereFE();
                new LoginFE();
            }
        });

    }
 }




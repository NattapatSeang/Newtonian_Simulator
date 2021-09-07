/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newton;

import static java.awt.Color.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author W7
 */
public class Newton extends javax.swing.JFrame {

    public Newton() {
        initComponents();
    }
    
    public boolean check;
    

    public void paint(Graphics g) {
        if(check==true)
        {
        //Graphic Variable
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(red);
        g3.fillOval(450-15, 300-15, 30, 30);
        
        //Variable
        double VX=Double.parseDouble(ObjVX.getText());
        double VY=0-Double.parseDouble(ObjVY.getText());
        double M=Double.parseDouble(SunMass.getText());
        double m=Double.parseDouble(ObjMass.getText());
        double VXnew,VYnew;
        int D=0;
        int t = 0;
        int tmax=Integer.parseInt(TimeSet.getText());
        if(RadioButton1.isSelected())
        {
            D = 1000000;
        }
        else if(RadioButton2.isSelected())
        {
            D = 10000;
        }

        double X=450*D+Double.parseDouble(ObjX.getText());
        double Y=300*D-Double.parseDouble(ObjY.getText());
        int SunX=450*D;
        int SunY=300*D;
        double G=6.6742*0.00000000000000000001*3600*3600;
        
        //Math 
        while((X<900*D)&&(X>0)&&(Y>0)&&(Y<600*D)&&(t<tmax))
        {
            
        //time
        t = t+1;
        String T = String.valueOf(t);
	TimeSet.setText(T);
        
        //GMm
        double r = ((X-SunX)*(X-SunX))+((Y-SunY)*(Y-SunY));
        double F = G*M*m/r;
        double A = F/m;
        
        //Find Degree
        double Yt = Math.abs(Y-SunY);
        double Xt = Math.abs(X-SunX);
        double Z = atan(Yt/Xt);
        
        //Vector
        double AY = A*sin(Z);
        double AX = A*cos(Z);
        
        if((X>=450*D)&&(Y>=300*D))
        {
            VXnew = VX-AX;
            VYnew = VY-AY;
        }
        else
        if((X<=450*D)&&(Y>=300*D))
        {
            VXnew = VX+AX;
            VYnew = VY-AY;
        }
        else
        if((X>=450*D)&&(Y<=300*D))
        {
            VXnew = VX-AX;
            VYnew = VY+AY;
        }
        else
        {
            VXnew = VX+AX;
            VYnew = VY+AY;
        }
        
        double Xnew = X+VXnew;
        double Ynew = Y+VYnew;
        
        //Change to int
        int xnew = (int) (Xnew/D);
        int ynew = (int) (Ynew/D);       
        int x = (int) (X/D);
        int y = (int) (Y/D);            
        
        //Update
        VX = VXnew;
        VY = VYnew;
        X=Xnew;
        Y=Ynew;
        int xr = x-450;
        int yr = 0-(y-350);
        String XL = String.valueOf(xr);
        String YL = String.valueOf(yr);
        LastX.setText(XL);
        LastY.setText(YL);
        
        //Graphic
        g2.setColor(black);
        Line2D lin = new Line2D.Float(x, y, xnew, ynew);
        g2.draw(lin);
        }
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GridSet = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ObjX = new javax.swing.JTextField();
        ObjY = new javax.swing.JTextField();
        ObjVX = new javax.swing.JTextField();
        ObjVY = new javax.swing.JTextField();
        ObjMass = new javax.swing.JTextField();
        SunMass = new javax.swing.JTextField();
        TimeSet = new javax.swing.JTextField();
        Okay = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        RadioButton1 = new javax.swing.JRadioButton();
        RadioButton2 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LastX = new javax.swing.JTextField();
        LastY = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Newton V.1");
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(0, 0, 900, 600));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ObjX");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 117, 19);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ObjY");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 75, 28, 15);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("ObjVX");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 135, 37, 15);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ObjVY");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 195, 36, 15);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ObjMass");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 255, 51, 15);

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("SunMass");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 315, 54, 15);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Set Time");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 375, 60, 15);

        ObjX.setText("149600000");
        ObjX.setName("ObjX"); // NOI18N
        ObjX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObjXActionPerformed(evt);
            }
        });
        getContentPane().add(ObjX);
        ObjX.setBounds(10, 36, 220, 28);

        ObjY.setText("0");
        ObjY.setAutoscrolls(false);
        ObjY.setName("ObjY"); // NOI18N
        getContentPane().add(ObjY);
        ObjY.setBounds(10, 96, 220, 28);

        ObjVX.setText("0");
        getContentPane().add(ObjVX);
        ObjVX.setBounds(10, 156, 220, 28);

        ObjVY.setText("108000");
        getContentPane().add(ObjVY);
        ObjVY.setBounds(10, 216, 220, 28);

        ObjMass.setText("5972000000000000000000000");
        ObjMass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObjMassActionPerformed(evt);
            }
        });
        getContentPane().add(ObjMass);
        ObjMass.setBounds(10, 276, 220, 28);

        SunMass.setText("1989000000000000000000000000000");
        getContentPane().add(SunMass);
        SunMass.setBounds(10, 336, 220, 28);

        TimeSet.setText("8760");
        getContentPane().add(TimeSet);
        TimeSet.setBounds(70, 370, 70, 28);

        Okay.setText("OK");
        Okay.setName("OK"); // NOI18N
        Okay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkayActionPerformed(evt);
            }
        });
        getContentPane().add(Okay);
        Okay.setBounds(90, 410, 47, 23);

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        getContentPane().add(Reset);
        Reset.setBounds(150, 410, 60, 23);

        GridSet.add(RadioButton1);
        RadioButton1.setSelected(true);
        RadioButton1.setText("(900*10^6) X (600*10^6) km^2");
        RadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(RadioButton1);
        RadioButton1.setBounds(10, 440, 210, 23);

        GridSet.add(RadioButton2);
        RadioButton2.setText("(900*10^3) X (600*10^4) km^2");
        RadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(RadioButton2);
        RadioButton2.setBounds(10, 460, 190, 23);

        jLabel8.setText("Set Grid");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 410, 50, 20);

        jLabel9.setText("hours");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(150, 380, 34, 14);

        LastX.setEnabled(false);
        getContentPane().add(LastX);
        LastX.setBounds(10, 530, 70, 30);

        LastY.setEnabled(false);
        getContentPane().add(LastY);
        LastY.setBounds(110, 530, 70, 30);

        jLabel10.setText("Location Now");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 500, 90, 14);

        jLabel11.setText(",");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(100, 560, 10, 14);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void OkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkayActionPerformed
        check=true;
        repaint();
    }//GEN-LAST:event_OkayActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        check=false;
    }//GEN-LAST:event_ResetActionPerformed

    private void ObjXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObjXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ObjXActionPerformed

    private void RadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButton1ActionPerformed

    private void RadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButton2ActionPerformed

    private void ObjMassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObjMassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ObjMassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Newton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Newton().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GridSet;
    private javax.swing.JTextField LastX;
    private javax.swing.JTextField LastY;
    private javax.swing.JTextField ObjMass;
    private javax.swing.JTextField ObjVX;
    private javax.swing.JTextField ObjVY;
    private javax.swing.JTextField ObjX;
    private javax.swing.JTextField ObjY;
    private javax.swing.JButton Okay;
    private javax.swing.JRadioButton RadioButton1;
    private javax.swing.JRadioButton RadioButton2;
    private javax.swing.JButton Reset;
    private javax.swing.JTextField SunMass;
    public javax.swing.JTextField TimeSet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}

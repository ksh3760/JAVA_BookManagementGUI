package p20201020å����;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
   static JTextField[] tfs;
   static JButton[] buttons;
   
   public MyFrame(String name) {
      this.setTitle(name);
      this.setSize(500, 500);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new GridLayout(5, 3));
      
      JLabel[] labels = new JLabel[5];
      labels[0] = new JLabel("å��ȣ");
      labels[1] = new JLabel("å�̸�");
      labels[2] = new JLabel("���ǻ�");
      labels[3] = new JLabel("���ǳ⵵");
      labels[4] = new JLabel("����");

      tfs = new JTextField[5];
      for (int i = 0; i < 5; i++) {
         tfs[i] = new JTextField(20);
      }
      
      JButton[] buttons = new JButton[5];
      buttons[0] = new JButton("��ȸ");      
      buttons[1] = new JButton("����");
      buttons[2] = new JButton("����");
      buttons[3] = new JButton("����");
      
      MyActionListener listener = new MyActionListener(this);
      for (int i = 0; i < 5; i++) {
         this.add(labels[i]);
         this.add(tfs[i]);
         if (i < 4) {
            this.add(buttons[i]);
            buttons[i].addActionListener(listener);
         }

      }

      this.setVisible(true);
   }

}



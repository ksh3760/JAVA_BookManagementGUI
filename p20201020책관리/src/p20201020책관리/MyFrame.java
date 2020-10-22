package p20201020책관리;

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
      labels[0] = new JLabel("책번호");
      labels[1] = new JLabel("책이름");
      labels[2] = new JLabel("출판사");
      labels[3] = new JLabel("출판년도");
      labels[4] = new JLabel("가격");

      tfs = new JTextField[5];
      for (int i = 0; i < 5; i++) {
         tfs[i] = new JTextField(20);
      }
      
      JButton[] buttons = new JButton[5];
      buttons[0] = new JButton("조회");      
      buttons[1] = new JButton("삽입");
      buttons[2] = new JButton("수정");
      buttons[3] = new JButton("삭제");
      
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



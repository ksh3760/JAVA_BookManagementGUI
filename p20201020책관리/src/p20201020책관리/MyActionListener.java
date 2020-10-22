package p20201020å����;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MyActionListener implements ActionListener {
   MyFrame myFrame;
   
   public MyActionListener(MyFrame myFrame) {
      this.myFrame = myFrame;
   
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      JButton button = (JButton)e.getSource();	// ���� ��ư�� �����ϰ� �Ѵ�.
      String type = button.getText();
      
      System.out.println(type + " (��)�� �������ϴ�." + " å��ȣ : " + myFrame.tfs[0].getText());
      System.out.println("------------------------------");

      switch (type) {
		case "��ȸ": {
			
		  	  MyDb.SearchBook();	  
		      MyFrame.tfs[0].setText(Integer.toString(MyDb.book_id));
		      MyFrame.tfs[1].setText(MyDb.title);
		      MyFrame.tfs[2].setText(MyDb.publisher);
		      MyFrame.tfs[3].setText(MyDb.year);
		      MyFrame.tfs[4].setText(Integer.toString(MyDb.price));	

	      break;
		}
		case "����": {
			MyDb.InsertBook ();
			break;
		}
		case "����": {
			MyDb.UpdateBook();
			break;
		}
		case "����": {
			// ���� ���� ��Ȯ��
			int result = JOptionPane.showConfirmDialog(null, 
					"���� �����Ͻðڽ��ϱ�?", "������ ����", JOptionPane.YES_NO_OPTION);
	
			if(result == JOptionPane.CLOSED_OPTION) {
				System.out.println("â�� �ݾҽ��ϴ�.");
			} else if(result == JOptionPane.YES_OPTION) {
				MyDb.DeleteBook();
			} else
				System.out.println("����Ͽ����ϴ�.");

			 break;
		}

	}// end switch
      
   }// public void actionPerformed
   
}// end public class MyActionListener implements ActionListener


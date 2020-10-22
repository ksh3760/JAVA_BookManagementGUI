package p20201020책관리;

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
      JButton button = (JButton)e.getSource();	// 누른 버튼을 동작하게 한다.
      String type = button.getText();
      
      System.out.println(type + " (을)를 눌렀습니다." + " 책번호 : " + myFrame.tfs[0].getText());
      System.out.println("------------------------------");

      switch (type) {
		case "조회": {
			
		  	  MyDb.SearchBook();	  
		      MyFrame.tfs[0].setText(Integer.toString(MyDb.book_id));
		      MyFrame.tfs[1].setText(MyDb.title);
		      MyFrame.tfs[2].setText(MyDb.publisher);
		      MyFrame.tfs[3].setText(MyDb.year);
		      MyFrame.tfs[4].setText(Integer.toString(MyDb.price));	

	      break;
		}
		case "삽입": {
			MyDb.InsertBook ();
			break;
		}
		case "수정": {
			MyDb.UpdateBook();
			break;
		}
		case "삭제": {
			// 삭제 여부 재확인
			int result = JOptionPane.showConfirmDialog(null, 
					"정말 삭제하시겠습니까?", "데이터 삭제", JOptionPane.YES_NO_OPTION);
	
			if(result == JOptionPane.CLOSED_OPTION) {
				System.out.println("창을 닫았습니다.");
			} else if(result == JOptionPane.YES_OPTION) {
				MyDb.DeleteBook();
			} else
				System.out.println("취소하였습니다.");

			 break;
		}

	}// end switch
      
   }// public void actionPerformed
   
}// end public class MyActionListener implements ActionListener


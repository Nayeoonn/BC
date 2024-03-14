package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class bController {
   
   @FXML
   TextField tInput;
   
   // A로 이동하기
   public void toA(ActionEvent evnet) throws IOException {
      Main.setRoot("A");
   }
   
   // 전달받은 데이터 텍스트필드에 출력하기
   public void showData(String data) {
      tInput.setText( data );
   }


}
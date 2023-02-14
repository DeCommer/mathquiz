package com.mathquiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML private TextField answerField;
    @FXML private Label questionLabel;
    double answer;

    @FXML
    public void nextQuestion(ActionEvent e) {
        int leftNum = (int)Math.floor(Math.random() * 10 + 1);
        String[] operator = {" + ", " - ", " * ", " ÷ "};
        String randOp = operator[(int)(Math.random() * operator.length)];
        int rightNum = (int)Math.floor(Math.random() * 10 + 1);
        questionLabel.setText("" + leftNum + randOp + rightNum);
    }

    @FXML
    public void submitAns(KeyEvent e){
        try {
            answer = Double.parseDouble(answerField.getText());
            if (e.getCode() == KeyCode.ENTER) {
                if(answer == 43) {
                    questionLabel.setText("CORRECT!"); //change a labels text
                } else{
                    questionLabel.setText("INCORRECT!");
                    
                }
            }
        } catch(NumberFormatException err) { // catch any other key presses
            //System.out.println();
        }catch (Exception err) {
           // System.out.println(err);
        }
    }


    
    
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.xml.namespace.QName;
import java.io.ObjectInputStream;

public class Controller {

    @FXML
    TextField txtCalc;
    int tempNumber1;
    Double tempNumber;
    String tempBtn;
    double inMemory;


    public void number(ActionEvent actionEvent) {
        tempBtn = ((Button) actionEvent.getSource()).getText();
        //System.out.println(tempBtn);
        if (txtCalc.getText().equals("0")) {
            txtCalc.setText(tempBtn);
        } else {
            txtCalc.setText(txtCalc.getText() + tempBtn);
        }
    }


    public void deleteAll(ActionEvent actionEvent) {
        txtCalc.setText("0");
    }
    public void deleteOne(ActionEvent actionEvent) {

        String delOne = (txtCalc.getText().substring(0,txtCalc.getText().length()-1));
        txtCalc.setText(delOne);
    }

    public void forDouble(ActionEvent actionEvent) {
        tempBtn = ".";
        if (txtCalc.getText().contains(".")){
            txtCalc.setText(txtCalc.getText());
        }
        else {
            txtCalc.setText(txtCalc.getText() + tempBtn);
        }
    }

    public void InMemory(ActionEvent actionEvent) {
        inMemory = Double.parseDouble(txtCalc.getText());
        //System.out.println(inMemory);
    }

    public void OutMemory(ActionEvent actionEvent) {
        txtCalc.setText(txtCalc.getText()+inMemory);
    }
    public void calculateSqrt(ActionEvent actionEvent) {
        tempBtn = ((Button) actionEvent.getSource()).getText();
        if (Double.parseDouble(txtCalc.getText())<0){txtCalc.setText("incorrect operation for real numbers");}
        if (txtCalc.getText().contains("+")||txtCalc.getText().contains("-")||txtCalc.getText().contains("*")||
                txtCalc.getText().contains("/")) {
            txtCalc.setText(txtCalc.getText());
        } else {
            double realCalculate = Math.sqrt(Double.parseDouble(txtCalc.getText()));

            txtCalc.setText(realCalculate + "");
        }
    }

    public void calculate(ActionEvent actionEvent) {
        String calculate;
        String numers = "1234567890.";
        double num1=0,num2=0,realCalculate;
        String tempOperation="";
        String count1="",count;
        calculate = (txtCalc.getText());
        //System.out.println(calculate);

        for (int i = 0; i < calculate.length(); i++) {
           count = calculate.substring(i,i+1);
           if (numers.contains(count)){
                count1 += (count);
               //System.out.println(count1);

               num2 = Double.parseDouble(count1);
           }else {tempOperation = count;count1="";num1=num2;}
        }
        switch (tempOperation){
            case "+": {
                realCalculate = num1+num2;
                break;
            }
            case "-": {
                realCalculate = num1-num2;
                break;
            }
            case "*": {
                realCalculate = num1*num2;
                break;
            }
            case "/": {
                realCalculate = num1/num2;
                break;
            }

            default: realCalculate = 999999999;
            break;
        }

        txtCalc.setText(realCalculate!=999999999? realCalculate+"":txtCalc.getText());
    }

    public void operation(ActionEvent actionEvent) {
        tempNumber = Double.parseDouble(txtCalc.getText());
        tempBtn = ((Button) actionEvent.getSource()).getText();

        txtCalc.setText(tempNumber + tempBtn);

    }
}

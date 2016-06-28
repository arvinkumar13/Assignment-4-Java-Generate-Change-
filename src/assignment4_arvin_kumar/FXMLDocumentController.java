/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4_arvin_kumar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author arvinkumar
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button makeChange;
    @FXML
    private TextField inputAmt;
    @FXML
    private FlowPane billsDisplay;
    @FXML
    private FlowPane coinsDisplay;
    @FXML
    private Label errorInChange;
    @FXML
    private Label labelCoins;
    @FXML
    private Label labelBills;
    @FXML
    private Label amountForChange;
    @FXML
    private ImageView bill50;
    @FXML
    private ImageView bill20;
    @FXML
    private ImageView bill10;
    @FXML
    private ImageView bill5;
    @FXML
    private ImageView toonie;
    @FXML
    private ImageView loonie;
    @FXML
    private ImageView quarter;
    @FXML
    private ImageView dime;
    @FXML
    private ImageView nickel;

    /**
     *the method to generate the change for the given amount
     */
    public void generateChange() {
        try {
            //clearing the children of both flowpanes so as to get bills and cons for the new value
            billsDisplay.getChildren().clear();
            coinsDisplay.getChildren().clear();
            errorInChange.setText("");
            //the amount entered
            double amount = Double.parseDouble(inputAmt.getText());

            //rounding off 3 cents or above to 5cents
            int cents = (int) (amount * 100);
            if (cents % 5 >= 3) {
                amount = ((cents / 5 + 1) * 5);
            } else {
                amount = ((cents / 5) * 5);
            }
            //validating for for negative,zero or 100 or greater value
            if (amount >= 10000) {
                amountForChange.setText("the amount for change is more than or equal to $100");
                errorInChange.setText("no change for more than $100");
            } else if (amount == 0) {
                amountForChange.setText("the amount for change is $" + amount / 100);
                errorInChange.setText("no change generated for zero");
            } else if (amount < 0) {
                amountForChange.setText("the amount for change is not valid");
                errorInChange.setText("the input entered was negative");
            } else {
                amountForChange.setText("the amount for change is $" + amount / 100);
                //displaying $50 bills
                while (amount >= 5000) {
                    getbill50();
                    amount = amount - 5000;
                }
                //displaying $20 bills
                while (amount >= 2000) {
                    getbill20();
                    amount = amount - 2000;
                }
                //displaying $10 bills
                while (amount >= 1000) {
                    getbill10();
                    amount = amount - 1000;
                }
                //displaying $5 bills
                while (amount >= 500) {
                    getbill5();
                    amount = amount - 500;
                }
                //displaying toonies
                while (amount >= 200) {
                    gettoonie();
                    amount = amount - 200;
                }
                //displaying loonies
                while (amount >= 100) {
                    getloonie();
                    amount = amount - 100;
                }
                //displaying quarters
                while (amount >= 25) {
                    getquarter();
                    amount = amount - 25;
                }
                //displaying dimes
                while (amount >= 10) {
                    getdime();
                    amount = amount - 10;
                }
                //displaying nickels
                while (amount >= 5) {
                    getnickel();
                    amount = amount - 5;
                }
            }
            //catching an exception for bad inputs and displaying a message for it
        } catch (Exception error) {
            amountForChange.setText("the amount for change is not valid");
            errorInChange.setText("please enter the amount correctly");
        }
    }

    /**
     *a method for displaying $50 bills
     */
        public void getbill50() {
        ImageView m1 = new ImageView(bill50.getImage());
        m1.setFitWidth(131);
        m1.setFitHeight(60);
        billsDisplay.getChildren().add(m1);
    }


    /**
     *a method for displaying $20 bills
     */
        public void getbill20() {
        ImageView m1 = new ImageView(bill20.getImage());
        m1.setFitWidth(131);
        m1.setFitHeight(60);
        billsDisplay.getChildren().add(m1);
    }


    /**
     *a method for displaying $10 bills
     */
        public void getbill10() {
        ImageView m1 = new ImageView(bill10.getImage());
        m1.setFitWidth(131);
        m1.setFitHeight(60);
        billsDisplay.getChildren().add(m1);
    }


    /**
     *a method for displaying $5 bills
     */
        public void getbill5() {
        ImageView m1 = new ImageView(bill5.getImage());
        m1.setFitWidth(131);
        m1.setFitHeight(60);
        billsDisplay.getChildren().add(m1);
    }

    /**
     *a method for displaying toonies
     */
        public void gettoonie() {
        ImageView m1 = new ImageView(toonie.getImage());
        m1.setFitWidth(100);
        m1.setFitHeight(100);
        coinsDisplay.getChildren().add(m1);
    }


    /**
     *a method for displaying loonies
     */
        public void getloonie() {
        ImageView m1 = new ImageView(loonie.getImage());
        m1.setFitWidth(100);
        m1.setFitHeight(100);
        coinsDisplay.getChildren().add(m1);
    }
        
    /**
     *a method for displaying quarters
     */
        public void getquarter() {
        ImageView m1 = new ImageView(quarter.getImage());
        m1.setFitWidth(85);
        m1.setFitHeight(85);
        coinsDisplay.getChildren().add(m1);
    }

    /**
     *a method for displaying nickels
     */
        public void getnickel() {
        ImageView m1 = new ImageView(nickel.getImage());
        m1.setFitWidth(80);
        m1.setFitHeight(80);
        coinsDisplay.getChildren().add(m1);
    }

    /**
     *a method for displaying dimes
     */
        public void getdime() {
        ImageView m1 = new ImageView(dime.getImage());
        m1.setFitWidth(65);
        m1.setFitHeight(65);
        coinsDisplay.getChildren().add(m1);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

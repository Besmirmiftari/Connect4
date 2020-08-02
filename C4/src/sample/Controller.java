package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button n00,n01,n02,n03,n04,n05,n06,
    n10,n11,n12,n13,n14,n15,n16,
    n20,n21,n22,n23,n24,n25,n26,
    n30,n31,n32,n33,n34,n35,n36,
    n40,n41,n42,n43,n44,n45,n46,
    n50,n51,n52,n53,n54,n55,n56;


    int array[][] = new int[6][7];
    int player = 1;

    public void insert(Button button){
    System.out.println(button.getId()+ " its me");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                String in = "n"+i+""+j+" ";

            }
            System.out.println(" ");
        }
    }
}

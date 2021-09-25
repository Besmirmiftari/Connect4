package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//import static jdk.nashorn.internal.objects.Global.Infinity;

public class Main extends Application {
    int array[][] = new int[6][7];
    Button buttons[][] = new Button[6][7];
    int player = 1;
    @Override
    public void start(Stage window) throws Exception{
        GameScreen(window);
    }
    public void GameScreen(Stage window) throws FileNotFoundException {
        AnchorPane pane = new AnchorPane();
        pane.prefHeight(561.0); pane.prefWidth(702.0);pane.setStyle("-fx-background-color: #303030;");
        Button reset = new Button(); reset.setPrefSize(53.0,25.0); reset.setLayoutX(628.0); reset.setLayoutY(150.0); reset.setStyle("-fx-background-color: #019CE9;");
        VBox v = new VBox(); v.setPrefSize(702.0,561.0); v.setLayoutX(40.0);v.setLayoutY(48.0); reset.setText("Reset"); reset.setOnAction(event -> GameReset(window));
        for(int i=0;i<6;i++){
            HBox h = new HBox(); h.setPrefSize(82.0,665.0); h.setSpacing(15.0);
            for(int j=0;j<7;j++){
                buttons[i][j] = new Button();
                Button temp = buttons[i][j];
                buttons[i][j].setOnAction(event -> insert(temp));
                buttons[i][j].setStyle("-fx-background-radius: 50;");
                buttons[i][j].setPrefSize(53.0,51.0);
                buttons[i][j].setId(i+""+j);
                h.getChildren().add(buttons[i][j]);
            }
            v.getChildren().add(h);
        }
        //Image image = new Image(new FileInputStream("C:\\Users\\IT SOLUTION\\IdeaProjects\\C4\\src\\Image\\Connect-4-Header.png"));
        //ImageView imageView = new ImageView(image);imageView.setFitHeight(61.0);imageView.setFitWidth(200.0);imageView.setLayoutX(550.0);imageView.setLayoutY(50.0);

        pane.getChildren().add(v);pane.getChildren().add(reset);//pane.getChildren().add(imageView);
        Scene sc = new Scene(pane);
        window.setScene(sc);
        window.show();
    }
    public void insert(Button b){
        String idd = b.getId();
        char a[] = idd.toCharArray();
       // = Character.getNumericValue(a[0]);
        int j = Character.getNumericValue(a[1]);
        int i  = insertCheckUp(j);


        if(array[i][j]==0){
            if(player==1){
                buttons[i][j].setStyle("-fx-background-radius: 50; -fx-background-color: #C6F701;");
                array[i][j] = 1;
                buttons[i][j].setDisable(true);
                player++;
                if(winer(i,j)){
                    disableRemainder();
                }
            }
            else if(player==2){
                buttons[i][j].setStyle("-fx-background-radius: 50; -fx-background-color: #FB0101;");
                array[i][j] = 2;
                buttons[i][j].setDisable(true);
                player--;
                if(winer(i,j)){
                    disableRemainder();
                }
            }
        }
    }
    public int insertCheckUp(int j){
        for(int ii=5;ii>=0;ii--){
            if(array[ii][j]==0){
                return ii;
            }
        }
        return 0;
    }

    public boolean winer(int i,int j){
        int count = 1;
        int counting = array[i][j];

        //RightCheck
        try{
            for(int jj=j+1,times=3;times!=0;jj++,times--){
                if(array[i][jj]==counting){
                    count++;
                }else if(array[i][jj]!=counting){
                    count = 1;
                    break;
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }
        //LeftCheck
        try{
            for(int jj=j-1,times=3;times!=0;jj--,times--){
                if(array[i][jj]==counting){
                    count++;
                }else if(array[i][jj]!=counting){
                    count = 1;
                    break;
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }
        //DownCheck Upcheck not needed
        try{

            for(int ii=i+1,times=3;times!=0;ii++,times--){
                if(array[ii][j]==counting){
                    count++;
                }else if (array[ii][j]!=counting){
                    count = 1;
                    break;
                }
            }
            if (count==4){
                return true;
            }

        }catch(IndexOutOfBoundsException e){
            count = 1;
        }
        //SideUpRightCheck

        try{
            for(int jj=j+1,ii=i-1,times=3;times!=0;jj++,ii--,times--){
                if(array[ii][jj]==counting){
                    count++;
                }else if(array[ii][jj]!=counting){
                    count = 1;
                    break;
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }

        //SideUpLeftCheck

        try{
            for(int jj=j-1,ii=i-1,times=3;times!=0;jj--,ii--,times--){
                if(array[ii][jj]==counting){
                    count++;
                }else if(array[ii][jj]!=counting){
                    count = 1;
                    break;
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }

        //SideDownRightCheck
        try{
            for(int jj=j+1,ii=i+1,times=3;times!=0;jj++,ii++,times--){
                if(array[ii][jj]==counting){
                    count++;
                }else if(array[ii][jj]!=counting){
                    count = 1;
                    break;
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }

        //SideDownLeftCheck

        try{
            for(int jj=j-1,ii=i+1,times=3;times!=0;jj--,ii++,times--){
                if(array[ii][jj]==counting){
                    count++;
                }else if(array[ii][jj]!=counting){
                    count = 1;
                    break;
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }

        //RightMiddleCheck

        try {
            int tempJ = j - 1;
            if (array[i][tempJ] == counting){
                count++;
                for (int jj = j + 1, ii = i, times = 2; times != 0; jj++,times--) {

                    if (array[ii][jj] == counting) {
                        count++;
                    } else if (array[ii][jj] != counting) {
                        count = 1;
                        break;
                    }
                }
        }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }

        //LeftMiddleCheck

        try {
            int tempI = j + 1;
            if (array[i][tempI] == counting){
                count++;
                for (int jj = j - 1, ii = i, times = 2; times != 0; jj--,times--) {

                    if (array[ii][jj] == counting) {
                        count++;
                    } else if (array[ii][jj] != counting) {
                        count = 1;
                        break;
                    }
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }

        //SideUpRightMiddleCheck

        try {
            int tempJ = j - 1;
            int tempI = i+1;
            if (array[tempI][tempJ] == counting){
                count++;
                for (int jj = j + 1, ii = i-1, times = 2; times != 0; jj++,ii--,times--) {

                    if (array[ii][jj] == counting) {
                        count++;
                    } else if (array[ii][jj] != counting) {
                        count = 1;
                        break;
                    }
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }

        //SideUpLeftMiddleCheck

        try {
            int tempJ = j + 1;
            int tempI = i + 1;
            if (array[tempI][tempJ] == counting){
                count++;
                for (int jj = j - 1, ii = i-1, times = 2; times != 0; jj--,ii--,times--) {

                    if (array[ii][jj] == counting) {
                        count++;
                    } else if (array[ii][jj] != counting) {
                        count = 1;
                        break;
                    }
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }

        //SideDownRightMiddleCheck

        try {
            int tempJ = j - 1;
            int tempI = i - 1;
            if (array[tempI][tempJ] == counting){
                count++;
                for (int jj = j + 1, ii = i+1, times = 2; times != 0; jj++,ii++,times--) {

                    if (array[ii][jj] == counting) {
                        count++;
                    } else if (array[ii][jj] != counting) {
                        count = 1;
                        break;
                    }
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }

        //SideDownLeftMiddleCheck

        try {
            int tempJ = j + 1;
            int tempI = i - 1;
            if (array[tempI][tempJ] == counting){
                count++;
                for (int jj = j - 1, ii = i+1, times = 2; times != 0; jj--,ii++,times--) {

                    if (array[ii][jj] == counting) {
                        count++;
                    } else if (array[ii][jj] != counting) {
                        count = 1;
                        break;
                    }
                }
            }
            if(count==4){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            count = 1;
        }

        return false;
    }

    public void disableRemainder(){
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                if(array[i][j]==0){
                    buttons[i][j].setDisable(true);
                }
            }

        }
    }
    public void GameReset(Stage window){
        try {
            player = 1;
            GameScreen(window);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    if (array[i][j] != 0) {
                        array[i][j] = 0;
                    }
                }

            }
        }catch (Exception e){}
    }
        public static void main(String[] args) {
            launch(args);
        }
}

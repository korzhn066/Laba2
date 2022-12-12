package main.laba2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class MainController {
    @FXML Label Result;

    @FXML private ImageView FormulaImage;

    InputStream firstFormulaPath;
    InputStream secondFormulaPath;

    Image firsImg;
    Image secondImg;

    private boolean firstFormulaRBValue = false;
    private boolean secondFormulaRBValue = false;

    @FXML
    protected void setFirstFormulaRB() {
        firstFormulaRBValue = true;
        secondFormulaRBValue = false;

        FormulaImage.setImage(firsImg);
    }

    @FXML
    protected void setSecondFormulaRB() {
        firstFormulaRBValue = false;
        secondFormulaRBValue = true;

        FormulaImage.setImage(secondImg);
    }

    @FXML private Label Param1;
    @FXML private Label Param2;
    @FXML private Label Param3;

    private boolean RB1 = false;
    private boolean RB2 = false;

    private double mem1 = 0;
    private double mem2 = 0;
    private double mem3 = 0;

    @FXML
    protected void setParamRB1() {
        RB1 = true;
        RB2 = false;
    }

    @FXML
    protected void setParamRB2() {
        RB1 = false;
        RB2 = true;
    }

    @FXML
    protected void setParamRB3() {
        RB1 = false;
        RB2 = false;
    }

    @FXML
    protected void MPus() {
        try {
            if (RB1) {
                mem1 += Double.parseDouble(Result.getText());
                Param1.setText(String.valueOf(mem1));
            }else if (RB2){
                mem2 += Double.parseDouble(Result.getText());
                Param2.setText(String.valueOf(mem2));
            }else {
                mem3 += Double.parseDouble(Result.getText());
                Param3.setText(String.valueOf(mem3));
            }
        }
        catch (NumberFormatException e) {
            Result.setText("Сначала посчитайте");
        }
    }

    @FXML
    protected void MX() {
        if (RB1) {
            mem1 = 0;
            Param1.setText(String.valueOf(mem1));
        }else if (RB2){
            mem2 = 0;
            Param2.setText(String.valueOf(mem2));
        }else {
            mem3 = 0;
            Param3.setText(String.valueOf(mem3));
        }
    }



    private double FirstFunc(double x, double y, double z) {
        return (Math.sin(Math.PI * y * y) + Math.log(y * y)) /
                (Math.sin(Math.PI * z * z) + Math.sin(x) + Math.log(z * z) + x * x + Math.pow(Math.E, Math.cos(z * x)));
    }

    private double SecondFunc(double x, double y, double z) {
        return Math.pow(Math.cos(Math.pow(Math.E, y) + Math.pow(Math.E, y * y)) + Math.sqrt(1/x), 0.25)/
                (Math.cos(Math.PI * z * z * z) + Math.pow(Math.log((1 + z) * (1 + z)) , Math.sin(y)));
    }

    @FXML
    protected void getResult() {
        try {
            double x = Double.parseDouble(XParam.getText());
            double y = Double.parseDouble(YParam.getText());
            double z = Double.parseDouble(ZParam.getText());

            if (!firstFormulaRBValue && !secondFormulaRBValue)
            {
                Result.setText("Выберите уравнение");
            }else {
                if (firstFormulaRBValue) {
                    Result.setText(String.valueOf(FirstFunc(x, y, z)));
                }
                else {
                    Result.setText(String.valueOf(SecondFunc(x, y, z)));
                }
            }
        }
        catch(NumberFormatException e) {
            Result.setText("Вы неправильно задали параметры");
        }
    }

    @FXML
    protected void AboutProgram() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("О программе");
        alert.setHeaderText("6 группа");
        alert.setGraphic(new ImageView(secondImg));
        alert.setContentText("Корж Никита Николаевич");

        alert.showAndWait();
    }

    @FXML private TableView<TableModel> tableView;

    TextField XParam = new TextField("XParam");
    TextField YParam = new TextField("YParam");
    TextField ZParam = new TextField("ZParam");

    private ObservableList<TableModel> tableModels = FXCollections.observableArrayList(
            new TableModel("x=", XParam),
            new TableModel("y=", YParam),
            new TableModel("z=", ZParam)
    );

    @FXML
    private void initialize() {
        tableView.setItems(tableModels);

        firstFormulaPath = getClass().getResourceAsStream("/main/laba2/first.png");
        secondFormulaPath = getClass().getResourceAsStream("/main/laba2/second.png");

        firsImg = new Image(firstFormulaPath);
        secondImg = new Image(secondFormulaPath);
    }


}


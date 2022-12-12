module main.laba2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.laba2 to javafx.fxml;
    exports main.laba2;
}
module com.mathquiz {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mathquiz to javafx.fxml;
    exports com.mathquiz;
}

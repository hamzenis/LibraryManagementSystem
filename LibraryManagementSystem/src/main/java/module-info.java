module com.lms.librarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lms.librarymanagementsystem to javafx.fxml;
    exports com.lms.librarymanagementsystem;
}
module org.app.movie4u {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.app.movie4u to javafx.fxml;
    exports org.app.movie4u;
}

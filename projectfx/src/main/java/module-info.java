module org.fsb.projectfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.fsb.projectfx to javafx.fxml;
    exports org.fsb.projectfx;
}

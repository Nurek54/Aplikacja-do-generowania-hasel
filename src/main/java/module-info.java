module com.example.projektapkadogenerowaniahasel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projektapkadogenerowaniahasel to javafx.fxml;
    exports com.example.projektapkadogenerowaniahasel;
}
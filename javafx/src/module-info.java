/**
 * we can give a description to a module
 *
 * @since 1.1.1
 */
module com.example.javafx {

    requires javafx.controls;

    exports com.example.javafx to javafx.graphics;
}

// exports com.example.javafx ;

// or 

// exports com.example.javafx to javafx.graphics;

// or

// opens com.example.javafx to javafx.graphics;
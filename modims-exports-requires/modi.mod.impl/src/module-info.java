module modi.mod {

    // modi.mod exports the com.mod.impl package
    // exports <package-name-of-the-module>
    exports com.mod.impl;

    // modi.mod requires the modi.api module
    // requires <module-name>
    requires modi.api;
}
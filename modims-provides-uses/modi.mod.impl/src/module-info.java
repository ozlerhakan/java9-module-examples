import com.mod.impl.mod.ModuleQuery;

module modi.mod {

    requires modi.api;

    // modi.mod provides the service Query with its implementation ModuleQuery!
    // to access the com.modi.api.query.Query type, modi.mod (this module) requires the target module.
    // provides <qualified-name> with <qualified-name>
    provides com.modi.api.query.Query with ModuleQuery;
}
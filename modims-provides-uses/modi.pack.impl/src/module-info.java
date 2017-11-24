import com.pack.impl.pack.PackageQuery;

module modi.pack {

    requires modi.api;

    // modi.pack provides the service Query with its implementation PackageQuery!
    // to access the com.modi.api.query.Query type, modi.pack (this module) requires the target module.
    // provides <qualified-name> with <qualified-name>
    provides com.modi.api.query.Query with PackageQuery;
}
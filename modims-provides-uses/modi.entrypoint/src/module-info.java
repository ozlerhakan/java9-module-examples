module modi.entrypoint {

    requires modi.api;

    // to consume the query service in the Java module system, we need to use the uses clause.
    // modi.entrypoint uses ServiceLoader to find the target interface out along with its relevant implementations!
    // we'll access the related service implementations, moduleQuery and packageQuery, at runtime in the main class thanks to serviceloader.
    // The modi.entrypoint module doesn't need to know anything about modules providing the Query implementations.
    // only knowing the Query type is enough for serviceloader to find the implementations of the Query interface at runtime!
    uses com.modi.api.query.Query;
}
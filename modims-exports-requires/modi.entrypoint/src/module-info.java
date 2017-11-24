module modi.entrypoint {

    // the entrypoint doesn't know the query implementations!
    // only it knows the api module and the query provider
    requires modi.provider;
    requires modi.api;
}
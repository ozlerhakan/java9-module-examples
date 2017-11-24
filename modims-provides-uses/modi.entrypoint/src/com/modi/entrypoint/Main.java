package com.modi.entrypoint;


import com.modi.api.query.Query;
import com.modi.api.query.annotation.Search;

import java.util.ServiceLoader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        if (args.length != 2) {
            printUsage();
            System.exit(0);
        }

        final String flag = args[0].toLowerCase();
        final String keyword = args[1];

        // we find the corresponding service at runtime!
        ServiceLoader<Query> loader = ServiceLoader.load(Query.class);

        loader.stream()
                .filter(service -> {
                    Class<? extends Query> queryType = service.type();

                    if (queryType.isAnnotationPresent(Search.class)) {
                        String[] flags = queryType.getAnnotation(Search.class).value();
                        return Stream.of(flags).anyMatch(f -> f.equals(flag));
                    }
                    return false;
                })
                .map(ServiceLoader.Provider::get)
                .findFirst()
                .ifPresentOrElse(query -> {
                            if (query.exists(keyword)) {
                                System.out.println(":)");
                            } else {
                                System.out.println(":(");
                            }
                        },
                        Main::printUsage);
    }

    private static void printUsage() {
        System.out.println("Commands:\n" +
                "-m,--module\ta module name \n" +
                "-p,--package\ta package name");
    }
}

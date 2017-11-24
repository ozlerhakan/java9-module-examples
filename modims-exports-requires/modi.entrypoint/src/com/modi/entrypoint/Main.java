package com.modi.entrypoint;

import com.modi.provider.query.QueryProvider;

public class Main {

    public static void main(String[] args) {

        if (args.length != 2) {
            printUsage();
            System.exit(0);
        }

        final String flag = args[0].toLowerCase();
        final String keyword = args[1];

        QueryProvider.getQuery(flag)
                     .ifPresentOrElse(query -> {
                                 System.out.println(query);
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

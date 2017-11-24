package com.example.modi.entrypoint;

import com.example.modi.query.Modi;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("specify a searchable name (a module or a package name)");
            System.exit(0);
        }

        final String keyword = args[0];
        Modi modi = new Modi();
        boolean exists = modi.exists(keyword);

        System.out.println(exists ? ":)" : ":(");
    }
}

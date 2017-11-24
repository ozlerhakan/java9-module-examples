package com.pack.impl.pack;

import com.modi.api.query.Query;
import com.modi.api.query.annotation.Search;

import static com.pack.impl.utils.Flags.PACKAGE_FLAG;
import static com.pack.impl.utils.Flags.P_FLAG;

/**
 * Created by hakan on 19/11/2017
 */
@Search({PACKAGE_FLAG, P_FLAG})
public final class PackageQuery implements Query {

    //a public non-arg constructor class needed to be a service

    /**
     * find whether the target keyword exists in the module system or not
     *
     * @param keyword a searchable package name
     * @return true if the keyword exists, otherwise false
     */
    @Override
    public boolean exists(String keyword) {
        // this module is an application module
        final Module module = PackageQuery.class.getModule();
        final ModuleLayer moduleLayer = module.getLayer();

        return moduleLayer.modules()
                .parallelStream()
                .anyMatch(layer -> layer.getPackages().stream().anyMatch(pck -> pck.equals(keyword)));
    }
}

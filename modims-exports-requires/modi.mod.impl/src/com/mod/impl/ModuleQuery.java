package com.mod.impl;

import com.modi.api.query.Query;

/**
 * Created by hakan on 12/11/2017
 */
public final class ModuleQuery implements Query {

    //a public non-arg constructor class needed to be a service

    /**
     * find whether the target keyword exists in the module system or not
     *
     * @param keyword a searchable module name
     * @return true if the keyword exists, otherwise false
     */
    public boolean exists(String keyword) {

        // this module is an application module
        final Module module = ModuleQuery.class.getModule();
        final ModuleLayer moduleLayer = module.getLayer();

        return moduleLayer.modules()
                .parallelStream()
                .anyMatch(layer -> keyword.equals(layer.getName()));
    }
}

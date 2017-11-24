package com.mod.impl.mod;

import com.modi.api.query.Query;
import com.modi.api.query.annotation.Search;

import static com.mod.impl.util.Flags.MODULE_FLAG;
import static com.mod.impl.util.Flags.M_FLAG;

/**
 * Created by hakan on 12/11/2017
 */
@Search({MODULE_FLAG, M_FLAG})
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

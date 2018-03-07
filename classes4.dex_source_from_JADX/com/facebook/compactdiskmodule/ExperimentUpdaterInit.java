package com.facebook.compactdiskmodule;

import com.facebook.common.init.INeedInit;
import com.facebook.compactdisk.Experiment;
import com.facebook.compactdisk.ExperimentManager;
import javax.inject.Inject;

/* compiled from: max_message_size */
public class ExperimentUpdaterInit implements INeedInit {
    private final ExperimentManager f8193a;

    @Inject
    public ExperimentUpdaterInit(ExperimentManager experimentManager) {
        this.f8193a = experimentManager;
    }

    public void init() {
        this.f8193a.onExperimentsUpdated(new Experiment[0]);
    }
}

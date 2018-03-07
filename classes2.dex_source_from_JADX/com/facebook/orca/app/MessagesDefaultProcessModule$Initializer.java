package com.facebook.orca.app;

import com.facebook.common.init.INeedInit;
import com.facebook.common.process.ProcessName;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: video_broadcast_seal_type */
public class MessagesDefaultProcessModule$Initializer implements INeedInit {
    private final ProcessName f1245a;

    @Inject
    public MessagesDefaultProcessModule$Initializer(ProcessName processName) {
        this.f1245a = processName;
    }

    public void init() {
        boolean z;
        if (this.f1245a.e() || this.f1245a.a()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Module installed in the wrong process: " + this.f1245a.b);
    }
}

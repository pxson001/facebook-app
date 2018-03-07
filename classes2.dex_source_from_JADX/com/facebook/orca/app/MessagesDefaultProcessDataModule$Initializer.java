package com.facebook.orca.app;

import com.facebook.common.init.INeedInit;
import com.facebook.common.process.ProcessName;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: video_channel_entry_point */
public class MessagesDefaultProcessDataModule$Initializer implements INeedInit {
    private final ProcessName f1244a;

    @Inject
    public MessagesDefaultProcessDataModule$Initializer(ProcessName processName) {
        this.f1244a = processName;
    }

    public void init() {
        boolean z = this.f1244a.e() || this.f1244a.a();
        Preconditions.checkState(z);
    }
}

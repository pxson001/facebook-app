package com.facebook.trace;

import com.facebook.common.init.INeedInit;
import javax.inject.Inject;

/* compiled from: lifecycle */
public class DebugTraceInit implements INeedInit {
    private final DebugTraceXConfigListener f9365a;
    private final DebugTraceUploader f9366b;

    @Inject
    public DebugTraceInit(DebugTraceXConfigListener debugTraceXConfigListener, DebugTraceUploader debugTraceUploader) {
        this.f9365a = debugTraceXConfigListener;
        this.f9366b = debugTraceUploader;
    }

    public void init() {
        this.f9365a.m9761b();
        this.f9366b.m9778a();
    }
}

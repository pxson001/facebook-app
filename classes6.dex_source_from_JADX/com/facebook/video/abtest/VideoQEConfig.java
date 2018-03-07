package com.facebook.video.abtest;

import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: scheme */
public class VideoQEConfig {
    public final boolean f5279a;
    public final boolean f5280b;
    public final boolean f5281c;

    @Inject
    public VideoQEConfig(QeAccessor qeAccessor) {
        this.f5279a = qeAccessor.a(ExperimentsForVideoAbTestModule.dU, false);
        this.f5280b = qeAccessor.a(ExperimentsForVideoAbTestModule.dF, false);
        this.f5281c = qeAccessor.a(ExperimentsForVideoAbTestModule.dM, false);
    }
}

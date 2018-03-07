package com.facebook.composer.capability;

import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: cover photo load state */
public class ComposerSlideshowCapability {
    private QeAccessor f16701a;

    @Inject
    public ComposerSlideshowCapability(QeAccessor qeAccessor) {
        this.f16701a = qeAccessor;
    }

    public final boolean m20733a(boolean z) {
        if (this.f16701a.a(Liveness.Live, ExperimentsForComposerAbTestModule.x, false)) {
            return z;
        }
        return false;
    }
}

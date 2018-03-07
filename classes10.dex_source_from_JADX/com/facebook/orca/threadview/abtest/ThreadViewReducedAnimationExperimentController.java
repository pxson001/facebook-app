package com.facebook.orca.threadview.abtest;

import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: max_friends_sharing_faces */
public class ThreadViewReducedAnimationExperimentController {
    private final QeAccessor f8157a;
    private int f8158b = Integer.MIN_VALUE;

    @Inject
    public ThreadViewReducedAnimationExperimentController(QeAccessor qeAccessor) {
        this.f8157a = qeAccessor;
    }

    public final boolean m8073a() {
        return m8072c() == 0;
    }

    public final boolean m8074b() {
        return m8072c() == 1;
    }

    private int m8072c() {
        if (this.f8158b == Integer.MIN_VALUE) {
            this.f8158b = this.f8157a.a(ExperimentsForThreadViewExperimentsModule.f8154a, 2);
        }
        return this.f8158b;
    }
}

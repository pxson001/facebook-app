package com.facebook.api.ufiservices.qe;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: post_game_score */
public class CommentPrefetchExperimentController {
    public final QeAccessor f9396a;

    @Inject
    public CommentPrefetchExperimentController(QeAccessor qeAccessor) {
        this.f9396a = qeAccessor;
    }

    public static CommentPrefetchExperimentController m14352b(InjectorLike injectorLike) {
        return new CommentPrefetchExperimentController(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final boolean m14353a() {
        return this.f9396a.mo596a(ExperimentsForUfiServiceQeModule.f6626k, false);
    }

    public final boolean m14354c() {
        return this.f9396a.mo596a(ExperimentsForUfiServiceQeModule.f6624i, false);
    }
}

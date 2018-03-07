package com.facebook.feedback.prefetcher;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: post_compose_nux_seen */
public class FeedbackPrefetchingExperiments {
    private final GatekeeperStoreImpl f9397a;

    public static FeedbackPrefetchingExperiments m14356b(InjectorLike injectorLike) {
        return new FeedbackPrefetchingExperiments(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public FeedbackPrefetchingExperiments(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f9397a = gatekeeperStoreImpl;
    }

    public final boolean m14357a() {
        return this.f9397a.m2189a(734, false);
    }

    public final boolean m14358b() {
        return this.f9397a.m2189a(665, false);
    }

    public static FeedbackPrefetchingExperiments m14355a(InjectorLike injectorLike) {
        return m14356b(injectorLike);
    }
}

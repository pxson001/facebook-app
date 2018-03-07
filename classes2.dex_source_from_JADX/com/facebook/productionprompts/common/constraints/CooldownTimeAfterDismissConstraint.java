package com.facebook.productionprompts.common.constraints;

import com.facebook.productionprompts.abtest.ExperimentsForProductionPromptsAbtestModule;
import com.facebook.qe.api.QeAccessor;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

/* compiled from: netego_promote_instagram_footer_text */
public class CooldownTimeAfterDismissConstraint implements PromptFetchConstraint {
    @VisibleForTesting
    static long f12829a = 3000;
    @VisibleForTesting
    static long f12830b = 0;
    @VisibleForTesting
    long f12831c = 0;
    private final QeAccessor f12832d;
    private boolean f12833e = false;
    private long f12834f = 0;

    @Inject
    public CooldownTimeAfterDismissConstraint(QeAccessor qeAccessor) {
        this.f12832d = qeAccessor;
    }

    public final boolean mo2497a() {
        return this.f12833e;
    }

    public final boolean mo2498a(long j) {
        return this.f12831c < j - this.f12834f;
    }

    public final void mo2496a(long j, boolean z) {
        this.f12834f = j;
        long a = this.f12832d.mo575a(ExperimentsForProductionPromptsAbtestModule.f13416e, f12829a);
        if (!z) {
            a = f12830b;
        }
        this.f12831c = a;
        this.f12833e = true;
    }

    public final void mo2499b(long j) {
        this.f12833e = false;
    }
}

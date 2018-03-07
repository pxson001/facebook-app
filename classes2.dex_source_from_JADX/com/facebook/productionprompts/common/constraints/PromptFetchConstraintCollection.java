package com.facebook.productionprompts.common.constraints;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.productionprompts.abtest.ProductionPromptsGatekeepers;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: netego_promote_instagram_friend_count_25 */
public class PromptFetchConstraintCollection implements PromptFetchConstraint {
    private final GatekeeperStoreImpl f12824a;
    private final ImmutableSet<PromptFetchConstraint> f12825b;
    private final PromptsExperimentHelper f12826c;

    public static PromptFetchConstraintCollection m18841a(InjectorLike injectorLike) {
        return new PromptFetchConstraintCollection(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), new TimeoutAfterPostConstraint(FbSharedPreferencesImpl.m1826a(injectorLike)), new CooldownTimeAfterDismissConstraint(QeInternalImplMethodAutoProvider.m3744a(injectorLike)), new MinimumTimeShownConstraint(FbSharedPreferencesImpl.m1826a(injectorLike)), PromptsExperimentHelper.m15312b(injectorLike));
    }

    @Inject
    public PromptFetchConstraintCollection(GatekeeperStoreImpl gatekeeperStoreImpl, TimeoutAfterPostConstraint timeoutAfterPostConstraint, CooldownTimeAfterDismissConstraint cooldownTimeAfterDismissConstraint, MinimumTimeShownConstraint minimumTimeShownConstraint, PromptsExperimentHelper promptsExperimentHelper) {
        this.f12824a = gatekeeperStoreImpl;
        this.f12825b = ImmutableSet.of(timeoutAfterPostConstraint, cooldownTimeAfterDismissConstraint, minimumTimeShownConstraint);
        this.f12826c = promptsExperimentHelper;
    }

    public final boolean mo2497a() {
        return true;
    }

    public final boolean mo2498a(long j) {
        if (!this.f12826c.m15313b()) {
            return true;
        }
        if (this.f12824a.m2189a(ProductionPromptsGatekeepers.f13527a, false)) {
            return true;
        }
        Iterator it = this.f12825b.iterator();
        while (it.hasNext()) {
            PromptFetchConstraint promptFetchConstraint = (PromptFetchConstraint) it.next();
            if (promptFetchConstraint.mo2497a() && !promptFetchConstraint.mo2498a(j)) {
                return false;
            }
        }
        return true;
    }

    public final void mo2496a(long j, boolean z) {
        Iterator it = this.f12825b.iterator();
        while (it.hasNext()) {
            ((PromptFetchConstraint) it.next()).mo2496a(j, z);
        }
    }

    public final void mo2499b(long j) {
        Iterator it = this.f12825b.iterator();
        while (it.hasNext()) {
            ((PromptFetchConstraint) it.next()).mo2499b(j);
        }
    }
}

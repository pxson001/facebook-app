package com.facebook.messaging.badges;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: open_timestamp_difference */
public class BadgesExperimentController {
    public final QeAccessor f8110a;

    public static BadgesExperimentController m8365b(InjectorLike injectorLike) {
        return new BadgesExperimentController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BadgesExperimentController(QeAccessor qeAccessor) {
        this.f8110a = qeAccessor;
    }

    public final boolean m8366a() {
        return this.f8110a.a(ExperimentsForBadgesModule.f8111a, false);
    }

    public static BadgesExperimentController m8364a(InjectorLike injectorLike) {
        return m8365b(injectorLike);
    }
}

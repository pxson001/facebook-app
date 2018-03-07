package com.facebook.notifications.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: deactivated_fan_assoc_deleter */
public class Notifications2gImprovementsExperimentController {
    public final QeAccessor f5204a;

    public static Notifications2gImprovementsExperimentController m10059b(InjectorLike injectorLike) {
        return new Notifications2gImprovementsExperimentController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public Notifications2gImprovementsExperimentController(QeAccessor qeAccessor) {
        this.f5204a = qeAccessor;
    }

    public final boolean m10060b() {
        return this.f5204a.a(ExperimentsForNotificationsAbtestModule.d, false);
    }

    public static Notifications2gImprovementsExperimentController m10058a(InjectorLike injectorLike) {
        return m10059b(injectorLike);
    }
}

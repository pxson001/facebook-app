package com.facebook.selfupdate.remotepushtrigger;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: google_accounts */
public class RemotePushTriggerExperimentController {
    public final QeAccessor f11014a;

    public static RemotePushTriggerExperimentController m11476b(InjectorLike injectorLike) {
        return new RemotePushTriggerExperimentController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RemotePushTriggerExperimentController(QeAccessor qeAccessor) {
        this.f11014a = qeAccessor;
    }

    public final boolean m11477b() {
        return this.f11014a.a(ExperimentsForRemotePushTriggerModule.f11024a, false);
    }
}

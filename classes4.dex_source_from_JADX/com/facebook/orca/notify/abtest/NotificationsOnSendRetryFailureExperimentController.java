package com.facebook.orca.notify.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: send_error_error_url */
public class NotificationsOnSendRetryFailureExperimentController {
    public final QeAccessor f2825a;

    public static NotificationsOnSendRetryFailureExperimentController m3100a(InjectorLike injectorLike) {
        return new NotificationsOnSendRetryFailureExperimentController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NotificationsOnSendRetryFailureExperimentController(QeAccessor qeAccessor) {
        this.f2825a = qeAccessor;
    }
}

package com.facebook.messaging.messagerequests.experiment;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: saved_fav_photos */
public class MessageRequestsExperimentController {
    private final QeAccessor f3223a;

    public static MessageRequestsExperimentController m3149b(InjectorLike injectorLike) {
        return new MessageRequestsExperimentController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessageRequestsExperimentController(QeAccessor qeAccessor) {
        this.f3223a = qeAccessor;
    }
}

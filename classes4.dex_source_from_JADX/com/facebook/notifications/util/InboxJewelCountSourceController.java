package com.facebook.notifications.util;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.forcemessenger.ForceMessenger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: min_trim_time */
public class InboxJewelCountSourceController {
    private final ForceMessenger f7642a;
    private final QeAccessor f7643b;

    public static InboxJewelCountSourceController m8008b(InjectorLike injectorLike) {
        return new InboxJewelCountSourceController(ForceMessenger.m8010a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public InboxJewelCountSourceController(ForceMessenger forceMessenger, QeAccessor qeAccessor) {
        this.f7642a = forceMessenger;
        this.f7643b = qeAccessor;
    }

    public final boolean m8009a() {
        if (!this.f7643b.a(ExperimentsForNotificationsModule.f9705b, false)) {
            return false;
        }
        if (this.f7643b.a(ExperimentsForNotificationsModule.f9704a, false)) {
            return this.f7642a.m8014a();
        }
        if (this.f7642a.m8019f()) {
            return false;
        }
        return true;
    }
}

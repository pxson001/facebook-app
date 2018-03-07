package com.facebook.messaging.sms.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: is_debuggable */
public class SmsGatekeepers {
    public final GatekeeperStoreImpl f10044a;

    public static SmsGatekeepers m10502b(InjectorLike injectorLike) {
        return new SmsGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SmsGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f10044a = gatekeeperStoreImpl;
    }

    public final boolean m10503a() {
        return this.f10044a.a(1125, false);
    }

    public static SmsGatekeepers m10501a(InjectorLike injectorLike) {
        return m10502b(injectorLike);
    }

    public final boolean m10504d() {
        return this.f10044a.a(325, false);
    }

    public final boolean m10505e() {
        return this.f10044a.a(1127, false);
    }

    public final boolean m10506g() {
        return this.f10044a.a(1129, false);
    }
}

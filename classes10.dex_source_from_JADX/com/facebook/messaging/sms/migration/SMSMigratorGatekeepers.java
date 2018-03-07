package com.facebook.messaging.sms.migration;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: pyml_xout */
public class SMSMigratorGatekeepers {
    private final GatekeeperStoreImpl f4201a;

    public static SMSMigratorGatekeepers m3843b(InjectorLike injectorLike) {
        return new SMSMigratorGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SMSMigratorGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f4201a = gatekeeperStoreImpl;
    }

    public final boolean m3844a() {
        return this.f4201a.a(330, false);
    }
}

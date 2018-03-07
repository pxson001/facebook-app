package com.facebook.rtcpresence;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: notify_page_nux_shown */
public class Boolean_ShowCallEveryoneInPeopleTabGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m8043b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(1084, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1084, false));
    }
}

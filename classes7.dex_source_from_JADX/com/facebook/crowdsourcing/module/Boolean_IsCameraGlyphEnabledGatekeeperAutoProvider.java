package com.facebook.crowdsourcing.module;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: com.facebook.notifications.lockscreen.ACTION_LOCKSCREEN_NOTIFICATIONS_VIEW_ATTACHED */
public class Boolean_IsCameraGlyphEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(453, false));
    }
}

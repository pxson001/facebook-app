package com.facebook.ui.browser;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: group_comment_reply */
public class TriState_IsInAppBrowserEnabledMethodAutoProvider extends AbstractProvider<TriState> {
    public static TriState m11408b(InjectorLike injectorLike) {
        return BrowserModule.m11409a(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        return BrowserModule.m11409a(GatekeeperStoreImplMethodAutoProvider.a(this));
    }

    public static TriState m11407a(InjectorLike injectorLike) {
        return m11408b(injectorLike);
    }
}

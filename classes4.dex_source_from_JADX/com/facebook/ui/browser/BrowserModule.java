package com.facebook.ui.browser;

import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.ui.browser.gating.IsInAppBrowserEnabled;

@InjectorModule
/* compiled from: group_comment */
public class BrowserModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsInAppBrowserEnabled
    static TriState m11409a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return gatekeeperStoreImpl.a(121);
    }
}

package com.facebook.presence;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: download_sticker_asset */
public class PresenceModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static PayForPlayPresence m14454a(DefaultPresenceManager defaultPresenceManager) {
        return defaultPresenceManager.m7765d();
    }
}

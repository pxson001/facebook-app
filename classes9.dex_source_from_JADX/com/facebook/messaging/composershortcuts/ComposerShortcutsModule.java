package com.facebook.messaging.composershortcuts;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: messaging_received_delay */
public class ComposerShortcutsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsPlatformAppsInComposerEnabled
    static Boolean m10562a() {
        return Boolean.valueOf(false);
    }
}

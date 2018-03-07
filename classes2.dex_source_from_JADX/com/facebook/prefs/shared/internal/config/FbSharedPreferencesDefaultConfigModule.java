package com.facebook.prefs.shared.internal.config;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: vnd.android.cursor.item/vnd.facebook.katana.bookmark_unread_count */
public class FbSharedPreferencesDefaultConfigModule extends AbstractLibraryModule {
    @ProviderMethod
    @DefaultWriteDelay
    public static Integer m1977a() {
        return Integer.valueOf(500);
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }
}

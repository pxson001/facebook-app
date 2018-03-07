package com.facebook.work.bookmarks.bridge;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: music_preview_play */
public class WorkBookmarksBridgeModule extends AbstractLibraryModule {
    @ProviderMethod
    @IsWorkBookmarksEnabled
    static Boolean m6544a() {
        return Boolean.valueOf(false);
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }
}

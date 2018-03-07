package com.facebook.feed.ufi;

import com.facebook.feed.annotations.IsUFIShareActionEnabled;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: Trying to set invalid selected option for suggest edits field */
public class FeedUfiModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @IsUFIShareActionEnabled
    @ProviderMethod
    static Boolean m24274a() {
        return Boolean.valueOf(true);
    }
}

package com.facebook.feed.rows.photosfeed;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: action_default_message */
public class MultipleRowsPhotosFeedModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @CustomSnowFlakeBackgroundColor
    public static Integer m23229a() {
        return Integer.valueOf(2131363087);
    }
}

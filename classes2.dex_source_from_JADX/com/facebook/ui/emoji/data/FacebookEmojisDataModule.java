package com.facebook.ui.emoji.data;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: include_feedback_to_prefetch */
public class FacebookEmojisDataModule extends AbstractLibraryModule {
    @ProviderMethod
    static FacebookEmojisData m27895a() {
        return new FacebookEmojisData();
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }
}

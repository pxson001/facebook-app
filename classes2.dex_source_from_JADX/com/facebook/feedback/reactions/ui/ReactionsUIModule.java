package com.facebook.feedback.reactions.ui;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: gk_rtmp_exoplayer_on_android */
public class ReactionsUIModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @PillsBlingBarTextSize
    public static Integer m30208a() {
        return Integer.valueOf(2131427400);
    }
}

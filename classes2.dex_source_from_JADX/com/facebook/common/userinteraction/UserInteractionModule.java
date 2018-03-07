package com.facebook.common.userinteraction;

import com.facebook.common.userinteraction.DefaultUserInteractionController.ActivityListener;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: subtitle_preferred_locale */
public class UserInteractionModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static ActivityListener m6469a(DefaultUserInteractionController defaultUserInteractionController) {
        return defaultUserInteractionController.f897e;
    }
}

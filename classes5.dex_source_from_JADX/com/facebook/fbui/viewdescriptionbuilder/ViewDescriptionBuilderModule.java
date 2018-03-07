package com.facebook.fbui.viewdescriptionbuilder;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;

@InjectorModule
/* compiled from: YOGA_PILATES */
public class ViewDescriptionBuilderModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    public static ViewDescriptionBuilder getInstanceForTest_ViewDescriptionBuilder(FbInjector fbInjector) {
        return ViewDescriptionBuilder.b(fbInjector);
    }
}

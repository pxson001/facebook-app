package com.facebook.common.ui.animation;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: place_picker_past_places_shown_in_main_list */
public class CommonUIAnimationModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @IsJewelPopupZeroRatingFeatureEnabled
    @ProviderMethod
    @Singleton
    static Boolean m11077a() {
        return Boolean.TRUE;
    }
}

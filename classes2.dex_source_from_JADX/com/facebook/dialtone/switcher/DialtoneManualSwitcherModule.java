package com.facebook.dialtone.switcher;

import com.facebook.dialtone.common.IsDialtoneManualSwitcherFeatureAvailable;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: promotion_id */
public class DialtoneManualSwitcherModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsDialtoneManualSwitcherFeatureAvailable
    public static Boolean m13622a(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
        return Boolean.valueOf(dialtoneManualSwitcherController.m8421e());
    }
}

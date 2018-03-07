package com.facebook.abtest.qe;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.provider.IProvidePreferences;

/* compiled from: treehouse_android_groups_tab */
public class IProvidePreferences_ForQuickExperimentMethodAutoProvider extends AbstractProvider<IProvidePreferences> {
    public static IProvidePreferences m2290a(InjectorLike injectorLike) {
        return QuickExperimentPrefsModule.m2293a(IdBasedProvider.a(injectorLike, 3870));
    }

    public Object get() {
        return QuickExperimentPrefsModule.m2293a(IdBasedProvider.a(this, 3870));
    }
}

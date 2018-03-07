package com.facebook.search.common.errors.module;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.search.common.errors.ShouldToastGraphSearchErrors;
import com.facebook.search.common.errors.prefs.SearchErrorPrefKeys;

@InjectorModule
/* compiled from: event_viewer_subscribed_source_profiles */
public class SearchErrorsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ShouldToastGraphSearchErrors
    public static Boolean m23482a(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.a(SearchErrorPrefKeys.f15854a, false));
    }
}

package com.facebook.search.common.errors.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: event_watchers.count */
public class Boolean_ShouldToastGraphSearchErrorsMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return SearchErrorsModule.m23482a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

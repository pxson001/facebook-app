package com.facebook.analytics.counter;

import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessName;
import com.facebook.common.process.ProcessUtil;
import com.facebook.common.time.Clock;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: user_key */
public class CounterModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static CountersPrefWriter m2787a(ProcessUtil processUtil, FbSharedPreferences fbSharedPreferences, CountersPrefKeyUtil countersPrefKeyUtil, Clock clock, Provider<Long> provider) {
        ProcessName a = processUtil.m2389a();
        if (a.e()) {
            return null;
        }
        return new CountersPrefWriter(fbSharedPreferences, a.c(), countersPrefKeyUtil, clock, provider);
    }

    @ProviderMethod
    @Singleton
    static CountersPrefReader m2786a(DefaultProcessUtil defaultProcessUtil, FbSharedPreferences fbSharedPreferences, CountersPrefKeyUtil countersPrefKeyUtil) {
        if (defaultProcessUtil.m2389a().e()) {
            return new CountersPrefReader(fbSharedPreferences, countersPrefKeyUtil);
        }
        return null;
    }
}

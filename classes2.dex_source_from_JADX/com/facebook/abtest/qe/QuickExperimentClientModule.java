package com.facebook.abtest.qe;

import com.facebook.abtest.qe.annotations.IsUserTrustedWithQEInternals;
import com.facebook.abtest.qe.annotations.LoggedInUserIdHash;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache.QuickExperimentMemoryCacheInitializer;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Provider;

@InjectorModule
/* compiled from: unused_file/ */
public class QuickExperimentClientModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static QuickExperimentMemoryCacheInitializer m3739a(QuickExperimentMemoryCache quickExperimentMemoryCache) {
        return quickExperimentMemoryCache.mo544e();
    }

    @ProviderMethod
    @IsUserTrustedWithQEInternals
    public static Boolean m3740a(Provider<TriState> provider, Provider<TriState> provider2) {
        boolean z = TriState.YES.equals(provider.get()) || TriState.YES.equals(provider2.get());
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @LoggedInUserIdHash
    @UserScoped
    static String m3741a(String str) {
        return str != null ? SecureHashUtil.a(str) : null;
    }
}

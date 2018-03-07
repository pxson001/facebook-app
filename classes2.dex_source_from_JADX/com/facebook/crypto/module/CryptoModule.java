package com.facebook.crypto.module;

import android.content.Context;
import com.facebook.android.crypto.keychain.SharedPrefsBackedKeyChain;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.keychain.UserStorageKeyChain;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.localstats.LocalStatsLoggerImpl;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: optimistic_scan_count */
public class CryptoModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static LoggedInUserCrypto m16221a(FacebookConceal facebookConceal, LightSharedPreferencesFactory lightSharedPreferencesFactory, AbstractFbErrorReporter abstractFbErrorReporter, LocalStatsLoggerImpl localStatsLoggerImpl) {
        Object userStorageKeyChain = new UserStorageKeyChain(lightSharedPreferencesFactory, facebookConceal, abstractFbErrorReporter);
        return new LoggedInUserCrypto(facebookConceal.m16215c(userStorageKeyChain), userStorageKeyChain, abstractFbErrorReporter, localStatsLoggerImpl);
    }

    @ProviderMethod
    @Singleton
    @SharedPrefsKey
    static Crypto m16219a(Context context, FacebookConceal facebookConceal) {
        return facebookConceal.m16214b(new SharedPrefsBackedKeyChain(context, CryptoConfig.KEY_128));
    }

    @ProviderMethod
    @Singleton
    @FixedKey
    static Crypto m16220a(FacebookConceal facebookConceal) {
        return facebookConceal.m16214b(new FixedKeyChain(CryptoConfig.KEY_128));
    }

    @ProviderMethod
    @Singleton
    @FixedKey256
    static Crypto m16222b(FacebookConceal facebookConceal) {
        return facebookConceal.m16215c(new FixedKeyChain(CryptoConfig.KEY_256));
    }
}

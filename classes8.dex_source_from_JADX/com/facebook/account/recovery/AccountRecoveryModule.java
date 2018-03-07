package com.facebook.account.recovery;

import com.facebook.account.recovery.annotations.IsBounceFromMSiteEnabled;
import com.facebook.account.recovery.annotations.IsCaptchaEnabled;
import com.facebook.account.recovery.annotations.IsEmailListedBeforeSmsEnabled;
import com.facebook.account.recovery.annotations.IsGkUnsetBounceFromMSiteEnabled;
import com.facebook.account.recovery.annotations.IsParallelSearchEnabled;
import com.facebook.androidinternals.android.os.SystemPropertiesInternal;
import com.facebook.common.random.SecureRandom_FixedSecureRandomMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.experiment.InitialAppLaunchExperiment;
import com.facebook.growth.experiment.InitialAppLaunchExperimentConstants.ExperimentSpecification;
import com.facebook.growth.experiment.InitialAppLaunchExperimentProvider;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.util.Date;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: location_disabled_niem */
public class AccountRecoveryModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @IsBounceFromMSiteEnabled
    @ProviderMethod
    @Singleton
    static TriState m11991a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return gatekeeperStoreImpl.a(8);
    }

    @ProviderMethod
    @Singleton
    @IsCaptchaEnabled
    static TriState m11993b(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return gatekeeperStoreImpl.a(1);
    }

    @ProviderMethod
    @Singleton
    @IsParallelSearchEnabled
    static TriState m11994c(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return gatekeeperStoreImpl.a(0);
    }

    @ProviderMethod
    @Singleton
    @IsEmailListedBeforeSmsEnabled
    static TriState m11995d(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return gatekeeperStoreImpl.a(9);
    }

    @ProviderMethod
    @Singleton
    @IsGkUnsetBounceFromMSiteEnabled
    static TriState m11992a(InitialAppLaunchExperimentProvider initialAppLaunchExperimentProvider) {
        TriState triState;
        InitialAppLaunchExperiment initialAppLaunchExperiment = new InitialAppLaunchExperiment((Clock) SystemClockMethodAutoProvider.a(initialAppLaunchExperimentProvider), (FbSharedPreferences) FbSharedPreferencesImpl.a(initialAppLaunchExperimentProvider), SecureRandom_FixedSecureRandomMethodAutoProvider.b(initialAppLaunchExperimentProvider), ExperimentSpecification.AR_BOUNCE_FROM_MSITE);
        Integer integer = Integer.getInteger(initialAppLaunchExperiment.e);
        if (integer != null) {
            if (integer.intValue() == 1) {
                triState = TriState.YES;
            } else if (integer.intValue() == 0) {
                triState = TriState.NO;
            } else if (integer.intValue() == 2) {
                triState = TriState.UNSET;
            }
            return triState;
        }
        long a = SystemPropertiesInternal.a(initialAppLaunchExperiment.e, -1);
        if (a == 1) {
            triState = TriState.YES;
        } else if (a == 0) {
            triState = TriState.NO;
        } else if (a == 2) {
            triState = TriState.UNSET;
        } else if (initialAppLaunchExperiment.g == 0) {
            triState = TriState.UNSET;
        } else if (initialAppLaunchExperiment.b.a()) {
            int a2 = initialAppLaunchExperiment.b.a(initialAppLaunchExperiment.f, -1);
            if (a2 < 0 || a2 >= 10000) {
                int nextInt = initialAppLaunchExperiment.c.nextInt(10000);
                initialAppLaunchExperiment.b.edit().a(initialAppLaunchExperiment.f, nextInt).commit();
                a2 = nextInt;
            }
            if (a2 >= 0 && a2 < 10000) {
                Object obj;
                Date date = new Date(initialAppLaunchExperiment.a.a());
                if (date.before(initialAppLaunchExperiment.h) || date.after(initialAppLaunchExperiment.i)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null && (initialAppLaunchExperiment.j == null || initialAppLaunchExperiment.j.m17342a())) {
                    if (a2 < initialAppLaunchExperiment.g) {
                        triState = TriState.YES;
                    } else if (a2 < initialAppLaunchExperiment.g * 2) {
                        triState = TriState.NO;
                    } else {
                        triState = TriState.UNSET;
                    }
                }
            }
            triState = TriState.UNSET;
        } else {
            triState = TriState.UNSET;
        }
        return triState;
    }
}

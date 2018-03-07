package com.facebook.aldrin.status;

import com.facebook.aldrin.status.annotations.IsAldrinEnabled;
import com.facebook.aldrin.status.annotations.IsAldrinUser;
import com.facebook.aldrin.status.annotations.ShouldBeAldrinUser;
import com.facebook.aldrin.status.gk.AldrinFeatureKillSwitch;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: quick_share_friends */
public class AldrinStatusModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsAldrinEnabled
    public static Boolean m12843a(AldrinFeatureKillSwitch aldrinFeatureKillSwitch) {
        boolean a;
        if (aldrinFeatureKillSwitch.f8321a.get() == null) {
            a = aldrinFeatureKillSwitch.f8323c.m2189a(29, false);
        } else {
            a = aldrinFeatureKillSwitch.f8322b.m2189a(882, false);
        }
        return Boolean.valueOf(a);
    }

    @ProviderMethod
    @ShouldBeAldrinUser
    static Boolean m12842a(AldrinUserStatusManager aldrinUserStatusManager) {
        AldrinUserStatus d = aldrinUserStatusManager.d();
        boolean z = d != null && d.shouldBeCu;
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsAldrinUser
    static Boolean m12844b(AldrinUserStatusManager aldrinUserStatusManager) {
        AldrinUserStatus d = aldrinUserStatusManager.d();
        boolean z = d != null && d.isCu;
        return Boolean.valueOf(z);
    }
}

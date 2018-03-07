package com.facebook.work.groups.multicompany.gk;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: music_preview_open_native */
public class Boolean_IsWorkMultiCompanyGroupsEnabledGkMethodAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m6545b(InjectorLike injectorLike) {
        return WorkMultiCompanyGroupModule.m6546a(Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        return WorkMultiCompanyGroupModule.m6546a(Boolean_IsWorkBuildMethodAutoProvider.a(this), GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}

package com.facebook.work.groups.multicompany.gk;

import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: music_preview_media_player_error */
public class WorkMultiCompanyGroupModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsWorkMultiCompanyGroupsEnabledGk
    static Boolean m6546a(Boolean bool, GatekeeperStoreImpl gatekeeperStoreImpl) {
        boolean z = false;
        if (bool.booleanValue() && gatekeeperStoreImpl.a(994, false)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}

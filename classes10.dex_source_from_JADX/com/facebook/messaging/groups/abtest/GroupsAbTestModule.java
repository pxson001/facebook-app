package com.facebook.messaging.groups.abtest;

import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsCreateGroupEventsEnabled;
import com.facebook.messaging.annotations.IsSinglePickerEnabled;
import com.facebook.messaging.annotations.ShouldShowManageGroupUpsellExperiment;
import com.facebook.messaging.groups.annotations.IsInviteToMessengerInGroupsEnabled;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Provider;

@InjectorModule
/* compiled from: sideloading_show_android_installer */
public class GroupsAbTestModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsSinglePickerEnabled
    public static Boolean m2333a(GatekeeperStoreImpl gatekeeperStoreImpl, QeAccessor qeAccessor) {
        boolean z = false;
        short s = ExperimentsForGroupsAbTestModule.f2423f;
        if (gatekeeperStoreImpl.a(318) == TriState.YES || qeAccessor.a(s, false)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @ShouldShowManageGroupUpsellExperiment
    public static Boolean m2335a(QeAccessor qeAccessor, Provider<Boolean> provider) {
        boolean z = qeAccessor.a(ExperimentsForGroupsAbTestModule.f2419b, false) || ((Boolean) provider.get()).booleanValue();
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsCreateGroupEventsEnabled
    static Boolean m2334a(QeAccessor qeAccessor) {
        return Boolean.valueOf(qeAccessor.a(ExperimentsForGroupsAbTestModule.f2420c, false));
    }

    @ProviderMethod
    @IsInviteToMessengerInGroupsEnabled
    public static Boolean m2332a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return Boolean.valueOf(gatekeeperStoreImpl.a(234, false));
    }
}

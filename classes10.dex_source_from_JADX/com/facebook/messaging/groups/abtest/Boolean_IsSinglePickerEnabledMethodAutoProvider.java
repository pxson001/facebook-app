package com.facebook.messaging.groups.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: sideshow_load_fail */
public class Boolean_IsSinglePickerEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return GroupsAbTestModule.m2333a(GatekeeperStoreImplMethodAutoProvider.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}

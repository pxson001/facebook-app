package com.facebook.messaging.groups.abtest;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: sideshow_item_click */
public class Boolean_ShouldShowManageGroupUpsellExperimentMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return GroupsAbTestModule.m2335a((QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedProvider.a(this, 4086));
    }
}

package com.facebook.messaging.groups.abtest;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: sideshow_name */
public class Boolean_IsCreateGroupEventsEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m2331b(InjectorLike injectorLike) {
        return GroupsAbTestModule.m2334a((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        return GroupsAbTestModule.m2334a((QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}

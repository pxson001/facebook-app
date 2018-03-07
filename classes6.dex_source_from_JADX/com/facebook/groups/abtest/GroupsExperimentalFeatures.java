package com.facebook.groups.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: mPhoneticName */
public class GroupsExperimentalFeatures {
    private final GatekeeperStoreImpl f10991a;

    public static GroupsExperimentalFeatures m17638b(InjectorLike injectorLike) {
        return new GroupsExperimentalFeatures(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GroupsExperimentalFeatures(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f10991a = gatekeeperStoreImpl;
    }

    public final boolean m17639a() {
        return this.f10991a.a(675, false);
    }

    public static GroupsExperimentalFeatures m17637a(InjectorLike injectorLike) {
        return m17638b(injectorLike);
    }
}

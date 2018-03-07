package com.facebook.messaging.photoreminders;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: mRequestsCounts */
public class PhotoRemindersGatekeepers {
    public final GatekeeperStoreImpl f8584a;

    public static PhotoRemindersGatekeepers m8831b(InjectorLike injectorLike) {
        return new PhotoRemindersGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PhotoRemindersGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f8584a = gatekeeperStoreImpl;
    }

    public final boolean m8832a() {
        return this.f8584a.a(277, false);
    }

    public final boolean m8833b() {
        return this.f8584a.a(280, false);
    }

    public final boolean m8834c() {
        return this.f8584a.a(278, false);
    }

    public static PhotoRemindersGatekeepers m8830a(InjectorLike injectorLike) {
        return m8831b(injectorLike);
    }
}

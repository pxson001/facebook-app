package com.facebook.messaging.quickcam;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: descriptor.proto has a new declared type but Desrciptors.java wasn't updated. */
public class Boolean_IsPhotosAutoSaveAvailableGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(965, false));
    }
}

package com.facebook.messaging.media.download;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: mIntroReason */
public class Boolean_IsPhotosAutoDownloadAvailableGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m12168b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(1030, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1030, false));
    }
}

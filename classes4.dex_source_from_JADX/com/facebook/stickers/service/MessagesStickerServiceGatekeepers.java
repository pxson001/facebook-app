package com.facebook.stickers.service;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: extra_background_confirmed_contactpoint */
public class MessagesStickerServiceGatekeepers {
    private final GatekeeperStoreImpl f12532a;

    public static MessagesStickerServiceGatekeepers m13278b(InjectorLike injectorLike) {
        return new MessagesStickerServiceGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessagesStickerServiceGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12532a = gatekeeperStoreImpl;
    }

    public final boolean m13279a() {
        return this.f12532a.a(452, false);
    }
}

package com.facebook.messaging.composershortcuts;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: messenger-quick-cam-%d */
public class ComposerShortcutsGatekeepers {
    private final GatekeeperStoreImpl f10052a;

    public static ComposerShortcutsGatekeepers m10556a(InjectorLike injectorLike) {
        return new ComposerShortcutsGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ComposerShortcutsGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f10052a = gatekeeperStoreImpl;
    }

    public final boolean m10557a() {
        return this.f10052a.a(211, false);
    }
}

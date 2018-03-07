package com.facebook.gk.store;

import java.io.File;
import javax.annotation.Nullable;

/* compiled from: videochannel?id=%s */
public class GatekeeperStoreUserManager {
    private final GatekeeperStoreConfig f1076a;
    public final File f1077b;

    public GatekeeperStoreUserManager(GatekeeperStoreConfig gatekeeperStoreConfig, File file) {
        this.f1076a = gatekeeperStoreConfig;
        this.f1077b = file;
    }

    public final GatekeeperCache m2174a(String str) {
        GatekeeperCache gatekeeperCache = new GatekeeperCache(this.f1076a.mo327a());
        GatekeeperRepository b = m2173b(str);
        if (b != null) {
            b.m2158a(gatekeeperCache);
        }
        return gatekeeperCache;
    }

    public final void m2175a(String str, GatekeeperCache gatekeeperCache) {
        GatekeeperRepository b = m2173b(str);
        if (b != null) {
            b.m2159b(gatekeeperCache);
        }
    }

    @Nullable
    private GatekeeperRepository m2173b(String str) {
        File file = new File(new File(this.f1077b, "users"), str);
        if (file.exists() || file.mkdirs()) {
            return new GatekeeperRepository(this.f1076a, file);
        }
        return null;
    }
}

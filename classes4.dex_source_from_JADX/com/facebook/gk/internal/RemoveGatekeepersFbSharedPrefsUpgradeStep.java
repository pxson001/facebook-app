package com.facebook.gk.internal;

import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.GatekeeperWriter;
import com.facebook.gk.store.GatekeeperWriter$Editor;
import com.facebook.prefs.shared.FbSharedPreferencesDbStorage;
import com.facebook.prefs.shared.PrefKey;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: {src_pkg= */
public class RemoveGatekeepersFbSharedPrefsUpgradeStep {
    private final GatekeeperWriter f39a;
    private final GatekeeperStoreImpl f40b;
    private final PrefKey f41c;
    public final int f42d;

    public RemoveGatekeepersFbSharedPrefsUpgradeStep(GatekeeperWriter gatekeeperWriter, GatekeeperStoreImpl gatekeeperStoreImpl, PrefKey prefKey, int i) {
        this.f39a = gatekeeperWriter;
        this.f40b = gatekeeperStoreImpl;
        this.f41c = prefKey;
        this.f42d = i;
    }

    public final void m35a(Map<PrefKey, Object> map, FbSharedPreferencesDbStorage fbSharedPreferencesDbStorage) {
        Object<PrefKey> hashSet = new HashSet();
        GatekeeperWriter$Editor e = this.f39a.e();
        for (Entry entry : map.entrySet()) {
            PrefKey prefKey = (PrefKey) entry.getKey();
            if (prefKey.a(this.f41c)) {
                if (entry.getValue() instanceof Boolean) {
                    String b = prefKey.b(this.f41c);
                    if (this.f40b.b(b)) {
                        e.mo2a(b, TriState.valueOf((Boolean) entry.getValue()));
                    }
                }
                hashSet.add(prefKey);
            }
        }
        e.mo5a();
        for (PrefKey remove : hashSet) {
            map.remove(remove);
        }
        fbSharedPreferencesDbStorage.a(Collections.emptyMap(), hashSet);
        Integer.valueOf(hashSet.size());
    }
}

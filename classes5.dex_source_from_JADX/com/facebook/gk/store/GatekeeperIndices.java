package com.facebook.gk.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: remoteInputs */
public class GatekeeperIndices {
    private final Map<String, Integer> f3173a;

    public GatekeeperIndices(GatekeeperStoreConfig gatekeeperStoreConfig) {
        ArrayList b = gatekeeperStoreConfig.b();
        int size = b.size();
        Map hashMap = new HashMap(size);
        for (int i = 0; i < size; i++) {
            hashMap.put(b.get(i), Integer.valueOf(i));
        }
        this.f3173a = hashMap;
    }

    public final Integer m4302a(String str) {
        return (Integer) this.f3173a.get(str);
    }
}

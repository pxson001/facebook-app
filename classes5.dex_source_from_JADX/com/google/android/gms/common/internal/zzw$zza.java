package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzw$zza {
    private final List<String> f6590a = new ArrayList();
    private final Object f6591b;

    public zzw$zza(Object obj) {
        this.f6591b = zzx.a(obj);
    }

    public final zzw$zza m12402a(String str, Object obj) {
        this.f6590a.add(((String) zzx.a(str)) + "=" + String.valueOf(obj));
        return this;
    }

    public final String toString() {
        StringBuilder append = new StringBuilder(100).append(this.f6591b.getClass().getSimpleName()).append('{');
        int size = this.f6590a.size();
        for (int i = 0; i < size; i++) {
            append.append((String) this.f6590a.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}

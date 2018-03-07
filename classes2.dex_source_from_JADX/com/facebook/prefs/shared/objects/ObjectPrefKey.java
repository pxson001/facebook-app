package com.facebook.prefs.shared.objects;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* compiled from: maxSize <= 0 */
public class ObjectPrefKey<V> {
    public final PrefKey f14963a;
    private final Class<V> f14964b;

    public static <T> ObjectPrefKey<T> m21401a(PrefKey prefKey, String str, Class<T> cls) {
        return new ObjectPrefKey((PrefKey) prefKey.m2011a(str), cls);
    }

    private ObjectPrefKey(PrefKey prefKey, Class<V> cls) {
        this.f14963a = (PrefKey) Preconditions.checkNotNull(prefKey);
        this.f14964b = (Class) Preconditions.checkNotNull(cls);
    }

    public final PrefKey m21402a() {
        return this.f14963a;
    }

    public final Class<V> m21403b() {
        return this.f14964b;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ObjectPrefKey) && ((ObjectPrefKey) obj).f14963a.equals(this.f14963a) && ((ObjectPrefKey) obj).f14964b.equals(this.f14964b);
    }

    public int hashCode() {
        return Objects.hashCode(this.f14963a, this.f14964b);
    }

    public String toString() {
        return StringFormatUtil.formatStrLocaleSafe("ObjectPrefKey: %s, type: %s", this.f14963a.m2012a(), this.f14964b);
    }
}

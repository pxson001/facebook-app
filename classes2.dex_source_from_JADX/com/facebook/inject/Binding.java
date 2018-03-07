package com.facebook.inject;

import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

/* compiled from: x-cache */
public class Binding<T> {
    public String f670a;
    public Key<T> f671b;
    public Provider<? extends T> f672c;
    public Class<? extends Annotation> f673d;
    public Provider<? extends T> f674e;
    public byte f675f;

    public final String m1383a() {
        return this.f670a;
    }

    public final Key<T> m1387b() {
        return this.f671b;
    }

    public final void m1384a(Key<T> key) {
        this.f671b = key;
    }

    public final Provider<? extends T> m1389c() {
        return this.f672c;
    }

    public final void m1385a(Provider<? extends T> provider) {
        this.f672c = provider;
    }

    public final Class<? extends Annotation> m1390d() {
        return this.f673d;
    }

    public final boolean m1391e() {
        return (this.f675f & 1) == 1;
    }

    public final void m1386a(boolean z) {
        if (z) {
            this.f675f = (byte) (this.f675f | 1);
        } else {
            this.f675f = (byte) (this.f675f & (1 ^ -1));
        }
    }

    public final void m1388b(Provider<? extends T> provider) {
        this.f674e = provider;
    }

    public String toString() {
        return String.format("%s{declaringModuleName = %s, key = $s, provider = %s, scope = %s, default = %s}", new Object[]{getClass().getSimpleName(), this.f670a, this.f671b, this.f672c, this.f673d, Boolean.valueOf(m1391e())});
    }
}

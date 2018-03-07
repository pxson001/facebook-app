package com.facebook.inject;

import com.google.inject.Key;

/* compiled from: destination_address */
public class ComponentBinding<T> {
    public String f5101a;
    public Key<T> f5102b;
    private ComponentProvider<T> f5103c;

    public final Key<T> m10000a() {
        return this.f5102b;
    }

    public String toString() {
        return String.format("%s{declaringModuleName = %s, key = $s, provider = %s}", new Object[]{getClass().getSimpleName(), this.f5101a, this.f5102b, this.f5103c});
    }
}

package com.facebook.zero.config;

import com.facebook.inject.InjectorLike;

/* compiled from: ् */
public class DefaultZeroConfiguration implements ZeroConfiguration {
    public static DefaultZeroConfiguration m88a(InjectorLike injectorLike) {
        return new DefaultZeroConfiguration();
    }

    public final String m89a() {
        throw new IllegalStateException("Megaphone location not supported by the default zero rating configuration");
    }
}

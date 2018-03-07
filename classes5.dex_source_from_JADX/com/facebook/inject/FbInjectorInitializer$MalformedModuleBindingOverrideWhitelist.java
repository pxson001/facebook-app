package com.facebook.inject;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

/* compiled from: dependencies */
final class FbInjectorInitializer$MalformedModuleBindingOverrideWhitelist {
    public static final Multimap<String, String> f5130a;

    static {
        Builder c = ImmutableMultimap.c();
        c.b("com.facebook.testing.instrumentation.sampleapp.BaseTestModule", "Key[type=com.facebook.common.errorreporting.FbErrorReporter, annotation=[none]]");
        f5130a = c.b();
    }
}

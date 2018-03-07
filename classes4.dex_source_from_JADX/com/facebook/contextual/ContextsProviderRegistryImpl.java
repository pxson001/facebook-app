package com.facebook.contextual;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: startService= */
public class ContextsProviderRegistryImpl {
    private Map<String, ContextHandler> f1912a = new HashMap();

    public ContextsProviderRegistryImpl(Set<? extends ContextsProvider> set) {
        for (ContextsProvider a : set) {
            for (ContextHandler contextHandler : a.mo134a()) {
                contextHandler.toString();
                m1965a(contextHandler.f1922a, contextHandler);
            }
        }
    }

    private void m1965a(String str, ContextHandler contextHandler) {
        if (this.f1912a.put(str, contextHandler) != null) {
            throw new IllegalStateException("ContextsProvider already registered for: " + str);
        }
    }

    public final ContextHandler m1966a(String str) {
        ContextHandler contextHandler = (ContextHandler) this.f1912a.get(str.toLowerCase(Locale.US));
        if (contextHandler != null) {
            return contextHandler;
        }
        throw new ContextualConfigError("Unknown context");
    }
}

package com.facebook.contextual;

import com.facebook.contextual.models.ContextualConfigIdentifier;
import com.facebook.contextual.models.ContextualConfigIdentifier__JsonHelper;
import com.facebook.contextual.models.MultiOutputResolved__JsonHelper;
import com.facebook.contextual.models.MultiOutputSingleContextTable__JsonHelper;
import com.facebook.contextual.models.Resolved__JsonHelper;
import com.facebook.contextual.models.SingleContextTable__JsonHelper;
import java.io.IOException;

/* compiled from: sponsored_feed_unit_cache_size */
public class ContextualConfigFactoryImpl {
    private BucketMatcherFactoryImpl f1937a;
    private ContextsProviderRegistryImpl f1938b;
    private ContextualConfigLogger f1939c;

    public ContextualConfigFactoryImpl(BucketMatcherFactoryImpl bucketMatcherFactoryImpl, ContextsProviderRegistryImpl contextsProviderRegistryImpl, ContextualConfigLogger contextualConfigLogger) {
        this.f1937a = bucketMatcherFactoryImpl;
        this.f1938b = contextsProviderRegistryImpl;
        this.f1939c = contextualConfigLogger;
    }

    public final ContextualConfig m2006a(RawConfig rawConfig) {
        try {
            return m2005a(ContextualConfigIdentifier__JsonHelper.a(rawConfig.b()), rawConfig);
        } catch (IOException e) {
            throw new ContextualConfigError("Can't read config");
        }
    }

    private ContextualConfig m2005a(ContextualConfigIdentifier contextualConfigIdentifier, RawConfig rawConfig) {
        if (contextualConfigIdentifier == null || contextualConfigIdentifier.a == null || contextualConfigIdentifier.b == null) {
            throw new ContextualConfigError("Can't identify config");
        }
        try {
            if (contextualConfigIdentifier.a.equals("single-context-buckets-table")) {
                return new SingleContextTableContextualConfig(rawConfig, SingleContextTable__JsonHelper.a(rawConfig.b()), this.f1937a, this.f1938b, this.f1939c);
            } else if (contextualConfigIdentifier.a.equals("multi-output-single-context-table")) {
                return new MultiOutputSingleContextContextualConfig(rawConfig, MultiOutputSingleContextTable__JsonHelper.a(rawConfig.b()), this.f1937a, this.f1938b, this.f1939c);
            } else if (contextualConfigIdentifier.a.equals("resolved")) {
                return new ResolvedContextualConfig(rawConfig, Resolved__JsonHelper.a(rawConfig.b()), this.f1939c);
            } else {
                if (contextualConfigIdentifier.a.equals("multi-output-resolved")) {
                    return new MultiOutputResolvedContextualConfig(rawConfig, MultiOutputResolved__JsonHelper.a(rawConfig.b()), this.f1939c);
                }
                throw new ContextualConfigError("Unknown config type");
            }
        } catch (IOException e) {
            throw new ContextualConfigError("Can't read config");
        }
    }
}

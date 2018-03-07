package com.facebook.contextual;

import com.facebook.contextual.ContextValue.Type;
import com.facebook.contextual.models.Bucket;
import com.facebook.contextual.models.SingleContextModelBase;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: outputRotationDegreesClockwise */
public abstract class SingleContextContextualConfigBase implements ContextualConfig {
    SingleContextModelBase f8522b;
    ContextHandler f8523c;
    BucketsMatcher f8524d;
    RawConfig f8525e;
    Map<String, ContextValue[]> f8526f;
    ContextValue[] f8527g;
    ContextualConfigLogger f8528h;

    public SingleContextContextualConfigBase(RawConfig rawConfig, SingleContextModelBase singleContextModelBase, int i, BucketMatcherFactoryImpl bucketMatcherFactoryImpl, ContextsProviderRegistryImpl contextsProviderRegistryImpl, ContextualConfigLogger contextualConfigLogger) {
        if (singleContextModelBase == null) {
            throw new ContextualConfigError("Bad config");
        } else if (singleContextModelBase.e.intValue() != i) {
            throw new ContextualConfigError("Unsupported config version");
        } else if (singleContextModelBase.f == null) {
            throw new ContextualConfigError("Missing context in config");
        } else {
            Type a = ContextValue.a(singleContextModelBase.f.c);
            if (singleContextModelBase.f.a == null || a == null) {
                throw new ContextualConfigError("Bad context identifier");
            }
            this.f8524d = new BucketsMatcher();
            if (!singleContextModelBase.f.d) {
                if (singleContextModelBase.g == null) {
                    throw new ContextualConfigError("Missing buckets definition");
                }
                for (Bucket bucket : singleContextModelBase.g) {
                    this.f8524d.a.add(bucketMatcherFactoryImpl.a(bucket.a.toLowerCase(Locale.US), bucket.b, bucket.c));
                }
            }
            if (singleContextModelBase.f.e) {
                this.f8523c = new ContextHandler(singleContextModelBase.f.a, null, 0);
            } else {
                this.f8523c = contextsProviderRegistryImpl.a(singleContextModelBase.f.a);
            }
            this.f8522b = singleContextModelBase;
            this.f8525e = rawConfig;
            this.f8528h = contextualConfigLogger;
        }
    }

    public final RawConfig m12340a() {
        return this.f8525e;
    }

    public final ContextualConfigEvaluationResult m12339a(@Nullable LocalContextsProvider localContextsProvider) {
        String c;
        ContextValue[] contextValueArr;
        ContextValue a = this.f8523c.a(this.f8522b.f.b, localContextsProvider);
        if (a != null) {
            if (this.f8522b.f.d) {
                c = a.c();
            } else {
                c = this.f8524d.a(a.b());
            }
            contextValueArr = c != null ? (ContextValue[]) this.f8526f.get(c) : null;
        } else {
            c = null;
            contextValueArr = null;
        }
        if (contextValueArr == null) {
            contextValueArr = this.f8527g;
        }
        return new ContextualConfigEvaluationResult(this, this.f8523c, a, c, contextValueArr, this.f8528h, this.f8525e);
    }
}

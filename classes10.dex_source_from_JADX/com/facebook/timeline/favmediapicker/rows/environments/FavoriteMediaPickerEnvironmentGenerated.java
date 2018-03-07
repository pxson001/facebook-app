package com.facebook.timeline.favmediapicker.rows.environments;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.environment.impl.HasContextImpl;
import com.facebook.feed.environment.impl.HasContextImplProvider;
import com.facebook.feed.environment.impl.HasPersistentStateImpl;
import com.facebook.feed.environment.impl.HasPrefetcherNoOpImpl;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: friends_nearby_settings_upsell_click */
public class FavoriteMediaPickerEnvironmentGenerated implements HasContext, HasPersistentState, HasPrefetcher, HasRowKey {
    private final HasPrefetcherNoOpImpl f11039a;
    private final HasPersistentStateImpl f11040b;
    private final HasRowKeyImplEmpty f11041c;
    private final HasContextImpl f11042d;

    @Inject
    public FavoriteMediaPickerEnvironmentGenerated(@Assisted Context context, HasPrefetcherNoOpImpl hasPrefetcherNoOpImpl, HasPersistentStateImpl hasPersistentStateImpl, HasRowKeyImplEmpty hasRowKeyImplEmpty, HasContextImplProvider hasContextImplProvider) {
        this.f11039a = hasPrefetcherNoOpImpl;
        this.f11040b = hasPersistentStateImpl;
        this.f11041c = hasRowKeyImplEmpty;
        this.f11042d = HasContextImplProvider.a(context);
    }

    public final void m11211a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f11039a.a(imageRequest, callerContext);
    }

    public final <K, T> T m11208a(ContextStateKey<K, T> contextStateKey) {
        return this.f11040b.a(contextStateKey);
    }

    public final <K, T> T m11209a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f11040b.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m11212a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f11040b.a(contextStateKey, t);
    }

    public final RowKey m11213m() {
        return this.f11041c.m11217m();
    }

    public final void m11210a(RowKey rowKey) {
        this.f11041c.m11216a(rowKey);
    }

    public final void m11214n() {
        this.f11041c.m11218n();
    }

    public final boolean m11215o() {
        return this.f11041c.m11219o();
    }

    public Context getContext() {
        return this.f11042d.getContext();
    }
}

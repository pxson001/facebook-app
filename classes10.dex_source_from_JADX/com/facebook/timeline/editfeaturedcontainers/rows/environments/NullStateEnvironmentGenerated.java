package com.facebook.timeline.editfeaturedcontainers.rows.environments;

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
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.calls.SectionTypesInputFeaturedPageSuggestionsSectionType;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.timeline.editfeaturedcontainers.utils.NullStateMorePageSuggestionsFetcher;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: getAdvertisingIdInfo */
public class NullStateEnvironmentGenerated implements HasContext, HasPersistentState, HasPrefetcher, HasRowKey, HasMorePageSuggestionsFetcher {
    private final HasPrefetcherNoOpImpl f10903a;
    private final HasPersistentStateImpl f10904b;
    private final HasRowKeyImplEmpty f10905c;
    private final HasContextImpl f10906d;
    private final NullStateMorePageSuggestionsFetcher f10907e;

    @Inject
    public NullStateEnvironmentGenerated(@Assisted Context context, HasPrefetcherNoOpImpl hasPrefetcherNoOpImpl, HasPersistentStateImpl hasPersistentStateImpl, HasRowKeyImplEmpty hasRowKeyImplEmpty, HasContextImplProvider hasContextImplProvider, NullStateMorePageSuggestionsFetcher nullStateMorePageSuggestionsFetcher) {
        this.f10903a = hasPrefetcherNoOpImpl;
        this.f10904b = hasPersistentStateImpl;
        this.f10905c = hasRowKeyImplEmpty;
        this.f10906d = HasContextImplProvider.a(context);
        this.f10907e = nullStateMorePageSuggestionsFetcher;
    }

    public final void m11019a(ImageRequest imageRequest, CallerContext callerContext) {
        this.f10903a.a(imageRequest, callerContext);
    }

    public final <K, T> T m11013a(ContextStateKey<K, T> contextStateKey) {
        return this.f10904b.a(contextStateKey);
    }

    public final <K, T> T m11014a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f10904b.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m11020a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f10904b.a(contextStateKey, t);
    }

    public final RowKey m11021m() {
        return this.f10905c.m11010m();
    }

    public final void m11018a(RowKey rowKey) {
        this.f10905c.m11009a(rowKey);
    }

    public final void m11022n() {
        this.f10905c.m11011n();
    }

    public final boolean m11023o() {
        return this.f10905c.m11012o();
    }

    public Context getContext() {
        return this.f10906d.getContext();
    }

    public final void mo517a(int i, int i2, ImmutableList<SectionTypesInputFeaturedPageSuggestionsSectionType> immutableList, Context context) {
        this.f10907e.mo517a(i, i2, immutableList, context);
    }

    public final void mo518a(MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter) {
        this.f10907e.mo518a(multiRowRecyclerViewAdapter);
    }

    public final void mo516a() {
        this.f10907e.mo516a();
    }
}

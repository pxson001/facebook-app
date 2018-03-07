package com.facebook.timeline.entitycards;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.entitycards.collect.ImmutableOffsetArray;
import com.facebook.entitycards.loader.AvailableIdsLoader;
import com.facebook.entitycards.model.EntityCardsScrollDirection;
import com.facebook.entitycards.service.EntityCardsIdsForPageLoader;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.Assisted;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: geofence */
public class TimelineIdsForPageLoader implements EntityCardsIdsForPageLoader {
    protected final String f10987a;
    protected Optional<String> f10988b;
    private final TimelineEntityCardsType f10989c;
    public final AvailableIdsLoader f10990d;
    @Nullable
    private final CallerContext f10991e;
    private final Provider<ExecutorService> f10992f;

    /* compiled from: geofence */
    /* synthetic */ class C15972 {
        static final /* synthetic */ int[] f10986a = new int[TimelineEntityCardsType.values().length];
    }

    @Inject
    public TimelineIdsForPageLoader(@Assisted AvailableIdsLoader availableIdsLoader, @Nullable @Assisted CallerContext callerContext, @Assisted Bundle bundle, Provider<ExecutorService> provider) {
        Assertions.b(bundle);
        this.f10989c = (TimelineEntityCardsType) bundle.getSerializable("extra_loader_type");
        this.f10988b = Optional.fromNullable(bundle.getString("extra_cursor"));
        this.f10987a = bundle.getString("extra_query_data");
        this.f10990d = availableIdsLoader;
        this.f10991e = callerContext;
        this.f10992f = provider;
    }

    public final boolean m11103a(EntityCardsScrollDirection entityCardsScrollDirection) {
        boolean a = this.f10990d.a(entityCardsScrollDirection);
        if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
            return a;
        }
        return a || this.f10988b.isPresent();
    }

    public final ListenableFuture<ImmutableOffsetArray<String>> m11102a(EntityCardsScrollDirection entityCardsScrollDirection, final int i) {
        if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
            return this.f10990d.a(entityCardsScrollDirection, i);
        }
        ImmutableOffsetArray b = this.f10990d.b(entityCardsScrollDirection, i);
        if (b.c()) {
            return Futures.a(m11100b(), new Function<Pair<ImmutableList<String>, Optional<String>>, ImmutableOffsetArray<String>>(this) {
                final /* synthetic */ TimelineIdsForPageLoader f10985b;

                @Nullable
                public Object apply(Object obj) {
                    Pair pair = (Pair) obj;
                    this.f10985b.f10988b = (Optional) pair.second;
                    this.f10985b.f10990d.a((ImmutableList) pair.first);
                    return this.f10985b.f10990d.b(EntityCardsScrollDirection.RIGHT, i);
                }
            }, (Executor) this.f10992f.get());
        }
        return Futures.a(b);
    }

    public final Optional<Bundle> m11101a() {
        Serializable serializable = this.f10989c;
        Optional optional = this.f10988b;
        Serializable serializable2 = this.f10987a;
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_loader_type", serializable);
        bundle.putString("extra_cursor", (String) optional.orNull());
        bundle.putSerializable("extra_query_data", serializable2);
        return Optional.of(bundle);
    }

    private ListenableFuture<Pair<ImmutableList<String>, Optional<String>>> m11100b() {
        int[] iArr = C15972.f10986a;
        this.f10989c.ordinal();
        throw new UnsupportedOperationException("Unknown card type");
    }
}

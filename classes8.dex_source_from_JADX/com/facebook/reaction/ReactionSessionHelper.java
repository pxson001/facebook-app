package com.facebook.reaction;

import android.os.Bundle;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: button-style */
public class ReactionSessionHelper {
    public final ReactionUtil f18690a;
    public final ReactionSessionManager f18691b;

    /* compiled from: button-style */
    class C20702 implements Runnable {
        final /* synthetic */ ReactionSessionHelper f18689a;

        C20702(ReactionSessionHelper reactionSessionHelper) {
            this.f18689a = reactionSessionHelper;
        }

        public void run() {
        }
    }

    public static ReactionSessionHelper m22580b(InjectorLike injectorLike) {
        return new ReactionSessionHelper(ReactionUtil.m22637a(injectorLike), ReactionSessionManager.m22590a(injectorLike));
    }

    @Inject
    public ReactionSessionHelper(ReactionUtil reactionUtil, ReactionSessionManager reactionSessionManager) {
        this.f18690a = reactionUtil;
        this.f18691b = reactionSessionManager;
    }

    public final ReactionSession m22583a(Surface surface, ReactionQueryParams reactionQueryParams) {
        ReactionSession d = m22581d(surface, reactionQueryParams);
        this.f18690a.m22660a(reactionQueryParams, d.f18658a, surface);
        return d;
    }

    public final ReactionSession m22585a(@Nullable String str, Surface surface, ReactionQueryParams reactionQueryParams) {
        ReactionSession b = m22579b(str, surface, reactionQueryParams);
        this.f18690a.m22660a(reactionQueryParams, b.f18658a, surface);
        return b;
    }

    public final ReactionSession m22586b(Surface surface, ReactionQueryParams reactionQueryParams) {
        ReactionSession d = m22581d(surface, reactionQueryParams);
        this.f18690a.m22662a(reactionQueryParams, d.f18658a, surface, GraphQLCachePolicy.d, 604800, new ReactionInitialQueryCacheKeySerializer(surface, Long.toString(((Long) Preconditions.checkNotNull(reactionQueryParams.m22530q())).longValue())));
        return d;
    }

    public final ReactionSession m22584a(GraphQLBatchRequest graphQLBatchRequest, int i, Surface surface, ReactionQueryParams reactionQueryParams, @Nullable DisposableFutureCallback disposableFutureCallback, @Nullable ExecutorService executorService, boolean z) {
        ReactionSession d = m22581d(surface, reactionQueryParams);
        GraphQLBatchRequest graphQLBatchRequest2 = graphQLBatchRequest;
        int i2 = i;
        ReactionQueryParams reactionQueryParams2 = reactionQueryParams;
        Surface surface2 = surface;
        DisposableFutureCallback disposableFutureCallback2 = disposableFutureCallback;
        ExecutorService executorService2 = executorService;
        boolean z2 = z;
        this.f18690a.m22658a(graphQLBatchRequest2, i2, reactionQueryParams2, d.m22562f(), surface2, disposableFutureCallback2, executorService2, z2, 604800, new ReactionInitialQueryCacheKeySerializer(surface, Long.toString(((Long) Preconditions.checkNotNull(reactionQueryParams.m22530q())).longValue())));
        return d;
    }

    public final ReactionSession m22587c(Surface surface, ReactionQueryParams reactionQueryParams) {
        ReactionSession e = m22582e(surface, reactionQueryParams);
        this.f18690a.m22661a(reactionQueryParams, e.f18658a, surface, 604800, new ReactionInitialQueryCacheKeySerializer(surface, Long.toString(((Long) Preconditions.checkNotNull(reactionQueryParams.f18639t)).longValue())));
        return e;
    }

    private ReactionSession m22581d(Surface surface, ReactionQueryParams reactionQueryParams) {
        return m22578a(null, surface, reactionQueryParams, false);
    }

    private ReactionSession m22579b(@Nullable String str, Surface surface, ReactionQueryParams reactionQueryParams) {
        return m22578a(str, surface, reactionQueryParams, false);
    }

    private ReactionSession m22582e(Surface surface, ReactionQueryParams reactionQueryParams) {
        return m22578a(null, surface, reactionQueryParams, true);
    }

    private ReactionSession m22578a(@Nullable String str, Surface surface, ReactionQueryParams reactionQueryParams, boolean z) {
        final String uuid = Strings.isNullOrEmpty(str) ? SafeUUIDGenerator.a().toString() : str;
        final ReactionSession a = this.f18691b.m22603a(uuid, surface);
        if (z) {
            a.f18656A = new C20702(this);
        } else {
            final ReactionQueryParams reactionQueryParams2 = reactionQueryParams;
            final Surface surface2 = surface;
            a.f18656A = new Runnable(this) {
                final /* synthetic */ ReactionSessionHelper f18688e;

                public void run() {
                    a.m22554a();
                    this.f18688e.f18690a.m22660a(reactionQueryParams2, uuid, surface2);
                }
            };
        }
        if (reactionQueryParams.f18632m != null) {
            Bundle bundle = new Bundle();
            bundle.putString("place_name", reactionQueryParams.f18632m);
            a.f18681x = bundle;
        }
        a.f18682y = reactionQueryParams;
        this.f18691b.m22616c(uuid);
        this.f18691b.m22617d(uuid);
        return a;
    }
}

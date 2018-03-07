package com.facebook.reaction.ui.datafetcher;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;

/* compiled from: We should not look for the position of a non-result row */
public abstract class ReactionShowMoreDataFetcher<T, L> {
    public final DefaultAndroidThreadUtil f21097a;
    public final ReactionAnalyticsLogger f21098b;
    private final DisposableFutureCallback<GraphQLResult<T>> f21099c;
    public String f21100d = null;
    public boolean f21101e = true;
    public boolean f21102f = false;
    public String f21103g;
    public Surface f21104h;

    /* compiled from: We should not look for the position of a non-result row */
    public interface FetcherListener {
        void mo1126d();
    }

    /* compiled from: We should not look for the position of a non-result row */
    class RequestCallback extends AbstractDisposableFutureCallback<GraphQLResult<T>> {
        final /* synthetic */ ReactionShowMoreDataFetcher f21119a;

        public RequestCallback(ReactionShowMoreDataFetcher reactionShowMoreDataFetcher) {
            this.f21119a = reactionShowMoreDataFetcher;
        }

        protected final void m24732a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f21119a.f21097a.a();
            this.f21119a.f21102f = false;
            if (!(graphQLResult == null || graphQLResult.e == null)) {
                this.f21119a.mo1153b(graphQLResult.e);
                DefaultPageInfoFields a = this.f21119a.mo1151a(graphQLResult.e);
                if (a != null) {
                    this.f21119a.f21100d = a.a();
                    this.f21119a.f21101e = a.b();
                }
            }
            if (this.f21119a.f21100d == null) {
                this.f21119a.f21101e = false;
            }
        }

        protected final void m24733a(Throwable th) {
            this.f21119a.f21102f = false;
            this.f21119a.f21098b.m22834a(this.f21119a.f21103g, this.f21119a.f21104h, th);
        }
    }

    protected abstract DefaultPageInfoFields mo1151a(T t);

    protected abstract void mo1152a(String str, DisposableFutureCallback<GraphQLResult<T>> disposableFutureCallback);

    protected abstract void mo1153b(T t);

    public ReactionShowMoreDataFetcher(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ReactionAnalyticsLogger reactionAnalyticsLogger, String str, Surface surface) {
        this.f21097a = defaultAndroidThreadUtil;
        this.f21098b = reactionAnalyticsLogger;
        this.f21099c = new RequestCallback(this);
        this.f21103g = str;
        this.f21104h = surface;
    }

    public final void m24721b() {
        if (this.f21101e && !this.f21102f) {
            mo1152a(this.f21100d, this.f21099c);
            this.f21102f = true;
        }
    }
}

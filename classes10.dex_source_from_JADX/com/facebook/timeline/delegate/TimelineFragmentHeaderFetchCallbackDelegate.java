package com.facebook.timeline.delegate;

import android.content.Context;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultBigProfilePictureFieldsModel;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.TimelineFragment;
import com.facebook.timeline.datafetcher.FetchContactCacheTask;
import com.facebook.timeline.datafetcher.HeaderFetchFutures;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ViewerTopFriendsQueryModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ViewerTopFriendsQueryModel.FollowedProfilesModel.NodesModel;
import com.facebook.timeline.protocol.ResultSource;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: gpi */
public class TimelineFragmentHeaderFetchCallbackDelegate {
    private static TimelineFragmentHeaderFetchCallbackDelegate f10723i;
    private static final Object f10724j = new Object();
    @ForUiThread
    private final Provider<Executor> f10725a;
    public final TimelinePerformanceLogger f10726b;
    public TimelineFragment f10727c;
    private AbstractDisposableFutureCallback<GraphQLResult<?>> f10728d;
    private AbstractDisposableFutureCallback<GraphQLResult<?>> f10729e;
    public final boolean[] f10730f = new boolean[]{false};
    public TimelineAbstractDisposableFutureCallback<GraphQLResult<DefaultBigProfilePictureFieldsModel>> f10731g;
    public AbstractDisposableFutureCallback<GraphQLResult<ViewerTopFriendsQueryModel>> f10732h;

    /* compiled from: gpi */
    abstract class TimelineAbstractDisposableFutureCallback<T> extends AbstractDisposableFutureCallback<T> {
        final /* synthetic */ TimelineFragmentHeaderFetchCallbackDelegate f10718b;

        public TimelineAbstractDisposableFutureCallback(TimelineFragmentHeaderFetchCallbackDelegate timelineFragmentHeaderFetchCallbackDelegate) {
            this.f10718b = timelineFragmentHeaderFetchCallbackDelegate;
        }

        public final void jc_() {
            super.jc_();
            this.f10718b.f10727c = null;
        }
    }

    /* compiled from: gpi */
    class C15571 extends TimelineAbstractDisposableFutureCallback<GraphQLResult<?>> {
        final /* synthetic */ TimelineFragmentHeaderFetchCallbackDelegate f10719a;

        C15571(TimelineFragmentHeaderFetchCallbackDelegate timelineFragmentHeaderFetchCallbackDelegate) {
            this.f10719a = timelineFragmentHeaderFetchCallbackDelegate;
            super(timelineFragmentHeaderFetchCallbackDelegate);
        }

        public final void m10763a(Object obj) {
            TimelineFragmentHeaderFetchCallbackDelegate.m10776d((GraphQLResult) obj, this.f10719a.f10727c);
        }

        public final void m10764a(Throwable th) {
            this.f10719a.f10727c.aL();
        }
    }

    /* compiled from: gpi */
    class C15582 extends TimelineAbstractDisposableFutureCallback<GraphQLResult<?>> {
        final /* synthetic */ TimelineFragmentHeaderFetchCallbackDelegate f10720a;

        C15582(TimelineFragmentHeaderFetchCallbackDelegate timelineFragmentHeaderFetchCallbackDelegate) {
            this.f10720a = timelineFragmentHeaderFetchCallbackDelegate;
            super(timelineFragmentHeaderFetchCallbackDelegate);
        }

        public final void m10765a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (TimelineFragmentHeaderFetchCallbackDelegate.m10775b(graphQLResult)) {
                TimelinePerformanceLogger timelinePerformanceLogger = this.f10720a.f10726b;
                timelinePerformanceLogger.f.c = true;
                timelinePerformanceLogger.c.f("TimelineHeaderCachedDataRead");
                if (!this.f10720a.f10730f[0]) {
                    TimelineFragment timelineFragment = this.f10720a.f10727c;
                    if (TimelineFragmentHeaderFetchCallbackDelegate.m10775b(graphQLResult)) {
                        TimelineFragmentHeaderFetchCallbackDelegate.m10776d(graphQLResult, timelineFragment);
                    }
                }
            }
        }

        public final void m10766a(Throwable th) {
            this.f10720a.f10727c.aL();
        }
    }

    /* compiled from: gpi */
    public class C15593 extends TimelineAbstractDisposableFutureCallback<GraphQLResult<DefaultBigProfilePictureFieldsModel>> {
        final /* synthetic */ TimelineFragmentHeaderFetchCallbackDelegate f10721a;

        public C15593(TimelineFragmentHeaderFetchCallbackDelegate timelineFragmentHeaderFetchCallbackDelegate) {
            this.f10721a = timelineFragmentHeaderFetchCallbackDelegate;
            super(timelineFragmentHeaderFetchCallbackDelegate);
        }

        protected final void m10767a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e == null || ((DefaultBigProfilePictureFieldsModel) graphQLResult.e).a() == null || ((DefaultBigProfilePictureFieldsModel) graphQLResult.e).a().b() == null) {
                this.f10721a.f10727c.aQ();
                return;
            }
            TimelineFragment timelineFragment = this.f10721a.f10727c;
            String b = ((DefaultBigProfilePictureFieldsModel) graphQLResult.e).a().b();
            if (timelineFragment.cg != null) {
                timelineFragment.cm.c.b("TimelineFetchProfilePicUri");
                ImageRequest a = ImageRequest.a(b);
                if (a != null) {
                    ((ImagePipeline) timelineFragment.cs.get()).e(a, TimelineFragment.br);
                }
            }
        }

        protected final void m10768a(Throwable th) {
            this.f10721a.f10727c.aQ();
        }
    }

    /* compiled from: gpi */
    public class C15604 extends TimelineAbstractDisposableFutureCallback<GraphQLResult<ViewerTopFriendsQueryModel>> {
        final /* synthetic */ TimelineFragmentHeaderFetchCallbackDelegate f10722a;

        public C15604(TimelineFragmentHeaderFetchCallbackDelegate timelineFragmentHeaderFetchCallbackDelegate) {
            this.f10722a = timelineFragmentHeaderFetchCallbackDelegate;
            super(timelineFragmentHeaderFetchCallbackDelegate);
        }

        protected final void m10769a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null && ((ViewerTopFriendsQueryModel) graphQLResult.e).a() != null) {
                TimelineFragment timelineFragment = this.f10722a.f10727c;
                ImmutableList a = ((ViewerTopFriendsQueryModel) graphQLResult.e).a().a();
                if (timelineFragment.cg != null && timelineFragment.cf != null) {
                    String valueOf = String.valueOf(timelineFragment.cf.b);
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        if (valueOf.equals(((NodesModel) a.get(i)).b())) {
                            timelineFragment.cg.k = true;
                            return;
                        }
                    }
                }
            }
        }

        protected final void m10770a(Throwable th) {
        }
    }

    private static TimelineFragmentHeaderFetchCallbackDelegate m10774b(InjectorLike injectorLike) {
        return new TimelineFragmentHeaderFetchCallbackDelegate(IdBasedSingletonScopeProvider.a(injectorLike, 3863), TimelinePerformanceLogger.a(injectorLike));
    }

    public static TimelineFragmentHeaderFetchCallbackDelegate m10771a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineFragmentHeaderFetchCallbackDelegate b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10724j) {
                TimelineFragmentHeaderFetchCallbackDelegate timelineFragmentHeaderFetchCallbackDelegate;
                if (a2 != null) {
                    timelineFragmentHeaderFetchCallbackDelegate = (TimelineFragmentHeaderFetchCallbackDelegate) a2.a(f10724j);
                } else {
                    timelineFragmentHeaderFetchCallbackDelegate = f10723i;
                }
                if (timelineFragmentHeaderFetchCallbackDelegate == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10774b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10724j, b3);
                        } else {
                            f10723i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineFragmentHeaderFetchCallbackDelegate;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public TimelineFragmentHeaderFetchCallbackDelegate(Provider<Executor> provider, TimelinePerformanceLogger timelinePerformanceLogger) {
        this.f10725a = provider;
        this.f10726b = timelinePerformanceLogger;
    }

    public final void m10778a(@Nullable HeaderFetchFutures headerFetchFutures, TimelineFragment timelineFragment) {
        if (headerFetchFutures != null && headerFetchFutures.f10416a != null && headerFetchFutures.f10417b != null) {
            GraphQLQueryFuture graphQLQueryFuture;
            this.f10727c = timelineFragment;
            m10772a(headerFetchFutures);
            if (headerFetchFutures.f10418c != null) {
                graphQLQueryFuture = headerFetchFutures.f10418c;
                this.f10731g = new C15593(this);
                Futures.a(graphQLQueryFuture, this.f10731g, MoreExecutors.a());
            }
            if (headerFetchFutures.f10419d != null) {
                graphQLQueryFuture = headerFetchFutures.f10419d;
                this.f10732h = new C15604(this);
                Futures.a(graphQLQueryFuture, this.f10732h, MoreExecutors.a());
            }
        }
    }

    private void m10772a(HeaderFetchFutures headerFetchFutures) {
        if (headerFetchFutures.f10417b.isDone() && !headerFetchFutures.f10417b.isCancelled()) {
            try {
                Uninterruptibles.a(headerFetchFutures.f10417b);
                this.f10730f[0] = true;
            } catch (ExecutionException e) {
                this.f10730f[0] = false;
            }
        }
        this.f10728d = new C15571(this);
        Futures.a(headerFetchFutures.f10417b, this.f10728d, (Executor) this.f10725a.get());
        this.f10729e = new C15582(this);
        Futures.a(headerFetchFutures.f10416a, this.f10729e, (Executor) this.f10725a.get());
    }

    public static void m10773a(boolean z, @Nullable HeaderFetchFutures headerFetchFutures, @Nullable FetchContactCacheTask fetchContactCacheTask) {
        if (headerFetchFutures != null) {
            headerFetchFutures.f10416a.cancel(true);
            if (z) {
                headerFetchFutures.f10417b.cancel(true);
            }
            if (headerFetchFutures.f10418c != null) {
                headerFetchFutures.f10418c.cancel(true);
            }
            if (headerFetchFutures.f10419d != null) {
                headerFetchFutures.f10419d.cancel(true);
            }
        }
        if (fetchContactCacheTask != null && fetchContactCacheTask != null) {
            fetchContactCacheTask.f10402c.cancel(false);
            fetchContactCacheTask.cancel(false);
        }
    }

    public final void m10777a() {
        if (this.f10729e != null) {
            this.f10729e.jc_();
        }
        if (this.f10728d != null) {
            this.f10728d.jc_();
        }
        if (this.f10731g != null) {
            this.f10731g.jc_();
        }
        if (this.f10732h != null) {
            this.f10732h.jc_();
        }
    }

    public static void m10776d(@Nullable GraphQLResult<?> graphQLResult, Listener listener) {
        try {
            TracerDetour.a("TimelineFragment.onFetchHeaderSucceeded", -1759884495);
            Object obj = null;
            DataFreshnessResult dataFreshnessResult = DataFreshnessResult.NO_DATA;
            ResultSource resultSource = ResultSource.UNDEFINED;
            if (graphQLResult != null) {
                obj = graphQLResult.d();
                dataFreshnessResult = graphQLResult.a();
                resultSource = ResultSource.fromGraphQLResultDataFreshness(dataFreshnessResult);
            }
            listener.m10305a(obj, dataFreshnessResult, resultSource);
        } finally {
            TracerDetour.a(1330631901);
        }
    }

    public static boolean m10775b(@Nullable GraphQLResult<?> graphQLResult) {
        return (graphQLResult == null || graphQLResult.e == null) ? false : true;
    }
}

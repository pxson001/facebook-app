package com.facebook.timeline.datafetcher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.earlyfetch.EarlyFetchResult;
import com.facebook.earlyfetch.EarlyFetcher;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLBatchRequest.EndpointScheduler;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.timeline.TimelineFetchFutures;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.controllers.TimelineContactCacheController;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.delegate.TimelineFragmentHeaderFetchCallbackDelegate;
import com.facebook.timeline.intent.ModelBundleGraphQLInterfaces.ModelBundleProfileGraphQL;
import com.facebook.timeline.profileprotocol.FetchTimelineHeaderParamsFactory;
import com.facebook.timeline.protocol.FetchTimelineHeaderParams;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: groupInformation or groupId is null in openGroupInfo */
public class TimelineEarlyFetcher extends EarlyFetcher<TimelineFetchIdentifier, TimelineEarlyFetchFutures> {
    @VisibleForTesting
    static final CallerContext f10456a = CallerContext.a(TimelineEarlyFetcher.class, "timeline");
    private static volatile TimelineEarlyFetcher f10457l;
    public final Provider<QeAccessor> f10458b;
    private final Provider<FetchTimelineHeaderParamsFactory> f10459c;
    private final Provider<TimelineHeaderParallelQueryExecutor> f10460d;
    private final Provider<TimelineFirstUnitsEarlyFetcher> f10461e;
    @LoggedInUserId
    private final Provider<String> f10462f;
    private final Provider<TimelineContactCacheController> f10463g;
    private final Provider<QuickPerformanceLogger> f10464h;
    private final Provider<TimelineFetchFutures> f10465i;
    public final Lazy<ImagePipeline> f10466j;
    private final Provider<GraphQLQueryExecutor> f10467k;

    public static com.facebook.timeline.datafetcher.TimelineEarlyFetcher m10575a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10457l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineEarlyFetcher.class;
        monitor-enter(r1);
        r0 = f10457l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10578b(r0);	 Catch:{ all -> 0x0035 }
        f10457l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10457l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineEarlyFetcher.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineEarlyFetcher");
    }

    private static TimelineEarlyFetcher m10578b(InjectorLike injectorLike) {
        return new TimelineEarlyFetcher(IdBasedSingletonScopeProvider.a(injectorLike, 3219), IdBasedSingletonScopeProvider.a(injectorLike, 11309), IdBasedSingletonScopeProvider.a(injectorLike, 11179), IdBasedSingletonScopeProvider.a(injectorLike, 11176), IdBasedProvider.a(injectorLike, 4442), IdBasedProvider.a(injectorLike, 11165), IdBasedSingletonScopeProvider.a(injectorLike, 3229), IdBasedSingletonScopeProvider.a(injectorLike, 11121), IdBasedSingletonScopeProvider.b(injectorLike, 2309), IdBasedProvider.a(injectorLike, 2164));
    }

    protected final void m10581a(Object obj) {
        TimelineEarlyFetchFutures timelineEarlyFetchFutures = (TimelineEarlyFetchFutures) obj;
        if (timelineEarlyFetchFutures != null) {
            TimelineFragmentHeaderFetchCallbackDelegate.m10773a(true, timelineEarlyFetchFutures.f10453a, timelineEarlyFetchFutures.f10454b);
        }
    }

    @Inject
    public TimelineEarlyFetcher(Provider<QeAccessor> provider, Provider<FetchTimelineHeaderParamsFactory> provider2, Provider<TimelineHeaderParallelQueryExecutor> provider3, Provider<TimelineFirstUnitsEarlyFetcher> provider4, Provider<String> provider5, Provider<TimelineContactCacheController> provider6, Provider<QuickPerformanceLogger> provider7, Provider<TimelineFetchFutures> provider8, Lazy<ImagePipeline> lazy, Provider<GraphQLQueryExecutor> provider9) {
        this.f10458b = provider;
        this.f10459c = provider2;
        this.f10460d = provider3;
        this.f10461e = provider4;
        this.f10462f = provider5;
        this.f10463g = provider6;
        this.f10464h = provider7;
        this.f10465i = provider8;
        this.f10466j = lazy;
        this.f10467k = provider9;
    }

    protected final boolean m10582a(int i) {
        return i == 2645995 && ((QeAccessor) this.f10458b.get()).a(ExperimentsForTimelineAbTestModule.E, false);
    }

    protected final EarlyFetchResult<TimelineFetchIdentifier, TimelineEarlyFetchFutures> m10580a(String str, Bundle bundle) {
        ((QuickPerformanceLogger) this.f10464h.get()).b(1703974);
        EarlyFetchResult<TimelineFetchIdentifier, TimelineEarlyFetchFutures> a = m10573a(Long.parseLong(str), bundle);
        ((QuickPerformanceLogger) this.f10464h.get()).b(1703974, (short) 2);
        return a;
    }

    @Nullable
    protected final EarlyFetchResult<TimelineFetchIdentifier, TimelineEarlyFetchFutures> m10579a(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        long j;
        ((QuickPerformanceLogger) this.f10464h.get()).b(1703974);
        if (extras.containsKey("com.facebook.katana.profile.id")) {
            j = extras.getLong("com.facebook.katana.profile.id");
        } else {
            j = Long.parseLong((String) this.f10462f.get());
        }
        EarlyFetchResult<TimelineFetchIdentifier, TimelineEarlyFetchFutures> a = m10573a(j, extras);
        ((QuickPerformanceLogger) this.f10464h.get()).b(1703974, (short) 2);
        return a;
    }

    @Nullable
    private EarlyFetchResult<TimelineFetchIdentifier, TimelineEarlyFetchFutures> m10573a(long j, Bundle bundle) {
        int i = 1;
        if (((TimelineFetchFutures) this.f10465i.get()).m10273b(j) == 1) {
            return null;
        }
        EndpointScheduler endpointScheduler;
        Optional fromNullable = Optional.fromNullable(bundle.getString("timeline_context_item_type"));
        boolean z = bundle.getBoolean("timeline_has_unseen_section");
        FetchTimelineHeaderParams a = ((FetchTimelineHeaderParamsFactory) this.f10459c.get()).m12095a(j, fromNullable);
        ModelBundleProfileGraphQL modelBundleProfileGraphQL = (ModelBundleProfileGraphQL) FlatBufferModelHelper.a(bundle, "graphql_profile");
        TimelineFetchIdentifier timelineFetchIdentifier = new TimelineFetchIdentifier(j);
        boolean a2 = ((QeAccessor) this.f10458b.get()).a(ExperimentsForTimelineAbTestModule.M, false);
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("TimelineEarlyFetcherRequest");
        if (a2) {
            endpointScheduler = EndpointScheduler.PHASED;
        } else {
            endpointScheduler = EndpointScheduler.UNSPECIFIED;
        }
        graphQLBatchRequest.j = endpointScheduler;
        HeaderFetchFutures a3 = ((TimelineHeaderParallelQueryExecutor) this.f10460d.get()).m10627a(graphQLBatchRequest, a, modelBundleProfileGraphQL, f10456a);
        if (!a2) {
            i = 0;
        }
        FirstUnitsObservables a4 = m10576a(graphQLBatchRequest, j, z, i);
        ((GraphQLQueryExecutor) this.f10467k.get()).a(graphQLBatchRequest);
        ((TimelineHeaderParallelQueryExecutor) this.f10460d.get()).m10628a(a3);
        m10577a(modelBundleProfileGraphQL);
        return new EarlyFetchResult(timelineFetchIdentifier, new TimelineEarlyFetchFutures(a3, m10574a(j), a4));
    }

    @Nullable
    private FirstUnitsObservables m10576a(GraphQLBatchRequest graphQLBatchRequest, long j, boolean z, int i) {
        boolean z2 = false;
        if (!((QeAccessor) this.f10458b.get()).a(ExperimentsForTimelineAbTestModule.L, false)) {
            return null;
        }
        TimelineFirstUnitsEarlyFetcher timelineFirstUnitsEarlyFetcher = (TimelineFirstUnitsEarlyFetcher) this.f10461e.get();
        if (j == Long.parseLong((String) this.f10462f.get())) {
            z2 = true;
        }
        return timelineFirstUnitsEarlyFetcher.m10586a(graphQLBatchRequest, j, z2, z, i, f10456a);
    }

    protected final boolean m10583b() {
        return true;
    }

    @Nullable
    private FetchContactCacheTask m10574a(long j) {
        if (!((QeAccessor) this.f10458b.get()).a(ExperimentsForTimelineAbTestModule.A, false)) {
            return null;
        }
        TimelineContactCacheController timelineContactCacheController = (TimelineContactCacheController) this.f10463g.get();
        FbAsyncTask fetchContactCacheTask = new FetchContactCacheTask(Long.valueOf(j), ContactIterators.a(timelineContactCacheController.f10353c));
        timelineContactCacheController.f10352b.a(fetchContactCacheTask, new Void[0]);
        return fetchContactCacheTask;
    }

    private void m10577a(ModelBundleProfileGraphQL modelBundleProfileGraphQL) {
        Object obj;
        if (modelBundleProfileGraphQL == null || modelBundleProfileGraphQL.dB_() == null || modelBundleProfileGraphQL.dB_().b() == null || ((ImagePipeline) this.f10466j.get()).b(Uri.parse(modelBundleProfileGraphQL.dB_().b()))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            ((ImagePipeline) this.f10466j.get()).e(ImageRequest.a(modelBundleProfileGraphQL.dB_().b()), f10456a);
        }
    }
}

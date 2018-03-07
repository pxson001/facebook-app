package com.facebook.feedback.reactions.api;

import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: gsym_imp */
public class FeedbackReactionsSettingsFetcher {
    private static volatile FeedbackReactionsSettingsFetcher f21458d;
    public final GraphQLQueryExecutor f21459a;
    private final TasksManager f21460b;
    public final Executor f21461c;

    /* compiled from: gsym_imp */
    public class C08513 implements Function<GraphQLResult<C0850x41c6c670>, ImmutableList<ReactionInfosModel>> {
        final /* synthetic */ FeedbackReactionsSettingsFetcher f21501a;

        public C08513(FeedbackReactionsSettingsFetcher feedbackReactionsSettingsFetcher) {
            this.f21501a = feedbackReactionsSettingsFetcher;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return null;
            }
            return ((C0850x41c6c670) graphQLResult.f6203e).m29206a().m29976a();
        }
    }

    public static com.facebook.feedback.reactions.api.FeedbackReactionsSettingsFetcher m29175a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21458d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.reactions.api.FeedbackReactionsSettingsFetcher.class;
        monitor-enter(r1);
        r0 = f21458d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m29176b(r0);	 Catch:{ all -> 0x0035 }
        f21458d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21458d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.api.FeedbackReactionsSettingsFetcher.a(com.facebook.inject.InjectorLike):com.facebook.feedback.reactions.api.FeedbackReactionsSettingsFetcher");
    }

    private static FeedbackReactionsSettingsFetcher m29176b(InjectorLike injectorLike) {
        return new FeedbackReactionsSettingsFetcher(GraphQLQueryExecutor.m10435a(injectorLike), TasksManager.m14550b(injectorLike), C0055x2995691a.m1881a(injectorLike));
    }

    @Inject
    public FeedbackReactionsSettingsFetcher(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, ExecutorService executorService) {
        this.f21459a = graphQLQueryExecutor;
        this.f21460b = tasksManager;
        this.f21461c = executorService;
    }

    public final void m29177a(float f, boolean z, final FutureCallback futureCallback, final FeedbackReactionsSettingsLogger feedbackReactionsSettingsLogger, boolean z2) {
        if (futureCallback != null) {
            final FeedbackReactionsSettingsLogger feedbackReactionsSettingsLogger2 = feedbackReactionsSettingsLogger;
            final float f2 = f;
            final boolean z3 = z;
            final boolean z4 = z2;
            this.f21460b.m14556a((Object) "feedback_reaction_settings_fetch", new Callable<ListenableFuture<ImmutableList<ReactionInfosModel>>>(this) {
                final /* synthetic */ FeedbackReactionsSettingsFetcher f21496e;

                public Object call() {
                    GraphQLCachePolicy graphQLCachePolicy;
                    FeedbackReactionsSettingsLogger feedbackReactionsSettingsLogger = feedbackReactionsSettingsLogger2;
                    feedbackReactionsSettingsLogger.f21465d = feedbackReactionsSettingsLogger.f21463b.mo211a();
                    FeedbackReactionsSettingsFetcher feedbackReactionsSettingsFetcher = this.f21496e;
                    float f = f2;
                    boolean z = z3;
                    if (z4) {
                        graphQLCachePolicy = GraphQLCachePolicy.f7112d;
                    } else {
                        graphQLCachePolicy = GraphQLCachePolicy.f7109a;
                    }
                    TypedGraphQlQueryString c0849x58811274 = new C0849x58811274();
                    c0849x58811274.m11314a("scale", Float.valueOf(f));
                    c0849x58811274.m11312a("includeVectorData", Boolean.valueOf(z));
                    return Futures.m2450a(feedbackReactionsSettingsFetcher.f21459a.m10446a(GraphQLRequest.m11587a(c0849x58811274).m11590a(86400).m11594a(graphQLCachePolicy)), new C08513(feedbackReactionsSettingsFetcher), feedbackReactionsSettingsFetcher.f21461c);
                }
            }, new AbstractDisposableFutureCallback<List<ReactionInfosModel>>(this) {
                final /* synthetic */ FeedbackReactionsSettingsFetcher f21499c;

                protected final void mo347a(Object obj) {
                    List list = (List) obj;
                    if (list != null) {
                        feedbackReactionsSettingsLogger.m29181a(true);
                        futureCallback.onSuccess(list);
                    }
                }

                protected final void mo348a(Throwable th) {
                    feedbackReactionsSettingsLogger.m29181a(false);
                    futureCallback.onFailure(th);
                }
            });
        }
    }
}

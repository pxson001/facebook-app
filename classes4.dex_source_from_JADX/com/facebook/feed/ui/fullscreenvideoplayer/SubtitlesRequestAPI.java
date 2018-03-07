package com.facebook.feed.ui.fullscreenvideoplayer;

import com.facebook.api.graphql.videocaptions.FetchVideoCaptionsGraphQL.FetchVideoCaptionsGraphQLString;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: personal_to_work_switch */
public class SubtitlesRequestAPI {
    private static volatile SubtitlesRequestAPI f5043d;
    private GraphQLQueryExecutor f5044a;
    private ExecutorService f5045b;
    public AbstractFbErrorReporter f5046c;

    public static com.facebook.feed.ui.fullscreenvideoplayer.SubtitlesRequestAPI m5421a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5043d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.ui.fullscreenvideoplayer.SubtitlesRequestAPI.class;
        monitor-enter(r1);
        r0 = f5043d;	 Catch:{ all -> 0x003a }
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
        r0 = m5422b(r0);	 Catch:{ all -> 0x0035 }
        f5043d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5043d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.ui.fullscreenvideoplayer.SubtitlesRequestAPI.a(com.facebook.inject.InjectorLike):com.facebook.feed.ui.fullscreenvideoplayer.SubtitlesRequestAPI");
    }

    private static SubtitlesRequestAPI m5422b(InjectorLike injectorLike) {
        return new SubtitlesRequestAPI(GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public SubtitlesRequestAPI(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5044a = graphQLQueryExecutor;
        this.f5045b = executorService;
        this.f5046c = abstractFbErrorReporter;
    }

    public final void m5423a(String str, String str2, SubtitlesRequestCallback subtitlesRequestCallback) {
        if (str2.equals("")) {
            subtitlesRequestCallback.a();
            return;
        }
        GraphQlQueryString fetchVideoCaptionsGraphQLString = new FetchVideoCaptionsGraphQLString();
        fetchVideoCaptionsGraphQLString.a("video_id", str);
        fetchVideoCaptionsGraphQLString.a("locales", str2);
        Futures.a(this.f5044a.a(GraphQLRequest.a(fetchVideoCaptionsGraphQLString).a(GraphQLCachePolicy.a).a(600)), new 1(this, subtitlesRequestCallback), this.f5045b);
    }
}

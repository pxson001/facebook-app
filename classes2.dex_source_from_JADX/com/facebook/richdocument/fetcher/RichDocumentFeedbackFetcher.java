package com.facebook.richdocument.fetcher;

import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQl.RichDocumentNodeFeedbackString;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_thread */
public class RichDocumentFeedbackFetcher {
    private static volatile RichDocumentFeedbackFetcher f23878c;
    public final GraphQLQueryExecutor f23879a;
    public final TasksManager f23880b;

    public static com.facebook.richdocument.fetcher.RichDocumentFeedbackFetcher m32269a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23878c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.richdocument.fetcher.RichDocumentFeedbackFetcher.class;
        monitor-enter(r1);
        r0 = f23878c;	 Catch:{ all -> 0x003a }
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
        r0 = m32270b(r0);	 Catch:{ all -> 0x0035 }
        f23878c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23878c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.fetcher.RichDocumentFeedbackFetcher.a(com.facebook.inject.InjectorLike):com.facebook.richdocument.fetcher.RichDocumentFeedbackFetcher");
    }

    private static RichDocumentFeedbackFetcher m32270b(InjectorLike injectorLike) {
        return new RichDocumentFeedbackFetcher(GraphQLQueryExecutor.m10435a(injectorLike), TasksManager.m14550b(injectorLike));
    }

    @Inject
    public RichDocumentFeedbackFetcher(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f23879a = graphQLQueryExecutor;
        this.f23880b = tasksManager;
    }

    public static GraphQLRequest<GraphQLFeedback> m32268a(String str, long j) {
        GraphQLRequest<GraphQLFeedback> a = GraphQLRequest.m11587a((RichDocumentNodeFeedbackString) new RichDocumentNodeFeedbackString().m11315a("feedback_node_id", str)).m11594a(GraphQLCachePolicy.f7109a).m11590a(j).m11596a(RequestPriority.INTERACTIVE);
        a.f7084b = true;
        return a;
    }
}

package com.facebook.feed.curationflow;

import com.facebook.api.feed.service.GraphPostService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.feed.protocol.FetchCurationFlowGraphQL.FetchCurationFlowString;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLModels.FetchCurationFlowModel.FeedCurationFlowStepModel;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction.Builder;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Map;
import java.util.Stack;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_info_rtt_stddev */
public class CurationFlowManager {
    public static final String f12492a = CurationFlowManager.class.getSimpleName();
    private static volatile CurationFlowManager f12493i;
    public final AbstractFbErrorReporter f12494b;
    private final ListeningExecutorService f12495c;
    private final GraphQLQueryExecutor f12496d;
    private final GraphPostService f12497e;
    public Map<String, Stack<FeedCurationFlowStepModel>> f12498f = Maps.m838c();
    private Map<String, String> f12499g = Maps.m838c();
    private Map<String, GraphQLNegativeFeedbackActionType> f12500h = Maps.m838c();

    public static com.facebook.feed.curationflow.CurationFlowManager m18565a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12493i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.curationflow.CurationFlowManager.class;
        monitor-enter(r1);
        r0 = f12493i;	 Catch:{ all -> 0x003a }
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
        r0 = m18567b(r0);	 Catch:{ all -> 0x0035 }
        f12493i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12493i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.curationflow.CurationFlowManager.a(com.facebook.inject.InjectorLike):com.facebook.feed.curationflow.CurationFlowManager");
    }

    private static CurationFlowManager m18567b(InjectorLike injectorLike) {
        return new CurationFlowManager(FbErrorReporterImpl.m2317a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), GraphPostService.m18477b(injectorLike));
    }

    @Inject
    public CurationFlowManager(AbstractFbErrorReporter abstractFbErrorReporter, ListeningExecutorService listeningExecutorService, GraphQLQueryExecutor graphQLQueryExecutor, GraphPostService graphPostService) {
        this.f12494b = abstractFbErrorReporter;
        this.f12495c = listeningExecutorService;
        this.f12496d = graphQLQueryExecutor;
        this.f12497e = graphPostService;
    }

    public final void m18573a(String str, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType, FutureCallback<FeedCurationFlowStepModel> futureCallback) {
        TypedGraphQlQueryString fetchCurationFlowString = new FetchCurationFlowString();
        fetchCurationFlowString.m11315a("node_id", str).m11315a("action", graphQLNegativeFeedbackActionType.name()).m11315a("action_path", m18569c(str));
        Futures.m2458a(this.f12496d.m10446a(GraphQLRequest.m11587a(fetchCurationFlowString)), new 4(this, str, futureCallback, graphQLNegativeFeedbackActionType), this.f12495c);
    }

    public final void m18571a(FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType, FutureCallback<FeedCurationFlowStepModel> futureCallback) {
        String r = ((NegativeFeedbackActionsUnit) feedProps.f13444a).mo2892r();
        m18568b(r, graphQLNegativeFeedbackActionType);
        Builder builder = new Builder();
        builder.j = graphQLNegativeFeedbackActionType;
        GraphQLNegativeFeedbackAction a = builder.a();
        String c = m18569c(r);
        Futures.m2458a(this.f12497e.m18478a(feedProps, a, NegativeFeedbackExperienceLocation.NEWSFEED.stringValueOf(), c), new 3(this, r, graphQLNegativeFeedbackActionType, new 2(this, futureCallback, feedProps, graphQLNegativeFeedbackActionType, c), futureCallback), this.f12495c);
    }

    public final void m18572a(FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, FutureCallback<FeedCurationFlowStepModel> futureCallback) {
        String r = ((NegativeFeedbackActionsUnit) feedProps.f13444a).mo2892r();
        if (this.f12498f.containsKey(r)) {
            GraphQLNegativeFeedbackActionType a = ((FeedCurationFlowStepModel) ((Stack) this.f12498f.get(r)).peek()).j().a();
            ListenableFuture a2 = m18566a(this, feedProps, a, m18569c(r));
            m18568b(r, a);
            Futures.m2458a(a2, new 1(this, r, futureCallback), this.f12495c);
        }
    }

    public final boolean m18576a(String str, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType) {
        if (this.f12500h.containsKey(str) && this.f12500h.get(str) == graphQLNegativeFeedbackActionType) {
            return true;
        }
        return false;
    }

    public final boolean m18575a(String str) {
        return this.f12500h.containsKey(str);
    }

    public final FeedCurationFlowStepModel m18577b(String str) {
        if (!this.f12498f.containsKey(str)) {
            return null;
        }
        Stack stack = (Stack) this.f12498f.get(str);
        if (stack.empty()) {
            return null;
        }
        return (FeedCurationFlowStepModel) stack.peek();
    }

    public final void m18574a(String str, String str2) {
        this.f12499g.put(str, str2);
    }

    private String m18569c(String str) {
        String str2 = (String) this.f12499g.get(str);
        return str2 != null ? str2 : "";
    }

    public static ListenableFuture m18566a(CurationFlowManager curationFlowManager, FeedProps feedProps, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType, String str) {
        Builder builder = new Builder();
        builder.j = graphQLNegativeFeedbackActionType;
        return curationFlowManager.f12497e.m18483b(feedProps, builder.a(), NegativeFeedbackExperienceLocation.NEWSFEED.stringValueOf(), str);
    }

    private void m18568b(String str, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType) {
        this.f12500h.put(str, graphQLNegativeFeedbackActionType);
    }

    public static void m18570d(CurationFlowManager curationFlowManager, String str) {
        curationFlowManager.f12500h.remove(str);
    }
}

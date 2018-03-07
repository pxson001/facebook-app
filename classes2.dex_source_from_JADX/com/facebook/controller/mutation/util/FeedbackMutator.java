package com.facebook.controller.mutation.util;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel;
import com.facebook.api.ufiservices.common.CommentLoadDirection;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentPlaceInfoToPlaceListItemsConnection;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedbackReaction;
import com.facebook.graphql.model.GraphQLFeedbackReactionInfo;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLPlaceListItem;
import com.facebook.graphql.model.GraphQLPlaceListItemToRecommendingCommentsConnection;
import com.facebook.graphql.model.GraphQLReactorsOfContentConnection;
import com.facebook.graphql.model.GraphQLReactorsOfContentEdge;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTopLevelCommentsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsEdge;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sampling_rate */
public class FeedbackMutator {
    private static final Comparator f6325a = new C02761();
    private static volatile FeedbackMutator f6326c;
    public final Clock f6327b;

    /* compiled from: sampling_rate */
    final class C02761 implements Comparator<GraphQLTopReactionsEdge> {
        C02761() {
        }

        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((GraphQLTopReactionsEdge) obj2).m27553j(), ((GraphQLTopReactionsEdge) obj).m27553j());
        }
    }

    public static com.facebook.controller.mutation.util.FeedbackMutator m10618a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6326c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.controller.mutation.util.FeedbackMutator.class;
        monitor-enter(r1);
        r0 = f6326c;	 Catch:{ all -> 0x003a }
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
        r0 = m10633b(r0);	 Catch:{ all -> 0x0035 }
        f6326c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6326c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.controller.mutation.util.FeedbackMutator.a(com.facebook.inject.InjectorLike):com.facebook.controller.mutation.util.FeedbackMutator");
    }

    private static FeedbackMutator m10633b(InjectorLike injectorLike) {
        return new FeedbackMutator(SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public FeedbackMutator(Clock clock) {
        this.f6327b = clock;
    }

    private static GraphQLLikersOfContentConnection m10626a(GraphQLLikersOfContentConnection graphQLLikersOfContentConnection, GraphQLActor graphQLActor) {
        Builder builder = ImmutableList.builder();
        ImmutableList j = graphQLLikersOfContentConnection.m22668j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            GraphQLActor graphQLActor2 = (GraphQLActor) j.get(i);
            if (!Objects.equal(graphQLActor2.m23765H(), graphQLActor.m23765H())) {
                builder.m1069c(graphQLActor2);
            }
        }
        GraphQLLikersOfContentConnection.Builder a = GraphQLLikersOfContentConnection.Builder.a(graphQLLikersOfContentConnection).a(graphQLLikersOfContentConnection.mo2914a() - 1);
        a.e = builder.m1068b();
        a = a;
        a.f = GraphQLHelper.m22458a(graphQLLikersOfContentConnection);
        return a.a();
    }

    public static GraphQLFeedback m10624a(GraphQLFeedback graphQLFeedback, GraphQLFeedback graphQLFeedback2) {
        if (graphQLFeedback2 == null || graphQLFeedback == null) {
            return graphQLFeedback;
        }
        GraphQLFeedback.Builder a = GraphQLFeedback.Builder.a(graphQLFeedback);
        a.j(graphQLFeedback2.y_());
        a.B = graphQLFeedback2.m23208B();
        a.W = graphQLFeedback2.m23227U();
        a.S = graphQLFeedback2.m23223Q();
        a.C = GraphQLHelper.m22520o(graphQLFeedback2);
        return a.a();
    }

    public final GraphQLFeedback m10640a(GraphQLFeedback graphQLFeedback, GraphQLActor graphQLActor, boolean z) {
        if (graphQLFeedback == null || graphQLActor == null || GraphQLHelper.m22520o(graphQLFeedback) == null || z == graphQLFeedback.y_()) {
            return graphQLFeedback;
        }
        GraphQLFeedback.Builder a = GraphQLFeedback.Builder.a(graphQLFeedback);
        a.s = this.f6327b.mo211a();
        a.j(z);
        if (!(z && GraphQLHelper.m22520o(graphQLFeedback).m22668j().contains(graphQLActor)) && (z || GraphQLHelper.m22520o(graphQLFeedback).mo2914a() != 0)) {
            GraphQLLikersOfContentConnection o;
            if (z) {
                o = GraphQLHelper.m22520o(graphQLFeedback);
                Builder builder = ImmutableList.builder();
                builder.m1065b(o.m22668j());
                builder.m1069c(graphQLActor);
                GraphQLLikersOfContentConnection.Builder a2 = GraphQLLikersOfContentConnection.Builder.a(o).a(o.mo2914a() + 1);
                a2.e = builder.m1068b();
                GraphQLLikersOfContentConnection.Builder builder2 = a2;
                builder2.f = GraphQLHelper.m22458a(o);
                o = builder2.a();
            } else {
                o = m10626a(GraphQLHelper.m22520o(graphQLFeedback), graphQLActor);
            }
            a.C = o;
        }
        return a.a();
    }

    public final GraphQLFeedback m10639a(@Nullable GraphQLFeedback graphQLFeedback, GraphQLActor graphQLActor) {
        if (graphQLFeedback == null) {
            return graphQLFeedback;
        }
        return m10640a(graphQLFeedback, graphQLActor, !graphQLFeedback.y_());
    }

    public final GraphQLFeedback m10638a(GraphQLActor graphQLActor, GraphQLFeedback graphQLFeedback, FeedbackModel feedbackModel) {
        GraphQLFeedbackReaction graphQLFeedbackReaction;
        ImmutableList j;
        boolean z = false;
        int intValue = FeedbackReaction.m29190a(graphQLFeedback).intValue();
        int a = feedbackModel.n() != null ? feedbackModel.n().a() : 0;
        GraphQLFeedback.Builder a2 = GraphQLFeedback.Builder.a(graphQLFeedback);
        a2.a = graphQLFeedback.w_();
        a2.b = graphQLFeedback.u_();
        a2.s = this.f6327b.mo211a();
        GraphQLFeedback.Builder builder = a2;
        if (a == 1) {
            z = true;
        }
        GraphQLFeedback.Builder j2 = builder.j(z);
        if (a == 0) {
            graphQLFeedbackReaction = null;
        } else {
            GraphQLFeedbackReaction.Builder builder2 = new GraphQLFeedbackReaction.Builder();
            builder2.d = a;
            graphQLFeedbackReaction = builder2.a();
        }
        j2.T = graphQLFeedbackReaction;
        j2.a(a);
        a2.C = GraphQLLikersOfContentConnection.Builder.a(GraphQLHelper.m22520o(graphQLFeedback)).a(feedbackModel.l().a()).a();
        GraphQLReactorsOfContentConnection.Builder builder3 = new GraphQLReactorsOfContentConnection.Builder();
        if (graphQLFeedback.m23211E() != null) {
            j = graphQLFeedback.m23211E().m22676j();
        } else {
            j = RegularImmutableList.f535a;
        }
        builder3.e = m10628a(graphQLActor, j, intValue, a);
        a2.E = builder3.a(feedbackModel.m().a()).a();
        a2.M = m10627a(graphQLFeedback, intValue, a);
        return a2.a();
    }

    private static ImmutableList<GraphQLReactorsOfContentEdge> m10628a(GraphQLActor graphQLActor, ImmutableList<GraphQLReactorsOfContentEdge> immutableList, int i, int i2) {
        Builder builder = new Builder();
        GraphQLReactorsOfContentEdge.Builder builder2;
        if (i != 0 || i2 == 0) {
            int size = immutableList.size();
            for (int i3 = 0; i3 < size; i3++) {
                GraphQLReactorsOfContentEdge graphQLReactorsOfContentEdge = (GraphQLReactorsOfContentEdge) immutableList.get(i3);
                if (!graphQLReactorsOfContentEdge.m27542j().m23765H().equals(graphQLActor.m23765H())) {
                    builder.m1069c(graphQLReactorsOfContentEdge);
                } else if (i2 != 0) {
                    GraphQLReactorsOfContentEdge.Builder builder3 = new GraphQLReactorsOfContentEdge.Builder();
                    builder3.e = graphQLReactorsOfContentEdge.m27542j();
                    builder2 = builder3;
                    builder2.d = m10625a(i2);
                    builder.m1069c(builder2.a());
                }
            }
        } else {
            builder2 = new GraphQLReactorsOfContentEdge.Builder();
            builder2.e = graphQLActor;
            builder2 = builder2;
            builder2.d = m10625a(i2);
            builder.m1069c(builder2.a());
            builder.m1065b((Iterable) immutableList);
        }
        return builder.m1068b();
    }

    private static GraphQLFeedbackReactionInfo m10625a(int i) {
        GraphQLFeedbackReactionInfo.Builder builder = new GraphQLFeedbackReactionInfo.Builder();
        builder.g = i;
        return builder.a();
    }

    private static ImmutableList<GraphQLTopReactionsEdge> m10629a(ImmutableList<GraphQLTopReactionsEdge> immutableList, int i, int i2) {
        if (i == i2) {
            return immutableList;
        }
        Collection linkedList = new LinkedList();
        int size = immutableList.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < size) {
            Object obj;
            int i6;
            GraphQLTopReactionsEdge graphQLTopReactionsEdge = (GraphQLTopReactionsEdge) immutableList.get(i3);
            int m = graphQLTopReactionsEdge.m27550a().m27561m();
            int j = graphQLTopReactionsEdge.m27553j();
            Object obj2 = null;
            if (i == m) {
                j--;
            } else if (i2 == m) {
                j++;
                i5 = 1;
            } else {
                GraphQLTopReactionsEdge graphQLTopReactionsEdge2 = graphQLTopReactionsEdge;
            }
            if (obj2 != null || j <= 0) {
                obj = obj2;
            } else {
                GraphQLTopReactionsEdge.Builder builder = new GraphQLTopReactionsEdge.Builder();
                graphQLTopReactionsEdge.m9958h();
                builder.d = graphQLTopReactionsEdge.m27550a();
                builder.e = graphQLTopReactionsEdge.m27553j();
                BaseModel.Builder.m22419a(builder, graphQLTopReactionsEdge);
                GraphQLTopReactionsEdge.Builder builder2 = builder;
                builder2.e = j;
                obj = builder2.a();
            }
            if (obj != null) {
                linkedList.add(obj);
                i6 = i4 + 1;
            } else {
                i6 = i4;
            }
            i3++;
            i4 = i6;
        }
        if (i5 == 0 && i2 != 0 && i4 < 4) {
            builder2 = new GraphQLTopReactionsEdge.Builder();
            GraphQLFeedbackReactionInfo.Builder builder3 = new GraphQLFeedbackReactionInfo.Builder();
            builder3.g = i2;
            builder2.d = builder3.a();
            builder2 = builder2;
            builder2.e = 1;
            linkedList.add(builder2.a());
        }
        Collections.sort(linkedList, f6325a);
        return ImmutableList.copyOf(linkedList);
    }

    public static GraphQLTopReactionsConnection m10627a(GraphQLFeedback graphQLFeedback, int i, int i2) {
        ImmutableList immutableList;
        if (graphQLFeedback.m23219M() == null || graphQLFeedback.m23219M().m24899a() == null) {
            immutableList = RegularImmutableList.f535a;
        } else {
            immutableList = graphQLFeedback.m23219M().m24899a();
        }
        ImmutableList a = m10629a(immutableList, i, i2);
        GraphQLTopReactionsConnection.Builder builder = new GraphQLTopReactionsConnection.Builder();
        builder.d = a;
        return builder.a();
    }

    public final GraphQLFeedback m10644a(GraphQLFeedback graphQLFeedback, boolean z) {
        if (graphQLFeedback == null) {
            return graphQLFeedback;
        }
        GraphQLFeedback.Builder a = GraphQLFeedback.Builder.a(graphQLFeedback);
        a.s = this.f6327b.mo211a();
        a.m(z);
        return a.a();
    }

    public final GraphQLFeedback m10641a(GraphQLFeedback graphQLFeedback, GraphQLComment graphQLComment) {
        return m10623a(graphQLFeedback, graphQLComment, CommentUpdateType.ADD, false);
    }

    public final GraphQLFeedback m10645b(GraphQLFeedback graphQLFeedback, GraphQLComment graphQLComment) {
        return m10623a(graphQLFeedback, graphQLComment, CommentUpdateType.EDIT, false);
    }

    public final GraphQLFeedback m10647c(GraphQLFeedback graphQLFeedback, GraphQLComment graphQLComment) {
        return m10623a(graphQLFeedback, graphQLComment, CommentUpdateType.ADD_OR_EDIT, false);
    }

    public final GraphQLFeedback m10649d(GraphQLFeedback graphQLFeedback, GraphQLComment graphQLComment) {
        return m10623a(graphQLFeedback, graphQLComment, CommentUpdateType.ADD_OR_EDIT, true);
    }

    private static boolean m10632a(ImmutableList<GraphQLComment> immutableList, GraphQLComment graphQLComment) {
        return immutableList != null && immutableList.contains(graphQLComment);
    }

    private GraphQLFeedback m10623a(GraphQLFeedback graphQLFeedback, GraphQLComment graphQLComment, CommentUpdateType commentUpdateType, boolean z) {
        if (graphQLFeedback == null || graphQLComment == null || GraphQLHelper.m22503e(graphQLFeedback)) {
            return graphQLFeedback;
        }
        if (commentUpdateType.equals(CommentUpdateType.ADD) && m10632a(GraphQLHelper.m22509i(graphQLFeedback), graphQLComment)) {
            return graphQLFeedback;
        }
        if (commentUpdateType.equals(CommentUpdateType.EDIT) && !m10632a(GraphQLHelper.m22509i(graphQLFeedback), graphQLComment)) {
            return graphQLFeedback;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList i = GraphQLHelper.m22509i(graphQLFeedback);
        if (!(z || i.contains(graphQLComment))) {
            builder.m1069c(graphQLComment);
        }
        int size = i.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            GraphQLComment graphQLComment2 = (GraphQLComment) i.get(i2);
            if (!graphQLComment.equals(graphQLComment2)) {
                builder.m1069c(graphQLComment2);
                z3 = z2;
            } else if (z2) {
                z3 = z2;
            } else {
                builder.m1069c(graphQLComment);
                z3 = true;
            }
            i2++;
            z2 = z3;
        }
        if (z && !i.contains(graphQLComment)) {
            builder.m1069c(graphQLComment);
        }
        int size2 = (builder.m1068b().size() - i.size()) + GraphQLHelper.m22504f(graphQLFeedback);
        GraphQLFeedback.Builder a = GraphQLFeedback.Builder.a(graphQLFeedback);
        a.t = true;
        a = a;
        a.s = this.f6327b.mo211a();
        return m10621a(a, builder.m1068b(), size2, GraphQLHelper.m22507h(graphQLFeedback));
    }

    public final GraphQLFeedback m10643a(GraphQLFeedback graphQLFeedback, String str) {
        if (graphQLFeedback == null || str == null || GraphQLHelper.m22504f(graphQLFeedback) == 0) {
            return graphQLFeedback;
        }
        Builder builder = ImmutableList.builder();
        int f = GraphQLHelper.m22504f(graphQLFeedback);
        if (GraphQLHelper.m22509i(graphQLFeedback) != null) {
            ImmutableList i = GraphQLHelper.m22509i(graphQLFeedback);
            int size = i.size();
            for (int i2 = 0; i2 < size; i2++) {
                GraphQLComment graphQLComment = (GraphQLComment) i.get(i2);
                if (!str.equals(graphQLComment.mo2890l().mo2933j())) {
                    builder.m1069c(graphQLComment);
                }
            }
        }
        GraphQLFeedback.Builder a = GraphQLFeedback.Builder.a(graphQLFeedback);
        a.s = this.f6327b.mo211a();
        return m10621a(a, builder.m1068b(), f - 1, GraphQLHelper.m22507h(graphQLFeedback));
    }

    public final GraphQLFeedback m10650e(GraphQLFeedback graphQLFeedback, GraphQLComment graphQLComment) {
        if (graphQLFeedback == null || graphQLComment == null || GraphQLHelper.m22504f(graphQLFeedback) == 0 || GraphQLHelper.m22509i(graphQLFeedback) == null) {
            return graphQLFeedback;
        }
        Builder builder = ImmutableList.builder();
        int f = GraphQLHelper.m22504f(graphQLFeedback);
        ImmutableList i = GraphQLHelper.m22509i(graphQLFeedback);
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            GraphQLComment graphQLComment2 = (GraphQLComment) i.get(i2);
            if (!graphQLComment.equals(graphQLComment2)) {
                builder.m1069c(graphQLComment2);
            }
        }
        GraphQLFeedback.Builder a = GraphQLFeedback.Builder.a(graphQLFeedback);
        a.s = this.f6327b.mo211a();
        return m10621a(a, builder.m1068b(), f - 1, GraphQLHelper.m22507h(graphQLFeedback));
    }

    public final GraphQLFeedback m10642a(GraphQLFeedback graphQLFeedback, @Nullable GraphQLFeedback graphQLFeedback2, CommentLoadDirection commentLoadDirection) {
        Preconditions.checkNotNull(graphQLFeedback);
        if (commentLoadDirection != CommentLoadDirection.LOAD_BEFORE) {
            return m10635e(graphQLFeedback, graphQLFeedback2);
        }
        List i;
        if (graphQLFeedback2 == null || GraphQLHelper.m22506g(graphQLFeedback2) == 0) {
            i = GraphQLHelper.m22509i(graphQLFeedback);
        } else {
            List a = Lists.m1299a(GraphQLHelper.m22509i(graphQLFeedback2).iterator());
            ImmutableList i2 = GraphQLHelper.m22509i(graphQLFeedback);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                GraphQLComment graphQLComment = (GraphQLComment) i2.get(i3);
                if (!a.contains(graphQLComment)) {
                    a.add(a.size(), graphQLComment);
                }
            }
            i = a;
        }
        GraphQLPageInfo.Builder builder = GraphQLHelper.m22507h(graphQLFeedback) == null ? new GraphQLPageInfo.Builder() : GraphQLPageInfo.Builder.m22678a(GraphQLHelper.m22507h(graphQLFeedback));
        if (GraphQLHelper.m22507h(graphQLFeedback2) != null) {
            builder.f15933h = GraphQLHelper.m22507h(graphQLFeedback2).v_();
            builder.f15932g = GraphQLHelper.m22507h(graphQLFeedback2).mo1408c();
        }
        return m10621a(GraphQLFeedback.Builder.a(graphQLFeedback), i, GraphQLHelper.m22504f(graphQLFeedback), builder.m22681a());
    }

    private static GraphQLFeedback m10635e(GraphQLFeedback graphQLFeedback, @Nullable GraphQLFeedback graphQLFeedback2) {
        List i;
        if (graphQLFeedback2 == null || GraphQLHelper.m22506g(graphQLFeedback2) == 0) {
            i = GraphQLHelper.m22509i(graphQLFeedback);
        } else {
            List a = Lists.m1299a(GraphQLHelper.m22509i(graphQLFeedback).iterator());
            ImmutableList i2 = GraphQLHelper.m22509i(graphQLFeedback2);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                GraphQLComment graphQLComment = (GraphQLComment) i2.get(i3);
                if (a.contains(graphQLComment)) {
                    a.set(a.indexOf(graphQLComment), graphQLComment);
                } else {
                    a.add(a.size(), graphQLComment);
                }
            }
            i = a;
        }
        GraphQLPageInfo.Builder builder = GraphQLHelper.m22507h(graphQLFeedback) == null ? new GraphQLPageInfo.Builder() : GraphQLPageInfo.Builder.m22678a(GraphQLHelper.m22507h(graphQLFeedback));
        if (GraphQLHelper.m22507h(graphQLFeedback2) != null) {
            builder.f15930e = GraphQLHelper.m22507h(graphQLFeedback2).mo1405a();
            builder.f15931f = GraphQLHelper.m22507h(graphQLFeedback2).mo1407b();
        }
        return m10621a(GraphQLFeedback.Builder.a(graphQLFeedback), i, GraphQLHelper.m22504f(graphQLFeedback), builder.m22681a());
    }

    public final GraphQLFeedback m10646b(GraphQLFeedback graphQLFeedback, GraphQLFeedback graphQLFeedback2) {
        if (graphQLFeedback2 == null) {
            return graphQLFeedback;
        }
        GraphQLComment graphQLComment;
        ImmutableList i = GraphQLHelper.m22509i(graphQLFeedback);
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            graphQLComment = (GraphQLComment) i.get(i2);
            if (graphQLComment != null && graphQLComment.mo2890l() != null && StringUtil.m3590a(graphQLComment.mo2890l().mo2933j(), graphQLFeedback2.mo2933j())) {
                break;
            }
        }
        graphQLComment = null;
        if (graphQLComment == null) {
            return graphQLFeedback;
        }
        GraphQLComment.Builder a = GraphQLComment.Builder.a(graphQLComment);
        a.o = graphQLFeedback2;
        return m10621a(GraphQLFeedback.Builder.a(graphQLFeedback), m10630a(GraphQLHelper.m22509i(graphQLFeedback), graphQLComment, a.a()), GraphQLHelper.m22504f(graphQLFeedback), GraphQLHelper.m22507h(graphQLFeedback));
    }

    public static GraphQLFeedback m10622a(GraphQLFeedback graphQLFeedback, int i) {
        GraphQLFeedback.Builder builder = new GraphQLFeedback.Builder();
        GraphQLLikersOfContentConnection.Builder builder2 = new GraphQLLikersOfContentConnection.Builder();
        if (graphQLFeedback != null) {
            builder = GraphQLFeedback.Builder.a(graphQLFeedback);
            GraphQLLikersOfContentConnection C = graphQLFeedback.m23209C();
            if (C != null) {
                builder2 = GraphQLLikersOfContentConnection.Builder.a(C);
            }
        }
        builder.C = builder2.a(i).a();
        return builder.a();
    }

    public static GraphQLFeedback m10634b(GraphQLFeedback graphQLFeedback, int i) {
        GraphQLFeedback.Builder builder = new GraphQLFeedback.Builder();
        GraphQLTopLevelCommentsConnection.Builder builder2 = new GraphQLTopLevelCommentsConnection.Builder();
        if (graphQLFeedback != null) {
            builder = GraphQLFeedback.Builder.a(graphQLFeedback);
            GraphQLTopLevelCommentsConnection L = graphQLFeedback.m23218L();
            if (L != null) {
                builder2 = GraphQLTopLevelCommentsConnection.Builder.a(L);
            }
        }
        builder.L = builder2.a(i).a();
        return builder.a();
    }

    public final GraphQLFeedback m10648c(GraphQLFeedback graphQLFeedback, GraphQLFeedback graphQLFeedback2) {
        GraphQLFeedback.Builder a = GraphQLFeedback.Builder.a(graphQLFeedback);
        a.s = this.f6327b.mo211a();
        GraphQLFeedback.Builder builder = a;
        Builder builder2 = new Builder();
        ImmutableList i = GraphQLHelper.m22509i(graphQLFeedback);
        int size = i.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            int i4;
            GraphQLComment graphQLComment = (GraphQLComment) i.get(i2);
            if (GraphQLHelper.m22480a(graphQLFeedback2, graphQLComment)) {
                i4 = i3 + 1;
            } else {
                builder2.m1069c(graphQLComment);
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        return m10621a(builder, builder2.m1068b(), GraphQLHelper.m22504f(graphQLFeedback) - i3, GraphQLHelper.m22507h(graphQLFeedback));
    }

    public static boolean m10631a(GraphQLComment graphQLComment) {
        ImmutableList q = graphQLComment.m27184q();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            GraphQLMedia r = ((GraphQLStoryAttachment) q.get(i)).m23979r();
            if (r != null) {
                GraphQLVideo b = GraphQLMediaConversionHelper.b(r);
                if (b != null && (b.bs() == GraphQLVideoStatusType.ENCODING || b.bs() == GraphQLVideoStatusType.ENCODED || b.bs() == GraphQLVideoStatusType.UPLOADING || b.bs() == GraphQLVideoStatusType.UPLOADED)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public final Result m10636a(GraphQLFeedback graphQLFeedback, GraphQLPage graphQLPage, String str) {
        ImmutableList i = GraphQLHelper.m22509i(graphQLFeedback);
        if (i.isEmpty()) {
            return null;
        }
        GraphQLComment graphQLComment;
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            graphQLComment = (GraphQLComment) i.get(i2);
            if (graphQLComment.m27192y().equals(str)) {
                break;
            }
        }
        graphQLComment = null;
        if (graphQLComment == null) {
            return null;
        }
        GraphQLComment a = m10619a(graphQLComment, graphQLPage);
        List a2 = m10630a(i, graphQLComment, a);
        GraphQLFeedback.Builder a3 = GraphQLFeedback.Builder.a(graphQLFeedback);
        a3.s = this.f6327b.mo211a();
        return new Result(m10621a(a3, a2, GraphQLHelper.m22504f(graphQLFeedback), GraphQLHelper.m22507h(graphQLFeedback)), a);
    }

    public final Result m10637a(GraphQLFeedback graphQLFeedback, String str, String str2, boolean z) {
        ImmutableList i = GraphQLHelper.m22509i(graphQLFeedback);
        if (i.isEmpty()) {
            return null;
        }
        GraphQLComment graphQLComment;
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            graphQLComment = (GraphQLComment) i.get(i2);
            if (graphQLComment.m27192y().equals(str)) {
                break;
            }
        }
        graphQLComment = null;
        if (graphQLComment == null) {
            return null;
        }
        GraphQLComment a = m10620a(graphQLComment, str2, z);
        List a2 = m10630a(i, graphQLComment, a);
        GraphQLFeedback.Builder a3 = GraphQLFeedback.Builder.a(graphQLFeedback);
        a3.s = this.f6327b.mo211a();
        return new Result(m10621a(a3, a2, GraphQLHelper.m22504f(graphQLFeedback), GraphQLHelper.m22507h(graphQLFeedback)), a);
    }

    private static GraphQLComment m10620a(GraphQLComment graphQLComment, String str, boolean z) {
        if (graphQLComment.m27178j() == null || graphQLComment.m27178j().size() != 1) {
            return graphQLComment;
        }
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) graphQLComment.m27178j().get(0);
        GraphQLNode z2 = graphQLStoryAttachment.m23987z();
        GraphQLNode.Builder a = GraphQLNode.Builder.a(z2);
        if (z) {
            BaseModel fu = z2.fu();
            if (fu == null) {
                return graphQLComment;
            }
            Collection a2 = Lists.m1298a(fu.m24656a());
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                if (((GraphQLPlaceListItem) it.next()).k().ae().equals(str)) {
                    it.remove();
                    break;
                }
            }
            GraphQLCommentPlaceInfoToPlaceListItemsConnection.Builder builder = new GraphQLCommentPlaceInfoToPlaceListItemsConnection.Builder();
            fu.m9958h();
            builder.d = fu.m24656a();
            BaseModel.Builder.m22419a(builder, fu);
            GraphQLCommentPlaceInfoToPlaceListItemsConnection.Builder builder2 = builder;
            builder2.d = ImmutableList.copyOf(a2);
            a.gj = builder2.a();
        } else {
            Collection a3 = Lists.m1298a(z2.kJ());
            Iterator it2 = a3.iterator();
            while (it2.hasNext()) {
                if (((GraphQLPage) it2.next()).ae().equals(str)) {
                    it2.remove();
                    break;
                }
            }
            a.ga = ImmutableList.copyOf(a3);
        }
        GraphQLComment.Builder a4 = GraphQLComment.Builder.a(graphQLComment);
        GraphQLStoryAttachment.Builder a5 = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
        a5.t = a.a();
        a4.f = ImmutableList.of(a5.a());
        return a4.a();
    }

    public static GraphQLFeedback m10621a(GraphQLFeedback.Builder builder, List<GraphQLComment> list, int i, GraphQLPageInfo graphQLPageInfo) {
        GraphQLTopLevelCommentsConnection.Builder builder2 = builder.L == null ? new GraphQLTopLevelCommentsConnection.Builder() : GraphQLTopLevelCommentsConnection.Builder.a(builder.L);
        GraphQLTopLevelCommentsConnection.Builder a = builder2.a(i);
        a.e = ImmutableList.copyOf((Collection) list);
        a = a;
        a.f = graphQLPageInfo;
        a.a();
        builder.L = builder2.a();
        return builder.a();
    }

    private static GraphQLComment m10619a(GraphQLComment graphQLComment, GraphQLPage graphQLPage) {
        if (graphQLComment.m27178j() == null || graphQLComment.m27178j().size() != 1) {
            return graphQLComment;
        }
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) graphQLComment.m27178j().get(0);
        GraphQLNode z = graphQLStoryAttachment.m23987z();
        GraphQLNode.Builder a = GraphQLNode.Builder.a(z);
        Collection a2 = Lists.m1298a(z.kJ());
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            if (((GraphQLPage) it.next()).ae().equals(graphQLPage.ae())) {
                it.remove();
                break;
            }
        }
        a.ga = ImmutableList.copyOf(a2);
        GraphQLCommentPlaceInfoToPlaceListItemsConnection fu = z.fu();
        Collection a3 = fu != null ? Lists.m1298a(fu.m24656a()) : new ArrayList();
        GraphQLPlaceListItem.Builder builder = new GraphQLPlaceListItem.Builder();
        builder.e = graphQLPage;
        builder = builder;
        GraphQLPlaceListItemToRecommendingCommentsConnection.Builder builder2 = new GraphQLPlaceListItemToRecommendingCommentsConnection.Builder();
        builder2.d = ImmutableList.of(graphQLComment);
        builder.f = builder2.a();
        a3.add(builder.a());
        GraphQLCommentPlaceInfoToPlaceListItemsConnection.Builder builder3 = new GraphQLCommentPlaceInfoToPlaceListItemsConnection.Builder();
        builder3.d = ImmutableList.copyOf(a3);
        a.gj = builder3.a();
        GraphQLComment.Builder a4 = GraphQLComment.Builder.a(graphQLComment);
        GraphQLStoryAttachment.Builder a5 = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
        a5.t = a.a();
        a4.f = ImmutableList.of(a5.a());
        return a4.a();
    }

    private static ImmutableList<GraphQLComment> m10630a(ImmutableList<GraphQLComment> immutableList, GraphQLComment graphQLComment, GraphQLComment graphQLComment2) {
        if (graphQLComment == null) {
            return immutableList;
        }
        Builder builder = new Builder();
        int size = immutableList.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            GraphQLComment graphQLComment3 = (GraphQLComment) immutableList.get(i);
            if (graphQLComment3 == null || graphQLComment3.mo2890l() == null || !graphQLComment3.mo2890l().equals(graphQLComment.mo2890l())) {
                builder.m1069c(graphQLComment3);
                obj2 = obj;
            } else {
                builder.m1069c(graphQLComment2);
                obj2 = 1;
            }
            i++;
            obj = obj2;
        }
        if (obj == null) {
            builder.m1069c(graphQLComment2);
        }
        return builder.m1068b();
    }
}

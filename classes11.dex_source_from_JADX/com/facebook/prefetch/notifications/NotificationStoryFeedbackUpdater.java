package com.facebook.prefetch.notifications;

import com.facebook.api.ufiservices.common.CommentLoadDirection;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTopLevelCommentsConnection;
import com.facebook.inject.InjectorLike;
import com.facebook.ufiservices.data.DefaultFeedbackCacheProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TAP_ON_CTA */
public class NotificationStoryFeedbackUpdater {
    private static volatile NotificationStoryFeedbackUpdater f10836d;
    private DefaultFeedbackCacheProvider f10837a;
    private FeedbackMutator f10838b;
    private Clock f10839c;

    public static com.facebook.prefetch.notifications.NotificationStoryFeedbackUpdater m11303a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10836d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefetch.notifications.NotificationStoryFeedbackUpdater.class;
        monitor-enter(r1);
        r0 = f10836d;	 Catch:{ all -> 0x003a }
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
        r0 = m11304b(r0);	 Catch:{ all -> 0x0035 }
        f10836d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10836d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefetch.notifications.NotificationStoryFeedbackUpdater.a(com.facebook.inject.InjectorLike):com.facebook.prefetch.notifications.NotificationStoryFeedbackUpdater");
    }

    private static NotificationStoryFeedbackUpdater m11304b(InjectorLike injectorLike) {
        return new NotificationStoryFeedbackUpdater(DefaultFeedbackCacheProvider.a(injectorLike), FeedbackMutator.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NotificationStoryFeedbackUpdater(DefaultFeedbackCacheProvider defaultFeedbackCacheProvider, FeedbackMutator feedbackMutator, Clock clock) {
        this.f10837a = defaultFeedbackCacheProvider;
        this.f10838b = feedbackMutator;
        this.f10839c = clock;
    }

    public final void m11305a(GraphQLStory graphQLStory) {
        while (graphQLStory != null) {
            GraphQLFeedback l = graphQLStory.l();
            if (l != null) {
                l.a(this.f10839c.a());
                GraphQLFeedback b = this.f10837a.b(l.z_());
                if (b != null) {
                    l = m11302a(b, l);
                }
                try {
                    this.f10837a.a(l.z_()).a(new Builder().a(l).a());
                } catch (Throwable e) {
                    BLog.b(getClass(), "Error while updating feedback from notification", e);
                }
            }
            graphQLStory = graphQLStory.L();
        }
    }

    private GraphQLFeedback m11302a(GraphQLFeedback graphQLFeedback, GraphQLFeedback graphQLFeedback2) {
        GraphQLFeedback.Builder a = GraphQLFeedback.Builder.a(this.f10838b.a(graphQLFeedback, graphQLFeedback2, CommentLoadDirection.LOAD_BEFORE));
        a.L = GraphQLTopLevelCommentsConnection.Builder.a(a.L).b(GraphQLHelper.f(graphQLFeedback2)).a();
        a.C = GraphQLLikersOfContentConnection.Builder.a(graphQLFeedback2.C()).a();
        return a.a();
    }
}

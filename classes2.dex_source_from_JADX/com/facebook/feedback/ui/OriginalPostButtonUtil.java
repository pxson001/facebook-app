package com.facebook.feedback.ui;

import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: id */
public class OriginalPostButtonUtil {
    private static volatile OriginalPostButtonUtil f20627c;
    public final QeAccessor f20628a;
    public final NewsfeedAnalyticsLogger f20629b;

    public static com.facebook.feedback.ui.OriginalPostButtonUtil m28370a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20627c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.ui.OriginalPostButtonUtil.class;
        monitor-enter(r1);
        r0 = f20627c;	 Catch:{ all -> 0x003a }
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
        r0 = m28371b(r0);	 Catch:{ all -> 0x0035 }
        f20627c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20627c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.ui.OriginalPostButtonUtil.a(com.facebook.inject.InjectorLike):com.facebook.feedback.ui.OriginalPostButtonUtil");
    }

    private static OriginalPostButtonUtil m28371b(InjectorLike injectorLike) {
        return new OriginalPostButtonUtil(QeInternalImplMethodAutoProvider.m3744a(injectorLike), NewsfeedAnalyticsLogger.m26299b(injectorLike));
    }

    @Inject
    public OriginalPostButtonUtil(QeAccessor qeAccessor, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger) {
        this.f20628a = qeAccessor;
        this.f20629b = newsfeedAnalyticsLogger;
    }

    public final boolean m28374a(FeedProps<GraphQLStory> feedProps) {
        switch (1.a[m28372c(feedProps).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f20628a.mo596a(ExperimentsForFeedbackTestModule.f6810N, false);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return this.f20628a.mo596a(ExperimentsForFeedbackTestModule.f6811O, false);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return this.f20628a.mo596a(ExperimentsForFeedbackTestModule.f6810N, false);
            case 5:
                return this.f20628a.mo596a(ExperimentsForFeedbackTestModule.f6811O, false) || this.f20628a.mo596a(ExperimentsForFeedbackTestModule.f6808L, false);
            default:
                return false;
        }
    }

    public static ReshareTargetType m28372c(FeedProps<GraphQLStory> feedProps) {
        if (feedProps == null) {
            return ReshareTargetType.NONE;
        }
        Flattenable flattenable = feedProps.f13444a;
        if (!(flattenable instanceof GraphQLStory)) {
            return ReshareTargetType.NONE;
        }
        GraphQLStory graphQLStory = (GraphQLStory) flattenable;
        if (StoryHierarchyHelper.m27438e(graphQLStory)) {
            return ReshareTargetType.NONE;
        }
        Flattenable c = feedProps.m19807c();
        if (c != null && !(c instanceof GraphQLStory)) {
            return ReshareTargetType.NONE;
        }
        GraphQLStory graphQLStory2 = (GraphQLStory) c;
        GraphQLStory L = graphQLStory.m22326L();
        long aD = (long) graphQLStory.aD();
        if (graphQLStory2 == null || StoryHierarchyHelper.m27438e(graphQLStory2)) {
            if (L == null) {
                return ReshareTargetType.NONE;
            }
            if (aD == 0) {
                return ReshareTargetType.RESHARE_TOP;
            }
            return ReshareTargetType.AGGREGATE_TOP;
        } else if (graphQLStory2.m22326L() == graphQLStory) {
            return graphQLStory2.aD() > 0 ? ReshareTargetType.AGGREGATE_ORIGINAL_POST : ReshareTargetType.ORIGINAL_POST;
        } else {
            if (graphQLStory2.m22326L() == null) {
                return ReshareTargetType.NONE;
            }
            return ReshareTargetType.AGGREGATE_RESHARE;
        }
    }

    public final SwapStory m28373a(FeedProps<GraphQLStory> feedProps, FeedListType feedListType) {
        FeedListName a = feedListType == null ? null : feedListType.mo2419a();
        if ((a == FeedListName.VIDEO_CHANNEL || a == FeedListName.VIDEO_HOME) && this.f20628a.mo596a(ExperimentsForFeedbackTestModule.f6806J, false)) {
            return new SwapStory(false, feedProps);
        }
        switch (1.a[m28372c(feedProps).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f20628a.mo596a(ExperimentsForFeedbackTestModule.f6805I, false) ? new SwapStory(true, feedProps.m19803a(((GraphQLStory) feedProps.f13444a).m22326L())) : new SwapStory(false, feedProps);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return this.f20628a.mo596a(ExperimentsForFeedbackTestModule.f6804H, false) ? new SwapStory(true, feedProps.f13445b) : new SwapStory(false, feedProps);
            case 3:
                return new SwapStory(false, feedProps);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return this.f20628a.mo596a(ExperimentsForFeedbackTestModule.f6805I, false) ? new SwapStory(true, feedProps.f13445b.m19803a(((GraphQLStory) feedProps.m19807c()).m22326L())) : new SwapStory(false, feedProps);
            case 5:
                if (!this.f20628a.mo596a(ExperimentsForFeedbackTestModule.f6804H, false)) {
                    return new SwapStory(false, feedProps);
                }
                FeedProps feedProps2 = feedProps.f13445b;
                return new SwapStory(true, feedProps2.m19803a((Flattenable) ((GraphQLStory) feedProps2.f13444a).m22321G().m22608j().get(0)));
            default:
                return new SwapStory(false, feedProps);
        }
    }
}

package com.facebook.timeline.units.model;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLTimelineSectionUnitsEdge;
import com.facebook.graphql.model.OrganicImpression;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_instant_articles_saved */
public class TimelineFeedStoryLinkifyUtil {
    private static volatile TimelineFeedStoryLinkifyUtil f12770a;

    public static com.facebook.timeline.units.model.TimelineFeedStoryLinkifyUtil m12730a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f12770a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.timeline.units.model.TimelineFeedStoryLinkifyUtil.class;
        monitor-enter(r1);
        r0 = f12770a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m12729a();	 Catch:{ all -> 0x0034 }
        f12770a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12770a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.units.model.TimelineFeedStoryLinkifyUtil.a(com.facebook.inject.InjectorLike):com.facebook.timeline.units.model.TimelineFeedStoryLinkifyUtil");
    }

    private static TimelineFeedStoryLinkifyUtil m12729a() {
        return new TimelineFeedStoryLinkifyUtil();
    }

    public static void m12731a(@Nullable GraphQLTimelineSection graphQLTimelineSection) {
        if (graphQLTimelineSection != null && graphQLTimelineSection.l() != null && graphQLTimelineSection.l().a() != null) {
            ImmutableList a = graphQLTimelineSection.l().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                FeedUnit j = ((GraphQLTimelineSectionUnitsEdge) a.get(i)).j();
                if (j instanceof GraphQLStory) {
                    OrganicImpression a2 = OrganicImpression.a((GraphQLStory) j);
                    if (a2 != null) {
                        a2.l();
                    }
                }
            }
        }
    }
}

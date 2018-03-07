package com.facebook.timeline.feed;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.timeline.feed.parts.TimelineInvisibleLoadingIndicatorPartDefinition;
import com.facebook.timeline.feed.parts.TimelineLoadingIndicatorPartDefinition;
import com.facebook.timeline.feed.parts.TimelineNoStoriesPartDefinition;
import com.facebook.timeline.feed.parts.TimelinePostsLabelPartDefinition;
import com.facebook.timeline.feed.parts.TimelineScrubberPartDefinition;
import javax.inject.Singleton;

@Singleton
/* compiled from: friends_nearby_more_section_data_load_fail */
public class TimelineFeedPlugInDeclarations implements FeedRowSupportDeclaration {
    private static volatile TimelineFeedPlugInDeclarations f11145a;

    public static com.facebook.timeline.feed.TimelineFeedPlugInDeclarations m11296a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11145a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.timeline.feed.TimelineFeedPlugInDeclarations.class;
        monitor-enter(r1);
        r0 = f11145a;	 Catch:{ all -> 0x0039 }
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
        r0 = m11295a();	 Catch:{ all -> 0x0034 }
        f11145a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11145a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.feed.TimelineFeedPlugInDeclarations.a(com.facebook.inject.InjectorLike):com.facebook.timeline.feed.TimelineFeedPlugInDeclarations");
    }

    private static TimelineFeedPlugInDeclarations m11295a() {
        return new TimelineFeedPlugInDeclarations();
    }

    public final void m11297a(ListItemRowController listItemRowController) {
        listItemRowController.a(TimelineScrubberPartDefinition.f11212a);
        listItemRowController.a(TimelineLoadingIndicatorPartDefinition.f11185a);
        listItemRowController.a(TimelineInvisibleLoadingIndicatorPartDefinition.f11177a);
        listItemRowController.a(TimelineNoStoriesPartDefinition.f11195a);
        listItemRowController.a(TimelinePostsLabelPartDefinition.f11198a);
    }
}

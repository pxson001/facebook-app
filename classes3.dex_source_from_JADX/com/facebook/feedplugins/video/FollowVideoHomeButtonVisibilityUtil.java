package com.facebook.feedplugins.video;

import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryActorHelper;
import javax.inject.Singleton;

@Singleton
/* compiled from: ufi/reactions/v2/16x16/sad */
public class FollowVideoHomeButtonVisibilityUtil {
    private static volatile FollowVideoHomeButtonVisibilityUtil f181a;

    public static com.facebook.feedplugins.video.FollowVideoHomeButtonVisibilityUtil m170a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f181a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feedplugins.video.FollowVideoHomeButtonVisibilityUtil.class;
        monitor-enter(r1);
        r0 = f181a;	 Catch:{ all -> 0x0039 }
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
        r0 = m169a();	 Catch:{ all -> 0x0034 }
        f181a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f181a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.video.FollowVideoHomeButtonVisibilityUtil.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.video.FollowVideoHomeButtonVisibilityUtil");
    }

    private static FollowVideoHomeButtonVisibilityUtil m169a() {
        return new FollowVideoHomeButtonVisibilityUtil();
    }

    public static boolean m171a(boolean z, boolean z2, FeedProps<GraphQLStoryAttachment> feedProps, FollowVideosState followVideosState) {
        if (!z || !z2) {
            return false;
        }
        GraphQLMedia r = ((GraphQLStoryAttachment) feedProps.a).r();
        if (r == null || !r.bb()) {
            return false;
        }
        GraphQLActor aF = r.aF();
        if (aF == null || !aF.ay()) {
            return false;
        }
        GraphQLStory c = AttachmentProps.c(feedProps);
        if (c == null) {
            return false;
        }
        if (StoryActorHelper.b(c) == null) {
            return false;
        }
        if (aF.aB()) {
            return aF.aB() && followVideosState.f274a;
        } else {
            return true;
        }
    }
}

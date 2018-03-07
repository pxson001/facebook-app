package com.facebook.video.followvideos.nux;

import android.view.ViewGroup;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.feed.nux.FeedNuxBubbleManager;
import com.facebook.feed.nux.FeedNuxBubbleManager.BlockingCause;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.controllercallbacks.ScrollCallback;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: storyAttachment or getTarget is null */
public class FollowVideosNuxBubbleController extends BaseController implements ScrollCallback {
    private static volatile FollowVideosNuxBubbleController f2741c;
    public ViewGroup f2742a;
    public FeedNuxBubbleManager f2743b;

    public static com.facebook.video.followvideos.nux.FollowVideosNuxBubbleController m2632a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2741c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.followvideos.nux.FollowVideosNuxBubbleController.class;
        monitor-enter(r1);
        r0 = f2741c;	 Catch:{ all -> 0x003a }
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
        r0 = m2633b(r0);	 Catch:{ all -> 0x0035 }
        f2741c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2741c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.followvideos.nux.FollowVideosNuxBubbleController.a(com.facebook.inject.InjectorLike):com.facebook.video.followvideos.nux.FollowVideosNuxBubbleController");
    }

    private static FollowVideosNuxBubbleController m2633b(InjectorLike injectorLike) {
        return new FollowVideosNuxBubbleController(FeedNuxBubbleManager.a(injectorLike));
    }

    @Inject
    public FollowVideosNuxBubbleController(FeedNuxBubbleManager feedNuxBubbleManager) {
        this.f2743b = feedNuxBubbleManager;
    }

    public final void m2634a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (i == 0) {
            this.f2743b.b(BlockingCause.IS_SCROLLING);
        } else {
            this.f2743b.a(BlockingCause.IS_SCROLLING);
        }
    }

    public final void m2635a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        this.f2743b.b();
    }
}

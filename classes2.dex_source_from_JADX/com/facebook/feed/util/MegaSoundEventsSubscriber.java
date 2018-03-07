package com.facebook.feed.util;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.init.INeedInit;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_invite_banner_android */
public class MegaSoundEventsSubscriber implements INeedInit {
    private static final List<String> f13896a = ImmutableList.of("like_main", "comment", "share", "post_main", "post_comment", "like_comment", "pull_to_refresh", "pull_to_refresh_slow", "pull_to_refresh_medium", "pull_to_refresh_fast", "collapse_after_refresh");
    private static volatile MegaSoundEventsSubscriber f13897k;
    public Lazy<FBSoundUtil> f13898b;
    public FeedEventBus f13899c;
    public FlyoutEventBus f13900d;
    public Provider<FbEventSubscriberListManager> f13901e;
    public FbEventSubscriberListManager f13902f;
    public FbEventSubscriberListManager f13903g;
    public FbEventSubscriberListManager f13904h;
    public BaseFbBroadcastManager f13905i;
    public SelfRegistrableReceiverImpl f13906j;

    public static com.facebook.feed.util.MegaSoundEventsSubscriber m20258a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13897k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.util.MegaSoundEventsSubscriber.class;
        monitor-enter(r1);
        r0 = f13897k;	 Catch:{ all -> 0x003a }
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
        r0 = m20260b(r0);	 Catch:{ all -> 0x0035 }
        f13897k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13897k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.MegaSoundEventsSubscriber.a(com.facebook.inject.InjectorLike):com.facebook.feed.util.MegaSoundEventsSubscriber");
    }

    private static MegaSoundEventsSubscriber m20260b(InjectorLike injectorLike) {
        return new MegaSoundEventsSubscriber(IdBasedSingletonScopeProvider.m1810b(injectorLike, 10994), FeedEventBus.m4573a(injectorLike), FlyoutEventBus.m14086a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), IdBasedProvider.m1811a(injectorLike, 973));
    }

    @Inject
    public MegaSoundEventsSubscriber(Lazy<FBSoundUtil> lazy, FeedEventBus feedEventBus, FlyoutEventBus flyoutEventBus, FbBroadcastManager fbBroadcastManager, Provider<FbEventSubscriberListManager> provider) {
        this.f13898b = lazy;
        this.f13899c = feedEventBus;
        this.f13900d = flyoutEventBus;
        this.f13905i = fbBroadcastManager;
        this.f13901e = provider;
    }

    public static boolean m20259a(String str) {
        return f13896a.contains(str);
    }

    public static void m20261b(MegaSoundEventsSubscriber megaSoundEventsSubscriber, String str) {
        if (m20259a(str)) {
            ((FBSoundUtil) megaSoundEventsSubscriber.f13898b.get()).b(str);
        }
    }

    public void init() {
        this.f13902f = (FbEventSubscriberListManager) this.f13901e.get();
        this.f13903g = (FbEventSubscriberListManager) this.f13901e.get();
        this.f13904h = (FbEventSubscriberListManager) this.f13901e.get();
        this.f13902f.m14133a(new LikeClickSubscriber(this));
        this.f13902f.m14133a(new CommentClickedSubscriber(this));
        this.f13902f.m14133a(new ShareClickedSubscriber(this));
        this.f13902f.m14133a(new PermalinkCommentLikeClickedSubscriber(this));
        this.f13902f.m14133a(new PermalinkCommentPostedSubscriber(this));
        this.f13902f.m14131a(this.f13899c);
        this.f13904h.m14133a(new PullToRefreshSubscriber(this));
        this.f13904h.m14133a(new CollapseRefreshSubscriber(this));
        this.f13904h.m14131a(this.f13899c);
        this.f13903g.m14133a(new CommentLikeClickedSubscriber(this));
        this.f13903g.m14133a(new FlyoutLikeClickedSubscriber(this));
        this.f13903g.m14133a(new CommentPostedSubscriber(this));
        this.f13903g.m14131a(this.f13900d);
        this.f13906j = this.f13905i.m2951a().mo506a("com.facebook.STREAM_PUBLISH_COMPLETE", new 1(this)).mo503a();
        this.f13906j.m3296b();
    }
}

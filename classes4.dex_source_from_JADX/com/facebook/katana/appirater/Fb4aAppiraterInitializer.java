package com.facebook.katana.appirater;

import com.facebook.appirater.Appirater;
import com.facebook.appirater.InternalStarRatingController;
import com.facebook.appirater.InternalStarRatingController.3;
import com.facebook.appirater.InternalStarRatingController.InteractionType;
import com.facebook.common.init.INeedInit;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.util.event.AppiraterEvents$FeedFragmentPausedEvent;
import com.facebook.feed.util.event.AppiraterEvents$FirstFeedScrollEvent;
import com.facebook.feed.util.event.AppiraterEvents.FeedFragmentResumedEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FeedEventSubscriber;
import com.facebook.inject.InjectorLike;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnResumeEventSubscriber;
import javax.inject.Inject;

/* compiled from: multi_buffer */
public class Fb4aAppiraterInitializer implements INeedInit {
    private static volatile Fb4aAppiraterInitializer f7357i;
    private final FeedEventBus f7358a;
    private final FlyoutEventBus f7359b;
    public final Appirater f7360c;
    public final InternalStarRatingController f7361d;
    private final Fb4aFirstFeedScrollSubscriber f7362e = new Fb4aFirstFeedScrollSubscriber(this);
    private final Fb4aFeedFragmentResumedSubscriber f7363f = new Fb4aFeedFragmentResumedSubscriber(this);
    private final Fb4aFeedFragmentPausedSubscriber f7364g = new Fb4aFeedFragmentPausedSubscriber(this);
    private final FlyoutResumeEventSubscriber f7365h = new FlyoutResumeEventSubscriber(this);

    /* compiled from: multi_buffer */
    class Fb4aFirstFeedScrollSubscriber extends FeedEventSubscriber<AppiraterEvents$FirstFeedScrollEvent> {
        final /* synthetic */ Fb4aAppiraterInitializer f7411a;

        public Fb4aFirstFeedScrollSubscriber(Fb4aAppiraterInitializer fb4aAppiraterInitializer) {
            this.f7411a = fb4aAppiraterInitializer;
        }

        public final void m7718b(FbEvent fbEvent) {
            this.f7411a.f7360c.m7687b();
        }

        public final Class<AppiraterEvents$FirstFeedScrollEvent> m7717a() {
            return AppiraterEvents$FirstFeedScrollEvent.class;
        }
    }

    /* compiled from: multi_buffer */
    class Fb4aFeedFragmentResumedSubscriber extends FeedEventSubscriber<FeedFragmentResumedEvent> {
        final /* synthetic */ Fb4aAppiraterInitializer f7412a;

        public Fb4aFeedFragmentResumedSubscriber(Fb4aAppiraterInitializer fb4aAppiraterInitializer) {
            this.f7412a = fb4aAppiraterInitializer;
        }

        public final void m7720b(FbEvent fbEvent) {
            FeedFragmentResumedEvent feedFragmentResumedEvent = (FeedFragmentResumedEvent) fbEvent;
            this.f7412a.f7360c.m7686a(feedFragmentResumedEvent.a);
            this.f7412a.f7361d.m7700a(feedFragmentResumedEvent.a);
        }

        public final Class<FeedFragmentResumedEvent> m7719a() {
            return FeedFragmentResumedEvent.class;
        }
    }

    /* compiled from: multi_buffer */
    class Fb4aFeedFragmentPausedSubscriber extends FeedEventSubscriber<AppiraterEvents$FeedFragmentPausedEvent> {
        final /* synthetic */ Fb4aAppiraterInitializer f7413a;

        public Fb4aFeedFragmentPausedSubscriber(Fb4aAppiraterInitializer fb4aAppiraterInitializer) {
            this.f7413a = fb4aAppiraterInitializer;
        }

        public final void m7722b(FbEvent fbEvent) {
            this.f7413a.f7361d.m7706f();
        }

        public final Class<AppiraterEvents$FeedFragmentPausedEvent> m7721a() {
            return AppiraterEvents$FeedFragmentPausedEvent.class;
        }
    }

    /* compiled from: multi_buffer */
    class FlyoutResumeEventSubscriber extends FlyoutOnResumeEventSubscriber {
        final /* synthetic */ Fb4aAppiraterInitializer f7414a;

        public FlyoutResumeEventSubscriber(Fb4aAppiraterInitializer fb4aAppiraterInitializer) {
            this.f7414a = fb4aAppiraterInitializer;
        }

        public final void m7723b(FbEvent fbEvent) {
            InternalStarRatingController internalStarRatingController = this.f7414a.f7361d;
            switch (3.a[InteractionType.UFI_FLYOUT.ordinal()]) {
                case 1:
                    internalStarRatingController.f7396k = true;
                    return;
                case 2:
                    internalStarRatingController.f7397l = true;
                    return;
                case 3:
                    internalStarRatingController.f7398m = true;
                    return;
                case 4:
                    internalStarRatingController.f7399n = true;
                    return;
                default:
                    return;
            }
        }
    }

    public static com.facebook.katana.appirater.Fb4aAppiraterInitializer m7679a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7357i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.appirater.Fb4aAppiraterInitializer.class;
        monitor-enter(r1);
        r0 = f7357i;	 Catch:{ all -> 0x003a }
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
        r0 = m7680b(r0);	 Catch:{ all -> 0x0035 }
        f7357i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7357i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.appirater.Fb4aAppiraterInitializer.a(com.facebook.inject.InjectorLike):com.facebook.katana.appirater.Fb4aAppiraterInitializer");
    }

    private static Fb4aAppiraterInitializer m7680b(InjectorLike injectorLike) {
        return new Fb4aAppiraterInitializer(Appirater.m7681a(injectorLike), InternalStarRatingController.m7692a(injectorLike), FeedEventBus.a(injectorLike), FlyoutEventBus.a(injectorLike));
    }

    @Inject
    public Fb4aAppiraterInitializer(Appirater appirater, InternalStarRatingController internalStarRatingController, FeedEventBus feedEventBus, FlyoutEventBus flyoutEventBus) {
        this.f7360c = appirater;
        this.f7361d = internalStarRatingController;
        this.f7358a = feedEventBus;
        this.f7359b = flyoutEventBus;
    }

    public void init() {
        this.f7358a.a(this.f7362e);
        this.f7358a.a(this.f7363f);
        this.f7358a.a(this.f7364g);
        this.f7359b.a(this.f7365h);
    }
}

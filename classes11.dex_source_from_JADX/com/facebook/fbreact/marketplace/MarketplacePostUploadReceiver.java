package com.facebook.fbreact.marketplace;

import android.os.Handler;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.fbreact.marketplace.FBMarketplaceComposerBridgeModule.C09281;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadEventSubscriber;
import com.facebook.photos.upload.event.MediaUploadFailedEvent;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_audience_educator_type */
public class MarketplacePostUploadReceiver {
    private static volatile MarketplacePostUploadReceiver f7388h;
    public C09281 f7389a;
    public final MediaSuccessBusSubscriber f7390b = new MediaSuccessBusSubscriber(this);
    public final MediaFailureBusSubscriber f7391c = new MediaFailureBusSubscriber(this);
    public final MediaUploadEventBus f7392d;
    public final Handler f7393e;
    @Nullable
    public String f7394f;
    @Nullable
    public Runnable f7395g;

    /* compiled from: extra_audience_educator_type */
    public class C09351 implements Runnable {
        final /* synthetic */ MarketplacePostUploadReceiver f7385a;

        public C09351(MarketplacePostUploadReceiver marketplacePostUploadReceiver) {
            this.f7385a = marketplacePostUploadReceiver;
        }

        public void run() {
            MarketplacePostUploadReceiver.m8566a(this.f7385a);
        }
    }

    /* compiled from: extra_audience_educator_type */
    class MediaFailureBusSubscriber extends MediaUploadEventSubscriber<MediaUploadFailedEvent> {
        final /* synthetic */ MarketplacePostUploadReceiver f7386a;

        public MediaFailureBusSubscriber(MarketplacePostUploadReceiver marketplacePostUploadReceiver) {
            this.f7386a = marketplacePostUploadReceiver;
        }

        public final void m8562b(FbEvent fbEvent) {
            MediaUploadFailedEvent mediaUploadFailedEvent = (MediaUploadFailedEvent) fbEvent;
            FBMarketplaceComposerBridgeModule.m8549u(this.f7386a.f7389a.f7349a);
            MarketplacePostUploadReceiver.m8566a(this.f7386a);
        }

        public final Class<MediaUploadFailedEvent> m8561a() {
            return MediaUploadFailedEvent.class;
        }
    }

    /* compiled from: extra_audience_educator_type */
    class MediaSuccessBusSubscriber extends MediaUploadEventSubscriber<MediaUploadSuccessEvent> {
        final /* synthetic */ MarketplacePostUploadReceiver f7387a;

        public MediaSuccessBusSubscriber(MarketplacePostUploadReceiver marketplacePostUploadReceiver) {
            this.f7387a = marketplacePostUploadReceiver;
        }

        public final void m8564b(FbEvent fbEvent) {
            MediaUploadSuccessEvent mediaUploadSuccessEvent = (MediaUploadSuccessEvent) fbEvent;
            FBMarketplaceComposerBridgeModule.m8548t(this.f7387a.f7389a.f7349a);
            MarketplacePostUploadReceiver.m8566a(this.f7387a);
        }

        public final Class<MediaUploadSuccessEvent> m8563a() {
            return MediaUploadSuccessEvent.class;
        }
    }

    public static com.facebook.fbreact.marketplace.MarketplacePostUploadReceiver m8565a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7388h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbreact.marketplace.MarketplacePostUploadReceiver.class;
        monitor-enter(r1);
        r0 = f7388h;	 Catch:{ all -> 0x003a }
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
        r0 = m8567b(r0);	 Catch:{ all -> 0x0035 }
        f7388h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7388h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbreact.marketplace.MarketplacePostUploadReceiver.a(com.facebook.inject.InjectorLike):com.facebook.fbreact.marketplace.MarketplacePostUploadReceiver");
    }

    private static MarketplacePostUploadReceiver m8567b(InjectorLike injectorLike) {
        return new MarketplacePostUploadReceiver(MediaUploadEventBus.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public MarketplacePostUploadReceiver(MediaUploadEventBus mediaUploadEventBus, Handler handler) {
        this.f7392d = mediaUploadEventBus;
        this.f7393e = handler;
    }

    public static void m8566a(MarketplacePostUploadReceiver marketplacePostUploadReceiver) {
        marketplacePostUploadReceiver.f7394f = null;
        if (marketplacePostUploadReceiver.f7395g != null) {
            HandlerDetour.a(marketplacePostUploadReceiver.f7393e, marketplacePostUploadReceiver.f7395g);
            marketplacePostUploadReceiver.f7395g = null;
        }
        if (marketplacePostUploadReceiver.f7394f == null) {
            marketplacePostUploadReceiver.f7392d.b(marketplacePostUploadReceiver.f7390b);
            marketplacePostUploadReceiver.f7392d.b(marketplacePostUploadReceiver.f7391c);
        }
    }
}

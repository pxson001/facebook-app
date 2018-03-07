package com.facebook.api.feedcache;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbVpvOmnistoreSyncRequest;
import com.facebook.api.feedcache.omnistore.FeedUnitUpdateSubscriber;
import com.facebook.api.feedcache.omnistore.VpvUpdateSubscriber;
import com.facebook.api.feedcache.omnistore.annotations.IsOmnistorePrivacyUpdateEnable;
import com.facebook.api.feedcache.omnistore.annotations.IsOmnistoreVpvUpdateEnable;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.base.broadcast.BackgroundBroadcastThread;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.INeedInit;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.omnistore.Omnistore;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_dup_media_fbid_returned */
public class OmnistoreUpdateInitializer implements IHaveUserData, INeedInit {
    private static volatile OmnistoreUpdateInitializer f8001m;
    public final Provider<FeedUnitUpdateSubscriber> f8002a;
    public final Provider<VpvUpdateSubscriber> f8003b;
    @IsOmnistorePrivacyUpdateEnable
    public final Provider<Boolean> f8004c;
    @IsOmnistoreVpvUpdateEnable
    public final Provider<Boolean> f8005d;
    public final FbAppType f8006e;
    public final String f8007f;
    private final Provider<FeedUnitUpdateReceivedCallback> f8008g;
    private final Provider<VpvUpdateReceivedCallback> f8009h;
    private final ActionReceiver f8010i = new C03921(this);
    @BackgroundBroadcastThread
    private final Handler f8011j;
    private final BaseFbBroadcastManager f8012k;
    public final FeedDbMutationService f8013l;

    /* compiled from: messenger_dup_media_fbid_returned */
    class C03921 implements ActionReceiver {
        final /* synthetic */ OmnistoreUpdateInitializer f8014a;

        C03921(OmnistoreUpdateInitializer omnistoreUpdateInitializer) {
            this.f8014a = omnistoreUpdateInitializer;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -628300420);
            this.f8014a.f8013l.a(new FeedDbVpvOmnistoreSyncRequest());
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1402665628, a);
        }
    }

    public static com.facebook.api.feedcache.OmnistoreUpdateInitializer m8321a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8001m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.OmnistoreUpdateInitializer.class;
        monitor-enter(r1);
        r0 = f8001m;	 Catch:{ all -> 0x003a }
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
        r0 = m8322b(r0);	 Catch:{ all -> 0x0035 }
        f8001m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8001m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.OmnistoreUpdateInitializer.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.OmnistoreUpdateInitializer");
    }

    private static OmnistoreUpdateInitializer m8322b(InjectorLike injectorLike) {
        return new OmnistoreUpdateInitializer(IdBasedProvider.a(injectorLike, 248), IdBasedProvider.a(injectorLike, 249), IdBasedProvider.a(injectorLike, 3894), IdBasedProvider.a(injectorLike, 3895), (FbAppType) injectorLike.getInstance(FbAppType.class), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 4800), IdBasedProvider.a(injectorLike, 4801), Handler_BackgroundBroadcastThreadMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), FeedDbMutationService.a(injectorLike));
    }

    @Inject
    public OmnistoreUpdateInitializer(Provider<FeedUnitUpdateSubscriber> provider, Provider<VpvUpdateSubscriber> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, FbAppType fbAppType, String str, Provider<FeedUnitUpdateReceivedCallback> provider5, Provider<VpvUpdateReceivedCallback> provider6, Handler handler, FbBroadcastManager fbBroadcastManager, FeedDbMutationService feedDbMutationService) {
        this.f8002a = provider;
        this.f8003b = provider2;
        this.f8004c = provider3;
        this.f8005d = provider4;
        this.f8006e = fbAppType;
        this.f8007f = str;
        this.f8008g = provider5;
        this.f8009h = provider6;
        this.f8011j = handler;
        this.f8012k = fbBroadcastManager;
        this.f8013l = feedDbMutationService;
    }

    public void init() {
        Object obj;
        if (this.f8007f == null || "0".equals(this.f8007f)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null && Product.FB4A == this.f8006e.j) {
            if (((Boolean) this.f8004c.get()).booleanValue()) {
                FeedUnitUpdateReceivedCallback feedUnitUpdateReceivedCallback = (FeedUnitUpdateReceivedCallback) this.f8008g.get();
                ((Omnistore) feedUnitUpdateReceivedCallback.c.get()).addDeltaReceivedCallback(feedUnitUpdateReceivedCallback);
            } else {
                ((FeedUnitUpdateSubscriber) this.f8002a.get()).m9923a();
            }
            if (((Boolean) this.f8005d.get()).booleanValue()) {
                VpvUpdateReceivedCallback vpvUpdateReceivedCallback = (VpvUpdateReceivedCallback) this.f8009h.get();
                ((Omnistore) vpvUpdateReceivedCallback.a.get()).addDeltaReceivedCallback(vpvUpdateReceivedCallback);
                this.f8012k.a().a(AppStateManager.c, this.f8010i).a(this.f8011j).a().b();
                return;
            }
            ((VpvUpdateSubscriber) this.f8003b.get()).m10110a();
        }
    }

    public void clearUserData() {
        if (Product.FB4A == this.f8006e.j && !((Boolean) this.f8004c.get()).booleanValue()) {
            ((FeedUnitUpdateSubscriber) this.f8002a.get()).m9923a();
        }
        if (Product.FB4A == this.f8006e.j && !((Boolean) this.f8005d.get()).booleanValue()) {
            ((VpvUpdateSubscriber) this.f8003b.get()).m10110a();
        }
    }
}

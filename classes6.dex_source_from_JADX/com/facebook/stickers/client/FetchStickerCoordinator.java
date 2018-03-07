package com.facebook.stickers.client;

import android.os.Bundle;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.service.FetchStickersParams;
import com.facebook.stickers.service.FetchStickersParams.StickersUpdateOperation;
import com.facebook.stickers.service.FetchStickersResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ListMultimap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: encoderOutputBuffer %s was null */
public class FetchStickerCoordinator {
    public static final Class<?> f16429a = FetchStickerCoordinator.class;
    private static volatile FetchStickerCoordinator f16430h;
    public final DefaultBlueServiceOperationFactory f16431b;
    private final ScheduledExecutorService f16432c;
    public final Object f16433d = new Object();
    @GuardedBy("mFutureLock")
    public final ListMultimap<String, SettableFuture<Sticker>> f16434e;
    @GuardedBy("mFutureLock")
    private boolean f16435f;
    private final Runnable f16436g = new C11491(this);

    /* compiled from: encoderOutputBuffer %s was null */
    class C11491 implements Runnable {
        final /* synthetic */ FetchStickerCoordinator f16426a;

        C11491(FetchStickerCoordinator fetchStickerCoordinator) {
            this.f16426a = fetchStickerCoordinator;
        }

        public void run() {
            ListMultimap b;
            synchronized (this.f16426a.f16433d) {
                this.f16426a.f16435f = false;
                b = ArrayListMultimap.b(this.f16426a.f16434e);
                this.f16426a.f16434e.g();
            }
            FetchStickerCoordinator.m23914a(this.f16426a, b);
        }
    }

    public static com.facebook.stickers.client.FetchStickerCoordinator m23913a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16430h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.client.FetchStickerCoordinator.class;
        monitor-enter(r1);
        r0 = f16430h;	 Catch:{ all -> 0x003a }
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
        r0 = m23917b(r0);	 Catch:{ all -> 0x0035 }
        f16430h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16430h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.client.FetchStickerCoordinator.a(com.facebook.inject.InjectorLike):com.facebook.stickers.client.FetchStickerCoordinator");
    }

    private static FetchStickerCoordinator m23917b(InjectorLike injectorLike) {
        return new FetchStickerCoordinator(DefaultBlueServiceOperationFactory.b(injectorLike), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    FetchStickerCoordinator(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ScheduledExecutorService scheduledExecutorService) {
        this.f16431b = defaultBlueServiceOperationFactory;
        this.f16432c = scheduledExecutorService;
        this.f16434e = ArrayListMultimap.t();
    }

    public final ListenableFuture<Sticker> m23918a(String str) {
        SettableFuture f = SettableFuture.f();
        m23915a(str, f);
        return f;
    }

    private void m23915a(String str, SettableFuture<Sticker> settableFuture) {
        synchronized (this.f16433d) {
            this.f16434e.a(str, settableFuture);
            if (this.f16435f) {
                return;
            }
            this.f16435f = true;
            this.f16432c.schedule(this.f16436g, 50, TimeUnit.MILLISECONDS);
        }
    }

    public static void m23914a(FetchStickerCoordinator fetchStickerCoordinator, final ListMultimap listMultimap) {
        ImmutableList copyOf = ImmutableList.copyOf(listMultimap.p());
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickersParams", new FetchStickersParams(copyOf, StickersUpdateOperation.DO_NOT_UPDATE_IF_CACHED));
        Futures.a(BlueServiceOperationFactoryDetour.a(fetchStickerCoordinator.f16431b, "fetch_stickers", bundle, -461419545).a(), new OperationResultFutureCallback(fetchStickerCoordinator) {
            final /* synthetic */ FetchStickerCoordinator f16428b;

            public final void m23912a(Object obj) {
                ImmutableList immutableList = ((FetchStickersResult) ((OperationResult) obj).h()).a;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    Sticker sticker = (Sticker) immutableList.get(i);
                    List<SettableFuture> a = listMultimap.a(sticker.f4938a);
                    if (a != null) {
                        for (SettableFuture a2 : a) {
                            FutureDetour.a(a2, sticker, -1682253136);
                        }
                    }
                    listMultimap.b(sticker.f4938a);
                }
                if (!listMultimap.n()) {
                    BLog.a(FetchStickerCoordinator.f16429a, "did not receive results for stickers: %s", new Object[]{listMultimap.p()});
                }
                for (SettableFuture a3 : listMultimap.i()) {
                    a3.a(new RuntimeException("Failed to fetch sticker"));
                }
            }

            protected final void m23911a(ServiceException serviceException) {
                BLog.b(FetchStickerCoordinator.f16429a, "Error fetching stickers", serviceException);
                for (SettableFuture a : listMultimap.i()) {
                    a.a(new RuntimeException("Failed to fetch sticker"));
                }
            }
        }, fetchStickerCoordinator.f16432c);
    }
}

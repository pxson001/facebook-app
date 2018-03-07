package com.facebook.stickers.client;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OnProgressListener;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.stickers.service.FetchStickerPacksResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: enable_photo_uploads */
public class StickerDownloadManager implements IHaveUserData {
    public static final CallerContext f16451a = CallerContext.a(StickerDownloadManager.class, "sticker_download_manager");
    public static final Class<?> f16452b = StickerDownloadManager.class;
    private static volatile StickerDownloadManager f16453i;
    public final DefaultBlueServiceOperationFactory f16454c;
    public final ExecutorService f16455d;
    public final BaseFbBroadcastManager f16456e;
    private final FbSharedPreferences f16457f;
    public final HashMap<String, FutureAndCallbackHolder> f16458g = new HashMap();
    public final HashMap<String, Integer> f16459h = new HashMap();

    /* compiled from: enable_photo_uploads */
    public class C11521 implements AsyncFunction<OperationResult, Object> {
        final /* synthetic */ StickerPack f16443a;
        final /* synthetic */ StickerDownloadManager f16444b;

        public C11521(StickerDownloadManager stickerDownloadManager, StickerPack stickerPack) {
            this.f16444b = stickerDownloadManager;
            this.f16443a = stickerPack;
        }

        public final ListenableFuture m23927a(Object obj) {
            ImmutableList immutableList = (ImmutableList) ((FetchStickerPacksResult) ((OperationResult) obj).h()).b.get();
            ArrayList arrayList = new ArrayList();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                StickerPack stickerPack = (StickerPack) immutableList.get(i);
                if (!stickerPack.f4955a.equals(this.f16443a.f4955a)) {
                    arrayList.add(stickerPack);
                }
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("stickerPacks", arrayList);
            bundle.putParcelableArrayList("deletedStickerPacks", Lists.a(new StickerPack[]{this.f16443a}));
            return BlueServiceOperationFactoryDetour.a(this.f16444b.f16454c, "set_downloaded_sticker_packs", bundle, ErrorPropagation.BY_EXCEPTION, StickerDownloadManager.f16451a, 771707034).a();
        }
    }

    /* compiled from: enable_photo_uploads */
    public class C11543 extends OnProgressListener {
        final /* synthetic */ StickerPack f16447a;
        final /* synthetic */ StickerDownloadManager f16448b;

        public C11543(StickerDownloadManager stickerDownloadManager, StickerPack stickerPack) {
            this.f16448b = stickerDownloadManager;
            this.f16447a = stickerPack;
        }

        public final void m23930a(OperationResult operationResult) {
            int ceil = (int) Math.ceil(Double.parseDouble(operationResult.c) * 100.0d);
            this.f16448b.f16459h.put(this.f16447a.f4955a, Integer.valueOf(ceil));
            Intent intent = new Intent("com.facebook.orca.stickers.DOWNLOAD_PROGRESS");
            intent.putExtra("stickerPack", this.f16447a);
            intent.putExtra("progress", ceil);
            this.f16448b.f16456e.a(intent);
        }
    }

    /* compiled from: enable_photo_uploads */
    public class C11554 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ StickerPack f16449a;
        final /* synthetic */ StickerDownloadManager f16450b;

        protected final void m23931a(Object obj) {
            Class cls = StickerDownloadManager.f16452b;
            String str = this.f16449a.f4955a;
            StickerDownloadManager.m23934a(this.f16450b, true, this.f16449a);
        }

        public C11554(StickerDownloadManager stickerDownloadManager, StickerPack stickerPack) {
            this.f16450b = stickerDownloadManager;
            this.f16449a = stickerPack;
        }

        protected final void m23932a(Throwable th) {
            BLog.b(StickerDownloadManager.f16452b, th, "Unable to download sticker pack %s", new Object[]{this.f16449a.f4955a});
            StickerDownloadManager.m23934a(this.f16450b, true, this.f16449a);
        }

        public final void jc_() {
            super.jc_();
            BLog.b(StickerDownloadManager.f16452b, "Image download for pack %s cancelled.", new Object[]{this.f16449a.f4955a});
            StickerDownloadManager.m23934a(this.f16450b, false, this.f16449a);
        }
    }

    public static com.facebook.stickers.client.StickerDownloadManager m23933a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16453i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.client.StickerDownloadManager.class;
        monitor-enter(r1);
        r0 = f16453i;	 Catch:{ all -> 0x003a }
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
        r0 = m23935b(r0);	 Catch:{ all -> 0x0035 }
        f16453i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16453i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.client.StickerDownloadManager.a(com.facebook.inject.InjectorLike):com.facebook.stickers.client.StickerDownloadManager");
    }

    private static StickerDownloadManager m23935b(InjectorLike injectorLike) {
        return new StickerDownloadManager(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public StickerDownloadManager(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, BaseFbBroadcastManager baseFbBroadcastManager, FbSharedPreferences fbSharedPreferences) {
        this.f16454c = defaultBlueServiceOperationFactory;
        this.f16455d = executorService;
        this.f16456e = baseFbBroadcastManager;
        this.f16457f = fbSharedPreferences;
    }

    public final void m23936a(final StickerPack stickerPack) {
        if (m23937c(stickerPack)) {
            BLog.a(f16452b, "Can't start download--download for this pack is already in progress.");
            return;
        }
        Intent intent = new Intent("com.facebook.orca.stickers.DOWNLOAD_QUEUED");
        intent.putExtra("stickerPack", stickerPack);
        this.f16456e.a(intent);
        Bundle bundle = new Bundle();
        bundle.putParcelable("stickerPack", stickerPack);
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f16454c, "add_sticker_pack", bundle, ErrorPropagation.BY_EXCEPTION, f16451a, -234339258).a();
        C11532 c11532 = new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ StickerDownloadManager f16446b;

            protected final void m23928a(Object obj) {
                Class cls = StickerDownloadManager.f16452b;
                String str = stickerPack.f4955a;
                Intent intent = new Intent("com.facebook.orca.stickers.ADD_SUCCESS");
                intent.putExtra("stickerPack", stickerPack);
                this.f16446b.f16456e.a(intent);
                StickerDownloadManager stickerDownloadManager = this.f16446b;
                StickerPack stickerPack = stickerPack;
                Bundle bundle = new Bundle();
                bundle.putParcelable("stickerPack", stickerPack);
                Operation a = BlueServiceOperationFactoryDetour.a(stickerDownloadManager.f16454c, "download_sticker_pack_assets", bundle, ErrorPropagation.BY_EXCEPTION, StickerDownloadManager.f16451a, -159595506);
                a.a(new C11543(stickerDownloadManager, stickerPack));
                OperationFuture a2 = a.a();
                C11554 c11554 = new C11554(stickerDownloadManager, stickerPack);
                Futures.a(a2, c11554, stickerDownloadManager.f16455d);
                stickerDownloadManager.f16458g.put(stickerPack.f4955a, FutureAndCallbackHolder.a(a2, c11554));
            }

            protected final void m23929a(Throwable th) {
                BLog.b(StickerDownloadManager.f16452b, th, "Unable to add sticker pack %s", new Object[]{stickerPack.f4955a});
                StickerDownloadManager.m23934a(this.f16446b, false, stickerPack);
            }

            public final void jc_() {
                super.jc_();
                BLog.b(StickerDownloadManager.f16452b, "Add sticker pack operation for pack %s cancelled.", new Object[]{stickerPack.f4955a});
                StickerDownloadManager.m23934a(this.f16446b, false, stickerPack);
            }
        };
        Futures.a(a, c11532, this.f16455d);
        this.f16458g.put(stickerPack.f4955a, FutureAndCallbackHolder.a(a, c11532));
    }

    public final boolean m23937c(StickerPack stickerPack) {
        return this.f16458g.get(stickerPack.f4955a) != null;
    }

    public final int m23938d(StickerPack stickerPack) {
        return this.f16459h.containsKey(stickerPack.f4955a) ? ((Integer) this.f16459h.get(stickerPack.f4955a)).intValue() : 0;
    }

    public static void m23934a(StickerDownloadManager stickerDownloadManager, boolean z, StickerPack stickerPack) {
        Intent intent;
        stickerDownloadManager.f16457f.edit().putBoolean(StickerPrefKeys.i, true).commit();
        String str = stickerPack.f4955a;
        stickerDownloadManager.f16458g.remove(str);
        stickerDownloadManager.f16459h.remove(str);
        if (z) {
            intent = new Intent("com.facebook.orca.stickers.DOWNLOAD_SUCCESS");
        } else {
            intent = new Intent("com.facebook.orca.stickers.DOWNLOAD_FAILURE");
        }
        intent.putExtra("stickerPack", stickerPack);
        stickerDownloadManager.f16456e.a(intent);
    }

    public void clearUserData() {
        for (FutureAndCallbackHolder a : this.f16458g.values()) {
            a.a(true);
        }
        this.f16458g.clear();
        this.f16459h.clear();
    }
}

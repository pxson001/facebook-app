package com.facebook.minipreview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: third_party_logging_urls */
public class MiniPreviewGenerator {
    private static volatile MiniPreviewGenerator f1625e;
    private final ListeningExecutorService f1626a;
    public final DefaultAndroidThreadUtil f1627b;
    private final Lazy<FbErrorReporter> f1628c;
    private final Resources f1629d;

    public static com.facebook.minipreview.MiniPreviewGenerator m1812a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1625e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.minipreview.MiniPreviewGenerator.class;
        monitor-enter(r1);
        r0 = f1625e;	 Catch:{ all -> 0x003a }
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
        r0 = m1813b(r0);	 Catch:{ all -> 0x0035 }
        f1625e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1625e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.minipreview.MiniPreviewGenerator.a(com.facebook.inject.InjectorLike):com.facebook.minipreview.MiniPreviewGenerator");
    }

    private static MiniPreviewGenerator m1813b(InjectorLike injectorLike) {
        return new MiniPreviewGenerator(DefaultAndroidThreadUtil.b(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MiniPreviewGenerator(AndroidThreadUtil androidThreadUtil, ListeningExecutorService listeningExecutorService, Lazy<FbErrorReporter> lazy, Resources resources) {
        this.f1627b = androidThreadUtil;
        this.f1626a = listeningExecutorService;
        this.f1628c = lazy;
        this.f1629d = resources;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.common.annotations.VisibleForTesting
    final byte[] m1814a(java.lang.String r7) {
        /*
        r6 = this;
        r1 = 0;
        r0 = r6.f1629d;	 Catch:{ IOException -> 0x0039, all -> 0x0052 }
        r2 = 2131165222; // 0x7f070026 float:1.7944655E38 double:1.052935522E-314;
        r1 = r0.openRawResource(r2);	 Catch:{ IOException -> 0x0039, all -> 0x0052 }
        r0 = 0;
        r0 = android.util.Base64.decode(r7, r0);	 Catch:{ IOException -> 0x0054, all -> 0x0052 }
        r2 = r0.length;	 Catch:{ IOException -> 0x0054, all -> 0x0052 }
        r2 = r2 + -3;
        r2 = r2 + 607;
        r2 = new byte[r2];	 Catch:{ IOException -> 0x0054, all -> 0x0052 }
        r3 = 0;
        r4 = 607; // 0x25f float:8.5E-43 double:3.0E-321;
        r1.read(r2, r3, r4);	 Catch:{ IOException -> 0x0054, all -> 0x0052 }
        r3 = 162; // 0xa2 float:2.27E-43 double:8.0E-322;
        r4 = 1;
        r4 = r0[r4];	 Catch:{ IOException -> 0x0054, all -> 0x0052 }
        r2[r3] = r4;	 Catch:{ IOException -> 0x0054, all -> 0x0052 }
        r3 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r4 = 2;
        r4 = r0[r4];	 Catch:{ IOException -> 0x0054, all -> 0x0052 }
        r2[r3] = r4;	 Catch:{ IOException -> 0x0054, all -> 0x0052 }
        r3 = 3;
        r4 = 607; // 0x25f float:8.5E-43 double:3.0E-321;
        r5 = r0.length;	 Catch:{ IOException -> 0x0054, all -> 0x0052 }
        r5 = r5 + -3;
        java.lang.System.arraycopy(r0, r3, r2, r4, r5);	 Catch:{ IOException -> 0x0054, all -> 0x0052 }
        if (r1 == 0) goto L_0x0038;
    L_0x0035:
        r1.close();
    L_0x0038:
        return r2;
    L_0x0039:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
    L_0x003c:
        r0 = r6.f1628c;	 Catch:{ all -> 0x004a }
        r0 = r0.get();	 Catch:{ all -> 0x004a }
        r0 = (com.facebook.common.errorreporting.AbstractFbErrorReporter) r0;	 Catch:{ all -> 0x004a }
        r3 = "mini_preview_generator";
        r0.a(r3, r1);	 Catch:{ all -> 0x004a }
        throw r1;	 Catch:{ all -> 0x004a }
    L_0x004a:
        r0 = move-exception;
        r1 = r2;
    L_0x004c:
        if (r1 == 0) goto L_0x0051;
    L_0x004e:
        r1.close();
    L_0x0051:
        throw r0;
    L_0x0052:
        r0 = move-exception;
        goto L_0x004c;
    L_0x0054:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.minipreview.MiniPreviewGenerator.a(java.lang.String):byte[]");
    }

    public final ListenableFuture<Bitmap> m1815b(final String str) {
        return this.f1626a.a(new Callable<Bitmap>(this) {
            final /* synthetic */ MiniPreviewGenerator f1624b;

            public Object call() {
                this.f1624b.f1627b.b();
                TracerDetour.a("decodePayload", -231495871);
                try {
                    byte[] a = this.f1624b.m1814a(str);
                    Options options = new Options();
                    options.inMutable = true;
                    Object decodeByteArray = BitmapFactory.decodeByteArray(a, 0, a.length, options);
                    return decodeByteArray;
                } finally {
                    TracerDetour.a(-1861910278);
                }
            }
        });
    }
}

package com.facebook.minipreview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.images.effects.Blur;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: throwback_permalink */
public class MiniPreviewCoverPhotoProcessor {
    private static volatile MiniPreviewCoverPhotoProcessor f1619d;
    protected final MiniPreviewGenerator f1620a;
    private final ScreenUtil f1621b;
    private final Executor f1622c;

    public static com.facebook.minipreview.MiniPreviewCoverPhotoProcessor m1807a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1619d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.minipreview.MiniPreviewCoverPhotoProcessor.class;
        monitor-enter(r1);
        r0 = f1619d;	 Catch:{ all -> 0x003a }
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
        r0 = m1808b(r0);	 Catch:{ all -> 0x0035 }
        f1619d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1619d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.minipreview.MiniPreviewCoverPhotoProcessor.a(com.facebook.inject.InjectorLike):com.facebook.minipreview.MiniPreviewCoverPhotoProcessor");
    }

    private static MiniPreviewCoverPhotoProcessor m1808b(InjectorLike injectorLike) {
        return new MiniPreviewCoverPhotoProcessor(ScreenUtil.a(injectorLike), MiniPreviewGenerator.m1812a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MiniPreviewCoverPhotoProcessor(ScreenUtil screenUtil, MiniPreviewGenerator miniPreviewGenerator, Executor executor) {
        this.f1621b = screenUtil;
        this.f1620a = miniPreviewGenerator;
        this.f1622c = executor;
    }

    public final ListenableFuture<Drawable> m1810a(String str, float f) {
        return mo435a(str, 5, 1.1f, 1.1f, 0.1f, f);
    }

    protected ListenableFuture<Drawable> mo435a(String str, int i, float f, float f2, float f3, float f4) {
        final int i2 = i;
        final float f5 = f;
        final float f6 = f2;
        final float f7 = f3;
        final float f8 = f4;
        return Futures.a(this.f1620a.m1815b(str), new Function<Bitmap, Drawable>(this) {
            final /* synthetic */ MiniPreviewCoverPhotoProcessor f1618f;

            public Object apply(Object obj) {
                return this.f1618f.m1809a((Bitmap) obj, i2, f5, f6, f7, f8);
            }
        }, this.f1622c);
    }

    protected final Drawable m1809a(Bitmap bitmap, int i, float f, float f2, float f3, float f4) {
        TracerDetour.a("blur", -2028975058);
        Blur.m11215b(bitmap, i);
        TracerDetour.a(1622887197);
        TracerDetour.a("scale_saturate", 1552148467);
        Drawable a = m1806a(bitmap, f, f2, f3, f4);
        TracerDetour.a(-1505217182);
        bitmap.recycle();
        return a;
    }

    private Drawable m1806a(Bitmap bitmap, float f, float f2, float f3, float f4) {
        float f5 = 1.0f;
        Resources system = Resources.getSystem();
        int max = Math.max(bitmap.getWidth(), this.f1621b.c() / 10);
        int max2 = Math.max(bitmap.getHeight(), Math.round(((float) max) / f4));
        if (max > bitmap.getWidth() || max2 > bitmap.getHeight()) {
            f5 = Math.min((((float) max) * 1.0f) / ((float) bitmap.getWidth()), (1.0f * ((float) max2)) / ((float) bitmap.getHeight()));
            max2 = (int) ((((float) bitmap.getWidth()) * f5) + 0.5f);
            max = (int) ((((float) bitmap.getHeight()) * f5) + 0.5f);
        } else {
            max2 = bitmap.getWidth();
            max = bitmap.getHeight();
        }
        TracerDetour.a("createBitmap", 1604519202);
        Bitmap createBitmap = Bitmap.createBitmap(max2, max, Config.ARGB_8888);
        TracerDetour.a(-1954963219);
        Canvas canvas = new Canvas(createBitmap);
        canvas.scale(f5, f5);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, m1805a(f, f2, f3));
        return new BitmapDrawable(system, createBitmap);
    }

    private Paint m1805a(float f, float f2, float f3) {
        Paint paint = new Paint(3);
        int i = 0;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(f);
        Object array = colorMatrix.getArray();
        Object obj = new float[20];
        System.arraycopy(array, 0, obj, 0, array.length);
        while (i < 15) {
            obj[i] = obj[i] * f2;
            i++;
        }
        obj[4] = obj[4] + f3;
        obj[9] = obj[9] + f3;
        obj[14] = obj[14] + f3;
        colorMatrix.set(obj);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        return paint;
    }
}

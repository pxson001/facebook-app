package com.facebook.reviews.binder;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.SparseIntArray;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.util.SpannableUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.InjectorLike;
import com.facebook.reviews.ui.BarChart;
import com.facebook.reviews.ui.BarChart.BarChartItem;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: UNSUPPORTED_COMPONENT_STYLE */
public class StarRatingBarChartBinder {
    private static final int[] f21411a = new int[]{2131361968, 2131361967, 2131361965, 2131361964, 2131361917};
    private static volatile StarRatingBarChartBinder f21412d;
    public final GlyphColorizer f21413b;
    private final Resources f21414c;

    public static com.facebook.reviews.binder.StarRatingBarChartBinder m25045a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21412d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.binder.StarRatingBarChartBinder.class;
        monitor-enter(r1);
        r0 = f21412d;	 Catch:{ all -> 0x003a }
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
        r0 = m25046b(r0);	 Catch:{ all -> 0x0035 }
        f21412d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21412d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.binder.StarRatingBarChartBinder.a(com.facebook.inject.InjectorLike):com.facebook.reviews.binder.StarRatingBarChartBinder");
    }

    private static StarRatingBarChartBinder m25046b(InjectorLike injectorLike) {
        return new StarRatingBarChartBinder(GlyphColorizer.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StarRatingBarChartBinder(GlyphColorizer glyphColorizer, Resources resources) {
        this.f21413b = glyphColorizer;
        this.f21414c = resources;
    }

    public final void m25047a(BarChart barChart, SparseIntArray sparseIntArray, int i) {
        barChart.m25226a();
        Resources resources = barChart.getResources();
        Drawable a = this.f21413b.a(2130843460, -9801344);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430070);
        a.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        Drawable drawable = a;
        while (i > 0) {
            Object string = barChart.getResources().getString(2131235359, new Object[]{Integer.valueOf(i)});
            SpannableString spannableString = new SpannableString(string);
            SpannableUtil.a(StringLengthHelper.a(Integer.toString(i)), StringLengthHelper.a(string), spannableString, new Object[]{new ImageSpan(drawable, 1)});
            barChart.m25227a(new BarChartItem(this.f21414c.getColor(i < f21411a.length ? f21411a[i - 1] : f21411a[f21411a.length - 1]), spannableString, sparseIntArray.get(i)));
            i--;
        }
    }
}

package com.facebook.reviews.util.helper;

import android.content.res.Resources;
import android.graphics.drawable.InsetDrawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.SpannableUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.InjectorLike;
import java.text.DecimalFormat;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: profile_video_android_upload_started */
public class ReviewsRatingHelper {
    private static volatile ReviewsRatingHelper f4983d;
    private final GlyphColorizer f4984a;
    private final Resources f4985b;
    private Locales f4986c;

    public static com.facebook.reviews.util.helper.ReviewsRatingHelper m4932a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4983d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.util.helper.ReviewsRatingHelper.class;
        monitor-enter(r1);
        r0 = f4983d;	 Catch:{ all -> 0x003a }
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
        r0 = m4933b(r0);	 Catch:{ all -> 0x0035 }
        f4983d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4983d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.util.helper.ReviewsRatingHelper.a(com.facebook.inject.InjectorLike):com.facebook.reviews.util.helper.ReviewsRatingHelper");
    }

    private static ReviewsRatingHelper m4933b(InjectorLike injectorLike) {
        return new ReviewsRatingHelper(GlyphColorizer.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), Locales.a(injectorLike));
    }

    @Inject
    public ReviewsRatingHelper(GlyphColorizer glyphColorizer, Resources resources, Locales locales) {
        this.f4984a = glyphColorizer;
        this.f4985b = resources;
        this.f4986c = locales;
    }

    public final SpannableString m4935a(int i, int i2) {
        return m4936a(i, i2, 2131361917);
    }

    public final SpannableString m4936a(int i, int i2, int i3) {
        return m4931a(this.f4985b.getString(2131235359, new Object[]{Integer.valueOf(i)}), StringLengthHelper.a(Integer.toString(i)), i2, i3);
    }

    public final SpannableString m4934a(double d, int i) {
        return m4930a(d, i, 2131361917);
    }

    private SpannableString m4930a(double d, int i, int i2) {
        return m4931a(this.f4985b.getString(2131235358, new Object[]{Double.valueOf(d)}), StringLengthHelper.a(m4937a(d)), i, i2);
    }

    public final String m4937a(double d) {
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(this.f4986c.a());
        decimalFormat.applyPattern("#.#");
        return decimalFormat.format(d);
    }

    private SpannableString m4931a(String str, int i, int i2, int i3) {
        SpannableString spannableString = new SpannableString(str);
        SpannableUtil.a(0, i, spannableString, new Object[]{new ForegroundColorSpan(this.f4985b.getColor(i3)), new StyleSpan(1), new AbsoluteSizeSpan(i2)});
        int i4 = (int) (((double) i2) * 0.625d);
        int i5 = (int) (((double) i2) * 0.1125d);
        new InsetDrawable(this.f4984a.a(2130843460, r1), i5, 0, 0, i5).setBounds(0, 0, i5 + i4, i5 + i4);
        SpannableUtil.a(i, StringLengthHelper.a(str), spannableString, new Object[]{new ImageSpan(r0, 1)});
        return spannableString;
    }
}

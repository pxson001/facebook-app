package com.facebook.search.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import com.facebook.common.util.SpannableUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.inject.InjectorLike;
import com.facebook.search.util.RoundedBackgroundSpan.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: megaphone_x_button */
public class TypeaheadRowTitleFormatter {
    private static final CharSequence f8942e = "[badge]";
    private static final CharSequence f8943f = "[phonetic]";
    private static volatile TypeaheadRowTitleFormatter f8944g;
    private final Context f8945a;
    private final Drawable f8946b = ContextCompat.a(this.f8945a, 2130843876);
    private final Drawable f8947c = ContextCompat.a(this.f8945a, 2130843877);
    private final Drawable f8948d;

    /* compiled from: megaphone_x_button */
    /* synthetic */ class C09261 {
        static final /* synthetic */ int[] f8941a = new int[GraphQLPageVerificationBadge.values().length];

        static {
            try {
                f8941a[GraphQLPageVerificationBadge.GRAY_VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8941a[GraphQLPageVerificationBadge.BLUE_VERIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static com.facebook.search.util.TypeaheadRowTitleFormatter m10667a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8944g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.util.TypeaheadRowTitleFormatter.class;
        monitor-enter(r1);
        r0 = f8944g;	 Catch:{ all -> 0x003a }
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
        r0 = m10670b(r0);	 Catch:{ all -> 0x0035 }
        f8944g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8944g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.util.TypeaheadRowTitleFormatter.a(com.facebook.inject.InjectorLike):com.facebook.search.util.TypeaheadRowTitleFormatter");
    }

    private static TypeaheadRowTitleFormatter m10670b(InjectorLike injectorLike) {
        return new TypeaheadRowTitleFormatter((Context) injectorLike.getInstance(Context.class), GlyphColorizer.a(injectorLike));
    }

    @Inject
    public TypeaheadRowTitleFormatter(Context context, GlyphColorizer glyphColorizer) {
        this.f8945a = context;
        this.f8948d = glyphColorizer.a(2130843554, -13266433);
        int dimensionPixelSize = this.f8945a.getResources().getDimensionPixelSize(2131431648);
        m10668a(this.f8946b, dimensionPixelSize);
        m10668a(this.f8947c, dimensionPixelSize);
        m10668a(this.f8948d, dimensionPixelSize);
    }

    public final SpannableStringBuilder m10671a(SpannableStringBuilder spannableStringBuilder) {
        m10669a(spannableStringBuilder, this.f8946b);
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder m10672a(SpannableStringBuilder spannableStringBuilder, GraphQLPageVerificationBadge graphQLPageVerificationBadge) {
        m10669a(spannableStringBuilder, m10666a(graphQLPageVerificationBadge));
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder m10673b(SpannableStringBuilder spannableStringBuilder) {
        CharSequence spannableStringBuilder2 = new SpannableStringBuilder(StringLocaleUtil.b(this.f8945a.getString(2131237509)));
        Builder builder = new Builder();
        builder.f8913b = this.f8945a.getResources().getColor(2131362035);
        builder = builder;
        builder.f8914c = this.f8945a.getResources().getColor(17170443);
        builder = builder;
        builder.f8915d = 4.0f;
        builder = builder;
        RoundedBackgroundSpan roundedBackgroundSpan = new RoundedBackgroundSpan(builder.f8912a, builder.f8913b, builder.f8914c, builder.f8915d, builder.f8916e);
        SpannableUtil.a(spannableStringBuilder2, new Object[]{new AbsoluteSizeSpan(24), new StyleSpan(1), roundedBackgroundSpan});
        return spannableStringBuilder.append(" ").append(spannableStringBuilder2);
    }

    private Drawable m10666a(GraphQLPageVerificationBadge graphQLPageVerificationBadge) {
        switch (C09261.f8941a[graphQLPageVerificationBadge.ordinal()]) {
            case 1:
                return this.f8947c;
            case 2:
                return this.f8946b;
            default:
                throw new IllegalArgumentException("No drawable for verification status" + graphQLPageVerificationBadge.name());
        }
    }

    private static void m10669a(SpannableStringBuilder spannableStringBuilder, Drawable drawable) {
        spannableStringBuilder.append("⁠").append(f8942e);
        spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), spannableStringBuilder.length() - f8942e.length(), spannableStringBuilder.length(), 17);
    }

    private static void m10668a(Drawable drawable, int i) {
        drawable.setBounds(i, 0, drawable.getIntrinsicWidth() + i, drawable.getIntrinsicHeight());
    }
}

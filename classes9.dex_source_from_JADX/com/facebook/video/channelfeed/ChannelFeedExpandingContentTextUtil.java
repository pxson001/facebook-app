package com.facebook.video.channelfeed;

import android.text.SpannableStringBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.text.CustomFontUtil;
import com.facebook.ufiservices.util.ContinueReadingSpan;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: task started before it was queued? */
public class ChannelFeedExpandingContentTextUtil {
    private static volatile ChannelFeedExpandingContentTextUtil f2174b;
    private final CustomFontUtil f2175a;

    public static com.facebook.video.channelfeed.ChannelFeedExpandingContentTextUtil m2167a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2174b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.channelfeed.ChannelFeedExpandingContentTextUtil.class;
        monitor-enter(r1);
        r0 = f2174b;	 Catch:{ all -> 0x003a }
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
        r0 = m2171b(r0);	 Catch:{ all -> 0x0035 }
        f2174b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2174b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.channelfeed.ChannelFeedExpandingContentTextUtil.a(com.facebook.inject.InjectorLike):com.facebook.video.channelfeed.ChannelFeedExpandingContentTextUtil");
    }

    private static ChannelFeedExpandingContentTextUtil m2171b(InjectorLike injectorLike) {
        return new ChannelFeedExpandingContentTextUtil(CustomFontUtil.a(injectorLike));
    }

    @Inject
    public ChannelFeedExpandingContentTextUtil(CustomFontUtil customFontUtil) {
        this.f2175a = customFontUtil;
    }

    public final void m2174a(SpannableStringBuilder spannableStringBuilder, int i, String str, ContinueReadingSpan continueReadingSpan) {
        Preconditions.checkNotNull(spannableStringBuilder);
        Preconditions.checkArgument(i > 0);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(continueReadingSpan);
        int c = m2172c(spannableStringBuilder, i, str);
        spannableStringBuilder.delete(m2166a(spannableStringBuilder.toString(), i), spannableStringBuilder.length());
        spannableStringBuilder.append(m2168a(str));
        spannableStringBuilder.setSpan(continueReadingSpan, c - str.length(), c, 33);
        spannableStringBuilder.setSpan(CustomFontUtil.a(), c - str.length(), c, 33);
    }

    public static boolean m2170a(SpannableStringBuilder spannableStringBuilder, int i, int i2, String str) {
        Object obj;
        if (spannableStringBuilder == null || str == null || i <= 0 || spannableStringBuilder.length() <= 0 || i >= spannableStringBuilder.length() || spannableStringBuilder.length() <= m2172c(spannableStringBuilder, i, str)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            if (spannableStringBuilder != null && str != null && i2 > 0 && spannableStringBuilder.length() > 0) {
                int i3 = 0;
                if (spannableStringBuilder != null) {
                    int i4 = 1;
                    while (i3 < spannableStringBuilder.length()) {
                        if (spannableStringBuilder.charAt(i3) == '\n') {
                            i4++;
                        }
                        i3++;
                    }
                    i3 = i4;
                }
                if (i2 < i3) {
                    obj = 1;
                    if (obj == null) {
                        return false;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static int m2172c(SpannableStringBuilder spannableStringBuilder, int i, String str) {
        return m2166a(spannableStringBuilder.toString(), i) + m2168a(str).length();
    }

    private static int m2166a(String str, int i) {
        if (str.length() <= i) {
            return str.length();
        }
        int indexOf = str.indexOf(10);
        if (indexOf >= 0 && indexOf < i) {
            i = indexOf;
        }
        int i2 = i;
        while (i2 < str.length()) {
            if (m2169a(str.charAt(i2))) {
                break;
            }
            i2++;
        }
        i2 = i;
        indexOf = i2;
        int c = m2173c(str, i);
        return Math.abs(indexOf - i) > Math.abs(i - c) ? c : indexOf;
    }

    private static int m2173c(String str, int i) {
        for (int i2 = i; i2 >= 0; i2--) {
            if (m2169a(str.charAt(i2))) {
                return i2;
            }
        }
        return i;
    }

    public static boolean m2169a(char c) {
        return c == ' ' || c == '\n';
    }

    private static String m2168a(String str) {
        return "… " + str;
    }
}

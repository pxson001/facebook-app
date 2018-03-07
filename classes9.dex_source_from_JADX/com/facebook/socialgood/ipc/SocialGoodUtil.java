package com.facebook.socialgood.ipc;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: userProfile */
public class SocialGoodUtil {
    private static volatile SocialGoodUtil f763b;
    public final Context f764a;

    public static com.facebook.socialgood.ipc.SocialGoodUtil m828a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f763b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.socialgood.ipc.SocialGoodUtil.class;
        monitor-enter(r1);
        r0 = f763b;	 Catch:{ all -> 0x003a }
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
        r0 = m829b(r0);	 Catch:{ all -> 0x0035 }
        f763b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f763b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.ipc.SocialGoodUtil.a(com.facebook.inject.InjectorLike):com.facebook.socialgood.ipc.SocialGoodUtil");
    }

    private static SocialGoodUtil m829b(InjectorLike injectorLike) {
        return new SocialGoodUtil((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public SocialGoodUtil(Context context) {
        this.f764a = context;
    }

    public final Spannable m831a(String str, String str2, boolean z, String str3) {
        int parseColor;
        try {
            parseColor = Color.parseColor("#" + str3);
        } catch (IllegalArgumentException e) {
            parseColor = ContextCompat.b(this.f764a, 2131363684);
        }
        return m830a(str, str2, z, parseColor);
    }

    public final Spannable m830a(String str, String str2, boolean z, int i) {
        Object string;
        if (!z || TextUtils.isEmpty(str)) {
            string = this.f764a.getResources().getString(2131239338, new Object[]{str2});
        } else {
            string = this.f764a.getResources().getString(2131239337, new Object[]{str2, str});
        }
        Spannable append = new SpannableStringBuilder().append(string);
        append.setSpan(new ForegroundColorSpan(i), 0, string.length(), 18);
        return append;
    }
}

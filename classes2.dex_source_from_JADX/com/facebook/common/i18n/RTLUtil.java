package com.facebook.common.i18n;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: structured_survey/intern_dev_mode_recent_integration_point_ids */
public class RTLUtil {
    private static volatile RTLUtil f3954b;
    private final Context f3955a;

    public static com.facebook.common.i18n.RTLUtil m6553a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3954b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.i18n.RTLUtil.class;
        monitor-enter(r1);
        r0 = f3954b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m6555b(r0);	 Catch:{ all -> 0x0035 }
        f3954b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3954b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.i18n.RTLUtil.a(com.facebook.inject.InjectorLike):com.facebook.common.i18n.RTLUtil");
    }

    private static RTLUtil m6555b(InjectorLike injectorLike) {
        return new RTLUtil((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public RTLUtil(Context context) {
        this.f3955a = context;
    }

    public final boolean m6557a() {
        return m6554a(this.f3955a);
    }

    public static boolean m6554a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (VERSION.SDK_INT < 17 || (applicationInfo.flags & 4194304) == 0) {
            return false;
        }
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public final Drawable m6556a(int i) {
        if (!m6557a()) {
            return this.f3955a.getResources().getDrawable(i);
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(this.f3955a.getResources(), i);
        return new 1(this, this.f3955a.getResources(), decodeResource, decodeResource);
    }
}

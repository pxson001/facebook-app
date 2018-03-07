package com.facebook.notifications.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.widget.DefaultNotificationsRenderer;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: expire_ttl_ms_override */
public class NotificationsFetchCountHelper {
    private static volatile NotificationsFetchCountHelper f12584d;
    private final double f12585a = 1.0d;
    private final double f12586b = 0.5d;
    private final FbSharedPreferences f12587c;

    public static com.facebook.notifications.util.NotificationsFetchCountHelper m13369a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12584d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.NotificationsFetchCountHelper.class;
        monitor-enter(r1);
        r0 = f12584d;	 Catch:{ all -> 0x003a }
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
        r0 = m13370b(r0);	 Catch:{ all -> 0x0035 }
        f12584d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12584d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationsFetchCountHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.NotificationsFetchCountHelper");
    }

    private static NotificationsFetchCountHelper m13370b(InjectorLike injectorLike) {
        return new NotificationsFetchCountHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public NotificationsFetchCountHelper(FbSharedPreferences fbSharedPreferences) {
        this.f12587c = fbSharedPreferences;
    }

    public final int m13371a(Context context, Display display, DefaultNotificationsRenderer defaultNotificationsRenderer) {
        return m13368a(context, display, defaultNotificationsRenderer, 1.0d);
    }

    private int m13368a(Context context, Display display, DefaultNotificationsRenderer defaultNotificationsRenderer, double d) {
        int i = 4;
        PrefKey prefKey = d == 1.0d ? NotificationsPreferenceConstants.f7730g : NotificationsPreferenceConstants.f7731h;
        if (this.f12587c.a(prefKey)) {
            return this.f12587c.a(prefKey, 4);
        }
        Object obj;
        double a = (double) defaultNotificationsRenderer.m13485a(context);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        int ceil = (int) Math.ceil(((double) Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) / a);
        if (ceil > 30 || ceil < 4) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            i = (int) Math.floor(((double) ceil) * d);
            this.f12587c.edit().a(prefKey, i).commit();
        }
        return i;
    }
}

package com.facebook.katana.orca;

import android.net.Uri;
import android.provider.Settings.System;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.forcemessenger.ForceMessenger;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: incoming_hot_like_large_message */
public class FbAndroidMessagingNotificationPreferences {
    private static final String f10358a = System.DEFAULT_NOTIFICATION_URI.toString();
    private static volatile FbAndroidMessagingNotificationPreferences f10359d;
    public final FbSharedPreferences f10360b;
    private final ForceMessenger f10361c;

    public static com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences m10901a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10359d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences.class;
        monitor-enter(r1);
        r0 = f10359d;	 Catch:{ all -> 0x003a }
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
        r0 = m10902b(r0);	 Catch:{ all -> 0x0035 }
        f10359d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10359d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences.a(com.facebook.inject.InjectorLike):com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences");
    }

    private static FbAndroidMessagingNotificationPreferences m10902b(InjectorLike injectorLike) {
        return new FbAndroidMessagingNotificationPreferences((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ForceMessenger.m8010a(injectorLike));
    }

    @Inject
    public FbAndroidMessagingNotificationPreferences(FbSharedPreferences fbSharedPreferences, ForceMessenger forceMessenger) {
        this.f10360b = fbSharedPreferences;
        this.f10361c = forceMessenger;
    }

    public final boolean m10903b() {
        return this.f10360b.a(NotificationsPreferenceConstants.f7746w, true);
    }

    public final boolean m10904c() {
        return !this.f10361c.m8014a();
    }

    public final boolean m10905d() {
        return this.f10360b.a(NotificationsPreferenceConstants.f7734k, true);
    }

    public final boolean m10906e() {
        Uri g = m10908g();
        return (g == null || g.equals(Uri.EMPTY)) ? false : true;
    }

    public final boolean m10907f() {
        return this.f10360b.a(NotificationsPreferenceConstants.f7735l, true);
    }

    public final Uri m10908g() {
        Object a = this.f10360b.a(NotificationsPreferenceConstants.f7736m, f10358a);
        if (StringUtil.a(a)) {
            return Uri.EMPTY;
        }
        return Uri.parse(a);
    }
}

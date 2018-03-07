package com.facebook.notifications.lockscreen.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import com.facebook.common.android.ActivityManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: logging_enabled */
public class LockscreenThirdPartyActivityHelper {
    private static final ComponentName f8921a = new ComponentName("com.google.android.apps.maps", "com.google.android.maps.driveabout.app.NavigationActivity");
    private static final ComponentName f8922b = new ComponentName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
    private static volatile LockscreenThirdPartyActivityHelper f8923d;
    private final ActivityManager f8924c;

    public static com.facebook.notifications.lockscreen.util.LockscreenThirdPartyActivityHelper m9275a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8923d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.lockscreen.util.LockscreenThirdPartyActivityHelper.class;
        monitor-enter(r1);
        r0 = f8923d;	 Catch:{ all -> 0x003a }
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
        r0 = m9278b(r0);	 Catch:{ all -> 0x0035 }
        f8923d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8923d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.lockscreen.util.LockscreenThirdPartyActivityHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.lockscreen.util.LockscreenThirdPartyActivityHelper");
    }

    private static LockscreenThirdPartyActivityHelper m9278b(InjectorLike injectorLike) {
        return new LockscreenThirdPartyActivityHelper(ActivityManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public LockscreenThirdPartyActivityHelper(ActivityManager activityManager) {
        this.f8924c = activityManager;
    }

    public final boolean m9279a() {
        if (m9276a(f8921a) && m9277a("com.google.android.apps.maps", ".NavigationService")) {
            return true;
        }
        if (m9276a(f8922b) && m9277a("com.google.android.apps.maps", ".NavigationService")) {
            return true;
        }
        return false;
    }

    private boolean m9277a(String str, String str2) {
        for (RunningServiceInfo runningServiceInfo : this.f8924c.getRunningServices(1000)) {
            if (runningServiceInfo.started && runningServiceInfo.service != null && runningServiceInfo.service.getPackageName().equals(str) && runningServiceInfo.service.getClassName().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean m9276a(ComponentName componentName) {
        List runningTasks = this.f8924c.getRunningTasks(1);
        if (runningTasks.isEmpty()) {
            return false;
        }
        return ((RunningTaskInfo) runningTasks.get(0)).topActivity.equals(componentName);
    }
}

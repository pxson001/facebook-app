package com.facebook.content;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.facebook.common.android.ApplicationInfoMethodAutoProvider;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.internal.ImmutableList;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fresh_feed_new_story_pill_hidden */
public class SecureContextHelperUtil {
    private static volatile SecureContextHelperUtil f23244c;
    public final PackageManager f23245a;
    public final ApplicationInfo f23246b;

    public static com.facebook.content.SecureContextHelperUtil m31347a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23244c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.content.SecureContextHelperUtil.class;
        monitor-enter(r1);
        r0 = f23244c;	 Catch:{ all -> 0x003a }
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
        r0 = m31350b(r0);	 Catch:{ all -> 0x0035 }
        f23244c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23244c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.content.SecureContextHelperUtil.a(com.facebook.inject.InjectorLike):com.facebook.content.SecureContextHelperUtil");
    }

    private static SecureContextHelperUtil m31350b(InjectorLike injectorLike) {
        return new SecureContextHelperUtil(PackageManagerMethodAutoProvider.m2633a(injectorLike), ApplicationInfoMethodAutoProvider.m8676b(injectorLike));
    }

    @Inject
    public SecureContextHelperUtil(PackageManager packageManager, ApplicationInfo applicationInfo) {
        this.f23245a = packageManager;
        this.f23246b = applicationInfo;
    }

    public static List<ActivityInfo> m31348a(Intent intent, PackageManager packageManager, ApplicationInfo applicationInfo) {
        int i = applicationInfo.uid;
        Iterable<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        List arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            ComponentInfo componentInfo = resolveInfo.activityInfo;
            if (m31349a(componentInfo, packageManager, applicationInfo)) {
                arrayList.add(componentInfo);
            }
        }
        return ImmutableList.a(arrayList);
    }

    public static boolean m31349a(ComponentInfo componentInfo, PackageManager packageManager, ApplicationInfo applicationInfo) {
        int i = applicationInfo.uid;
        int i2 = componentInfo.applicationInfo.uid;
        return i == i2 || packageManager.checkSignatures(i, i2) == 0;
    }
}

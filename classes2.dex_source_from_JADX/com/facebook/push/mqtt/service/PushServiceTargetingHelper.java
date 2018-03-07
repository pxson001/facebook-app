package com.facebook.push.mqtt.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.DeadObjectException;
import com.facebook.base.service.CachedBindServiceResult;
import com.facebook.base.service.CachingServiceBinder;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.mqttlite.MqttService;
import com.google.common.base.Preconditions;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mLastDisconnectMs */
public class PushServiceTargetingHelper {
    private static volatile PushServiceTargetingHelper f15534d;
    private final CachingServiceBinder f15535a;
    private final PackageManager f15536b;
    private final Set<ComponentName> f15537c = new HashSet();

    public static com.facebook.push.mqtt.service.PushServiceTargetingHelper m22145a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15534d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.service.PushServiceTargetingHelper.class;
        monitor-enter(r1);
        r0 = f15534d;	 Catch:{ all -> 0x003a }
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
        r0 = m22148b(r0);	 Catch:{ all -> 0x0035 }
        f15534d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15534d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.service.PushServiceTargetingHelper.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.service.PushServiceTargetingHelper");
    }

    private static PushServiceTargetingHelper m22148b(InjectorLike injectorLike) {
        return new PushServiceTargetingHelper(CachingServiceBinder.m22154a(injectorLike), PackageManagerMethodAutoProvider.m2633a(injectorLike));
    }

    @Inject
    public PushServiceTargetingHelper(CachingServiceBinder cachingServiceBinder, PackageManager packageManager) {
        this.f15535a = cachingServiceBinder;
        this.f15536b = packageManager;
    }

    public final ComponentName m22150a(Context context, Intent intent) {
        m22149c(context, intent);
        ComponentName startService = context.startService(intent);
        if (startService == null) {
            BLog.b("PushServiceTargetingHelper", "Unable to startService, the service %s was not found", new Object[]{intent.getComponent().flattenToShortString()});
            m22147a(context, intent.getComponent());
        }
        return startService;
    }

    public final boolean m22153b(Context context, Intent intent) {
        m22149c(context, intent);
        intent.getComponent().flattenToString();
        return context.stopService(intent);
    }

    public final CachedBindServiceResult m22151a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        m22149c(context, intent);
        ComponentName component = intent.getComponent();
        component.flattenToString();
        CachedBindServiceResult a = this.f15535a.m22159a(intent, serviceConnection, i);
        if (!a.a) {
            BLog.b("PushServiceTargetingHelper", "Unable to bind to %s", new Object[]{component.flattenToString()});
            m22147a(context, component);
        }
        return a;
    }

    public final void m22152a(ServiceConnection serviceConnection) {
        this.f15535a.m22160a(serviceConnection);
    }

    private void m22149c(Context context, Intent intent) {
        ComponentName componentName = new ComponentName(context, MqttService.class);
        Preconditions.checkArgument(intent.getComponent() == null, "Explicit component selection is not allowed");
        m22146a(componentName);
        intent.setComponent(componentName);
    }

    private static void m22147a(Context context, ComponentName componentName) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(componentName.getPackageName(), 4);
            int i = 0;
            while (i < packageInfo.services.length) {
                if (!StringUtil.m3590a(componentName.getClassName(), packageInfo.services[i].name)) {
                    i++;
                } else {
                    return;
                }
            }
            throw new RuntimeException(StringFormatUtil.formatStrLocaleSafe("No service found for class name: %s in package: %s", componentName.getClassName(), componentName.getPackageName()));
        } catch (Throwable e) {
            throw new RuntimeException(StringFormatUtil.formatStrLocaleSafe("No package found for component name: %s", componentName.getPackageName()), e);
        } catch (RuntimeException e2) {
            if (!(e2.getCause() instanceof DeadObjectException)) {
                throw e2;
            }
        }
    }

    private void m22146a(ComponentName componentName) {
        synchronized (this.f15537c) {
            if (this.f15537c.contains(componentName)) {
                return;
            }
            this.f15537c.add(componentName);
            this.f15536b.setComponentEnabledSetting(componentName, 1, 1);
        }
    }
}

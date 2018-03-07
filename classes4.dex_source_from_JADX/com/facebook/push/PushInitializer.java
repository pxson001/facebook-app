package com.facebook.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.common.alarm.FbAlarmManager;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.push.registration.ServiceType;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: isExposureHoldout */
public class PushInitializer extends AbstractAuthComponent implements INeedInit {
    private static final Class<?> f10171a = PushInitializer.class;
    private static volatile PushInitializer f10172g;
    private final Context f10173b;
    private final FbAlarmManagerImpl f10174c;
    public final ExecutorService f10175d;
    private final Lazy<Set<PushManager>> f10176e;
    public final AtomicBoolean f10177f = new AtomicBoolean(false);

    /* compiled from: isExposureHoldout */
    public class LocalBroadcastReceiver extends DynamicSecureBroadcastReceiver {
        public LocalBroadcastReceiver() {
            super("com.facebook.orca.push.ACTION_ALARM", new AlarmReceiver());
        }
    }

    public static com.facebook.push.PushInitializer m10633a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10172g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.PushInitializer.class;
        monitor-enter(r1);
        r0 = f10172g;	 Catch:{ all -> 0x003a }
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
        r0 = m10634b(r0);	 Catch:{ all -> 0x0035 }
        f10172g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10172g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.PushInitializer.a(com.facebook.inject.InjectorLike):com.facebook.push.PushInitializer");
    }

    private static PushInitializer m10634b(InjectorLike injectorLike) {
        return new PushInitializer((Context) injectorLike.getInstance(Context.class), FbAlarmManagerImpl.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$PushManager(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public PushInitializer(Context context, FbAlarmManager fbAlarmManager, ExecutorService executorService, Lazy<Set<PushManager>> lazy) {
        this.f10173b = context;
        this.f10174c = fbAlarmManager;
        this.f10175d = executorService;
        this.f10176e = lazy;
    }

    public void init() {
        m10636j(this);
        m10637k(this);
    }

    private void m10635i() {
        TracerDetour.a("PushInitializer.onLogin", 1928301461);
        try {
            Iterator it = ((Set) this.f10176e.get()).iterator();
            while (it.hasNext()) {
                PushManager pushManager = (PushManager) it.next();
                TracerDetour.a(pushManager.getClass().getName(), -1996301939);
                try {
                    pushManager.mo796c();
                    TracerDetour.a(pushManager);
                } finally {
                    int i = -659612365;
                    TracerDetour.a(-659612365);
                }
            }
        } finally {
            TracerDetour.a(553753884);
        }
    }

    public final void m10640a(@Nullable AuthenticationResult authenticationResult) {
        TracerDetour.a("PushInitializer.authComplete", 2142232043);
        try {
            m10635i();
        } finally {
            TracerDetour.a(1867596945);
        }
    }

    public final void m10641d() {
        TracerDetour.a("PushInitializer.unregisterPushToken", 326676823);
        try {
            Iterator it = ((Set) this.f10176e.get()).iterator();
            while (it.hasNext()) {
                PushManager pushManager = (PushManager) it.next();
                TracerDetour.a(pushManager.getClass().getName(), 499414356);
                try {
                    pushManager.mo798e();
                    TracerDetour.a(pushManager);
                } finally {
                    int i = -10628610;
                    TracerDetour.a(-10628610);
                }
            }
        } finally {
            TracerDetour.a(-251508184);
        }
    }

    public static void m10636j(PushInitializer pushInitializer) {
        TracerDetour.a("PushInitializer.ensureSupported", -1892571375);
        try {
            Iterator it = ((Set) pushInitializer.f10176e.get()).iterator();
            while (it.hasNext()) {
                PushManager pushManager = (PushManager) it.next();
                TracerDetour.a(pushManager.getClass().getName(), 1419500160);
                try {
                    pushManager.mo795b();
                    TracerDetour.a(pushManager);
                } finally {
                    int i = -1964076733;
                    TracerDetour.a(-1964076733);
                }
            }
        } finally {
            TracerDetour.a(94402796);
        }
    }

    public static void m10637k(PushInitializer pushInitializer) {
        TracerDetour.a("PushInitializer.ensureRegistered", 1305740535);
        try {
            Iterator it = ((Set) pushInitializer.f10176e.get()).iterator();
            while (it.hasNext()) {
                PushManager pushManager = (PushManager) it.next();
                TracerDetour.a(pushManager.getClass().getName(), -462473571);
                try {
                    pushManager.mo797d();
                    TracerDetour.a(pushManager);
                } finally {
                    int i = 2072019736;
                    TracerDetour.a(2072019736);
                }
            }
            pushInitializer.m10638l();
        } finally {
            TracerDetour.a(1699063162);
        }
    }

    public final PushManager m10639a(ServiceType serviceType) {
        TracerDetour.a("PushInitializer.getPushManager", 1663339711);
        try {
            Iterator it = ((Set) this.f10176e.get()).iterator();
            while (it.hasNext()) {
                PushManager pushManager = (PushManager) it.next();
                TracerDetour.a(pushManager.getClass().getName(), 1516538515);
                try {
                    if (pushManager.mo794a().equals(serviceType)) {
                        TracerDetour.a(1852538351);
                        return pushManager;
                    }
                    TracerDetour.a(pushManager);
                } finally {
                    int i = -1724085927;
                    TracerDetour.a(-1724085927);
                }
            }
            throw new IllegalStateException("Unsupported ServiceType " + serviceType.name());
        } finally {
            TracerDetour.a(2011031768);
        }
    }

    private void m10638l() {
        if (this.f10177f.compareAndSet(false, true)) {
            Intent intent = new Intent(this.f10173b, LocalBroadcastReceiver.class);
            intent.setAction("com.facebook.orca.push.ACTION_ALARM");
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f10173b, -1, intent, 134217728);
            long currentTimeMillis = System.currentTimeMillis() + 86400000;
            FbAlarmManagerImpl fbAlarmManagerImpl = this.f10174c;
            if (VERSION.SDK_INT < 19) {
                fbAlarmManagerImpl.a.set(1, currentTimeMillis, broadcast);
            } else {
                fbAlarmManagerImpl.a.setExact(1, currentTimeMillis, broadcast);
            }
        }
    }
}

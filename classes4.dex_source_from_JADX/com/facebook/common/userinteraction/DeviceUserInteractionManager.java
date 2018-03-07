package com.facebook.common.userinteraction;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.common.hardware.ScreenPowerState.PowerChangeListener;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hot_like_timeout */
public class DeviceUserInteractionManager {
    public static final String f10724a = (DeviceUserInteractionManager.class.getCanonicalName() + ".ACTIVITY_MAYBE_CHANGED");
    public static final String f10725b = (DeviceUserInteractionManager.class.getCanonicalName() + ".USER_ENTERED_DEVICE");
    public static final String f10726c = (DeviceUserInteractionManager.class.getCanonicalName() + ".USER_LEFT_DEVICE");
    private static final Class<?> f10727d = DeviceUserInteractionManager.class;
    private static volatile DeviceUserInteractionManager f10728i;
    public final BaseFbBroadcastManager f10729e;
    public final ScreenPowerState f10730f;
    public final Clock f10731g;
    public volatile long f10732h;

    /* compiled from: hot_like_timeout */
    class C04881 implements PowerChangeListener {
        final /* synthetic */ DeviceUserInteractionManager f10733a;

        C04881(DeviceUserInteractionManager deviceUserInteractionManager) {
            this.f10733a = deviceUserInteractionManager;
        }

        public final void m11182a(boolean z) {
            DeviceUserInteractionManager deviceUserInteractionManager = this.f10733a;
            deviceUserInteractionManager.f10729e.a(z ? DeviceUserInteractionManager.f10725b : DeviceUserInteractionManager.f10726c);
            deviceUserInteractionManager.f10729e.a(DeviceUserInteractionManager.f10724a);
        }
    }

    public static com.facebook.common.userinteraction.DeviceUserInteractionManager m11180a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10728i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.userinteraction.DeviceUserInteractionManager.class;
        monitor-enter(r1);
        r0 = f10728i;	 Catch:{ all -> 0x003a }
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
        r0 = m11181b(r0);	 Catch:{ all -> 0x0035 }
        f10728i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10728i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.userinteraction.DeviceUserInteractionManager.a(com.facebook.inject.InjectorLike):com.facebook.common.userinteraction.DeviceUserInteractionManager");
    }

    private static DeviceUserInteractionManager m11181b(InjectorLike injectorLike) {
        return new DeviceUserInteractionManager((BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), ScreenPowerState.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DeviceUserInteractionManager(BaseFbBroadcastManager baseFbBroadcastManager, ScreenPowerState screenPowerState, Clock clock) {
        this.f10729e = baseFbBroadcastManager;
        this.f10730f = screenPowerState;
        this.f10731g = clock;
        this.f10730f.a(new C04881(this));
    }
}

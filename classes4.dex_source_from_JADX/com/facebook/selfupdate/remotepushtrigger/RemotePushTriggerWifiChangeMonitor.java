package com.facebook.selfupdate.remotepushtrigger;

import android.os.Handler;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.device.DeviceConditionHelper.WifiStateChangedListener;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.selfupdate.SelfUpdateChecker;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: google_api_availability */
public class RemotePushTriggerWifiChangeMonitor implements INeedInit {
    private static volatile RemotePushTriggerWifiChangeMonitor f11004j;
    private final AppStateManager f11005a;
    public final DeviceConditionHelper f11006b;
    private final BaseFbBroadcastManager f11007c;
    public final Handler f11008d;
    public final RemotePushTriggerExperimentController f11009e;
    public final RemotePushTriggerReporter f11010f;
    private final SelfUpdateChecker f11011g;
    public final Runnable f11012h = new C05181(this);
    public final WifiStateChangedListener f11013i = new C05192(this);

    /* compiled from: google_api_availability */
    class C05181 implements Runnable {
        final /* synthetic */ RemotePushTriggerWifiChangeMonitor f11020a;

        C05181(RemotePushTriggerWifiChangeMonitor remotePushTriggerWifiChangeMonitor) {
            this.f11020a = remotePushTriggerWifiChangeMonitor;
        }

        public void run() {
            if (this.f11020a.f11006b.b()) {
                this.f11020a.f11010f.m11478a();
            }
        }
    }

    /* compiled from: google_api_availability */
    class C05192 implements WifiStateChangedListener {
        final /* synthetic */ RemotePushTriggerWifiChangeMonitor f11021a;

        C05192(RemotePushTriggerWifiChangeMonitor remotePushTriggerWifiChangeMonitor) {
            this.f11021a = remotePushTriggerWifiChangeMonitor;
        }

        public final void m11479a(DeviceConditionHelper deviceConditionHelper) {
            HandlerDetour.a(this.f11021a.f11008d, this.f11021a.f11012h);
            HandlerDetour.b(this.f11021a.f11008d, this.f11021a.f11012h, (long) this.f11021a.f11009e.f11014a.a(ExperimentsForRemotePushTriggerModule.f11028e, 1000), 1901612537);
        }
    }

    public static com.facebook.selfupdate.remotepushtrigger.RemotePushTriggerWifiChangeMonitor m11472a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11004j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.selfupdate.remotepushtrigger.RemotePushTriggerWifiChangeMonitor.class;
        monitor-enter(r1);
        r0 = f11004j;	 Catch:{ all -> 0x003a }
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
        r0 = m11474b(r0);	 Catch:{ all -> 0x0035 }
        f11004j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11004j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.selfupdate.remotepushtrigger.RemotePushTriggerWifiChangeMonitor.a(com.facebook.inject.InjectorLike):com.facebook.selfupdate.remotepushtrigger.RemotePushTriggerWifiChangeMonitor");
    }

    private static RemotePushTriggerWifiChangeMonitor m11474b(InjectorLike injectorLike) {
        return new RemotePushTriggerWifiChangeMonitor(AppStateManager.a(injectorLike), DeviceConditionHelper.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), RemotePushTriggerExperimentController.m11476b(injectorLike), new RemotePushTriggerReporter(AppStateManager.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), RemotePushTriggerExperimentController.m11476b(injectorLike), IdBasedLazy.a(injectorLike, 2164)), SelfUpdateChecker.b(injectorLike));
    }

    @Inject
    public RemotePushTriggerWifiChangeMonitor(AppStateManager appStateManager, DeviceConditionHelper deviceConditionHelper, BaseFbBroadcastManager baseFbBroadcastManager, Handler handler, RemotePushTriggerExperimentController remotePushTriggerExperimentController, RemotePushTriggerReporter remotePushTriggerReporter, SelfUpdateChecker selfUpdateChecker) {
        this.f11005a = appStateManager;
        this.f11006b = deviceConditionHelper;
        this.f11007c = baseFbBroadcastManager;
        this.f11008d = handler;
        this.f11009e = remotePushTriggerExperimentController;
        this.f11010f = remotePushTriggerReporter;
        this.f11011g = selfUpdateChecker;
    }

    public void init() {
        if (m11473a()) {
            this.f11007c.a().a(AppStateManager.b, new 4(this)).a(AppStateManager.c, new 3(this)).a().b();
            if (this.f11009e.m11477b() || !this.f11005a.j()) {
                m11475b(this);
            }
        }
    }

    private boolean m11473a() {
        return !this.f11011g.a() && this.f11009e.f11014a.a(ExperimentsForRemotePushTriggerModule.f11025b, false);
    }

    public static void m11475b(RemotePushTriggerWifiChangeMonitor remotePushTriggerWifiChangeMonitor) {
        if (remotePushTriggerWifiChangeMonitor.m11473a()) {
            if (remotePushTriggerWifiChangeMonitor.f11006b.a(true)) {
                remotePushTriggerWifiChangeMonitor.f11010f.m11478a();
            }
            remotePushTriggerWifiChangeMonitor.f11006b.a(remotePushTriggerWifiChangeMonitor.f11013i);
        }
    }
}

package com.facebook.oxygen.preloads.integration.dogfooding;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbAppBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.android.LocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.SerialListeningExecutorService;
import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkConstants;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: send_debug_info_async */
public class AuthListener implements INeedInit {
    private static volatile AuthListener f8989k;
    private final Context f8990a;
    private final PackageManager f8991b;
    private final AbstractFbErrorReporter f8992c;
    private final BaseFbBroadcastManager f8993d;
    private final LocalBroadcastManager f8994e;
    private final Provider<TriState> f8995f;
    private final Provider<TriState> f8996g;
    public final DefaultSerialListeningExecutorService f8997h;
    private final AppManagerSsoCallerVerifier f8998i;
    private final DynamicSecureBroadcastReceiver f8999j;

    /* compiled from: send_debug_info_async */
    public class C04253 implements ActionReceiver {
        final /* synthetic */ AuthListener f9022a;

        public C04253(AuthListener authListener) {
            this.f9022a = authListener;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1235378806);
            AuthListener.m9314a(this.f9022a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1522970595, a);
        }
    }

    /* compiled from: send_debug_info_async */
    public class C04264 implements ActionReceiver {
        final /* synthetic */ AuthListener f9023a;

        public C04264(AuthListener authListener) {
            this.f9023a = authListener;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -663640994);
            AuthListener.m9317b(this.f9023a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 295319749, a);
        }
    }

    /* compiled from: send_debug_info_async */
    public class EmployeeLoggedInMarkerReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2098740517, Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -142048841));
        }
    }

    public static com.facebook.oxygen.preloads.integration.dogfooding.AuthListener m9312a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8989k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.oxygen.preloads.integration.dogfooding.AuthListener.class;
        monitor-enter(r1);
        r0 = f8989k;	 Catch:{ all -> 0x003a }
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
        r0 = m9316b(r0);	 Catch:{ all -> 0x0035 }
        f8989k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8989k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.oxygen.preloads.integration.dogfooding.AuthListener.a(com.facebook.inject.InjectorLike):com.facebook.oxygen.preloads.integration.dogfooding.AuthListener");
    }

    private static AuthListener m9316b(InjectorLike injectorLike) {
        return new AuthListener((Context) injectorLike.getInstance(Context.class), PackageManagerMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), LocalBroadcastManagerMethodAutoProvider.m7676a(injectorLike), (BaseFbBroadcastManager) CrossFbAppBroadcastManager.a(injectorLike), DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 640), IdBasedProvider.a(injectorLike, 642), AppManagerSsoCallerVerifier.m9323b(injectorLike));
    }

    @Inject
    public AuthListener(Context context, PackageManager packageManager, FbErrorReporter fbErrorReporter, LocalBroadcastManager localBroadcastManager, FbBroadcastManager fbBroadcastManager, SerialListeningExecutorService serialListeningExecutorService, Provider<TriState> provider, Provider<TriState> provider2, AppManagerSsoCallerVerifier appManagerSsoCallerVerifier) {
        this.f8990a = context;
        this.f8991b = packageManager;
        this.f8992c = fbErrorReporter;
        this.f8994e = localBroadcastManager;
        this.f8993d = fbBroadcastManager;
        this.f8995f = provider;
        this.f8997h = serialListeningExecutorService;
        this.f8996g = provider2;
        this.f8998i = appManagerSsoCallerVerifier;
        C04253 c04253 = new C04253(this);
        this.f8999j = new DynamicSecureBroadcastReceiver(ImmutableMap.builder().b("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE", c04253).b("com.facebook.orca.login.AuthStateMachineMonitor.LOGOUT_COMPLETE", new C04264(this)).b());
    }

    public void init() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE");
        intentFilter.addAction("com.facebook.orca.login.AuthStateMachineMonitor.LOGOUT_COMPLETE");
        this.f8994e.a(this.f8999j, intentFilter);
        final boolean c = m9320c();
        this.f8997h.a(new Runnable(this) {
            final /* synthetic */ AuthListener f11160b;

            public void run() {
                AuthListener.m9319c(this.f11160b, c);
                AuthListener.m9321d(this.f11160b);
            }
        });
    }

    public static void m9314a(AuthListener authListener) {
        authListener.m9315a(authListener.m9320c());
    }

    public static void m9317b(AuthListener authListener) {
        authListener.m9315a(false);
    }

    private void m9315a(final boolean z) {
        this.f8997h.a(new Runnable(this) {
            final /* synthetic */ AuthListener f2841b;

            public void run() {
                AuthListener.m9319c(this.f2841b, z);
                AuthListener.m9322d(this.f2841b, z);
            }
        });
    }

    private boolean m9320c() {
        return ((TriState) this.f8995f.get()).asBoolean(false) || ((TriState) this.f8996g.get()).asBoolean(false);
    }

    public static void m9319c(AuthListener authListener, boolean z) {
        Boolean.valueOf(z);
        authListener.f8991b.setComponentEnabledSetting(new ComponentName(authListener.f8990a, EmployeeLoggedInMarkerReceiver.class), z ? 1 : 2, 1);
    }

    public static void m9322d(AuthListener authListener, boolean z) {
        Boolean.valueOf(z);
        Intent intent = new Intent("com.facebook.appmanager.fb4a.auth.EVENT");
        intent.putExtra("employee_loggedin", z);
        authListener.m9318b(intent);
        authListener.m9313a(intent);
    }

    public static void m9321d(AuthListener authListener) {
        Intent intent = new Intent("com.facebook.appmanager.fb4a.auth.CHECK_LOGGED_IN_STATUS");
        authListener.m9318b(intent);
        authListener.m9313a(intent);
    }

    private void m9313a(Intent intent) {
        if (this.f8991b.checkSignatures(this.f8990a.getPackageName(), PreloadSdkConstants.a) == 0) {
            intent.setPackage(PreloadSdkConstants.a);
            this.f8993d.a(intent);
        }
    }

    private boolean m9318b(Intent intent) {
        try {
            this.f8991b.getPackageInfo(PreloadSdkConstants.a, 0);
            try {
                this.f8998i.m9324b();
                intent.setPackage(PreloadSdkConstants.a);
                this.f8990a.sendBroadcast(intent, PreloadSdkConstants.b);
                return true;
            } catch (Throwable th) {
                this.f8992c.a("AuthListener", "AppManager does not own permission.");
                return false;
            }
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}

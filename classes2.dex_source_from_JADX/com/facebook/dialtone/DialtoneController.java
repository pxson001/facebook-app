package com.facebook.dialtone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.dialtone.activitylistener.DialtoneActivityListener;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.FetchDialtonePhotoQuotaModel.DialtonePhotoQuotaModel;
import com.facebook.gk.init.INeedInitForGatekeepersListenerRegistration;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.sdk.common.TokenRequestReason;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: total_succeed */
public abstract class DialtoneController {

    @Singleton
    /* compiled from: total_succeed */
    public class LocalDialtoneControllerReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<DialtoneController> {
        private static volatile LocalDialtoneControllerReceiverRegistration f2317a;

        public static com.facebook.dialtone.DialtoneController.LocalDialtoneControllerReceiverRegistration m4500a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f2317a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.dialtone.DialtoneController.LocalDialtoneControllerReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2317a;	 Catch:{ all -> 0x003a }
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
            r0 = m4501b(r0);	 Catch:{ all -> 0x0035 }
            f2317a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2317a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.DialtoneController.LocalDialtoneControllerReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.DialtoneController$LocalDialtoneControllerReceiverRegistration");
        }

        private static LocalDialtoneControllerReceiverRegistration m4501b(InjectorLike injectorLike) {
            return new LocalDialtoneControllerReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 1086));
        }

        protected void onReceive(Context context, Intent intent, Object obj) {
            DialtoneController dialtoneController = (DialtoneController) obj;
            String action = intent.getAction();
            if ("com.facebook.zero.ZERO_RATING_DISABLED_ON_WIFI".equals(action)) {
                dialtoneController.mo1229h();
            } else if ("com.facebook.zero.ZERO_RATING_STATE_UNREGISTERED_REASON".equals(action)) {
                dialtoneController.mo1225d(intent.getExtras().getString("unregistered_reason"));
            } else if ("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE".equals(action)) {
                dialtoneController.mo1230i();
            }
        }

        @Inject
        public LocalDialtoneControllerReceiverRegistration(Lazy<DialtoneController> lazy) {
            super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, "com.facebook.zero.ZERO_RATING_DISABLED_ON_WIFI", "com.facebook.zero.ZERO_RATING_STATE_UNREGISTERED_REASON", "com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE");
        }
    }

    @Singleton
    /* compiled from: total_succeed */
    public class OnInitDialtoneControllerGatekeeperListenerRegistration extends INeedInitForGatekeepersListenerRegistration<DialtoneController> {
        private static volatile OnInitDialtoneControllerGatekeeperListenerRegistration f2430c;
        private final FbSharedPreferences f2431b;

        public static com.facebook.dialtone.DialtoneController.OnInitDialtoneControllerGatekeeperListenerRegistration m4627a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f2430c;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.dialtone.DialtoneController.OnInitDialtoneControllerGatekeeperListenerRegistration.class;
            monitor-enter(r1);
            r0 = f2430c;	 Catch:{ all -> 0x003a }
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
            r0 = m4628b(r0);	 Catch:{ all -> 0x0035 }
            f2430c = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2430c;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.DialtoneController.OnInitDialtoneControllerGatekeeperListenerRegistration.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.DialtoneController$OnInitDialtoneControllerGatekeeperListenerRegistration");
        }

        private static OnInitDialtoneControllerGatekeeperListenerRegistration m4628b(InjectorLike injectorLike) {
            return new OnInitDialtoneControllerGatekeeperListenerRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 1086), FbSharedPreferencesImpl.m1826a(injectorLike));
        }

        protected final void mo659a(GatekeeperStoreImpl gatekeeperStoreImpl, int i, Object obj) {
            DialtoneController dialtoneController = (DialtoneController) obj;
            this.f2431b.edit().putBoolean(DialtonePrefKeys.f2499v, true).commit();
            dialtoneController.mo1212a(TokenRequestReason.GATEKEEPER_CHANGED);
            if (!gatekeeperStoreImpl.m2189a(i, false) && dialtoneController.mo1221b()) {
                dialtoneController.mo1217a("dialtone_gatekeeper_turned_off");
            }
        }

        @Inject
        public OnInitDialtoneControllerGatekeeperListenerRegistration(Lazy<DialtoneController> lazy, FbSharedPreferences fbSharedPreferences) {
            super((Lazy) lazy, 559);
            this.f2431b = fbSharedPreferences;
        }
    }

    public void mo1209a(DialtoneActivityListener dialtoneActivityListener) {
    }

    public boolean mo1213a() {
        return false;
    }

    public boolean mo1214a(Context context, Intent intent) {
        return false;
    }

    public boolean mo1221b() {
        return false;
    }

    public boolean mo1223c() {
        return false;
    }

    public boolean mo1217a(@Nullable String str) {
        return false;
    }

    public void mo1208a(Context context) {
    }

    public void mo1210a(DialtoneStateChangedListener dialtoneStateChangedListener) {
    }

    public void mo1220b(DialtoneStateChangedListener dialtoneStateChangedListener) {
    }

    public int mo1226e() {
        return 0;
    }

    public boolean mo1215a(Uri uri, CallerContext callerContext) {
        return false;
    }

    public boolean mo1218a(String str, CallerContext callerContext) {
        return false;
    }

    public boolean mo1222b(String str) {
        return false;
    }

    public boolean mo1224c(String str) {
        return false;
    }

    public Bitmap mo1207a(float f, float f2, PlaceholderState placeholderState) {
        return null;
    }

    @Nullable
    public Activity mo1227f() {
        return null;
    }

    public boolean mo1228g() {
        return false;
    }

    public boolean mo1219a(boolean z) {
        return false;
    }

    public boolean mo1216a(DialtoneStateChangedListener dialtoneStateChangedListener, Uri uri, boolean z) {
        return false;
    }

    protected void mo1229h() {
    }

    protected void mo1225d(String str) {
    }

    protected void mo1230i() {
    }

    public boolean mo1231j() {
        return false;
    }

    public boolean mo1232k() {
        return false;
    }

    public boolean mo1233l() {
        return false;
    }

    public boolean mo1234m() {
        return false;
    }

    public void mo1211a(DialtonePhotoQuotaModel dialtonePhotoQuotaModel) {
    }

    protected void mo1212a(TokenRequestReason tokenRequestReason) {
    }
}

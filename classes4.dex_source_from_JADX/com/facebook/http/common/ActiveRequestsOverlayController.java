package com.facebook.http.common;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.TextView;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_tracking_enabled */
public class ActiveRequestsOverlayController implements INeedInit {
    public static final PrefKey f9798a = InternalHttpPrefKeys.g;
    private static volatile ActiveRequestsOverlayController f9799n;
    private final Context f9800b;
    private final WindowManager f9801c;
    public final Handler f9802d;
    private final FbHttpRequestProcessor f9803e;
    private final FbSharedPreferences f9804f;
    private final BaseFbBroadcastManager f9805g;
    private final List<FbHttpRequest<?>> f9806h = Lists.a();
    private TextView f9807i;
    private final Callback f9808j = new Callback(this);
    private boolean f9809k = false;
    private boolean f9810l = false;
    public boolean f9811m = false;

    /* compiled from: is_tracking_enabled */
    class Callback implements Runnable {
        final /* synthetic */ ActiveRequestsOverlayController f9812a;

        public Callback(ActiveRequestsOverlayController activeRequestsOverlayController) {
            this.f9812a = activeRequestsOverlayController;
        }

        public void run() {
            HandlerDetour.a(this.f9812a.f9802d, this);
            if (this.f9812a.m10215e()) {
                ActiveRequestsOverlayController.m10210g(this.f9812a);
                this.f9812a.m10214d();
            }
        }
    }

    /* compiled from: is_tracking_enabled */
    class C04411 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ ActiveRequestsOverlayController f9813a;

        C04411(ActiveRequestsOverlayController activeRequestsOverlayController) {
            this.f9813a = activeRequestsOverlayController;
        }

        public final void m10216a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            this.f9813a.m10211a();
        }
    }

    /* compiled from: is_tracking_enabled */
    class C04422 implements ActionReceiver {
        final /* synthetic */ ActiveRequestsOverlayController f9818a;

        C04422(ActiveRequestsOverlayController activeRequestsOverlayController) {
            this.f9818a = activeRequestsOverlayController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1504046724);
            this.f9818a.f9811m = false;
            this.f9818a.m10213c();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 157094472, a);
        }
    }

    /* compiled from: is_tracking_enabled */
    class C04433 implements ActionReceiver {
        final /* synthetic */ ActiveRequestsOverlayController f9819a;

        C04433(ActiveRequestsOverlayController activeRequestsOverlayController) {
            this.f9819a = activeRequestsOverlayController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -271850474);
            this.f9819a.f9811m = true;
            this.f9819a.m10212b();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 925370491, a);
        }
    }

    public static com.facebook.http.common.ActiveRequestsOverlayController m10207a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9799n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.ActiveRequestsOverlayController.class;
        monitor-enter(r1);
        r0 = f9799n;	 Catch:{ all -> 0x003a }
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
        r0 = m10208b(r0);	 Catch:{ all -> 0x0035 }
        f9799n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9799n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.ActiveRequestsOverlayController.a(com.facebook.inject.InjectorLike):com.facebook.http.common.ActiveRequestsOverlayController");
    }

    private static ActiveRequestsOverlayController m10208b(InjectorLike injectorLike) {
        return new ActiveRequestsOverlayController((Context) injectorLike.getInstance(Context.class), WindowManagerMethodAutoProvider.b(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), FbHttpRequestProcessor.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike));
    }

    @Inject
    public ActiveRequestsOverlayController(Context context, WindowManager windowManager, Handler handler, FbHttpRequestProcessor fbHttpRequestProcessor, FbSharedPreferences fbSharedPreferences, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f9800b = context;
        this.f9801c = windowManager;
        this.f9802d = handler;
        this.f9803e = fbHttpRequestProcessor;
        this.f9804f = fbSharedPreferences;
        this.f9805g = baseFbBroadcastManager;
    }

    public void init() {
        m10211a();
        this.f9804f.a(f9798a, new C04411(this));
        this.f9805g.a().a(AppStateManager.b, new C04422(this)).a().b();
        this.f9805g.a().a(AppStateManager.c, new C04433(this)).a().b();
    }

    public final void m10211a() {
        boolean z = false;
        this.f9809k = this.f9804f.a(f9798a, false);
        if (VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this.f9800b)) {
            z = true;
        }
        this.f9810l = z;
        if (this.f9809k && !this.f9810l) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse("package:" + this.f9800b.getPackageName()));
            intent.addFlags(268435456);
            this.f9800b.startActivity(intent);
        }
        m10213c();
        if (!m10215e()) {
            m10212b();
        }
    }

    public final void m10212b() {
        if (this.f9807i != null) {
            this.f9807i.setVisibility(8);
        }
    }

    public final void m10213c() {
        if (m10215e()) {
            m10209f();
            this.f9807i.setVisibility(0);
            m10214d();
        }
    }

    public final void m10214d() {
        HandlerDetour.b(this.f9802d, this.f9808j, 500, -709179587);
    }

    public final boolean m10215e() {
        return this.f9809k && !this.f9811m && this.f9810l;
    }

    private void m10209f() {
        if (this.f9807i == null) {
            this.f9807i = new TextView(this.f9800b);
            LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 24, -3);
            layoutParams.gravity = 51;
            this.f9807i.setBackgroundDrawable(new ColorDrawable(-1426063361));
            this.f9807i.setTextSize(12.0f);
            this.f9807i.setTextColor(-65536);
            this.f9801c.addView(this.f9807i, layoutParams);
        }
    }

    public static void m10210g(ActiveRequestsOverlayController activeRequestsOverlayController) {
        int i = 0;
        activeRequestsOverlayController.m10209f();
        StringBuilder stringBuilder = new StringBuilder();
        RequestProcessorSnapshot a = activeRequestsOverlayController.f9803e.a();
        stringBuilder.append("Inflight: \n");
        ArrayList arrayList = a.f9816a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((FbHttpRequest) arrayList.get(i2)).a(stringBuilder);
            stringBuilder.append("\n");
        }
        stringBuilder.append("\nQueued: \n");
        ArrayList arrayList2 = a.f9817b;
        int size2 = arrayList2.size();
        while (i < size2) {
            ((FbHttpRequest) arrayList2.get(i)).a(stringBuilder);
            stringBuilder.append("\n");
            i++;
        }
        activeRequestsOverlayController.f9807i.setText(stringBuilder.toString());
    }
}

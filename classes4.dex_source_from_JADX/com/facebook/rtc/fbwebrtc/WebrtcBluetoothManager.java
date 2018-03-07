package com.facebook.rtc.fbwebrtc;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothHeadset;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.6;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.6.1;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: senders */
public class WebrtcBluetoothManager {
    private static final Class<?> f2726a = WebrtcBluetoothManager.class;
    private static volatile WebrtcBluetoothManager f2727j;
    public final Context f2728b;
    public final AudioManager f2729c;
    public BluetoothReceiver f2730d;
    public BluetoothAdapter f2731e;
    public BluetoothHeadset f2732f;
    public 6 f2733g;
    public boolean f2734h;
    public final ActionReceiver f2735i = new C01242(this);

    /* compiled from: senders */
    class C01242 implements ActionReceiver {
        final /* synthetic */ WebrtcBluetoothManager f2736a;

        C01242(WebrtcBluetoothManager webrtcBluetoothManager) {
            this.f2736a = webrtcBluetoothManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1896603322);
            String action = intent.getAction();
            int intExtra;
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                Integer.valueOf(intExtra);
                if (this.f2736a.f2733g != null) {
                    6 6 = this.f2736a.f2733g;
                    if (!6.a.be && 6.a.n.m2922b()) {
                        6.a.x.schedule(new 1(6), 700, TimeUnit.MILLISECONDS);
                    } else if (6.a.be && (intExtra == 3 || intExtra == 0)) {
                        WebrtcUiHandler.bc(6.a);
                    }
                    WebrtcUiHandler.bn(6.a);
                    WebrtcUiHandler.bK(6.a);
                }
            } else if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(action)) {
                intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
                Integer.valueOf(intExtra);
                if (intExtra == 12) {
                    this.f2736a.f2729c.setBluetoothScoOn(true);
                }
                if (this.f2736a.f2733g != null) {
                    this.f2736a.f2733g.b(intExtra);
                }
            }
            LogUtils.e(869011963, a);
        }
    }

    public static com.facebook.rtc.fbwebrtc.WebrtcBluetoothManager m2918a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2727j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.fbwebrtc.WebrtcBluetoothManager.class;
        monitor-enter(r1);
        r0 = f2727j;	 Catch:{ all -> 0x003a }
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
        r0 = m2919b(r0);	 Catch:{ all -> 0x0035 }
        f2727j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2727j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.WebrtcBluetoothManager.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.WebrtcBluetoothManager");
    }

    private static WebrtcBluetoothManager m2919b(InjectorLike injectorLike) {
        return new WebrtcBluetoothManager((Context) injectorLike.getInstance(Context.class), AudioManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public WebrtcBluetoothManager(Context context, AudioManager audioManager) {
        this.f2728b = context;
        this.f2729c = audioManager;
    }

    public final void m2920a() {
        this.f2733g = null;
        if (this.f2734h) {
            if (this.f2729c.isBluetoothScoOn()) {
                this.f2729c.setBluetoothScoOn(false);
            }
            this.f2729c.stopBluetoothSco();
            this.f2734h = false;
        }
        if (this.f2730d != null) {
            this.f2728b.unregisterReceiver(this.f2730d);
            this.f2730d = null;
        }
        if (!(this.f2731e == null || this.f2732f == null)) {
            this.f2731e.closeProfileProxy(1, this.f2732f);
        }
        this.f2732f = null;
        this.f2731e = null;
    }

    public final boolean m2922b() {
        return (this.f2731e == null || this.f2732f == null || this.f2732f.getConnectedDevices().size() <= 0) ? false : true;
    }

    public final boolean m2921a(boolean z) {
        Boolean.valueOf(this.f2729c.isBluetoothScoOn());
        Boolean.valueOf(z);
        if (z) {
            if (m2922b()) {
                this.f2729c.startBluetoothSco();
                this.f2729c.setMode(2);
                this.f2734h = true;
            } else {
                this.f2734h = false;
            }
        } else if (this.f2734h) {
            if (this.f2729c.isBluetoothScoOn()) {
                this.f2729c.setBluetoothScoOn(false);
            }
            this.f2729c.stopBluetoothSco();
            this.f2734h = false;
        }
        return this.f2734h;
    }
}

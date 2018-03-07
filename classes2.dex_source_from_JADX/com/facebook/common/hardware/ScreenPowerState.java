package com.facebook.common.hardware;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.PowerManager;
import com.facebook.base.broadcast.BroadcastReceiverManager;
import com.facebook.base.broadcast.ForwardingBroadcastReceiver;
import com.facebook.base.broadcast.GlobalBroadcastReceiverManager;
import com.facebook.common.android.PowerManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: simple */
public class ScreenPowerState {
    private static volatile ScreenPowerState f4736d;
    private final PowerManager f4737a;
    private final BroadcastReceiverManager<PowerChangeListener> f4738b;
    public volatile Boolean f4739c;

    /* compiled from: simple */
    class C02391 implements ForwardingBroadcastReceiver<PowerChangeListener> {
        final /* synthetic */ ScreenPowerState f4745a;

        C02391(ScreenPowerState screenPowerState) {
            this.f4745a = screenPowerState;
        }

        public final void mo1252a(Collection<PowerChangeListener> collection, Intent intent) {
            ScreenPowerState screenPowerState = this.f4745a;
            boolean equals = intent.getAction().equals("android.intent.action.SCREEN_ON");
            screenPowerState.f4739c = Boolean.valueOf(equals);
            for (PowerChangeListener a : collection) {
                a.mo1326a(equals);
            }
        }
    }

    /* compiled from: simple */
    public interface PowerChangeListener {
        void mo1326a(boolean z);
    }

    public static com.facebook.common.hardware.ScreenPowerState m8540a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4736d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.hardware.ScreenPowerState.class;
        monitor-enter(r1);
        r0 = f4736d;	 Catch:{ all -> 0x003a }
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
        r0 = m8541b(r0);	 Catch:{ all -> 0x0035 }
        f4736d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4736d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.hardware.ScreenPowerState.a(com.facebook.inject.InjectorLike):com.facebook.common.hardware.ScreenPowerState");
    }

    private static ScreenPowerState m8541b(InjectorLike injectorLike) {
        return new ScreenPowerState((Context) injectorLike.getInstance(Context.class), PowerManagerMethodAutoProvider.m5525b(injectorLike));
    }

    @Inject
    public ScreenPowerState(Context context, PowerManager powerManager) {
        this.f4737a = powerManager;
        ForwardingBroadcastReceiver c02391 = new C02391(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.setPriority(999);
        this.f4738b = new GlobalBroadcastReceiverManager(context, c02391, intentFilter);
    }

    public final void m8542a(PowerChangeListener powerChangeListener) {
        m8543a(powerChangeListener, null);
    }

    public final void m8543a(PowerChangeListener powerChangeListener, @Nullable Handler handler) {
        synchronized (this) {
            this.f4738b.m8556a(powerChangeListener, handler);
        }
    }

    public final void m8545b(PowerChangeListener powerChangeListener) {
        synchronized (this) {
            this.f4738b.m8555a((Object) powerChangeListener);
            if (this.f4738b.m8557a()) {
                this.f4739c = null;
            }
        }
    }

    public final boolean m8544a() {
        if (this.f4739c != null) {
            return this.f4739c.booleanValue();
        }
        return m8546b();
    }

    public final boolean m8546b() {
        return this.f4737a.isScreenOn();
    }
}

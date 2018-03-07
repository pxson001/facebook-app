package com.facebook.zero.sdk.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.facebook.zero.ui.ZeroIndicatorController.1;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.android.internal.os.BatteryStatsImpl$Uid$Sensor */
public class ZeroIndicatorBase implements ZeroIndicator {
    private static volatile ZeroIndicatorBase f5909k;
    private Notification f5910a;
    private String f5911b;
    private NotificationManager f5912c;
    private int f5913d = 43127089;
    private boolean f5914e = false;
    private Context f5915f;
    private int f5916g;
    private Bitmap f5917h;
    private String f5918i;
    private Class<?> f5919j;

    public static com.facebook.zero.sdk.ui.ZeroIndicatorBase m10705a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5909k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.sdk.ui.ZeroIndicatorBase.class;
        monitor-enter(r1);
        r0 = f5909k;	 Catch:{ all -> 0x003a }
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
        r0 = m10706b(r0);	 Catch:{ all -> 0x0035 }
        f5909k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5909k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.sdk.ui.ZeroIndicatorBase.a(com.facebook.inject.InjectorLike):com.facebook.zero.sdk.ui.ZeroIndicatorBase");
    }

    private static ZeroIndicatorBase m10706b(InjectorLike injectorLike) {
        return new ZeroIndicatorBase(NotificationManagerMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public ZeroIndicatorBase(NotificationManager notificationManager, Context context) {
        this.f5912c = notificationManager;
        this.f5915f = context;
    }

    public void setIndicatorData(ZeroIndicatorData zeroIndicatorData) {
        if (zeroIndicatorData == null) {
            m10708b();
            this.f5910a = null;
            return;
        }
        if (this.f5910a != null) {
            this.f5912c.cancel("ZeroIndicatorBase", this.f5913d);
            this.f5910a = null;
        }
        this.f5911b = zeroIndicatorData.m10680a();
        this.f5918i = zeroIndicatorData.m10683d();
        Intent intent = new Intent(this.f5915f, this.f5919j);
        intent.putExtra("zero_action_url", this.f5918i);
        Builder smallIcon = new Builder(this.f5915f).setContentTitle(this.f5911b).setContentText(zeroIndicatorData.m10681b()).setOngoing(true).setSmallIcon(this.f5916g);
        if (this.f5919j != null) {
            smallIcon.setContentIntent(PendingIntent.getActivity(this.f5915f, 0, intent, 134217728));
        }
        if (this.f5917h != null) {
            smallIcon.setLargeIcon(this.f5917h);
        }
        this.f5910a = smallIcon.build();
        if (this.f5914e) {
            this.f5912c.notify("ZeroIndicatorBase", this.f5913d, this.f5910a);
        }
    }

    public void setListener(1 1) {
    }

    public final void m10707a() {
        if (!this.f5914e && this.f5910a != null) {
            this.f5912c.notify("ZeroIndicatorBase", this.f5913d, this.f5910a);
            this.f5914e = true;
        }
    }

    public final void m10708b() {
        if (this.f5914e) {
            this.f5912c.cancel("ZeroIndicatorBase", this.f5913d);
            this.f5914e = false;
        }
    }

    public final boolean m10709c() {
        return this.f5914e;
    }
}

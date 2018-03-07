package com.facebook.http.onion.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.http.onion.TorProxy.ConnectionState;
import com.facebook.http.onion.TorProxy.State;
import com.facebook.http.onion.TorProxy.TorListener;
import com.facebook.http.onion.prefs.OnionUtils;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.logging.NotificationsLogger.Component;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.model.SystemTrayNotificationBuilder;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: viewer_locations */
public class TorStatusNotificationListener implements TorListener {
    private static volatile TorStatusNotificationListener f366g;
    public final Context f367a;
    private final SystemTrayNotificationManager f368b;
    public final SystemTrayNotificationBuilder f369c;
    private final Lazy<OnionUtils> f370d;
    public NotificationLogObject f371e;
    public Intent f372f;

    public static com.facebook.http.onion.ui.TorStatusNotificationListener m504a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f366g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.onion.ui.TorStatusNotificationListener.class;
        monitor-enter(r1);
        r0 = f366g;	 Catch:{ all -> 0x003a }
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
        r0 = m505b(r0);	 Catch:{ all -> 0x0035 }
        f366g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f366g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.onion.ui.TorStatusNotificationListener.a(com.facebook.inject.InjectorLike):com.facebook.http.onion.ui.TorStatusNotificationListener");
    }

    private static TorStatusNotificationListener m505b(InjectorLike injectorLike) {
        return new TorStatusNotificationListener((Context) injectorLike.getInstance(Context.class), SystemTrayNotificationManager.a(injectorLike), SystemTrayNotificationBuilder.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2273));
    }

    @Inject
    public TorStatusNotificationListener(Context context, SystemTrayNotificationManager systemTrayNotificationManager, SystemTrayNotificationBuilder systemTrayNotificationBuilder, Lazy<OnionUtils> lazy) {
        this.f367a = context;
        this.f368b = systemTrayNotificationManager;
        this.f369c = systemTrayNotificationBuilder;
        this.f370d = lazy;
    }

    public final void m506a() {
    }

    public final void m507a(State state, ConnectionState connectionState) {
        if (state == State.DISABLED) {
            this.f368b.a(NotificationType.TOR_STATUS);
            return;
        }
        if (this.f372f == null || this.f371e == null) {
            this.f372f = new Intent("android.intent.action.VIEW", Uri.parse(FBLinks.a("settings/tor")));
            NotificationLogObject notificationLogObject = new NotificationLogObject();
            notificationLogObject.j = true;
            notificationLogObject = notificationLogObject;
            notificationLogObject.b = NotificationType.TOR_STATUS;
            notificationLogObject = notificationLogObject;
            notificationLogObject.d = 1;
            this.f371e = notificationLogObject;
            SystemTrayNotificationBuilder d = this.f369c.d(this.f367a.getString(2131233724));
            d.k.c(false);
            d = d;
            d.k.b(true);
            d.k.a(Boolean.valueOf(true).booleanValue());
        }
        int i = (connectionState == null || !connectionState.isCheckedConnection()) ? 2130840889 : 2130840890;
        int i2 = connectionState != null ? connectionState.resId : ConnectionState.CHECKING_CONNECTION.resId;
        if (connectionState == ConnectionState.CHECKED_CONNECTION_TOR && ((OnionUtils) this.f370d.get()).d()) {
            i2 = 2131233722;
        }
        CharSequence string = this.f367a.getString(i2);
        SystemTrayNotificationBuilder a = this.f369c.a(string);
        a.k.a(new BigTextStyle().b(string));
        a.a(i);
        this.f368b.a(NotificationType.TOR_STATUS, this.f369c, this.f372f, Component.ACTIVITY, this.f371e);
    }
}

package com.facebook.notifications.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_delay_hours */
public class NotificationsLogger {
    private static final Class<?> f11661a = NotificationsLogger.class;
    private static volatile NotificationsLogger f11662e;
    public final AnalyticsLogger f11663b;
    public final Clock f11664c;
    private final NotificationsFunnelLogger f11665d;

    public static com.facebook.notifications.logging.NotificationsLogger m12207a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11662e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.logging.NotificationsLogger.class;
        monitor-enter(r1);
        r0 = f11662e;	 Catch:{ all -> 0x003a }
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
        r0 = m12208b(r0);	 Catch:{ all -> 0x0035 }
        f11662e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11662e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.logging.NotificationsLogger.a(com.facebook.inject.InjectorLike):com.facebook.notifications.logging.NotificationsLogger");
    }

    private static NotificationsLogger m12208b(InjectorLike injectorLike) {
        return new NotificationsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), NotificationsFunnelLogger.a(injectorLike));
    }

    @Inject
    public NotificationsLogger(AnalyticsLogger analyticsLogger, Clock clock, NotificationsFunnelLogger notificationsFunnelLogger) {
        this.f11663b = analyticsLogger;
        this.f11664c = clock;
        this.f11665d = notificationsFunnelLogger;
    }

    public final void m12210a(@Nullable NotificationLogObject notificationLogObject, Event event) {
        if (notificationLogObject != null) {
            if (event == Event.CLICK_FROM_TRAY) {
                this.f11665d.a(NotificationSource.PUSH, notificationLogObject);
            }
            this.f11663b.c(new PushNotificationEvent(this, event, notificationLogObject));
        }
    }

    public final void m12211a(@Nullable NotificationLogObject notificationLogObject, String str) {
        if (notificationLogObject != null) {
            HoneyClientEventFast a = this.f11663b.a(str, false);
            if (notificationLogObject != null && a.a()) {
                a.a("ct", notificationLogObject.c());
                a.a("ci", notificationLogObject.c);
                if (notificationLogObject.t != null) {
                    a.a("push_source", notificationLogObject.s);
                    a.a("push_id", notificationLogObject.t);
                    a.a("time_to_tray_ms", this.f11664c.a() - notificationLogObject.u);
                }
            }
            HoneyClientEventFast honeyClientEventFast = a;
            if (honeyClientEventFast.a()) {
                honeyClientEventFast.b();
            }
        }
    }

    public final void m12209a(@Nullable NotificationLogObject notificationLogObject) {
        if (notificationLogObject != null) {
            this.f11665d.a(NotificationSource.JEWEL, notificationLogObject);
            this.f11663b.a(new JewelNotificationEvent(this, Event.graph_notification_click, notificationLogObject));
        }
    }
}

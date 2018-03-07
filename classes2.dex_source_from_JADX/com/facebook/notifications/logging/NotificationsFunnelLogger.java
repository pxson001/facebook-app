package com.facebook.notifications.logging;

import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.funnellogger.PayloadBundle;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.logging.NotificationsFunnelLoggingConstants.NotificationActionType;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: has_media */
public class NotificationsFunnelLogger {
    private static volatile NotificationsFunnelLogger f21356b;
    public final FunnelLoggerImpl f21357a;

    public static com.facebook.notifications.logging.NotificationsFunnelLogger m29041a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21356b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.logging.NotificationsFunnelLogger.class;
        monitor-enter(r1);
        r0 = f21356b;	 Catch:{ all -> 0x003a }
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
        r0 = m29043b(r0);	 Catch:{ all -> 0x0035 }
        f21356b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21356b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.logging.NotificationsFunnelLogger.a(com.facebook.inject.InjectorLike):com.facebook.notifications.logging.NotificationsFunnelLogger");
    }

    private static NotificationsFunnelLogger m29043b(InjectorLike injectorLike) {
        return new NotificationsFunnelLogger(FunnelLoggerImpl.m8018a(injectorLike));
    }

    @Inject
    public NotificationsFunnelLogger(FunnelLoggerImpl funnelLoggerImpl) {
        this.f21357a = funnelLoggerImpl;
    }

    public final void m29047a(NotificationSource notificationSource, NotificationLogObject notificationLogObject) {
        this.f21357a.m8033a(FunnelRegistry.f21151Q);
        m29045b("notification_source", notificationSource.name());
        if (notificationSource == NotificationSource.JEWEL) {
            m29042a(notificationLogObject);
        } else if (notificationSource == NotificationSource.PUSH) {
            m29044b(notificationLogObject);
        }
    }

    public final void m29046a() {
        this.f21357a.m8040b(FunnelRegistry.f21151Q);
    }

    public final void m29049b(String str) {
        this.f21357a.m8039a(FunnelRegistry.f21151Q, NotificationActionType.POST.name(), null, PayloadBundle.a().a("composer_session_id", str));
    }

    public final void m29048a(String str, String str2) {
        this.f21357a.m8039a(FunnelRegistry.f21151Q, NotificationActionType.EVENT_RSVP.name(), null, PayloadBundle.a().a("action_type", str).a("event_privacy_type", str2));
    }

    public final void m29050c(String str) {
        this.f21357a.m8039a(FunnelRegistry.f21151Q, NotificationActionType.FRIENDING.name(), null, PayloadBundle.a().a("action_type", str));
    }

    public final void m29051d(String str) {
        this.f21357a.m8039a(FunnelRegistry.f21151Q, NotificationActionType.REACTION.name(), null, PayloadBundle.a().a("reaction_type", str));
    }

    private void m29045b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\":\"");
        stringBuilder.append(str2);
        this.f21357a.m8037a(FunnelRegistry.f21151Q, stringBuilder.toString());
    }

    private void m29042a(NotificationLogObject notificationLogObject) {
        m29045b("notification_position", String.valueOf(notificationLogObject.v));
        m29045b("seen_state", notificationLogObject.A);
        m29045b("logging_data", notificationLogObject.i);
    }

    private void m29044b(NotificationLogObject notificationLogObject) {
        m29045b("alert_id", String.valueOf(notificationLogObject.e));
        m29045b("content_id", String.valueOf(notificationLogObject.g));
        m29045b("notif_type", notificationLogObject.a);
    }
}

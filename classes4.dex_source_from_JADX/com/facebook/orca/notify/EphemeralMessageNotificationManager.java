package com.facebook.orca.notify;

import android.content.res.Resources;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.util.ArrayMap;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.ephemeral.EphemeralProgressUtil;
import com.facebook.messaging.messagerendering.MessageRenderingUtil;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.NewEphemeralMessageNotification;
import com.facebook.wear.NotificationManagerCompatMethodAutoProvider;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: setDownloadedStickerPacks */
public class EphemeralMessageNotificationManager {
    private static volatile EphemeralMessageNotificationManager f2454i;
    private final Clock f2455a;
    public final EphemeralProgressUtil f2456b;
    public final MessagingNotificationUtil f2457c;
    public final MessageRenderingUtil f2458d;
    public final NotificationManagerCompat f2459e;
    public final Resources f2460f;
    private final ScheduledExecutorService f2461g;
    public final Map<ThreadKey, String> f2462h = Collections.synchronizedMap(new ArrayMap());

    public static com.facebook.orca.notify.EphemeralMessageNotificationManager m2728a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2454i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.EphemeralMessageNotificationManager.class;
        monitor-enter(r1);
        r0 = f2454i;	 Catch:{ all -> 0x003a }
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
        r0 = m2731b(r0);	 Catch:{ all -> 0x0035 }
        f2454i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2454i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.EphemeralMessageNotificationManager.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.EphemeralMessageNotificationManager");
    }

    private static EphemeralMessageNotificationManager m2731b(InjectorLike injectorLike) {
        return new EphemeralMessageNotificationManager((Clock) SystemClockMethodAutoProvider.a(injectorLike), EphemeralProgressUtil.m2737b(injectorLike), MessagingNotificationUtil.m2639a(injectorLike), MessageRenderingUtil.m2715a(injectorLike), NotificationManagerCompatMethodAutoProvider.m2552b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EphemeralMessageNotificationManager(Clock clock, EphemeralProgressUtil ephemeralProgressUtil, MessagingNotificationUtil messagingNotificationUtil, MessageRenderingUtil messageRenderingUtil, NotificationManagerCompat notificationManagerCompat, Resources resources, ScheduledExecutorService scheduledExecutorService) {
        this.f2455a = clock;
        this.f2456b = ephemeralProgressUtil;
        this.f2457c = messagingNotificationUtil;
        this.f2458d = messageRenderingUtil;
        this.f2459e = notificationManagerCompat;
        this.f2460f = resources;
        this.f2461g = scheduledExecutorService;
    }

    public final void m2732a(NotificationCompat$Builder notificationCompat$Builder, NewEphemeralMessageNotification newEphemeralMessageNotification) {
        Message message = newEphemeralMessageNotification.c;
        notificationCompat$Builder.m13a(this.f2457c.m2655a(message, this.f2457c.m2654a(message.b)));
        String a = this.f2458d.m2718a(message.e, message.b);
        notificationCompat$Builder.m19b(this.f2460f.getString(2131231884, new Object[]{a}));
    }

    public final void m2734a(NewEphemeralMessageNotification newEphemeralMessageNotification, ThreadKey threadKey, NotificationCompat$Builder notificationCompat$Builder) {
        Preconditions.checkArgument(MessageUtil.V(newEphemeralMessageNotification.c), "NewEphemeralMessageNotifications should always have an ephemeral message");
        m2733a(threadKey);
        m2729a(newEphemeralMessageNotification, threadKey, notificationCompat$Builder, 0);
        Message message = newEphemeralMessageNotification.c;
        this.f2462h.put(message.b, message.a);
    }

    public final void m2733a(ThreadKey threadKey) {
        this.f2462h.remove(threadKey);
        this.f2459e.m2558a(threadKey.toString(), 10023);
    }

    private void m2729a(NewEphemeralMessageNotification newEphemeralMessageNotification, ThreadKey threadKey, NotificationCompat$Builder notificationCompat$Builder, long j) {
        if (newEphemeralMessageNotification.c.a.equals((String) this.f2462h.get(threadKey))) {
            notificationCompat$Builder.m10a(null);
            notificationCompat$Builder.m16a(null);
        }
        this.f2461g.schedule(new 1(this, newEphemeralMessageNotification, threadKey, notificationCompat$Builder), j, TimeUnit.MILLISECONDS);
    }
}

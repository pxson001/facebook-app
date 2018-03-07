package com.facebook.orca.threadview;

import com.facebook.common.banner.BannerNotification;
import com.facebook.common.banner.BannerNotificationPrioritizer;
import com.facebook.messaging.banner.MuteThreadWarningNotification;
import com.facebook.messaging.connectivity.ConnectionStatusNotification;
import com.facebook.messaging.events.banner.EventReminderNotification;
import com.facebook.messaging.groups.banner.GroupJoinRequestNotification;
import com.facebook.messaging.groups.namingbar.GroupNamingBarBanner;
import com.facebook.messaging.invites.quickinvites.InviteToMessengerBannerNotification;
import com.facebook.messaging.payment.thread.banner.IncomingPaymentRequestBannerNotification;
import com.facebook.messaging.payment.thread.banner.PaymentPlatformContextBannerNotification;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: member_requests */
public class ThreadViewMessagesFragmentBannerNotificationPrioritizer implements BannerNotificationPrioritizer {
    private static final Map<Class<? extends BannerNotification>, Integer> f7839a = new Builder().b(ConnectionStatusNotification.class, Integer.valueOf(8)).b(IncomingPaymentRequestBannerNotification.class, Integer.valueOf(7)).b(PaymentPlatformContextBannerNotification.class, Integer.valueOf(6)).b(GroupJoinRequestNotification.class, Integer.valueOf(5)).b(GroupNamingBarBanner.class, Integer.valueOf(4)).b(InviteToMessengerBannerNotification.class, Integer.valueOf(3)).b(MuteThreadWarningNotification.class, Integer.valueOf(2)).b(EventReminderNotification.class, Integer.valueOf(1)).b();
    private static volatile ThreadViewMessagesFragmentBannerNotificationPrioritizer f7840b;

    public static com.facebook.orca.threadview.ThreadViewMessagesFragmentBannerNotificationPrioritizer m7767a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f7840b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.orca.threadview.ThreadViewMessagesFragmentBannerNotificationPrioritizer.class;
        monitor-enter(r1);
        r0 = f7840b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m7766a();	 Catch:{ all -> 0x0034 }
        f7840b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f7840b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.ThreadViewMessagesFragmentBannerNotificationPrioritizer.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadview.ThreadViewMessagesFragmentBannerNotificationPrioritizer");
    }

    private static ThreadViewMessagesFragmentBannerNotificationPrioritizer m7766a() {
        return new ThreadViewMessagesFragmentBannerNotificationPrioritizer();
    }

    public final int m7768a(Class<? extends BannerNotification> cls) {
        return ((Integer) f7839a.get(cls)).intValue();
    }
}

package com.facebook.orca.notify;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.sms.NeueSmsPreferenceActivity;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_impressions */
public class SmsFallbackNumberNotificationHandler$ReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<SmsFallbackNumberNotificationHandler> {
    private static volatile SmsFallbackNumberNotificationHandler$ReceiverRegistration f2339a;

    public static com.facebook.orca.notify.SmsFallbackNumberNotificationHandler$ReceiverRegistration m4529a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2339a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.SmsFallbackNumberNotificationHandler$ReceiverRegistration.class;
        monitor-enter(r1);
        r0 = f2339a;	 Catch:{ all -> 0x003a }
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
        r0 = m4530b(r0);	 Catch:{ all -> 0x0035 }
        f2339a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2339a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.SmsFallbackNumberNotificationHandler$ReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.SmsFallbackNumberNotificationHandler$ReceiverRegistration");
    }

    private static SmsFallbackNumberNotificationHandler$ReceiverRegistration m4530b(InjectorLike injectorLike) {
        return new SmsFallbackNumberNotificationHandler$ReceiverRegistration(IdBasedLazy.m1808a(injectorLike, 8805));
    }

    protected void onReceive(Context context, Intent intent, Object obj) {
        SmsFallbackNumberNotificationHandler smsFallbackNumberNotificationHandler = (SmsFallbackNumberNotificationHandler) obj;
        if (intent.getBooleanExtra("default_sms", false) && TextUtils.isEmpty(((TelephonyManager) smsFallbackNumberNotificationHandler.e.get()).getLine1Number()) && TextUtils.isEmpty(smsFallbackNumberNotificationHandler.d.mo278a(SmsPrefKeys.L, null))) {
            Builder builder = new Builder(smsFallbackNumberNotificationHandler.a);
            BigTextStyle b = new BigTextStyle().b(smsFallbackNumberNotificationHandler.a.getString(2131231466));
            PendingIntent a = SecurePendingIntent.a(smsFallbackNumberNotificationHandler.a, 0, new Intent(smsFallbackNumberNotificationHandler.a, NeueSmsPreferenceActivity.class), 134217728);
            builder = builder.a(smsFallbackNumberNotificationHandler.a.getString(2131231465)).b(smsFallbackNumberNotificationHandler.a.getString(2131231466));
            FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = smsFallbackNumberNotificationHandler.b;
            builder = builder.a(2130843533);
            builder.d = a;
            smsFallbackNumberNotificationHandler.c.a(10028, builder.c(true).a(b).c());
            ((SmsTakeoverAnalyticsLogger) smsFallbackNumberNotificationHandler.f.get()).d();
            return;
        }
        smsFallbackNumberNotificationHandler.c.a(10028);
    }

    @Inject
    public SmsFallbackNumberNotificationHandler$ReceiverRegistration(Lazy<SmsFallbackNumberNotificationHandler> lazy) {
        super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, MessagesBroadcastIntents.f2370y);
    }
}

package com.facebook.sideloading;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hasClickedOnCoverPhotoUpload */
public class SideloadingNotifier {
    private static final Class<?> f10077a = SideloadingNotifier.class;
    private static final long[] f10078b = new long[]{0, 250, 200, 250};
    private static volatile SideloadingNotifier f10079i;
    public final Context f10080c;
    public final SecureContextHelper f10081d;
    private final DefaultAndroidThreadUtil f10082e;
    private final Resources f10083f;
    private final NotificationManager f10084g;
    private final SideloadingLogger f10085h;

    public static com.facebook.sideloading.SideloadingNotifier m10150a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10079i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sideloading.SideloadingNotifier.class;
        monitor-enter(r1);
        r0 = f10079i;	 Catch:{ all -> 0x003a }
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
        r0 = m10154b(r0);	 Catch:{ all -> 0x0035 }
        f10079i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10079i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sideloading.SideloadingNotifier.a(com.facebook.inject.InjectorLike):com.facebook.sideloading.SideloadingNotifier");
    }

    private static SideloadingNotifier m10154b(InjectorLike injectorLike) {
        return new SideloadingNotifier((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), NotificationManagerMethodAutoProvider.b(injectorLike), SideloadingLogger.m10126b(injectorLike));
    }

    @Inject
    public SideloadingNotifier(Context context, SecureContextHelper secureContextHelper, DefaultAndroidThreadUtil defaultAndroidThreadUtil, Resources resources, NotificationManager notificationManager, SideloadingLogger sideloadingLogger) {
        this.f10080c = context;
        this.f10081d = secureContextHelper;
        this.f10082e = defaultAndroidThreadUtil;
        this.f10083f = resources;
        this.f10084g = notificationManager;
        this.f10085h = sideloadingLogger;
    }

    private synchronized void m10152a(String str, String str2, int i, String str3, String str4, String str5) {
        PendingIntent a = SecurePendingIntent.a(this.f10080c, 0, m10153b(str, str2, "notification"), 134217728);
        BigTextStyle a2 = new BigTextStyle().b(str4).a(str3);
        this.f10084g.notify(1090, new Builder(this.f10080c).a(i).a(str3).b(str4).a(a2).e(str5).a(a).c(true).a(f10078b).a(RingtoneManager.getDefaultUri(2)).c());
        this.f10085h.m10127a("sideloading_post_ready_to_install_notification");
    }

    public final void m10155a(String str, String str2) {
        m10152a(str, str2, 2130842225, this.f10083f.getString(2131241333), this.f10083f.getString(2131241334), this.f10083f.getString(2131241335));
    }

    public final synchronized void m10156a(String str, String str2, String str3) {
        Intent b = m10153b(str, str2, str3);
        if (b != null) {
            b.addFlags(268435456);
            m10151a(b);
        }
    }

    private void m10151a(final Intent intent) {
        this.f10082e.a(new Runnable(this) {
            final /* synthetic */ SideloadingNotifier f10076b;

            public void run() {
                this.f10076b.f10081d.a(intent, this.f10076b.f10080c);
            }
        });
    }

    private Intent m10153b(String str, String str2, String str3) {
        Intent intent = new Intent(this.f10080c, SideloadingInstallActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("local_uri", str);
        intent.putExtra("package_name", str2);
        intent.putExtra("triggered_from", str3);
        return intent;
    }
}

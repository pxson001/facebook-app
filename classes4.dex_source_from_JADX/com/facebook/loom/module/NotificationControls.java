package com.facebook.loom.module;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.core.LoomConstants;
import com.facebook.loom.core.TraceControl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mUpdateThrottle= */
public class NotificationControls implements INeedInit, OnSharedPreferenceChangeListener {
    private static final String f8464a = ("com.facebook.loom.CONTROL_TOGGLE." + Process.myPid());
    private static volatile NotificationControls f8465j;
    private final NotificationManager f8466b;
    private FbSharedPreferences f8467c;
    private final Context f8468d;
    @Nullable
    private PendingIntent f8469e;
    private boolean f8470f = false;
    public boolean f8471g = false;
    private boolean f8472h = false;
    @Nullable
    private Notification f8473i;

    /* compiled from: mUpdateThrottle= */
    class C05281 implements ActionReceiver {
        final /* synthetic */ NotificationControls f11132a;

        C05281(NotificationControls notificationControls) {
            this.f11132a = notificationControls;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2046803953);
            synchronized (this.f11132a) {
                try {
                    if (this.f11132a.f8471g) {
                        NotificationControls.m8713b(this.f11132a);
                    } else {
                        NotificationControls.m8715c(this.f11132a);
                    }
                } finally {
                    LogUtils.e(-1923115799, a);
                }
            }
        }
    }

    public static com.facebook.loom.module.NotificationControls m8709a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8465j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.loom.module.NotificationControls.class;
        monitor-enter(r1);
        r0 = f8465j;	 Catch:{ all -> 0x003a }
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
        r0 = m8712b(r0);	 Catch:{ all -> 0x0035 }
        f8465j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8465j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.loom.module.NotificationControls.a(com.facebook.inject.InjectorLike):com.facebook.loom.module.NotificationControls");
    }

    private static NotificationControls m8712b(InjectorLike injectorLike) {
        return new NotificationControls((Context) injectorLike.getInstance(Context.class), NotificationManagerMethodAutoProvider.m8723b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    NotificationControls(Context context, NotificationManager notificationManager, FbSharedPreferences fbSharedPreferences) {
        this.f8468d = context;
        this.f8466b = notificationManager;
        this.f8467c = fbSharedPreferences;
    }

    public synchronized void init() {
        IntentFilter intentFilter = new IntentFilter(f8464a);
        this.f8468d.registerReceiver(new DynamicSecureBroadcastReceiver(f8464a, new C05281(this)), intentFilter);
        this.f8469e = PendingIntent.getBroadcast(this.f8468d, 0, new Intent(f8464a), 134217728);
        this.f8467c.a(LoomConstants.a, this);
        m8719a(this.f8467c, LoomConstants.a);
    }

    public final synchronized void m8719a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
        if (prefKey.equals(LoomConstants.a)) {
            m8714b(fbSharedPreferences.a(prefKey, false));
        }
    }

    final synchronized boolean m8721a() {
        return this.f8470f;
    }

    private synchronized void m8714b(boolean z) {
        if (z) {
            m8716c(this.f8471g);
        } else {
            m8717d();
        }
        this.f8470f = z;
    }

    static /* synthetic */ void m8713b(NotificationControls notificationControls) {
        TraceControl traceControl = TraceControl.b;
        if (traceControl != null) {
            traceControl.a(4, null, 0);
        }
    }

    static /* synthetic */ void m8715c(NotificationControls notificationControls) {
        TraceControl traceControl = TraceControl.b;
        if (traceControl != null) {
            traceControl.a(4, 1, null, 0);
        }
    }

    final synchronized void m8720a(boolean z) {
        if (this.f8470f && this.f8471g != z) {
            m8716c(z);
            this.f8471g = z;
        }
    }

    final synchronized void m8718a(UploadState uploadState) {
        if (this.f8470f) {
            CharSequence charSequence;
            CharSequence charSequence2;
            switch (2.a[uploadState.ordinal()]) {
                case 1:
                    charSequence = "Uploading Loom trace";
                    charSequence2 = "Uploading trace";
                    break;
                case 2:
                    charSequence = "Trace upload was successful";
                    charSequence2 = "Upload successful";
                    break;
                case 3:
                    charSequence = "Trace upload failed";
                    charSequence2 = "Upload failed";
                    break;
                default:
                    charSequence2 = "Trace upload status unknown";
                    charSequence = charSequence2;
                    break;
            }
            NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this.f8468d);
            notificationCompat$Builder.m24d(-1).m2a(17301589).m13a(charSequence).m26e(charSequence2);
            m8711a(201, notificationCompat$Builder.m21c());
        }
    }

    private void m8716c(boolean z) {
        TraceControl traceControl = TraceControl.b;
        if (traceControl == null) {
            throw new IllegalStateException("TraceControl is null and we're showing a notification");
        }
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence format;
        String c = traceControl.c();
        if (z) {
            charSequence = "Loom is weaving";
            charSequence2 = "Tap to stop and upload trace";
            format = String.format(Locale.ENGLISH, "%s\n\nTrace ID: %s", new Object[]{charSequence2, c});
        } else {
            format = "Tap to start tracing";
            Object obj = "Loom is primed and ready";
            charSequence2 = format;
        }
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this.f8468d);
        NotificationCompat$Builder e = notificationCompat$Builder.m26e("Loom controls");
        e.f12j = 1;
        e = e.m2a(17301593);
        e.f6d = this.f8469e;
        e.m15a(true).m13a(charSequence).m19b(charSequence2).m12a(new BigTextStyle(notificationCompat$Builder).b(format));
        this.f8473i = notificationCompat$Builder.m21c();
        m8711a(200, this.f8473i);
    }

    private void m8717d() {
        this.f8473i = null;
        m8710a(200);
    }

    private void m8711a(int i, @Nullable Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("notification can't be null");
        }
        try {
            this.f8466b.notify(i, notification);
        } catch (NullPointerException e) {
        }
    }

    private void m8710a(int i) {
        try {
            this.f8466b.cancel(i);
        } catch (NullPointerException e) {
        }
    }
}

package com.facebook.facecast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.SecurePendingIntent;
import com.facebook.facecastdisplay.analytics.FacecastDisplayLogger;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bulk_contacts_delete */
public class FacecastPausedNotificationManager {
    public static final long[] f18034a = new long[]{0, 100};
    public final NotificationManager f18035b;
    public final Context f18036c;
    public final Resources f18037d;
    private final Handler f18038e;
    public final Clock f18039f;
    private final boolean f18040g;
    public final FacecastDisplayLogger f18041h;
    @Nullable
    private Runnable f18042i = new C15241(this);

    /* compiled from: bulk_contacts_delete */
    class C15241 implements Runnable {
        final /* synthetic */ FacecastPausedNotificationManager f18033a;

        C15241(FacecastPausedNotificationManager facecastPausedNotificationManager) {
            this.f18033a = facecastPausedNotificationManager;
        }

        public void run() {
            FacecastPausedNotificationManager facecastPausedNotificationManager = this.f18033a;
            PendingIntent a = SecurePendingIntent.a(facecastPausedNotificationManager.f18036c, 0, new Intent(facecastPausedNotificationManager.f18036c, FacecastActivity.class), 134217728);
            CharSequence nullToEmpty = Strings.nullToEmpty(facecastPausedNotificationManager.f18037d.getString(2131238291));
            CharSequence nullToEmpty2 = Strings.nullToEmpty(facecastPausedNotificationManager.f18037d.getString(2131238292));
            Builder a2 = new Builder(facecastPausedNotificationManager.f18036c).a(nullToEmpty).b(nullToEmpty2).e(nullToEmpty2).a(2130843529);
            a2.d = a;
            Builder a3 = a2.c(true).a(facecastPausedNotificationManager.f18039f.a());
            a3.j = 1;
            a3 = a3.a(FacecastPausedNotificationManager.f18034a);
            a3.z = 1;
            facecastPausedNotificationManager.f18035b.notify(null, 10086, a3.c());
            facecastPausedNotificationManager.f18041h.m3311e();
        }
    }

    public static FacecastPausedNotificationManager m21872a(InjectorLike injectorLike) {
        return new FacecastPausedNotificationManager((Context) injectorLike.getInstance(Context.class, ForAppContext.class), NotificationManagerMethodAutoProvider.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FacecastDisplayLogger.m3304a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FacecastPausedNotificationManager(@ForAppContext Context context, NotificationManager notificationManager, Resources resources, Handler handler, Clock clock, FacecastDisplayLogger facecastDisplayLogger, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f18036c = context;
        this.f18035b = notificationManager;
        this.f18037d = resources;
        this.f18038e = handler;
        this.f18039f = clock;
        this.f18041h = facecastDisplayLogger;
        this.f18040g = gatekeeperStoreImpl.a(572, false);
    }

    public final void m21873a() {
        if (this.f18040g) {
            m21874b();
            HandlerDetour.b(this.f18038e, this.f18042i, 10000, 85063618);
            this.f18041h.m3310d();
        }
    }

    public final void m21874b() {
        if (this.f18040g) {
            HandlerDetour.a(this.f18038e, this.f18042i);
            this.f18035b.cancel(10086);
        }
    }
}

package com.facebook.rtc.campon;

import android.content.Context;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.random.InsecureRandom;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.rtc.VoipNotificationPreferencesMethodAutoProvider;
import com.facebook.rtc.WebrtcCallStatusObserverMethodAutoProvider;
import com.facebook.rtc.interfaces.VoipNotificationPreferences;
import com.facebook.rtc.interfaces.WebrtcCallStatusObserver;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: audio_data */
public class RtcCallerCamper extends RtcCallCamper {
    private static final String f19254l = RtcCallerCamper.class.getName();
    @Inject
    VoipNotificationPreferences f19255g;
    @Inject
    WebrtcCallStatusObserver f19256h;
    @Inject
    Clock f19257i;
    @Inject
    @ForUiThread
    public ScheduledExecutorService f19258j;
    @Inject
    @InsecureRandom
    public Random f19259k;
    public final boolean f19260m;
    private final long f19261n;
    private long f19262o;
    public ScheduledFuture f19263p;

    /* compiled from: audio_data */
    public class C22781 implements Runnable {
        final /* synthetic */ RtcCallerCamper f19253a;

        public C22781(RtcCallerCamper rtcCallerCamper) {
            this.f19253a = rtcCallerCamper;
        }

        public void run() {
            this.f19253a.f19246a.f19300u.remove(Long.valueOf(this.f19253a.f19247b));
            WebrtcCallStatusObserver webrtcCallStatusObserver = this.f19253a.f19256h;
            boolean z = this.f19253a.f19260m;
            this.f19253a.f19257i.a();
            VoipNotificationPreferences voipNotificationPreferences = this.f19253a.f19255g;
        }
    }

    private static <T extends InjectableComponentWithoutContext> void m19300a(Class<T> cls, T t, Context context) {
        m19301a(t, context);
    }

    private static void m19301a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RtcCallerCamper) obj).m19299a(VoipNotificationPreferencesMethodAutoProvider.m19090a(fbInjector), WebrtcCallStatusObserverMethodAutoProvider.m19091a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), Random_InsecureRandomMethodAutoProvider.a(fbInjector));
    }

    public RtcCallerCamper(RtcCampOnManager rtcCampOnManager, long j, boolean z, long j2, long j3, long j4) {
        super(rtcCampOnManager, j, j2, j4);
        this.f19260m = z;
        this.f19261n = j3;
        m19300a(RtcCallerCamper.class, this, rtcCampOnManager.m19325a());
    }

    private void m19299a(VoipNotificationPreferences voipNotificationPreferences, WebrtcCallStatusObserver webrtcCallStatusObserver, Clock clock, ScheduledExecutorService scheduledExecutorService, Random random) {
        this.f19255g = voipNotificationPreferences;
        this.f19256h = webrtcCallStatusObserver;
        this.f19257i = clock;
        this.f19258j = scheduledExecutorService;
        this.f19259k = random;
    }

    public final boolean mo811e() {
        Calendar instance = GregorianCalendar.getInstance();
        instance.setTimeInMillis(this.f19257i.a());
        int i = instance.get(11);
        if (i >= 23 || i < 7 || this.f19246a.m19330c() || this.f19246a.m19331d() || !this.f19246a.f19282c.e() || this.f19262o <= 0 || this.f19262o - this.f19250e <= this.f19261n) {
            return false;
        }
        return true;
    }

    public final void mo812g() {
        this.f19262o = 0;
    }

    public final void mo814i() {
        if (this.f19263p != null) {
            this.f19263p.cancel(false);
            this.f19263p = null;
        }
    }

    public final void mo813h() {
        int max = Math.max(this.f19259k.nextInt(20000), 2000);
        mo814i();
        this.f19263p = this.f19258j.schedule(new C22781(this), (long) max, TimeUnit.MILLISECONDS);
        this.f19246a.f19300u.put(Long.valueOf(this.f19247b), this);
    }

    public final void mo815j() {
        Long.valueOf(this.f19247b);
        this.f19262o = this.f19257i.a();
    }

    public final boolean mo816l() {
        return true;
    }
}

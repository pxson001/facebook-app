package com.facebook.rtc.campon;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.rtc.VoipNotificationPreferencesMethodAutoProvider;
import com.facebook.rtc.WebrtcCallStatusObserverMethodAutoProvider;
import com.facebook.rtc.interfaces.VoipNotificationPreferences;
import com.facebook.rtc.interfaces.WebrtcCallStatusObserver;
import javax.inject.Inject;

/* compiled from: audio/x-wav */
public class RtcIncomingMissedCallCamper extends RtcCallCamper {
    private static final String f19304i = RtcIncomingMissedCallCamper.class.getName();
    @Inject
    public VoipNotificationPreferences f19305g;
    @Inject
    public WebrtcCallStatusObserver f19306h;

    public static void m19334a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RtcIncomingMissedCallCamper rtcIncomingMissedCallCamper = (RtcIncomingMissedCallCamper) obj;
        VoipNotificationPreferences a = VoipNotificationPreferencesMethodAutoProvider.m19090a(fbInjector);
        WebrtcCallStatusObserver a2 = WebrtcCallStatusObserverMethodAutoProvider.m19091a(fbInjector);
        rtcIncomingMissedCallCamper.f19305g = a;
        rtcIncomingMissedCallCamper.f19306h = a2;
    }

    public RtcIncomingMissedCallCamper(RtcCampOnManager rtcCampOnManager, long j, long j2, long j3) {
        super(rtcCampOnManager, j, j2, j3);
        Class cls = RtcIncomingMissedCallCamper.class;
        m19334a(this, rtcCampOnManager.f19281b);
    }

    public final boolean mo811e() {
        return (this.f19246a.m19330c() || this.f19246a.m19331d()) ? false : true;
    }

    public final void mo812g() {
    }

    public final void mo813h() {
    }

    public final boolean mo816l() {
        return true;
    }
}

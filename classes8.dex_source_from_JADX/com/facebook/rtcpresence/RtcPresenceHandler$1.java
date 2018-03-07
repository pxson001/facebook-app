package com.facebook.rtcpresence;

import com.facebook.user.model.UserKey;
import java.lang.ref.WeakReference;

/* compiled from: notif_rule */
public class RtcPresenceHandler$1 extends RtcPresenceFetcherListener {
    final /* synthetic */ long f7805a;
    final /* synthetic */ WeakReference f7806b;
    final /* synthetic */ RtcPresenceHandler f7807c;

    public RtcPresenceHandler$1(RtcPresenceHandler rtcPresenceHandler, long j, WeakReference weakReference) {
        this.f7807c = rtcPresenceHandler;
        this.f7805a = j;
        this.f7806b = weakReference;
    }

    public final void mo516a(UserKey userKey, RtcPresenceState rtcPresenceState) {
        this.f7807c.d.now();
        if (rtcPresenceState != null) {
            this.f7807c.c.a(userKey, rtcPresenceState);
        }
        RtcPresenceListenerDefault rtcPresenceListenerDefault = (RtcPresenceListenerDefault) this.f7806b.get();
        if (rtcPresenceListenerDefault != null) {
            rtcPresenceListenerDefault.m8053a();
        }
    }

    public final void mo515a() {
        RtcPresenceListenerDefault rtcPresenceListenerDefault = (RtcPresenceListenerDefault) this.f7806b.get();
        if (rtcPresenceListenerDefault != null) {
            rtcPresenceListenerDefault.m8054b();
        }
    }
}

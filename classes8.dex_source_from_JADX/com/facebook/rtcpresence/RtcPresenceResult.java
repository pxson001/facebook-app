package com.facebook.rtcpresence;

import com.facebook.user.model.UserKey;
import java.util.HashMap;
import java.util.Map;

/* compiled from: notice_subtitle */
class RtcPresenceResult {
    private final Map<UserKey, RtcPresenceState> f7822a = new HashMap();

    RtcPresenceResult() {
    }

    public final void m8060a(UserKey userKey, RtcPresenceState rtcPresenceState) {
        this.f7822a.put(userKey, rtcPresenceState);
    }

    public final Map<UserKey, RtcPresenceState> m8059a() {
        return this.f7822a;
    }
}

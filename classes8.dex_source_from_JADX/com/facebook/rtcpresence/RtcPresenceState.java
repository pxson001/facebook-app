package com.facebook.rtcpresence;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: notice_style */
public class RtcPresenceState {
    public final boolean f7823a;
    public final boolean f7824b;
    public final String f7825c;
    public final String f7826d;
    public final long f7827e;
    public final ImmutableMap<String, String> f7828f;

    public RtcPresenceState(boolean z, String str, String str2, long j, ImmutableMap<String, String> immutableMap) {
        this(z, z, str, str2, j, immutableMap);
    }

    public RtcPresenceState(boolean z, boolean z2, String str, String str2, long j, ImmutableMap<String, String> immutableMap) {
        this.f7823a = z;
        this.f7824b = z2;
        this.f7825c = str;
        if (str2 == null) {
            str2 = "";
        }
        this.f7826d = str2;
        this.f7827e = j;
        this.f7828f = immutableMap;
    }

    public RtcPresenceState(boolean z, String str, String str2, long j) {
        this(z, str, str2, j, RegularImmutableBiMap.a);
    }

    public final long m8061e() {
        return this.f7827e;
    }
}

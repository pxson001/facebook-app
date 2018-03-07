package com.facebook.xconfig.sync;

import com.facebook.common.util.TriState;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: sms_takeover_message_received */
public class XSyncConfigResult {
    public final String f2000a;
    public final ImmutableMap<String, String> f2001b;
    public final String f2002c;
    public final boolean f2003d;
    public final TriState f2004e;

    XSyncConfigResult(String str, ImmutableMap<String, String> immutableMap, String str2, boolean z, boolean z2) {
        this.f2000a = str;
        this.f2001b = immutableMap;
        this.f2002c = str2;
        this.f2003d = z;
        this.f2004e = z ? TriState.valueOf(z2) : TriState.UNSET;
    }

    public String toString() {
        return "XSyncConfigResult{name='" + this.f2000a + '\'' + ", settingNamesToValues=" + this.f2001b + ", valueHash='" + this.f2002c + '\'' + ", hasDebugInfo=" + this.f2003d + ", wouldHaveSkipped=" + this.f2004e + '}';
    }
}

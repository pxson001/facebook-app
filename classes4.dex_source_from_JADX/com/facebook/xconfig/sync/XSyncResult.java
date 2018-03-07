package com.facebook.xconfig.sync;

import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: sms_takeover_message_downloaded */
public class XSyncResult {
    public final ImmutableMap<String, XSyncConfigResult> f2005a;

    XSyncResult(ImmutableMap<String, XSyncConfigResult> immutableMap) {
        this.f2005a = immutableMap;
    }
}

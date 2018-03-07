package com.facebook.rtcpresence;

import com.facebook.common.callercontext.CallerContext;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.Callable;

/* compiled from: notice_title_color */
public class RtcPresenceLoader$2 implements Callable<RtcPresenceResult> {
    final /* synthetic */ ImmutableSet f7814a;
    final /* synthetic */ RtcPresenceLoader f7815b;

    public RtcPresenceLoader$2(RtcPresenceLoader rtcPresenceLoader, ImmutableSet immutableSet) {
        this.f7815b = rtcPresenceLoader;
        this.f7814a = immutableSet;
    }

    public Object call() {
        return (RtcPresenceResult) this.f7815b.f.a(this.f7815b.g, new RtcPresenceParams(this.f7814a), CallerContext.a(RtcPresenceLoader.class));
    }
}

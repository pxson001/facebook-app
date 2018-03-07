package com.facebook.rtcpresence;

import com.facebook.debug.log.BLog;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: notice_title_color */
public class RtcPresenceLoader$PresenceCallback implements FutureCallback<RtcPresenceResult> {
    final /* synthetic */ RtcPresenceLoader f7816a;
    private final ImmutableSet<UserKey> f7817b;

    public void onSuccess(@Nullable Object obj) {
        RtcPresenceResult rtcPresenceResult = (RtcPresenceResult) obj;
        synchronized (this) {
            Map a;
            RtcPresenceLoader.a();
            if (rtcPresenceResult != null) {
                a = rtcPresenceResult.m8059a();
            } else {
                a = null;
            }
            RtcPresenceLoader.d.removeAll(this.f7817b);
            Map e = RtcPresenceLoader.e(this.f7817b);
            Iterator it = this.f7817b.iterator();
            while (it.hasNext()) {
                UserKey userKey = (UserKey) it.next();
                if (e.containsKey(userKey)) {
                    for (RtcPresenceFetcherListener rtcPresenceFetcherListener : (List) e.get(userKey)) {
                        if (a == null || !a.containsKey(userKey)) {
                            rtcPresenceFetcherListener.mo516a(userKey, null);
                        } else {
                            rtcPresenceFetcherListener.mo516a(userKey, (RtcPresenceState) a.get(userKey));
                        }
                    }
                }
            }
            for (RtcPresenceFetcherListener a2 : RtcPresenceLoader.f(this.f7817b)) {
                a2.mo517a(ImmutableMap.copyOf(a));
            }
        }
    }

    public RtcPresenceLoader$PresenceCallback(RtcPresenceLoader rtcPresenceLoader, Set<UserKey> set) {
        this.f7816a = rtcPresenceLoader;
        this.f7817b = ImmutableSet.copyOf(set);
    }

    public synchronized void onFailure(Throwable th) {
        BLog.a(RtcPresenceLoader.a, th, "Presence callback onFailure", new Object[0]);
        RtcPresenceLoader.d.removeAll(this.f7817b);
        Map e = RtcPresenceLoader.e(this.f7817b);
        Set<RtcPresenceFetcherListener> f = RtcPresenceLoader.f(this.f7817b);
        for (List addAll : e.values()) {
            f.addAll(addAll);
        }
        for (RtcPresenceFetcherListener a : f) {
            a.mo515a();
        }
    }
}

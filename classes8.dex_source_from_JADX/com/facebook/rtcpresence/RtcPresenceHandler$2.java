package com.facebook.rtcpresence;

import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: notif_rule */
public class RtcPresenceHandler$2 extends RtcPresenceFetcherListener {
    final /* synthetic */ ImmutableSet f7808a;
    final /* synthetic */ WeakReference f7809b;
    final /* synthetic */ RtcPresenceHandler f7810c;
    private final Set<UserKey> f7811d = new HashSet(this.f7808a);

    public RtcPresenceHandler$2(RtcPresenceHandler rtcPresenceHandler, ImmutableSet immutableSet, WeakReference weakReference) {
        this.f7810c = rtcPresenceHandler;
        this.f7808a = immutableSet;
        this.f7809b = weakReference;
    }

    public final void mo517a(ImmutableMap<UserKey, RtcPresenceState> immutableMap) {
        Iterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            this.f7810c.c.a((UserKey) entry.getKey(), (RtcPresenceState) entry.getValue());
        }
        RtcPresenceListenerDefault rtcPresenceListenerDefault = (RtcPresenceListenerDefault) this.f7809b.get();
        ImmutableSet keySet = immutableMap.keySet();
        if (rtcPresenceListenerDefault != null && !keySet.isEmpty()) {
            this.f7811d.removeAll(keySet);
            if (this.f7811d.isEmpty()) {
                rtcPresenceListenerDefault.m8053a();
            }
        }
    }

    public final void mo515a() {
        RtcPresenceListenerDefault rtcPresenceListenerDefault = (RtcPresenceListenerDefault) this.f7809b.get();
        if (rtcPresenceListenerDefault != null) {
            rtcPresenceListenerDefault.m8054b();
        }
    }
}

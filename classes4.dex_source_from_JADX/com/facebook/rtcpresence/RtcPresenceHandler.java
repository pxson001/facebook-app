package com.facebook.rtcpresence;

import android.net.NetworkInfo;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtcpresence.abtests.ExperimentsForRtcPresenceModule;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableSet;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: session_id=? */
public class RtcPresenceHandler {
    private final Provider<Boolean> f2521a;
    private final DeviceConditionHelper f2522b;
    public final RtcPresenceCache f2523c;
    public final MonotonicClock f2524d;
    public final RtcPresenceLoader f2525e;
    public final RtcPresenceFallbackStrategy f2526f;
    private final QeAccessor f2527g;

    public static RtcPresenceHandler m2807b(InjectorLike injectorLike) {
        return new RtcPresenceHandler(IdBasedProvider.a(injectorLike, 4314), DeviceConditionHelper.a(injectorLike), RtcPresenceCache.m2815a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), RtcPresenceLoader.m2819a(injectorLike), (RtcPresenceFallbackStrategy) null, (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RtcPresenceHandler(Provider<Boolean> provider, DeviceConditionHelper deviceConditionHelper, RtcPresenceCache rtcPresenceCache, MonotonicClock monotonicClock, RtcPresenceLoader rtcPresenceLoader, RtcPresenceFallbackStrategy rtcPresenceFallbackStrategy, QeAccessor qeAccessor) {
        this.f2521a = provider;
        this.f2522b = deviceConditionHelper;
        this.f2523c = rtcPresenceCache;
        this.f2524d = monotonicClock;
        this.f2525e = rtcPresenceLoader;
        this.f2526f = rtcPresenceFallbackStrategy;
        this.f2527g = qeAccessor;
    }

    public static RtcPresenceHandler m2804a(InjectorLike injectorLike) {
        return m2807b(injectorLike);
    }

    public final void m2812a(UserKey userKey, @Nullable RtcPresenceListenerDefault rtcPresenceListenerDefault) {
        if (userKey != null) {
            if (m2809b()) {
                if (!m2806a(this.f2523c.m2817a(userKey))) {
                    this.f2525e.m2826a(userKey, new 1(this, this.f2524d.now(), new WeakReference(rtcPresenceListenerDefault)));
                } else if (rtcPresenceListenerDefault != null) {
                    rtcPresenceListenerDefault.a();
                }
            } else if (rtcPresenceListenerDefault != null) {
                rtcPresenceListenerDefault.a();
            }
        }
    }

    public final void m2814a(Set<UserKey> set, @Nullable RtcPresenceListener rtcPresenceListener) {
        if (m2809b()) {
            Collection hashSet = new HashSet();
            Collection hashSet2 = new HashSet();
            for (UserKey userKey : set) {
                if (m2806a(this.f2523c.m2817a(userKey))) {
                    hashSet.add(userKey);
                } else {
                    hashSet2.add(userKey);
                }
            }
            if (!(hashSet.isEmpty() || rtcPresenceListener == null)) {
                ImmutableSet.copyOf(hashSet);
            }
            if (!hashSet2.isEmpty()) {
                ImmutableSet copyOf = ImmutableSet.copyOf(hashSet2);
                this.f2525e.m2827a(copyOf, new 2(this, copyOf, new WeakReference(rtcPresenceListener)));
            }
        } else if (rtcPresenceListener != null) {
            rtcPresenceListener.a();
        }
    }

    public final void m2813a(UserKey userKey, boolean z, String str, String str2) {
        this.f2523c.m2818a(userKey, new RtcPresenceState(z, str, str2, this.f2524d.now()));
    }

    public final RtcPresenceState m2811a(UserKey userKey) {
        RtcPresenceState b = m2808b(userKey);
        return (b.a || b.d == null || !((b.d.equals(RtcAbortedCallReasonIds.b) || b.d.equals(RtcAbortedCallReasonIds.c)) && this.f2527g.a(ExperimentsForRtcPresenceModule.b, false))) ? b : new RtcPresenceState(true, b.b, b.c, b.d, b.e, b.f);
    }

    private RtcPresenceState m2808b(UserKey userKey) {
        if (!m2805a()) {
            return new RtcPresenceState(false, null, RtcAbortedCallReasonIds.j, 0);
        }
        if (!m2810c()) {
            return new RtcPresenceState(false, null, RtcAbortedCallReasonIds.f, 0);
        }
        if (userKey == null) {
            return new RtcPresenceState(false, null, RtcAbortedCallReasonIds.d, 0);
        }
        RtcPresenceState a = this.f2523c.m2817a(userKey);
        if (a != null) {
            return a;
        }
        RtcPresenceState rtcPresenceState;
        if (this.f2526f == null) {
            rtcPresenceState = null;
        } else {
            rtcPresenceState = this.f2526f.a();
        }
        a = rtcPresenceState;
        return a == null ? new RtcPresenceState(false, null, RtcAbortedCallReasonIds.c, 0) : a;
    }

    private boolean m2806a(RtcPresenceState rtcPresenceState) {
        if (rtcPresenceState != null) {
            if (rtcPresenceState.a && this.f2524d.now() - rtcPresenceState.e < 240000) {
                return true;
            }
            if (!rtcPresenceState.a && this.f2524d.now() - rtcPresenceState.e < 10000) {
                return true;
            }
        }
        return false;
    }

    private boolean m2805a() {
        return ((Boolean) this.f2521a.get()).booleanValue();
    }

    private boolean m2809b() {
        return m2805a() && m2810c();
    }

    private boolean m2810c() {
        NetworkInfo c = this.f2522b.c();
        return c != null && c.isConnected();
    }
}

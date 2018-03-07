package com.facebook.analytics;

import com.facebook.analytics.logger.AnalyticsConfig$Level;
import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy;
import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy.ConfigSnapShot;
import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperListeners;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.user.model.User;
import javax.inject.Provider;

/* compiled from: update_saved_state */
public abstract class BaseAnalyticsConfig {
    private static final Class<?> f1759a = BaseAnalyticsConfig.class;
    private final Provider<User> f1760b;
    private final int f1761c;
    public final AnalyticsLoggingPolicy f1762d;
    private final GatekeeperStoreImpl f1763e;
    private final OnGatekeeperChangeListener f1764f = new C01181(this);
    private AnalyticsConfig$Level f1765g;

    /* compiled from: update_saved_state */
    class C01181 extends OnGatekeeperChangeListener {
        final /* synthetic */ BaseAnalyticsConfig f1829a;

        C01181(BaseAnalyticsConfig baseAnalyticsConfig) {
            this.f1829a = baseAnalyticsConfig;
        }

        public final void mo545a(GatekeeperStoreImpl gatekeeperStoreImpl, int i) {
            BaseAnalyticsConfig.m3561d(this.f1829a);
        }
    }

    /* compiled from: update_saved_state */
    /* synthetic */ class C02032 {
        static final /* synthetic */ int[] f3271a = new int[TriState.values().length];

        static {
            try {
                f3271a[TriState.YES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3271a[TriState.NO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3271a[TriState.UNSET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public BaseAnalyticsConfig(Provider<User> provider, GatekeeperStore gatekeeperStore, GatekeeperListeners gatekeeperListeners, int i, AnalyticsLoggingPolicy analyticsLoggingPolicy) {
        this.f1760b = provider;
        this.f1763e = gatekeeperStore;
        this.f1761c = i;
        this.f1762d = analyticsLoggingPolicy;
        gatekeeperListeners.m3657a(this.f1764f, i);
    }

    public final AnalyticsConfig$Level m3562a() {
        if (this.f1765g == null) {
            m3561d(this);
        }
        return this.f1765g;
    }

    public static void m3561d(BaseAnalyticsConfig baseAnalyticsConfig) {
        if (baseAnalyticsConfig.f1763e.m2189a(baseAnalyticsConfig.f1761c, false)) {
            baseAnalyticsConfig.f1765g = AnalyticsConfig$Level.CORE_AND_SAMPLED;
        } else {
            baseAnalyticsConfig.f1765g = AnalyticsConfig$Level.CORE;
        }
    }

    public final boolean m3565b() {
        User user = (User) this.f1760b.get();
        if (user == null || !user.f3612o) {
            return false;
        }
        return true;
    }

    public final boolean m3564a(String str, boolean z) {
        switch (C02032.f3271a[this.f1762d.m2870a(str).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return true;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return false;
            default:
                boolean z2;
                if (z) {
                    z2 = true;
                } else {
                    z2 = this.f1762d.f1478d.nextInt(200) == 0;
                }
                return z2;
        }
    }

    public final boolean m3563a(String str) {
        return !this.f1762d.f1476b.m2917a(str);
    }

    public final boolean m3566c() {
        ConfigSnapShot c = this.f1762d.m2874c();
        return c == null || c.m4375b() || c.m4374a();
    }
}

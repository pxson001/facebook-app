package com.facebook.prefs.shared.init;

import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: today_android_multirow_notif_public */
public abstract class INeedInitForSharedPrefsListenerRegistration<T> implements OnSharedPreferenceChangeListener {
    public static final Class f2459a = INeedInitForSharedPrefsListenerRegistration.class;
    private final Lazy<T> f2460b;
    private PrefKey f2461c;
    private Set<PrefKey> f2462d;
    private PrefKey f2463e;
    private AtomicBoolean f2464f;

    /* compiled from: today_android_multirow_notif_public */
    public enum PrefKeyMatchType {
        WHOLE,
        PREFIX
    }

    /* compiled from: today_android_multirow_notif_public */
    /* synthetic */ class C01711 {
        static final /* synthetic */ int[] f2504a = new int[PrefKeyMatchType.values().length];

        static {
            try {
                f2504a[PrefKeyMatchType.PREFIX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2504a[PrefKeyMatchType.WHOLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected abstract void mo667a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey, T t);

    protected INeedInitForSharedPrefsListenerRegistration(Lazy<T> lazy, PrefKey prefKey) {
        this(lazy, prefKey, PrefKeyMatchType.WHOLE);
    }

    protected INeedInitForSharedPrefsListenerRegistration(Lazy<T> lazy, Set<PrefKey> set) {
        this.f2464f = new AtomicBoolean();
        this.f2460b = lazy;
        this.f2462d = ImmutableSet.copyOf((Collection) set);
    }

    protected INeedInitForSharedPrefsListenerRegistration(Lazy<T> lazy, PrefKey prefKey, PrefKeyMatchType prefKeyMatchType) {
        this.f2464f = new AtomicBoolean();
        switch (C01711.f2504a[prefKeyMatchType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f2460b = lazy;
                this.f2461c = prefKey;
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f2460b = lazy;
                this.f2463e = prefKey;
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final void m4673a(FbSharedPreferences fbSharedPreferences) {
        if (!this.f2464f.getAndSet(true)) {
            if (this.f2462d != null) {
                fbSharedPreferences.mo283a(this.f2462d, (OnSharedPreferenceChangeListener) this);
            } else if (this.f2463e != null) {
                fbSharedPreferences.mo279a(this.f2463e, (OnSharedPreferenceChangeListener) this);
            } else if (this.f2461c != null) {
                fbSharedPreferences.mo293c(this.f2461c, this);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public final void mo668a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
        mo667a(fbSharedPreferences, prefKey, this.f2460b.get());
    }
}

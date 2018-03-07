package com.facebook.interstitial.manager;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.interstitial.api.FetchInterstitialResult;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: publish_post */
class LazyInterstitialControllerHolder {
    private static final Class<?> f8656b = LazyInterstitialControllerHolder.class;
    public final String f8657a;
    private final InterstitialController f8658c;
    private FetchInterstitialResult f8659d;
    private boolean f8660e;

    public LazyInterstitialControllerHolder(InterstitialController interstitialController) {
        this.f8658c = (InterstitialController) Preconditions.checkNotNull(interstitialController);
        this.f8657a = interstitialController.mo1173b();
    }

    public final synchronized boolean m13464a() {
        return this.f8660e;
    }

    @Nullable
    public final synchronized InterstitialController m13466b() {
        InterstitialController interstitialController;
        if (this.f8660e) {
            interstitialController = this.f8658c;
        } else {
            interstitialController = null;
        }
        return interstitialController;
    }

    @Nullable
    public final synchronized FetchInterstitialResult m13467c() {
        return this.f8659d;
    }

    public final synchronized ImmutableList<InterstitialTrigger> m13468d() {
        ImmutableList<InterstitialTrigger> e;
        e = m13469e();
        if (e == null) {
            e = ImmutableList.of();
        }
        return e;
    }

    @Nullable
    public final synchronized ImmutableList<InterstitialTrigger> m13469e() {
        ImmutableList<InterstitialTrigger> immutableList;
        InterstitialController b = m13466b();
        if (b == null) {
            immutableList = null;
        } else {
            immutableList = b.mo1174c();
        }
        return immutableList;
    }

    public final synchronized boolean m13465a(FetchInterstitialResult fetchInterstitialResult, AbstractFbErrorReporter abstractFbErrorReporter) {
        boolean z = true;
        synchronized (this) {
            Preconditions.checkNotNull(fetchInterstitialResult);
            Preconditions.checkNotNull(abstractFbErrorReporter);
            this.f8659d = fetchInterstitialResult;
            try {
                this.f8658c.mo1172a(fetchInterstitialResult.data);
                this.f8658c.mo1171a(fetchInterstitialResult.fetchTimeMs);
                this.f8660e = true;
            } catch (Throwable e) {
                abstractFbErrorReporter.m2352b(f8656b.getSimpleName() + "_prepareController", e);
                z = false;
            }
        }
        return z;
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("isInited", this.f8660e).add("InterstitialId", this.f8658c != null ? this.f8658c.mo1173b() : null).add("FetchInterstitialResult", this.f8659d).toString();
    }
}

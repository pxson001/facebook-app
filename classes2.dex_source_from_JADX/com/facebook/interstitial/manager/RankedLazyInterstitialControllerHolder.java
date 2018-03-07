package com.facebook.interstitial.manager;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: publish_mode_selector_nux_seen */
class RankedLazyInterstitialControllerHolder implements Comparable<RankedLazyInterstitialControllerHolder> {
    public final int f8667a;
    public final LazyInterstitialControllerHolder f8668b;

    public int compareTo(Object obj) {
        RankedLazyInterstitialControllerHolder rankedLazyInterstitialControllerHolder = (RankedLazyInterstitialControllerHolder) obj;
        if (rankedLazyInterstitialControllerHolder == null) {
            return -1;
        }
        return ComparisonChain.a.a(this.f8667a, rankedLazyInterstitialControllerHolder.f8667a).a(m13485a(), rankedLazyInterstitialControllerHolder.m13485a()).b();
    }

    public RankedLazyInterstitialControllerHolder(int i, LazyInterstitialControllerHolder lazyInterstitialControllerHolder) {
        this.f8667a = i;
        this.f8668b = (LazyInterstitialControllerHolder) Preconditions.checkNotNull(lazyInterstitialControllerHolder);
    }

    public final String m13485a() {
        return this.f8668b.f8657a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RankedLazyInterstitialControllerHolder) || obj == null) {
            return false;
        }
        RankedLazyInterstitialControllerHolder rankedLazyInterstitialControllerHolder = (RankedLazyInterstitialControllerHolder) obj;
        if (Objects.equal(Integer.valueOf(this.f8667a), Integer.valueOf(rankedLazyInterstitialControllerHolder.f8667a)) && Objects.equal(m13485a(), rankedLazyInterstitialControllerHolder.m13485a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f8667a), m13485a());
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("rank", this.f8667a).add("LazyInterstitialControllerHolder", this.f8668b).toString();
    }
}

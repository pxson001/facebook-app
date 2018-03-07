package com.facebook.zero.common;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import com.google.common.collect.ImmutableSet;

/* compiled from: toId */
public abstract class UiFeaturesAccessor {
    protected UiFeatureDataSerializer f2468a;
    protected volatile ImmutableSet<ZeroFeatureKey> f2469b;
    protected PrefKey f2470c;

    protected UiFeaturesAccessor(PrefKey prefKey, UiFeatureDataSerializer uiFeatureDataSerializer) {
        this.f2470c = prefKey;
        this.f2468a = uiFeatureDataSerializer;
    }

    public final boolean m4682a(ZeroFeatureKey zeroFeatureKey) {
        return mo669a().contains(zeroFeatureKey);
    }

    protected ImmutableSet<ZeroFeatureKey> mo669a() {
        if (this.f2469b == null) {
            this.f2469b = this.f2468a.m8055a(this.f2470c.m2012a());
        }
        return this.f2469b;
    }

    public final void m4683b() {
        ImmutableSet a = this.f2468a.m8055a(this.f2470c.m2012a());
        if (!a.equals(this.f2469b)) {
            this.f2469b = a;
        }
    }
}

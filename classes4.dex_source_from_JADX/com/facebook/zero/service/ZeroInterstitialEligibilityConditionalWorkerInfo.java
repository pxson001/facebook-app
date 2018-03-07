package com.facebook.zero.service;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.annotations.IsInZeroInterstitialGatekeeper;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: instanceLogData */
public class ZeroInterstitialEligibilityConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<ZeroInterstitialEligibilityConditionalWorker> f10274b;
    @IsInZeroInterstitialGatekeeper
    private final Provider<Boolean> f10275c;
    private final FbSharedPreferences f10276d;

    @Inject
    public ZeroInterstitialEligibilityConditionalWorkerInfo(Provider<ZeroInterstitialEligibilityConditionalWorker> provider, Provider<Boolean> provider2, FbSharedPreferences fbSharedPreferences) {
        this.f10274b = provider;
        this.f10275c = provider2;
        this.f10276d = fbSharedPreferences;
    }

    public final boolean mo788a() {
        return ((Boolean) this.f10275c.get()).booleanValue();
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10274b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10805a(LoginState.LOGGED_IN).m10806a(NetworkState.CONNECTED).m10807a();
    }

    public final long mo792e() {
        long a = ((long) this.f10276d.a(ZeroPrefKeys.z, 3600)) * 1000;
        Long.valueOf(a);
        return a;
    }
}

package com.facebook.zero.service;

import com.facebook.common.util.TriState;
import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.constants.FbZeroTokenType;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: installed_service_ */
public class ZeroTokenConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<ZeroTokenConditionalWorker> f10277b;
    private final Provider<TriState> f10278c;
    private final FbSharedPreferences f10279d;
    private final Provider<FbZeroTokenType> f10280e;

    @Inject
    public ZeroTokenConditionalWorkerInfo(Provider<ZeroTokenConditionalWorker> provider, Provider<TriState> provider2, FbSharedPreferences fbSharedPreferences, Provider<FbZeroTokenType> provider3) {
        this.f10277b = provider;
        this.f10278c = provider2;
        this.f10279d = fbSharedPreferences;
        this.f10280e = provider3;
    }

    public final boolean mo788a() {
        return ((TriState) this.f10278c.get()).asBoolean(false);
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10277b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10803a(AppState.BACKGROUND).m10805a(LoginState.LOGGED_IN).m10806a(NetworkState.CONNECTED).m10807a();
    }

    public final long mo792e() {
        long a = ((long) this.f10279d.a(((FbZeroTokenType) this.f10280e.get()).getTokenTTLKey(), 3600)) * 1000;
        Long.valueOf(a);
        return a;
    }
}

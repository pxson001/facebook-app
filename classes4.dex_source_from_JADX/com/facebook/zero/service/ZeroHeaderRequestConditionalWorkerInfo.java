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
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.annotations.IsZeroHeaderRequestFeatureEnabled;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: instant_shopping_fb4a_qe_universe */
public class ZeroHeaderRequestConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<ZeroHeaderRequestConditionalWorker> f10259b;
    @IsZeroHeaderRequestFeatureEnabled
    private final Provider<TriState> f10260c;
    private final FbSharedPreferences f10261d;

    @Inject
    public ZeroHeaderRequestConditionalWorkerInfo(Provider<ZeroHeaderRequestConditionalWorker> provider, Provider<TriState> provider2, FbSharedPreferences fbSharedPreferences) {
        this.f10259b = provider;
        this.f10260c = provider2;
        this.f10261d = fbSharedPreferences;
    }

    public final boolean mo788a() {
        return ((TriState) this.f10260c.get()).asBoolean(false);
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10259b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10803a(AppState.BACKGROUND).m10805a(LoginState.LOGGED_IN).m10806a(NetworkState.CONNECTED).m10807a();
    }

    public final long mo792e() {
        long a = ((long) this.f10261d.a(ZeroPrefKeys.t, 3600)) * 1000;
        Long.valueOf(a);
        return a;
    }
}

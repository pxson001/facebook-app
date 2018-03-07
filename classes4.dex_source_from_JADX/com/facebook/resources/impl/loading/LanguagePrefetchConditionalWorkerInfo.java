package com.facebook.resources.impl.loading;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.BatteryState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: int */
public class LanguagePrefetchConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<LanguagePrefetchConditionalWorker> f10250b;
    private final Provider<Boolean> f10251c;

    @Inject
    public LanguagePrefetchConditionalWorkerInfo(Provider<Boolean> provider, Provider<LanguagePrefetchConditionalWorker> provider2) {
        this.f10251c = provider;
        this.f10250b = provider2;
    }

    public final boolean mo788a() {
        return ((Boolean) this.f10251c.get()).booleanValue();
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10250b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10806a(NetworkState.CONNECTED).m10803a(AppState.BACKGROUND).m10804a(BatteryState.NOT_LOW).m10805a(LoginState.LOGGED_IN).m10807a();
    }

    public final long mo792e() {
        return 86400000;
    }
}

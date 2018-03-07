package com.facebook.composer.minutiae.protocol;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: is_auto_downloadable */
public class MinutiaeConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<MinutiaeConditionalWorker> f10114b;

    @Inject
    public MinutiaeConditionalWorkerInfo(Provider<MinutiaeConditionalWorker> provider) {
        this.f10114b = provider;
    }

    public final boolean mo788a() {
        return true;
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10114b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10806a(NetworkState.CONNECTED).m10803a(AppState.BACKGROUND).m10805a(LoginState.LOGGED_IN).m10807a();
    }

    public final long mo792e() {
        return 604800000;
    }
}

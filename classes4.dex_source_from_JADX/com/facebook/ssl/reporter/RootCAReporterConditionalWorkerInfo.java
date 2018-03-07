package com.facebook.ssl.reporter;

import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: instantvideo.dev */
public class RootCAReporterConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<RootCAReporter> f10258b;

    @Inject
    public RootCAReporterConditionalWorkerInfo(Provider<RootCAReporter> provider) {
        this.f10258b = provider;
    }

    public final boolean mo788a() {
        return true;
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<RootCAReporter> mo790c() {
        return this.f10258b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10803a(AppState.BACKGROUND).m10806a(NetworkState.CONNECTED).m10805a(LoginState.LOGGED_IN).m10807a();
    }

    public final long mo792e() {
        return 2419200000L;
    }
}

package com.facebook.messaging.analytics.reliability;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.LoginState;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: interstitials_configuration_fetch_start */
public class ReliabilityLoggerStaleEntriesConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<ReliabilityLoggerStaleEntriesConditionalWorker> f10200b;

    @Inject
    public ReliabilityLoggerStaleEntriesConditionalWorkerInfo(Provider<ReliabilityLoggerStaleEntriesConditionalWorker> provider) {
        this.f10200b = provider;
    }

    public final boolean mo788a() {
        return true;
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10200b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10803a(AppState.BACKGROUND).m10805a(LoginState.LOGGED_IN).m10807a();
    }

    public final long mo792e() {
        return 7200000;
    }
}

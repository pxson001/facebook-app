package com.facebook.search.suggestions.nullstate;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: instream_video_ads */
public class NullStateSyncConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<NullStateSyncConditionalWorker> f10256b;
    private final QeAccessor f10257c;

    @Inject
    public NullStateSyncConditionalWorkerInfo(Provider<NullStateSyncConditionalWorker> provider, QeAccessor qeAccessor) {
        this.f10256b = provider;
        this.f10257c = qeAccessor;
    }

    public final boolean mo788a() {
        return this.f10257c.a(ExperimentsForSearchAbTestModule.aX, 0) > 0;
    }

    public final Trigger mo789b() {
        return Trigger.STATE_CHANGE;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10256b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10803a(AppState.BACKGROUND).m10806a(NetworkState.CONNECTED).m10805a(LoginState.LOGGED_IN).m10807a();
    }

    public final long mo792e() {
        return (long) (this.f10257c.a(ExperimentsForSearchAbTestModule.aX, 0) * 1000);
    }
}

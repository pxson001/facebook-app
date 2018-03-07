package com.facebook.search.bootstrap.sync;

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

/* compiled from: insufficient disk space */
public class BootstrapSyncConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<BootstrapSyncConditionalWorker> f10252b;
    private final boolean f10253c;
    private final boolean f10254d;
    private final long f10255e;

    @Inject
    public BootstrapSyncConditionalWorkerInfo(QeAccessor qeAccessor, Provider<BootstrapSyncConditionalWorker> provider) {
        this.f10252b = provider;
        this.f10253c = qeAccessor.a(ExperimentsForSearchAbTestModule.bq, true);
        this.f10254d = qeAccessor.a(ExperimentsForSearchAbTestModule.br, true);
        this.f10255e = ((long) qeAccessor.a(ExperimentsForSearchAbTestModule.bn, 24)) * 3600000;
    }

    public final boolean mo788a() {
        return (this.f10253c && this.f10254d) ? false : true;
    }

    public final Trigger mo789b() {
        return Trigger.STATE_CHANGE;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10252b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10803a(AppState.BACKGROUND).m10806a(NetworkState.CONNECTED).m10805a(LoginState.LOGGED_IN).m10807a();
    }

    public final long mo792e() {
        return this.f10255e;
    }
}

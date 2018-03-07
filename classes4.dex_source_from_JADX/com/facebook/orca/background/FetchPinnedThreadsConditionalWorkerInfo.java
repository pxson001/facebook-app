package com.facebook.orca.background;

import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.config.application.Product;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: interactors_friend */
public class FetchPinnedThreadsConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Product f10245b;
    private Provider<FetchPinnedThreadsConditionalWorker> f10246c;
    private final FetchPinnedThreadsSyncComponent f10247d;

    @Inject
    public FetchPinnedThreadsConditionalWorkerInfo(Provider<FetchPinnedThreadsConditionalWorker> provider, FetchPinnedThreadsSyncComponent fetchPinnedThreadsSyncComponent, Product product) {
        this.f10246c = provider;
        this.f10247d = fetchPinnedThreadsSyncComponent;
        this.f10245b = product;
    }

    public final boolean mo788a() {
        return (this.f10245b == Product.PAA || this.f10245b == Product.FB4A || this.f10247d.m10740d()) ? false : true;
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends FetchPinnedThreadsConditionalWorker> mo790c() {
        return this.f10246c;
    }

    public final long mo792e() {
        return 86400000;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10806a(NetworkState.CONNECTED).m10803a(AppState.BACKGROUND).m10805a(LoginState.LOGGED_IN).m10807a();
    }
}

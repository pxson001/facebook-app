package com.facebook.messaging.payment.prefs;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.messaging.payment.cache.PaymentRequestCache;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: interstitial_ */
public class FetchIncomingPaymentRequestsConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<FetchIncomingPaymentRequestsConditionalWorker> f10201b;
    private final Provider<Boolean> f10202c;
    private final PaymentRequestCache f10203d;

    @Inject
    public FetchIncomingPaymentRequestsConditionalWorkerInfo(Provider<FetchIncomingPaymentRequestsConditionalWorker> provider, Provider<Boolean> provider2, PaymentRequestCache paymentRequestCache) {
        this.f10201b = provider;
        this.f10202c = provider2;
        this.f10203d = paymentRequestCache;
    }

    public final boolean mo788a() {
        if (!((Boolean) this.f10202c.get()).booleanValue()) {
            return false;
        }
        if (this.f10203d.m10689a() != null) {
            return false;
        }
        return true;
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10201b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10806a(NetworkState.CONNECTED).m10803a(AppState.BACKGROUND).m10805a(LoginState.LOGGED_IN).m10807a();
    }

    public final long mo792e() {
        return 21600000;
    }
}

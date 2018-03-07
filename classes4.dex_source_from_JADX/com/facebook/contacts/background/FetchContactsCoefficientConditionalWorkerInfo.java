package com.facebook.contacts.background;

import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.contacts.properties.ContactsStorageMode;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: isSelectedOptionExternal */
public class FetchContactsCoefficientConditionalWorkerInfo implements ConditionalWorkerInfo {
    private Provider<FetchContactsCoefficientConditionalWorker> f10117b;
    private final Provider<ContactsStorageMode> f10118c;

    @Inject
    public FetchContactsCoefficientConditionalWorkerInfo(Provider<FetchContactsCoefficientConditionalWorker> provider, Provider<ContactsStorageMode> provider2) {
        this.f10117b = provider;
        this.f10118c = provider2;
    }

    public final Provider<? extends FetchContactsCoefficientConditionalWorker> mo790c() {
        return this.f10117b;
    }

    public final boolean mo788a() {
        return this.f10118c.get() == ContactsStorageMode.CONTACTS_DATABASE;
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final long mo792e() {
        return 86400000;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10806a(NetworkState.CONNECTED).m10803a(AppState.BACKGROUND).m10805a(LoginState.LOGGED_IN).m10807a();
    }
}

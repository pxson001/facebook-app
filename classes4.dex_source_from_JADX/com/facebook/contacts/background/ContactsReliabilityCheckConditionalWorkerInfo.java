package com.facebook.contacts.background;

import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.contacts.background.annotations.IsContactsReliabilityCheckOverWifiEnabled;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: is_app_new_install_reported/ */
public class ContactsReliabilityCheckConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<ContactsReliabilityCheckConditionalWorker> f10115b;
    @IsContactsReliabilityCheckOverWifiEnabled
    private final Provider<Boolean> f10116c;

    @Inject
    public ContactsReliabilityCheckConditionalWorkerInfo(Provider<ContactsReliabilityCheckConditionalWorker> provider, Provider<Boolean> provider2) {
        this.f10115b = provider;
        this.f10116c = provider2;
    }

    public final Provider<? extends ContactsReliabilityCheckConditionalWorker> mo790c() {
        return this.f10115b;
    }

    public final boolean mo788a() {
        return ((Boolean) this.f10116c.get()).booleanValue();
    }

    public final Trigger mo789b() {
        return Trigger.STATE_CHANGE;
    }

    public final long mo792e() {
        return 86400000;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10806a(NetworkState.CONNECTED_THROUGH_WIFI).m10803a(AppState.BACKGROUND).m10805a(LoginState.LOGGED_IN).m10807a();
    }
}

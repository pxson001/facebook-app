package com.facebook.languages.switcher.task;

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

/* compiled from: invalid_selected_content_privacy_option_received */
public class AutoSyncLoggedInUserLocaleConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<AutoSyncLoggedInUserLocaleConditionalWorker> f10195b;

    @Inject
    public AutoSyncLoggedInUserLocaleConditionalWorkerInfo(Provider<AutoSyncLoggedInUserLocaleConditionalWorker> provider) {
        this.f10195b = provider;
    }

    public final boolean mo788a() {
        return true;
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10195b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10806a(NetworkState.CONNECTED).m10803a(AppState.BACKGROUND).m10805a(LoginState.LOGGED_IN).m10807a();
    }

    public final long mo792e() {
        return 86400000;
    }
}

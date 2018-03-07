package com.facebook.contacts.ccu;

import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: isPlaying */
public class ContactsUploadConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final ContactsUploadClient f10119b;
    private final FbSharedPreferences f10120c;
    private final GatekeeperStoreImpl f10121d;
    private final Provider<ContactsUploadConditionalWorker> f10122e;

    @Inject
    public ContactsUploadConditionalWorkerInfo(ContactsUploadClient contactsUploadClient, FbSharedPreferences fbSharedPreferences, GatekeeperStore gatekeeperStore, Provider<ContactsUploadConditionalWorker> provider) {
        this.f10119b = contactsUploadClient;
        this.f10120c = fbSharedPreferences;
        this.f10121d = gatekeeperStore;
        this.f10122e = provider;
    }

    public final Provider<? extends ContactsUploadConditionalWorker> mo790c() {
        return this.f10122e;
    }

    public final boolean mo788a() {
        return this.f10121d.a(387, false);
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final long mo792e() {
        long a = this.f10120c.a(AnalyticsPrefKeys.d, -1);
        return a == -1 ? this.f10119b.f10148p.f10188i : a;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10806a(NetworkState.CONNECTED).m10805a(LoginState.LOGGED_IN).m10803a(AppState.BACKGROUND).m10807a();
    }
}

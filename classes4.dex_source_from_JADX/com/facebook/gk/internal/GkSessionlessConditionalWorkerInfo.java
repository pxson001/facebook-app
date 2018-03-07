package com.facebook.gk.internal;

import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessUtil;
import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.gk.store.GatekeeperStoreConfig;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: invite_id */
public class GkSessionlessConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final FbSharedPreferences f10190b;
    private final DefaultProcessUtil f10191c;
    private final Provider<GkSessionlessConditionalWorker> f10192d;
    private final GatekeeperStoreConfig f10193e;

    @Inject
    public GkSessionlessConditionalWorkerInfo(FbSharedPreferences fbSharedPreferences, ProcessUtil processUtil, Provider<GkSessionlessConditionalWorker> provider, GatekeeperStoreConfig gatekeeperStoreConfig) {
        this.f10190b = fbSharedPreferences;
        this.f10191c = processUtil;
        this.f10192d = provider;
        this.f10193e = gatekeeperStoreConfig;
    }

    public final boolean mo788a() {
        return this.f10193e.a() > 0 && this.f10191c.a().e();
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10192d;
    }

    public final RequiredStates mo791d() {
        Builder a = new Builder().m10806a(NetworkState.CONNECTED);
        if (1 == this.f10190b.a(SessionlessGkPrefKeys.f47e, 0)) {
            a.m10803a(AppState.BACKGROUND);
        }
        return a.m10807a();
    }

    public final long mo792e() {
        return 86400000;
    }
}

package com.facebook.graphql.cursor.worker;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: invite */
public class GraphCursorDatabaseConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<GraphCursorDatabaseWorker> f10194b;

    @Inject
    public GraphCursorDatabaseConditionalWorkerInfo(Provider<GraphCursorDatabaseWorker> provider) {
        this.f10194b = provider;
    }

    public final boolean mo788a() {
        return true;
    }

    public final Trigger mo789b() {
        return Trigger.STATE_CHANGE;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10194b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10803a(AppState.BACKGROUND).m10807a();
    }

    public final long mo792e() {
        return 43200000;
    }
}

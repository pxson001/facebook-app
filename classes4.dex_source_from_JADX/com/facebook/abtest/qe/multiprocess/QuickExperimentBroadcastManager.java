package com.facebook.abtest.qe.multiprocess;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.process.ProcessName;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: thrift_serialize_error */
public class QuickExperimentBroadcastManager {
    public final BaseFbBroadcastManager f1101a;
    private final Provider<ProcessName> f1102b;

    public static QuickExperimentBroadcastManager m1383b(InjectorLike injectorLike) {
        return new QuickExperimentBroadcastManager((BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(injectorLike), IdBasedProvider.a(injectorLike, 595));
    }

    @Inject
    public QuickExperimentBroadcastManager(FbBroadcastManager fbBroadcastManager, Provider<ProcessName> provider) {
        this.f1101a = fbBroadcastManager;
        this.f1102b = provider;
    }

    public final void m1384a(boolean z) {
        Intent intent = new Intent("com.facebook.abtest.action.UPDATE_CACHE");
        if (!z) {
            intent.putExtra("process_name", ((ProcessName) this.f1102b.get()).b);
        }
        this.f1101a.a(intent);
    }

    public static QuickExperimentBroadcastManager m1382a(InjectorLike injectorLike) {
        return m1383b(injectorLike);
    }
}

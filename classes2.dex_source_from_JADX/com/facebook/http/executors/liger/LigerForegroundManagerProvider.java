package com.facebook.http.executors.liger;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPClient;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: profiling */
public class LigerForegroundManagerProvider extends AbstractAssistedProvider<LigerForegroundManager> {
    public final LigerForegroundManager m13641a(HTTPClient hTTPClient) {
        return new LigerForegroundManager(LocalFbBroadcastManager.m2946a((InjectorLike) this), MostRecentHostsStorage.m13631a((InjectorLike) this), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(this), AppStateManager.m2245a((InjectorLike) this), QeInternalImplMethodAutoProvider.m3744a(this), AnalyticsLoggerMethodAutoProvider.m3509a(this), hTTPClient);
    }
}

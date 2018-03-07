package com.facebook.backgroundtasks;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.backgroundtasks.STATICDI_MULTIBIND_PROVIDER.BackgroundTask;
import com.facebook.common.android.LocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftErrorHelper;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.common.executors.C0109x696ccb0c;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;

/* compiled from: file_size */
public class BackgroundTaskRunnerProvider extends AbstractAssistedProvider<BackgroundTaskRunner> {
    public final BackgroundTaskRunner m32123a(Long l, Long l2, Long l3) {
        return new BackgroundTaskRunner(IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(this), C0109x696ccb0c.m2944a(this), DefaultUserInteractionController.m1747a((InjectorLike) this), AppStateManager.m2245a((InjectorLike) this), LocalBroadcastManagerMethodAutoProvider.a(this), BackgroundTask.a(this), BackgroundTaskController.m2229a(this), IdBasedSingletonScopeProvider.m1809a(this, 385), DefaultAndroidThreadUtil.m1645a((InjectorLike) this), SystemClockMethodAutoProvider.m1498a(this), FbAnalyticsConfig.m3559a(this), QuickPerformanceLoggerMethodAutoProvider.m2859a(this), BaseBackgroundWorkLogger.m1660a((InjectorLike) this), FbErrorReporterImpl.m2317a((InjectorLike) this), SoftErrorHelper.m32068a((InjectorLike) this), AnalyticsLoggerMethodAutoProvider.m3509a(this), l, l2, l3);
    }
}

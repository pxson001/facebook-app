package com.facebook.facecast;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.facecast.FacecastCopyrightMonitor.CopyrightStateListener;
import com.facebook.facecast.plugin.FacecastAnalyticsLogger;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: button_event */
public class FacecastCopyrightMonitorProvider extends AbstractAssistedProvider<FacecastCopyrightMonitor> {
    public final FacecastCopyrightMonitor m21860a(String str, CopyrightStateListener copyrightStateListener) {
        return new FacecastCopyrightMonitor((AbstractFbErrorReporter) FbErrorReporterImpl.a(this), FacecastAnalyticsLogger.m21959a((InjectorLike) this), ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(this), GraphQLQueryExecutor.a(this), DefaultAndroidThreadUtil.b(this), Handler_ForUiThreadMethodAutoProvider.b(this), (Clock) SystemClockMethodAutoProvider.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), str, copyrightStateListener);
    }
}

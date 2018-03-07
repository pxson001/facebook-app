package com.facebook.sync.service;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.sync.SyncDbHandler;
import com.facebook.sync.analytics.FullRefreshReason;
import com.facebook.sync.analytics.SyncErrorReporter;
import com.facebook.sync.connection.SyncConnectionHandler;
import com.facebook.sync.connection.SyncConnectionHandler.ConnectionFreshness;
import com.facebook.sync.connection.SyncConnectionStateManager;
import com.facebook.sync.connection.SyncConnectionStateManager$QueueKey;
import com.facebook.sync.connection.SyncErrorRecoveryHandler;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.sync.prefs.SyncDebugOverlaySettingsTags;
import javax.inject.Provider;

/* compiled from: featured_header_nux_dismissed */
public abstract class SyncServiceErrorHandler {
    private static final Class<?> f14553a = SyncServiceErrorHandler.class;
    private final SyncConnectionHandler f14554b;
    private final SyncConnectionStateManager f14555c;
    private final SyncErrorRecoveryHandler f14556d;
    private final SyncErrorReporter f14557e;
    private final Provider<Boolean> f14558f;

    public SyncServiceErrorHandler(SyncConnectionHandler syncConnectionHandler, SyncConnectionStateManager syncConnectionStateManager, SyncErrorRecoveryHandler syncErrorRecoveryHandler, SyncErrorReporter syncErrorReporter, Provider<Boolean> provider) {
        this.f14554b = syncConnectionHandler;
        this.f14555c = syncConnectionStateManager;
        this.f14556d = syncErrorRecoveryHandler;
        this.f14557e = syncErrorReporter;
        this.f14558f = provider;
    }

    public final OperationResult m18446a(String str, int i, SyncDbHandler<?, ?> syncDbHandler, CallerContext callerContext, Exception exception) {
        if (!(exception instanceof MissedDeltaException)) {
            return m18444a(str, syncDbHandler, callerContext, exception);
        }
        return m18443a(str, i, (SyncDbHandler) syncDbHandler, callerContext, (MissedDeltaException) exception);
    }

    private OperationResult m18443a(String str, int i, SyncDbHandler<?, ?> syncDbHandler, CallerContext callerContext, MissedDeltaException missedDeltaException) {
        new Object[1][0] = m18445a().apiString;
        this.f14555c.c(SyncConnectionStateManager$QueueKey.m18363a(str, m18445a()));
        if (((Boolean) this.f14558f.get()).booleanValue()) {
            SyncErrorRecoveryHandler.m18368a(syncDbHandler, FullRefreshReason.f14429e);
        }
        return this.f14554b.m18356a(i, syncDbHandler, ConnectionFreshness.ENSURE, callerContext);
    }

    private OperationResult m18444a(String str, SyncDbHandler<?, ?> syncDbHandler, CallerContext callerContext, Exception exception) {
        SyncErrorReporter syncErrorReporter = this.f14557e;
        IrisQueueTypes a = m18445a();
        syncErrorReporter.f14443b.a(SyncDebugOverlaySettingsTags.f14549b, StringFormatUtil.formatStrLocaleSafe("Uncaught sync exception on %s queue!!! - %s", a.apiString, exception));
        syncErrorReporter.f14442a.a("sync_delta_handling", "Exception in delta handling. queue_type = " + a.apiString, exception);
        if (this.f14556d.m18371b((SyncDbHandler) syncDbHandler)) {
            Object[] objArr = new Object[]{m18445a().apiString, str};
            SyncErrorRecoveryHandler.m18368a(syncDbHandler, FullRefreshReason.f14428d);
            SyncErrorRecoveryHandler.m18370e(syncDbHandler);
            return OperationResult.a(ErrorCodeUtil.a(exception), exception);
        }
        objArr = new Object[]{m18445a().apiString, str};
        return this.f14554b.m18357a(FullRefreshReason.m18330a(exception), callerContext);
    }

    private IrisQueueTypes m18445a() {
        return this.f14554b.m18358a();
    }
}

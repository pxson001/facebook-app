package com.facebook.sync.connection;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.sync.SyncDbHandler;
import com.facebook.sync.analytics.FullRefreshReason;
import com.facebook.sync.analytics.SyncAnalyticsLogger;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.sync.model.thrift.GetIrisDiffs;
import com.facebook.sync.prefs.SyncDebugOverlaySettingsTags;
import com.facebook.sync.util.ExponentialBackoffHelper.ExecutionResult;
import com.facebook.sync.util.ExponentialBackoffHelper.ExponentialBackoffOperation;
import com.facebook.sync.util.ExponentialBackoffHelperFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: feedback_enable_commenting */
public abstract class SyncConnectionHandler {
    private final SyncErrorRecoveryHandler f14466a;
    public final SyncMqttPublisher f14467b;
    public final SyncConnectionStateManager f14468c;
    public final SyncAnalyticsLogger f14469d;
    public final DebugOverlayController f14470e;
    private final Clock f14471f;
    private final ExponentialBackoffHelperFactory f14472g;
    private final ScheduledExecutorService f14473h;
    public final String f14474i;
    private final SyncDbHandler f14475j;
    private final Provider<Boolean> f14476k;
    @Nullable
    private Future f14477l;
    private long f14478m;

    /* compiled from: feedback_enable_commenting */
    public enum ConnectionFreshness {
        ENSURE,
        REFRESH_CONNECTION
    }

    public abstract OperationResult m18357a(FullRefreshReason fullRefreshReason, @Nullable CallerContext callerContext);

    public abstract void m18362e();

    public SyncConnectionHandler(SyncErrorRecoveryHandler syncErrorRecoveryHandler, SyncMqttPublisher syncMqttPublisher, SyncConnectionStateManager syncConnectionStateManager, SyncAnalyticsLogger syncAnalyticsLogger, DebugOverlayController debugOverlayController, Clock clock, ExponentialBackoffHelperFactory exponentialBackoffHelperFactory, ScheduledExecutorService scheduledExecutorService, String str, SyncDbHandler syncDbHandler, Provider<Boolean> provider) {
        this.f14466a = syncErrorRecoveryHandler;
        this.f14467b = syncMqttPublisher;
        this.f14468c = syncConnectionStateManager;
        this.f14469d = syncAnalyticsLogger;
        this.f14470e = debugOverlayController;
        this.f14471f = clock;
        this.f14472g = exponentialBackoffHelperFactory;
        this.f14473h = scheduledExecutorService;
        this.f14474i = str;
        this.f14475j = syncDbHandler;
        this.f14476k = provider;
    }

    public final OperationResult m18356a(int i, SyncDbHandler<?, ?> syncDbHandler, ConnectionFreshness connectionFreshness, CallerContext callerContext) {
        Object obj;
        Integer.valueOf(i);
        m18362e();
        if (connectionFreshness == ConnectionFreshness.REFRESH_CONNECTION) {
            SyncMqttPublisher syncMqttPublisher = this.f14467b;
            syncMqttPublisher.f14497h.clear();
            syncMqttPublisher.m18390d();
        }
        SyncErrorRecoveryHandler syncErrorRecoveryHandler = this.f14466a;
        if (!syncDbHandler.m18324b() || syncErrorRecoveryHandler.m18371b((SyncDbHandler) syncDbHandler)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return m18357a(syncDbHandler.m18325c(), callerContext);
        }
        if (syncDbHandler.m18324b()) {
            m18353a(this.f14466a.m18372c(syncDbHandler), i, syncDbHandler, connectionFreshness, callerContext);
            return OperationResult.a(ErrorCode.OTHER, "ensureSync full refresh delayed because it was already performed recently.");
        }
        String e = syncDbHandler.m18327e();
        long a = syncDbHandler.m18318a();
        Object obj2 = (e == null || a == -1) ? 1 : null;
        SyncConnectionStateManager$QueueKey a2 = SyncConnectionStateManager$QueueKey.m18363a(this.f14474i, m18358a());
        if (obj2 == null && connectionFreshness == ConnectionFreshness.ENSURE && this.f14468c.a(a2)) {
            String str = m18358a().apiString;
            return OperationResult.a;
        } else if (this.f14468c.b(a2)) {
            m18353a(60000, i, syncDbHandler, connectionFreshness, callerContext);
            return OperationResult.a(ErrorCode.OTHER, StringFormatUtil.formatStrLocaleSafe("Queue %s for %s is temporarily not available. Backing off.", m18358a().apiString, this.f14474i));
        } else if (e == null) {
            return m18357a(FullRefreshReason.f14425a, callerContext);
        } else {
            if (a < 0) {
                return m18357a(FullRefreshReason.f14426b, callerContext);
            }
            if (m18354a(i, e, a)) {
                this.f14468c.a(a2, this.f14471f.a());
                return OperationResult.a;
            }
            return OperationResult.a(ErrorCode.CONNECTION_FAILURE, StringFormatUtil.formatStrLocaleSafe("resumeQueueConnectionIfMqttConnected failed for %s queue. Not connected to sync.  viewerContextUserId = %s", m18358a().apiString, this.f14474i));
        }
    }

    private void m18353a(long j, int i, SyncDbHandler<?, ?> syncDbHandler, ConnectionFreshness connectionFreshness, CallerContext callerContext) {
        if (this.f14477l == null || this.f14477l.isDone()) {
            final int i2 = i;
            final SyncDbHandler<?, ?> syncDbHandler2 = syncDbHandler;
            final ConnectionFreshness connectionFreshness2 = connectionFreshness;
            final CallerContext callerContext2 = callerContext;
            this.f14477l = this.f14473h.schedule(new Runnable(this) {
                final /* synthetic */ SyncConnectionHandler f14460e;

                public void run() {
                    try {
                        this.f14460e.m18356a(i2, syncDbHandler2, connectionFreshness2, callerContext2);
                    } catch (Exception e) {
                    }
                }
            }, j, TimeUnit.MILLISECONDS);
        }
    }

    private boolean m18354a(int i, String str, long j) {
        if (this.f14468c.a()) {
            return m18355b(i, str, j);
        }
        String str2 = m18358a().apiString;
        return false;
    }

    @VisibleForTesting
    private boolean m18355b(int i, String str, long j) {
        final String str2 = str;
        final long j2 = j;
        final int i2 = i;
        return ((Boolean) this.f14472g.m18450a(60000, 1000, new ExponentialBackoffOperation<Boolean>(this) {
            final /* synthetic */ SyncConnectionHandler f14464d;
            private int f14465e = 0;

            public final ExecutionResult<Boolean> mo1146a() {
                boolean z = false;
                if (!this.f14464d.f14468c.a()) {
                    return new ExecutionResult(false, Boolean.valueOf(false));
                }
                this.f14464d.f14469d.m18338a(new HoneyClientEvent("sync_resume_queue_connection_attempt").a("attempt", this.f14465e), this.f14464d.m18358a());
                this.f14464d.f14470e.a(SyncDebugOverlaySettingsTags.f14550c, StringFormatUtil.formatStrLocaleSafe("get_diffs. queueType = %s, syncToken = %s, seqId = %d, attempt %d.", this.f14464d.m18358a().apiString, str2, Long.valueOf(j2), Integer.valueOf(this.f14465e)));
                boolean a = this.f14464d.f14467b.m18384a(i2, str2, j2, this.f14464d.f14474i);
                if (!a) {
                    z = true;
                }
                return new ExecutionResult(z, Boolean.valueOf(a));
            }

            public final void mo1147a(long j) {
                this.f14464d.f14470e.a(SyncDebugOverlaySettingsTags.f14550c, StringFormatUtil.formatStrLocaleSafe("get_diffs failed. queueType = %s, syncToken = %s, seqId = %d, attempt %d.", this.f14464d.m18358a().apiString, str2, Long.valueOf(j2), Integer.valueOf(this.f14465e)));
                this.f14465e++;
            }
        }).m18447a()).booleanValue();
    }

    public final IrisQueueTypes m18358a() {
        return this.f14467b.m18382a();
    }

    public final SyncConnectionStateManager$QueueKey m18359b() {
        return SyncConnectionStateManager$QueueKey.m18363a(this.f14474i, m18358a());
    }

    @Nullable
    public final GetIrisDiffs m18360c() {
        if (((Boolean) this.f14476k.get()).booleanValue() && this.f14475j.m18327e() != null) {
            ObjectNode b = this.f14467b.m18387b(this.f14467b.m18386b(), this.f14475j.m18327e(), this.f14475j.m18318a(), this.f14474i);
            if (GetIrisDiffsBuilder.m18346a(b)) {
                this.f14470e.a(SyncDebugOverlaySettingsTags.f14550c, StringFormatUtil.formatStrLocaleSafe("get_diffs on connect. queueType = %s, syncToken = %s, seqId = %d", m18358a().apiString, this.f14475j.m18327e(), Long.valueOf(this.f14475j.m18318a())));
                this.f14478m = this.f14475j.m18318a();
                return new GetIrisDiffsBuilder().m18348b(b).m18347a();
            }
        }
        return null;
    }

    public final void m18361d() {
        if (this.f14478m > this.f14475j.m18318a()) {
            BLog.c("SyncConnectionHandler", "lastSequeuenceId included in the connect message %d is greater than the current one %d", new Object[]{Long.valueOf(this.f14478m), Long.valueOf(this.f14475j.m18318a())});
            return;
        }
        this.f14467b.m18391e();
    }
}

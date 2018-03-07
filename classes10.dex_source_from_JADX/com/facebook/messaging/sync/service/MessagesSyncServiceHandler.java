package com.facebook.messaging.sync.service;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.GatekeeperStoreManager;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbThreadProperties;
import com.facebook.messaging.database.threads.DbThreadsPropertyUtil;
import com.facebook.messaging.sync.MessagesSyncDbHandler;
import com.facebook.messaging.sync.MessagesSyncOperationContextSupplier;
import com.facebook.messaging.sync.connection.MessagesSyncConnectionHandler;
import com.facebook.messaging.sync.delta.MessagesSyncPayloadHandler;
import com.facebook.messaging.sync.model.thrift.DeltaForcedFetch;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.model.thrift.SyncPayload;
import com.facebook.messaging.sync.push.SyncOperationContextSupplier;
import com.facebook.sync.DefaultSyncContextChecker;
import com.facebook.sync.SyncContextChecker;
import com.facebook.sync.analytics.FullRefreshReason;
import com.facebook.sync.service.SyncOperationParamsUtil;
import com.facebook.sync.service.SyncOperationParamsUtil.FullRefreshParams;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: post_login_nux_seen */
public class MessagesSyncServiceHandler implements BlueServiceHandler {
    private static final Object f4663m = new Object();
    private final GatekeeperStoreImpl f4664a;
    private final MessagesSyncDbHandler f4665b;
    public final MessagesSyncConnectionHandler f4666c;
    private final SyncOperationParamsUtil f4667d;
    private final MessagesSyncServiceErrorHandler f4668e;
    private final Provider<Boolean> f4669f;
    private final Provider<Integer> f4670g;
    public final DbThreadsPropertyUtil f4671h;
    private final MessagesSyncOperationContextSupplier f4672i;
    private final DefaultSyncContextChecker f4673j;
    private final AbstractFbErrorReporter f4674k;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessagesSyncPayloadHandler> f4675l = UltralightRuntime.b;

    private static MessagesSyncServiceHandler m4222b(InjectorLike injectorLike) {
        MessagesSyncServiceHandler messagesSyncServiceHandler = new MessagesSyncServiceHandler(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), MessagesSyncDbHandler.m3882a(injectorLike), MessagesSyncConnectionHandler.m3905a(injectorLike), SyncOperationParamsUtil.a(injectorLike), MessagesSyncServiceErrorHandler.m4218a(injectorLike), IdBasedProvider.a(injectorLike, 4075), IdBasedProvider.a(injectorLike, 4419), DbThreadsPropertyUtil.a(injectorLike), MessagesSyncOperationContextSupplier.m3898a(injectorLike), DefaultSyncContextChecker.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
        messagesSyncServiceHandler.f4675l = IdBasedLazy.a(injectorLike, 8501);
        return messagesSyncServiceHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.service.MessagesSyncServiceHandler m4220a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f4663m;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m4222b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4663m;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.service.MessagesSyncServiceHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.service.MessagesSyncServiceHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f4663m;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.service.MessagesSyncServiceHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.service.MessagesSyncServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.service.MessagesSyncServiceHandler");
    }

    @Inject
    public MessagesSyncServiceHandler(GatekeeperStoreManager gatekeeperStoreManager, MessagesSyncDbHandler messagesSyncDbHandler, MessagesSyncConnectionHandler messagesSyncConnectionHandler, SyncOperationParamsUtil syncOperationParamsUtil, MessagesSyncServiceErrorHandler messagesSyncServiceErrorHandler, Provider<Boolean> provider, Provider<Integer> provider2, DbThreadsPropertyUtil dbThreadsPropertyUtil, SyncOperationContextSupplier syncOperationContextSupplier, SyncContextChecker syncContextChecker, FbErrorReporter fbErrorReporter) {
        this.f4664a = gatekeeperStoreManager;
        this.f4665b = messagesSyncDbHandler;
        this.f4666c = messagesSyncConnectionHandler;
        this.f4667d = syncOperationParamsUtil;
        this.f4668e = messagesSyncServiceErrorHandler;
        this.f4669f = provider;
        this.f4670g = provider2;
        this.f4671h = dbThreadsPropertyUtil;
        this.f4672i = syncOperationContextSupplier;
        this.f4673j = syncContextChecker;
        this.f4674k = fbErrorReporter;
    }

    public final OperationResult m4223a(OperationParams operationParams) {
        if (this.f4664a.d()) {
            String str = operationParams.b;
            if (!((Boolean) this.f4669f.get()).booleanValue()) {
                BLog.b("MessagesSyncServiceHandler", "Sync protocol disabled. Ignore operation %s", new Object[]{str});
                return OperationResult.a(ErrorCode.CANCELLED);
            } else if (!this.f4673j.a()) {
                this.f4674k.a("MessagesSyncServiceHandler", StringFormatUtil.formatStrLocaleSafe("%s called without a valid logged in user. CallerContext=%s", str, operationParams.e));
                return OperationResult.a(ErrorCode.CANCELLED);
            } else if ("ensure_sync".equals(str)) {
                return this.f4666c.a(((Integer) this.f4670g.get()).intValue(), this.f4665b, SyncOperationParamsUtil.d(operationParams), operationParams.e);
            } else if ("force_full_refresh".equals(str)) {
                OperationResult a;
                FullRefreshParams c = SyncOperationParamsUtil.c(operationParams);
                if (StringUtil.a(c.b, this.f4671h.a(DbThreadProperties.i))) {
                    a = this.f4666c.m3912a(c.a, operationParams.e);
                } else {
                    a = OperationResult.a;
                }
                return a;
            } else if ("deltas".equals(str)) {
                return m4221b(operationParams);
            } else {
                throw new IllegalArgumentException("Unknown operation type: " + str);
            }
        }
        BLog.a("MessagesSyncServiceHandler", "GKs not initialized yet. Ignore operation %s", new Object[]{operationParams.b});
        return OperationResult.a(ErrorCode.CANCELLED);
    }

    private OperationResult m4221b(OperationParams operationParams) {
        SyncPayload syncPayload = (SyncPayload) SyncOperationParamsUtil.a(operationParams);
        FbTraceNode b = SyncOperationParamsUtil.b(operationParams);
        for (DeltaWrapper deltaWrapper : syncPayload.deltas) {
            if (deltaWrapper.a() == 18) {
                DeltaForcedFetch r = deltaWrapper.r();
                if (r.messageId == null && r.threadKey == null) {
                    return this.f4666c.m3912a(FullRefreshReason.a(syncPayload.firstDeltaSeqId.longValue()), operationParams.f());
                }
            }
        }
        try {
            ((MessagesSyncPayloadHandler) this.f4675l.get()).m3988a(syncPayload, b);
            return OperationResult.a();
        } catch (Exception e) {
            return this.f4668e.a(Long.toString(this.f4672i.m3900a(syncPayload).longValue()), ((Integer) this.f4670g.get()).intValue(), this.f4665b, operationParams.f(), e);
        }
    }
}

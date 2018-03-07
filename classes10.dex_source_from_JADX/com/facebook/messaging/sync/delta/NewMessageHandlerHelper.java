package com.facebook.messaging.sync.delta;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.notificationpolicy.NotificationPolicyEngine;
import com.facebook.messaging.notify.NewMessageNotificationFactory;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.push.PushProperty;
import com.facebook.push.PushSource;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.annotation.Nullable;

@UserScoped
/* compiled from: profile_share_app_clicked */
public class NewMessageHandlerHelper {
    private static final Object f4417g = new Object();
    private final DbInsertThreadsHandler f4418a;
    private final Clock f4419b;
    private final NewMessageNotificationFactory f4420c;
    private final DeltaUiChangesCache f4421d;
    private final NotificationPolicyEngine f4422e;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4423f = UltralightRuntime.b;

    private static NewMessageHandlerHelper m3991b(InjectorLike injectorLike) {
        NewMessageHandlerHelper newMessageHandlerHelper = new NewMessageHandlerHelper(DbInsertThreadsHandler.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), NewMessageNotificationFactory.b(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), NotificationPolicyEngine.m3311a(injectorLike));
        newMessageHandlerHelper.f4423f = IdBasedLazy.a(injectorLike, 7693);
        return newMessageHandlerHelper;
    }

    @Inject
    private NewMessageHandlerHelper(DbInsertThreadsHandler dbInsertThreadsHandler, Clock clock, NewMessageNotificationFactory newMessageNotificationFactory, DeltaUiChangesCache deltaUiChangesCache, NotificationPolicyEngine notificationPolicyEngine) {
        this.f4418a = dbInsertThreadsHandler;
        this.f4419b = clock;
        this.f4420c = newMessageNotificationFactory;
        this.f4421d = deltaUiChangesCache;
        this.f4422e = notificationPolicyEngine;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.NewMessageHandlerHelper m3990a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4417g;	 Catch:{ all -> 0x006c }
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
        r1 = m3991b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4417g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.NewMessageHandlerHelper) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.NewMessageHandlerHelper) r0;	 Catch:{  }
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
        r0 = f4417g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.NewMessageHandlerHelper) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.NewMessageHandlerHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.NewMessageHandlerHelper");
    }

    @Nullable
    public final NewMessageResult m3992a(Message message, long j, boolean z) {
        return this.f4418a.a(new NewMessageResult(DataFreshnessResult.FROM_SERVER, message, null, null, this.f4419b.a()), j, z);
    }

    public final void m3993a(@Nullable NewMessageResult newMessageResult, long j, TriState triState) {
        if (newMessageResult != null) {
            TriState valueOf;
            if (this.f4422e.m3316a()) {
                valueOf = TriState.valueOf(this.f4422e.m3317a(newMessageResult.a.c, newMessageResult.a.a, newMessageResult.c.C));
            } else {
                valueOf = triState;
            }
            this.f4422e.m3314a(newMessageResult.a.e.b.b(), newMessageResult.a.c);
            ((CacheInsertThreadsHandler) this.f4423f.get()).a(newMessageResult, j);
            Message message = newMessageResult.a;
            this.f4421d.m3966a(message.b, this.f4420c.a(message, newMessageResult.c.a, newMessageResult.c.D, new PushProperty(PushSource.MQTT), valueOf));
        }
    }
}

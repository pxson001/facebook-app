package com.facebook.messaging.notificationpolicy;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.util.JSONUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.push.PushProperty;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: retry_queue */
public class NotificationDelayTestManager {
    private static final Object f3382j = new Object();
    private final LinkedHashSet<String> f3383a = new LinkedHashSet();
    private final LinkedHashMap<String, MessagePushData> f3384b = new LinkedHashMap();
    private final DataCache f3385c;
    private final DbFetchThreadHandler f3386d;
    private final MessagesBroadcaster f3387e;
    private final NotificationDelayTestAnalytics f3388f;
    private final Provider<String> f3389g;
    private final QeAccessor f3390h;
    private final DefaultThreadKeyFactory f3391i;

    private static NotificationDelayTestManager m3281b(InjectorLike injectorLike) {
        return new NotificationDelayTestManager(DataCache.a(injectorLike), DbFetchThreadHandler.a(injectorLike), MessagesBroadcaster.a(injectorLike), NotificationDelayTestAnalytics.m3269a(injectorLike), IdBasedProvider.a(injectorLike, 4442), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), DefaultThreadKeyFactory.b(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.notificationpolicy.NotificationDelayTestManager m3279a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3382j;	 Catch:{ all -> 0x006c }
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
        r1 = m3281b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3382j;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.notificationpolicy.NotificationDelayTestManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.notificationpolicy.NotificationDelayTestManager) r0;	 Catch:{  }
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
        r0 = f3382j;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.notificationpolicy.NotificationDelayTestManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.notificationpolicy.NotificationDelayTestManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.notificationpolicy.NotificationDelayTestManager");
    }

    @Inject
    NotificationDelayTestManager(DataCache dataCache, DbFetchThreadHandler dbFetchThreadHandler, MessagesBroadcaster messagesBroadcaster, NotificationDelayTestAnalytics notificationDelayTestAnalytics, Provider<String> provider, QeAccessor qeAccessor, ThreadKeyFactory threadKeyFactory) {
        this.f3385c = dataCache;
        this.f3386d = dbFetchThreadHandler;
        this.f3387e = messagesBroadcaster;
        this.f3388f = notificationDelayTestAnalytics;
        this.f3389g = provider;
        this.f3390h = qeAccessor;
        this.f3391i = threadKeyFactory;
    }

    public final synchronized void m3282a(Long l, String str) {
        if (m3280a() && !l.toString().equals(this.f3389g.get())) {
            this.f3388f.m3272a(str);
            if (this.f3383a.size() >= 100) {
                Iterator it = this.f3383a.iterator();
                it.next();
                it.remove();
            }
            this.f3383a.add(str);
            MessagePushData messagePushData = (MessagePushData) this.f3384b.remove(str);
            if (messagePushData != null) {
                this.f3388f.m3275d(str);
                this.f3387e.a(messagePushData);
            }
        }
    }

    public final synchronized boolean m3283a(String str, JsonNode jsonNode, PushProperty pushProperty) {
        boolean z = true;
        synchronized (this) {
            if (m3280a()) {
                String b = JSONUtil.b(jsonNode.b("n"));
                this.f3388f.m3273b(b);
                if (this.f3390h.a(Liveness.Live, ExperimentsForNotificationPolicyModule.f3376f, false)) {
                    ThreadKey a = m3278a(jsonNode);
                    if (a == null) {
                        this.f3388f.m3276e(b);
                    } else if (this.f3385c.a(a) == null && !this.f3386d.a(a, 0).a()) {
                        this.f3388f.m3277f(b);
                    }
                }
                if (this.f3383a.contains(b)) {
                    this.f3388f.m3274c(b);
                } else if (this.f3384b.containsKey(b)) {
                    z = false;
                } else {
                    MessagePushData messagePushData = new MessagePushData(str, jsonNode.toString(), pushProperty);
                    if (this.f3384b.size() >= 100) {
                        Iterator it = this.f3384b.keySet().iterator();
                        it.next();
                        it.remove();
                    }
                    this.f3384b.put(b, messagePushData);
                    z = false;
                }
            }
        }
        return z;
    }

    private boolean m3280a() {
        return this.f3390h.a(Liveness.Live, ExperimentsForNotificationPolicyModule.f3375e, false) && this.f3390h.a(Liveness.Live, ExperimentsForNotificationPolicyModule.f3372b, false);
    }

    @Nullable
    private ThreadKey m3278a(JsonNode jsonNode) {
        if (JSONUtil.d(jsonNode.b("g")) != 1) {
            String b = JSONUtil.b(jsonNode.b("uid"));
            if (Objects.equal(b, "0") || b == null) {
                return null;
            }
            return this.f3391i.a(Long.parseLong(b));
        } else if (jsonNode.d("f")) {
            return ThreadKey.a(JSONUtil.c(jsonNode.b("f")));
        } else {
            return null;
        }
    }
}

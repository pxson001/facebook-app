package com.facebook.messaging.sync.delta;

import android.os.Bundle;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.cache.MessagesBroadcaster.ThreadUpdateCause;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.NewMessageNotification;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

@UserScoped
/* compiled from: profile_tile_section_type */
public class DeltaUiChangesCache implements IHaveUserData {
    private static final Object f4351h = new Object();
    public final MessagesBroadcaster f4352a;
    public final Map<ThreadKey, List<NewMessageNotification>> f4353b = Maps.c();
    public final Set<ThreadKey> f4354c = Sets.a();
    public final Map<ThreadKey, Bundle> f4355d = Maps.c();
    public final Map<ThreadKey, Bundle> f4356e = Maps.c();
    public final Map<ThreadKey, DeletedMessages> f4357f = Maps.c();
    public final Map<ThreadKey, Bundle> f4358g = Maps.c();

    /* compiled from: profile_tile_section_type */
    public final class DeletedMessages {
        public final ThreadKey f4348a;
        public final List<String> f4349b = Lists.a();
        public final List<String> f4350c = Lists.a();

        public DeletedMessages(ThreadKey threadKey) {
            this.f4348a = threadKey;
        }
    }

    private static DeltaUiChangesCache m3962b(InjectorLike injectorLike) {
        return new DeltaUiChangesCache(MessagesBroadcaster.a(injectorLike));
    }

    @Inject
    public DeltaUiChangesCache(MessagesBroadcaster messagesBroadcaster) {
        this.f4352a = messagesBroadcaster;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.DeltaUiChangesCache m3961a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4351h;	 Catch:{ all -> 0x006c }
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
        r1 = m3962b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4351h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.DeltaUiChangesCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.DeltaUiChangesCache) r0;	 Catch:{  }
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
        r0 = f4351h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.DeltaUiChangesCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.DeltaUiChangesCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.DeltaUiChangesCache");
    }

    public final void m3966a(ThreadKey threadKey, NewMessageNotification newMessageNotification) {
        m3963e(threadKey).add(newMessageNotification);
        this.f4355d.remove(threadKey);
        this.f4356e.remove(threadKey);
    }

    public final void m3965a(ThreadKey threadKey, long j) {
        Map map = this.f4358g;
        MessagesBroadcaster messagesBroadcaster = this.f4352a;
        map.put(threadKey, MessagesBroadcaster.a(ThreadUpdateCause.MESSAGE_SENT_DELTA, threadKey, -1, FbTraceNode.a, j));
    }

    public final void m3964a(ThreadKey threadKey) {
        m3963e(threadKey);
    }

    public final void m3967c(ThreadKey threadKey) {
        m3963e(threadKey);
        this.f4354c.remove(threadKey);
    }

    public void clearUserData() {
        m3968e();
    }

    public final void m3968e() {
        this.f4357f.clear();
        this.f4353b.clear();
        this.f4354c.clear();
        this.f4355d.clear();
        this.f4356e.clear();
        this.f4358g.clear();
    }

    private List<NewMessageNotification> m3963e(ThreadKey threadKey) {
        List<NewMessageNotification> list = (List) this.f4353b.get(threadKey);
        if (list != null) {
            return list;
        }
        List a = Lists.a();
        this.f4353b.put(threadKey, a);
        return a;
    }
}

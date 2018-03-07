package com.facebook.messaging.bugreporter.foldercounts;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.bugreporter.activity.ComponentWithDebugInfo;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.inject.Inject;

@UserScoped
/* compiled from: lastDeliveredReceiptMsgId */
public class FolderCountsDebugDataTracker implements ComponentWithDebugInfo {
    private static final Object f9611e = new Object();
    private final FolderCountDebugInfo f9612a = new FolderCountDebugInfo();
    private final FolderCountDebugInfo f9613b = new FolderCountDebugInfo();
    private final Clock f9614c;
    private MarkFolderSeenResult f9615d = new MarkFolderSeenResult(null, Channel.UNKNOWN, null, false);

    /* compiled from: lastDeliveredReceiptMsgId */
    class FolderCountDebugInfo {
        private int f9616a = -1;
        private int f9617b = -1;
        private int f9618c = -1;
        private long f9619d = -1;

        public String toString() {
            return new ToStringHelper("FolderCountDebugInfo").add("unread", this.f9616a).add("unseen", this.f9617b).add("recent_unread", this.f9618c).add("updateTimestamp", this.f9619d).toString();
        }
    }

    private static FolderCountsDebugDataTracker m10058b(InjectorLike injectorLike) {
        return new FolderCountsDebugDataTracker(SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FolderCountsDebugDataTracker(SystemClock systemClock) {
        this.f9614c = systemClock;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker m10057a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9611e;	 Catch:{ all -> 0x006c }
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
        r1 = m10058b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9611e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker) r0;	 Catch:{  }
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
        r0 = f9611e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker.a(com.facebook.inject.InjectorLike):com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker");
    }

    public final synchronized void m10059a(int i, int i2) {
        this.f9612a.f9616a = i;
        this.f9612a.f9617b = i2;
        this.f9612a.f9619d = this.f9614c.a();
    }

    public final synchronized void m10060a(int i, int i2, int i3) {
        this.f9612a.f9618c = i3;
        m10059a(i, i2);
    }

    public final synchronized void m10062b(int i, int i2, int i3) {
        this.f9613b.f9616a = i;
        this.f9613b.f9617b = i2;
        this.f9613b.f9618c = i3;
        this.f9613b.f9619d = this.f9614c.a();
    }

    public final synchronized void m10061a(MarkFolderSeenResult markFolderSeenResult) {
        this.f9615d = markFolderSeenResult;
    }

    public synchronized Map<String, String> getDebugInfo() {
        return ImmutableMap.builder().b("latestInboxFromPush", this.f9612a.toString()).b("latestInboxFromFetch", this.f9613b.toString()).b("latestMarkFolderSeenResult", this.f9615d.toString()).b();
    }
}

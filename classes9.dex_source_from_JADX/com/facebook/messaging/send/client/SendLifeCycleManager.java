package com.facebook.messaging.send.client;

import android.util.SparseArray;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: default_target_spec */
public class SendLifeCycleManager {
    private static final SparseArray<Object> f16736a;
    private static final SparseArray<Object> f16737b;
    private static final Object f16738h = new Object();
    private final DefaultAndroidThreadUtil f16739c;
    private final AbstractFbErrorReporter f16740d;
    private final MessagingPerformanceLogger f16741e;
    @GuardedBy("ui_thread")
    private final Map<String, SendLifeCycleState> f16742f = Maps.c();
    @GuardedBy("ui_thread")
    private final Map<String, SettableFuture<SendResult>> f16743g = Maps.c();

    /* compiled from: default_target_spec */
    class SendLifeCycleState {
        final Message f16733a;
        int f16734b = 100;
        int f16735c = 200;

        SendLifeCycleState(Message message) {
            this.f16733a = message;
        }
    }

    private static SendLifeCycleManager m16765b(InjectorLike injectorLike) {
        return new SendLifeCycleManager(DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), MessagingPerformanceLogger.a(injectorLike));
    }

    static {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(100, Boolean.TRUE);
        sparseArray.append(101, Boolean.TRUE);
        sparseArray.append(102, Boolean.TRUE);
        f16736a = sparseArray;
        sparseArray = new SparseArray();
        sparseArray.append(201, Boolean.TRUE);
        sparseArray.append(202, Boolean.TRUE);
        sparseArray.append(203, Boolean.TRUE);
        sparseArray.append(204, Boolean.TRUE);
        f16737b = sparseArray;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.client.SendLifeCycleManager m16762a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f16738h;	 Catch:{ all -> 0x006c }
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
        r1 = m16765b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16738h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.SendLifeCycleManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.client.SendLifeCycleManager) r0;	 Catch:{  }
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
        r0 = f16738h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.SendLifeCycleManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.client.SendLifeCycleManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.client.SendLifeCycleManager");
    }

    @Inject
    public SendLifeCycleManager(DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, MessagingPerformanceLogger messagingPerformanceLogger) {
        this.f16739c = defaultAndroidThreadUtil;
        this.f16740d = abstractFbErrorReporter;
        this.f16741e = messagingPerformanceLogger;
    }

    final ListenableFuture<SendResult> m16767a(Message message) {
        this.f16739c.a();
        String str = message.n;
        if (((SendLifeCycleState) this.f16742f.get(str)) != null) {
            this.f16740d.a("SendLifeCycleManager_old_state", "Send already in progress?");
        }
        this.f16742f.put(str, new SendLifeCycleState(message));
        SettableFuture f = SettableFuture.f();
        this.f16743g.put(str, f);
        return f;
    }

    public final void m16768a(String str, int i) {
        TracerDetour.a("SendLifeCycleManager.setInsertPendingState", 1819303897);
        try {
            Preconditions.checkArgument(f16736a.get(i) != null);
            this.f16741e.a(str, m16763a(i));
            this.f16739c.a();
            SendLifeCycleState sendLifeCycleState = (SendLifeCycleState) this.f16742f.get(str);
            if (sendLifeCycleState != null) {
                sendLifeCycleState.f16734b = i;
                m16766c();
            }
            TracerDetour.a(-1147361345);
        } catch (Throwable th) {
            TracerDetour.a(1555045150);
        }
    }

    public final void m16769b(String str, int i) {
        boolean z = false;
        Preconditions.checkArgument(f16737b.get(i) != null);
        this.f16739c.a();
        SendLifeCycleState sendLifeCycleState = (SendLifeCycleState) this.f16742f.get(str);
        if (sendLifeCycleState != null) {
            sendLifeCycleState.f16735c = i;
            m16766c();
            z = m16764a(sendLifeCycleState);
        }
        MessagingPerformanceLogger messagingPerformanceLogger = this.f16741e;
        if (!messagingPerformanceLogger.d.c(5505025, str.hashCode())) {
            messagingPerformanceLogger.d.e(5505025, str.hashCode());
            messagingPerformanceLogger.a(str, "non_specified_start");
        }
        if (z) {
            this.f16741e.d.b(5505025, str.hashCode(), m16763a(i));
            return;
        }
        this.f16741e.a(str, m16763a(i));
    }

    private void m16766c() {
        this.f16739c.a();
        Iterator it = this.f16742f.values().iterator();
        while (it.hasNext()) {
            SendLifeCycleState sendLifeCycleState = (SendLifeCycleState) it.next();
            if (m16764a(sendLifeCycleState)) {
                it.remove();
                SettableFuture settableFuture = (SettableFuture) this.f16743g.remove(sendLifeCycleState.f16733a.n);
                if (settableFuture != null) {
                    FutureDetour.a(settableFuture, new SendResult(sendLifeCycleState.f16733a, sendLifeCycleState.f16734b == 101, sendLifeCycleState.f16735c == 203), 3208949);
                }
            }
        }
    }

    private static boolean m16764a(SendLifeCycleState sendLifeCycleState) {
        if (sendLifeCycleState.f16734b == 100) {
            return false;
        }
        if (sendLifeCycleState.f16735c == 203 || sendLifeCycleState.f16735c == 204) {
            return true;
        }
        return false;
    }

    private static short m16763a(int i) {
        switch (i) {
            case 100:
                return (short) 54;
            case 101:
                return (short) 55;
            case 102:
                return (short) 56;
            case 200:
                return (short) 50;
            case 201:
                return (short) 48;
            case 202:
                return (short) 49;
            case 203:
                return (short) 2;
            case 204:
                return (short) 3;
            default:
                return (short) 51;
        }
    }
}

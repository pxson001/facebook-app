package com.facebook.messaging.tincan.messenger;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@UserScoped
/* compiled from: click_resend_code_button */
public final class TincanSendMessageManager {
    private static final Object f18039c = new Object();
    private final DefaultBlueServiceOperationFactory f18040a;
    private final Executor f18041b;

    private static TincanSendMessageManager m18032b(InjectorLike injectorLike) {
        return new TincanSendMessageManager(DefaultBlueServiceOperationFactory.b(injectorLike), Executor_SameThreadExecutorMethodAutoProvider.a(injectorLike));
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public TincanSendMessageManager(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Executor executor) {
        this.f18040a = defaultBlueServiceOperationFactory;
        this.f18041b = executor;
    }

    public final ListenableFuture<SendResult> m18033a(Message message) {
        Preconditions.checkArgument(ThreadKey.g(message.b));
        final SettableFuture f = SettableFuture.f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("message", message);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f18040a, "TincanSendMessage", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(TincanSendMessageManager.class), 1244243410).a(), new OperationResultFutureCallback2(this) {
            final /* synthetic */ TincanSendMessageManager f18038b;

            public final void m18028a(OperationResult operationResult) {
                FutureDetour.a(f, new SendResult((Message) operationResult.h(), true, false), -684719675);
            }

            protected final void m18030a(Throwable th) {
                f.a(th);
            }
        }, this.f18041b);
        return f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.messenger.TincanSendMessageManager m18031a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f18039c;	 Catch:{ all -> 0x006c }
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
        r1 = m18032b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f18039c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.TincanSendMessageManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.messenger.TincanSendMessageManager) r0;	 Catch:{  }
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
        r0 = f18039c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.TincanSendMessageManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.messenger.TincanSendMessageManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.messenger.TincanSendMessageManager");
    }
}

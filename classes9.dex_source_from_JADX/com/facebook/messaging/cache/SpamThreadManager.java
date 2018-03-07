package com.facebook.messaging.cache;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkThreadFields.MarkThreadFieldsBuilder;
import com.facebook.messaging.service.model.MarkThreadsParams;
import com.facebook.messaging.service.model.MarkThreadsParams.MarkThreadsParamsBuilder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Set;
import javax.inject.Inject;

@UserScoped
/* compiled from: method/FriendFinderContinuousSyncSettingPost */
public class SpamThreadManager {
    private static final Object f9543d = new Object();
    public final MessagesBroadcaster f9544a;
    public final DefaultBlueServiceOperationFactory f9545b;
    public final Set<ThreadKey> f9546c = Sets.a();

    private static SpamThreadManager m10134b(InjectorLike injectorLike) {
        return new SpamThreadManager(MessagesBroadcaster.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public SpamThreadManager(MessagesBroadcaster messagesBroadcaster, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f9544a = messagesBroadcaster;
        this.f9545b = defaultBlueServiceOperationFactory;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.cache.SpamThreadManager m10133a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9543d;	 Catch:{ all -> 0x006c }
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
        r1 = m10134b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9543d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.SpamThreadManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.cache.SpamThreadManager) r0;	 Catch:{  }
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
        r0 = f9543d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.SpamThreadManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.SpamThreadManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.SpamThreadManager");
    }

    public final void m10135a(ThreadSummary threadSummary) {
        ImmutableList<ThreadSummary> of = ImmutableList.of(threadSummary);
        MarkThreadsParamsBuilder markThreadsParamsBuilder = new MarkThreadsParamsBuilder();
        markThreadsParamsBuilder.f17212a = Mark.SPAM;
        MarkThreadsParamsBuilder markThreadsParamsBuilder2 = markThreadsParamsBuilder;
        for (ThreadSummary threadSummary2 : of) {
            MarkThreadFieldsBuilder markThreadFieldsBuilder = new MarkThreadFieldsBuilder();
            markThreadFieldsBuilder.f17198a = threadSummary2.a;
            markThreadFieldsBuilder = markThreadFieldsBuilder;
            markThreadFieldsBuilder.f17199b = true;
            markThreadFieldsBuilder = markThreadFieldsBuilder;
            markThreadFieldsBuilder.f17200c = threadSummary2.c;
            markThreadFieldsBuilder = markThreadFieldsBuilder;
            markThreadFieldsBuilder.f17201d = threadSummary2.d;
            markThreadsParamsBuilder2.m17153a(markThreadFieldsBuilder.m17152a());
        }
        final Object a = markThreadsParamsBuilder2.m17154a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("markThreadsParams", a);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f9545b, "mark_threads", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), 632699716).a(), new OperationResultFutureCallback(this) {
            final /* synthetic */ SpamThreadManager f9542b;

            public final void m10132a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                this.f9542b.f9546c.removeAll(a.f17218d);
            }

            protected final void m10131a(ServiceException serviceException) {
                SpamThreadManager spamThreadManager = this.f9542b;
                MarkThreadsParams markThreadsParams = a;
                spamThreadManager.f9546c.removeAll(markThreadsParams.f17218d);
                spamThreadManager.f9544a.a(markThreadsParams.f17218d);
            }
        }, MoreExecutors.a());
        for (ThreadSummary threadSummary22 : of) {
            this.f9546c.add(threadSummary22.a);
        }
    }
}

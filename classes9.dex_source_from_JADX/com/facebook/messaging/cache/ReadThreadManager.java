package com.facebook.messaging.cache;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.service.model.MarkThreadFields.MarkThreadFieldsBuilder;
import com.facebook.messaging.service.model.MarkThreadsParams;
import com.facebook.messaging.service.model.MarkThreadsParams.MarkThreadsParamsBuilder;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@UserScoped
/* compiled from: method/bookmarks.set */
public class ReadThreadManager {
    private static final Class<?> f9526a = ReadThreadManager.class;
    private static final Object f9527j = new Object();
    private final MessagesBroadcaster f9528b;
    private final DefaultBlueServiceOperationFactory f9529c;
    public final ExecutorService f9530d;
    private BaseFbBroadcastManager f9531e;
    private SelfRegistrableReceiverImpl f9532f = this.f9531e.a().a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C11071(this)).a();
    public Map<ThreadKey, MarkThreadFields> f9533g;
    private DefaultAppChoreographer f9534h;
    public final DataCache f9535i;

    /* compiled from: method/bookmarks.set */
    class C11071 implements ActionReceiver {
        final /* synthetic */ ReadThreadManager f9518a;

        C11071(ReadThreadManager readThreadManager) {
            this.f9518a = readThreadManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -455497088);
            switch (C11115.f9525a[PushStateEvent.fromValue(intent.getIntExtra("event", -1)).ordinal()]) {
                case 1:
                    ReadThreadManager readThreadManager = this.f9518a;
                    MarkThreadsParamsBuilder markThreadsParamsBuilder = new MarkThreadsParamsBuilder();
                    markThreadsParamsBuilder.f17212a = Mark.READ;
                    MarkThreadsParamsBuilder markThreadsParamsBuilder2 = markThreadsParamsBuilder;
                    for (MarkThreadFields markThreadFields : readThreadManager.f9533g.values()) {
                        if (markThreadFields.f17206c >= readThreadManager.f9535i.c(markThreadFields.f17204a)) {
                            markThreadsParamsBuilder2.m17153a(markThreadFields);
                        }
                    }
                    ExecutorDetour.a(readThreadManager.f9530d, new C11104(readThreadManager, markThreadsParamsBuilder2.m17154a()), -1284685847);
                    readThreadManager.f9533g.clear();
                    break;
            }
            LogUtils.e(1374934031, a);
        }
    }

    /* compiled from: method/bookmarks.set */
    public class C11104 implements Runnable {
        final /* synthetic */ MarkThreadsParams f9523a;
        final /* synthetic */ ReadThreadManager f9524b;

        public C11104(ReadThreadManager readThreadManager, MarkThreadsParams markThreadsParams) {
            this.f9524b = readThreadManager;
            this.f9523a = markThreadsParams;
        }

        public void run() {
            if (!this.f9523a.f17217c.isEmpty()) {
                ReadThreadManager.m10122b(this.f9524b, this.f9523a);
            }
        }
    }

    /* compiled from: method/bookmarks.set */
    /* synthetic */ class C11115 {
        static final /* synthetic */ int[] f9525a = new int[PushStateEvent.values().length];

        static {
            try {
                f9525a[PushStateEvent.CHANNEL_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private static ReadThreadManager m10121b(InjectorLike injectorLike) {
        return new ReadThreadManager(MessagesBroadcaster.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), DefaultAppChoreographer.a(injectorLike), DataCache.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.cache.ReadThreadManager m10118a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9527j;	 Catch:{ all -> 0x006c }
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
        r1 = m10121b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9527j;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.ReadThreadManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.cache.ReadThreadManager) r0;	 Catch:{  }
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
        r0 = f9527j;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.ReadThreadManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.ReadThreadManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.ReadThreadManager");
    }

    @Inject
    public ReadThreadManager(MessagesBroadcaster messagesBroadcaster, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, BaseFbBroadcastManager baseFbBroadcastManager, DefaultAppChoreographer defaultAppChoreographer, DataCache dataCache) {
        this.f9528b = messagesBroadcaster;
        this.f9529c = defaultBlueServiceOperationFactory;
        this.f9530d = executorService;
        this.f9531e = baseFbBroadcastManager;
        this.f9534h = defaultAppChoreographer;
        this.f9535i = dataCache;
        this.f9532f.b();
        this.f9533g = Maps.c();
    }

    public final void m10123a(ThreadKey threadKey) {
        ThreadSummary a = this.f9535i.a(threadKey);
        if (a != null) {
            m10125a(a);
        }
    }

    public final void m10125a(ThreadSummary threadSummary) {
        m10119a(threadSummary, true);
    }

    public final void m10126b(ThreadSummary threadSummary) {
        m10119a(threadSummary, false);
    }

    private void m10119a(ThreadSummary threadSummary, boolean z) {
        long j = threadSummary.c;
        if (ThreadKey.d(threadSummary.a) && !z) {
            j = 0;
        }
        MarkThreadFieldsBuilder markThreadFieldsBuilder = new MarkThreadFieldsBuilder();
        markThreadFieldsBuilder.f17198a = threadSummary.a;
        markThreadFieldsBuilder = markThreadFieldsBuilder;
        markThreadFieldsBuilder.f17199b = z;
        markThreadFieldsBuilder = markThreadFieldsBuilder;
        markThreadFieldsBuilder.f17200c = j;
        MarkThreadFieldsBuilder markThreadFieldsBuilder2 = markThreadFieldsBuilder;
        markThreadFieldsBuilder2.f17201d = threadSummary.d;
        markThreadFieldsBuilder2 = markThreadFieldsBuilder2;
        markThreadFieldsBuilder2.f17203f = threadSummary.A;
        markThreadFieldsBuilder2 = markThreadFieldsBuilder2;
        markThreadFieldsBuilder2.f17202e = threadSummary.k;
        MarkThreadFields a = markThreadFieldsBuilder2.m17152a();
        MarkThreadsParamsBuilder markThreadsParamsBuilder = new MarkThreadsParamsBuilder();
        markThreadsParamsBuilder.f17212a = Mark.READ;
        MarkThreadsParams a2 = markThreadsParamsBuilder.m17153a(a).m17154a();
        this.f9535i.a(a);
        m10120a(a2);
    }

    private void m10120a(final MarkThreadsParams markThreadsParams) {
        DataCache dataCache = this.f9535i;
        ImmutableList immutableList = markThreadsParams.f17217c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            dataCache.a((MarkThreadFields) immutableList.get(i));
        }
        this.f9534h.a("markThreadsRead", new Runnable(this) {
            final /* synthetic */ ReadThreadManager f9520b;

            public void run() {
                ReadThreadManager.m10122b(this.f9520b, markThreadsParams);
            }
        }, Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI);
        this.f9528b.b(markThreadsParams.f17218d);
    }

    public static void m10122b(ReadThreadManager readThreadManager, final MarkThreadsParams markThreadsParams) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("markThreadsParams", markThreadsParams);
        Futures.a(BlueServiceOperationFactoryDetour.a(readThreadManager.f9529c, "mark_threads", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(readThreadManager.getClass()), -1589566962).a(), new OperationResultFutureCallback(readThreadManager) {
            final /* synthetic */ ReadThreadManager f9522b;

            protected final void m10116a(ServiceException serviceException) {
                ImmutableList immutableList = markThreadsParams.f17217c;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    MarkThreadFields markThreadFields = (MarkThreadFields) immutableList.get(i);
                    MarkThreadFields markThreadFields2 = (MarkThreadFields) this.f9522b.f9533g.get(markThreadFields.f17204a);
                    if (markThreadFields2 == null || markThreadFields2.f17206c <= markThreadFields.f17206c || markThreadFields.f17206c == 0) {
                        this.f9522b.f9533g.put(markThreadFields.f17204a, markThreadFields);
                    }
                }
            }
        }, MoreExecutors.a());
    }

    public final void m10124a(ThreadKey threadKey, long j, long j2) {
        MarkThreadFieldsBuilder markThreadFieldsBuilder = new MarkThreadFieldsBuilder();
        markThreadFieldsBuilder.f17198a = threadKey;
        markThreadFieldsBuilder = markThreadFieldsBuilder;
        markThreadFieldsBuilder.f17199b = true;
        markThreadFieldsBuilder = markThreadFieldsBuilder;
        markThreadFieldsBuilder.f17200c = j;
        markThreadFieldsBuilder = markThreadFieldsBuilder;
        markThreadFieldsBuilder.f17202e = j2;
        MarkThreadFields a = markThreadFieldsBuilder.m17152a();
        this.f9535i.a(a);
        MarkThreadsParamsBuilder markThreadsParamsBuilder = new MarkThreadsParamsBuilder();
        markThreadsParamsBuilder.f17212a = Mark.READ;
        MarkThreadsParamsBuilder a2 = markThreadsParamsBuilder.m17153a(a);
        a2.f17213b = false;
        Parcelable a3 = a2.m17154a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("markThreadsParams", a3);
        BlueServiceOperationFactoryDetour.a(this.f9529c, "mark_threads", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), 1843804938).a(true).a();
        this.f9528b.c(threadKey);
    }
}

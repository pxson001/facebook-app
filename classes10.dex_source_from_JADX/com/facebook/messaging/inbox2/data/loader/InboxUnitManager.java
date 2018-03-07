package com.facebook.messaging.inbox2.data.loader;

import android.content.Context;
import android.content.Intent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.enums.GraphQLMessengerInboxUnitType;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.data.common.InboxUnit;
import com.facebook.messaging.inbox2.data.common.InboxUnitFetcher;
import com.facebook.messaging.inbox2.data.common.InboxUnitParams;
import com.facebook.messaging.inbox2.data.common.InboxUnitResult;
import com.facebook.messaging.inbox2.data.common.InboxUnitsToFetch;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: server_validation */
public class InboxUnitManager {
    private static final Class<?> f2778a = InboxUnitManager.class;
    private static final Object f2779i = new Object();
    private final InboxUnitFetcher f2780b;
    private final BaseFbBroadcastManager f2781c;
    private final SelfRegistrableReceiverImpl f2782d;
    private final C04551 f2783e = new C04551(this);
    @GuardedBy("this")
    @Nullable
    private FetchInfo f2784f;
    @GuardedBy("this")
    @Nullable
    private InboxUnitResult f2785g;
    @GuardedBy("this")
    private boolean f2786h;

    /* compiled from: server_validation */
    public class C04551 {
        public final /* synthetic */ InboxUnitManager f2768a;

        C04551(InboxUnitManager inboxUnitManager) {
            this.f2768a = inboxUnitManager;
        }
    }

    /* compiled from: server_validation */
    class C04562 implements ActionReceiver {
        final /* synthetic */ InboxUnitManager f2769a;

        C04562(InboxUnitManager inboxUnitManager) {
            this.f2769a = inboxUnitManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 353791420);
            InboxUnitManager.m2729a(this.f2769a, intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1878636456, a);
        }
    }

    /* compiled from: server_validation */
    class C04573 extends AbstractDisposableFutureCallback<InboxUnitResult> {
        final /* synthetic */ InboxUnitManager f2770a;

        C04573(InboxUnitManager inboxUnitManager) {
            this.f2770a = inboxUnitManager;
        }

        protected final void m2722a(Object obj) {
            InboxUnitResult inboxUnitResult = (InboxUnitResult) obj;
            synchronized (this.f2770a) {
                this.f2770a.f2785g = inboxUnitResult;
                this.f2770a.f2784f = null;
                InboxUnitManager.m2730a(this.f2770a, false);
                InboxUnitManager.m2730a(this.f2770a, true);
                InboxUnitManager.m2736b(this.f2770a, true);
            }
        }

        protected final void m2723a(Throwable th) {
            synchronized (this.f2770a) {
                this.f2770a.f2784f = null;
            }
        }
    }

    /* compiled from: server_validation */
    /* synthetic */ class C04584 {
        static final /* synthetic */ int[] f2772b = new int[DataFreshnessParam.values().length];

        static {
            try {
                f2772b[DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2772b[DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2772b[DataFreshnessParam.STALE_DATA_OKAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2772b[DataFreshnessParam.DO_NOT_CHECK_SERVER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f2771a = new int[FetchStrategy.values().length];
            try {
                f2771a[FetchStrategy.USE_CURRENT_FETCH.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2771a[FetchStrategy.START_NEW_INDEPENDENT_FETCH.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2771a[FetchStrategy.START_NEW_FETCH_AND_TRACK_RESULT.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: server_validation */
    public class CachedResult {
        public final InboxUnitResult f2773a;
        public final boolean f2774b;

        public CachedResult(InboxUnitResult inboxUnitResult, boolean z) {
            this.f2773a = (InboxUnitResult) Preconditions.checkNotNull(inboxUnitResult);
            this.f2774b = z;
        }
    }

    /* compiled from: server_validation */
    class FetchInfo {
        final InboxUnitParams f2775a;
        final ListenableFuture<InboxUnitResult> f2776b;
        final DisposableFutureCallback<InboxUnitResult> f2777c;

        public FetchInfo(InboxUnitParams inboxUnitParams, ListenableFuture<InboxUnitResult> listenableFuture, DisposableFutureCallback<InboxUnitResult> disposableFutureCallback) {
            this.f2775a = inboxUnitParams;
            this.f2776b = listenableFuture;
            this.f2777c = disposableFutureCallback;
        }

        final void m2724a() {
            this.f2777c.jc_();
        }
    }

    @VisibleForTesting
    /* compiled from: server_validation */
    enum FetchStrategy {
        USE_CURRENT_FETCH,
        START_NEW_FETCH_AND_TRACK_RESULT,
        START_NEW_INDEPENDENT_FETCH
    }

    private static InboxUnitManager m2733b(InjectorLike injectorLike) {
        return new InboxUnitManager(InboxUnitFetcherMethodAutoProvider.m2715b(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.inbox2.data.loader.InboxUnitManager m2728a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f2779i;	 Catch:{ all -> 0x006c }
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
        r1 = m2733b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f2779i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.inbox2.data.loader.InboxUnitManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.inbox2.data.loader.InboxUnitManager) r0;	 Catch:{  }
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
        r0 = f2779i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.inbox2.data.loader.InboxUnitManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.inbox2.data.loader.InboxUnitManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.inbox2.data.loader.InboxUnitManager");
    }

    @Inject
    InboxUnitManager(InboxUnitFetcher inboxUnitFetcher, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f2780b = inboxUnitFetcher;
        this.f2781c = baseFbBroadcastManager;
        C04562 c04562 = new C04562(this);
        this.f2782d = this.f2781c.a().a(MessagesBroadcastIntents.a, c04562).a(MessagesBroadcastIntents.b, c04562).a(MessagesBroadcastIntents.d, c04562).a(MessagesBroadcastIntents.c, c04562).a();
    }

    @Nullable
    public final synchronized CachedResult m2737a() {
        CachedResult cachedResult;
        if (this.f2785g == null) {
            cachedResult = null;
        } else {
            cachedResult = new CachedResult(this.f2785g, this.f2786h);
        }
        return cachedResult;
    }

    public final synchronized ListenableFuture<InboxUnitResult> m2738a(InboxUnitParams inboxUnitParams) {
        ListenableFuture<InboxUnitResult> b;
        boolean z = true;
        synchronized (this) {
            switch (m2727a(this.f2784f != null ? this.f2784f.f2775a : null, inboxUnitParams)) {
                case USE_CURRENT_FETCH:
                    if (this.f2784f == null) {
                        z = false;
                    }
                    Preconditions.checkState(z);
                    b = Futures.b(this.f2784f.f2776b);
                    break;
                case START_NEW_INDEPENDENT_FETCH:
                    b = this.f2780b.mo77a(inboxUnitParams);
                    break;
                case START_NEW_FETCH_AND_TRACK_RESULT:
                    m2734b(inboxUnitParams);
                    if (this.f2784f == null) {
                        z = false;
                    }
                    Preconditions.checkState(z);
                    b = Futures.b(this.f2784f.f2776b);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        return b;
    }

    private synchronized void m2734b(InboxUnitParams inboxUnitParams) {
        if (this.f2784f != null) {
            this.f2784f.m2724a();
            this.f2784f = null;
        }
        ListenableFuture a = this.f2780b.mo77a(inboxUnitParams);
        C04573 c04573 = new C04573(this);
        Futures.a(a, c04573);
        this.f2784f = new FetchInfo(inboxUnitParams, a, c04573);
    }

    @VisibleForTesting
    private static FetchStrategy m2727a(@Nullable InboxUnitParams inboxUnitParams, InboxUnitParams inboxUnitParams2) {
        if (inboxUnitParams2.f2753b == InboxUnitsToFetch.TOP) {
            return FetchStrategy.START_NEW_INDEPENDENT_FETCH;
        }
        DataFreshnessParam dataFreshnessParam = inboxUnitParams != null ? inboxUnitParams.f2752a : null;
        switch (C04584.f2772b[inboxUnitParams2.f2752a.ordinal()]) {
            case 1:
                if (dataFreshnessParam == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
                    return FetchStrategy.USE_CURRENT_FETCH;
                }
                return FetchStrategy.START_NEW_FETCH_AND_TRACK_RESULT;
            case 2:
                if (dataFreshnessParam == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA || dataFreshnessParam == DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE) {
                    return FetchStrategy.USE_CURRENT_FETCH;
                }
                return FetchStrategy.START_NEW_FETCH_AND_TRACK_RESULT;
            case 3:
                if (dataFreshnessParam == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA || dataFreshnessParam == DataFreshnessParam.STALE_DATA_OKAY || dataFreshnessParam == DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE) {
                    return FetchStrategy.USE_CURRENT_FETCH;
                }
                return FetchStrategy.START_NEW_FETCH_AND_TRACK_RESULT;
            case 4:
                if (dataFreshnessParam == DataFreshnessParam.DO_NOT_CHECK_SERVER) {
                    return FetchStrategy.USE_CURRENT_FETCH;
                }
                if (dataFreshnessParam == null) {
                    return FetchStrategy.START_NEW_FETCH_AND_TRACK_RESULT;
                }
                return FetchStrategy.START_NEW_INDEPENDENT_FETCH;
            default:
                return FetchStrategy.START_NEW_INDEPENDENT_FETCH;
        }
    }

    public static synchronized void m2730a(InboxUnitManager inboxUnitManager, boolean z) {
        synchronized (inboxUnitManager) {
            if (z) {
                if (!inboxUnitManager.f2782d.a()) {
                    inboxUnitManager.f2782d.b();
                }
            }
            if (!z && inboxUnitManager.f2782d.a()) {
                inboxUnitManager.f2782d.c();
            }
        }
    }

    public static synchronized void m2729a(InboxUnitManager inboxUnitManager, Intent intent) {
        Object obj = 1;
        synchronized (inboxUnitManager) {
            if (inboxUnitManager.f2785g != null) {
                if (intent.hasExtra("thread_key")) {
                    Object obj2;
                    if (inboxUnitManager.m2732a(ImmutableSet.of((ThreadKey) intent.getParcelableExtra("thread_key")))) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    obj = obj2;
                } else if (intent.hasExtra("multiple_thread_keys") && !inboxUnitManager.m2732a(ImmutableSet.copyOf(intent.getParcelableArrayListExtra("multiple_thread_keys")))) {
                    obj = null;
                }
                if (obj != null) {
                    m2735b(inboxUnitManager);
                }
            }
        }
    }

    public static synchronized void m2736b(InboxUnitManager inboxUnitManager, boolean z) {
        synchronized (inboxUnitManager) {
            if (z) {
                if (inboxUnitManager.f2785g != null) {
                    inboxUnitManager.f2785g.mo76a(inboxUnitManager.f2783e);
                }
            }
            if (!(z || inboxUnitManager.f2785g == null)) {
                inboxUnitManager.f2785g.mo76a(null);
            }
        }
    }

    public static synchronized void m2735b(InboxUnitManager inboxUnitManager) {
        synchronized (inboxUnitManager) {
            inboxUnitManager.f2786h = true;
            m2736b(inboxUnitManager, false);
            inboxUnitManager.f2781c.a(MessagesBroadcastIntents.A);
        }
    }

    @GuardedBy("this")
    private boolean m2732a(Set<ThreadKey> set) {
        Preconditions.checkNotNull(this.f2785g);
        ImmutableList immutableList = this.f2785g.mo75a().f2757d;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            InboxUnit inboxUnit = (InboxUnit) immutableList.get(i);
            if (inboxUnit.f2734a == GraphQLMessengerInboxUnitType.MESSAGE_THREADS) {
                for (ThreadSummary threadSummary : ((Map) inboxUnit.f2736c).values()) {
                    if (set.contains(threadSummary.a)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }
}

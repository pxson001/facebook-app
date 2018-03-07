package com.facebook.orca.threadview;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.MessagesUiReorderer;
import com.facebook.messaging.cache.ThreadsCacheUpdateRateLimiter;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.MessagesCollectionMerger;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.service.model.FetchMoreMessagesParams;
import com.facebook.messaging.service.model.FetchMoreMessagesResult;
import com.facebook.messaging.service.model.FetchThreadHandlerChange;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Provider;

@NotThreadSafe
/* compiled from: message is a fb story share */
public class ThreadViewLoader implements FbLoader<Params, Result, Error> {
    private final DataCache f7618a;
    public final ThreadsCacheUpdateRateLimiter f7619b;
    public final DefaultBlueServiceOperationFactory f7620c;
    private final MessagesUiReorderer f7621d;
    private final MessageDeduper f7622e;
    private final MessagesCollectionMerger f7623f;
    private final AbstractFbErrorReporter f7624g;
    private final DefaultThreadKeyFactory f7625h;
    private final Provider<UserKey> f7626i;
    private final UncommittedThreadModificationsCache f7627j;
    public final DebugOverlayController f7628k;
    public final MessagingPerformanceLogger f7629l;
    private final Random f7630m;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SendMessageManager> f7631n = UltralightRuntime.b;
    public Callback<Params, Result, Error> f7632o;
    public ThreadKey f7633p;
    public FutureAndCallbackHolder<OperationResult> f7634q;
    public FutureAndCallbackHolder<OperationResult> f7635r;
    private DataFreshnessParam f7636s;
    public Params f7637t;
    public Result f7638u;
    public boolean f7639v;
    private int f7640w;
    @Nullable
    public Params f7641x;

    /* compiled from: message is a fb story share */
    public class Error {
        public final ServiceException f7602a;
        public final boolean f7603b;

        public Error(ServiceException serviceException, boolean z) {
            this.f7602a = serviceException;
            this.f7603b = z;
        }
    }

    /* compiled from: message is a fb story share */
    public enum LoadType {
        THREAD_VIEW,
        MORE_MESSAGES
    }

    /* compiled from: message is a fb story share */
    public class Params {
        public final boolean f7604a;
        public final boolean f7605b;
        public final LoadType f7606c;
        public final int f7607d;
        public final boolean f7608e;
        @Nullable
        public final ImmutableList<ParticipantInfo> f7609f;

        private Params(boolean z, boolean z2, LoadType loadType, int i, boolean z3, @Nullable List<ParticipantInfo> list) {
            this.f7604a = z;
            this.f7605b = z2;
            this.f7606c = loadType;
            this.f7607d = i;
            this.f7608e = z3;
            this.f7609f = list == null ? null : ImmutableList.copyOf(list);
        }

        private Params(boolean z, boolean z2, LoadType loadType, boolean z3) {
            this(z, z2, loadType, 20, z3, null);
        }

        public static Params m7324a(boolean z, boolean z2, int i, boolean z3) {
            return new Params(z, z2, LoadType.THREAD_VIEW, i, z3, null);
        }

        public static Params m7325a(boolean z, boolean z2, boolean z3) {
            return new Params(z, z2, LoadType.THREAD_VIEW, z3);
        }

        public static Params m7322a(List<ParticipantInfo> list) {
            return new Params(false, false, LoadType.THREAD_VIEW, 0, false, list);
        }

        public static Params m7323a(boolean z, boolean z2) {
            return new Params(z, z2, LoadType.MORE_MESSAGES, false);
        }

        public static Params m7321a(Params params, Params params2) {
            boolean z;
            boolean z2 = false;
            Preconditions.checkState(params.f7606c == params2.f7606c);
            if (params.f7604a || params2.f7604a) {
                z = true;
            } else {
                z = false;
            }
            if (params.f7605b || params2.f7605b) {
                z2 = true;
            }
            if (params.f7604a == z && params.f7605b == z2) {
                return params;
            }
            return new Params(z, z2, params.f7606c, params.f7608e);
        }
    }

    /* compiled from: message is a fb story share */
    public class Result {
        public static final Result f7610h = new Result(null, null, null, RegularImmutableList.a, false, DataFetchDisposition.a, RegularImmutableList.a);
        public final ThreadSummary f7611a;
        public final User f7612b;
        public final MessagesCollection f7613c;
        public final ImmutableList<Message> f7614d;
        public final boolean f7615e;
        public final DataFetchDisposition f7616f;
        public final ImmutableList<FetchThreadHandlerChange> f7617g;

        public Result(ThreadSummary threadSummary, User user, MessagesCollection messagesCollection, ImmutableList<Message> immutableList, boolean z, DataFetchDisposition dataFetchDisposition, ImmutableList<FetchThreadHandlerChange> immutableList2) {
            this.f7611a = threadSummary;
            this.f7612b = user;
            this.f7613c = messagesCollection;
            this.f7614d = immutableList;
            this.f7615e = z;
            this.f7616f = dataFetchDisposition;
            this.f7617g = immutableList2;
        }

        public final boolean m7329a() {
            return this.f7611a != null;
        }

        public final boolean m7330b() {
            return this.f7612b != null;
        }

        public static Result m7327a(@Nonnull ThreadSummary threadSummary, MessagesCollection messagesCollection, ImmutableList<Message> immutableList, DataFetchDisposition dataFetchDisposition, List<FetchThreadHandlerChange> list) {
            Preconditions.checkNotNull(threadSummary);
            return new Result(threadSummary, null, messagesCollection, immutableList, false, dataFetchDisposition, list != null ? ImmutableList.copyOf(list) : RegularImmutableList.a);
        }

        public static Result m7328a(Result result, Message message) {
            Preconditions.checkArgument(result != null);
            return new Result(result.f7611a, result.f7612b, result.f7613c, ImmutableList.builder().c(message).b(result.f7614d).b(), result.f7615e, result.f7616f, result.f7617g);
        }

        public static Result m7326a(@Nonnull ThreadSummary threadSummary) {
            Preconditions.checkNotNull(threadSummary);
            return new Result(threadSummary, null, null, null, true, DataFetchDisposition.j, RegularImmutableList.a);
        }
    }

    public static ThreadViewLoader m7346b(InjectorLike injectorLike) {
        ThreadViewLoader threadViewLoader = new ThreadViewLoader(DataCache.a(injectorLike), ThreadsCacheUpdateRateLimiter.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), MessagesUiReorderer.a(injectorLike), MessageDeduper.m6606a(injectorLike), MessagesCollectionMerger.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DefaultThreadKeyFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 3598), UncommittedThreadModificationsCache.m4224a(injectorLike), DebugOverlayController.a(injectorLike), MessagingPerformanceLogger.a(injectorLike));
        threadViewLoader.f7631n = IdBasedLazy.a(injectorLike, 8347);
        return threadViewLoader;
    }

    public static ThreadViewLoader m7333a(InjectorLike injectorLike) {
        return m7346b(injectorLike);
    }

    private Result m7332a(User user, DataFetchDisposition dataFetchDisposition, List<FetchThreadHandlerChange> list) {
        ImmutableList copyOf;
        ImmutableList copyOf2;
        if (user.T.a() == Type.FACEBOOK && Objects.equal(user.s, "user")) {
            copyOf = ImmutableList.copyOf(((SendMessageManager) this.f7631n.get()).b(this.f7625h.a(user.T)));
        } else {
            copyOf = RegularImmutableList.a;
        }
        Preconditions.checkNotNull(user);
        if (list != null) {
            copyOf2 = ImmutableList.copyOf(list);
        } else {
            copyOf2 = RegularImmutableList.a;
        }
        return new Result(null, user, null, copyOf, false, dataFetchDisposition, copyOf2);
    }

    @Inject
    private ThreadViewLoader(DataCache dataCache, ThreadsCacheUpdateRateLimiter threadsCacheUpdateRateLimiter, BlueServiceOperationFactory blueServiceOperationFactory, MessagesUiReorderer messagesUiReorderer, MessageDeduper messageDeduper, MessagesCollectionMerger messagesCollectionMerger, FbErrorReporter fbErrorReporter, ThreadKeyFactory threadKeyFactory, Provider<UserKey> provider, UncommittedThreadModificationsCache uncommittedThreadModificationsCache, DebugOverlayController debugOverlayController, MessagingPerformanceLogger messagingPerformanceLogger) {
        this.f7618a = dataCache;
        this.f7619b = threadsCacheUpdateRateLimiter;
        this.f7620c = blueServiceOperationFactory;
        this.f7621d = messagesUiReorderer;
        this.f7622e = messageDeduper;
        this.f7623f = messagesCollectionMerger;
        this.f7624g = fbErrorReporter;
        this.f7625h = threadKeyFactory;
        this.f7626i = provider;
        this.f7627j = uncommittedThreadModificationsCache;
        this.f7628k = debugOverlayController;
        this.f7629l = messagingPerformanceLogger;
        this.f7630m = new Random();
    }

    public final void m7351a(ThreadKey threadKey) {
        if (!Objects.equal(this.f7633p, threadKey)) {
            this.f7633p = threadKey;
            m7348c();
        }
    }

    public final void m7350a(Callback<Params, Result, Error> callback) {
        this.f7632o = callback;
    }

    public final void m7352a(Params params) {
        Preconditions.checkNotNull(params);
        if (params.f7606c == LoadType.THREAD_VIEW) {
            m7347b(params);
            return;
        }
        if (!(this.f7634q != null || this.f7635r != null || this.f7638u == null || this.f7638u.f7611a == null || this.f7638u.f7613c == null)) {
            ImmutableList immutableList = this.f7638u.f7613c.b;
            if (!(immutableList.size() == 0 || this.f7638u.f7613c.c)) {
                final Params a = Params.m7323a(false, params.f7605b);
                Message message = (Message) immutableList.get(immutableList.size() - 1);
                FetchMoreMessagesParams fetchMoreMessagesParams = new FetchMoreMessagesParams(this.f7633p, message.a, message.c, params.f7607d);
                this.f7628k.a(MessagesDebugOverlaySettingsTags.d, "ThreadViewLoader FETCH_MORE_MESSAGES " + this.f7633p);
                Bundle bundle = new Bundle();
                bundle.putParcelable("fetchMoreMessagesParams", fetchMoreMessagesParams);
                OperationFuture b = BlueServiceOperationFactoryDetour.a(this.f7620c, "fetch_more_messages", bundle, CallerContext.a(ThreadViewLoader.class), 1521183880).b();
                this.f7637t = a;
                this.f7632o.a(a, b);
                this.f7639v = a.f7605b;
                C11522 c11522 = new OperationResultFutureCallback(this) {
                    final /* synthetic */ ThreadViewLoader f7601b;

                    public final void m7320a(Object obj) {
                        OperationResult operationResult = (OperationResult) obj;
                        this.f7601b.f7635r = null;
                        ThreadViewLoader.m7341a(this.f7601b, a, operationResult);
                    }

                    protected final void m7319a(ServiceException serviceException) {
                        this.f7601b.f7635r = null;
                        ThreadViewLoader threadViewLoader = this.f7601b;
                        threadViewLoader.f7632o.c(a, new Error(serviceException, threadViewLoader.f7639v));
                        threadViewLoader.f7639v = false;
                    }
                };
                this.f7635r = FutureAndCallbackHolder.a(b, c11522);
                Futures.a(b, c11522);
            }
        }
    }

    public final void m7349a() {
        m7348c();
    }

    private void m7347b(Params params) {
        Object obj = null;
        if (this.f7633p != null) {
            TracerDetour.a("TVL.startLoadThreadView", 881684084);
            try {
                int nextInt = this.f7630m.nextInt();
                this.f7640w = nextInt;
                this.f7629l.b(nextInt, "ThreadViewLoader.startLoadThreadView");
                ThreadSummary a = this.f7618a.a(this.f7633p);
                if (a != null) {
                    MessagesCollection b = this.f7618a.b(this.f7633p);
                    if (b == null || (!b.e() && b.g() < params.f7607d)) {
                        this.f7632o.a(params, Result.m7326a(a));
                    } else {
                        DataFetchDisposition dataFetchDisposition;
                        if (params.f7604a) {
                            dataFetchDisposition = DataFetchDisposition.d;
                        } else {
                            dataFetchDisposition = DataFetchDisposition.c;
                        }
                        DataFetchDisposition h = DataFetchDisposition.newBuilder().a(dataFetchDisposition).f(TriState.YES).h();
                        this.f7638u = m7331a(a, b, h, ImmutableList.of());
                        m7340a(this.f7638u, "StartLoad");
                        this.f7632o.a(params, this.f7638u);
                        obj = 1;
                        this.f7629l.b(nextInt, h);
                        this.f7629l.n(nextInt);
                    }
                }
                if (this.f7635r != null) {
                    if (!this.f7637t.f7605b || params.f7605b) {
                        this.f7635r.a(false);
                        this.f7635r = null;
                        this.f7637t = null;
                    } else {
                        this.f7629l.n(nextInt);
                        return;
                    }
                }
                if (this.f7634q != null) {
                    this.f7637t = Params.m7321a(this.f7637t, params);
                    if (params.f7608e) {
                        this.f7641x = params;
                    }
                    this.f7629l.n(nextInt);
                    TracerDetour.a(-1564276316);
                    return;
                }
                if (obj != null) {
                    if (params.f7604a) {
                        m7337a(params, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, nextInt);
                    } else if (this.f7619b.a(this.f7633p)) {
                        m7337a(params, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, nextInt);
                    } else {
                        this.f7637t = params;
                        this.f7632o.b(this.f7637t, this.f7638u);
                    }
                } else if (!params.f7604a && m7345a(this.f7638u)) {
                    this.f7637t = params;
                    this.f7632o.b(this.f7637t, this.f7638u);
                    this.f7629l.n(nextInt);
                } else if (this.f7633p.f()) {
                    m7336a(params, nextInt);
                } else {
                    m7337a(params, DataFreshnessParam.STALE_DATA_OKAY, nextInt);
                }
                TracerDetour.a(1745424252);
            } finally {
                TracerDetour.a(41175930);
            }
        }
    }

    private void m7348c() {
        this.f7637t = null;
        this.f7638u = null;
        if (this.f7634q != null) {
            this.f7634q.a(false);
            this.f7634q = null;
            MessagingPerformanceLogger messagingPerformanceLogger = this.f7629l;
            messagingPerformanceLogger.d.b(5505041, this.f7640w, (short) 4);
        }
        if (this.f7635r != null) {
            this.f7635r.a(false);
            this.f7635r = null;
        }
    }

    private void m7336a(Params params, int i) {
        Preconditions.checkArgument(ThreadKey.f(this.f7633p));
        Preconditions.checkNotNull(params.f7609f);
        this.f7637t = params;
        List arrayList = new ArrayList();
        ImmutableList immutableList = params.f7609f;
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ParticipantInfo participantInfo = (ParticipantInfo) immutableList.get(i2);
            ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
            threadParticipantBuilder.a = participantInfo;
            arrayList.add(threadParticipantBuilder.f());
        }
        ThreadSummaryBuilder newBuilder = ThreadSummary.newBuilder();
        newBuilder.A = FolderName.INBOX;
        newBuilder = newBuilder;
        newBuilder.a = this.f7633p;
        newBuilder = newBuilder;
        newBuilder.h = arrayList;
        newBuilder = newBuilder;
        newBuilder.u = true;
        this.f7638u = m7331a(newBuilder.V(), new MessagesCollection(this.f7633p, RegularImmutableList.a, false), DataFetchDisposition.a, (List) RegularImmutableList.a);
        this.f7632o.a(this.f7637t, this.f7638u);
        this.f7632o.b(this.f7637t, this.f7638u);
        this.f7629l.n(i);
    }

    private void m7337a(final Params params, DataFreshnessParam dataFreshnessParam, final int i) {
        if (this.f7634q != null) {
            this.f7629l.n(i);
            return;
        }
        this.f7629l.b(i, "ThreadViewLoader.loadThread");
        this.f7636s = dataFreshnessParam;
        this.f7628k.a(MessagesDebugOverlaySettingsTags.d, "ThreadViewLoader FETCH_THREAD " + this.f7633p);
        Bundle bundle = new Bundle();
        FetchThreadParamsBuilder fetchThreadParamsBuilder = new FetchThreadParamsBuilder();
        fetchThreadParamsBuilder.a = ThreadCriteria.a(this.f7633p);
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.b = dataFreshnessParam;
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.f = params.f7607d;
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.h = true;
        bundle.putParcelable("fetchThreadParams", fetchThreadParamsBuilder.i());
        OperationFuture b = BlueServiceOperationFactoryDetour.a(this.f7620c, "fetch_thread", bundle, CallerContext.a(ThreadViewLoader.class), -674925999).b();
        this.f7637t = params;
        this.f7632o.a(params, b);
        C11511 c11511 = new OperationResultFutureCallback(this) {
            final /* synthetic */ ThreadViewLoader f7599c;

            public final void m7318a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                this.f7599c.f7634q = null;
                Params params = this.f7599c.f7641x;
                this.f7599c.f7641x = null;
                this.f7599c.f7629l.n(i);
                ThreadViewLoader.m7342a(this.f7599c, params, operationResult, params, i);
            }

            protected final void m7317a(ServiceException serviceException) {
                this.f7599c.f7634q = null;
                Params params = this.f7599c.f7641x;
                this.f7599c.f7641x = null;
                this.f7599c.f7629l.o(i);
                ThreadViewLoader.m7343a(this.f7599c, params, serviceException, params);
            }
        };
        this.f7634q = FutureAndCallbackHolder.a(b, c11511);
        Futures.a(b, c11511);
    }

    public static void m7342a(ThreadViewLoader threadViewLoader, Params params, OperationResult operationResult, Params params2, int i) {
        FetchThreadResult fetchThreadResult = (FetchThreadResult) operationResult.k();
        if (fetchThreadResult.c != null) {
            threadViewLoader.m7339a(params, fetchThreadResult, params2, i);
        } else if (threadViewLoader.m7334a(fetchThreadResult.e) != null) {
            threadViewLoader.m7338a(params, fetchThreadResult, params2);
        } else {
            threadViewLoader.f7624g.a("ThreadViewLoader", "Successful fetch w/o thread or user");
            m7343a(threadViewLoader, params, ServiceException.a(new AssertionError()), params2);
        }
    }

    @Nullable
    private User m7334a(ImmutableList<User> immutableList) {
        if (immutableList == null || immutableList.size() != 2) {
            return null;
        }
        UserKey userKey = (UserKey) this.f7626i.get();
        if (Objects.equal(((User) immutableList.get(0)).T, userKey)) {
            return Objects.equal(((User) immutableList.get(1)).T, userKey) ? (User) immutableList.get(1) : null;
        } else {
            return (User) immutableList.get(0);
        }
    }

    private void m7339a(Params params, FetchThreadResult fetchThreadResult, Params params2, int i) {
        ThreadSummary threadSummary = fetchThreadResult.c;
        MessagesCollection messagesCollection = fetchThreadResult.d;
        if (this.f7633p != null) {
            m7335a(threadSummary, params, fetchThreadResult);
        } else {
            this.f7633p = threadSummary.a;
        }
        DataFetchDisposition dataFetchDisposition = fetchThreadResult.b;
        this.f7638u = m7331a(threadSummary, messagesCollection, dataFetchDisposition, fetchThreadResult.g);
        m7340a(this.f7638u, "onFetchThreadSucceededWithThreadSummary");
        this.f7632o.a(params, this.f7638u);
        if (this.f7637t.f7604a && this.f7636s != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA && !dataFetchDisposition.n.asBoolean(false) && !dataFetchDisposition.q.asBoolean(false)) {
            m7337a(this.f7637t, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, i);
        } else if (!dataFetchDisposition.m.isLocal()) {
            this.f7632o.b(this.f7637t, this.f7638u);
            if (params2 != null) {
                m7347b(params2);
            }
        } else if (dataFetchDisposition.o.asBoolean(false) && !dataFetchDisposition.q.asBoolean(false)) {
            m7337a(this.f7637t, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, i);
        } else if (messagesCollection.a(this.f7637t.f7607d)) {
            this.f7632o.b(this.f7637t, this.f7638u);
            if (params2 != null) {
                m7347b(params2);
            }
        } else {
            m7337a(this.f7637t, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, i);
        }
    }

    private void m7335a(ThreadSummary threadSummary, Params params, FetchThreadResult fetchThreadResult) {
        if (!Objects.equal(this.f7633p, threadSummary.a)) {
            String str = "Invalid threadKey after thread fetch. mThreadKey=%s, threadSummary.threadKey=%s, loadType=%s, numMessages=%s, %s";
            Object[] objArr = new Object[5];
            objArr[0] = this.f7633p;
            objArr[1] = threadSummary.a;
            objArr[2] = params.f7606c;
            objArr[3] = fetchThreadResult.d != null ? Integer.valueOf(fetchThreadResult.d.g()) : "na";
            objArr[4] = fetchThreadResult.b;
            throw new IllegalStateException(StringFormatUtil.a(str, objArr));
        }
    }

    private void m7338a(Params params, FetchThreadResult fetchThreadResult, Params params2) {
        this.f7638u = m7332a(m7334a(fetchThreadResult.e), fetchThreadResult.b, fetchThreadResult.g);
        this.f7632o.a(params, this.f7638u);
        this.f7632o.b(this.f7637t, this.f7638u);
        if (params2 != null) {
            m7347b(params2);
        }
    }

    public static void m7343a(ThreadViewLoader threadViewLoader, Params params, ServiceException serviceException, Params params2) {
        threadViewLoader.f7632o.c(params, new Error(serviceException, params.f7605b));
        if (params2 != null) {
            threadViewLoader.m7347b(params2);
        }
    }

    private Result m7331a(ThreadSummary threadSummary, MessagesCollection messagesCollection, DataFetchDisposition dataFetchDisposition, List<FetchThreadHandlerChange> list) {
        TracerDetour.a("TVL.createResult", -346212644);
        try {
            Preconditions.checkNotNull(threadSummary);
            Preconditions.checkNotNull(messagesCollection);
            MessagesCollection a = this.f7621d.a(messagesCollection);
            ThreadSummary a2 = this.f7627j.m4229a(threadSummary);
            Result a3 = Result.m7327a(a2, a, MessageDeduper.m6607a(a, ((SendMessageManager) this.f7631n.get()).b(a2.a)), dataFetchDisposition, list);
            return a3;
        } finally {
            TracerDetour.a(1949972111);
        }
    }

    public static void m7341a(ThreadViewLoader threadViewLoader, Params params, OperationResult operationResult) {
        if (threadViewLoader.f7638u != null) {
            threadViewLoader.f7639v = false;
            if (threadViewLoader.f7638u.f7611a != null && threadViewLoader.f7638u.f7613c != null) {
                FetchMoreMessagesResult fetchMoreMessagesResult = (FetchMoreMessagesResult) operationResult.k();
                threadViewLoader.f7638u = Result.m7327a(threadViewLoader.f7638u.f7611a, threadViewLoader.f7623f.a(threadViewLoader.f7638u.f7613c, fetchMoreMessagesResult.c), threadViewLoader.f7638u.f7614d, fetchMoreMessagesResult.b, RegularImmutableList.a);
                threadViewLoader.m7340a(threadViewLoader.f7638u, "onFetchMoreMessagesSucceeded");
                threadViewLoader.f7632o.a(params, threadViewLoader.f7638u);
                threadViewLoader.f7632o.b(threadViewLoader.f7637t, threadViewLoader.f7638u);
            }
        }
    }

    private void m7340a(Result result, String str) {
        if (BLog.b(2)) {
            StringBuilder stringBuilder = new StringBuilder("Updating Result:\n");
            stringBuilder.append("Reason: ").append(str).append('\n');
            stringBuilder.append("DeliveryTimes:\n");
            ImmutableList immutableList = result.f7611a.h;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
                stringBuilder.append("   ").append(threadParticipant.b()).append(":").append(threadParticipant.d).append('\n');
            }
            stringBuilder.append("Messages:\n");
            m7344a(stringBuilder, result, 10);
        }
    }

    private static void m7344a(StringBuilder stringBuilder, Result result, int i) {
        if (result.f7613c == null || (result.f7613c.f() && (result.f7614d == null || result.f7614d.isEmpty()))) {
            stringBuilder.append("    none\n");
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (i3 < i && i2 < result.f7614d.size()) {
            stringBuilder.append("   ").append((Message) result.f7614d.get(i2)).append("(PENDING) \n");
            i3++;
            i2++;
        }
        int i4 = 0;
        int i5 = i3;
        while (i5 < i && i4 < result.f7613c.g()) {
            stringBuilder.append("   ").append(result.f7613c.b(i4)).append("\n");
            i5++;
            i4++;
        }
    }

    private static boolean m7345a(@Nullable Result result) {
        return result != null && result.m7330b();
    }
}

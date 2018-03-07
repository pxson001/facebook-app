package com.facebook.messaging.montage.inboxcomposer;

import android.os.Bundle;
import android.support.annotation.CheckResult;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.ThreadsCacheUpdateRateLimiter;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.MontageMessagesHelper;
import com.facebook.messaging.montage.annotations.MyMontageThreadKey;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: save_active_state */
public class MontageInboxComposerLoader implements FbLoader<Params, MontageInboxComposerData, Throwable> {
    private final DefaultBlueServiceOperationFactory f3301a;
    private final DataCache f3302b;
    private final Executor f3303c;
    private final AbstractFbErrorReporter f3304d;
    private final MontageMessagesHelper f3305e;
    private final Provider<ThreadKey> f3306f;
    private final ThreadsCacheUpdateRateLimiter f3307g;
    public FutureAndCallbackHolder<OperationResult> f3308h;
    public Params f3309i;
    public Callback<Params, MontageInboxComposerData, Throwable> f3310j;

    /* compiled from: save_active_state */
    public class Params {
        public final boolean f3299a;
        public final boolean f3300b;

        public Params(boolean z, boolean z2) {
            this.f3299a = z;
            this.f3300b = z2;
        }

        @CheckResult
        final Params m3210a(Params params) {
            boolean z = false;
            boolean z2 = this.f3299a || params.f3299a;
            if (this.f3300b || params.f3300b) {
                z = true;
            }
            if (this.f3299a == z2 && this.f3300b == z) {
                return this;
            }
            return new Params(z2, z);
        }
    }

    public static MontageInboxComposerLoader m3215b(InjectorLike injectorLike) {
        return new MontageInboxComposerLoader(DefaultBlueServiceOperationFactory.b(injectorLike), DataCache.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), MontageMessagesHelper.b(injectorLike), IdBasedProvider.a(injectorLike, 7975), ThreadsCacheUpdateRateLimiter.a(injectorLike));
    }

    @Inject
    MontageInboxComposerLoader(BlueServiceOperationFactory blueServiceOperationFactory, DataCache dataCache, Executor executor, FbErrorReporter fbErrorReporter, MontageMessagesHelper montageMessagesHelper, @MyMontageThreadKey Provider<ThreadKey> provider, ThreadsCacheUpdateRateLimiter threadsCacheUpdateRateLimiter) {
        this.f3301a = blueServiceOperationFactory;
        this.f3302b = dataCache;
        this.f3303c = executor;
        this.f3304d = fbErrorReporter;
        this.f3305e = montageMessagesHelper;
        this.f3306f = provider;
        this.f3307g = threadsCacheUpdateRateLimiter;
    }

    public final void m3216a(Callback<Params, MontageInboxComposerData, Throwable> callback) {
        this.f3310j = callback;
    }

    public final void m3217a(Params params) {
        Preconditions.checkNotNull(params);
        ThreadKey threadKey = (ThreadKey) this.f3306f.get();
        if (threadKey == null) {
            this.f3310j.b(params, null);
            return;
        }
        MontageInboxComposerData a = m3211a(threadKey);
        if (a != null) {
            this.f3310j.a(params, a);
        }
        if (this.f3308h != null) {
            this.f3309i = this.f3309i.m3210a(params);
        } else if (a == null) {
            m3213a(threadKey, params, DataFreshnessParam.STALE_DATA_OKAY);
        } else if (params.f3299a) {
            m3213a(threadKey, params, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
        } else if (this.f3307g.a(threadKey)) {
            m3213a(threadKey, params, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE);
        } else {
            this.f3310j.b(params, a);
        }
    }

    @Nullable
    private MontageInboxComposerData m3211a(ThreadKey threadKey) {
        ThreadSummary a = this.f3302b.a(threadKey);
        if (a != null) {
            MessagesCollection b = this.f3302b.b(threadKey);
            if (b != null) {
                return m3212a(a, b);
            }
        }
        return null;
    }

    private void m3213a(ThreadKey threadKey, final Params params, DataFreshnessParam dataFreshnessParam) {
        if (this.f3308h == null) {
            FetchThreadParamsBuilder fetchThreadParamsBuilder = new FetchThreadParamsBuilder();
            fetchThreadParamsBuilder.a = ThreadCriteria.a(threadKey);
            fetchThreadParamsBuilder = fetchThreadParamsBuilder;
            fetchThreadParamsBuilder.b = dataFreshnessParam;
            fetchThreadParamsBuilder = fetchThreadParamsBuilder;
            fetchThreadParamsBuilder.f = 1;
            fetchThreadParamsBuilder = fetchThreadParamsBuilder;
            fetchThreadParamsBuilder.h = true;
            FetchThreadParams i = fetchThreadParamsBuilder.i();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchThreadParams", i);
            OperationFuture b = BlueServiceOperationFactoryDetour.a(this.f3301a, "fetch_thread", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(MontageInboxComposerLoader.class), -168903219).b();
            this.f3309i = params;
            this.f3310j.a(params, b);
            C05301 c05301 = new OperationResultFutureCallback(this) {
                final /* synthetic */ MontageInboxComposerLoader f3298b;

                public final void m3209a(Object obj) {
                    OperationResult operationResult = (OperationResult) obj;
                    this.f3298b.f3308h = null;
                    FetchThreadResult fetchThreadResult = (FetchThreadResult) operationResult.k();
                    if (fetchThreadResult == null) {
                        this.f3298b.f3310j.c(params, ServiceException.a(new AssertionError()));
                    }
                    MontageInboxComposerLoader.m3214a(this.f3298b, params, fetchThreadResult);
                }

                protected final void m3208a(ServiceException serviceException) {
                    this.f3298b.f3308h = null;
                    this.f3298b.f3310j.c(params, serviceException);
                }
            };
            this.f3308h = FutureAndCallbackHolder.a(b, c05301);
            Futures.a(b, c05301, this.f3303c);
        }
    }

    public static void m3214a(MontageInboxComposerLoader montageInboxComposerLoader, Params params, FetchThreadResult fetchThreadResult) {
        if (fetchThreadResult.c == null) {
            montageInboxComposerLoader.f3304d.a("MontageInboxComposerLoader", "Successful fetch w/o ThreadSummary");
            montageInboxComposerLoader.f3310j.c(params, ServiceException.a(new AssertionError()));
            return;
        }
        ThreadSummary threadSummary = fetchThreadResult.c;
        MessagesCollection messagesCollection = fetchThreadResult.d;
        if (messagesCollection == null) {
            montageInboxComposerLoader.f3304d.a("MontageInboxComposerLoader", "Successful fetch w/o MessagesCollection");
            montageInboxComposerLoader.f3310j.c(params, ServiceException.a(new AssertionError()));
            return;
        }
        MontageInboxComposerData a = montageInboxComposerLoader.m3212a(threadSummary, messagesCollection);
        montageInboxComposerLoader.f3310j.a(params, a);
        DataFetchDisposition dataFetchDisposition = fetchThreadResult.b;
        if (montageInboxComposerLoader.f3309i.f3299a && !dataFetchDisposition.n.asBoolean(false) && !dataFetchDisposition.q.asBoolean(false)) {
            montageInboxComposerLoader.m3213a(threadSummary.a, montageInboxComposerLoader.f3309i, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
        } else if (!dataFetchDisposition.m.isLocal()) {
            montageInboxComposerLoader.f3310j.b(montageInboxComposerLoader.f3309i, a);
        } else if (dataFetchDisposition.o.asBoolean(false) && !dataFetchDisposition.q.asBoolean(false)) {
            montageInboxComposerLoader.m3213a(threadSummary.a, montageInboxComposerLoader.f3309i, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE);
        } else if (messagesCollection.a(1)) {
            montageInboxComposerLoader.f3310j.b(montageInboxComposerLoader.f3309i, a);
        } else {
            montageInboxComposerLoader.m3213a(threadSummary.a, montageInboxComposerLoader.f3309i, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE);
        }
    }

    private MontageInboxComposerData m3212a(ThreadSummary threadSummary, MessagesCollection messagesCollection) {
        if (!this.f3305e.b(messagesCollection)) {
            return new MontageInboxComposerData(threadSummary.a, null, null);
        }
        Message b = messagesCollection.b(0);
        ImmutableList b2 = this.f3305e.b(b, threadSummary);
        Builder builder = ImmutableList.builder();
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            builder.c(((ThreadParticipant) b2.get(i)).b());
        }
        return new MontageInboxComposerData(threadSummary.a, builder.b(), b);
    }
}

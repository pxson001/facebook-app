package com.facebook.orca.threadview;

import android.os.Bundle;
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
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.OperationResult.NoResultDataParcelableException;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.analytics.search.OmniPickerAnalyticsLogger;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.FetchThreadKeyByParticipantsParams;
import com.facebook.messaging.service.model.FetchThreadKeyByParticipantsResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: message_event_guests */
public class ThreadKeyByParticipantsLoader implements FbLoader<Params, Result, Error> {
    public final DefaultBlueServiceOperationFactory f7418a;
    private final AbstractFbErrorReporter f7419b;
    public FutureAndCallbackHolder<OperationResult> f7420c;
    public Callback<Params, Result, Error> f7421d;
    public UserKey f7422e;
    public Set<UserKey> f7423f;
    public Executor f7424g;
    private Lazy<OmniPickerAnalyticsLogger> f7425h;

    /* compiled from: message_event_guests */
    public class Error {
        public final ServiceException f7416a;

        public Error(ServiceException serviceException) {
            this.f7416a = serviceException;
        }
    }

    /* compiled from: message_event_guests */
    public class Params {
    }

    /* compiled from: message_event_guests */
    public class Result {
        public final ThreadKey f7417a;

        private Result(ThreadKey threadKey) {
            this.f7417a = threadKey;
        }

        public static Result m7061a(ThreadKey threadKey) {
            return new Result(threadKey);
        }
    }

    private static ThreadKeyByParticipantsLoader m7064b(InjectorLike injectorLike) {
        return new ThreadKeyByParticipantsLoader(DefaultBlueServiceOperationFactory.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 7517));
    }

    public final void m7066a(Object obj) {
        final Params params = (Params) obj;
        Preconditions.checkNotNull(params);
        if (this.f7423f != null && !this.f7423f.isEmpty()) {
            if (this.f7420c == null) {
                Preconditions.checkNotNull(this.f7421d);
                Bundle bundle = new Bundle();
                bundle.putParcelable("fetch_thread_with_participants_key", new FetchThreadKeyByParticipantsParams(this.f7422e, this.f7423f, false));
                OperationFuture b = BlueServiceOperationFactoryDetour.a(this.f7418a, "fetch_thread_by_participants", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(ThreadKeyByParticipantsLoader.class), 461117773).b();
                this.f7421d.a(params, b);
                C11101 c11101 = new OperationResultFutureCallback(this) {
                    final /* synthetic */ ThreadKeyByParticipantsLoader f7415b;

                    public final void m7060a(Object obj) {
                        OperationResult operationResult = (OperationResult) obj;
                        this.f7415b.f7420c = null;
                        ThreadKeyByParticipantsLoader.m7062a(this.f7415b, params, operationResult);
                    }

                    protected final void m7059a(ServiceException serviceException) {
                        this.f7415b.f7420c = null;
                        ThreadKeyByParticipantsLoader.m7063a(this.f7415b, params, serviceException);
                    }
                };
                this.f7420c = FutureAndCallbackHolder.a(b, c11101);
                Futures.a(b, c11101, this.f7424g);
            }
        }
    }

    @Inject
    public ThreadKeyByParticipantsLoader(BlueServiceOperationFactory blueServiceOperationFactory, Executor executor, FbErrorReporter fbErrorReporter, Lazy<OmniPickerAnalyticsLogger> lazy) {
        this.f7418a = blueServiceOperationFactory;
        this.f7424g = executor;
        this.f7419b = fbErrorReporter;
        this.f7425h = lazy;
    }

    public final void m7065a(Callback<Params, Result, Error> callback) {
        this.f7421d = callback;
    }

    public static void m7062a(ThreadKeyByParticipantsLoader threadKeyByParticipantsLoader, Params params, OperationResult operationResult) {
        if (threadKeyByParticipantsLoader.f7421d == null) {
            threadKeyByParticipantsLoader.f7419b.a("ThreadViewByParticipantsLoader", "Load succeeded but callback is null.");
            return;
        }
        try {
            ThreadKey threadKey = ((FetchThreadKeyByParticipantsResult) operationResult.h()).a;
            threadKeyByParticipantsLoader.f7421d.a(params, Result.m7061a(threadKey));
            ((OmniPickerAnalyticsLogger) threadKeyByParticipantsLoader.f7425h.get()).a(threadKey != null, threadKeyByParticipantsLoader.f7423f.size() - 1);
        } catch (NoResultDataParcelableException e) {
            threadKeyByParticipantsLoader.f7419b.a("ThreadViewByParticipantsLoader", "Error fetching thread key.");
            m7063a(threadKeyByParticipantsLoader, params, ServiceException.a(e));
        }
    }

    public static void m7063a(ThreadKeyByParticipantsLoader threadKeyByParticipantsLoader, Params params, ServiceException serviceException) {
        if (threadKeyByParticipantsLoader.f7421d == null) {
            threadKeyByParticipantsLoader.f7419b.a("ThreadViewByParticipantsLoader", "Load resulted in error but callback is null.");
            return;
        }
        threadKeyByParticipantsLoader.f7421d.c(params, new Error(serviceException));
    }
}

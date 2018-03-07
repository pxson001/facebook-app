package com.facebook.messaging.payment.prefs.transactions;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionQueryType;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsResult;
import com.facebook.messaging.payment.service.model.transactions.FetchMoreTransactionsResult;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListResult;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

/* compiled from: frozen_video */
public class MessengerPayHistoryLoader implements FbLoader<Params, MessengerPayHistoryLoaderResult, Error> {
    private static final Class<?> f14362a = MessengerPayHistoryLoader.class;
    public final PaymentProtocolUtil f14363b;
    public final AnalyticsLogger f14364c;
    public final Clock f14365d;
    public final Executor f14366e;
    public Callback<Params, MessengerPayHistoryLoaderResult, Error> f14367f;
    public FutureAndCallbackHolder<? extends Object> f14368g;
    public FutureAndCallbackHolder<? extends Object> f14369h;
    public MessengerPayHistoryLoaderResult f14370i;
    public boolean f14371j = false;

    /* compiled from: frozen_video */
    public class Error {
        public final ServiceException f14358a;

        public Error(ServiceException serviceException) {
            this.f14358a = serviceException;
        }

        public String toString() {
            return this.f14358a.toString();
        }
    }

    /* compiled from: frozen_video */
    public enum LoadType {
        LIST,
        MORE
    }

    @Immutable
    /* compiled from: frozen_video */
    public class Params {
        @Nullable
        public final PaymentTransactionQueryType f14359a;
        @Nullable
        public final QueryType f14360b;
        public final LoadType f14361c;

        public Params(@Nullable PaymentTransactionQueryType paymentTransactionQueryType, @Nullable QueryType queryType, LoadType loadType) {
            this.f14359a = paymentTransactionQueryType;
            this.f14360b = queryType;
            this.f14361c = loadType;
        }

        public static Params m14761a(QueryType queryType) {
            return new Params(null, queryType, LoadType.LIST);
        }

        public String toString() {
            return Objects.toStringHelper(this).add("paymentTransactionQueryType", this.f14359a).add("paymentRequestsQueryType", this.f14360b).add("loadType", this.f14361c).toString();
        }
    }

    public static MessengerPayHistoryLoader m14764b(InjectorLike injectorLike) {
        return new MessengerPayHistoryLoader(PaymentProtocolUtil.m14937a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessengerPayHistoryLoader(PaymentProtocolUtil paymentProtocolUtil, AnalyticsLogger analyticsLogger, Clock clock, Executor executor) {
        this.f14363b = paymentProtocolUtil;
        this.f14364c = analyticsLogger;
        this.f14365d = clock;
        this.f14366e = executor;
    }

    public final void m14768a(Callback<Params, MessengerPayHistoryLoaderResult, Error> callback) {
        this.f14367f = callback;
    }

    public final void m14769a(final Params params) {
        if (params == null) {
            throw new IllegalArgumentException("startLoad(): null Params received");
        }
        switch (params.f14361c) {
            case LIST:
                if (this.f14370i != null) {
                    this.f14371j = true;
                    return;
                } else {
                    m14765b(params);
                    return;
                }
            case MORE:
                if (this.f14370i != null && !this.f14370i.f14374c) {
                    Preconditions.checkArgument(params.f14359a != null);
                    if (this.f14368g == null && this.f14369h == null) {
                        ListenableFuture a = this.f14363b.m14950a(params.f14359a, Long.parseLong(((PaymentTransaction) this.f14370i.m14772a().get(this.f14370i.m14772a().size() - 1)).f13233f));
                        this.f14367f.a(params, a);
                        final long a2 = this.f14365d.a();
                        m14763a(this, params, "p2p_history_get_more_request", a2);
                        C16343 c16343 = new ResultFutureCallback<FetchMoreTransactionsResult>(this) {
                            final /* synthetic */ MessengerPayHistoryLoader f14356c;

                            public final void m14760a(Object obj) {
                                FetchMoreTransactionsResult fetchMoreTransactionsResult = (FetchMoreTransactionsResult) obj;
                                this.f14356c.f14369h = null;
                                MessengerPayHistoryLoader.m14763a(this.f14356c, params, "p2p_history_get_more_success", a2);
                                MessengerPayHistoryLoader messengerPayHistoryLoader = this.f14356c;
                                Params params = params;
                                if (messengerPayHistoryLoader.f14370i != null) {
                                    Builder builder = new Builder();
                                    builder.b(messengerPayHistoryLoader.f14370i.m14772a());
                                    builder.b(fetchMoreTransactionsResult.f14740a);
                                    messengerPayHistoryLoader.f14370i = MessengerPayHistoryLoaderResult.m14771a(builder.b(), fetchMoreTransactionsResult.f14741b);
                                    messengerPayHistoryLoader.f14367f.a(params, messengerPayHistoryLoader.f14370i);
                                    messengerPayHistoryLoader.f14367f.b(params, messengerPayHistoryLoader.f14370i);
                                }
                            }

                            protected final void m14759a(ServiceException serviceException) {
                                this.f14356c.f14369h = null;
                                MessengerPayHistoryLoader.m14763a(this.f14356c, params, "p2p_history_get_more_fail", a2);
                                MessengerPayHistoryLoader messengerPayHistoryLoader = this.f14356c;
                                messengerPayHistoryLoader.f14367f.c(params, new Error(serviceException));
                            }
                        };
                        this.f14369h = FutureAndCallbackHolder.a(a, c16343);
                        Futures.a(a, c16343, this.f14366e);
                    }
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Invalid LoadType found %s", params.f14361c));
        }
    }

    private void m14765b(final Params params) {
        if (this.f14369h != null) {
            this.f14369h.a(false);
            this.f14369h = null;
        }
        if (this.f14368g == null) {
            if (params.f14359a != null) {
                ListenableFuture a = this.f14363b.m14949a(params.f14359a, 50);
                this.f14367f.a(params, a);
                final long a2 = this.f14365d.a();
                if (params.f14359a != null) {
                    this.f14364c.a(P2pPaymentsLogEvent.d("p2p_history_get_request", "p2p_settings").e(params.f14359a.toString()).f(String.valueOf(a2)).a);
                }
                C16321 c16321 = new ResultFutureCallback<FetchTransactionListResult>(this) {
                    final /* synthetic */ MessengerPayHistoryLoader f14350c;

                    protected final void m14756a(Object obj) {
                        FetchTransactionListResult fetchTransactionListResult = (FetchTransactionListResult) obj;
                        this.f14350c.f14368g = null;
                        if (params.f14359a != null) {
                            this.f14350c.f14364c.a(P2pPaymentsLogEvent.d("p2p_history_get_success", "p2p_settings").e(params.f14359a.toString()).f(String.valueOf(a2)).a);
                        }
                        this.f14350c.f14370i = MessengerPayHistoryLoaderResult.m14771a(fetchTransactionListResult.f14748a, fetchTransactionListResult.f14749b);
                        MessengerPayHistoryLoader.m14767e(this.f14350c, params);
                    }

                    protected final void m14755a(ServiceException serviceException) {
                        this.f14350c.f14368g = null;
                        if (params.f14359a != null) {
                            this.f14350c.f14364c.a(P2pPaymentsLogEvent.d("p2p_history_get_fail", "p2p_settings").e(params.f14359a.toString()).f(String.valueOf(a2)).a);
                        }
                        MessengerPayHistoryLoader.m14762a(this.f14350c, params, serviceException);
                    }
                };
                this.f14368g = FutureAndCallbackHolder.a(a, c16321);
                Futures.a(a, c16321, this.f14366e);
            } else if (params.f14360b != null) {
                m14766d(params);
            }
        }
    }

    private void m14766d(final Params params) {
        ListenableFuture a = this.f14363b.m14951a(params.f14360b);
        this.f14367f.a(params, a);
        final long a2 = this.f14365d.a();
        if (params.f14360b != null) {
            this.f14364c.a(P2pPaymentsLogEvent.d("p2p_history_get_request", "p2p_settings").e(params.f14360b.toString()).f(String.valueOf(a2)).a);
        }
        C16332 c16332 = new ResultFutureCallback<FetchPaymentRequestsResult>(this) {
            final /* synthetic */ MessengerPayHistoryLoader f14353c;

            protected final void m14758a(Object obj) {
                FetchPaymentRequestsResult fetchPaymentRequestsResult = (FetchPaymentRequestsResult) obj;
                this.f14353c.f14368g = null;
                if (params.f14360b != null) {
                    this.f14353c.f14364c.a(P2pPaymentsLogEvent.d("p2p_history_get_success", "p2p_settings").e(params.f14360b.toString()).f(String.valueOf(a2)).a);
                }
                this.f14353c.f14370i = new MessengerPayHistoryLoaderResult(null, fetchPaymentRequestsResult.m15195a(), true);
                MessengerPayHistoryLoader.m14767e(this.f14353c, params);
            }

            protected final void m14757a(ServiceException serviceException) {
                this.f14353c.f14368g = null;
                if (params.f14360b != null) {
                    this.f14353c.f14364c.a(P2pPaymentsLogEvent.d("p2p_history_get_fail", "p2p_settings").e(params.f14360b.toString()).f(String.valueOf(a2)).a);
                }
                MessengerPayHistoryLoader.m14762a(this.f14353c, params, serviceException);
            }
        };
        this.f14368g = FutureAndCallbackHolder.a(a, c16332);
        Futures.a(a, c16332, this.f14366e);
    }

    public static void m14767e(MessengerPayHistoryLoader messengerPayHistoryLoader, Params params) {
        messengerPayHistoryLoader.f14367f.a(params, messengerPayHistoryLoader.f14370i);
        messengerPayHistoryLoader.f14367f.b(params, messengerPayHistoryLoader.f14370i);
    }

    public static void m14762a(MessengerPayHistoryLoader messengerPayHistoryLoader, Params params, ServiceException serviceException) {
        messengerPayHistoryLoader.f14367f.c(params, new Error(serviceException));
    }

    public static void m14763a(MessengerPayHistoryLoader messengerPayHistoryLoader, Params params, String str, long j) {
        if (messengerPayHistoryLoader.f14370i != null) {
            PaymentTransaction paymentTransaction = (PaymentTransaction) messengerPayHistoryLoader.f14370i.m14772a().get(messengerPayHistoryLoader.f14370i.m14772a().size() - 1);
            if (params.f14359a != null) {
                AnalyticsLogger analyticsLogger = messengerPayHistoryLoader.f14364c;
                P2pPaymentsLogEvent.Builder f = P2pPaymentsLogEvent.d(str, "p2p_settings").e(params.f14359a.toString()).f(String.valueOf(j));
                f.a.b("last_transaction_id", paymentTransaction.f13229b);
                analyticsLogger.a(f.a);
            }
        }
    }
}

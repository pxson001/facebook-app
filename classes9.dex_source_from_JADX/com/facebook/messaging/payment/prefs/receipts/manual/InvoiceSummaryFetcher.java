package com.facebook.messaging.payment.prefs.receipts.manual;

import android.net.Uri;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQuery.TransactionInvoiceQueryString;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryModels.TransactionInvoiceQueryModel;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryModels.TransactionItemProductFieldsModel.EdgesModel;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel.Builder;
import com.facebook.messaging.payment.prefs.receipts.manual.model.TransactionInvoiceConverter;
import com.facebook.messaging.payment.ui.model.PlatformCommerceAmountViewParamsBuilder;
import com.facebook.payments.ui.SingleItemInfoViewParamsBuilder;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: getPreferenceScreen */
public class InvoiceSummaryFetcher {
    private final GraphQLQueryExecutor f14157a;
    public final TasksManager f14158b;
    public final TransactionInvoiceConverter f14159c;

    /* compiled from: getPreferenceScreen */
    class C16101 implements Function<TransactionInvoiceQueryModel, InvoicesSummaryModel> {
        final /* synthetic */ InvoiceSummaryFetcher f14156a;

        C16101(InvoiceSummaryFetcher invoiceSummaryFetcher) {
            this.f14156a = invoiceSummaryFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            InvoicesSummaryModel invoicesSummaryModel;
            TransactionInvoiceQueryModel transactionInvoiceQueryModel = (TransactionInvoiceQueryModel) obj;
            TransactionInvoiceConverter transactionInvoiceConverter = this.f14156a.f14159c;
            if (transactionInvoiceQueryModel == null) {
                invoicesSummaryModel = null;
            } else {
                Builder builder = new Builder();
                if (!(transactionInvoiceQueryModel == null || transactionInvoiceQueryModel.m6194j() == null || transactionInvoiceQueryModel.m6194j().m6230a().isEmpty())) {
                    EdgesModel edgesModel = (EdgesModel) transactionInvoiceQueryModel.m6194j().m6230a().get(0);
                    SingleItemInfoViewParamsBuilder singleItemInfoViewParamsBuilder = new SingleItemInfoViewParamsBuilder();
                    singleItemInfoViewParamsBuilder.c = edgesModel.m6223a();
                    if (!(edgesModel.m6225b() == null || edgesModel.m6225b().m6216a() == null || StringUtil.a(edgesModel.m6225b().m6216a().m6212a()))) {
                        singleItemInfoViewParamsBuilder.a = edgesModel.m6225b().m6216a().m6212a();
                        singleItemInfoViewParamsBuilder.b = (float) transactionInvoiceConverter.f14269a.getDimensionPixelSize(2131428534);
                    }
                    builder.f14232b = Optional.fromNullable(singleItemInfoViewParamsBuilder.f());
                    builder.f14241k = Optional.fromNullable(Integer.valueOf(edgesModel.m6226c()));
                }
                if (transactionInvoiceQueryModel != null) {
                    PlatformCommerceAmountViewParamsBuilder platformCommerceAmountViewParamsBuilder = new PlatformCommerceAmountViewParamsBuilder();
                    platformCommerceAmountViewParamsBuilder.f15158a = CommerceCurrencyUtil.a(transactionInvoiceQueryModel.m6190b(), transactionInvoiceQueryModel.m6197m());
                    platformCommerceAmountViewParamsBuilder.f15161d = CommerceCurrencyUtil.a(transactionInvoiceQueryModel.m6190b(), transactionInvoiceQueryModel.m6198n());
                    if (!(transactionInvoiceQueryModel.lN_() == null || transactionInvoiceQueryModel.lN_().m6253b() == null)) {
                        platformCommerceAmountViewParamsBuilder.f15160c = CommerceCurrencyUtil.a(transactionInvoiceQueryModel.m6190b(), transactionInvoiceQueryModel.lN_().m6253b().m6245a());
                    }
                    builder.f14233c = Optional.fromNullable(platformCommerceAmountViewParamsBuilder.m15511e());
                    builder.f14245o = Optional.fromNullable(transactionInvoiceQueryModel.m6190b());
                    builder.f14246p = Optional.fromNullable(transactionInvoiceConverter.f14270b.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL, transactionInvoiceQueryModel.m6198n(), transactionInvoiceQueryModel.m6190b()));
                }
                builder.f14231a = Optional.fromNullable(transactionInvoiceQueryModel.m6192d());
                builder.f14238h = Optional.fromNullable(transactionInvoiceQueryModel.m6196l());
                builder.f14244n = Optional.fromNullable(transactionInvoiceQueryModel.m6195k());
                if (!(transactionInvoiceQueryModel.lO_() == null || transactionInvoiceQueryModel.lO_().m6174a() == null || StringUtil.a(transactionInvoiceQueryModel.lO_().m6174a().m6170a()))) {
                    builder.f14239i = Optional.fromNullable(Uri.parse(transactionInvoiceQueryModel.lO_().m6174a().m6170a()));
                }
                if (transactionInvoiceQueryModel.m6193g() != null) {
                    builder.m14687d(transactionInvoiceQueryModel.m6193g().m6239c());
                    builder.m14688f(transactionInvoiceQueryModel.m6193g().m6238b());
                }
                if (!(transactionInvoiceQueryModel.lN_() == null || StringUtil.a(transactionInvoiceQueryModel.lN_().m6252a()))) {
                    builder.f14235e = Optional.fromNullable(transactionInvoiceQueryModel.lN_().m6252a());
                }
                if (!StringUtil.a(transactionInvoiceQueryModel.m6191c())) {
                    builder.f14234d = Optional.fromNullable(transactionInvoiceQueryModel.m6191c());
                }
                if (!StringUtil.a(transactionInvoiceQueryModel.lM_())) {
                    builder.f14247q = Optional.fromNullable(transactionInvoiceQueryModel.lM_());
                }
                invoicesSummaryModel = builder.m14686a();
            }
            return invoicesSummaryModel;
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj;
        }
    }

    public static InvoiceSummaryFetcher m14628b(InjectorLike injectorLike) {
        return new InvoiceSummaryFetcher(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), new TransactionInvoiceConverter(ResourcesMethodAutoProvider.a(injectorLike), PaymentCurrencyUtil.m13192a(injectorLike)));
    }

    @Inject
    public InvoiceSummaryFetcher(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, TransactionInvoiceConverter transactionInvoiceConverter) {
        this.f14157a = graphQLQueryExecutor;
        this.f14158b = tasksManager;
        this.f14159c = transactionInvoiceConverter;
    }

    public final void m14629a(String str, AbstractDisposableFutureCallback<InvoicesSummaryModel> abstractDisposableFutureCallback) {
        GraphQLRequest a = GraphQLRequest.a((TransactionInvoiceQueryString) new TransactionInvoiceQueryString().a("transaction_id", str));
        a.a(RequestPriority.INTERACTIVE);
        this.f14158b.a("fetch_invoice_key", Futures.a(GraphQLQueryExecutor.a(this.f14157a.a(a)), new C16101(this), DirectExecutor.INSTANCE), abstractDisposableFutureCallback);
    }
}

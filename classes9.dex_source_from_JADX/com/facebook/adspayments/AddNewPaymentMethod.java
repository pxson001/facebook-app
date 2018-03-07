package com.facebook.adspayments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.analytics.PaymentsLogEvent;
import com.facebook.adspayments.analytics.PaymentsLogger;
import com.facebook.adspayments.graphql.FetchPaymentOptionsGraphQL.FetchPaymentOptionsQueryString;
import com.facebook.adspayments.graphql.FetchPaymentOptionsGraphQLModels.FetchPaymentOptionsQueryModel;
import com.facebook.common.locale.Country;
import com.facebook.graphql.enums.GraphQLMobilePaymentOption;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;

/* compiled from: Unexpected execution failure */
public class AddNewPaymentMethod {
    public static final ImmutableList<GraphQLMobilePaymentOption> f23407a = ImmutableList.of(GraphQLMobilePaymentOption.CREDIT_CARD, GraphQLMobilePaymentOption.PAYPAL);
    private final FragmentManager f23408b;
    private GraphQLQueryExecutor f23409c;
    public final PaymentsLogger f23410d;
    private ListenableFuture<GraphQLResult<FetchPaymentOptionsQueryModel>> f23411e;

    private void m25335a(PaymentsFlowContext paymentsFlowContext, Country country, ImmutableList<GraphQLMobilePaymentOption> immutableList, String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("payments_flow_context_key", paymentsFlowContext);
        bundle.putParcelable("billing_iso_country", country);
        bundle.putSerializable("payment_options", immutableList);
        bundle.putInt("request_code", i);
        SelectPaymentMethodDialogFragment selectPaymentMethodDialogFragment = new SelectPaymentMethodDialogFragment();
        selectPaymentMethodDialogFragment.g(bundle);
        selectPaymentMethodDialogFragment.a(this.f23408b, str);
    }

    @Inject
    public AddNewPaymentMethod(@Assisted FragmentManager fragmentManager, GraphQLQueryExecutor graphQLQueryExecutor, PaymentsLogger paymentsLogger) {
        this.f23408b = fragmentManager;
        this.f23409c = graphQLQueryExecutor;
        this.f23410d = paymentsLogger;
    }

    public final void m25336a(PaymentsFlowContext paymentsFlowContext, Country country, String str, int i) {
        final DialogFragment a = ProgressDialogFragment.a(2131230739, true, false);
        a.a(this.f23408b, "show_payment_method_tag");
        if (this.f23411e == null || this.f23411e.isDone()) {
            this.f23410d.m3880a("payments_select_new_payment_method_initiated", paymentsFlowContext);
            this.f23411e = this.f23409c.a(GraphQLRequest.a(new FetchPaymentOptionsQueryString()).a(GraphQLCachePolicy.c));
            final PaymentsFlowContext paymentsFlowContext2 = paymentsFlowContext;
            final Country country2 = country;
            final String str2 = str;
            final int i2 = i;
            Futures.a(this.f23411e, new FutureCallback<GraphQLResult<FetchPaymentOptionsQueryModel>>(this) {
                final /* synthetic */ AddNewPaymentMethod f23406f;

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    a.a();
                    this.f23406f.f23410d.m3880a("payments_fetch_payment_option_successful", paymentsFlowContext2);
                    if (graphQLResult == null || graphQLResult.e == null) {
                        this.f23406f.m25335a(paymentsFlowContext2, country2, AddNewPaymentMethod.f23407a, str2, i2);
                        return;
                    }
                    this.f23406f.m25335a(paymentsFlowContext2, country2, ((FetchPaymentOptionsQueryModel) graphQLResult.e).m25679a().m25677a(), str2, i2);
                }

                public void onFailure(Throwable th) {
                    a.a();
                    this.f23406f.f23410d.m3877a(th, paymentsFlowContext2);
                    this.f23406f.f23410d.m3879a((PaymentsLogEvent) new PaymentsLogEvent("payments_fetch_payment_option_failed", paymentsFlowContext2).m3866a(th));
                    this.f23406f.m25335a(paymentsFlowContext2, country2, AddNewPaymentMethod.f23407a, str2, i2);
                }
            }, MoreExecutors.a());
        }
    }
}

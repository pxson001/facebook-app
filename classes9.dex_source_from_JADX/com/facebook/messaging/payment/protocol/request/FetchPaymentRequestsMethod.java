package com.facebook.messaging.payment.protocol.request;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQL.FetchIncomingPaymentRequestsQueryString;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQL.FetchOutgoingPaymentRequestsQueryString;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchIncomingPaymentRequestsQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.FetchOutgoingPaymentRequestsQueryModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsResult;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: folder='inbox' AND not archived */
public class FetchPaymentRequestsMethod extends AbstractPersistedGraphQlApiMethod<FetchPaymentRequestsParams, FetchPaymentRequestsResult> {
    public static FetchPaymentRequestsMethod m15077a(InjectorLike injectorLike) {
        return new FetchPaymentRequestsMethod(GraphQLProtocolHelper.a(injectorLike));
    }

    public final Object m15078a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        ImmutableList a;
        FetchPaymentRequestsParams fetchPaymentRequestsParams = (FetchPaymentRequestsParams) obj;
        apiResponse.i();
        if (fetchPaymentRequestsParams.f14719b == QueryType.INCOMING) {
            a = ((FetchIncomingPaymentRequestsQueryModel) jsonParser.a(FetchIncomingPaymentRequestsQueryModel.class)).m13607a().m13603a();
        } else {
            a = ((FetchOutgoingPaymentRequestsQueryModel) jsonParser.a(FetchOutgoingPaymentRequestsQueryModel.class)).m13627a().m13623a();
        }
        ArrayList arrayList = new ArrayList(a.size());
        int size = a.size();
        for (int i = 0; i < size; i++) {
            arrayList.add((PaymentRequestModel) a.get(i));
        }
        return new FetchPaymentRequestsResult(arrayList);
    }

    public final GraphQlQueryString m15080f(Object obj) {
        return ((FetchPaymentRequestsParams) obj).f14719b == QueryType.INCOMING ? new FetchIncomingPaymentRequestsQueryString() : new FetchOutgoingPaymentRequestsQueryString();
    }

    @Inject
    public FetchPaymentRequestsMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final int m15079b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}

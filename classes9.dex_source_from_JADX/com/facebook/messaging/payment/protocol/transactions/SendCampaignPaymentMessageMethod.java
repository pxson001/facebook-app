package com.facebook.messaging.payment.protocol.transactions;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.transactions.SendCampaignPaymentMessageParams;
import com.facebook.messaging.payment.service.model.transactions.SendCampaignPaymentMessageResult;
import com.facebook.user.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: fling */
public class SendCampaignPaymentMessageMethod implements ApiMethod<SendCampaignPaymentMessageParams, SendCampaignPaymentMessageResult> {
    private final Provider<User> f14613a;

    public static SendCampaignPaymentMessageMethod m15143a(InjectorLike injectorLike) {
        return new SendCampaignPaymentMessageMethod(IdBasedProvider.a(injectorLike, 3596));
    }

    public final ApiRequest m15145a(Object obj) {
        SendCampaignPaymentMessageParams sendCampaignPaymentMessageParams = (SendCampaignPaymentMessageParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("receiver_ids", m15144a(sendCampaignPaymentMessageParams.f14754b)));
        arrayList.add(new BasicNameValuePair("campaign_name", sendCampaignPaymentMessageParams.f14755c));
        arrayList.add(new BasicNameValuePair("external_request_id", sendCampaignPaymentMessageParams.f14756d));
        if (!StringUtil.a(sendCampaignPaymentMessageParams.f14757e)) {
            arrayList.add(new BasicNameValuePair("message", sendCampaignPaymentMessageParams.f14757e));
        }
        arrayList.add(new BasicNameValuePair("format", "json"));
        if (this.f14613a.get() == null) {
            throw new IllegalStateException("null ViewerContextUser found sending payments via campaign flow.");
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "p2p_campaign_transfers";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%s/%s", ((User) this.f14613a.get()).a, "p2p_campaign_transfers");
        newBuilder = apiRequestBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public SendCampaignPaymentMessageMethod(Provider<User> provider) {
        this.f14613a = provider;
    }

    public final Object m15146a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        if (c.k() != JsonNodeType.ARRAY) {
            throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("Invalid response type %s received from server", c.k()));
        }
        Builder builder = new Builder();
        Iterator it = c.iterator();
        while (it.hasNext()) {
            c = (JsonNode) it.next();
            if (c.b("id") == null) {
                throw new IllegalArgumentException("Invalid response received from server - 'id' not found.");
            }
            builder.c(c.b("id").B());
        }
        return new SendCampaignPaymentMessageResult(builder.b());
    }

    @VisibleForTesting
    private static String m15144a(ImmutableList<Long> immutableList) {
        return "[" + StringUtil.b(",", new Object[]{immutableList}) + "]";
    }
}

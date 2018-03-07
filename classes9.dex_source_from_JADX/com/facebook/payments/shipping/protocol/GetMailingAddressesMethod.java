package com.facebook.payments.shipping.protocol;

import android.os.Parcelable;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.UnrestrictedResultPaymentsNetworkOperation;
import com.facebook.payments.shipping.model.SimpleMailingAddress;
import com.facebook.payments.shipping.model.SimpleMailingAddressBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: backstage_camera_video */
public class GetMailingAddressesMethod extends UnrestrictedResultPaymentsNetworkOperation<Parcelable, GetMailingAddressesResult> {
    public static GetMailingAddressesMethod m19007b(InjectorLike injectorLike) {
        return new GetMailingAddressesMethod(PaymentNetworkOperationHelper.a(injectorLike));
    }

    @Inject
    public GetMailingAddressesMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper, GetMailingAddressesResult.class);
    }

    public final ApiRequest m19008a(Object obj) {
        List a = Lists.a();
        a.add(new BasicNameValuePair("q", "viewer() {account_user {mailing_addresses {nodes {id, label, city_name, region_name, is_default, address {addressee, street, building, city, postal_code, country}}}}}"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "get_mailing_addresses";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "graphql";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m19009a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode jsonNode = (JsonNode) Preconditions.checkNotNull(((JsonNode) Preconditions.checkNotNull(((JsonNode) Preconditions.checkNotNull(((JsonNode) Preconditions.checkNotNull(apiResponse.c().b("viewer"))).b("account_user"))).b("mailing_addresses"))).b("nodes"));
        Preconditions.checkArgument(jsonNode.h());
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            jsonNode = (JsonNode) it.next();
            JsonNode jsonNode2 = (JsonNode) Preconditions.checkNotNull(jsonNode.b("address"));
            SimpleMailingAddressBuilder newBuilder = SimpleMailingAddress.newBuilder();
            newBuilder.f19012a = JSONUtil.b(jsonNode.b("id"));
            newBuilder = newBuilder;
            newBuilder.f19019h = JSONUtil.b(jsonNode.b("label"));
            newBuilder = newBuilder;
            newBuilder.f19020i = JSONUtil.b(jsonNode.b("city_name"));
            newBuilder = newBuilder;
            newBuilder.f19021j = JSONUtil.b(jsonNode.b("region_name"));
            newBuilder = newBuilder;
            newBuilder.f19022k = JSONUtil.g(jsonNode.b("is_default"));
            newBuilder = newBuilder;
            newBuilder.f19013b = JSONUtil.b(jsonNode2.b("addressee"));
            newBuilder = newBuilder;
            newBuilder.f19014c = JSONUtil.b(jsonNode2.b("street"));
            newBuilder = newBuilder;
            newBuilder.f19015d = JSONUtil.b(jsonNode2.b("building"));
            newBuilder = newBuilder;
            newBuilder.f19016e = JSONUtil.b(jsonNode2.b("city"));
            newBuilder = newBuilder;
            newBuilder.f19017f = JSONUtil.b(jsonNode2.b("postal_code"));
            newBuilder = newBuilder;
            newBuilder.f19018g = JSONUtil.b(jsonNode2.b("country"));
            builder.c(newBuilder.m18983l());
        }
        return new GetMailingAddressesResult(builder.b());
    }

    protected final String m19010a() {
        return "get_mailing_addresses";
    }
}

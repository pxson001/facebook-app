package com.facebook.zero.protocol.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.request.FetchZeroTokenRequestParams;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRuleSerialization;
import com.facebook.zero.sdk.token.ZeroToken;
import com.facebook.zero.sdk.util.StringListDataSerializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: fil */
public class FetchZeroTokenMethod extends ZeroBaseMethod implements ApiMethod<FetchZeroTokenRequestParams, ZeroToken> {
    private static final Class<?> f23728a = FetchZeroTokenMethod.class;
    private final StringListDataSerializer f23729b;
    private final ZeroUrlRewriteRuleSerialization f23730c;

    public static FetchZeroTokenMethod m32149b(InjectorLike injectorLike) {
        return new FetchZeroTokenMethod(StringListDataSerializer.m8059b(injectorLike), ZeroUrlRewriteRuleSerialization.m31825b(injectorLike));
    }

    public final ApiRequest mo672a(Object obj) {
        List b = m32150b((FetchZeroTokenRequestParams) obj);
        b.toString();
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.f7526b = "fetchZeroToken";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.f7527c = "GET";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.f7528d = "method/mobile.zeroCampaign";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.f7531g = b;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.f7535k = ApiResponseType.JSON;
        return apiRequestBuilder2.m12127a(RequestIdempotency.RETRY_SAFE).m12125C();
    }

    public final /* bridge */ /* synthetic */ Object mo673a(Object obj, ApiResponse apiResponse) {
        return m32148a(apiResponse);
    }

    @Inject
    public FetchZeroTokenMethod(StringListDataSerializer stringListDataSerializer, ZeroUrlRewriteRuleSerialization zeroUrlRewriteRuleSerialization) {
        this.f23729b = stringListDataSerializer;
        this.f23730c = zeroUrlRewriteRuleSerialization;
    }

    @VisibleForTesting
    private List<NameValuePair> m32150b(FetchZeroTokenRequestParams fetchZeroTokenRequestParams) {
        String str;
        List<NameValuePair> a = ZeroBaseMethod.m32153a(fetchZeroTokenRequestParams);
        String str2 = "dialtone_enabled";
        if (fetchZeroTokenRequestParams.f23530a == ZeroTokenType.DIALTONE) {
            str = "true";
        } else {
            str = "false";
        }
        a.add(new BasicNameValuePair(str2, str));
        str2 = "needs_backup_rules";
        if (fetchZeroTokenRequestParams.f23531b) {
            str = "true";
        } else {
            str = "false";
        }
        a.add(new BasicNameValuePair(str2, str));
        a.add(new BasicNameValuePair("token_hash", fetchZeroTokenRequestParams.f23532c));
        a.add(new BasicNameValuePair("request_reason", fetchZeroTokenRequestParams.f23533d.getRequestString()));
        return a;
    }

    private ZeroToken m32148a(ApiResponse apiResponse) {
        JsonNode c = apiResponse.m22205c();
        if (c == null) {
            throw new Exception("Expected response to be a struct");
        } else if (c.mo712e() == 0) {
            return ZeroToken.f23324a;
        } else {
            ImmutableSet fromStrings;
            ImmutableList a;
            ImmutableList a2;
            String a3 = JSONUtil.m13454a(c.mo709b("id"), "");
            JSONUtil.m13454a(c.mo709b("status"), "unknown");
            String a4 = JSONUtil.m13454a(c.mo709b("reg_status"), "unknown");
            String a5 = JSONUtil.m13454a(c.mo709b("carrier_name"), "");
            String a6 = JSONUtil.m13454a(c.mo709b("carrier_id"), "");
            String a7 = JSONUtil.m13454a(c.mo709b("carrier_logo_url"), "");
            int a8 = JSONUtil.m13449a(c.mo709b("ttl"), 3600);
            String a9 = JSONUtil.m13454a(c.mo709b("unregistered_reason"), "unavailable");
            if (c.mo709b("enabled_ui_features") != null) {
                fromStrings = ZeroFeatureKey.fromStrings(StringListDataSerializer.m8058a(c.mo709b("enabled_ui_features")));
            } else {
                fromStrings = ImmutableSet.of();
            }
            JsonNode b = c.mo709b("rewrite_rules");
            if (b != null) {
                a = ZeroUrlRewriteRuleSerialization.m31824a(b);
            } else {
                a = ImmutableList.of();
            }
            JsonNode b2 = c.mo709b("backup_rules");
            if (b2 != null) {
                a2 = ZeroUrlRewriteRuleSerialization.m31824a(b2);
            } else {
                a2 = ImmutableList.of();
            }
            return new ZeroToken(a3, a4, a5, a6, a7, a8, fromStrings, a, a9, a2, JSONUtil.m13454a(c.mo709b("token_hash"), ""), JSONUtil.m13449a(c.mo709b("request_time"), 0), JSONUtil.m13454a(c.mo709b("fast_hash"), ""));
        }
    }
}

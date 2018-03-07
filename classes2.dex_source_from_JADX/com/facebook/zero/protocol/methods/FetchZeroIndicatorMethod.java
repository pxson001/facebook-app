package com.facebook.zero.protocol.methods;

import com.facebook.common.locale.Locales;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.config.ZeroConfiguration;
import com.facebook.zero.fb4a.Fb4aZeroConfiguration;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.facebook.zero.ui.ZeroIndicatorDataSerialization;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: field_index */
public class FetchZeroIndicatorMethod implements ApiMethod<String, ZeroIndicatorData> {
    private static final Class<?> f23731a = FetchZeroIndicatorMethod.class;
    private final ZeroIndicatorDataSerialization f23732b;
    private final ZeroConfiguration f23733c;
    private final Locales f23734d;

    public static FetchZeroIndicatorMethod m32154b(InjectorLike injectorLike) {
        return new FetchZeroIndicatorMethod(ZeroIndicatorDataSerialization.m32145b(injectorLike), new Fb4aZeroConfiguration(), Locales.m2604a(injectorLike));
    }

    public final ApiRequest mo672a(Object obj) {
        String str = (String) obj;
        List a = Lists.m1296a();
        a.add(new BasicNameValuePair("megaphone_location", this.f23733c.mo3507a()));
        a.add(new BasicNameValuePair("zero_campaign", str));
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("locale", this.f23734d.m2613c()));
        return new ApiRequest("fetchZeroIndicator", "GET", "me/megaphone_top_stories", a, ApiResponseType.JSON);
    }

    @Inject
    public FetchZeroIndicatorMethod(ZeroIndicatorDataSerialization zeroIndicatorDataSerialization, ZeroConfiguration zeroConfiguration, Locales locales) {
        this.f23732b = zeroIndicatorDataSerialization;
        this.f23733c = zeroConfiguration;
        this.f23734d = locales;
    }

    @Nullable
    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        ZeroIndicatorData zeroIndicatorData;
        JsonNode a = apiResponse.m22205c().mo709b("data").mo708a(0);
        if (a == null) {
            zeroIndicatorData = null;
        } else {
            JsonNode b = a.mo709b("content");
            JsonNode b2 = a.mo709b("action");
            zeroIndicatorData = new ZeroIndicatorData(JSONUtil.m13454a(a.mo709b("id"), ""), JSONUtil.m13454a(a.mo709b("title"), ""), JSONUtil.m13454a(b.mo709b("text"), ""), JSONUtil.m13454a(b2.mo709b("title"), ""), JSONUtil.m13454a(b2.mo709b("url"), ""));
        }
        return zeroIndicatorData;
    }
}

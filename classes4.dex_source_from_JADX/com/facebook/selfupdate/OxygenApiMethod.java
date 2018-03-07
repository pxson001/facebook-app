package com.facebook.selfupdate;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: extra_device_id */
public class OxygenApiMethod implements ApiMethod<OxygenQueryParams, OxygenQueryResponse> {
    public final UniqueIdForDeviceHolderImpl f12511a;
    public final Provider<ViewerContext> f12512b;

    public static OxygenApiMethod m13259b(InjectorLike injectorLike) {
        return new OxygenApiMethod(UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 372));
    }

    public final ApiRequest m13260a(Object obj) {
        OxygenQueryParams oxygenQueryParams = (OxygenQueryParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("channel_app_id", "525967784198252"));
        a.add(new BasicNameValuePair("device_id", this.f12511a.a()));
        ViewerContext viewerContext = (ViewerContext) this.f12512b.get();
        if (viewerContext != null) {
            a.add(new BasicNameValuePair("access_token", viewerContext.mAuthToken));
        }
        List list = a;
        list.add(new BasicNameValuePair("limit", "1"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"").append(oxygenQueryParams.a).append("\":{ ");
        stringBuilder.append("\"version").append("\":").append(oxygenQueryParams.c).append(",");
        if (oxygenQueryParams.b != null) {
            stringBuilder.append("\"signature").append("\":\"").append(oxygenQueryParams.b).append("\",");
        }
        stringBuilder.append("},}");
        list.add(new BasicNameValuePair("builds", stringBuilder.toString()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "noauth_get_release_info";
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.GET;
        newBuilder = newBuilder;
        newBuilder.d = "method/mobile.releaseUpdate";
        newBuilder = newBuilder;
        newBuilder.g = list;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.t = true;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.u = false;
        return apiRequestBuilder.C();
    }

    @Inject
    public OxygenApiMethod(UniqueIdForDeviceHolder uniqueIdForDeviceHolder, Provider<ViewerContext> provider) {
        this.f12511a = uniqueIdForDeviceHolder;
        this.f12512b = provider;
    }

    public final Object m13261a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode b = apiResponse.c().b("data");
        if (b == null || b.e() == 0) {
            return null;
        }
        return new OxygenQueryResponse(b);
    }
}

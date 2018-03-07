package com.facebook.platform.server.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: full_refresh_reason */
public class GetAppPermissionsMethod implements ApiMethod<Params, Result> {
    public final ApiRequest m11764a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("third_party_app_id", params.a));
        a.add(new BasicNameValuePair("app_context", "platform_share"));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("get_app_permissions_method", TigonRequest.GET, "me/permissions", a, ApiResponseType.JSON);
    }

    public final Object m11765a(Object obj, ApiResponse apiResponse) {
        boolean z;
        apiResponse.i();
        JsonNode c = apiResponse.c();
        List a = Lists.a();
        if (c != null) {
            c = c.b("data");
        }
        if (c != null) {
            c = c.a(0);
        }
        if (c != null) {
            Iterator j = c.j();
            z = false;
            while (j.hasNext()) {
                String str = (String) j.next();
                if ("installed".equals(str)) {
                    z = true;
                } else {
                    a.add(str);
                }
            }
        } else {
            z = false;
        }
        return new Result(z, a);
    }
}

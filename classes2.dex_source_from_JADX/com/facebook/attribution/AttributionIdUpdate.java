package com.facebook.attribution;

import com.facebook.common.time.Clock;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: match_top_sms_contacts */
public class AttributionIdUpdate implements ApiMethod<Params, AttributionState> {
    private final Clock f14984a;

    public final ApiRequest mo672a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.m1296a();
        a.add(new BasicNameValuePair("attribution", params.a));
        a.add(new BasicNameValuePair("fb_device", params.e));
        if (params.b != null) {
            a.add(new BasicNameValuePair("gms_advertiser_id", params.b.a));
            a.add(new BasicNameValuePair("tracking_enabled", Boolean.toString(!params.b.b)));
            a.add(new BasicNameValuePair("gms_interop_fix", Boolean.toString(params.c)));
        }
        if (params.d != null) {
            a.add(new BasicNameValuePair("previous_advertising_id", params.d));
        }
        if (params.g != null) {
            a.add(new BasicNameValuePair("oxygen_attribution", params.g));
        }
        return new ApiRequest("postNewAttributionId", "POST", params.f + "/attributions", a, ApiResponseType.JSON);
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        JsonNode b;
        boolean z;
        Params params = (Params) obj;
        String str = null;
        boolean z2 = false;
        JsonNode c = apiResponse.m22205c();
        if (c != null) {
            JsonNode b2 = c.mo709b("should_relay_android_id");
            if (b2 != null) {
                z2 = b2.mo1646F();
            }
            b = c.mo709b("apps");
            z = z2;
        } else {
            b = null;
            z = false;
        }
        String str2 = params.a;
        long j = params.f;
        long a = this.f14984a.mo211a();
        if (params.b != null) {
            str = params.b.a;
        }
        return new AttributionState(str2, j, a, z, str, b);
    }

    public AttributionIdUpdate(Clock clock) {
        this.f14984a = clock;
    }
}

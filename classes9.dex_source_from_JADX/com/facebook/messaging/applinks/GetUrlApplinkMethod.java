package com.facebook.messaging.applinks;

import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: p2p_decline_payment_confirm */
public class GetUrlApplinkMethod implements ApiMethod<Uri, ApplinkData> {

    /* compiled from: p2p_decline_payment_confirm */
    public class ApplinkData {
        public final String f7697a;
        public final String f7698b;

        public ApplinkData(@Nullable String str, @Nonnull String str2) {
            this.f7697a = str;
            this.f7698b = str2;
        }
    }

    public final ApiRequest m7994a(Object obj) {
        Uri uri = (Uri) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("ids", uri.toString()));
        a.add(new BasicNameValuePair("fields", "app_links"));
        return new ApiRequest("fetchApplinkForUrl", "GET", "v2.1", RequestPriority.DEFAULT_PRIORITY, a, ApiResponseType.JSON);
    }

    @Nullable
    public final Object m7995a(Object obj, ApiResponse apiResponse) {
        String str = null;
        JsonNode f = apiResponse.c().f("android");
        if (f == null) {
            return null;
        }
        JsonNode f2 = f.f("url");
        if (f2 == null || StringUtil.a(f2.B())) {
            return null;
        }
        JsonNode f3 = f.f("package");
        if (f3 != null) {
            str = f3.B();
        }
        return new ApplinkData(str, f2.B());
    }
}

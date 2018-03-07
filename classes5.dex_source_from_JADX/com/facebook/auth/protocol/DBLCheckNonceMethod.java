package com.facebook.auth.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.config.application.PlatformAppConfig;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: supplemental_social_story */
public class DBLCheckNonceMethod implements ApiMethod<Params, Boolean> {
    private final PlatformAppConfig f2347a;

    /* compiled from: supplemental_social_story */
    public class Params {
        public final String f2343a;
        public final String f2344b;
        public final String f2345c;
        public final String f2346d;

        public Params(String str, String str2, String str3, String str4) {
            this.f2343a = str;
            this.f2344b = str2;
            this.f2345c = str3;
            this.f2346d = str4;
        }
    }

    public final ApiRequest m3210a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("app_id", this.f2347a.c()));
        a.add(new BasicNameValuePair("account_id", params.f2343a));
        if (params.f2344b != null) {
            a.add(new BasicNameValuePair("machine_id", params.f2344b));
        } else {
            a.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        a.add(new BasicNameValuePair("nonce", params.f2345c));
        a.add(new BasicNameValuePair("pin", params.f2346d));
        return new ApiRequest("dbl_check_nonce", "POST", StringFormatUtil.a("/%s/dblchecknonce", new Object[]{params.f2343a}), a, ApiResponseType.JSON);
    }

    @Inject
    public DBLCheckNonceMethod(PlatformAppConfig platformAppConfig) {
        this.f2347a = platformAppConfig;
    }

    public final Object m3211a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(JSONUtil.g(apiResponse.c()));
    }
}

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

/* compiled from: super_category_type */
public class DBLCheckPasswordMethod implements ApiMethod<Params, Boolean> {
    private final PlatformAppConfig f2351a;

    /* compiled from: super_category_type */
    public class Params {
        public final String f2348a;
        public final String f2349b;
        public final String f2350c;

        public Params(String str, String str2, String str3) {
            this.f2348a = str;
            this.f2349b = str2;
            this.f2350c = str3;
        }
    }

    public final ApiRequest m3212a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("app_id", this.f2351a.c()));
        a.add(new BasicNameValuePair("account_id", params.f2348a));
        if (params.f2349b != null) {
            a.add(new BasicNameValuePair("machine_id", params.f2349b));
        } else {
            a.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        a.add(new BasicNameValuePair("password", params.f2350c));
        return new ApiRequest("dbl_check_password", "POST", StringFormatUtil.a("/%s/dblcheckpassword", new Object[]{params.f2348a}), a, ApiResponseType.JSON);
    }

    @Inject
    public DBLCheckPasswordMethod(PlatformAppConfig platformAppConfig) {
        this.f2351a = platformAppConfig;
    }

    public final Object m3213a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(JSONUtil.g(apiResponse.c()));
    }
}

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

/* compiled from: super.subListUnchecked does not exist; inherited subList is valid if slow */
public class DBLRemoveNonceMethod implements ApiMethod<Params, Boolean> {
    private final PlatformAppConfig f2355a;

    /* compiled from: super.subListUnchecked does not exist; inherited subList is valid if slow */
    public class Params {
        public final String f2352a;
        public final String f2353b;
        public final String f2354c;

        public Params(String str, String str2, String str3) {
            this.f2352a = str;
            this.f2353b = str2;
            this.f2354c = str3;
        }
    }

    public final ApiRequest m3214a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("app_id", this.f2355a.c()));
        if (params.f2352a != null) {
            a.add(new BasicNameValuePair("machine_id", params.f2352a));
        } else {
            a.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        a.add(new BasicNameValuePair("account_id", params.f2353b));
        a.add(new BasicNameValuePair("nonce", params.f2354c));
        return new ApiRequest("dbl_remove_nonce", "POST", StringFormatUtil.a("/%s/dblremovenonce", new Object[]{params.f2353b}), a, ApiResponseType.JSON);
    }

    @Inject
    public DBLRemoveNonceMethod(PlatformAppConfig platformAppConfig) {
        this.f2355a = platformAppConfig;
    }

    public final Object m3215a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(JSONUtil.g(apiResponse.c()));
    }
}

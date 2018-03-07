package com.facebook.auth.protocol;

import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.config.application.PlatformAppConfig;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: support_dashboard */
public class DBLChangeNonceUsingPasswordMethod implements ApiMethod<Params, DBLFacebookCredentials> {
    private final PlatformAppConfig f2339a;
    private final FbSharedPreferences f2340b;
    private final ObjectMapper f2341c;
    private final AbstractFbErrorReporter f2342d;

    /* compiled from: support_dashboard */
    public class Params {
        public final String f2335a;
        public final String f2336b;
        public final String f2337c;
        public final String f2338d;

        public Params(String str, String str2, String str3, String str4) {
            this.f2335a = str;
            this.f2336b = str2;
            this.f2337c = str3;
            this.f2338d = str4;
        }
    }

    public static DBLChangeNonceUsingPasswordMethod m3207b(InjectorLike injectorLike) {
        return new DBLChangeNonceUsingPasswordMethod((PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final ApiRequest m3208a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("app_id", this.f2339a.c()));
        a.add(new BasicNameValuePair("account_id", params.f2335a));
        if (params.f2336b != null) {
            a.add(new BasicNameValuePair("machine_id", params.f2336b));
        } else {
            a.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        a.add(new BasicNameValuePair("password", params.f2337c));
        a.add(new BasicNameValuePair("new_pin", params.f2338d));
        return new ApiRequest("dbl_password_set_nonce", "POST", StringFormatUtil.a("/%s/dblpasswordsetnonce", new Object[]{params.f2335a}), a, ApiResponseType.JSON);
    }

    @Inject
    public DBLChangeNonceUsingPasswordMethod(PlatformAppConfig platformAppConfig, FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f2339a = platformAppConfig;
        this.f2340b = fbSharedPreferences;
        this.f2341c = objectMapper;
        this.f2342d = abstractFbErrorReporter;
    }

    public final Object m3209a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        String b = JSONUtil.b(c.b("id"));
        Integer valueOf = Integer.valueOf(JSONUtil.d(c.b("time")));
        String b2 = JSONUtil.b(c.b("name"));
        String b3 = JSONUtil.b(c.b("username"));
        String b4 = JSONUtil.b(c.b("nonce"));
        Boolean valueOf2 = Boolean.valueOf(JSONUtil.g(c.b("is_pin_set")));
        return new DBLFacebookCredentials(b, valueOf.intValue(), b2, b3, m3206a(b).mPicUrl, b4, valueOf2.booleanValue());
    }

    private DBLFacebookCredentials m3206a(String str) {
        try {
            return (DBLFacebookCredentials) this.f2341c.a(this.f2340b.a((PrefKey) AuthPrefKeys.k.a(str), null), DBLFacebookCredentials.class);
        } catch (Throwable e) {
            this.f2342d.a("DBLChangeNonceUsingPasswordMethod", "Unable to fetch user credentials from FbSharedPreferences.", e);
            return null;
        }
    }
}

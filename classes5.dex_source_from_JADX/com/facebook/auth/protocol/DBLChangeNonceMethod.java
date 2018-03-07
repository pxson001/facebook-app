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

/* compiled from: support_free_text */
public class DBLChangeNonceMethod implements ApiMethod<Params, DBLFacebookCredentials> {
    private final PlatformAppConfig f2331a;
    private final FbSharedPreferences f2332b;
    private final ObjectMapper f2333c;
    private final AbstractFbErrorReporter f2334d;

    /* compiled from: support_free_text */
    public class Params {
        public final String f2326a;
        public final String f2327b;
        public final String f2328c;
        public final String f2329d;
        public final String f2330e;

        public Params(String str, String str2, String str3, String str4, String str5) {
            this.f2326a = str;
            this.f2327b = str2;
            this.f2328c = str3;
            this.f2329d = str4;
            this.f2330e = str5;
        }
    }

    public static DBLChangeNonceMethod m3203b(InjectorLike injectorLike) {
        return new DBLChangeNonceMethod((PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final ApiRequest m3204a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("app_id", this.f2331a.c()));
        a.add(new BasicNameValuePair("account_id", params.f2326a));
        if (params.f2327b != null) {
            a.add(new BasicNameValuePair("machine_id", params.f2327b));
        } else {
            a.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        a.add(new BasicNameValuePair("nonce", params.f2328c));
        a.add(new BasicNameValuePair("old_pin", params.f2329d));
        a.add(new BasicNameValuePair("new_pin", params.f2330e));
        return new ApiRequest("dbl_change_nonce", "POST", StringFormatUtil.a("/%s/dblchangenonce", new Object[]{params.f2326a}), a, ApiResponseType.JSON);
    }

    @Inject
    public DBLChangeNonceMethod(PlatformAppConfig platformAppConfig, FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f2331a = platformAppConfig;
        this.f2332b = fbSharedPreferences;
        this.f2333c = objectMapper;
        this.f2334d = abstractFbErrorReporter;
    }

    public final Object m3205a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        String b = JSONUtil.b(c.b("id"));
        Integer valueOf = Integer.valueOf(JSONUtil.d(c.b("time")));
        String b2 = JSONUtil.b(c.b("name"));
        String b3 = JSONUtil.b(c.b("username"));
        String b4 = JSONUtil.b(c.b("nonce"));
        Boolean valueOf2 = Boolean.valueOf(JSONUtil.g(c.b("is_pin_set")));
        return new DBLFacebookCredentials(b, valueOf.intValue(), b2, b3, m3202a(b).mPicUrl, b4, valueOf2.booleanValue());
    }

    private DBLFacebookCredentials m3202a(String str) {
        try {
            return (DBLFacebookCredentials) this.f2333c.a(this.f2332b.a((PrefKey) AuthPrefKeys.k.a(str), null), DBLFacebookCredentials.class);
        } catch (Throwable e) {
            this.f2334d.a("DBLChangeNonceMethod", "Unable to fetch user credentials from FbSharedPreferences.", e);
            return null;
        }
    }
}

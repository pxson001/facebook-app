package com.facebook.auth.protocol;

import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.config.application.PlatformAppConfig;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.user.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: tagged_stickers */
public class SetNonceMethod implements ApiMethod<DeviceBasedLoginParams, DBLFacebookCredentials> {
    private Provider<User> f1318a;
    private final PlatformAppConfig f1319b;

    public static SetNonceMethod m1557b(InjectorLike injectorLike) {
        return new SetNonceMethod((PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class), IdBasedProvider.a(injectorLike, 3595));
    }

    public final ApiRequest m1558a(Object obj) {
        String str;
        DeviceBasedLoginParams deviceBasedLoginParams = (DeviceBasedLoginParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("new_app_id", this.f1319b.c()));
        if (deviceBasedLoginParams.a != null) {
            a.add(new BasicNameValuePair("machine_id", deviceBasedLoginParams.a));
        } else {
            a.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        a.add(new BasicNameValuePair("pin", deviceBasedLoginParams.b));
        a.add(new BasicNameValuePair("nonce_to_keep", deviceBasedLoginParams.c));
        if (deviceBasedLoginParams.d != null) {
            str = deviceBasedLoginParams.d;
        } else {
            str = ((User) this.f1318a.get()).a;
        }
        return new ApiRequest("set_nonce", TigonRequest.POST, StringFormatUtil.a("/%d/dblsetnonce", new Object[]{Long.valueOf(Long.parseLong(str))}), a, ApiResponseType.JSON);
    }

    public static SetNonceMethod m1556a(InjectorLike injectorLike) {
        return m1557b(injectorLike);
    }

    @Inject
    public SetNonceMethod(PlatformAppConfig platformAppConfig, Provider<User> provider) {
        this.f1319b = platformAppConfig;
        this.f1318a = provider;
    }

    public final Object m1559a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        String b = JSONUtil.b(c.b("id"));
        Integer valueOf = Integer.valueOf(JSONUtil.d(c.b("time")));
        String b2 = JSONUtil.b(c.b("name"));
        String b3 = JSONUtil.b(c.b("username"));
        String b4 = JSONUtil.b(c.b("nonce"));
        Boolean valueOf2 = Boolean.valueOf(JSONUtil.g(c.b("is_pin_set")));
        String str = null;
        if (this.f1318a.get() != null) {
            str = ((User) this.f1318a.get()).x();
        }
        return new DBLFacebookCredentials(b, valueOf.intValue(), b2, b3, str, b4, valueOf2.booleanValue());
    }
}

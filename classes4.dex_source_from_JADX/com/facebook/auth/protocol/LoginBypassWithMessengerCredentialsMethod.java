package com.facebook.auth.protocol;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: tag_expansion_options */
public class LoginBypassWithMessengerCredentialsMethod implements ApiMethod<LoginBypassWithMessengerCredentialsParams, AuthenticationResult> {
    private final UniqueIdForDeviceHolderImpl f1360a;
    private final AuthenticationResultExtractor f1361b;

    public static LoginBypassWithMessengerCredentialsMethod m1597a(InjectorLike injectorLike) {
        return new LoginBypassWithMessengerCredentialsMethod(UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), AuthenticationResultExtractor.m1535b(injectorLike));
    }

    public final ApiRequest m1598a(Object obj) {
        LoginBypassWithMessengerCredentialsParams loginBypassWithMessengerCredentialsParams = (LoginBypassWithMessengerCredentialsParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("account_id", loginBypassWithMessengerCredentialsParams.a.a));
        if (loginBypassWithMessengerCredentialsParams.a.e != null) {
            a.add(new BasicNameValuePair("birthday", new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(loginBypassWithMessengerCredentialsParams.a.e.getTime())));
        }
        a.add(new BasicNameValuePair("device_id", this.f1360a.a()));
        if (loginBypassWithMessengerCredentialsParams.b) {
            a.add(new BasicNameValuePair("generate_session_cookies", "1"));
        }
        if (loginBypassWithMessengerCredentialsParams.c != null) {
            a.add(new BasicNameValuePair("machine_id", loginBypassWithMessengerCredentialsParams.c));
        } else {
            a.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        a.add(new BasicNameValuePair("code", loginBypassWithMessengerCredentialsParams.a.c));
        a.add(new BasicNameValuePair("account_recovery_id", loginBypassWithMessengerCredentialsParams.a.d));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = BootstrapRequestName.LOGIN_MESSENGER_CREDS_BYPASS.requestNameString;
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.POST;
        newBuilder = newBuilder;
        newBuilder.d = "method/user.bypassLoginWithConfirmedMessengerCredentials";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m1599a(Object obj, ApiResponse apiResponse) {
        LoginBypassWithMessengerCredentialsParams loginBypassWithMessengerCredentialsParams = (LoginBypassWithMessengerCredentialsParams) obj;
        apiResponse.i();
        return this.f1361b.m1536a(apiResponse.c(), loginBypassWithMessengerCredentialsParams.a.b, loginBypassWithMessengerCredentialsParams.b, getClass().getSimpleName());
    }

    @Inject
    public LoginBypassWithMessengerCredentialsMethod(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl, AuthenticationResultExtractor authenticationResultExtractor) {
        this.f1360a = uniqueIdForDeviceHolderImpl;
        this.f1361b = authenticationResultExtractor;
    }
}

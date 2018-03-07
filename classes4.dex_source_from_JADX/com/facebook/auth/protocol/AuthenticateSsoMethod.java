package com.facebook.auth.protocol;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.config.application.PlatformAppConfig;
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
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: target_level_dbfs */
public class AuthenticateSsoMethod implements ApiMethod<Params, AuthenticationResult> {
    private final PlatformAppConfig f1300a;
    private final AuthenticationResultExtractor f1301b;
    private final UniqueIdForDeviceHolderImpl f1302c;

    public static AuthenticateSsoMethod m1532a(InjectorLike injectorLike) {
        return new AuthenticateSsoMethod((PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class), AuthenticationResultExtractor.m1535b(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike));
    }

    public final ApiRequest m1533a(Object obj) {
        Params params = (Params) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("device_id", this.f1302c.a()));
        arrayList.add(new BasicNameValuePair("access_token", params.a));
        arrayList.add(new BasicNameValuePair("new_app_id", params.c != null ? params.c : this.f1300a.c()));
        if (params.d) {
            arrayList.add(new BasicNameValuePair("generate_session_cookies", "1"));
        }
        if (params.b != null) {
            arrayList.add(new BasicNameValuePair("machine_id", params.b));
        } else {
            arrayList.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = BootstrapRequestName.AUTHENTICATE.requestNameString;
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.POST;
        newBuilder = newBuilder;
        newBuilder.d = "method/auth.getSessionForApp";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m1534a(Object obj, ApiResponse apiResponse) {
        Params params = (Params) obj;
        apiResponse.i();
        return this.f1301b.m1536a(apiResponse.c(), null, params.d, getClass().getSimpleName());
    }

    @Inject
    public AuthenticateSsoMethod(PlatformAppConfig platformAppConfig, AuthenticationResultExtractor authenticationResultExtractor, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f1300a = platformAppConfig;
        this.f1301b = authenticationResultExtractor;
        this.f1302c = uniqueIdForDeviceHolderImpl;
    }
}

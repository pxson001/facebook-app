package com.facebook.auth.protocol;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: targetWorkEmail */
public class AuthenticateDBLMethod implements ApiMethod<Params, AuthenticationResult> {
    private final AuthenticationResultExtractor f1307a;
    private final UniqueIdForDeviceHolderImpl f1308b;

    public static AuthenticateDBLMethod m1542b(InjectorLike injectorLike) {
        return new AuthenticateDBLMethod(AuthenticationResultExtractor.m1535b(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike));
    }

    public final ApiRequest m1543a(Object obj) {
        Params params = (Params) obj;
        DeviceBasedLoginCredentials deviceBasedLoginCredentials = params.a;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("device_id", this.f1308b.a()));
        a.add(new BasicNameValuePair("email", deviceBasedLoginCredentials.a));
        a.add(new BasicNameValuePair("password", deviceBasedLoginCredentials.b));
        a.add(new BasicNameValuePair("pin", deviceBasedLoginCredentials.c));
        if (deviceBasedLoginCredentials.d.getServerValue() != null) {
            a.add(new BasicNameValuePair("credentials_type", deviceBasedLoginCredentials.d.getServerValue()));
        }
        if (params.d) {
            a.add(new BasicNameValuePair("generate_session_cookies", "1"));
        }
        if (params.e != null) {
            a.add(new BasicNameValuePair("error_detail_type", params.e));
        }
        if (params.b != null) {
            a.add(new BasicNameValuePair("machine_id", params.b));
        } else {
            a.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        if (params.c != null) {
            a.add(new BasicNameValuePair("login_latitude", String.valueOf(params.c.getLatitude())));
            a.add(new BasicNameValuePair("login_longitude", String.valueOf(params.c.getLongitude())));
            a.add(new BasicNameValuePair("login_location_accuracy_m", String.valueOf(params.c.getAccuracy())));
            a.add(new BasicNameValuePair("login_location_timestamp_ms", String.valueOf(params.c.getTime())));
        }
        return new ApiRequest(BootstrapRequestName.AUTHENTICATE.requestNameString, TigonRequest.POST, "method/auth.login", a, ApiResponseType.JSON);
    }

    public final Object m1544a(Object obj, ApiResponse apiResponse) {
        Params params = (Params) obj;
        apiResponse.i();
        return this.f1307a.m1536a(apiResponse.c(), params.a.a, params.d, getClass().getSimpleName());
    }

    public static AuthenticateDBLMethod m1541a(InjectorLike injectorLike) {
        return m1542b(injectorLike);
    }

    @Inject
    public AuthenticateDBLMethod(AuthenticationResultExtractor authenticationResultExtractor, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f1307a = authenticationResultExtractor;
        this.f1308b = uniqueIdForDeviceHolderImpl;
    }
}

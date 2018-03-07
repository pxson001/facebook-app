package com.facebook.auth.protocol;

import android.location.Location;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.credentials.PasswordCredentials;
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
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: target_dialect */
public class AuthenticateMethod implements ApiMethod<Params, AuthenticationResult> {
    private final AuthenticationResultExtractor f1305a;
    private final UniqueIdForDeviceHolderImpl f1306b;

    /* compiled from: target_dialect */
    public class Params {
        public final PasswordCredentials f1376a;
        public final String f1377b;
        public final Location f1378c;
        public final boolean f1379d;
        public final String f1380e;

        public Params(PasswordCredentials passwordCredentials, String str, @Nullable Location location, boolean z, @Nullable String str2) {
            this.f1376a = passwordCredentials;
            this.f1377b = str;
            this.f1378c = location;
            this.f1379d = z;
            this.f1380e = str2;
        }
    }

    public static AuthenticateMethod m1538b(InjectorLike injectorLike) {
        return new AuthenticateMethod(AuthenticationResultExtractor.m1535b(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike));
    }

    public final ApiRequest m1539a(Object obj) {
        Params params = (Params) obj;
        PasswordCredentials passwordCredentials = params.f1376a;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("device_id", this.f1306b.a()));
        a.add(new BasicNameValuePair("email", passwordCredentials.f775a));
        a.add(new BasicNameValuePair("password", passwordCredentials.f776b));
        if (passwordCredentials.f777c.getServerValue() != null) {
            a.add(new BasicNameValuePair("credentials_type", passwordCredentials.f777c.getServerValue()));
        }
        if (params.f1379d) {
            a.add(new BasicNameValuePair("generate_session_cookies", "1"));
        }
        if (params.f1380e != null) {
            a.add(new BasicNameValuePair("error_detail_type", params.f1380e));
        }
        if (params.f1377b != null) {
            a.add(new BasicNameValuePair("machine_id", params.f1377b));
        } else {
            a.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        if (params.f1378c != null) {
            a.add(new BasicNameValuePair("login_latitude", String.valueOf(params.f1378c.getLatitude())));
            a.add(new BasicNameValuePair("login_longitude", String.valueOf(params.f1378c.getLongitude())));
            a.add(new BasicNameValuePair("login_location_accuracy_m", String.valueOf(params.f1378c.getAccuracy())));
            a.add(new BasicNameValuePair("login_location_timestamp_ms", String.valueOf(params.f1378c.getTime())));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = BootstrapRequestName.AUTHENTICATE.requestNameString;
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.POST;
        newBuilder = newBuilder;
        newBuilder.d = "method/auth.login";
        newBuilder = newBuilder;
        newBuilder.g = a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m1540a(Object obj, ApiResponse apiResponse) {
        Params params = (Params) obj;
        apiResponse.i();
        return this.f1305a.m1536a(apiResponse.c(), params.f1376a.f775a, params.f1379d, getClass().getSimpleName());
    }

    public static AuthenticateMethod m1537a(InjectorLike injectorLike) {
        return m1538b(injectorLike);
    }

    @Inject
    public AuthenticateMethod(AuthenticationResultExtractor authenticationResultExtractor, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f1305a = authenticationResultExtractor;
        this.f1306b = uniqueIdForDeviceHolderImpl;
    }
}

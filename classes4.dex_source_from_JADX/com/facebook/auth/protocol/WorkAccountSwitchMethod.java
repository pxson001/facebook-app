package com.facebook.auth.protocol;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.credentials.WorkUserSwitchCredentials;
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
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: tabIconImage */
public class WorkAccountSwitchMethod implements ApiMethod<Params, AuthenticationResult> {
    private final AuthenticationResultExtractor f1363a;
    private final UniqueIdForDeviceHolderImpl f1364b;

    public static WorkAccountSwitchMethod m1605a(InjectorLike injectorLike) {
        return new WorkAccountSwitchMethod(AuthenticationResultExtractor.m1535b(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike));
    }

    public final ApiRequest m1606a(Object obj) {
        Params params = (Params) obj;
        WorkUserSwitchCredentials workUserSwitchCredentials = params.a;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("device_id", this.f1364b.a()));
        a.add(new BasicNameValuePair("email", "X"));
        a.add(new BasicNameValuePair("password", "X"));
        a.add(new BasicNameValuePair("credentials_type", "personal_to_work_switch"));
        a.add(new BasicNameValuePair("community_id", workUserSwitchCredentials.b));
        a.add(new BasicNameValuePair("access_token", workUserSwitchCredentials.c));
        a.add(new BasicNameValuePair("generate_session_cookies", "1"));
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

    public final Object m1607a(Object obj, ApiResponse apiResponse) {
        Params params = (Params) obj;
        apiResponse.i();
        return this.f1363a.m1536a(apiResponse.c(), params.a.a, params.d, getClass().getSimpleName());
    }

    @Inject
    public WorkAccountSwitchMethod(AuthenticationResultExtractor authenticationResultExtractor, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f1363a = authenticationResultExtractor;
        this.f1364b = uniqueIdForDeviceHolderImpl;
    }
}

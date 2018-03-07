package com.facebook.registration.protocol;

import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.registration.model.RegistrationFormData;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: joinable_decline_admin */
public class ValidateRegistrationDataMethod implements ApiMethod<RegistrationFormData, Boolean> {
    private final String f8927a;

    public final ApiRequest m8926a(Object obj) {
        List r = ((RegistrationFormData) obj).r();
        r.add(new BasicNameValuePair("is_background", "false"));
        r.add(new BasicNameValuePair("reg_instance", this.f8927a));
        r.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = BootstrapRequestName.VALIDATE_REGISTRATION_DATA.requestNameString;
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "method/user.validateregistrationdata";
        newBuilder = newBuilder.a(RequestPriority.INTERACTIVE);
        newBuilder.g = r;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    public ValidateRegistrationDataMethod(String str) {
        this.f8927a = str;
    }

    public final Object m8927a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}

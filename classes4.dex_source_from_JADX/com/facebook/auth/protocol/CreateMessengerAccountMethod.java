package com.facebook.auth.protocol;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.common.util.JSONUtil;
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
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: tag_expansion_state */
public class CreateMessengerAccountMethod implements ApiMethod<CreateMessengerAccountParams, AuthenticationResult> {
    private final UniqueIdForDeviceHolderImpl f1358a;
    private final AuthenticationResultExtractor f1359b;

    public static CreateMessengerAccountMethod m1594a(InjectorLike injectorLike) {
        return new CreateMessengerAccountMethod(UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), AuthenticationResultExtractor.m1535b(injectorLike));
    }

    public final ApiRequest m1595a(Object obj) {
        CreateMessengerAccountParams createMessengerAccountParams = (CreateMessengerAccountParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("phone_number", createMessengerAccountParams.a.a));
        a.add(new BasicNameValuePair("first_name", createMessengerAccountParams.a.b));
        a.add(new BasicNameValuePair("last_name", createMessengerAccountParams.a.c));
        a.add(new BasicNameValuePair("device_id", this.f1358a.a()));
        if (createMessengerAccountParams.e != null) {
            a.add(new BasicNameValuePair("machine_id", createMessengerAccountParams.e));
        } else {
            a.add(new BasicNameValuePair("generate_machine_id", "1"));
        }
        if (createMessengerAccountParams.b) {
            a.add(new BasicNameValuePair("generate_session_cookies", "1"));
        }
        if (createMessengerAccountParams.c) {
            a.add(new BasicNameValuePair("seek_match", "1"));
        }
        a.add(new BasicNameValuePair("account_recovery_id", createMessengerAccountParams.d));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = BootstrapRequestName.CREATE_MESSENGER_ACCOUNT.requestNameString;
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.POST;
        newBuilder = newBuilder;
        newBuilder.d = "method/user.createMessengerOnlyAccount";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m1596a(Object obj, ApiResponse apiResponse) {
        CreateMessengerAccountParams createMessengerAccountParams = (CreateMessengerAccountParams) obj;
        apiResponse.i();
        JsonNode c = apiResponse.c();
        if (c.d("suggested_facebook_user")) {
            c = c.b("suggested_facebook_user");
            if (c.d("account_id")) {
                throw new SuggestedFacebookAccountFoundException(new SuggestedFacebookAccountInfo(JSONUtil.b(c.b("account_id")), JSONUtil.b(c.b("first_name")), JSONUtil.b(c.b("last_name")), JSONUtil.b(c.b("profile_pic"))));
            }
        }
        return this.f1359b.m1536a(apiResponse.c(), createMessengerAccountParams.a.a, createMessengerAccountParams.b, getClass().getSimpleName());
    }

    @Inject
    public CreateMessengerAccountMethod(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl, AuthenticationResultExtractor authenticationResultExtractor) {
        this.f1359b = authenticationResultExtractor;
        this.f1358a = uniqueIdForDeviceHolderImpl;
    }
}

package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.AddMembersParams;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: declinePaymentParams */
public class AddMembersMethod implements ApiMethod<AddMembersParams, Void> {
    private final PickedUserUtils f16863a;

    public final ApiRequest m16852a(Object obj) {
        AddMembersParams addMembersParams = (AddMembersParams) obj;
        List a = Lists.a();
        JsonNode a2 = PickedUserUtils.m16998a((List) addMembersParams.f17010b);
        a.add(new BasicNameValuePair("id", "t_" + addMembersParams.f17009a.i()));
        a.add(new BasicNameValuePair("to", a2.toString()));
        return new ApiRequest("addMembers", "POST", "/participants", a, ApiResponseType.STRING);
    }

    @Inject
    public AddMembersMethod(PickedUserUtils pickedUserUtils) {
        this.f16863a = pickedUserUtils;
    }

    public final Object m16853a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

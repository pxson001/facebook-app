package com.facebook.contacts.protocol.methods;

import com.facebook.contacts.server.DeleteContactParams;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;

/* compiled from: result_path */
public class DeleteContactMethod implements ApiMethod<DeleteContactParams, Void> {
    public final ApiRequest m3621a(Object obj) {
        DeleteContactParams deleteContactParams = (DeleteContactParams) obj;
        return new ApiRequest("deleteContact", "DELETE", deleteContactParams.a.m4069d(), Lists.a(), ApiResponseType.JSON);
    }

    public final Object m3622a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

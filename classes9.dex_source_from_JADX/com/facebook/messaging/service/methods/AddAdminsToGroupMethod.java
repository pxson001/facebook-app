package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.AddAdminsToGroupParams;
import com.facebook.messaging.service.model.AddAdminsToGroupResult;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: decline_payment */
public class AddAdminsToGroupMethod implements ApiMethod<AddAdminsToGroupParams, AddAdminsToGroupResult> {
    public final ApiRequest m16850a(Object obj) {
        AddAdminsToGroupParams addAdminsToGroupParams = (AddAdminsToGroupParams) obj;
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("t_id.%d/admins", Long.valueOf(addAdminsToGroupParams.f17007c.i()));
        List arrayList = new ArrayList();
        String str = "admin_ids";
        Builder builder = ImmutableList.builder();
        Iterator it = addAdminsToGroupParams.f17006b.iterator();
        while (it.hasNext()) {
            builder.c(((UserKey) it.next()).b());
        }
        arrayList.add(new BasicNameValuePair(str, builder.b().toString()));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "addAdminsToGroup";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = formatStrLocaleSafe;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.g = arrayList;
        return apiRequestBuilder2.C();
    }

    public final Object m16851a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        boolean z = c.d("success") && c.b("success").F();
        return new AddAdminsToGroupResult(z);
    }
}

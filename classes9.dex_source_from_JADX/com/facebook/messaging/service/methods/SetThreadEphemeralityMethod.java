package com.facebook.messaging.service.methods;

import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: ct_ */
public class SetThreadEphemeralityMethod implements ApiMethod<ModifyThreadParams, Void> {
    private final UniqueIdGenerator f16983a;

    public final ApiRequest m17041a(Object obj) {
        int i;
        ModifyThreadParams modifyThreadParams = (ModifyThreadParams) obj;
        Preconditions.checkArgument(modifyThreadParams.f17234n);
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("offline_threading_id", String.valueOf(this.f16983a.a())));
        arrayList.add(new BasicNameValuePair("thread_key", modifyThreadParams.m17156q()));
        arrayList.add(new BasicNameValuePair("new_thread_ttl", String.valueOf(modifyThreadParams.f17235o)));
        if (modifyThreadParams.f17235o == 0) {
            i = modifyThreadParams.f17236p;
        } else {
            i = modifyThreadParams.f17235o;
        }
        arrayList.add(new BasicNameValuePair("xmat_ttl", String.valueOf(i)));
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s/ephemeral_thread_modes", MessagingIdUtil.m17834a(modifyThreadParams.m17156q()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "setThreadEphemeralMode";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = formatStrLocaleSafe;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.STRING;
        return apiRequestBuilder2.C();
    }

    @Inject
    public SetThreadEphemeralityMethod(UniqueIdGenerator uniqueIdGenerator) {
        this.f16983a = uniqueIdGenerator;
    }

    public final Object m17042a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

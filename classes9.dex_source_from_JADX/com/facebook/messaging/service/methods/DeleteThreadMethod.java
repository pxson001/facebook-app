package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.DeleteThreadParams;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: date<= */
public class DeleteThreadMethod implements ApiMethod<DeleteThreadParams, Void> {
    public final ApiRequest m16881a(Object obj) {
        DeleteThreadParams deleteThreadParams = (DeleteThreadParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("id", "t_" + deleteThreadParams.f17035a.i()));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("deleteThread", "DELETE", "", a, ApiResponseType.STRING);
    }

    public final Object m16882a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

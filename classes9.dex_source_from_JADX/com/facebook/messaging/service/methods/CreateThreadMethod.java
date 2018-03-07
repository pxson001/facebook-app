package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.service.model.SendMessageByRecipientsParams;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: date_micros */
public class CreateThreadMethod implements ApiMethod<SendMessageByRecipientsParams, String> {
    private final PickedUserUtils f16866a;
    private final SendMessageParameterHelper f16867b;

    public static CreateThreadMethod m16867a(InjectorLike injectorLike) {
        return new CreateThreadMethod(PickedUserUtils.m16996a(injectorLike), SendMessageParameterHelper.m17035b(injectorLike));
    }

    public final ApiRequest m16868a(Object obj) {
        Object obj2;
        SendMessageByRecipientsParams sendMessageByRecipientsParams = (SendMessageByRecipientsParams) obj;
        List arrayList = new ArrayList();
        if (sendMessageByRecipientsParams.f17304a != null) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            arrayList.add(new BasicNameValuePair("name", sendMessageByRecipientsParams.f17304a));
        }
        this.f16867b.m17038a(arrayList, sendMessageByRecipientsParams.f17305b);
        arrayList.add(new BasicNameValuePair("to", PickedUserUtils.m16998a((List) sendMessageByRecipientsParams.f17306c).toString()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "createThread";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/threads";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    public CreateThreadMethod(PickedUserUtils pickedUserUtils, SendMessageParameterHelper sendMessageParameterHelper) {
        this.f16866a = pickedUserUtils;
        this.f16867b = sendMessageParameterHelper;
    }

    public final Object m16869a(Object obj, ApiResponse apiResponse) {
        return JSONUtil.b(apiResponse.c().b("tid"));
    }
}

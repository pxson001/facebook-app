package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.SendMessageToPendingThreadParams;
import com.facebook.messaging.service.model.SendMessageToPendingThreadResult;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: ct_cls */
public class SendMessageToPendingThreadMethod implements ApiMethod<SendMessageToPendingThreadParams, SendMessageToPendingThreadResult> {
    private final PickedUserUtils f16981a;
    private final SendMessageParameterHelper f16982b;

    public final ApiRequest m17039a(Object obj) {
        SendMessageToPendingThreadParams sendMessageToPendingThreadParams = (SendMessageToPendingThreadParams) obj;
        Preconditions.checkNotNull(sendMessageToPendingThreadParams);
        Preconditions.checkNotNull(sendMessageToPendingThreadParams.f17320a);
        Preconditions.checkNotNull(sendMessageToPendingThreadParams.f17320a.b);
        Preconditions.checkArgument(sendMessageToPendingThreadParams.f17320a.b.f());
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("to", PickedUserUtils.m16998a((List) sendMessageToPendingThreadParams.f17321b).toString()));
        arrayList.add(new BasicNameValuePair("use_existing_group", "true"));
        this.f16982b.m17038a(arrayList, sendMessageToPendingThreadParams.f17320a);
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "sendMessageToPendingThread";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "/threads";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    public SendMessageToPendingThreadMethod(PickedUserUtils pickedUserUtils, SendMessageParameterHelper sendMessageParameterHelper) {
        this.f16981a = pickedUserUtils;
        this.f16982b = sendMessageParameterHelper;
    }

    public final Object m17040a(Object obj, ApiResponse apiResponse) {
        return new SendMessageToPendingThreadResult(ThreadKey.a(JSONUtil.c(apiResponse.c().b("thread_fbid"))));
    }
}

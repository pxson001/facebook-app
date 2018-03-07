package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import com.facebook.user.model.UserFbidIdentifier;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: ct_t */
public class SendMessageMethod implements ApiMethod<Message, String> {
    private static final Class<?> f16975a = SendMessageMethod.class;
    private final PickedUserUtils f16976b;
    private final SendMessageParameterHelper f16977c;

    public static SendMessageMethod m17031b(InjectorLike injectorLike) {
        return new SendMessageMethod(PickedUserUtils.m16996a(injectorLike), SendMessageParameterHelper.m17035b(injectorLike));
    }

    public final ApiRequest m17032a(Object obj) {
        String str;
        Message message = (Message) obj;
        List arrayList = new ArrayList();
        if (message.b == null && message.z != null && !message.z.isEmpty()) {
            str = "/threads";
        } else if (ThreadKey.b(message.b)) {
            long j = message.b.d;
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            arrayNode.a(PickedUserUtils.m16997a(new UserFbidIdentifier(Long.toString(j))));
            arrayList.add(new BasicNameValuePair("to", arrayNode.toString()));
            str = "me/threads";
        } else {
            Object obj2;
            ThreadKey threadKey = message.b;
            if (threadKey == null || !threadKey.c()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                str = "me/montage_thread_messages";
            } else {
                arrayList.add(new BasicNameValuePair("id", MessagingIdUtil.m17835b(message.b.b)));
                str = "/messages";
            }
        }
        this.f16977c.m17038a(arrayList, message);
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "sendMessage";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = arrayList;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    public SendMessageMethod(PickedUserUtils pickedUserUtils, SendMessageParameterHelper sendMessageParameterHelper) {
        this.f16976b = pickedUserUtils;
        this.f16977c = sendMessageParameterHelper;
    }

    public static SendMessageMethod m17030a(InjectorLike injectorLike) {
        return m17031b(injectorLike);
    }

    public final Object m17033a(Object obj, ApiResponse apiResponse) {
        return JSONUtil.b(apiResponse.c().b("id"));
    }
}

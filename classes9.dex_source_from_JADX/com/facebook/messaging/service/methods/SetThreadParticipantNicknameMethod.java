package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: crop */
public class SetThreadParticipantNicknameMethod implements ApiMethod<ModifyThreadParams, Void> {
    public final ApiRequest m17050a(Object obj) {
        String str;
        ModifyThreadParams modifyThreadParams = (ModifyThreadParams) obj;
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s/nicknames", MessagingIdUtil.m17834a(modifyThreadParams.m17156q()));
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("participant_id", modifyThreadParams.f17231k.f17219a));
        arrayList.add(new BasicNameValuePair("source", modifyThreadParams.f17233m));
        String str2 = modifyThreadParams.f17231k.f17220b;
        if (StringUtil.a(str2)) {
            str = "DELETE";
        } else {
            str = "POST";
            arrayList.add(new BasicNameValuePair("nickname", str2));
        }
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "setThreadParticipantNickname";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = str;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.d = formatStrLocaleSafe;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.g = arrayList;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    public final Object m17051a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

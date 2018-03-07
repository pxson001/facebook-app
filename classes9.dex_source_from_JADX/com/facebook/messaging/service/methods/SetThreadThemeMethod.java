package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.model.threads.ThreadCustomization.Builder;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.messaging.service.model.SetThreadThemeResult;
import com.facebook.messaging.service.model.SetThreadThemeResultBuilder;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: credit_card_enabled */
public class SetThreadThemeMethod implements ApiMethod<ModifyThreadParams, SetThreadThemeResult> {
    public final ApiRequest m17054a(Object obj) {
        ModifyThreadParams modifyThreadParams = (ModifyThreadParams) obj;
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s/threadcustomization", MessagingIdUtil.m17834a(modifyThreadParams.m17156q()));
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        ThreadCustomization threadCustomization = modifyThreadParams.f17232l;
        if (modifyThreadParams.f17229i) {
            Object obj2;
            if (threadCustomization.b == ThreadCustomization.a.b && threadCustomization.c == ThreadCustomization.a.c && threadCustomization.d == ThreadCustomization.a.d) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                arrayList.add(new BasicNameValuePair("clear_theme", "true"));
            } else {
                if (threadCustomization.b != 0) {
                    arrayList.add(new BasicNameValuePair("background_color", m17053a(threadCustomization.b)));
                }
                if (threadCustomization.d != 0) {
                    arrayList.add(new BasicNameValuePair("incoming_bubble_color", m17053a(threadCustomization.d)));
                }
                if (threadCustomization.c != 0) {
                    arrayList.add(new BasicNameValuePair("outgoing_bubble_color", m17053a(threadCustomization.c)));
                }
                if (threadCustomization.e != 0) {
                    arrayList.add(new BasicNameValuePair("theme_color", m17053a(threadCustomization.e)));
                }
            }
        }
        if (modifyThreadParams.f17230j) {
            if (Objects.equal(threadCustomization.f, ThreadCustomization.a.f)) {
                arrayList.add(new BasicNameValuePair("clear_icon", "true"));
            } else {
                arrayList.add(new BasicNameValuePair("emoji", threadCustomization.f));
            }
        }
        arrayList.add(new BasicNameValuePair("source", modifyThreadParams.f17233m));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "setThreadTheme";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = formatStrLocaleSafe;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.g = arrayList;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    public final Object m17055a(Object obj, ApiResponse apiResponse) {
        ModifyThreadParams modifyThreadParams = (ModifyThreadParams) obj;
        apiResponse.i();
        JsonNode c = apiResponse.c();
        int a = m17052a(c, "thread_background_color");
        int a2 = m17052a(c, "outgoing_bubble_color");
        int a3 = m17052a(c, "incoming_bubble_color");
        String b = JSONUtil.b(c.b("emoji"));
        SetThreadThemeResultBuilder setThreadThemeResultBuilder = new SetThreadThemeResultBuilder();
        setThreadThemeResultBuilder.f17333a = modifyThreadParams.f17221a;
        setThreadThemeResultBuilder = setThreadThemeResultBuilder;
        Builder newBuilder = ThreadCustomization.newBuilder();
        newBuilder.a = a;
        Builder builder = newBuilder;
        builder.b = a2;
        builder = builder;
        builder.c = a3;
        builder = builder;
        builder.e = b;
        setThreadThemeResultBuilder.f17334b = builder.g();
        return new SetThreadThemeResult(setThreadThemeResultBuilder);
    }

    private static String m17053a(int i) {
        return i == 0 ? "00000000" : Integer.toHexString(i);
    }

    private static int m17052a(JsonNode jsonNode, String str) {
        Object a = JSONUtil.a(jsonNode.b(str), "");
        if (!StringUtil.a(a)) {
            try {
                return (int) Long.parseLong(a, 16);
            } catch (NumberFormatException e) {
            }
        }
        return 0;
    }
}

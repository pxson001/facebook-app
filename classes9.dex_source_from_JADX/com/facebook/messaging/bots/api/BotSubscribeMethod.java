package com.facebook.messaging.bots.api;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableList;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: oes_tex */
public class BotSubscribeMethod implements ApiMethod<Params, Void> {

    /* compiled from: oes_tex */
    public class Params {
        public final ThreadKey f8313a;
        public final long f8314b;

        public Params(ThreadKey threadKey, long j) {
            this.f8313a = threadKey;
            this.f8314b = j;
        }
    }

    public static BotSubscribeMethod m8576a(InjectorLike injectorLike) {
        return new BotSubscribeMethod();
    }

    public final ApiRequest m8577a(Object obj) {
        Params params = (Params) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.b = "messengerSubscribeToBot";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.g = ImmutableList.of(new BasicNameValuePair("id", StringFormatUtil.a("t_%d", new Object[]{Long.valueOf(params.f8313a.i())})), new BasicNameValuePair("bot", String.valueOf(params.f8314b)));
        newBuilder = newBuilder;
        newBuilder.d = "bot_subscriptions";
        return newBuilder.C();
    }

    public final Object m8578a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

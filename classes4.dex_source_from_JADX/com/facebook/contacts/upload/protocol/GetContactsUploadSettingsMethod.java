package com.facebook.contacts.upload.protocol;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;

/* compiled from: rtc_48khz */
public class GetContactsUploadSettingsMethod implements ApiMethod<Void, Result> {

    /* compiled from: rtc_48khz */
    public final class Result {
        public final boolean f3431a;

        public Result(boolean z) {
            this.f3431a = z;
        }
    }

    public final ApiRequest m3522a(@Nullable Object obj) {
        return new ApiRequest("getGlobalKillSwitchForContactsUpload", TigonRequest.GET, "me/contactsmessengersync", Lists.a(), ApiResponseType.JSON);
    }

    public final Object m3523a(@Nullable Object obj, ApiResponse apiResponse) {
        return new Result(JSONUtil.g(apiResponse.c().b("enabled")));
    }
}

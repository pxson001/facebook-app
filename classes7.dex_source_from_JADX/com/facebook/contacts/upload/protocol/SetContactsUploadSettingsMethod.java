package com.facebook.contacts.upload.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: tap_sticker_button */
public class SetContactsUploadSettingsMethod implements ApiMethod<Params, Void> {

    /* compiled from: tap_sticker_button */
    public final class Params {
        public final boolean f2226a;

        public Params(boolean z) {
            this.f2226a = z;
        }
    }

    public static SetContactsUploadSettingsMethod m2188a(InjectorLike injectorLike) {
        return new SetContactsUploadSettingsMethod();
    }

    public final ApiRequest m2189a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("enabled", String.valueOf(params.f2226a)));
        return new ApiRequest("setGlobalKillSwitchForContactsUpload", "POST", "me/contactsmessengersync", a, ApiResponseType.STRING);
    }

    public final Object m2190a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

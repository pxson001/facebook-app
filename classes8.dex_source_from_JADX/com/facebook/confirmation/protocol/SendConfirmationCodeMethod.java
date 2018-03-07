package com.facebook.confirmation.protocol;

import com.facebook.growth.model.Contactpoint;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: instant_article_follow_profile */
public class SendConfirmationCodeMethod implements ApiMethod<Contactpoint, Boolean> {
    public final ApiRequest m12739a(Object obj) {
        Contactpoint contactpoint = (Contactpoint) obj;
        NameValuePair[] nameValuePairArr = new NameValuePair[]{new BasicNameValuePair("normalized_contactpoint", contactpoint.normalized), new BasicNameValuePair("contactpoint_type", contactpoint.type.name()), new BasicNameValuePair("format", "json")};
        return new ApiRequest("sendConfirmationCode", "POST", "method/user.sendconfirmationcode", Lists.a(nameValuePairArr), ApiResponseType.JSON);
    }

    public final Object m12740a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}

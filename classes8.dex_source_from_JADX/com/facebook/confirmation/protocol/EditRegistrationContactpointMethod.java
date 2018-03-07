package com.facebook.confirmation.protocol;

import com.facebook.growth.model.Contactpoint;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: instant_article_media_id */
public class EditRegistrationContactpointMethod implements ApiMethod<Contactpoint, Boolean> {
    public final ApiRequest m12734a(Object obj) {
        Contactpoint contactpoint = (Contactpoint) obj;
        NameValuePair[] nameValuePairArr = new NameValuePair[]{new BasicNameValuePair("add_contactpoint", contactpoint.normalized), new BasicNameValuePair("add_contactpoint_type", contactpoint.type.name()), new BasicNameValuePair("format", "json")};
        return new ApiRequest("editRegistrationContactpoint", "POST", "method/user.editregistrationcontactpoint", Lists.a(nameValuePairArr), ApiResponseType.JSON);
    }

    public final Object m12735a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}

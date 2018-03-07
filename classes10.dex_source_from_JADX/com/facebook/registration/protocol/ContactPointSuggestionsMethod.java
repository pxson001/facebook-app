package com.facebook.registration.protocol;

import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.registration.model.ContactPointSuggestions;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: journey_prompt */
public class ContactPointSuggestionsMethod implements ApiMethod<Void, ContactPointSuggestions> {
    private final String f8917a;
    private final UniqueIdForDeviceHolderImpl f8918b;

    @Inject
    public ContactPointSuggestionsMethod(String str, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f8917a = str;
        this.f8918b = uniqueIdForDeviceHolderImpl;
    }

    public final ApiRequest m8900a(Object obj) {
        List arrayList = new ArrayList();
        String a = this.f8918b.a();
        if (a != null) {
            a = a.toUpperCase(Locale.US);
        }
        arrayList.add(new BasicNameValuePair("reg_instance", this.f8917a));
        arrayList.add(new BasicNameValuePair("phone_id", a));
        arrayList.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = BootstrapRequestName.CONTACT_POINT_SUGGESTIONS.requestNameString;
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "method/user.prefillorautocompletecontactpoint";
        newBuilder = newBuilder.a(RequestPriority.INTERACTIVE);
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSONPARSER;
        return newBuilder.C();
    }

    public final Object m8901a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (ContactPointSuggestions) apiResponse.d().a(ContactPointSuggestions.class);
    }
}

package com.facebook.contactlogs.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.common.collect.Lists;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: profile_nux_entry_point_view */
public class StartJourneysMethod implements ApiMethod<ArrayList<String>, Void> {
    public final JsonFactory f6171a;

    public final ApiRequest m6509a(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        NameValuePair[] nameValuePairArr = new NameValuePair[2];
        nameValuePairArr[0] = new BasicNameValuePair("format", "json");
        String str = "target_ids";
        Writer stringWriter = new StringWriter();
        JsonGenerator a = this.f6171a.a(stringWriter);
        a.d();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a.b((String) arrayList.get(i));
        }
        a.e();
        a.flush();
        nameValuePairArr[1] = new BasicNameValuePair(str, stringWriter.toString());
        List a2 = Lists.a(nameValuePairArr);
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "BeginJourneys";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "/me/messenger_journeys";
        newBuilder = newBuilder;
        newBuilder.g = a2;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    public StartJourneysMethod(JsonFactory jsonFactory) {
        this.f6171a = jsonFactory;
    }

    public final Object m6510a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

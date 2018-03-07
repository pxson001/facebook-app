package com.facebook.places.create.home;

import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBody;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: card_form_save_click */
public class HomeUpdateMethod implements ApiMethod<HomeUpdateParams, Boolean> {
    public final ApiRequest m22309a(Object obj) {
        HomeUpdateParams homeUpdateParams = (HomeUpdateParams) obj;
        List a = Lists.a();
        Preconditions.checkNotNull(Long.valueOf(homeUpdateParams.f18346a));
        boolean z = (homeUpdateParams.f18347b == null || homeUpdateParams.f18347b.trim().isEmpty()) ? false : true;
        Preconditions.checkArgument(z);
        a.add(new BasicNameValuePair("name", homeUpdateParams.f18347b));
        if (homeUpdateParams.f18348c != null) {
            a.add(new BasicNameValuePair("privacy", homeUpdateParams.f18348c.c()));
        }
        if (homeUpdateParams.f18349d != null) {
            a.add(new BasicNameValuePair("neighborhood_name", homeUpdateParams.f18349d));
        }
        if (!((homeUpdateParams.f18350e == null || homeUpdateParams.f18350e.trim().isEmpty()) && (homeUpdateParams.f18351f == null || homeUpdateParams.f18351f.trim().isEmpty()))) {
            ObjectNode c = JsonNodeFactory.a.c();
            c.a("city", homeUpdateParams.f18351f);
            c.a("street", homeUpdateParams.f18350e);
            a.add(new BasicNameValuePair("address", c.toString()));
        }
        if (homeUpdateParams.f18352g != 0) {
            a.add(new BasicNameValuePair("city_id", String.valueOf(homeUpdateParams.f18352g)));
        }
        a.add(new BasicNameValuePair("format", "json"));
        FormBodyPart formBodyPart = null;
        if (homeUpdateParams.f18353h != null) {
            File file = new File(homeUpdateParams.f18353h.e());
            formBodyPart = new FormBodyPart("file", new DataStreamBody(file, homeUpdateParams.f18353h.i(), file.getName()));
        } else {
            a.add(new BasicNameValuePair("remove_photo", Boolean.toString(homeUpdateParams.f18354i)));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "home_update";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = String.valueOf(homeUpdateParams.f18346a);
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        if (formBodyPart != null) {
            apiRequestBuilder.l = Lists.a(new FormBodyPart[]{formBodyPart});
        }
        return apiRequestBuilder.C();
    }

    public final Object m22310a(Object obj, ApiResponse apiResponse) {
        apiResponse.c();
        return Boolean.valueOf(true);
    }
}

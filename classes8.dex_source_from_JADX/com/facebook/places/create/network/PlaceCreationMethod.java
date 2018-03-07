package com.facebook.places.create.network;

import android.location.Location;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBody;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: cardHolderName */
public class PlaceCreationMethod implements ApiMethod<PlaceCreationParams, Long> {
    private static final Class<?> f18370a = PlaceCreationMethod.class;

    public final ApiRequest m22324a(Object obj) {
        PlaceCreationParams placeCreationParams = (PlaceCreationParams) obj;
        List a = Lists.a();
        Preconditions.checkNotNull(placeCreationParams.f18371a);
        Preconditions.checkNotNull(placeCreationParams.m22329a());
        a.add(new BasicNameValuePair("name", placeCreationParams.f18371a));
        a.add(new BasicNameValuePair("coords", m22322a(placeCreationParams.m22329a())));
        if (placeCreationParams.f18372b.isPresent()) {
            a.add(new BasicNameValuePair("pin_source", ((PlacePinAppId) placeCreationParams.f18372b.get()).name()));
        }
        FormBodyPart formBodyPart = null;
        if (placeCreationParams.f18384n != null) {
            File file = new File(placeCreationParams.f18384n.e());
            formBodyPart = new FormBodyPart("file", new DataStreamBody(file, placeCreationParams.f18384n.i(), file.getName()));
        }
        if (placeCreationParams.f18381k) {
            a.add(new BasicNameValuePair("type", "RESIDENCE"));
            a.add(new BasicNameValuePair("privacy", placeCreationParams.f18382l.c()));
        }
        if (placeCreationParams.f18373c != null) {
            a.add(new BasicNameValuePair("topics", m22323a(placeCreationParams.f18373c)));
        }
        if (placeCreationParams.f18383m != null) {
            a.add(new BasicNameValuePair("override_ids", m22323a(placeCreationParams.f18383m)));
        }
        a.add(new BasicNameValuePair("format", "json"));
        if (!((placeCreationParams.f18376f == null || placeCreationParams.f18376f.trim().isEmpty()) && (placeCreationParams.f18374d == null || placeCreationParams.f18374d.trim().isEmpty()))) {
            String str = placeCreationParams.f18376f;
            String str2 = placeCreationParams.f18374d;
            String str3 = placeCreationParams.f18377g;
            ObjectNode c = JsonNodeFactory.a.c();
            c.a("city", str2);
            c.a("street", str);
            c.a("postal_code", str3);
            a.add(new BasicNameValuePair("address", c.toString()));
        }
        if (placeCreationParams.f18378h != null) {
            a.add(new BasicNameValuePair("neighborhood_name", placeCreationParams.f18378h));
        }
        if (placeCreationParams.f18375e != 0) {
            a.add(new BasicNameValuePair("city_id", String.valueOf(placeCreationParams.f18375e)));
        }
        if (placeCreationParams.f18379i != null) {
            a.add(new BasicNameValuePair("phone", placeCreationParams.f18379i));
        }
        if (placeCreationParams.f18380j != null) {
            a.add(new BasicNameValuePair("website", placeCreationParams.f18380j));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "places-create";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "method/places.create";
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        if (formBodyPart != null) {
            apiRequestBuilder.l = Lists.a(new FormBodyPart[]{formBodyPart});
        }
        return apiRequestBuilder.C();
    }

    public final Object m22325a(Object obj, ApiResponse apiResponse) {
        return Long.valueOf(apiResponse.c().D());
    }

    private static String m22322a(Location location) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("latitude", location.getLatitude());
            jSONObject.put("longitude", location.getLongitude());
            if (location.hasAccuracy()) {
                jSONObject.put("accuracy", (double) location.getAccuracy());
            }
            if (location.hasAltitude()) {
                jSONObject.put("altitude", location.getAltitude());
            }
            if (location.hasBearing()) {
                jSONObject.put("heading", (double) location.getBearing());
            }
            if (location.hasSpeed()) {
                jSONObject.put("speed", (double) location.getSpeed());
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    private static String m22323a(List<Long> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (Long longValue : list) {
            arrayNode.b(longValue.longValue());
        }
        return arrayNode.toString();
    }
}

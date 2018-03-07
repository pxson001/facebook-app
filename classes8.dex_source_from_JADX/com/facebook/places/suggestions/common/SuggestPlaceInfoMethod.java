package com.facebook.places.suggestions.common;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.crowdsourcing.helper.HoursData.HoursForSingleDay;
import com.facebook.crowdsourcing.helper.HoursData.HoursInterval;
import com.facebook.crowdsourcing.helper.HoursDataHelper;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedHours;
import com.facebook.graphql.enums.GraphQLPlaceHoursType;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: search_typeahead_session_id */
public class SuggestPlaceInfoMethod implements ApiMethod<SuggestPlaceInfoParams, Boolean> {
    public final ApiRequest m3634a(Object obj) {
        ObjectNode objectNode;
        ArrayNode arrayNode;
        ImmutableList immutableList;
        int size;
        int i;
        SuggestPlaceInfoParams suggestPlaceInfoParams = (SuggestPlaceInfoParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "place-suggest-info";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("%s/suggestions", suggestPlaceInfoParams.f3751a);
        newBuilder = newBuilder;
        int i2 = 0;
        List a = Lists.a();
        m3633a(a, "name", suggestPlaceInfoParams.f3752b);
        m3633a(a, "phone", suggestPlaceInfoParams.f3759i);
        m3633a(a, "email", suggestPlaceInfoParams.f3756f);
        m3633a(a, "website", suggestPlaceInfoParams.f3760j);
        if (suggestPlaceInfoParams.f3758h != null) {
            a.add(new BasicNameValuePair("hours", m3632a(suggestPlaceInfoParams.f3758h, suggestPlaceInfoParams.f3757g)));
        }
        if (!(suggestPlaceInfoParams.f3753c == null && suggestPlaceInfoParams.f3754d == null && suggestPlaceInfoParams.f3755e == null && suggestPlaceInfoParams.f3762l == null)) {
            objectNode = new ObjectNode(JsonNodeFactory.a);
            if (suggestPlaceInfoParams.f3753c != null) {
                objectNode.a("address", suggestPlaceInfoParams.f3753c);
            }
            if (suggestPlaceInfoParams.f3754d != null) {
                objectNode.a("city", suggestPlaceInfoParams.f3754d);
            }
            if (suggestPlaceInfoParams.f3755e != null) {
                objectNode.a("city_id", suggestPlaceInfoParams.f3755e);
            }
            if (suggestPlaceInfoParams.f3762l != null) {
                objectNode.a("zip_code", suggestPlaceInfoParams.f3762l);
            }
            a.add(new BasicNameValuePair("location", objectNode.toString()));
        }
        if (suggestPlaceInfoParams.f3763m != null) {
            objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("latitude", suggestPlaceInfoParams.f3763m.a());
            objectNode.a("longitude", suggestPlaceInfoParams.f3763m.b());
            a.add(new BasicNameValuePair("coordinates", objectNode.toString()));
        }
        if (suggestPlaceInfoParams.f3764n != null) {
            arrayNode = new ArrayNode(JsonNodeFactory.a);
            immutableList = suggestPlaceInfoParams.f3764n;
            size = immutableList.size();
            for (i = 0; i < size; i++) {
                arrayNode.b(((Long) immutableList.get(i)).longValue());
            }
            a.add(new BasicNameValuePair("categories", arrayNode.toString()));
        }
        if (suggestPlaceInfoParams.f3761k != null) {
            arrayNode = new ArrayNode(JsonNodeFactory.a);
            immutableList = suggestPlaceInfoParams.f3761k;
            size = immutableList.size();
            for (i = 0; i < size; i++) {
                arrayNode.h((String) immutableList.get(i));
            }
            a.add(new BasicNameValuePair("websites", arrayNode.toString()));
        }
        if (suggestPlaceInfoParams.f3765o != null) {
            arrayNode = new ArrayNode(JsonNodeFactory.a);
            immutableList = suggestPlaceInfoParams.f3765o;
            size = immutableList.size();
            for (i = 0; i < size; i++) {
                arrayNode.b(((Long) immutableList.get(i)).longValue());
            }
            a.add(new BasicNameValuePair("duplicates", arrayNode.toString()));
        }
        m3633a(a, "originalName", suggestPlaceInfoParams.f3766p);
        m3633a(a, "originalPhone", suggestPlaceInfoParams.f3773w);
        m3633a(a, "originalEmail", suggestPlaceInfoParams.f3770t);
        m3633a(a, "originalWebsite", suggestPlaceInfoParams.f3774x);
        if (suggestPlaceInfoParams.f3772v != null) {
            a.add(new BasicNameValuePair("originalHours", m3632a(suggestPlaceInfoParams.f3772v, suggestPlaceInfoParams.f3771u)));
        }
        if (!(suggestPlaceInfoParams.f3767q == null && suggestPlaceInfoParams.f3768r == null && suggestPlaceInfoParams.f3769s == null && suggestPlaceInfoParams.f3776z == null)) {
            objectNode = new ObjectNode(JsonNodeFactory.a);
            if (suggestPlaceInfoParams.f3767q != null) {
                objectNode.a("address", suggestPlaceInfoParams.f3767q);
            }
            if (suggestPlaceInfoParams.f3768r != null) {
                objectNode.a("city", suggestPlaceInfoParams.f3768r);
            }
            if (suggestPlaceInfoParams.f3769s != null) {
                objectNode.a("city_id", suggestPlaceInfoParams.f3769s);
            }
            if (suggestPlaceInfoParams.f3776z != null) {
                objectNode.a("zip_code", suggestPlaceInfoParams.f3776z);
            }
            a.add(new BasicNameValuePair("originalLocation", objectNode.toString()));
        }
        if (suggestPlaceInfoParams.f3747B != null) {
            objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("latitude", suggestPlaceInfoParams.f3747B.a());
            objectNode.a("longitude", suggestPlaceInfoParams.f3747B.b());
            a.add(new BasicNameValuePair("originalCoordinates", objectNode.toString()));
        }
        if (suggestPlaceInfoParams.f3748C != null) {
            arrayNode = new ArrayNode(JsonNodeFactory.a);
            immutableList = suggestPlaceInfoParams.f3748C;
            size = immutableList.size();
            for (i = 0; i < size; i++) {
                arrayNode.b(((Long) immutableList.get(i)).longValue());
            }
            a.add(new BasicNameValuePair("originalCategories", arrayNode.toString()));
        }
        if (suggestPlaceInfoParams.f3775y != null) {
            ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.a);
            ImmutableList immutableList2 = suggestPlaceInfoParams.f3775y;
            int size2 = immutableList2.size();
            while (i2 < size2) {
                arrayNode2.h((String) immutableList2.get(i2));
                i2++;
            }
            a.add(new BasicNameValuePair("originalWebsites", arrayNode2.toString()));
        }
        if (suggestPlaceInfoParams.f3746A != null) {
            a.add(new BasicNameValuePair("source", suggestPlaceInfoParams.f3746A.toString()));
        }
        if (suggestPlaceInfoParams.f3749D != null) {
            a.add(new BasicNameValuePair("entry_point", suggestPlaceInfoParams.f3749D.getFullName()));
        }
        if (suggestPlaceInfoParams.f3750E != null) {
            a.add(new BasicNameValuePair("end_point", suggestPlaceInfoParams.f3750E.getFullName()));
        }
        newBuilder.g = a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m3635a(Object obj, ApiResponse apiResponse) {
        apiResponse.c();
        return Boolean.valueOf(true);
    }

    public static void m3633a(List<NameValuePair> list, String str, String str2) {
        if (str2 != null) {
            list.add(new BasicNameValuePair(str, str2));
        }
    }

    public static String m3632a(GraphQLPlaceHoursType graphQLPlaceHoursType, @Nullable CrowdsourcedHours crowdsourcedHours) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("hours_type", graphQLPlaceHoursType.name());
        if (GraphQLPlaceHoursType.OPEN_FOR_SELECTED.equals(graphQLPlaceHoursType) && crowdsourcedHours != null) {
            objectNode.c("mon", m3631a(HoursDataHelper.a(2, crowdsourcedHours)));
            objectNode.c("tue", m3631a(HoursDataHelper.a(3, crowdsourcedHours)));
            objectNode.c("wed", m3631a(HoursDataHelper.a(4, crowdsourcedHours)));
            objectNode.c("thu", m3631a(HoursDataHelper.a(5, crowdsourcedHours)));
            objectNode.c("fri", m3631a(HoursDataHelper.a(6, crowdsourcedHours)));
            objectNode.c("sat", m3631a(HoursDataHelper.a(7, crowdsourcedHours)));
            objectNode.c("sun", m3631a(HoursDataHelper.a(1, crowdsourcedHours)));
        }
        return objectNode.toString();
    }

    private static ArrayNode m3631a(HoursForSingleDay hoursForSingleDay) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        ImmutableList immutableList = hoursForSingleDay.a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            HoursInterval hoursInterval = (HoursInterval) immutableList.get(i);
            ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.a);
            if (hoursInterval.a != 0 || hoursInterval.b != 0) {
                arrayNode2.b(hoursInterval.a);
                arrayNode2.b(hoursInterval.b);
                arrayNode.a(arrayNode2);
            }
        }
        return arrayNode;
    }
}

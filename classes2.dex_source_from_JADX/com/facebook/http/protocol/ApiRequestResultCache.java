package com.facebook.http.protocol;

import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.http.NameValuePair;

/* compiled from: request_reason */
public class ApiRequestResultCache {
    private final HashMap<String, Object> f7278a = Maps.m838c();
    private final HashSet<String> f7279b = Sets.m1324b(Arrays.asList(new String[]{"UserTimelineQuery", "InitialUserTimelineQueryPlutonium", "TimelineFirstUnitsUser", "TimelineFirstUnitsUserPlutonium"}));

    public static ApiRequestResultCache m11773a(InjectorLike injectorLike) {
        return new ApiRequestResultCache();
    }

    private static String m11774c(ApiRequest apiRequest) {
        StringBuilder stringBuilder = new StringBuilder(apiRequest.f7498c);
        ImmutableList h = apiRequest.m12107h();
        int size = h.size();
        for (int i = 0; i < size; i++) {
            NameValuePair nameValuePair = (NameValuePair) h.get(i);
            stringBuilder.append(nameValuePair.getName()).append(':').append(nameValuePair.getValue());
        }
        return stringBuilder.toString();
    }

    public final boolean m11776a(ApiRequest apiRequest) {
        return this.f7279b.contains(apiRequest.f7496a);
    }

    public final void m11775a(ApiRequest apiRequest, Object obj) {
        this.f7278a.put(m11774c(apiRequest), obj);
    }

    public final Object m11777b(ApiRequest apiRequest) {
        return this.f7278a.get(m11774c(apiRequest));
    }
}

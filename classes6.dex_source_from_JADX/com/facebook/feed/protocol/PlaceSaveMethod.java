package com.facebook.feed.protocol;

import com.facebook.api.feedcache.memory.ToggleSaveParams;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: method/graphsearchtypeahead.get */
public class PlaceSaveMethod implements ApiMethod<ToggleSaveParams, Boolean> {
    public final ApiRequest m16398a(Object obj) {
        ToggleSaveParams toggleSaveParams = (ToggleSaveParams) obj;
        List a = Lists.a();
        Preconditions.checkNotNull(toggleSaveParams.b);
        Preconditions.checkNotNull(toggleSaveParams.f);
        Preconditions.checkNotNull(toggleSaveParams.g);
        a.add(new BasicNameValuePair("action", "ADD"));
        a.add(new BasicNameValuePair("item_id", toggleSaveParams.b));
        a.add(new BasicNameValuePair("curation_surface", toggleSaveParams.f.toString()));
        a.add(new BasicNameValuePair("curation_mechanism", toggleSaveParams.g.toString()));
        a.add(new BasicNameValuePair("privacy", "{\"value\":\"SELF\"}"));
        if (toggleSaveParams.c != null) {
            a.add(new BasicNameValuePair("source_story_id", toggleSaveParams.c));
        }
        return new ApiRequest("placeSave", "POST", "/" + toggleSaveParams.d + "/items", a, ApiResponseType.STRING);
    }

    public final Object m16399a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(Boolean.parseBoolean(apiResponse.b()));
    }
}

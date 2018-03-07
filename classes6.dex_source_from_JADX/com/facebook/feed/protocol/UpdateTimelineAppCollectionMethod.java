package com.facebook.feed.protocol;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.story.UpdateTimelineAppCollectionParams;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: messenger_commerce */
public class UpdateTimelineAppCollectionMethod implements ApiMethod<UpdateTimelineAppCollectionParams, Boolean> {
    public final ApiRequest m16494a(Object obj) {
        UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams = (UpdateTimelineAppCollectionParams) obj;
        Builder builder = ImmutableList.builder();
        builder.b(new NameValuePair[]{new BasicNameValuePair("item_id", updateTimelineAppCollectionParams.f5025b), new BasicNameValuePair("action", updateTimelineAppCollectionParams.f5026c.toString()), new BasicNameValuePair("curation_surface", updateTimelineAppCollectionParams.f5027d.toString()), new BasicNameValuePair("curation_mechanism", updateTimelineAppCollectionParams.f5028e.toString()), new BasicNameValuePair("format", "json")});
        if (updateTimelineAppCollectionParams.f5030g != null) {
            builder.c(new BasicNameValuePair("privacy", updateTimelineAppCollectionParams.f5030g));
        }
        if (updateTimelineAppCollectionParams.f5034k != null) {
            builder.c(new BasicNameValuePair("tracking", updateTimelineAppCollectionParams.f5034k));
        }
        if (updateTimelineAppCollectionParams.f5035l != null) {
            builder.c(new BasicNameValuePair("source_story_id", updateTimelineAppCollectionParams.f5035l));
        }
        return new ApiRequest("updateTimelineAppCollection", "POST", updateTimelineAppCollectionParams.f5024a + "/items", builder.b(), ApiResponseType.JSON);
    }

    public final Object m16495a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c()));
    }
}

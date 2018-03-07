package com.facebook.feedplugins.storygallerysurvey.service;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: birthday_quick_cam */
public class StoryGallerySurveyActionsMethod implements ApiMethod<StoryGallerySurveyActionsParams, Boolean> {
    public final ApiRequest m10071a(Object obj) {
        StoryGallerySurveyActionsParams storyGallerySurveyActionsParams = (StoryGallerySurveyActionsParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("action_type", storyGallerySurveyActionsParams.f9531a));
        return new ApiRequest("storyGalelrySurveyActions", "POST", "/me/story_gallery_survey_actions/", RequestPriority.NON_INTERACTIVE, a, ApiResponseType.JSON);
    }

    public final Object m10072a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c().f("success")));
    }
}

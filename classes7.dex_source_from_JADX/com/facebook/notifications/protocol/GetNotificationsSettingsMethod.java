package com.facebook.notifications.protocol;

import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.notifications.model.FacebookNotificationSetting;
import com.facebook.notifications.server.GetNotificationsSettingsParams;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: navigate_page_swipe */
public class GetNotificationsSettingsMethod implements ApiMethod<GetNotificationsSettingsParams, GetNotificationsSettingsResult> {
    public final ApiRequest m10373a(Object obj) {
        GetNotificationsSettingsParams getNotificationsSettingsParams = (GetNotificationsSettingsParams) obj;
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        fqlMultiQueryHelper.a("notificationssettings", StringFormatUtil.a("SELECT setting_id, setting_value FROM notification_setting WHERE user_id=%s AND type='%s'", new Object[]{getNotificationsSettingsParams.f8688a, getNotificationsSettingsParams.f8689b}));
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("queries", fqlMultiQueryHelper.a().toString()));
        return new ApiRequest("getNotificationsSettings", "GET", "method/fql.multiquery", a, ApiResponseType.JSON);
    }

    public final Object m10374a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode a = new FqlResultHelper(apiResponse.c()).a("notificationssettings");
        Builder builder = ImmutableList.builder();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            builder.c(FacebookNotificationSetting.m9976a(FBJsonFactory.g.b(((JsonNode) it.next()).toString())));
        }
        return new GetNotificationsSettingsResult(DataFreshnessResult.FROM_SERVER, builder.b(), System.currentTimeMillis());
    }
}

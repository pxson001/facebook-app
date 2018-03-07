package com.facebook.notifications.protocol;

import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.notifications.server.NotificationsChangeSettingsParams;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: must set dismiss direction */
public class NotificationsChangeSettingsMethod implements ApiMethod<NotificationsChangeSettingsParams, Boolean> {
    private static final Class<?> f8666a = NotificationsChangeSettingsMethod.class;

    public final ApiRequest m10645a(Object obj) {
        NotificationsChangeSettingsParams notificationsChangeSettingsParams = (NotificationsChangeSettingsParams) obj;
        Preconditions.checkNotNull(notificationsChangeSettingsParams);
        List a = Lists.a();
        if (!StringUtil.a(notificationsChangeSettingsParams.f8695a)) {
            a.add(new BasicNameValuePair("alert_types_on", notificationsChangeSettingsParams.f8695a));
        }
        if (!StringUtil.a(notificationsChangeSettingsParams.f8696b)) {
            a.add(new BasicNameValuePair("alert_types_off", notificationsChangeSettingsParams.f8696b));
        }
        if (!StringUtil.a(notificationsChangeSettingsParams.f8697c)) {
            a.add(new BasicNameValuePair("type", notificationsChangeSettingsParams.f8697c));
        }
        if (!StringUtil.a(notificationsChangeSettingsParams.f8698d)) {
            a.add(new BasicNameValuePair("setting_id", notificationsChangeSettingsParams.f8698d));
        }
        if (!StringUtil.a(notificationsChangeSettingsParams.f8699e)) {
            a.add(new BasicNameValuePair("setting_value", notificationsChangeSettingsParams.f8699e));
        }
        return new ApiRequest("graphNotificationsSettings", "POST", "me/notificationssettings", a, ApiResponseType.JSON);
    }

    public final Object m10646a(@Nullable Object obj, ApiResponse apiResponse) {
        NotificationsChangeSettingsParams notificationsChangeSettingsParams = (NotificationsChangeSettingsParams) obj;
        Preconditions.checkNotNull(apiResponse);
        apiResponse.i();
        boolean F = apiResponse.c().F();
        if (F && notificationsChangeSettingsParams != null) {
            return Boolean.valueOf(F);
        }
        BLog.b(f8666a, "Failed to change notification settings");
        return Boolean.valueOf(F);
    }
}

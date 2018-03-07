package com.facebook.events.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.events.model.EventType;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: aura */
public class CreateEventMethod implements ApiMethod<CreateEventParams, Long> {
    public final ApiRequest m19249a(Object obj) {
        CreateEventParams createEventParams = (CreateEventParams) obj;
        List a = createEventParams.mo855a();
        if (StringUtil.a(createEventParams.f19034b)) {
            throw new IllegalArgumentException("Missing required event name");
        }
        a.add(new BasicNameValuePair("name", createEventParams.f19034b));
        if (createEventParams.f19037e != null || createEventParams.f19041i == EventType.QUICK_INVITE) {
            Object obj2;
            if (createEventParams.f19037e != null) {
                a.add(new BasicNameValuePair("start_time", EventsApiConstants.m19289a(createEventParams.f19037e, createEventParams.f19040h, createEventParams.f19038f)));
            }
            if (!StringUtil.a(createEventParams.f19035c)) {
                a.add(new BasicNameValuePair("description", createEventParams.f19035c));
            }
            if (createEventParams.f19036d > 0) {
                a.add(new BasicNameValuePair("location_id", Long.toString(createEventParams.f19036d)));
            } else if (!StringUtil.a(createEventParams.f19044l)) {
                a.add(new BasicNameValuePair("location", createEventParams.f19044l));
            }
            if (createEventParams.f19039g != null) {
                a.add(new BasicNameValuePair("end_time", EventsApiConstants.m19288a(createEventParams.f19039g, createEventParams.f19040h)));
            }
            if (createEventParams.f19042j != null) {
                a.add(new BasicNameValuePair("privacy_type", EventsApiConstants.m19287a(createEventParams.f19042j)));
                a.add(new BasicNameValuePair("can_guests_invite_friends", Boolean.toString(createEventParams.f19043k)));
            }
            if (createEventParams.f19041i != null) {
                a.add(new BasicNameValuePair("event_type", createEventParams.f19041i.getContentValue()));
            }
            if (createEventParams.f19045m) {
                a.add(new BasicNameValuePair("admin_posts_only", "true"));
            }
            String str = "graphEventCreate";
            String str2 = "POST";
            String str3 = "%s/events";
            if (createEventParams.f19033a == null || createEventParams.f19033a.longValue() <= 0) {
                obj2 = "me";
            } else {
                obj2 = Long.toString(createEventParams.f19033a.longValue());
            }
            return new ApiRequest(str, str2, StringFormatUtil.formatStrLocaleSafe(str3, obj2), a, ApiResponseType.JSON);
        }
        throw new IllegalArgumentException("Missing required start time");
    }

    public final Object m19250a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Long.valueOf(apiResponse.c().b("id").D());
    }
}

package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: custom_voicemail_read */
public class MarkFolderSeenMethod implements ApiMethod<Void, Void> {
    public final ApiRequest m16963a(Object obj) {
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("viewed", "1"));
        return new ApiRequest("markFolderSeen", "POST", "me/threads/inbox", a, ApiResponseType.STRING);
    }

    public final Object m16964a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

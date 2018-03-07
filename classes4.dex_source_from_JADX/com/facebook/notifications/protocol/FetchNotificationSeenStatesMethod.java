package com.facebook.notifications.protocol;

import com.facebook.common.time.MonotonicClock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.notifications.model.NotificationSeenStates;
import com.facebook.notifications.server.FetchNotificationSeenStatesParams;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: language */
public class FetchNotificationSeenStatesMethod implements ApiMethod<FetchNotificationSeenStatesParams, FetchNotificationSeenStatesResult> {
    private final MonotonicClock f9660a;

    public final ApiRequest m10093a(Object obj) {
        FetchNotificationSeenStatesParams fetchNotificationSeenStatesParams = (FetchNotificationSeenStatesParams) obj;
        List a = Lists.a();
        ImmutableList immutableList = fetchNotificationSeenStatesParams.f7984a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            a.add(new BasicNameValuePair("notif_ids[]", (String) immutableList.get(i)));
        }
        return new ApiRequest(BootstrapRequestName.NOTIFICATION_GET_SEEN_STATES.requestNameString, TigonRequest.GET, "me/notification_seen_states", a, ApiResponseType.JSONPARSER);
    }

    @Inject
    public FetchNotificationSeenStatesMethod(MonotonicClock monotonicClock) {
        this.f9660a = monotonicClock;
    }

    public final Object m10094a(Object obj, ApiResponse apiResponse) {
        return new FetchNotificationSeenStatesResult(DataFreshnessResult.FROM_SERVER, (NotificationSeenStates) apiResponse.d().a(NotificationSeenStates.class), this.f9660a.now());
    }
}

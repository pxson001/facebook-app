package com.facebook.notifications.protocol;

import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.notifications.server.NotificationsChangeSeenStateParams;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: native_post/{%s}?story_cache_id={%s} */
public class GraphNotificationsChangeSeenStateMethod implements ApiMethod<NotificationsChangeSeenStateParams, GraphNotificationsChangeSeenStateMethodResult> {

    /* compiled from: native_post/{%s}?story_cache_id={%s} */
    /* synthetic */ class C06971 {
        static final /* synthetic */ int[] f8556a = new int[GraphQLStorySeenState.values().length];

        static {
            try {
                f8556a[GraphQLStorySeenState.SEEN_AND_READ.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8556a[GraphQLStorySeenState.SEEN_BUT_UNREAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: native_post/{%s}?story_cache_id={%s} */
    public class GraphNotificationsChangeSeenStateMethodResult {
        public final Boolean f8557a;
        public final NotificationsChangeSeenStateParams f8558b;

        public GraphNotificationsChangeSeenStateMethodResult(Boolean bool, NotificationsChangeSeenStateParams notificationsChangeSeenStateParams) {
            this.f8557a = bool;
            this.f8558b = notificationsChangeSeenStateParams;
        }
    }

    public final ApiRequest m10376a(Object obj) {
        NotificationsChangeSeenStateParams notificationsChangeSeenStateParams = (NotificationsChangeSeenStateParams) obj;
        Preconditions.checkNotNull(notificationsChangeSeenStateParams);
        List a = Lists.a();
        a.add(new BasicNameValuePair("notif_ids", Joiner.on(",").join(notificationsChangeSeenStateParams.f8693a)));
        a.add(new BasicNameValuePair(m10375a(notificationsChangeSeenStateParams.f8694b), "true"));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("graphNotificationsUpdateSeenState", "POST", "me/notifications", RequestPriority.NON_INTERACTIVE, a, ApiResponseType.JSON);
    }

    public final Object m10377a(Object obj, ApiResponse apiResponse) {
        NotificationsChangeSeenStateParams notificationsChangeSeenStateParams = (NotificationsChangeSeenStateParams) obj;
        Preconditions.checkNotNull(apiResponse);
        Preconditions.checkNotNull(notificationsChangeSeenStateParams);
        apiResponse.i();
        return new GraphNotificationsChangeSeenStateMethodResult(Boolean.valueOf(apiResponse.c().F()), notificationsChangeSeenStateParams);
    }

    private static String m10375a(GraphQLStorySeenState graphQLStorySeenState) {
        switch (C06971.f8556a[graphQLStorySeenState.ordinal()]) {
            case 1:
                return "read";
            case 2:
                return "seen";
            default:
                throw new NullPointerException();
        }
    }
}

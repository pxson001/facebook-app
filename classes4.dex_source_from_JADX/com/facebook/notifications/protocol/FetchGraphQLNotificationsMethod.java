package com.facebook.notifications.protocol;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.notifications.model.NotificationStories;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.util.NotificationsQueryBuilder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: importance_type */
public class FetchGraphQLNotificationsMethod extends AbstractPersistedGraphQlApiMethod<FetchGraphQLNotificationsParams, FetchGraphQLNotificationsResult> {
    private final NotificationsQueryBuilder f10459c;

    public final Object m10996a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return new FetchGraphQLNotificationsResult((NotificationStories) ((ObjectMapper) jsonParser.a()).a(jsonParser, NotificationStories.class), ((FetchGraphQLNotificationsParams) obj).m8042f(), DataFreshnessResult.FROM_SERVER, System.currentTimeMillis());
    }

    public final GraphQlQueryString m10998f(@Nullable Object obj) {
        return this.f10459c.m8052a((FetchGraphQLNotificationsParams) obj);
    }

    public final RequestPriority m10999j(Object obj) {
        SyncSource fromString = SyncSource.fromString(((FetchGraphQLNotificationsParams) obj).f7680g);
        if (SyncSource.PULL_TO_REFRESH.equals(fromString)) {
            return RequestPriority.INTERACTIVE;
        }
        if (SyncSource.BACKGROUND.equals(fromString)) {
            return RequestPriority.CAN_WAIT;
        }
        return RequestPriority.NON_INTERACTIVE;
    }

    @Inject
    public FetchGraphQLNotificationsMethod(NotificationsQueryBuilder notificationsQueryBuilder, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f10459c = notificationsQueryBuilder;
    }

    public final int m10997b(Object obj, ApiResponse apiResponse) {
        return 2;
    }
}

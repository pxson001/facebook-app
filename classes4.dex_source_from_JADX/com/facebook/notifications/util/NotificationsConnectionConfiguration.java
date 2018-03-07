package com.facebook.notifications.util;

import com.facebook.controller.connectioncontroller.common.ConnectionFetchOperation;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.controller.connectioncontroller.common.SimpleConnectionConfiguration;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParams;
import com.facebook.notifications.protocol.FetchNotificationsGraphQL.FirstNotificationsQueryString;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$FirstNotificationsQueryModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
import javax.inject.Inject;

/* compiled from: min_excessive_delay */
public class NotificationsConnectionConfiguration implements SimpleConnectionConfiguration<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel, Void, FetchNotificationsGraphQLModels$FirstNotificationsQueryModel> {
    private FetchGraphQLNotificationsParams f7693a;
    private final NotificationsQueryBuilder f7694b;

    @Inject
    public NotificationsConnectionConfiguration(@Assisted FetchGraphQLNotificationsParams fetchGraphQLNotificationsParams, NotificationsQueryBuilder notificationsQueryBuilder) {
        this.f7693a = fetchGraphQLNotificationsParams;
        this.f7694b = notificationsQueryBuilder;
    }

    public final TypedGraphQlQueryString mo647a(ConnectionFetchOperation connectionFetchOperation, Object obj) {
        FirstNotificationsQueryString b = this.f7694b.m8053b(this.f7693a);
        if (connectionFetchOperation.c != null) {
            b.a("before_notification_stories", connectionFetchOperation.c);
        }
        if (connectionFetchOperation.d != null) {
            b.a("after_notification_stories", connectionFetchOperation.d);
        }
        b.a("first_notification_stories", Integer.valueOf(connectionFetchOperation.e));
        return b;
    }

    public final ConnectionPage<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel> mo646a(GraphQLResult<FetchNotificationsGraphQLModels$FirstNotificationsQueryModel> graphQLResult) {
        if (((FetchNotificationsGraphQLModels$FirstNotificationsQueryModel) graphQLResult.e).m11006a() == null || ((FetchNotificationsGraphQLModels$FirstNotificationsQueryModel) graphQLResult.e).m11006a().a() == null || ((FetchNotificationsGraphQLModels$FirstNotificationsQueryModel) graphQLResult.e).m11006a().a().size() == 0) {
            return ConnectionPage.a;
        }
        int size = ((FetchNotificationsGraphQLModels$FirstNotificationsQueryModel) graphQLResult.e).m11006a().a().size();
        return new ConnectionPage(((FetchNotificationsGraphQLModels$FirstNotificationsQueryModel) graphQLResult.e).m11006a().a(), ((FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ((FetchNotificationsGraphQLModels$FirstNotificationsQueryModel) graphQLResult.e).m11006a().a().get(0)).mo813a(), ((FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) ((FetchNotificationsGraphQLModels$FirstNotificationsQueryModel) graphQLResult.e).m11006a().a().get(size - 1)).mo813a(), true, ((FetchNotificationsGraphQLModels$FirstNotificationsQueryModel) graphQLResult.e).m11006a().j().a());
    }
}

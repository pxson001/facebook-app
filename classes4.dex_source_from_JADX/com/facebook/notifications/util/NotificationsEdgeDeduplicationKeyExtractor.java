package com.facebook.notifications.util;

import com.facebook.common.util.StringUtil;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: metalines */
public class NotificationsEdgeDeduplicationKeyExtractor implements Function<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel, String> {
    @Nullable
    public Object apply(@Nullable Object obj) {
        FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) obj;
        if (fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel == null || fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.mo822k() == null || StringUtil.a(fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.mo822k().c())) {
            return null;
        }
        return fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.mo822k().c();
    }
}

package com.facebook.notifications.util;

import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: minutiae_object_picker_fetch_time */
public class NotificationConnectionControllerHelper {
    @Nullable
    public static NotificationsEdgeFieldsModel m10799a(ConnectionState<NotificationsEdgeFieldsModel> connectionState, @Nullable String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        for (int i = 0; i < connectionState.d(); i++) {
            NotificationsEdgeFieldsModel notificationsEdgeFieldsModel = (NotificationsEdgeFieldsModel) connectionState.a(i);
            if (notificationsEdgeFieldsModel.k() != null && notificationsEdgeFieldsModel.k().c().equals(str)) {
                return notificationsEdgeFieldsModel;
            }
        }
        return null;
    }
}
